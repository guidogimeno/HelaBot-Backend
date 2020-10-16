package com.gimeno.jarvis.models.dao;

import com.gimeno.jarvis.models.GroceryProduct;
import com.gimeno.jarvis.models.exceptions.GroceryProductNotFoundException;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

/*@Repository
public class GroceryProductDao implements IDao<GroceryProduct> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public GroceryProduct get(long id) {
        throw new NotImplementedException();
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
        throw new NotImplementedException();
    }

    @Override
    public void update(GroceryProduct product) {
        throw new NotImplementedException();
    }

    @Transactional
    public GroceryProduct findByBarCode(long barCode) {
        try {
            TypedQuery<GroceryProduct> query = entityManager.createQuery(
                    "from GroceryProduct p where p.barCode = :barCode" , GroceryProduct.class);
            query.setParameter("barCode", barCode);
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new GroceryProductNotFoundException();
        }
    }

    @Override
    @Transactional
    public void delete(long id) {
        throw new NotImplementedException();
    }
}*/
