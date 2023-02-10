/*
 * Class below is the controller for the Home Page for the / route 
 */

package com.cpan228.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// annotation packages imported 

@Controller
@RequestMapping("/")
public class HomeController {

  @RequestMapping
  public String home() {
    return "home";
  }

}
