package com.asi.service.resource.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asi.admin.service.impl.CopyServiceImpl;
import com.asi.admin.service.impl.LoginCopyServiceImpl;
import com.asi.admin.service.impl.MigrateProductServiceImpl;
import com.asi.admin.service.model.login.Credential;
import com.asi.service.product.client.ProductClient;

@Controller
@RequestMapping("utility")
public class CopyController {
    
    public static Map<String, String> inProgress = new HashMap<String, String>();

    @Autowired
    MigrateProductServiceImpl   migrationService;
    
    @Autowired
    LoginCopyServiceImpl loginService;
    
    @Autowired
    CopyServiceImpl copyService;
    
    @Autowired
    @Qualifier("productServiceClient")
    ProductClient productClient;

    Logger _LOGGER = Logger.getLogger(CopyController.class.getName());
    
    
    @RequestMapping(value = "validate", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
    @ResponseBody
    public Boolean isEnvironmentValid() throws Exception {
        return copyService.validateEnvironments();
    }

    @RequestMapping(value = "count", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
    @ResponseBody
    public long getProductsCount(@RequestParam("companyId") Long companyID, @RequestParam("authToken") String authToken) {

//        List<ProductSearch> products = migrationService.getProductsListByCompanyID(companyID, authToken);
//        return products.size();
        
        return migrationService.getProductCount(companyID, authToken);
        
    }
    
    @RequestMapping(value = "copy")
    public ModelAndView copyProducts(@ModelAttribute("companyId") Long companyId, @ModelAttribute("sourceAuthToken") String sourceAuthToken,
            @ModelAttribute("destinationAuthToken") String destinationAuthToken, @ModelAttribute("asiNumber") String asiNumber,
            @ModelAttribute("email") String email, @ModelAttribute("deleteAll") String callDeleteProc,
            @ModelAttribute("ssoId") String ssoId, @ModelAttribute("ssoIP") String ipAddress,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        boolean deleteExistingData = !StringUtils.isEmpty(callDeleteProc) && callDeleteProc.equalsIgnoreCase("Yes");

        CopyWorker copyWorker = new CopyWorker();
        copyWorker.setAsiNumber(asiNumber);
        copyWorker.setCompanyId(companyId);
        copyWorker.setDestinationAuthToken(destinationAuthToken);
        copyWorker.setSourceAuthToken(sourceAuthToken);
        copyWorker.setEmail(email);
        copyWorker.setSsoId(ssoId);
        copyWorker.setIpAddress(ipAddress);
        
        Credential credential = (Credential) request.getSession().getAttribute(LoginController.CREDENTIAL_SESSION);
        copyWorker.setCredential(credential);
        
        copyWorker.setCopyService(copyService);
        copyWorker.setMigrationService(migrationService);
        copyWorker.setLoginService(loginService);
        copyWorker.setProductClient(productClient);
        copyWorker.setDeleteExistingData(deleteExistingData);
        copyWorker.setInProgress(inProgress);

        Thread copyThread = new Thread(copyWorker);
        copyThread.setName("--External API Admin--[CopyWorker]--");
        
        copyThread.start();
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("email", email);
        mv.setViewName("/info");
        
        return mv;
    }
    

}
