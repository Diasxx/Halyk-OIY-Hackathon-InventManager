package com.example.Bagdar.Controller;
import com.example.Bagdar.entities.*;
import com.example.Bagdar.services.HalykInventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private HalykInventService halykInventService;


    @GetMapping("/")
    public String login(){
        return "loginpage";
    }

    @GetMapping("/mainpage/roombydepart/checkpage/{id}")
    public String check(Model model,@PathVariable(name = "id") Long id ){

        Person person = halykInventService.getPerson(id);
        Department department = person.getDepartment();
        Room room = halykInventService.getRoom(department.getId());
        List<ItemType> itemTypes = halykInventService.getAllItemTypes();
        List<Item> items = halykInventService.getAllItems();

        List<QuantityCount> quantityCounts = halykInventService.getAllQuantity();

        model.addAttribute("itemTypes",itemTypes);

        model.addAttribute("person",person);
        model.addAttribute("depo",department);

        model.addAttribute("room",room);
        model.addAttribute("items",items);

        model.addAttribute("quantityCounts",quantityCounts);


        return "checkpage";
    }

    @GetMapping("/mainpage/roombydepart/checkpageperson/{id}")
    public String checkPerson(Model model,@PathVariable(name = "id") Long id ){

        Person person = halykInventService.getPerson(id);
        Department department = person.getDepartment();
        Room room = halykInventService.getRoom(department.getId());
        List<ItemType> itemTypes = halykInventService.getAllItemTypes();
        List<Item> items = halykInventService.getAllItems();

        List<QuantityCount> quantityCounts = halykInventService.getAllQuantity();

        model.addAttribute("itemTypes",itemTypes);

        model.addAttribute("person",person);
        model.addAttribute("depo",department);

        model.addAttribute("room",room);
        model.addAttribute("items",items);

        model.addAttribute("quantityCounts",quantityCounts);


        return "checkpage";
    }

    @GetMapping("/mainpage/{id}")
    public String main(Model model,@PathVariable(name = "id") Long id ){

        Person person = halykInventService.getPerson(id);
        model.addAttribute("person",person);

        return "mainpage";
    }

    @GetMapping("/mainpage/roombydepart/{id}")
    public String roomByDepart(Model model,@PathVariable(name = "id") Long id ){

        Person person = halykInventService.getPerson(id);
        Department department = person.getDepartment();
        Room room = halykInventService.getRoom(department.getId());
        List<ItemType> itemTypes = halykInventService.getAllItemTypes();
        List<Item> items = halykInventService.getAllItems();

        model.addAttribute("itemTypes",itemTypes);

        model.addAttribute("person",person);
        model.addAttribute("depo",department);

        model.addAttribute("room",room);
        model.addAttribute("items",items);

        return "/roombydepart";
    }


    @GetMapping("/mainpage/personbydepart/{id}")
    public String personByDepart(Model model,@PathVariable(name = "id") Long id ){

        Person person = halykInventService.getPerson(id);
        Department department = person.getDepartment();
        Room room = halykInventService.getRoom(department.getId());
        List<ItemType> itemTypes = halykInventService.getAllItemTypes();
        List<Item> items = halykInventService.getAllItems();

        model.addAttribute("itemTypes",itemTypes);

        model.addAttribute("person",person);
        model.addAttribute("depo",department);

        model.addAttribute("room",room);
        model.addAttribute("items",items);

        return "/personbydepart";
    }




    @PostMapping("/updeteQuantity/{id}")
    public String additem(@RequestParam(name = "item_id") Long id,@PathVariable(name = "id") Long personid){

        QuantityCount quantityCount = halykInventService.getQuantityCount(id);

        quantityCount.setQuantity(quantityCount.getQuantity()+1);

        halykInventService.saveQuantity(quantityCount);


        try {
            File myObj = new File("filename.txt");

            if (!myObj.exists()) {
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("Unable to create the file.");
                }
            } else {
                System.out.println("File already exists.");
            }

            Item item = halykInventService.getItem(id);

            Date date = new Date();

            // Append data to the file
            String data = item.getName() + " было проверено на количество 1 единицу из " + (quantityCount.getQuantity()) + " в " + date + "\n";
            Files.write(Paths.get(myObj.getPath()), data.getBytes(), StandardOpenOption.APPEND);

            System.out.println("Data has been written to the file.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return "redirect:/mainpage/roombydepart/checkpage/"+personid;
    }



    @PostMapping("/checklogin")
    public String checkLogin(@RequestParam(name = "login")String login,
                           @RequestParam(name = "password") String password){

        Person person = halykInventService.getPersonByLoginAndAndPassword(login,password);
        if(person!=null){
            return "redirect:/mainpage/"+person.getId();
        }

        return "redirect:/";
    }
}