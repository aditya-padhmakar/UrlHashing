package com.example.urlhashing.controller;

import com.example.urlhashing.service.UrlHashingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.NoSuchAlgorithmException;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@Slf4j
public class HashingController {
    @Autowired
    UrlHashingService urlHashingService;
    private final org.slf4j.Logger Logger = getLogger(getClass());

    @GetMapping("/hash")
    public String hashUrl(@RequestParam("url") String url) throws NoSuchAlgorithmException {
        return urlHashingService.generateHashedUrl(url);
    }

    @GetMapping("/{hashedUrl}")
    public RedirectView redirectToUrl(@PathVariable String hashedUrl) {
        // Retrieve the original URL associated with the hashed URL from the database
        String originalUrl = urlHashingService.getOriginalUrl(hashedUrl);
        // Perform click tracking or any other desired operations
        // ...
        Logger.info("redirect:" + originalUrl);
        return new RedirectView(originalUrl);
    }

    @GetMapping("/original")
    public String getOrginalUrl(@RequestParam("hashedUrl") String hashedUrl){
        return urlHashingService.getOriginalUrl(hashedUrl);
    }

}
