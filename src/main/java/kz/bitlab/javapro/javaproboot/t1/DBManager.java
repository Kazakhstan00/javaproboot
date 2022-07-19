package kz.bitlab.javapro.javaproboot.t1;

import kz.bitlab.javapro.javaproboot.t1.Item;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Item> items = new ArrayList<>();
    private static Long id = 5L;

    static {
        items.add(new Item(1L, "iPhone 13 Pro", 40, 450000));
        items.add(new Item(2L, "iPhone 12 Pro", 30, 350000));
        items.add(new Item(3L, "iPhone 11 Pro", 20, 300000));
        items.add(new Item(4L, "iPhone 10 Pro", 10, 250000));
    }

    public static ArrayList<Item> getAllItems(){
        return items;
    }

    public static void addItem(Item item){
        item.setId(id);
        items.add(item);
        id++;
    }

    public static Item getItem(Long id){
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst().orElse(null) ;
    }
}
