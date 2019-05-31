package com.example.labka.controller;

import com.example.labka.service.impl.MemPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    private final MemPostService memPostService;

    public PostController(MemPostService memPostService) {
        this.memPostService = memPostService;
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String query){
        model.addAttribute("posts",memPostService.search(query));
        return "index";
    }
}
