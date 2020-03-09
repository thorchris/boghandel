package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<User> getCustomerList() {
        ArrayList<User> customerList = new ArrayList();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM useradmin.users WHERE role=\"customer\"";
            ResultSet rs = stmt.executeQuery( SQL );

            while (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                User user = new User(email, password, role);
                customerList.add(user);
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            System.out.println(ex);
        }
        return customerList;
    }

    public static void RemoveCustomer(String email){
        try {
            String SQL = "DELETE FROM Users WHERE email = (?)";
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, email);
            ps.execute();
            ps.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("FEJL! Kunne ikke indsætte medlem.");
        }
     }

    public static void EditPassword(String email, String password){
        try {
            String SQL = "UPDATE users SET password = (?) WHERE email = (?) and role = 'customer'";
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.execute();
            ps.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("FEJL! Kunne ikke ændre password.");
        }
    }


    }


