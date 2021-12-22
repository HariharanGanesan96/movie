package com.model;

import java.util.Date;
import java.util.Objects;

public class PetDetails {
	private int petId;
	private String petType;
	private String petName;
	private String petGender;
	private Date petDob;
	private int petQty;
	private String description;
	private String petColor;
	private double petprice;
	private String petImage;
	private String status;
	private int customerId;
	private int adminId;
	private Date regDate;
	private int avilableQty;
	
	public int getAvilableQty() {
		return avilableQty;
	}
	public void setAvilableQty(int avilableQty) {
		this.avilableQty = avilableQty;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetGender() {
		return petGender;
	}
	public void setPetGender(String petGender) {
		this.petGender = petGender;
	}
	public Date getPetDob() {
		return petDob;
	}
	public void setPetDob(Date petDob) {
		this.petDob = petDob;
	}
	public int getPetQty() {
		return petQty;
	}
	public void setPetQty(int petQty) {
		this.petQty = petQty;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPetColor() {
		return petColor;
	}
	public void setPetColor(String petColor) {
		this.petColor = petColor;
	}
	public double getPetprice() {
		return petprice;
	}
	public void setPetprice(double petprice) {
		this.petprice = petprice;
	}
	public String getPetImage() {
		return petImage;
	}
	public void setPetImage(String petImage) {
		this.petImage = petImage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	@Override
	public String toString() {
		return "PetDetails [petId=" + petId + ", petType=" + petType + ", petName=" + petName + ", petGender="
				+ petGender + ", petDob=" + petDob + ", petQty=" + petQty + ", description=" + description
				+ ", petColor=" + petColor + ", petprice=" + petprice + ", petImage=" + petImage + ", status=" + status
				+ ", customerId=" + customerId + ", adminId=" + adminId + ", regDate=" + regDate + ", avilableQty="
				+ avilableQty + "]";
	}
	public PetDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// This constructor is used for insert operation
	public PetDetails(String petType, String petName, String petGender, Date petDob, int petQty, String description,
			String petColor, double petprice, String petImage, int customerId,int availableQty) {
		super();
		this.petType = petType;
		this.petName = petName;
		this.petGender = petGender;
		this.petDob = petDob;
		this.petQty = petQty;
		this.description = description;
		this.petColor = petColor;
		this.petprice = petprice;
		this.petImage = petImage;
		this.customerId = customerId;
		this.avilableQty=availableQty;
	}
	
	// show all the pet details for customer
		public PetDetails(int petId, String petType, String petName, String petGender, Date petDob, 
				String description,String petColor,int petQty,  double petprice, String petImage,  Date regDate,int availableQty) {
			super();
			this.petId = petId;
			this.petType = petType;
			this.petName = petName;
			this.petGender = petGender;
			this.petDob = petDob;
			this.petQty = petQty;
			this.description = description;
			this.petColor = petColor;
			this.petprice = petprice;
			this.petImage = petImage;
			this.regDate = regDate;
			this.avilableQty=availableQty;
		}
	
	// show my pet details for customer
	public PetDetails(int petId, String petType, String petName, String petGender, Date petDob, 
			String description,String petColor,int petQty,  double petprice, String petImage, String status, Date regDate,int availableQty) {
		super();
		this.petId = petId;
		this.petType = petType;
		this.petName = petName;
		this.petGender = petGender;
		this.petDob = petDob;
		this.petQty = petQty;
		this.description = description;
		this.petColor = petColor;
		this.petprice = petprice;
		this.petImage = petImage;
		this.status = status;
		this.regDate = regDate;
		this.avilableQty=availableQty;
	}
		
	// used to show pet list for admin
	public PetDetails(int petId, String petType, String petName, String petGender, Date petDob,String description, 
			 String petColor, int petQty,double petprice, String petImage, String status, int customerId, Date regDate,int availableQty) {
		super();
		this.petId = petId;
		this.petType = petType;
		this.petName = petName;
		this.petGender = petGender;
		this.petDob = petDob;
		this.petQty = petQty;
		this.description = description;
		this.petColor = petColor;
		this.petprice = petprice;
		this.petImage = petImage;
		this.status = status;
		this.customerId = customerId;
		this.regDate = regDate;
		this.avilableQty=availableQty;
	}
	
	// used to store all the information
	public PetDetails(int petId, String petType, String petName, String petGender, Date petDob, int petQty,
			String description, String petColor, double petprice, String petImage, String status, int customerId,
			int adminId, Date regDate,int availableQty) {
		super();
		this.petId = petId;
		this.petType = petType;
		this.petName = petName;
		this.petGender = petGender;
		this.petDob = petDob;
		this.petQty = petQty;
		this.description = description;
		this.petColor = petColor;
		this.petprice = petprice;
		this.petImage = petImage;
		this.status = status;
		this.customerId = customerId;
		this.adminId = adminId;
		this.regDate = regDate;
		this.avilableQty=availableQty;
	}
}
