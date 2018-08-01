package com.isabell.authentication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="parents")

public class Parent {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Name needs to be filled out")
    private String fname;
    
    @NotNull(message = "Name needs to be filled out")
    private String lname;
    
    @Email(message="Email must be valid")
    private String email;
    
    @NotNull(message = "Phone number needs to be filled out")
    private String phone;
    
    @Min(message = "You need to have at least one kid to book a Nanny", value = 0)
    private Integer amountKid;
    
    @Size(min=5, message="Password must be greater than 5 characters")
    private String password;
    
    @Transient //Means that the passwordConfirmation will not be saved in the db and it's just used for validation
    private String passwordConfirmation;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List <Rating> ratings;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "bookings", 
            joinColumns = @JoinColumn(name = "parent_id"), 
            inverseJoinColumns = @JoinColumn(name = "nanny_id")
        )
        private List<Nanny> nannies;
    
//    constructor
    public Parent() {
    }
    
    public Parent(Long id, String fname, String lname, String email, String phone, Integer amountKid) {
    	this.fname = fname;
    	this.lname = lname;
    	this.email = email;
    	this.phone = phone;
    	this.amountKid = amountKid;
    }

    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
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



	public Integer getAmountKid() {
		return amountKid;
	}



	public void setAmountKid(Integer amountKid) {
		this.amountKid = amountKid;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}



	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public List<Rating> getRatings() {
		return ratings;
	}



	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}



	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
