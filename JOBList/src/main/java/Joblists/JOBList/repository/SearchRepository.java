package Joblists.JOBList.repository;

import Joblists.JOBList.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE " +
            "LOWER(p.profile) LIKE LOWER(CONCAT('%', :text, '%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :text, '%')) OR " +
            "LOWER(p.techs) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "ORDER BY p.experience ASC")
    List<Post> findByText(@Param("text") String text, Pageable pageable);
}
