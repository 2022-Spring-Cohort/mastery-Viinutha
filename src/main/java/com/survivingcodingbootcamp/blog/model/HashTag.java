package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class HashTag {
    @Id
    @GeneratedValue
    private long id;
    private String hashTag;
    @ManyToMany
    private Collection<Post> posts;

//    public HashTag(String hashTag) {
//        this.hashTag = hashTag;
//        this.posts = new ArrayList<Post>();
//    }

    public long getId() {
        return id;
    }

    public String getHashTag() {
        return hashTag;
    }
//
//    public Collection<Post> getPosts() {
//        return posts;
//    }

    public HashTag(String hashTag, Post...posts) {
        this.hashTag = hashTag;
        this.posts = Arrays.asList(posts);
    }
    public HashTag() {
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    public void setPost(Collection<Post> posts) {
        this.posts = posts;
    }

    public void setPost(Post post) {
        this.posts.add(post);
    }
}
