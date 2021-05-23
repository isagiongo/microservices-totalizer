package com.isagiongo.cloudnative.tema07.githubconsumer.config;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubConnector {

    @Value("${github.personal.token}")
    private String personalToken;

    public GitHub getConnection() throws IOException {
        return new GitHubBuilder().withJwtToken(personalToken).build();
    }
}
