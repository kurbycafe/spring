package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","helloo");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name , Model model){
        model.addAttribute("name" ,name);
        return "hello-template";

    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name , Model model){
        //model.addAttribute("name" ,name);
        return "hello"+name;

    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //return is jason {name:helloitsSpring }
        //return 시 string 은 그냥 반환
        //객체이면 json 형식으로
        //(httpMessageConverter) 동작
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
