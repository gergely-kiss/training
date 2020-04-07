package uk.gergely.kiss.training.tutorials.springboot.model;

import uk.gergely.kiss.training.data.JpaConstants;

import javax.persistence.*;

@Entity(name = JpaConstants.ACCOUNT)
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = JpaConstants.ID, nullable = false)
    private Long id;

    @Column(name = JpaConstants.USERNAME, nullable = false)
    private String userName;

    @Column(name = JpaConstants.PASSWORD, nullable = false)
    private String password;

    @Column(name = JpaConstants.ENABLED, nullable = false)
    private Boolean enabled;

    @Column(name = JpaConstants.CREDENTIALS_EXPIRED, nullable = false)
    private Boolean credentialsExpired;

    @Column(name = JpaConstants.EXPIRED, nullable = false)
    private Boolean expired;

    @Column(name = JpaConstants.LOCKED, nullable = false)
    private Boolean locked;

    public AccountEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

}
