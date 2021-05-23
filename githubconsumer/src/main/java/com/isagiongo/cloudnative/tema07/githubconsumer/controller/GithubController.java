package com.isagiongo.cloudnative.tema07.githubconsumer.controller;

import com.isagiongo.cloudnative.tema07.githubconsumer.service.GithubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubController {

    private GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/repositories/{name}")
    public ResponseEntity<String> countRepos(@PathVariable("name") String name) {
        try {
            return ResponseEntity.ok(String.valueOf(githubService.countRepositories(name)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
