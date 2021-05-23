package com.isagiongo.cloudnative.tema07.totalizer.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "twitter-service", url = "http://twitter-consumer:8081/twitts")
public interface TwitterService {

    @RequestMapping("/{name}")
    public String getAmountTwittsByUser(@PathVariable("name") String name);

}
