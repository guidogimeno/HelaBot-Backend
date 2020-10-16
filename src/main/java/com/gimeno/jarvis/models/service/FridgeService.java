package com.gimeno.jarvis.models.service;

import com.gimeno.jarvis.models.Fridge;
import com.gimeno.jarvis.models.dao.IFridgeDao;
import com.gimeno.jarvis.models.exceptions.FridgeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FridgeService implements IFridgeService {

    @Autowired
    private IFridgeDao fridgeDao;

    @Override
    @Transactional
    public Fridge get(long id) {
        return fridgeDao.findById(id).orElseThrow(FridgeNotFoundException::new);
    }

    @Override
    @Transactional
    public List<Fridge> getAll() {
        return (List<Fridge>) fridgeDao.findAll();
    }

    @Override
    @Transactional
    public void save(Fridge fridge) {
        fridgeDao.save(fridge);
    }

    @Override
    @Transactional
    public void delete(long id) {
        fridgeDao.deleteById(id);
    }
}
