package com.percival.test.services;

import com.percival.test.models.CompanyProfile;
import com.percival.test.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyProfileServiceImpl implements CompanyProfileService {

    @Autowired
    CompanyRepository repository;

    @Override
    public CompanyProfile getOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public CompanyProfile deleteCompanyProfileById(Long id) {
        return repository.deleteCompanyProfileById(id);
    }

    @Override
    public List<CompanyProfile> findAll() {
        return repository.findAll();
    }

    @Override
    public CompanyProfile save(CompanyProfile companyProfile) {
        return repository.save(companyProfile);
    }

    @Override
    public List<CompanyProfile> findByBusinessCategory(String category) {
        return repository.findByBusinessCategory(category);
    }

    @Override
    public CompanyProfile findByServices(String service) {
        return repository.findByServices(service);
    }

    @Override
    public CompanyProfile findByCompanyName(String companyName) {
        return repository.findByCompanyName(companyName);
    }
}
