package uk.gergely.kiss.training.tutorials.persistence.model;

import uk.gergely.kiss.training.data.JpaConstants;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = JpaConstants.ID, nullable = false)
    private Long id;

    @Column(name = JpaConstants.CODE, nullable = false)
    private String code;

    @Column(name = JpaConstants.LABEL, nullable = false)
    private String label;

    public RoleEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RoleEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("code='" + code + "'")
                .add("label='" + label + "'")
                .toString();
    }
}
