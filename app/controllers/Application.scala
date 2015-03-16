package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Customer

object Application extends Controller {

  def customerForm = Form(mapping("Customer Name" -> nonEmptyText, "Credit Limit"->number(min=0,max=100000))(Customer.apply)(Customer.unapply))

  def index = Action {
    Ok(views.html.index(customerForm))
  }

  def createCustomer = Action {
    implicit request => customerForm.bindFromRequest().fold(
      formWithErrors => BadRequest(views.html.index(formWithErrors)),
      customer => Ok(views.html.submittedOk(customer))
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