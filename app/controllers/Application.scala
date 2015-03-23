package controllers


import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.{Student,Music,Sports}

object Application extends Controller {

  def studentForm = Form(mapping("First Name" -> nonEmptyText,
    "Last Name"->nonEmptyText,
    "Music" -> optional(boolean),
    "Sports"-> optional(boolean))
    (Student.apply)(Student.unapply))

  def MusicForm = Form(mapping("reasons" -> nonEmptyText)
    (Music.apply)
    (Music.unapply))



  def SportsForm = Form(mapping("reasons" -> nonEmptyText)
    (Sports.apply)
    (Sports.unapply))

  def index = Action {
    Ok(views.html.index(studentForm))
  }

  def music = Action {
    Ok(views.html.musicView(MusicForm))
  }


  def createStudent = Action {

    implicit request => studentForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.index(formWithErrors)),
      student => Ok(views.html.submittedOk(student))
    )
  }

  def musicStuff = Action {

    implicit request => MusicForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.musicView(formWithErrors)),
      music => Ok(views.html.musicStuff(music))
    )
  }

  def sportsStuff = Action {

    implicit request => SportsForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.sportsView(formWithErrors)),
      sports => Ok(views.html.sportsStuff(sports))
    )
  }

  def ngTest = Action {
      ngTest => Ok(views.html.ngTest())
  }

  def reactTest = Action {
    react =>Ok(views.html.reactTest())
  }



}