package com.example.Bagdar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

// todo Make this
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "last_checked_date")
    private LocalDate lastCheckedDate;

    @Column(name = "state")
    private String state;

    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    private ItemType type;

    @OneToOne(fetch = FetchType.EAGER)
    private QuantityCount quantityCount;

}