package com.sda.cargo_project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "cargo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "item_type", nullable = false)
    private String itemType;

    @Column(name = "item_weight", nullable = false)
    private String itemWeight;

    @Column(name = "item_category", nullable = false)
    private String itemCategory;

    @Column(name = "from_location", nullable = false)
    private String fromLocation;

    @Column(name = "to_location", nullable = false)
    private String toLocation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
