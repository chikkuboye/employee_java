import java.sql.*;
import java.util.Scanner;

public class Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("Select the option you needed below ");
            System.out.println("1 .Insert the new employee details");
            System.out.println("2 .View the existing employee details");
            System.out.println("3 .Search the employee details ");
            System.out.println("4 .Update the employee details");
            System.out.println("5 .Delete the employee details");
            System.out.println("6 .Exit");

            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Insert the data");
                    System.out.println("Enter the empcode");
                    int empcode = sc.nextInt();
                    System.out.println("Enter the name of the employee ");
                    String name = sc.next();
                    System.out.println("Enter the designation ");
                    String design = sc.next();
                    System.out.println("Enter the salary of the employee");
                    int salary = sc.nextInt();
                    System.out.println("Enter the company name of the employeee");
                    String compName = sc.next();
                    System.out.println("Enter the phone number of the employee ");
                    String phone = sc.next();
                    System.out.println("Enter the Email id of the employee ");
                    String email = sc.next();
                    System.out.println("Enter the password");
                    String password = sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","");
                        String sql = "INSERT INTO `emplyees`(`empcode`, `empName`, `Designation`, `Salary`, `companyName`, `phoneNumber`, `EmailId`, `Password`) VALUES(?,?,?,?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setInt(1,empcode);
                        stmt.setString(2,name);
                        stmt.setString(3,design);
                        stmt.setInt(4,salary);
                        stmt.setString(5,compName);
                        stmt.setString(6,phone);
                        stmt.setString(7,email);
                        stmt.setString(8,password);
                        stmt.executeUpdate();

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    //String sql = "INSERT INTO `students`(`name`, `admNo`, `rollNo`, `collage`) VALUES ('"+name+"','"+admin+"','"+rollNo+"','"+collegeName+"')";
                    break;
                case 2:
                    System.out.println("View the employee details");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","");
                        String sql = "SELECT `empcode`, `empName`, `Designation`, `Salary`, `companyName`, `phoneNumber`, `EmailId`, `Password` FROM `emplyees`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getEmp = rs.getString("empcode");
                            String getName = rs.getString("empName");
                            String getDesign = rs.getString("Designation");
                            String getSalary = rs.getString("Salary");
                            String getCompany = rs.getString("companyName");
                            String getphone = rs.getString("phoneNumber");
                            String getEmail = rs.getString("EmailId");
                            String getpass = rs.getString("Password");
                            System.out.println("Empcode="+getEmp);
                            System.out.println("Name="+getName);
                            System.out.println("Designation="+getDesign);
                            System.out.println("Salary="+getSalary);
                            System.out.println("Company="+getCompany);
                            System.out.println("Phone Number="+getphone);
                            System.out.println("EmailId="+getEmail);
                            System.out.println("Password="+getpass+'\n');
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("Search the employee details");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","");
                        System.out.println("Enter the name of the employee ");
                        int emp = sc.nextInt();
                        String sql = "SELECT `id`, `empcode`, `empName`, `Designation`, `Salary`, `companyName`, `phoneNumber`, `EmailId`, `Password` FROM `emplyees` WHERE `empcode`="+emp;
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            String getEmp = rs.getString("empcode");
                            String getName = rs.getString("empName");
                            String getDesign = rs.getString("Designation");
                            String getSalary = rs.getString("Salary");
                            String getCompany = rs.getString("companyName");
                            String getphone = rs.getString("phoneNumber");
                            String getEmail = rs.getString("EmailId");
                            String getpass = rs.getString("Password");
                            System.out.println("Empcode="+getEmp);
                            System.out.println("Name="+getName);
                            System.out.println("Designation="+getDesign);
                            System.out.println("Salary="+getSalary);
                            System.out.println("Company="+getCompany);
                            System.out.println("Phone Number="+getphone);
                            System.out.println("EmailId="+getEmail);
                            System.out.println("Password="+getpass+'\n');
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Update the employee details ");
                    System.out.println("Enter the empcode");
                    int empCode = sc.nextInt();
                    System.out.println("Enter the name of the employee ");
                    String Name = sc.next();
                    System.out.println("Enter the designation ");
                    String Design = sc.next();
                    System.out.println("Enter the salary of the employee");
                    int Salary = sc.nextInt();
                    System.out.println("Enter the company name of the employeee");
                    String CompName = sc.next();
                    System.out.println("Enter the phone number of the employee ");
                    String Phone = sc.next();
                    System.out.println("Enter the Email id of the employee ");
                    String Email = sc.next();
                    System.out.println("Enter the password");
                    String Password = sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "");
                        String sql = "UPDATE `emplyees` SET `empcode`='"+empCode+"',`empName`='"+Name+"',`Designation`='"+Design+"',`Salary`='"+Salary+"',`companyName`='"+CompName+"',`phoneNumber`='"+Phone+"',`EmailId`='"+Email+"',`Password`='"+Password+"' WHERE `empcode`="+empCode;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Updated successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println("Delete the employee ");
                    System.out.println("Enter the emp code for deleting");
                    empCode = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "");
                        String sql = "DELETE FROM `emplyees` WHERE `empcode`="+empCode;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Deleted successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
