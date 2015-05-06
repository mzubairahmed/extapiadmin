package com.asi.service.resource.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asi.admin.service.impl.CopyServiceImpl;
import com.asi.admin.service.impl.MigrateProductServiceImpl;
import com.asi.admin.service.model.search.ProductSearch;
import com.asi.service.product.client.ProductClient;

@Controller
@RequestMapping("utility")
public class CopyController {
    
    public static Map<String, String> inProgress = new HashMap<String, String>();

    @Autowired
    MigrateProductServiceImpl   migrationService;
    
    @Autowired
    CopyServiceImpl copyService;
    
    @Autowired
    @Qualifier("productServiceClient")
    ProductClient productClient;

    Logger _LOGGER = Logger.getLogger(CopyController.class.getName());

    @RequestMapping(value = "count", method = RequestMethod.GET, produces = { "application/json; charset=UTF-8" })
    @ResponseBody
    public int getProductsCount(@RequestParam("companyId") Long companyID, @RequestParam("authToken") String authToken) {

        List<ProductSearch> products = migrationService.getProductsListByCompanyID(companyID, authToken);
        return products.size();
    }
    
    @RequestMapping(value = "copy")
    public ModelAndView copyProducts(@ModelAttribute("companyId") Long companyId, @ModelAttribute("sourceAuthToken") String sourceAuthToken,
            @ModelAttribute("destinationAuthToken") String destinationAuthToken, @ModelAttribute("asiNumber") String asiNumber, @ModelAttribute("email") String email,
            HttpServletResponse response) throws IOException {

        CopyWorker copyWorker = new CopyWorker();
        copyWorker.setAsiNumber(asiNumber);
        copyWorker.setCompanyId(companyId);
        copyWorker.setDestinationAuthToken(destinationAuthToken);
        copyWorker.setSourceAuthToken(sourceAuthToken);
        copyWorker.setEmail(email);
        
        copyWorker.setCopyService(copyService);
        copyWorker.setMigrationService(migrationService);
        copyWorker.setProductClient(productClient);
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