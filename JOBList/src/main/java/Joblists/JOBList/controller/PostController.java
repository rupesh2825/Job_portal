package Joblists.JOBList.controller;

import Joblists.JOBList.model.Post;
import Joblists.JOBList.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/jobs")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    // Create a new job post
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post savedPost = postRepository.save(post);
        return ResponseEntity.ok(savedPost);
    }

    // Get all posts or filter by query, tech, or experience
    @GetMapping
    public List<Post> getPosts(@RequestParam(required = false) String query,
                               @RequestParam(required = false) String tech,
                               @RequestParam(required = false) Integer experience) {
        if (query != null && !query.isEmpty()) {
            return postRepository.findByProfileContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
        } else if (tech != null && !tech.isEmpty()) {
            return postRepository.findByTechsContainingIgnoreCase(tech);
        } else if (experience != null) {
            return postRepository.findByExperience(experience);
        } else {
            return postRepository.findAll();
        }
    }
}
