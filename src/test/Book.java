package test;
import java.util.*;
import java.sql.*;
public class Book
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MUSKAN","goyal");
			Scanner s = new Scanner(System.in);
			System.out.println("===Choice===");
			System.out.println("1.AddBookDetails\n 2.ViewBooks");
			System.out.println("Enter the choice:");
			int choice = Integer.parseInt(s.nextLine());
			switch(choice)
			{
			case 1:
				PreparedStatement ps1 = con.prepareStatement("insert into Book values(?,?,?,?)");
				System.out.println("Enter the bCode:");
				String bcode = s.nextLine();
				System.out.println("Enter the bName:");
				String bname = s.nextLine();
				System.out.println("Enter the bAuthor");
				String bauthor = s.nextLine();
				System.out.println("Enter the bPrice:");
				float bprice = s.nextFloat();
				System.out.println("Enter the bQty:");
				int bqty = s.nextInt();
				ps1.setString(1,bcode);
				ps1.setString(2,bname);
				ps1.setString(3,bauthor);
				ps1.setFloat(4,bprice);
				ps1.setInt(5,bqty);
				int k = ps1.executeUpdate();
				if(k>0)
				{
					System.out.println("BookDetails inserted successfully...");
				}
				break;
			case 2:
				PreparedStatement ps2 = con.prepareStatement("select * from Book");
				ResultSet rs = ps2.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
				}
				break;
			  default:
				  System.out.println("Invalid choice....");
			}
			s.close();

	}catch(Exception e)
		{
		  e.printStackTrace();
		}
	}
}
