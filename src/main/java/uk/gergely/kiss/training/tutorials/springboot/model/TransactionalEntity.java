package uk.gergely.kiss.training.tutorials.springboot.model;

import uk.gergely.kiss.training.data.JpaConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public class TransactionalEntity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = JpaConstants.ID, nullable = false)
    private Long id;

    @Column(name = JpaConstants.REFERENCE_ID, nullable = false)
    private String referenceId = UUID.randomUUID().toString();

    @Version
    @Column(name = JpaConstants.VERSION, nullable = false)
    private Integer version;

    @Column(name = JpaConstants.CREATED_BY, nullable = false)
    private String createdBy;

    @Column(name = JpaConstants.CREATED_AT, nullable = false)
    private Date createdAt;

    @Column(name = JpaConstants.UPDATED_BY, nullable = false)
    private String updatedBy;

    @Column(name = JpaConstants.UPDATED_AT, nullable = false)
    private Date updatedAt;

    public TransactionalEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionalEntity)) return false;
        TransactionalEntity that = (TransactionalEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @PrePersist
    public void beforePersist(){
        setCreatedAt(new Date());
    }

    @PreUpdate
    public void beforeUpdate(){
        setUpdatedAt(new Date());
    }


}
