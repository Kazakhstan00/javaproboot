package kz.bitlab.javapro.javaproboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "car_name", length = 100)
    private String name;

    @Column(name = "car_model", columnDefinition = "TEXT")
    private String model;

    @Column(name = "car_price")
    private int price;

    @Column(name="engine_volume")
    private double engineVolume;
}
