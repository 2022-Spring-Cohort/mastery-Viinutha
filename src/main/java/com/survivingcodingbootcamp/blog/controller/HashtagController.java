package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.repository.HashTagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Controller
public class HashtagController {
    private HashTagRepository hashTagRepo;
    private PostRepository postRepo;

    public HashtagController(HashTagRepository hashTagRepo, PostRepository postRepo) {
        this.hashTagRepo = hashTagRepo;
        this.postRepo = postRepo;
    }
//    @GetMapping("/all-hashtags-template")//change to /hashtags
    @GetMapping("/hashTags")
    public String showAllHashtags(Model model) {
        List<HashTag> hashtags = (List<HashTag>) hashTagRepo.findAll();
        if(hashtags.size() > 0) {
            model.addAttribute("hashtags", hashtags);
            //return "all-hashtags-template";
            return "all-hashtags-template";
        }
        return "all-hashtags-template";
    }
//    @GetMapping("/posts/hashTags/{id}")//hashtags/{id}
    @GetMapping("/hashTags/{id}")
    public String showSingleHashtag(Model model, @PathVariable Long id){
        Optional<HashTag> optionalHash = hashTagRepo.findById(id);
        model.addAttribute("hashtag", optionalHash.get());
        return "single-hashtag-template";
    }

//    @PostMapping("/posts/hashTags/{id}")//move this to post controller and change mapping to /posts/{id}/addHastag
    @PostMapping("/posts/{id}")
    public String getHashTagFromUser(@RequestParam String hashTag, @PathVariable Long id, Model model){
        String tempHashtag = checkHashTag(hashTag);
        Optional<HashTag> optionalHash = hashTagRepo.findByHashTag(tempHashtag);
        Post post = postRepo.findById(id).get();
        if(optionalHash.isPresent()){
            if(!optionalHash.get().getPosts().contains(post)) {
                optionalHash.get().setPost(post);
                hashTagRepo.save(optionalHash.get());
            }
        }
        else {
            HashTag hashTag_2 = new HashTag(tempHashtag,post);
            hashTagRepo.save(hashTag_2);
        }
        model.addAttribute("hashtag",tempHashtag);
        return "redirect:/posts/"+id;
    }
    private String checkHashTag(String hashtag) {
        List<String> list = Arrays.asList(hashtag);
        String result = String.join(",", list);
        String tempHashtag = "";
        if (hashtag.contains("#")) {
            tempHashtag = hashtag;
        } else {
            tempHashtag = "#" + hashtag;
        }
        return tempHashtag;
    }

}
