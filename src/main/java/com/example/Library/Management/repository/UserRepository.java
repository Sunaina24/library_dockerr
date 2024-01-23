package com.example.Library.Management.repository;

import com.example.Library.Management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
