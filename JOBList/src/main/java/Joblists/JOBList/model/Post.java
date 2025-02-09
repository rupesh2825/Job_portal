package Joblists.JOBList.model;

import jakarta.persistence.*;

@Entity
@Table(name = "job_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profile", nullable = false)
    private String profile;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "experience")
    private int experience;

    @Column(name = "techs")
    private String techs; // Stored as a comma-separated string

    public Post() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getTechs() {
        return techs;
    }

    public void setTechs(String techs) {
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", profile='" + profile + '\'' +
                ", description='" + description + '\'' +
                ", experience=" + experience +
                ", techs='" + techs + '\'' +
                '}';
    }
}
