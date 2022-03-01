package br.com.bep.argonaut.dto;

import java.time.LocalDate;

public class StudentDTO {

    private String name;
    private String identityNumber;
    private LocalDate studentSince;
    private LocalDate birthDate;
    private Long cellphone;
    private String email;
    private String postalCode;
    private String addressLine;
    private double monthlyBill;
    private LocalDate lastPayDate;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
}
