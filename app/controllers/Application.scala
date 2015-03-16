package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.{Hobbies, Student}

object Application extends Controller {

  def studentForm = Form(mapping("First Name" -> nonEmptyText, "Last Name"->nonEmptyText,"Music" -> optional(nonEmptyText), "Sports"->optional(nonEmptyText))(Student.apply)(Student.unapply))



  def index = Action {
    Ok(views.html.index(studentForm))
  }

  def createStudent = Action {

    implicit request => studentForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.index(formWithErrors)),
      student => Ok(views.html.submittedOk(student))
    )
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