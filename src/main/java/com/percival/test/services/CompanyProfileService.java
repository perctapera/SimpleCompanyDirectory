package com.percival.test.services;

import com.percival.test.models.CompanyProfile;

import java.util.List;

public interface CompanyProfileService {

    CompanyProfile getOne(Long id);

    CompanyProfile deleteCompanyProfileById(Long id);

    List<CompanyProfile> findAll();

    CompanyProfile findByCompanyName(String companyName);
    CompanyProfile save(CompanyProfile companyProfile);
    List<CompanyProfile> findByBusinessCategory(String category);
    CompanyProfile findByServices(String service);
}
