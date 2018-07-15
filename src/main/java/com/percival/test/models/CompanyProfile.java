package com.percival.test.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String companyName;
    String businessCategory;
    String services;
    String companyDescription;
    String email;
    String telephone;
    String cell;
    String physicalAddress;
    String postalAddress;
    String webAddress;

    String imageBanner1;
    String imageBanner2;
    String imageBanner3;
    String imageBanner4;
    String imageBanner5;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getImageBanner1() {
        return imageBanner1;
    }

    public void setImageBanner1(String imageBanner1) {
        this.imageBanner1 = imageBanner1;
    }

    public String getImageBanner2() {
        return imageBanner2;
    }

    public void setImageBanner2(String imageBanner2) {
        this.imageBanner2 = imageBanner2;
    }

    public String getImageBanner3() {
        return imageBanner3;
    }

    public void setImageBanner3(String imageBanner3) {
        this.imageBanner3 = imageBanner3;
    }

    public String getImageBanner4() {
        return imageBanner4;
    }

    public void setImageBanner4(String imageBanner4) {
        this.imageBanner4 = imageBanner4;
    }

    public String getImageBanner5() {
        return imageBanner5;
    }

    public void setImageBanner5(String imageBanner5) {
        this.imageBanner5 = imageBanner5;
    }
}
