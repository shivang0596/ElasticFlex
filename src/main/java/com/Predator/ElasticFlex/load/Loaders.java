package com.Predator.ElasticFlex.load;

import com.Predator.ElasticFlex.model.Users;
import com.Predator.ElasticFlex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @PostConstruct
    @Transactional
    public void loadAll(){
        elasticsearchOperations.putMapping(Users.class);
        System.out.println("Loading Data!!");
        userRepository.save(getData());
        System.out.println("Loading Completed");
    }

    private List<Users> getData(){
        List<Users> usersElasticSearch=new ArrayList<>();
        usersElasticSearch.add(new Users("Ajay",9989L,"Falcon",43500L));
        usersElasticSearch.add(new Users("Jay",9409L,"Urban",53400L));
        usersElasticSearch.add(new Users("Ram",3989L,"Victor",34500L));
        usersElasticSearch.add(new Users("Kush",2339L,"Urban",12300L));
        usersElasticSearch.add(new Users("Vicky",1389L,"Falcon",56300L));
        return usersElasticSearch;
    }
}
