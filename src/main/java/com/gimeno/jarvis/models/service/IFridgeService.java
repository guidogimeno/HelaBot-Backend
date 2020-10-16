package com.gimeno.jarvis.models.service;

import com.gimeno.jarvis.models.Fridge;

import java.util.List;

public interface IFridgeService {
    Fridge get(long id);

    List<Fridge> getAll();

    void save(Fridge fridge);

    void delete(long id);
}
