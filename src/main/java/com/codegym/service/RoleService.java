package com.codegym.service;

import com.codegym.model.Role;
import com.codegym.model.Type;

public interface RoleService {
    Iterable<Role> findAll();
    public Role findById(Long id);
    public void save(Role role);
    public void remove(Long id);

}
