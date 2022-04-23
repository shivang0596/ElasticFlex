package com.Predator.ElasticFlex.controller;

import com.Predator.ElasticFlex.model.Users;
import com.Predator.ElasticFlex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/elastic/search")
public class SearchController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/name/{name}")
    public List<Users> searchName(@PathVariable final String name){
        return userRepository.findByName(name);

    }

    @GetMapping("/resp")
    public String getResponse(){
        return "Hello Predator!!";
    }

    @GetMapping(value = "/salary/{salary}")
    public List<Users> searchSalary(@PathVariable final Long salary){
        return userRepository.findBySalary(salary);
    }

    @GetMapping(value = "/all")
    public List<Users> searchAll(){
        List<Users> elasticList=new ArrayList<Users>();
        Iterable<Users> usersES = userRepository.findAll();
        usersES.forEach(elasticList::add);
        return elasticList;
    }
}
