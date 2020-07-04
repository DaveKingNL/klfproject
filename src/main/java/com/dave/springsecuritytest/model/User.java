
package com.dave.springsecuritytest.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author davej
 */
@Entity
@Table(name = "users")
public class User {
   
    @NotNull
    @Size(min = 4, max = 50)
    @Id
    @Column(name = "username")
    private String username;
    
    @NotNull
    @Size(min = 5, max = 50)
    @Column(name = "password")
    private String password;
    
    @Column(name = "enabled")
    private boolean enabled;
    
    @NotNull
    @Email
    @Size(min = 5, max = 50)
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy ="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<UserActivity> userActivities;
    
    @Transient
    private String message;
    
    
    public User() {
    }

    public User(String username, String password, boolean enabled, String email) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
    }

    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserActivity> getUserActivities() {
        return userActivities;
    }

    public void setUserActivities(Set<UserActivity> userActivities) {
        this.userActivities = userActivities;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
