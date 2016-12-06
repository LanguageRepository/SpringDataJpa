package com.example.controller;

import com.example.model.Role;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/role")
public class RoleConrtroller {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/get/{roleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Role getRole(@PathVariable(value = "roleId") int roleId) {
        return roleService.getRole((long) roleId);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createRole(@RequestBody Role role) {
        roleService.saveRole(role);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
    }

    @RequestMapping(value = "/del/{roleId}", method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable int roleId) {
        roleService.deleteRole((long) roleId);
    }


}
