package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.Constraint;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

public class Column extends Model{
	
	@Id
	public int column_id;
	
	@Constraints.Required
	public String title;
	

}
