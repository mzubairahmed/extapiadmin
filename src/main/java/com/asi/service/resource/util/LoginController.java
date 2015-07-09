package com.asi.service.resource.util;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import com.asi.admin.service.impl.LoginCopyServiceImpl;
import com.asi.admin.service.model.login.Credential;
import com.asi.service.login.client.vo.AccessData;
import com.asi.service.login.sso.vo.SSOBean;

@Controller
@RequestMapping("")
public class LoginController {
    
    private static final Logger _LOGGER = Logger.getLogger(LoginController.class.getName());
    
    public static final String CREDENTIAL_SESSION = "session.credentials";
    
    @Autowired
    private LoginCopyServiceImpl loginService;
    
    
    @RequestMapping("login")
    public ModelAndView onSubmit(HttpServletRequest request,  @ModelAttribute("asinumber") String asiNumber, 
            @ModelAttribute("username") String username, @ModelAttribute("password") String password, @ModelAttribute("email") String email) {
        
        if(_LOGGER.isTraceEnabled()) {
            _LOGGER.trace("User is logging in...");
        }
        
        ModelAndView mv = new ModelAndView();
        
        Credential credentials = new Credential();
        credentials.setAsi(asiNumber);
        credentials.setUsername(username);
        credentials.setPassword(password);
        
        AccessData sourceUser = null;
        AccessData destinationUser = null;
        SSOBean sso = null;
        
        try {
            sourceUser = loginService.loginUserSourceLocation(credentials);
            _LOGGER.info("User logged in successfully on source");
            destinationUser = loginService.loginUserDestinationLocation(credentials);
            _LOGGER.info("User logged in successfully on sandbox");
            
            _LOGGER.info("Calling SSO Service to acquire destination user information...");
            sso = loginService.getSSOBeanFromAuthToken(destinationUser.getAccessToken());
            if(sso != null) {
                sso.setIpAddress(getRemoteAddress(request));
            }
            
            mv.addObject("SupplierNumber", credentials.getAsi());
            mv.addObject("STAGE_USER", sourceUser);
            mv.addObject("SANDBOX_USER", destinationUser);
            mv.addObject("SSOBean", sso);
            mv.addObject("Email", email);
            
            // in case the login is successfull - set the credentials in session
            // in case the authtoken gets expired, the user should re-login and get a new authtoken instead of breaking the whole flow...
            request.getSession().setAttribute(CREDENTIAL_SESSION, credentials);

            mv.setViewName("/welcome");
        } catch (RestClientException e) {
            e.printStackTrace();
            mv.addObject("authorization_error", "true");
            mv.setViewName("/login");
        }

        return mv;
    }
    
    public String getRemoteAddress(HttpServletRequest request) {
        
        _LOGGER.info("remote address..");

        String[] HEADERS_TO_TRY = { 
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR" };
        
        String clientIP = null;
        
        request.getHeaderNames();
        
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            _LOGGER.debug(header + " = " + ip);
            if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
                clientIP = ip;
                break;
            }
        }
        
        if(clientIP == null) {
            clientIP = request.getRemoteAddr();
        }
        
        return clientIP;
    }

}
