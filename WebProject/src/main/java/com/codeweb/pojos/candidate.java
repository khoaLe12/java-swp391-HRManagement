/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeweb.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author KHOA
 */
@Entity
@Table(name = "Candidates")
public class candidate implements Serializable{
    
    @Id
    @Column(name = "Candidate_id")
    private String id;
    
    @Column(name = "FullName")
    private String name;
    
    @Column(name = "Given_Name")
    private String given_name;
    
    @Column(name = "Family_Name")
    private String family_name;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    
    @Column(name = "Phone")
    private String phone;
    
    @Column(name = "Address")
    private String address;
    
    @Column(name = "Avatar")
    private String picture;
    
    @Column(name = "Role")
    private String role;
    
    @Column(name = "Job_Name")
    private String jobName;
    
    @Column(nullable=true, name = "Experience")
    private Integer experience;
    
    @Column(name = "Blocked_status")
    private boolean status;

    @ManyToMany(mappedBy = "candidates", fetch = FetchType.EAGER)
    private Set<skill>skills;
    
    @OneToMany(mappedBy = "candidate",fetch = FetchType.EAGER)
    private Set<jobApplication> jobApplications;

    @ManyToMany(mappedBy = "listCandidates", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<jobPosting>jobPostings = new HashSet<jobPosting>();
    
    @Transient
    private Set<String> skillList;

    public Set<String> getSkillList() {
        return skillList;
    }

    public void setSkillList(Set<String> skillList) {
        this.skillList = skillList;
    }
    
    public Set<jobPosting> getJobPostings() {
        return jobPostings;
    }

    public void setJobPostings(Set<jobPosting> jobPostings) {
        this.jobPostings = jobPostings;
    }
    
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Set<skill> getSkills() {
        return skills;
    }

    public Set<jobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(Set<jobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }
    
    public void setSkills(Set<skill> skills) {
        this.skills = skills;
    }
    
    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getExperience() {
        if(experience == null)
            return 0;
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "candidate{" + "id=" + id + ", name=" + name + ", given_name=" + given_name + ", family_name=" + family_name + ", email=" + email + ", dob=" + dob + ", phone=" + phone + ", address=" + address + ", picture=" + picture + ", role=" + role + ", jobName=" + jobName + ", experience=" + experience + ", status=" + status + ", skills=" + skills + ", jobApplications=" + jobApplications + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof candidate)) return false;
        candidate that = (candidate) o;
        return Objects.equals(id, that.id);
    }
}
