package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;

// THIS WORKS OK
//    @GetMapping(value = "/whiskies")
//    public ResponseEntity<List<Whisky>> getAllWhisky(@RequestParam(name = "year", required = false)Integer year){
//        if (year !=null){
//            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }




//    @GetMapping(value = "/whiskies")
//    public ResponseEntity<List<Whisky>> getAllWhiskyByDistilleryAndAge(@RequestParam(name = "name", required = false)String name, @RequestParam(name = "age", required = false) Integer age){
//        if (name !=null){
//            return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryNameAndAge(name, age), HttpStatus.OK);
//        }
//        if (name !=null){
//            return new ResponseEntity<>(whiskyRepository.findByYear(year))
//        }
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }



//    merge two params and two methods.
    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskyByDistilleryNameAndAge(@RequestParam(name = "year", required = false)Integer year, @RequestParam(name = "name", required = false) String name, @RequestParam(name = "age", required = false) Integer age, @RequestParam(name = "region", required = false)String region) {
        if (year !=null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        if (name !=null && age != null){
            return new ResponseEntity<>(whiskyRepository.findWhiskiesByDistilleryNameAndAge(name, age), HttpStatus.OK);
        }
        if (region != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

}
