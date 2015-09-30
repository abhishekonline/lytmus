package Experiment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;

public class EkanshGupta {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://ediss-db.c47a5hmpj9xh.us-east-1.rds.amazonaws.com:3306/EDISS_DB";

	// Database credentials
	static final String USER = "egupta";
	static final String PASS = "abcd1234";
	
	public static void main(String args[]) {
		 	Connection conn = null;
		    Statement stmt = null;
		try {
			//making connection
			/*
			 * CREATE TABLE product(
			    id int,
			    asin VARCHAR(255) ,
			    title VARCHAR(255),
				groups VARCHAR(255),
				categories int,
			   );
			   
			
			 	create table category_master(
				category_name VARCHAR(255),
				category_id VARCHAR(255),
				category_parent VARCHAR(255)
				);  
			 */
			Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("\nConnecting to database...");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        System.out.println("MySQL connection successfull");
			BufferedReader br = new BufferedReader(new FileReader(
					"C:/Users/abhishek/Desktop/Project2Data.txt"));
			String line;
			int flag = 1;
			row r = new row();
			List<String> temp = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				if (line.trim().startsWith("Id:")) {
					r.Id = Integer.valueOf(line.replaceFirst("Id:", "").trim());
				} else if (line.trim().startsWith("ASIN:")) {
					r.ASIN = line.replaceFirst("ASIN:", "").trim();
				} else if (line.trim().startsWith("title:")) {
					r.title = line.replaceFirst("title:", "").trim();
				} else if (line.trim().startsWith("group:")) {
					r.group = line.replaceFirst("group:", "").trim();
				} else if (line.trim().startsWith("categories:")) {
					r.categories = Integer.valueOf(line.replaceFirst(
							"categories:", "").trim());
				} else if (line.trim().startsWith("|")
						&& line.trim().endsWith("]")) {
					temp.add(line.trim());
				} else if (line.trim().equals("")) {
					if (flag == 1) {
						StringBuffer bf= new StringBuffer();
						String sql1 = "SELECT * FROM category_master where category_name=?";
						String sql2= "INSERT INTO category_master (category_name,category_id,category_parent)" +
						        "VALUES (?, ?, ?)";
						for(int i=0;i<temp.size();i++){
							String[] sub_cats= temp.get(i).split("\\|");
							
							for(int j=0;j<sub_cats.length;j++){
								if(sub_cats[j].trim().equals(""))continue;
								String[] part= sub_cats[j].split("\\[");
								PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
								preparedStatement1.setString(1, part[0]);
								ResultSet resultSet = preparedStatement1.executeQuery();
								
								if(!resultSet.next())
								{
									PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
									preparedStatement2.setString(1, part[0]);
									preparedStatement2.setString(2, part[1].replaceFirst("]", ""));
									if(j>0)
										preparedStatement2.setString(3, sub_cats[j-1].split("\\[")[0]);
									else
										preparedStatement2.setString(3, null);
									//adding row to the category_master
									preparedStatement2.executeUpdate();
									
								}
								if(j==sub_cats.length-1)
								bf.append( part[1].replaceFirst("]", ""));
							}
							if(i!=temp.size()-1)
								bf.append(",");
							
						}
						System.out.println(bf.toString());
						
						r.categoryList.addAll(temp);
						String sql = "INSERT INTO product (id,asin,title,groups,categories,parent_id)" +
						        "VALUES (?, ?, ?, ?, ?, ?)";
						PreparedStatement preparedStatement = conn.prepareStatement(sql);
						preparedStatement.setLong(1, r.Id);
						preparedStatement.setString(2, r.ASIN);
						preparedStatement.setString(3, r.title);
						preparedStatement.setString(4, r.group);
						preparedStatement.setLong(5, r.categories);
						preparedStatement.setString(6, bf.toString());
						preparedStatement.executeUpdate();

						System.out.println("Inserted product id "+r.Id);
						r.categoryList.clear();
						temp.clear();
					}
					flag = flag ^ 1;
				} else
					continue;

			}
			StringBuffer bf= new StringBuffer();
			String sql1 = "SELECT * FROM category_master where category_name=?";
			String sql2= "INSERT INTO category_master (category_name,category_id,category_parent)" +
			        "VALUES (?, ?, ?)";
			for(int i=0;i<temp.size();i++){
				String[] sub_cats= temp.get(i).split("\\|");
				
				for(int j=0;j<sub_cats.length;j++){
					if(sub_cats[j].trim().equals(""))continue;
					String[] part= sub_cats[j].split("\\[");
					PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
					preparedStatement1.setString(1, part[0]);
					ResultSet resultSet = preparedStatement1.executeQuery();
					
					if(!resultSet.next())
					{
						PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
						preparedStatement2.setString(1, part[0]);
						preparedStatement2.setString(2, part[1].replaceFirst("]", ""));
						if(j>0)
							preparedStatement2.setString(3, sub_cats[j-1].split("\\[")[0]);
						else
							preparedStatement2.setString(3, null);
						//adding row to the category_master
						preparedStatement2.executeUpdate();
						
					}
					if(j==sub_cats.length-1)
					bf.append( part[1].replaceFirst("]", ""));
				}
				if(i!=temp.size()-1)
					bf.append(",");
				
			}
			System.out.println(bf.toString());
			
			r.categoryList.addAll(temp);
			String sql = "INSERT INTO product (id,asin,title,groups,categories,parent_id)" +
			        "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setLong(1, r.Id);
			preparedStatement.setString(2, r.ASIN);
			preparedStatement.setString(3, r.title);
			preparedStatement.setString(4, r.group);
			preparedStatement.setLong(5, r.categories);
			preparedStatement.setString(6, bf.toString());
			preparedStatement.executeUpdate();

			System.out.println("Inserted product id "+r.Id);
			r.categoryList.clear();
			temp.clear();
			conn.close();
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static class row {
		int Id;
		String ASIN;
		String title;
		String group;
		int categories;
		List<String> categoryList = new ArrayList<String>();
	}
}
