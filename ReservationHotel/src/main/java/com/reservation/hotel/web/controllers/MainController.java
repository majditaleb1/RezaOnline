package com.reservation.hotel.web.controllers;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView; 
@Controller 
public class MainController { 
@RequestMapping("index.htm") 
public ModelAndView main() { 
ModelAndView mov = new ModelAndView(); 
mov.setViewName("main"); 
return mov; 
} 
}