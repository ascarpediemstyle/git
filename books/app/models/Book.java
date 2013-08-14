package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;


@Entity
public class Book extends Model{
	
	private static final long serialVersionUID = 1L;

	@Id
	public int book_id;
	
	@Constraints.Required
	public String title;
	
	@Column
	public String amazonLink;
	
	@Column
	public String memo;
	
	@Column
	public String comment;
	
	@Column
	public int rating;
	
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date createDate;
	
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date updateDate;
	
	public String toString(){
		return title;
	}
	
	/**
     * Generic query helper for entity Computer with id Long
     */
    public static Finder<Integer,Book> find = new Finder<Integer,Book>(Integer.class, Book.class); 
    
	
	/**
     * Return a page of computer
     *
     * @param page Page to display
     * @param pageSize Number of computers per page
     * @param sortBy Computer property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the name column
     */
    public static Page<Book> page(int page, int pageSize, String sortBy, String order, String filter) {
        
    	return 
                find.where()
                    .ilike("title", "%" + filter + "%")
                    .orderBy(sortBy + " " + order)
                    .findPagingList(pageSize)
                    .getPage(page);
    	
    }
    
    
    
//    public static Map<String,String> options() {
//        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
//        for(Book b: Book.find.orderBy("title").findList()) {
//            options.put(b.book_id.toString(), b.title);
//        }
//        return options;
//    }

}
