package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def doLogin = Action {
    implicit request => val loginRequest = loginForm.bindFromRequest.get
      Ok(s"username: '${loginRequest.username}',password: '${loginRequest.password}'")
  }

  def loginForm = Form(mapping("username" -> text, "password" -> text)(LoginRequest.apply)(LoginRequest.unapply))

  case class LoginRequest(username:String,password:String)
  /*
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