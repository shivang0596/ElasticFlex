package com.Predator.ElasticFlex.repository;

import com.Predator.ElasticFlex.model.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<Users, Long> {
    List<Users> findByName(String name);

    List<Users> findBySalary(Long salary);
}
