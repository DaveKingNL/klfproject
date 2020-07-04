
package com.dave.springsecuritytest.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author davej
 */
@Entity
@Table(name="activity")
public class Activity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="activity_name")
    private String activityName;

    public Activity() {
    }
    
    @OneToMany(mappedBy ="activity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<UserActivity> userActivities;

    public Activity(int id, String activityName) {
        this.id = id;
        this.activityName = activityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Set<UserActivity> getUserActivities() {
        return userActivities;
    }

    public void setUserActivities(Set<UserActivity> userActivities) {
        this.userActivities = userActivities;
    }
    
    
}
