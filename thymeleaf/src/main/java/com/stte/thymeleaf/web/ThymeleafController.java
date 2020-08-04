package com.stte.thymeleaf.web;

import com.stte.thymeleaf.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * create by BloodFly at 2018/12/12
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/")
    public String index(Model model) {
        Person single = new Person("aa", 11);
        List<Person> people = new ArrayList<>();
        people.add(new Person("xx", 12));
        people.add(new Person("yy", 22));
        people.add(new Person("zz", 33));

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }
}
