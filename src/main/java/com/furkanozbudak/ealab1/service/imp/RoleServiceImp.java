package com.furkanozbudak.ealab1.service.imp;

import com.furkanozbudak.ealab1.model.Role;
import com.furkanozbudak.ealab1.repository.RoleRepository;
import com.furkanozbudak.ealab1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    RoleRepository roleRepository;


    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
