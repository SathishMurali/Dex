package com.nseit.Dex.repository;

import com.nseit.Dex.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
