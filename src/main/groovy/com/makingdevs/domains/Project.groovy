package com.makingdevs.domains

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@Table(name = "project")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id

  String name

  String codeName

  String description

  @Override
  public String toString() {
    return "Project [id=$id, name=$name, codeName=$codeNam, description=$description]"
  }

}
