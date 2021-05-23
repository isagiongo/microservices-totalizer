package com.isagiongo.cloudnative.tema07.totalizer.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "githubconsumer", url = "http://githubconsumer:8082/repositories")
public interface GithubService {

    @RequestMapping("/{name}")
    public String getAmountRepositoriesByUser(@PathVariable("name") String name);

}
