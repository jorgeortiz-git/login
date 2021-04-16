package com.bcp.card.login.dao;

import com.bcp.card.login.model.entity.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

  //@Query("select * from Usuario where username = :username and password = :password")
  Mono<User> findByUsernameAndPassword(String username, String password);
}

