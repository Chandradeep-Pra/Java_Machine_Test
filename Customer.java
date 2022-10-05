package com.nissan.bean;

import java.util.Random;

public class Customer {
	
	//Instance Variables
	private int acNo;
	private String customerName;
	private String  accType; 
	private float balance;
	private float minBalance;
	private String mobNum;
	private String custEmail;
	private int atmPin;
	private String pan;
	

	//Default constructor 
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Parameterized constructor
	public Customer(int acNo, String customerName, String accType, float balance, float minBalance, String mobNum,
			String custEmail, int atmPin) {
		super();
		this.acNo = acNo;
		this.customerName = customerName;
		this.accType = accType;
		this.balance = balance;
		this.minBalance = minBalance;
		this.mobNum = mobNum;
		this.custEmail = custEmail;
		this.atmPin = atmPin;
	}
	
	//Getters and Setters
	public int getAcNo() {
		return acNo;
	}

	public void setAcNo(int acNo) {
		this.acNo = acNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(float minBalance) {
		this.minBalance = minBalance;
	}

	public String getMobNum() {
		return mobNum;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public int getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}
	
	
	
	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	@Override
	public String toString() {
		return "Customer [acNo=" + acNo + ", customerName=" + customerName + ", accType=" + accType + ", balance=" + (balance+minBalance)
				+ ", minBalance=" + minBalance + ", mobNum=" + mobNum + ", custEmail=" + custEmail + ", atmPin="
				+ atmPin + "]";
	}

		//Generating Random Account Number
		public static int generateAccNo() {
			Random randAccNo=new Random();
			return (100000000 + randAccNo.nextInt(900000000));
			
		}
		
		//Generating Random 4 digit pin
		public static int generateATMPin() {
			Random randPin = new Random();
			return (1000 + randPin.nextInt(9000));
		}

	
		

}
