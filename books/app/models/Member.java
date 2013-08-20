package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "member_id" }) })
public class Member extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Constraints.Required
	public String member_id;
	
	@Constraints.Required
	public String member_name;
	
	@Constraints.Required
	public String password;
	
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date createDate;
	
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date updateDate;
	
	public String toString(){
		return member_name;
	}
	
	/**
     * Generic query helper for entity Computer with id Long
     */
    public static Finder<String,Member> find = new Finder<String,Member>(String.class, Member.class); 
    
    public static Page<Member> page(int page, int pageSize, String sortBy, String order, String filter) {
        
    	return 
                find.where()
                    .ilike("member_name", "%" + filter + "%")
                    .orderBy(sortBy + " " + order)
                    .findPagingList(pageSize)
                    .getPage(page);    	
    }
    
    public static Member getMember(String memberId)
    {
    	List<Member> members = find.where().eq("member_id", memberId).query().findList();
    	
    	if(members.size() == 1){
    		return members.get(0);
    	}
    	else{
    		return null;
    	}                    
    }
    
	

}
