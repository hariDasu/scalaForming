package controllers


import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.{Student,Music,Sports,React}

object Application extends Controller {

  def studentForm = Form(mapping("First Name" -> nonEmptyText,
    "Last Name"->nonEmptyText,
    "Music" -> optional(boolean),
    "Sports"-> optional(boolean))
    (Student.apply)(Student.unapply))

  def MusicForm = Form(mapping("reasons" -> nonEmptyText)
    (Music.apply)
    (Music.unapply))

  def ReactForm = Form(mapping("react"->nonEmptyText)(React.apply)(React.unapply))

  def SportsForm = Form(mapping("reasons" -> nonEmptyText)
    (Sports.apply)
    (Sports.unapply))

  def index = Action {
    Ok(views.html.index(studentForm))
  }

  def music = Action {
    Ok(views.html.musicView(MusicForm))
  }

 /* def postMusic = Action {
    if (Student.){
      Ok(views.html.Music(studentForm))
    }else Ok(views.html.index(studentForm))

  }*/

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

  def react = Action {
      react => Ok(views.html.react())
  }

    /*
      def doLogin = Action {
        implicit request => val loginRequest = loginForm.bindFromRequest.get
          Ok(s"username: '${loginRequest.username}',password: '${loginRequest.password}'")
      }

      def loginForm = Form(mapping("username" -> text, "password" -> text)(LoginRequest.apply)(LoginRequest.unapply))

      case class LoginRequest(username:String,password:String)

      def handleForm = Action(parse.tolerantFormUrlEncoded) {
        implicit request =>
          val username = request.body.get("username").map(_.head).getOrElse("");
          Ok(views.html.showUserName(username))
      }*/

  //Implicit conversion
  /*
  def handleForm = Action(parse.tolerantFormUrlEncoded) {
    implicit request => val username = request.get("username");
      Ok(views.html.showUserName(username))
  }*/

}