package kz.bitlab.javapro.javaproboot.task1.t1;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main {

    private Items items;

    @GetMapping(value = "/shop")
    public String shopPage(Model model){
        model.addAttribute("tovar", items);
        return "shop";
    }
}
