package com.isagiongo.cloudnative.tema07.totalizer.controllers;

import com.isagiongo.cloudnative.tema07.totalizer.services.GithubService;
import com.isagiongo.cloudnative.tema07.totalizer.services.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/totalizers")
public class TotalizerController {

    private Logger logger = LoggerFactory.getLogger(TotalizerController.class);

    private TwitterService twitterService;
    private GithubService githubService;

    public TotalizerController(TwitterService twitterService, GithubService githubService) {
        this.twitterService = twitterService;
        this.githubService = githubService;
    }

    @GetMapping("/twitts/{name}")
    public String getTwitts(@PathVariable String name) {
        return twitterService.getAmountTwittsByUser(name);
    }

    @GetMapping("/repositories/{name}")
    public String getRepositories(@PathVariable String name) {
        return githubService.getAmountRepositoriesByUser(name);
    }

    @GetMapping("/")
    public ResponseEntity<String> getTotalizers(@RequestParam("twitter") String twitterUser, @RequestParam("github") String githubUser) {
        try {
            logger.info("Connecting Twitter Consumer");
            String twitts = twitterService.getAmountTwittsByUser(twitterUser);
            logger.info("Connecting GitHub Consumer");
            String repositories = githubService.getAmountRepositoriesByUser(githubUser);
            return ResponseEntity.ok(String.format("User [%s] - Total of twitts:  [%s] / User [%s] - Total of repositories: [%s]", twitterUser, twitts, githubUser, repositories));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
