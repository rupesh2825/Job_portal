package Joblists.JOBList.repository;

import Joblists.JOBList.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // Search job posts by profile, description, or tech stack
    @Query("SELECT p FROM Post p WHERE " +
            "LOWER(p.profile) LIKE LOWER(CONCAT('%', :text, '%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "ORDER BY p.experience ASC")
    List<Post> findByText(@Param("text") String text, Pageable pageable);

    // Search job posts by technology
    @Query("SELECT p FROM Post p WHERE LOWER(p.techs) LIKE LOWER(CONCAT('%', :tech, '%'))")
    List<Post> findByTechnology(@Param("tech") String tech);

    // Get posts by minimum experience required
    @Query("SELECT p FROM Post p WHERE p.experience >= :years ORDER BY p.experience ASC")
    List<Post> findByExperience(@Param("years") int years);
}
