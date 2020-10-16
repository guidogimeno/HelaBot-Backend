package com.gimeno.jarvis.models.service;

import com.gimeno.jarvis.models.GroceryProduct;
import com.gimeno.jarvis.models.dao.IGroceryProductDao;
import com.gimeno.jarvis.models.exceptions.GroceryProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GroceryProductService implements IGroceryProductService {

    @Autowired
    private IGroceryProductDao groceryProductDao;

    @Override
    @Transactional
    public GroceryProduct get(long id) {
        return groceryProductDao.findById(id).orElseThrow(GroceryProductNotFoundException::new);
    }

    @Override
    @Transactional
    public List<GroceryProduct> getAll() {
        return (List<GroceryProduct>) groceryProductDao.findAll();
    }

    @Override
    @Transactional
    public void save(GroceryProduct groceryProduct) {
        groceryProductDao.save(groceryProduct);
    }

    @Override
    @Transactional
    public void delete(long id) {
        groceryProductDao.deleteById(id);
    }

    @Override
    @Transactional
    public GroceryProduct findByBarCode(long barCode) {
        return groceryProductDao.findByBarCode(barCode);
    }
}
