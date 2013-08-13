package controllers;

import play.*;

import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import views.html.*;

import models.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result showBookList(int page, String sortBy, String order, String filter) {
        
    	return ok(
                bookList.render(
                    Book.page(page, 10, sortBy, order, filter),
                    sortBy, order, filter
                )
            );
    }
    
public static Result showAllBookList() {
        
    	return showBookList(0,"title","desc","");
    }
    

    /**
     * Display the 'new computer form'.
     */
    public static Result createBook() {
        Form<Book> bookForm = Form.form(Book.class);
        return ok(
            bookCreateForm.render(bookForm)
        );
    }  
    
    /**
     * Display the 'edit form' of a existing Computer.
     *
     * @param id Id of the computer to edit
     */
    public static Result editBook(int id) {
        Form<Book> bookForm = Form.form(Book.class).fill(
        		Book.find.byId(id)
        );
        return ok(
            bookEditForm.render(id, bookForm)
        );
    }

}
