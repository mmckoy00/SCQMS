package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="supervisor_tbl")
@PrimaryKeyJoinColumn
public class Supervisor extends User
{

	private static final long serialVersionUID = 1L;
	
	public Supervisor() {
		
	}

	public Supervisor(String id, String password, String firstName, String lastName, Role role) {
		super(id, password, firstName, lastName, role);
	}
	
	
	
/*
	private User supervisor;
	/*private String userName;
	private String firstName;
	private String lastName;
	private String password;*/
/*	
	private Connection supConn;
	private Statement statement;
	private ResultSet result;
	
*/
	
/*
	//DEFAULT CONST.
	public Supervisor()
	{
		supConn = SupConnector.getDBConnection();
	}
	
	public void AddSupervisor(String userName, String firstName, String lastName, String password)
	{
		//build a sql query that inserts a new student into the database and executes
		String addSupervisor = " INSERT INTO supervisor.supervisors (userName, firstName, lastName, password) "
							 + "VALUES('"+ userName +" ', '"+firstName+ "' , '"+lastName+ "' , '" +password+ "');";	 //identifying the database that connection is being made to
		
		
		try {
			//using the connection to execute the insert
			statement = supConn.createStatement();
			int add = statement.executeUpdate(addSupervisor);
			if (add == 1)//once insertion occurred
			{
				JOptionPane.showMessageDialog(null, "Supervisor was Added",
						"Insertion Status", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		catch(SQLIntegrityConstraintViolationException ic)
		{
			System.err.println("Record Already Exist."+ic.getMessage());
		}
		catch(SQLException sql){
			
			sql.printStackTrace();
		}
		catch(Exception e){
			e.getMessage();
		}
						
	}
	*/
	
	/*
	public void ReadAll()
	{
		//reading all students from the database
		String selectSQL = "SELECT userName, firstName, lastName, password "
						 + "FROM supervisor.supervisors";
		
		try {
			//statement object
			statement = supConn.createStatement();
			result = statement.executeQuery(selectSQL);
			
			//iteration to print result
			while(result.next())
			{
				//extracting data from the current row using col names
				String userName = result.getString("userName");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String password = result.getString("password");
				
				System.out.println("User Name: "+userName+ "\nName: "+firstName+" "+lastName+"\nPassword: "+password);
			}
		}
		catch(SQLException sql) {
			System.out.println("SQL Exception occurred");sql.printStackTrace();
		}
		catch(Exception e) {
			System.err.println("Some Exception occurred" +e.getMessage());
		}
	}
	
	*/
	
	/*
	//build a SQL query that updates password based on userName 
	public void Update(String userName, String password)
	{
		String updateSQL = "UPDATE supervisor.supervisors "
						  + "SET password = '" +password+ 
						    " ' WHERE userName = ' "+userName+ " ' ";
		try {
			//statement object
			statement = supConn.createStatement();
		
			//tells us how many rows will be affected by the update
			int updated = statement.executeUpdate(updateSQL);
			
			if(updated == 0)
			{
				JOptionPane.showMessageDialog(null, "Issues Updating Record",
						"Record Update Status", JOptionPane.ERROR_MESSAGE);
				
			}
			else
			JOptionPane.showMessageDialog(null, "Updating Record was a Success!!",
					"Record Update Status", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch(SQLException sql) {
			System.err.println("UPDATE Failed"+sql.getMessage());
		}
		catch(Exception err) {
			err.printStackTrace();;
		}
	}
	
	*/
	
	/*
	//USING THE ID TO DELETE A STUDENT
	public void Delete(String userName)
	{
		//* means 'ALL'
		String deleteSQL = "DELETE userName, firstName, lastName, password "
						 + "FROM supervisor.supervisors "
						 + "WHERE userName = ' "+userName+ " '";
		
		try {
			//statement object
			statement = supConn.createStatement();
			int deleted = statement.executeUpdate(deleteSQL);
			
			if(deleted == 0)
			{
				JOptionPane.showMessageDialog(null, "Issues Deleting Record",
						"Record Deletion Status", JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null, " Record Deletion was Success!!",
					"Record Deletion Status", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		catch(SQLException sql) {
			System.err.println("Record Failed to DELETE"+sql.getMessage());
		}
		catch(Exception err) {
			err.printStackTrace();;
		}
	}
	*/
}

