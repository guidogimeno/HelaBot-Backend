package com.gimeno.jarvis.models.dao;

import com.gimeno.jarvis.models.GroceryProduct;
import org.springframework.data.repository.CrudRepository;

public interface IGroceryProductDao extends CrudRepository<GroceryProduct, Long> {

    GroceryProduct findByBarCode(long barCode);

}
