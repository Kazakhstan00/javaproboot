package kz.bitlab.javapro.javaproboot.task1.t1;

import kz.bitlab.javapro.javaproboot.t1.Item;

import java.util.ArrayList;

public class DBM {

    private static ArrayList<Items> items = new ArrayList<>();
    private static Long id = 6L;

    static {
        items.add(new Items(1L, "MacBook", "Classic", 750000));
        items.add(new Items(2L, "MacBook", "Classic", 750000));
        items.add(new Items(3L, "MacBook", "Classic", 750000));
        items.add(new Items(4L, "MacBook", "Classic", 750000));
        items.add(new Items(5L, "MacBook", "Classic", 750000));
        items.add(new Items(6L, "MacBook", "Classic", 750000));
    }

    public static ArrayList<Items> getAllItems(){
        return items;
    }

    public static void addItems(Items item){
        item.setId(id);
        items.add(item);
        id++;
    }

    public static Items getItems(Long id){
        return items.stream()
                .filter(items1 -> items1.getId() == id)
                .findFirst().orElse(null);
    }
}
