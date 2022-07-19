package kz.bitlab.javapro.javaproboot.controllers;


import kz.bitlab.javapro.javaproboot.beans.SomeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @Autowired
    private SomeBean someBean;

    @GetMapping(value = "/test2")
    public String test2(Model model){
        model.addAttribute("text", someBean.getConnection());
        return "test2";
    }
}
