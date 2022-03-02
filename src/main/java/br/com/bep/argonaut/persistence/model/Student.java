package br.com.bep.argonaut.persistence.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "identity_number", nullable = false)
    private String identityNumber;

    @Column(name = "student_since", nullable = false)
    private LocalDate studentSince;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "cellphone", nullable = false)
    private Long cellphone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "address_line", nullable = false)
    private String addressLine;

    @Column(name = "monthly_bill")
    private double monthlyBill;

    @Column(name = "last_pay_date")
    private LocalDate lastPayDate;

    @Column(name = "active")
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public LocalDate getStudentSince() {
        return studentSince;
    }

    public void setStudentSince(LocalDate studentSince) {
        this.studentSince = studentSince;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public double getMonthlyBill() {
        return monthlyBill;
    }

    public void setMonthlyBill(double monthlyBill) {
        this.monthlyBill = monthlyBill;
    }

    public LocalDate getLastPayDate() {
        return lastPayDate;
    }

    public void setLastPayDate(LocalDate lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
