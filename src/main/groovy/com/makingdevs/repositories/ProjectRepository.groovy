package com.makingdevs.repositories

import org.springframework.data.repository.CrudRepository

import com.makingdevs.domains.Project

interface ProjectRepository extends CrudRepository<Project, Long> { }
