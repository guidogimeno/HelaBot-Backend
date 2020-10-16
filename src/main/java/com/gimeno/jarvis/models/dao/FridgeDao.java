package com.gimeno.jarvis.models.dao;

import com.gimeno.jarvis.models.Fridge;
import com.gimeno.jarvis.models.exceptions.FridgeNotFoundException;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/*@Repository
public class FridgeDao implements IFridgeDao {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public Fridge get(long id) {
        Fridge fridge = entityManager.find(Fridge.class, id);
        if (fridge == null) throw new FridgeNotFoundException();
        return fridge;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Fridge> getAll() {
        return entityManager.createQuery("from Fridge").getResultList();
    }

    @Override
    public void save(Fridge fridge) {
        entityManager.persist(fridge);
    }

    @Override
    public void update(Fridge fridge) {
        entityManager.merge(fridge);
    }

    @Override
    public void delete(long id) {
        throw new NotImplementedException();
    }
}*/
