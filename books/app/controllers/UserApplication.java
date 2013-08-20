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
		Form<Member> memberForm = Form.form(Member.class);
		return ok(
				login.render(memberForm)
	        );   	
    }
	
	public static boolean existsMember(String memberId,String password)
    {
    	Member member = Member.getMember(memberId);
    	if(member==null) return false;
    	return member.password.equals(password);
    }
	
	public static Result auth() {
		Form<Member> memberForm = Form.form(Member.class).bindFromRequest();
		Member member = memberForm.get();
		
    	return BookApplication.showBookList(0, "title", "asc", "");
    }

}
