package Joblists.JOBList.controller;

import Joblists.JOBList.model.Post;
import Joblists.JOBList.repository.PostRepository;
import Joblists.JOBList.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/job_posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private SearchRepository searchRepository;

    // Create a new job post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    // Get all job posts
    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Search job posts by keyword in profile or description (limit 5 results)
    @GetMapping("/search")
    public List<Post> searchPosts(@RequestParam String text) {
        return searchRepository.findByText(text, PageRequest.of(0, 5));
    }

    // Search job posts by technology
    @GetMapping("/search/tech")
    public List<Post> searchByTechnology(@RequestParam String tech) {
        return postRepository.findByTechnology(tech);
    }

    // Search job posts by experience
    @GetMapping("/search/experience")
    public List<Post> searchByExperience(@RequestParam int years) {
        return postRepository.findByExperience(years);
    }
}
