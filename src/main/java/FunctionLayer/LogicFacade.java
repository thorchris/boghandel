package FunctionLayer;

import DBAccess.UserMapper;

import java.util.ArrayList;

import static DBAccess.DataMapper.getBookList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static User createEmployee( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "employee");
        UserMapper.createUser( user );
        return user;
    }

    public static void RemoveCustomer(String email){
        UserMapper.RemoveCustomer(email);

    }

    public static void EditPassword(String email, String password){
        UserMapper.EditPassword(email, password);
    }


    public static Book searchBook(String title){
        return searchBook(title);
    }


    public static ArrayList<Book> bookList(){
        return getBookList();
    }


}
