package com.bcp.card.login.dao;

import com.bcp.card.login.model.entity.TwilioAccout;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TwilioRepository extends ReactiveCrudRepository<TwilioAccout, Integer>  {

}
