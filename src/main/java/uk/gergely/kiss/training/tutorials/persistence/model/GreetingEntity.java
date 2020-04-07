package uk.gergely.kiss.training.tutorials.persistence.model;

import uk.gergely.kiss.training.data.JpaConstants;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
public class GreetingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = JpaConstants.ID, nullable = false)
    private Long id;

    @Column(name = JpaConstants.TEXT)
    private String text;

    public GreetingEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GreetingEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("text='" + text + "'")
                .toString();
    }
}
