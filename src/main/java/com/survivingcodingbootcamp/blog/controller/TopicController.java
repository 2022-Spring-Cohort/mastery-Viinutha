package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/topics")
public class TopicController {

    private TopicRepository topicRepo;
    private PostRepository postRepo;

    public TopicController(TopicRepository topicRepo,PostRepository postRepo) {
        this.postRepo = postRepo;
        this.topicRepo = topicRepo;
    }
    @GetMapping("/{id}")
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicRepo.findById(id).get());
        return "single-topic-template";
    }
    @PostMapping("/{id}")
    public String addSinglePost(@RequestParam String title, @RequestParam String author, @RequestParam String content, @PathVariable long id){
        Topic topic = topicRepo.findById(id).get();
        Post post = new Post(title,author,topic,content);
        postRepo.save(post);
        return "redirect:/topics/{id}";
     //   System.out.println(postRepo.findById(id).get().getTopic());
    }

}
