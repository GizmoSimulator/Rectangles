package com._6.rectangles.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com._6.rectangles.models.Rectangle;
import java.util.ArrayList;
import java.util.List;


@Controller
public class RectangleController {
    @GetMapping("/rectangles/view")

    public String getAllRectangles(Model model)
    {
        System.out.println("Getting all rectangles");
        //TODO: get all rectangles from database
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle("Hello", 0, 0, "BLUE"));
        rectangles.add(new Rectangle("Non", 20, 30, "RED"));
        // end of database call

        model.addAttribute("re", rectangles);

        return "rectangles/showAll";
    }








    
}
