package kz.bitlab.javapro.javaproboot.task1.t1;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {

    private Long id;
    private String name;
    private String description;
    private double price;

}
