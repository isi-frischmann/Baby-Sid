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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="nannys")
public class Nanny {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "Name needs to be filled out")
    private String fname;
    
    @NotNull(message = "Name needs to be filled out")
    private String lname;
    
    @NotNull(message = "Name needs to be filled out")
    private Long phone;
    
    @Email(message="Email must be valid")
    private String email;
    
    private String zipCode;
    private String address;
    private Integer maxKid;
    private Integer ageKidFrom;
	private Integer ageKidTo;
    
    @Size(min=5, message="Password must be greater than 5 characters")
    private String password;
    
    @Transient //Means that the passwordConfirmation will not be saved in the db and it's just used for validation
    private String passwordConfirmation;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy = "nanny", fetch = FetchType.LAZY)
    private List <Rating> ratings;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "bookings", 
            joinColumns = @JoinColumn(name = "nanny_id"), 
            inverseJoinColumns = @JoinColumn(name = "parent_id")
        )
        private List<Parent> parents;
    
//    constructor
    public Nanny() {
    }
    
    public Nanny(String fname, String lname, Long phone, String email, String zipCode, String address, Integer maxKid, Integer ageKidFrom, Integer ageKidTo) {
    	this.fname = fname;
    	this.lname = lname;
    	this.phone = phone;
    	this.email = email;
    	this.zipCode = zipCode;
    	this.address = address;
    	this.maxKid = maxKid;
    	this.ageKidFrom = ageKidFrom;
    	this.ageKidTo = ageKidTo;
    }
    
    
//    getter and setter
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

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	 public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public Integer getAgeKidFrom() {
			return ageKidFrom;
		}
	
	
	public void setAgeKidFrom(Integer ageKidFrom) {
		this.ageKidFrom = ageKidFrom;
	}


	public Integer getAgeKidTo() {
		return ageKidTo;
	}


	public void setAgeKidTo(Integer ageKidTo) {
		this.ageKidTo = ageKidTo;
	}
		
	public Integer getMaxKid() {
		return maxKid;
	}

	public void setMaxKid(Integer maxKid) {
		this.maxKid = maxKid;
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
