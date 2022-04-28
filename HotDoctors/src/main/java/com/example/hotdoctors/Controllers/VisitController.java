package com.example.hotdoctors.Controllers;

import com.example.hotdoctors.Visit.VisitServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor @RequestMapping("/visit")
public class VisitController {

    private final VisitServiceImpl visitServiceImpl;


}
