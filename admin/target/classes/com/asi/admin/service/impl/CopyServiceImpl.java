package com.asi.admin.service.impl;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.asi.admin.service.model.Product;
import com.asi.service.resource.response.ExternalAPIResponse;

public class CopyServiceImpl {
    
    private static final Logger _LOGGER = Logger.getLogger(CopyServiceImpl.class.getName());
    
    @Autowired
    MigrateProductServiceImpl   migrationService;
    RestTemplate                restTemplate;
    
    @Autowired
    private MailSender mailSender;
    
    private String sourceEndpoint;
    private String destinationEndpoint;
    
    // mail sender properties
    private String from;
    private String replyTo;
    
    public void sendStartProcessEMail(String to, String asiNumber) {
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(getFrom());
        message.setReplyTo(getReplyTo());
        message.setSubject("Product Updates - Copy Process Updates");
        message.setText("Dear User,\n\nYou have started the copy process for company: asi/" + asiNumber + " and it is in progress.\nWill send you the complete status after the process has been complete.\nThank you for your patience.");
        
        try {
            mailSender.send(message);
        } catch (MailException e) {
            _LOGGER.error(e);
        }
    }
    
    public void sendInProgressEmail(String to, String asiNumber) {
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(getFrom());
        message.setReplyTo(getReplyTo());
        message.setSubject("Product Updates - Copy Process Updates");
        message.setText("Dear User,\n\nCompany: asi/" + asiNumber + " is already in-progress.\nThank you for your patience.");

        try {
            mailSender.send(message);
        } catch (MailException e) {
            _LOGGER.error(e);
        }

    }

    
//    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
//    String htmlMsg = "<h3>Hello World!</h3>";
//    mimeMessage.setContent(htmlMsg, "text/html");
//    helper.setTo("someone@abc.com");
//    helper.setSubject("This is the test message for testing gmail smtp server using spring mail");
//    helper.setFrom("abc@gmail.com");
//    mailSender.send(mimeMessage);
    
    public void sendStatusReportEmail(String to, String asiNumber, String htmlMessage) {
//        SimpleMailMessage message = new SimpleMailMessage();
        
        JavaMailSenderImpl mailSenderImpl = (JavaMailSenderImpl) mailSender;
        MimeMessage message = mailSenderImpl.createMimeMessage();
        try {
            message.setContent(prepareReportMessage(asiNumber, htmlMessage), "text/html");
            
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, false, "UTF-8");
            messageHelper.setTo(to);
            messageHelper.setFrom(getFrom());
            messageHelper.setReplyTo(getReplyTo());
            messageHelper.setSubject("Product Updates - Copy Process Updates");
            
            mailSenderImpl.send(message);
            
        } catch (Exception e) {
            _LOGGER.error(e);
        }
        
    }
    
    private String prepareReportMessage(String asiNumber, String htmlMessage) {
        
        StringBuilder message = new StringBuilder();
        message.append("Dear User,").append("<br><br>").append("Your requested copy process for company: asi/").append(asiNumber).append(" has been finished.").append("<br>").append("Following is the product wise status.<br><br><br>");
        
        message.append("<table border='1px'>").append("<tr>").append("<th width='15%'>").append("XID").append("</th>").append("<th width='5%'>").append("Status").append("</th>").append("<th>").append("Message").append("</th>").append("<tr>");
        message.append(htmlMessage);
        
        return message.toString();
        
    }
    
    public Product getSourceProduct(String authToken, String xid) {

        Product product = null;
        HttpEntity<String> requestEntity = new HttpEntity<String>(getHeaders(authToken));
        ResponseEntity<Product> productResponse = restTemplate.exchange(sourceEndpoint, HttpMethod.GET, requestEntity, Product.class, xid);

        if (productResponse.getStatusCode() == HttpStatus.OK && productResponse.getBody() != null) {
            product = productResponse.getBody();
        }
        return product;
    }

    public ResponseEntity<ExternalAPIResponse> postProductToDestination(String authToken, Product product) throws RestClientException {

        HttpEntity<Product> requestEntity = new HttpEntity<Product>(product, getHeaders(authToken));
        return restTemplate.exchange(destinationEndpoint, HttpMethod.POST, requestEntity, ExternalAPIResponse.class);
    }

    private HttpHeaders getHeaders(String authToken) {

        HttpHeaders header = new HttpHeaders();
        header.add("AuthToken", authToken);
        header.setContentType(MediaType.APPLICATION_JSON);

        return header;
    }

    /**
     * @return the migrationService
     */
    public MigrateProductServiceImpl getMigrationService() {
        return migrationService;
    }

    /**
     * @param migrationService the migrationService to set
     */
    public void setMigrationService(MigrateProductServiceImpl migrationService) {
        this.migrationService = migrationService;
    }

    /**
     * @return the restTemplate
     */
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    /**
     * @param restTemplate the restTemplate to set
     */
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * @return the sourceEndpoint
     */
    public String getSourceEndpoint() {
        return sourceEndpoint;
    }

    /**
     * @param sourceEndpoint the sourceEndpoint to set
     */
    public void setSourceEndpoint(String sourceEndpoint) {
        this.sourceEndpoint = sourceEndpoint;
    }

    /**
     * @return the destinationEndpoint
     */
    public String getDestinationEndpoint() {
        return destinationEndpoint;
    }

    /**
     * @param destinationEndpoint the destinationEndpoint to set
     */
    public void setDestinationEndpoint(String destinationEndpoint) {
        this.destinationEndpoint = destinationEndpoint;
    }


    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }


    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }


    /**
     * @return the replyTo
     */
    public String getReplyTo() {
        return replyTo;
    }


    /**
     * @param replyTo the replyTo to set
     */
    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

}
