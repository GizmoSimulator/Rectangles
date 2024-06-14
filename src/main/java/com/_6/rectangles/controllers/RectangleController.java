package com._6.rectangles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import com._6.rectangles.models.Rectangle;
import com._6.rectangles.models.RectangleRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@Controller
public class RectangleController {
    @Autowired
    private RectangleRepository rectRepo;

    @GetMapping("/rectangles/view")
    public String getAllRectangles(Model model) {
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
    public String addRectangle(@RequestParam Map<String, String> newRectangle, HttpServletResponse response) {
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

    @GetMapping("/rectangle/{uid}")
    public String viewRectangleDetails(@PathVariable("uid") Integer uid, Model model) {
        // Retrieve the rectangle details from the database using the provided ID
        Rectangle rectangle = rectRepo.findByUid(uid);

        if (rectangle == null) {
            throw new IllegalArgumentException("Invalid rectangle UID: " + uid);
        }

        // Add the rectangle object to the model to be displayed on the details page
        model.addAttribute("rectangle", rectangle);

        // Return the name of the Thymeleaf template for the rectangle details page
        return "rectangles/rectangleDetails";
    }

    // Added and imported transactional so deleteRectangle works,
    // or else gives NoEntityManager error
    @Transactional
    @PostMapping("/deleteRectangle")
    public String deleteRectangle(@RequestParam("uid") String uidStr) {
        try {
            Integer uid = Integer.parseInt(uidStr);
            rectRepo.deleteByUid(uid);
            System.out.println("Deleting rectangle with UID: " + uid);
        } catch (NumberFormatException e) {
            System.out.println("Invalid UID format: " + uidStr);
        }
        return "redirect:/rectangles/view"; // Redirect to the view page after deletion
    }

    @PostMapping("/updateRectangle")
    public String updateRectangle(@RequestParam("uid") String uidStr,
                                  @RequestParam("name") String name,
                                  @RequestParam("height") String heightStr,
                                  @RequestParam("width") String widthStr,
                                  @RequestParam("color") String color
    ) {
        try {
            // Retrieve the rectangle from the database
            Integer uid = Integer.parseInt(uidStr);
            Double height = Double.parseDouble(heightStr);
            Double width = Double.parseDouble(widthStr);
            Rectangle rectangle = rectRepo.findByUid(uid);
    
            // Update the attributes
            rectangle.setName(name);
            rectangle.setHeight(height);
            rectangle.setWidth(width);
            rectangle.setColor(color);
            // Update other attributes similarly
    
            // Save the updated rectangle
            rectRepo.save(rectangle);
    
            return "redirect:/rectangle/" + uidStr; // Reload
        } catch (Exception e) {
            return "errorPage"; // Will give an error page.
        }
    }
    
}
