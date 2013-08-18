package controllers;


import java.util.Date;

import play.*;

import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import views.html.*;

import models.*;

public class UserApplication extends Controller {
	
	public static Result login() {
		Form<User> userForm = Form.form(User.class);
		return ok(
				login.render(userForm)
	        );   	
    }
	
	public static Result auth() {
		Form<User> userForm = Form.form(User.class).bindFromRequest();
		User user = userForm.get();
		user.createDate = new Date();
		user.updateDate = new Date();
		user.save();		
		
    	return BookApplication.showBookList(0, "title", "asc", "");
    }

}
