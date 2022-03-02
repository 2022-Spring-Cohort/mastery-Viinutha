package com.survivingcodingbootcamp.blog;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.HashTagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Populator implements CommandLineRunner {

    private TopicRepository topicRepo;
    private PostRepository postRepo;
    private HashTagRepository hashTagRepo;


    public Populator(TopicRepository topicRepo, PostRepository postRepo,HashTagRepository hashTagRepo) {

        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
        this.hashTagRepo = hashTagRepo;
    }

    @Override
    public void run(String... args) throws Exception {
//        HashTag hashTag1 = new HashTag("#welcome".toUpperCase());
//        hashTagRepo.save(hashTag1);
//        HashTag hashTag2 = new HashTag("#learning tdd".toUpperCase());
//        hashTagRepo.save(hashTag2);
//        HashTag hashTag3 = new HashTag("#Test the fear away".toUpperCase());
//        hashTagRepo.save(hashTag3);
//        HashTag hashTag4 = new HashTag("#unit test and you".toUpperCase());
//        hashTagRepo.save(hashTag4);
//        HashTag hashTag5 = new HashTag("#Battling Imposter Syndrome".toUpperCase());
//        hashTagRepo.save(hashTag5);
//        HashTag hashTag6 = new HashTag("#Introductory Java".toUpperCase());
//        hashTagRepo.save(hashTag6);
//        HashTag hashTag7 = new HashTag("#Object Oriented Programming and You".toUpperCase());
//        hashTagRepo.save(hashTag7);
        Topic topic1 = new Topic("Learning TDD");
        topicRepo.save(topic1);

        Post post1 = new Post("TDD For Fun and Profit", "Dr.Sues",topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.");
        postRepo.save(post1);
        Post post2 = new Post("Test the Fear Away","Dr.Sues", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.");
        postRepo.save(post2);
        Post post3 = new Post("Unit Tests and You", "Dr.Sues",topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.");
        postRepo.save(post3);
        Topic topic2 = new Topic("Battling Imposter Syndrome");
        topicRepo.save(topic2);
        Topic topic3 = new Topic("Introductory Java");
        topicRepo.save(topic3);
        Topic topic4 = new Topic("Object Oriented Programming and You");
        topicRepo.save(topic4);


    }

}
