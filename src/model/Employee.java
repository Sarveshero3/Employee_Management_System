package model;

import java.sql.Date;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private double salary;
    private Date dateOfJoining;
    private String email;
    private String phoneNumber;
    private String address;
    private String emergencyContactName;
    private String emergencyContactPhone;

    // Default Constructor
    public Employee() {}

    // Parameterized Constructor
    public Employee(int employeeId, String firstName, String lastName, String position, double salary,
                    Date dateOfJoining, String email, String phoneNumber, String address,
                    String emergencyContactName, String emergencyContactPhone) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Getters and Setters

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    } 

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } 

    public String getLastName() {
        return lastName;
    } 

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } 

    public String getPosition() {
        return position;
    } 

    public void setPosition(String position) {
        this.position = position;
    } 

    public double getSalary() {
        return salary;
    } 

    public void setSalary(double salary) {
        this.salary = salary;
    } 

    public Date getDateOfJoining() {
        return dateOfJoining;
    } 

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    } 

    public String getEmail() {
        return email;
    } 

    public void setEmail(String email) {
        this.email = email;
    } 

    public String getPhoneNumber() {
        return phoneNumber;
    } 

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    } 

    public String getAddress() {
        return address;
    } 

    public void setAddress(String address) {
        this.address = address;
    } 

    public String getEmergencyContactName() {
        return emergencyContactName;
    } 

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    } 

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    } 

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }
}
