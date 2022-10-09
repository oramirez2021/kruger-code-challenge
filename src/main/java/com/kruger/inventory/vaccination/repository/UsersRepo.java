package com.kruger.inventory.vaccination.repository;
import com.kruger.inventory.vaccination.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByUserName(String userName);
}
