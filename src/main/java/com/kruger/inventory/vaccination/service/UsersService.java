package com.kruger.inventory.vaccination.service;
import com.kruger.inventory.vaccination.model.Role;
import com.kruger.inventory.vaccination.model.Users;


import java.util.List;
/**
 * This class sets the functionality the class will have
 */
public interface UsersService {
    Users createUser(Users users);
    Role createRole(Role rol);
    void addingRoleToUser(String userName, String roleName);
    Users obtainUser(String userName);
    List<Users> obtainUsers();
    Long obtainTheInsertedId(Users user);
}
