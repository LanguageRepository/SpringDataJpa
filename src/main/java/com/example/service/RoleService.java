package com.example.service;

import com.example.model.Role;
import com.example.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public Role getRole(Long id) {
        return roleRepository.getOne(id);
    }

    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    public void updateRole(Role role) {
        roleRepository.saveAndFlush(role);
    }

    @Transactional
    public void deleteRole(Long id) {
        roleRepository.delete(id);
    }

}
