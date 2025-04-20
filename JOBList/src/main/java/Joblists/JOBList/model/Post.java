package Joblists.JOBList.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "job_posts")
public class Post {

    @Id
    private String id;
    private String profile;
    private String description;
    private int experience;
    private List<String> techs;  // Changed to List<String> for multiple technologies

    public Post() {}

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<String> getTechs() {
        return techs;
    }

    public void setTechs(List<String> techs) {
        this.techs = techs;
    }
}
