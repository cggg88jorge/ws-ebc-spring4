package com.makingdevs.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import com.makingdevs.repositories.ProjectRepository

@Controller
class ProjectController {

  @Autowired
  ProjectRepository projectRepository

  @RequestMapping("/projects")
  String index(Model model) {
    model.addAttribute("message", "Welcome to projects manager!")
    model.addAttribute("projects", projectRepository.findAll())
    "projects/index"
  }

}
