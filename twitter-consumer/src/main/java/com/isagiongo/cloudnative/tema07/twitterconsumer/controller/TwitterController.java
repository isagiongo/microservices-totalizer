package com.isagiongo.cloudnative.tema07.twitterconsumer.controller;

import com.isagiongo.cloudnative.tema07.twitterconsumer.service.TwitterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwitterController {

    private TwitterService twitterService;

    public TwitterController(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GetMapping("/twitts/{name}")
    public ResponseEntity<String> countTwitts(@PathVariable("name") String name) {
        try {
            return ResponseEntity.ok(String.valueOf(twitterService.countTweets(name)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
