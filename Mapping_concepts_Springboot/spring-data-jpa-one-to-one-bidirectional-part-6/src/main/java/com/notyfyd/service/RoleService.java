package com.notyfyd.service;

import com.notyfyd.entity.Role;
import com.notyfyd.entity.User;
import com.notyfyd.repository.RoleRepository;
import com.notyfyd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    private UserRepository userRepository;

    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    /** Create a new role along with users */
    public ResponseEntity<Object> addRole(Role role)  {

        Role newRole = new Role();
        newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());
        newRole.setUsers(role.getUsers());
        Role savedRole = roleRepository.save(newRole);
        if(roleRepository.findById(savedRole.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Role and Users");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }


    /** Delete a specified role given the id */
    public ResponseEntity<Object> deleteRole(Long id) {
        if(roleRepository.findById(id).isPresent()){
            roleRepository.deleteById(id);
            if(roleRepository.findById(id).isPresent()){
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }



}







//
//    @Transactional
//    public ResponseEntity<Object> addRole(Role role)  {
//        Role newRole = new Role();
//        newRole.setName(role.getName());
//        newRole.setDescription(role.getDescription());
//        Role savedRole = roleRepository.save(newRole);
//        if(roleRepository.findById(savedRole.getId()).isPresent()) {
//            List<User> userList = new ArrayList<>();
//            for(int i=0; i <  role.getUsers().size(); i++) {
//                User newUser = role.getUsers().get(i);
//                newUser.setRole(savedRole);
//                User savedUser = userRepository.save(newUser);
//                if(!userRepository.findById(savedUser.getId()).isPresent())
//                    return ResponseEntity.accepted().body("Successfully Created Role and Users");
//            }
//            return ResponseEntity.accepted().body("Successfully Created Role and Users");
//        } else return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
//    }



