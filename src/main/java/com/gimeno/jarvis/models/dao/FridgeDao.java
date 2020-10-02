package com.gimeno.jarvis.models.dao;

import com.gimeno.jarvis.models.Fridge;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class FridgeDao implements Dao<Fridge> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Fridge> get(long id) {
        return Optional.ofNullable(entityManager.find(Fridge.class, id));
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Fridge> getAll() {
        return entityManager.createQuery("from Fridge").getResultList();
    }

    @Override
    @Transactional
    public void save(Fridge fridge) {
        entityManager.persist(fridge);
    }

    @Override
    @Transactional
    public void update(Fridge fridge) {
        entityManager.merge(fridge);
    }
}
