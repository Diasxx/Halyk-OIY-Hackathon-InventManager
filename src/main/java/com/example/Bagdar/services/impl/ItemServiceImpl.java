package com.example.Bagdar.services.impl;

import com.example.Bagdar.entities.*;
import com.example.Bagdar.repositories.*;
import com.example.Bagdar.services.HalykInventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements HalykInventService {
    @Autowired
    private ItemTypeRepository itemTypeRepository;

    @Autowired
    private QuantityCountRepository quantityCountRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public QuantityCount saveQuantity(QuantityCount quantityCount) {
        return quantityCountRepository.save(quantityCount);
    }

    @Override
    public QuantityCount getQuantityCount(Long id) {
        return quantityCountRepository.getOne(id);
    }

    @Override
    public Item getItem(Long id) {
        return itemRepository.getOne(id);
    }

    @Override
    public List<ItemType> getAllItemTypes() {
        return itemTypeRepository.findAll();
    }

    @Override
    public Person getPerson(Long id) {
        return personRepository.getOne(id);
    }

    @Override
    public Department getDepartment(Long id) {
        return getDepartment(id);
    }

    @Override
    public Room getRoom(Long id) {
        return roomRepository.getOne(id);
    }

    @Override
    public Person getPersonByLoginAndAndPassword(String login, String password) {
        return personRepository.getPersonByLoginAndAndPassword(login, password);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Long getCount() {
        return itemRepository.count();
    }

    @Override
    public List<QuantityCount> getAllQuantity() {
        return quantityCountRepository.findAll();
    }
}
