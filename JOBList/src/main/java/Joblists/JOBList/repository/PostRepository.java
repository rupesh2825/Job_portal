package Joblists.JOBList.repository;

import Joblists.JOBList.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByProfileContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String profile, String description);

    List<Post> findByTechsContainingIgnoreCase(String techs);

    List<Post> findByExperience(int experience);
}
