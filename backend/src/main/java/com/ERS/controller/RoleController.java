package com.ERS.controller;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController {
    
    @Autowired
    RoleService roleService;

}
