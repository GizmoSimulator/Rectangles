package com._6.rectangles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com._6.rectangles.models.Rectangle;
import com._6.rectangles.models.RectangleRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class RectangleController {
    @Autowired
    private RectangleRepository rectRepo;

    


    @GetMapping("/rectangles/view")
    public String getAllRectangles(Model model)
    {
        System.out.println("Getting all rectangles");
        // get all rectangles from database
        List<Rectangle> rectangles = rectRepo.findAll();

        // List<Rectangle> rectangles = new ArrayList<>();
        // rectangles.add(new Rectangle("Hello", 0, 0, "BLUE"));
        // rectangles.add(new Rectangle("Non", 20, 30, "RED"));
        // end of database call

        model.addAttribute("re", rectangles);

        return "rectangles/home";
    }


    @PostMapping("/rectangles/clear")
    public String clearRectangles() {
        rectRepo.deleteAll();
        return "redirect:/rectangles/view"; // Redirect to the home page or any other page as needed
    }

    @PostMapping("/rectangles/add")
    public String addRectangle(@RequestParam Map<String, String> newRectangle, HttpServletResponse response){
        System.out.println("Added Rectangle");
        String newName = newRectangle.get("name");
        double newHeight = Double.parseDouble(newRectangle.get("height"));
        double newWidth = Double.parseDouble(newRectangle.get("width"));
        String newColor = newRectangle.get("color");

        rectRepo.save(new Rectangle(newName, newWidth, newHeight, newColor));
        response.setStatus(201);

        // return "rectangles/addedRectangle";
        // return "home";

        return "redirect:/rectangles/view";
    }










    
}
