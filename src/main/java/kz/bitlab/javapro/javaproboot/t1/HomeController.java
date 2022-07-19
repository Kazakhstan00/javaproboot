package kz.bitlab.javapro.javaproboot.t1;

import kz.bitlab.javapro.javaproboot.beans.SecondBean;
import kz.bitlab.javapro.javaproboot.beans.SomeBean;
import kz.bitlab.javapro.javaproboot.t1.DBManager;
import kz.bitlab.javapro.javaproboot.t1.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    private SomeBean someBean;

    @Autowired
    @Qualifier("secondBeanWithoutConstructor")
    private SecondBean secondBeanDanik;

    @GetMapping(value = "/test")
    public String testPage(Model model){

        String text = secondBeanDanik.getData();
        model.addAttribute("text", text);
        return "test";
    }

    @GetMapping(value = "/update")
    public String testPage(){
        someBean.setName("Arman");
        someBean.setAge(21);
        return "redirect:/test";
    }

    //doGet() @WebServlet("/")
    @GetMapping(value = "/asd")
    public String index(Model model){
        ArrayList<Item> items = DBManager.getAllItems();
        model.addAttribute("tovary", items); // request.setAttribute("tovary", items);
        return "index"; //request.getRequestDispatcher("/indexpage.html").forward(request, responce);
    }


    @PostMapping(value = "/additem")
    public String addItem(@RequestParam(name = "item_name") String name,
                          @RequestParam(name = "item_price") double price, // double price = Double.parseDouble(request.getParameter("item_price")
                          @RequestParam(name = "item_amount") int amount){

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setAmount(amount);

        DBManager.addItem(item);

        return "redirect:/"; //responce.sendRedirect("/")

    }

    @GetMapping(value = "/details/{itemId}")
    public String detailsPage(@PathVariable(name = "itemId") Long id,
                              Model model){
        Item item = DBManager.getItem(id);
        model.addAttribute("tovarbek", item);
        return "details";
    }

    @GetMapping(value = "/additem")
    public String addItem(Model model){
        return "additem";
    }
}
