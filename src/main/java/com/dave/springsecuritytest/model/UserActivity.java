/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dave.springsecuritytest.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author davej
 */
@Entity
@Table(name="user_activity")
public class UserActivity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private String username;
    
    
    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Integer activityId;
    
    @DateTimeFormat(pattern= "dd/MM/yyyy")
    @Column(name="occurrence")
    private Timestamp occurrence;

    private Timestamp firstOccurrence;
    
    private Timestamp lastOccurrence;
    
    private String activityName;
    
    private Integer amount;
    
    
    public UserActivity() {
    }

    public UserActivity(Integer id, String username, Integer activityId, Timestamp occurrence) {
        this.id = id;
        this.username = username;
        this.activityId = activityId;
        this.occurrence = occurrence;
    }

    public UserActivity(String username, Timestamp firstOccurrence, Timestamp lastOccurrence, String activityName, Integer amount) {
        this.username = username;
        this.firstOccurrence = firstOccurrence;
        this.lastOccurrence = lastOccurrence;
        this.activityName = activityName;
        this.amount = amount;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Timestamp getOccurence() {
        return occurrence;
    }

    public void setOccurence(Timestamp occurrence) {
        this.occurrence = occurrence;
    }

    public Timestamp getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Timestamp occurrence) {
        this.occurrence = occurrence;
    }

    public Timestamp getFirstOccurrence() {
        return firstOccurrence;
    }

    public void setFirstOccurrence(Timestamp firstOccurrence) {
        this.firstOccurrence = firstOccurrence;
    }

    public Timestamp getLastOccurrence() {
        return lastOccurrence;
    }

    public void setLastOccurrence(Timestamp lastOccurrence) {
        this.lastOccurrence = lastOccurrence;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    
    
    
    
}
