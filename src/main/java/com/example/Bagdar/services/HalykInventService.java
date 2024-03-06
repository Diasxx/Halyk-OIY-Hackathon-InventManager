package com.example.Bagdar.services;
import com.example.Bagdar.entities.*;

import java.util.List;

public interface HalykInventService {

    Person getPersonByLoginAndAndPassword(String login,String password);
    List<ItemType> getAllItemTypes();

    Person getPerson(Long id);
    Department getDepartment(Long id);

    Room getRoom(Long id);

    QuantityCount getQuantityCount(Long id);

    QuantityCount saveQuantity(QuantityCount quantityCount);

    Item getItem(Long id);
    List<QuantityCount> getAllQuantity();
    Long getCount();

    List<Item> getAllItems();

/*    Item getItemsByTypeIs(Long id);*/

}
