package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class boardController {
    @GetMapping("/boardList")
    public String boardList(Model model ) throws Exception{ 

        return "boardList";
    }
}
