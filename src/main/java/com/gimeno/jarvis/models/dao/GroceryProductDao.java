package com.gimeno.jarvis.models.dao;

import com.gimeno.jarvis.models.GroceryProduct;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class GroceryProductDao implements Dao<GroceryProduct> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<GroceryProduct> get(long id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<GroceryProduct> getAll() {
        return entityManager.createQuery("from GroceryProduct").getResultList();
    }

    @Override
    @Transactional
    public void save(GroceryProduct product) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void update(GroceryProduct product) {
        throw new RuntimeException("Not implemented");
    }
}
