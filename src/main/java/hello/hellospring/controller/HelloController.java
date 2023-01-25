package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("gym")
    public String hello(Model model) {
        model.addAttribute("data","healthbaby!!");
        return "gym";
    }

    @GetMapping("fight-club")
    public String fightClub(@RequestParam(value = "martial", required = true) String martial, Model model) {
        model.addAttribute("martial", martial);
        return "fight-skill";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return  "hello " + name; //"hello spring" 데이터를 view 없이 그대로 내려줌
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
