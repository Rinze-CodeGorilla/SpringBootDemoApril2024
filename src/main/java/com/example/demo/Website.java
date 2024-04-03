package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Website {

    @GetMapping("/hallo")
    public ResponseEntity<String> hallo() {
        return ResponseEntity.badRequest().body("Hallo");
    }

    @GetMapping("/template")
    public String template(Model model, @RequestParam(required = false) String name) {
        System.out.println("template method");
        LoggerFactory.getLogger(Website.class).info("template method");
        if (name == null)
            name = "Vreemdeling";
        model.addAttribute("name", name);
        return "voorbeeld";
    }
}
