package com.makingdevs

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class AppController {

  @ResponseBody
  @RequestMapping(value = "/", method = RequestMethod.GET)
  String helloWorld() {
    return "Hello World: Spring MVC without XML configuration"
  }
}
