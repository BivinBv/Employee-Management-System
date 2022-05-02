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
		int status1=0;
		int status2=0;
		String query1="insert into basic_details(first_name,last_name,Designation,Official_address,Mobile_number,Add_date)values(?,?,?,?,?,CURDATE())";
		PreparedStatement ps=getconnection().prepareStatement(query1);
		ps.setString(1, "Sooraj");
		ps.setString(2, "RS");
		ps.setString(3, "Software Tester");
		ps.setString(4, "1st Street");
		ps.setString(5, "7463786489");
		status1=ps.executeUpdate();
		
		String query2="insert into bank_information(Account_number,Bank_name,IFSC_code,PAN_number,Bank_add_date)"
				+ "values(?,?,?,?,CURDATE())";
		PreparedStatement ps1=getconnection().prepareStatement(query2);
		ps1.setString(1, "6565476568");
		ps1.setString(2, "South Indian Bank");
		ps1.setString(3, "SH6574566");
		ps1.setString(4, "HH9879HJJ");
		ps1.executeUpdate();
		
		
		if((status1>0))
		{
			System.out.println("Success in update");
		}
		else
		{
			System.out.println("failed to update");
		}
		
		}catch(Exception e) {System.out.println(e);}
	}
//-------------------------------------View Details---------------------------------------------------------------------------
	void view()
	{
		try
		{
			String query="select * from basic_details";
			Statement st=getconnection().createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				int id=rs.getInt("id");
				String First_name=rs.getString("First_name");
				String Last_name=rs.getString("Last_name");
				String Designation=rs.getString("Designation");
				String address=rs.getString("Official_address");
				String Mobileno=rs.getString("Mobile_number");
				String adddate=rs.getString("Add_date");
				String status=rs.getString("status");
				
				System.out.println("Name: "+First_name+" "+Last_name+"   Designation: "+Designation+"   Official_address: "+address+"  Mobile_Number:  "
						+Mobileno+"   Date: "+adddate);
				System.out.println("Status: "+status);
				
			}
			
		}catch(Exception e) {System.out.println(e);}
	}
//---------------------------------Blocking---------------------------------------------------------------------------------------	
}
public class Employee_management {

	public static void main(String[] args) {
		Empmng e=new Empmng();
		e.view();

	}

}
