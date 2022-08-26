package com.nseit.Dex.services;

import com.nseit.Dex.model.Admin;
import com.nseit.Dex.model.Candidate;
import com.nseit.Dex.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public void addUser(Admin admin){
        adminRepository.save(admin);
    }
}
