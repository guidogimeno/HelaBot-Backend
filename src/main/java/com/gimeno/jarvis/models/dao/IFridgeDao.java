package com.gimeno.jarvis.models.dao;

import com.gimeno.jarvis.models.Fridge;
import org.springframework.data.repository.CrudRepository;

public interface IFridgeDao extends CrudRepository<Fridge, Long> {

}
