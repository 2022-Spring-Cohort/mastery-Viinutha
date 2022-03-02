package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.HashTagRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
public class HomeController {
    private TopicRepository topicRepo;
    private HashTagRepository hashTagRepo;

    public HomeController(TopicRepository topicRepo, HashTagRepository hashTagRepo) {

        this.topicRepo = topicRepo;
        this.hashTagRepo = hashTagRepo;
    }

    @GetMapping("/")
    public String displayHomePage(Model model) {
        model.addAttribute("topics", topicRepo.findAll());
        return "home-template";
    }
    @PostMapping("/topics")
    public String addTopics(@RequestParam String name){
        Topic tp = new Topic(name);
        topicRepo.save(tp);
        return "redirect:/";
    }
}
