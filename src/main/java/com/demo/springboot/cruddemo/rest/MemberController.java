package com.demo.springboot.cruddemo.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.cruddemo.dao.MemberRepository;
import com.demo.springboot.cruddemo.dao.RoleRepository;
import com.demo.springboot.cruddemo.entity.Members;
import com.demo.springboot.cruddemo.entity.Role;

@RestController
@RequestMapping("/api")
public class MemberController {

    private MemberRepository mr;
    private RoleRepository rr;

    public MemberController(MemberRepository mr, RoleRepository rr) {
        this.mr = mr;
        this.rr = rr;
    }

    @PostMapping("/members")
    public Members createUser(@RequestBody Members mem, @RequestParam String roles) {
        // Member Creation
        mem.setPassword("{bcrypt}" + BCrypt.hashpw(mem.getPassword(), BCrypt.gensalt()));
        mem.setActive(1);
        mr.save(mem);
        mem.setPassword(null);
        // Role Creation for Member
        List<String> roleInputList = Arrays.asList(roles.split(","));
        System.out.println(roleInputList);
        List<Role> roleList = new ArrayList<Role>();
        for (String r : roleInputList) {
            Role rr = new Role(mem.getUserId(), "ROLE_" + r);
            roleList.add(rr);
        }
        System.out.println(roleList);
        rr.saveAll(roleList);
        return mem;
    }
}
