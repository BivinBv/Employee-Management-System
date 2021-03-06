package emp_management_sys;
import java.awt.List;
import java.io.*;
import java.io.*;
import java.util.*;

import java.sql.*;
import java.util.ArrayList;
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
				
				System.out.println("Id:"+"TV"+id+",  Name: "+First_name+" "+Last_name+",   Designation: "+Designation+",   Official_address: "+address+",  Mobile_Number:  "
						+Mobileno+",   Date: "+adddate);
				System.out.println("Status: "+status);
				System.out.println();
				
			}
			
		}catch(Exception e) {System.out.println(e);}
	}
//---------------------------------Blocking---------------------------------------------------------------------------------------
		void block()
		{
			try
			{
				int status=0;
				String query="update basic_details set status='Inactive' where id=?";
				PreparedStatement ps=getconnection().prepareStatement(query);
				ps.setInt(1, 5);
				status=ps.executeUpdate();
				if(status>0)
				{
					System.out.println("User Blocked");
				}
				else
				{
					System.out.println("user is not blocked");
				}
			}catch(Exception e) {System.out.println(e);}
		}
//----------------------------------Export to text file-------------------------------------------------------------------------------
		void print()
		{
			try
			{
				String query="select basic_details.id,First_name,Last_name,Designation,PAN_number, Account_number,Bank_name,IFSC_code from "
						+ "basic_details inner join bank_information on basic_details.id=bank_information.id";
				Statement st=getconnection().createStatement();
				ResultSet rs=st.executeQuery(query);
				while(rs.next())
				{
					int id=rs.getInt("id");
					String fname=rs.getString("First_name");
					String lname=rs.getString("Last_name");
					String desig=rs.getString("Designation");
					String PAN=rs.getString("PAN_number");
					String Accno=rs.getString("Account_number");
					String Bank_name=rs.getString("Bank_name");
					String IFSC=rs.getString("IFSC_code");
					
					FileWriter fw=new FileWriter("C:\\Users\\BIVIN\\OneDrive\\Documents\\Bivin\\file.txt",true);
					fw.write("\n Employee ID: TV"+id+"\n Name: "+fname+" "+lname+"\n Designation: "+desig+"\n PAN Number: "+PAN);
				    fw.write("\n Account_number: "+Accno+"\n Bank Name: "+Bank_name+"\n IFSC code: "+IFSC+"\n-------------------------");
					fw.close();
				}
				System.out.println("Saved to file");
	
			}catch(Exception e) {}
		}

}
public class Employee_management {

	public static void main(String[] args) throws IOException {
		Empmng e=new Empmng();
		e.print();

	}

}
