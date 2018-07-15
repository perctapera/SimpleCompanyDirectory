package com.percival.test.repository;

import com.percival.test.models.CompanyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyProfile, Long> {
    @Override
    CompanyProfile getOne(Long id);

    CompanyProfile deleteCompanyProfileById(Long id);

    @Override
    List<CompanyProfile> findAll();

    CompanyProfile findByCompanyName(String companyName);
   List<CompanyProfile> findByBusinessCategory(String categoty);
    CompanyProfile findByServices(String service);
}
