package com.makingdevs.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ProjectController {

  @RequestMapping("/projects")
  String index(Model model) {
    model.addAttribute("message", "Welcome to projects manager!")
    "projects/index"
  }

}
