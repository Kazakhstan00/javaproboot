package kz.bitlab.javapro.javaproboot.t1;

import lombok.*;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.List;
import java.util.function.Function;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Long id;
    private String name;
    private int amount;
    private double price;

    }


