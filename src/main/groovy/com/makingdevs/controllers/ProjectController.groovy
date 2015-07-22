package com.makingdevs.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import com.makingdevs.repositories.ProjectRepository
import org.springframework.jdbc.core.JdbcTemplate

@Controller
class ProjectController {

  @Autowired
  ProjectRepository projectRepository

  @Autowired
  JdbcTemplate jdbcTemplate

  @RequestMapping("/projects")
  String index(Model model) {
    model.addAttribute("message", "Welcome to projects manager!")

    def sessionKeys = jdbcTemplate.queryForList("SELECT * FROM SESSION_KEY")
    println sessionKeys

    model.addAttribute("projects", projectRepository.findAll())
    "projects/index"
  }

}
