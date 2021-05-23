package com.isagiongo.cloudnative.tema07.twitterconsumer.service;

import com.isagiongo.cloudnative.tema07.twitterconsumer.config.Twitter4jConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

@Service
public class TwitterService {

    private Logger logger = LoggerFactory.getLogger(TwitterService.class);

    @Autowired
    private Twitter4jConnector twitter4jConnector;

    public int countTweets(String name) throws TwitterException {
        logger.info("Connecting to twitter Api");
        Twitter client = twitter4jConnector.getConnection();

        logger.info("Searching for requested user");
        User user = client.showUser(name);

        logger.info("Found user: " + user.getScreenName() + ", Description: " + user.getDescription());
        return user.getStatusesCount();
    }
}
