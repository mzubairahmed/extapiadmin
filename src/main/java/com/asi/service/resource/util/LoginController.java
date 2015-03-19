package com.asi.service.resource.util;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import com.asi.admin.service.impl.LoginCopyServiceImpl;
import com.asi.admin.service.model.login.Credential;
import com.asi.service.login.client.vo.AccessData;

@Controller
@RequestMapping("")
public class LoginController {
    
    private static final Logger _LOGGER = Logger.getLogger(LoginController.class.getName());
    
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
        
        try {
            sourceUser = loginService.loginUserSourceLocation(credentials);
            _LOGGER.info("User logged in successfully on source");
            destinationUser = loginService.loginUserDestinationLocation(credentials);
            _LOGGER.info("User logged in successfully on sandbox");
            
            mv.addObject("SupplierNumber", credentials.getAsi());
            mv.addObject("STAGE_USER", sourceUser);
            mv.addObject("SANDBOX_USER", destinationUser);
            mv.addObject("Email", email);

            mv.setViewName("/welcome");
        } catch (RestClientException e) {
            e.printStackTrace();
            mv.addObject("authorization_error", "true");
            mv.setViewName("/login");
        }

        return mv;
    }

}
