package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id" }) })
public class User extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Constraints.Required
	public String user_id;
	
	@Constraints.Required
	public String user_name;
	
	@Constraints.Required
	public String password;
	
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date createDate;
	
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date updateDate;
	
	public String toString(){
		return user_name;
	}
	
	/**
     * Generic query helper for entity Computer with id Long
     */
    public static Finder<Integer,User> find = new Finder<Integer,User>(Integer.class, User.class); 
    
    public static Page<User> page(int page, int pageSize, String sortBy, String order, String filter) {
        
    	return 
                find.where()
                    .ilike("name", "%" + filter + "%")
                    .orderBy(sortBy + " " + order)
                    .findPagingList(pageSize)
                    .getPage(page);    	
    }
    
	

}
