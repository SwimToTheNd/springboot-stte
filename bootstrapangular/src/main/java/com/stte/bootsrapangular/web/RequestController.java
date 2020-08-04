package com.stte.bootsrapangular.web;

import com.stte.bootsrapangular.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * create by BloodFly at 2018/12/26
 */
@RestController
public class RequestController {

    @GetMapping("/search")
    public Person search(String personName) {
        return new Person(personName, new Random().nextInt(100), "beijing");
    }
}
