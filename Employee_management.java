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
}
public class Employee_management {

	public static void main(String[] args) {
		

	}

}
