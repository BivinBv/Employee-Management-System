package emp_management_sys;
import java.sql.*;
class Empmng
{
	private static Connection getconnection() throws Exception
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/emp_management";
		String uname="root";
		String pass="root";
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,uname,pass);
		return con;
	}
//----------------------------------Add an employee dlts-----------------------------------------------------------------------------------	
	void insert()
	{
		try
		{
		int status=0;
		String query="insert into basic_details(first_name,last_name,Designation,Official_address,Mobile_number,Add_date)values(?,?,?,?,?,CURDATE())";
		PreparedStatement ps=getconnection().prepareStatement(query);
		ps.setString(1, "Deepak");
		ps.setString(2, "Nair");
		ps.setString(3, "Software Tester");
		ps.setString(4, "Canada Turn");
		ps.setString(5, "9375628476");
		status=ps.executeUpdate();
		if(status>0)
		{
			System.out.println("Success in update");
		}
		else
		{
			System.out.println("failed to update");
		}
		
		}catch(Exception e) {System.out.println(e);}
	}
//----------------------------------------------------------------------------------------------------------------	
}
public class Employee_management {

	public static void main(String[] args) {
		Empmng e=new Empmng();
		e.insert();

	}

}
