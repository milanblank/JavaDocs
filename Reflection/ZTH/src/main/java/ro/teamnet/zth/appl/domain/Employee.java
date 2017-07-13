package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;

import java.util.Date;

/**
 * Created by Milan on 13-Jul-17.
 */

public class Employee {

    @Id(name = "employee_id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "hire_date")
    private Date hireDate;
    @Column(name = "job_id")
    private Job jobId;
    @Column(name = "salary")
    private double salary;
    @Column(name = "commission_pct")
    private double commissionPct;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Job getJobId() {
        return jobId;
    }

    public void setJobId(Job jobId) {
        this.jobId = jobId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(double commissionPct) {
        this.commissionPct = commissionPct;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Employee o = (Employee) obj;

        if(this.getId() == o.getId()
                && this.getFirstName().equals(o.getFirstName())
                && this.getLastName().equals(o.getLastName())
                && this.getEmail().equals(o.getEmail())
                && this.getPhoneNumber().equals(o.getPhoneNumber())
                && this.getHireDate().equals(o.getHireDate())
                && this.getJobId().equals(o.getJobId())
                && this.getSalary() == o.getSalary()
                && this.getCommissionPct() == o.getCommissionPct())
            return true;

        return super.equals(obj);
    }

    @Override
    public String toString() {
        return this.getId() + " "
                + this.getFirstName() + " "
                + this. getLastName() + " "
                + this.getEmail() + " "
                + this.getPhoneNumber() + " "
                + this.getHireDate() + " "
                + this. getJobId() + " "
                + this.getSalary() + " "
                + this.getCommissionPct();
    }
}
