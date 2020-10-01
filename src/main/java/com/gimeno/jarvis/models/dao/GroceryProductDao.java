package com.gimeno.jarvis.models.dao;

import com.gimeno.jarvis.models.GroceryProduct;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class GroceryProductDao implements Dao<GroceryProduct> {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<GroceryProduct> getAll() {
        return entityManager.createQuery("from GroceryProduct").getResultList();
    }
}
