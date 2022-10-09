package com.kruger.inventory.vaccination.service;

import com.kruger.inventory.vaccination.model.Role;
import com.kruger.inventory.vaccination.model.Users;
import com.kruger.inventory.vaccination.repository.RoleRepo;
import com.kruger.inventory.vaccination.repository.UsersRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UsersServiceImp implements UsersService {
    private final UsersRepo usersRepo;
    private final RoleRepo roleRepo;
    //private final PasswordEncoder passwordEncoder;
    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users usuario = usuarioRepo.findByUserName(username);
        if (usuario == null) {
            log.error("Usuario no encontrado");
            throw new UsernameNotFoundException("Usuario no encontrado");
        } else {
            log.info("Usuario encontrado en la base de datos: {} ", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getRoles().forEach(rol -> {
            authorities.add(new SimpleGrantedAuthority(rol.getName()));
        });
        return new org.springframework.security.core.userdetails.User(usuario.getUserName(), usuario.getPassword(), authorities);
    }
*/
    @Override
    public Users createUser(Users user) {
        log.info("Creating a new user {} in the DataBase", user.getUserName());
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepo.save(user);
    }

    @Override
    public Role createRole(Role role) {
        log.info("Guardando un nuevo rol {} en la base de datos", role.getName());
        log.info("Creating a new role {} in the Data Base", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addingRoleToUser(String userName, String roleName) {
        log.info("Adding role {} to the user {}", roleName, userName);
        Users user = usersRepo.findByUserName(userName);
        Role rol = roleRepo.findByName(roleName);
        user.getRoles().add(rol);
    }

    @Override
    public Users obtainUser(String userName) {
        log.info("Searching for user's name {}", userName);
        return usersRepo.findByUserName(userName);
    }

    @Override
    public List<Users> obtainUsers() {
        log.info("Listing all the Users");
        return usersRepo.findAll();
    }
}
