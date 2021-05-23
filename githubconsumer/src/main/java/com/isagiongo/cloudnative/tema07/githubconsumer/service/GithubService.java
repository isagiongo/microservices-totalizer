package com.isagiongo.cloudnative.tema07.githubconsumer.service;

import com.isagiongo.cloudnative.tema07.githubconsumer.config.GithubConnector;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GithubService {

    private Logger logger = LoggerFactory.getLogger(GithubService.class);

    @Autowired
    private GithubConnector githubConnector;

    public int countRepositories(String name) throws IOException {
        logger.info("Connecting to GitHub Api");
        GitHub gitHubClient = githubConnector.getConnection();

        logger.info("Searching for requested user");
        GHUser user = gitHubClient.getUser(name);

        logger.info("Found user: " + user.getName() + ", Bio: " + user.getBio());
        return user.getPublicRepoCount();
    }
}
