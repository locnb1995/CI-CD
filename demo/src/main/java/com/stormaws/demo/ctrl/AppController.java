package com.stormaws.demo.ctrl;

import com.stormaws.demo.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {


    @RequestMapping(method = RequestMethod.GET
            , value = "index"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> index(){
        Person person = new Person();
        person.setName("Nguyen Bao loc");
        person.setAge(29);
        person.setHometown("Tien Hai, Thai Binh");
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET , value = "health")
    public String health(){
        return "OK";
    }

}
