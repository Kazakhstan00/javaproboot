package kz.bitlab.javapro.javaproboot.t1;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Long id;
    private String name;
    private int amount;
    private double price;
}
