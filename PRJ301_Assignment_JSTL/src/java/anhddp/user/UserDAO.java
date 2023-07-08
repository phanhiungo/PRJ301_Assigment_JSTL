/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhddp.user;

import anhddp.util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author moneymaker
 */
public class UserDAO {
    private static String LOGIN = "SELECT fullName, roleID FROM tblUsers WHERE userID=? AND password=? ";
    private static String SEARCH = "SELECT userID, fullName, roleID FROM tblUsers WHERE fullName like ?";
    private static String DELETE = "DELETE tblUsers WHERE userID=?";
    private static String UPDATE = "UPDATE tblUsers SET fullName=?, roleID=? WHERE userID=?";
    private static String CHECK_DUPE = "SELECT fullName FROM tblUsers WHERE userID=?";
    private static String INSERT = "INSERT INTO tblUsers(userID, fullName, roleID, password) VALUES(?,?,?,?)";
    public UserDTO checkLogin(String userID, String password) throws ClassNotFoundException, SQLException{
        UserDTO user = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.getConnection();
            if(con != null){
                ptm = con.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2,password);
                rs = ptm.executeQuery();
                if(rs.next()){
                    String roleID = rs.getString("roleID");
                    String fullName = rs.getString("fullName");
                    user = new UserDTO(userID, fullName, roleID, "");
                }
            }
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(ptm != null){
                ptm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return user;
    }
    public List<UserDTO> getListUser(String search) throws ClassNotFoundException, SQLException{
        List<UserDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.getConnection();
            if(con != null){
                ptm = con.prepareStatement(SEARCH);
                ptm.setString(1,"%" + search +"%");
                rs = ptm.executeQuery();
                while(rs.next()){
                   String userID = rs.getString("userID");
                   String fullName = rs.getString("fullName");
                   String roleID = rs.getString("roleID");
                   String password = "***";
                   list.add(new UserDTO(userID, fullName, roleID, password));   
                }
            }
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(ptm != null){
                ptm.close();
            }
            if(con != null){
                con.close();
            }
        }
       return list;
    }
    public boolean delete(String userID) throws SQLException{
        boolean checkDelete = false;
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBHelper.getConnection();
            if(con != null){
                stm = con.prepareStatement(DELETE);
                stm.setString(1, userID);
                checkDelete = stm.executeUpdate() > 0 ? true : false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return checkDelete;
    }
    public boolean update(UserDTO user) throws SQLException{
        boolean checkUpdate = false;
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBHelper.getConnection();
            if(con != null){
                stm = con.prepareStatement(UPDATE);
                stm.setString(1, user.getFullName());
                stm.setString(2, user.getRoleID());
                stm.setString(3, user.getUserID());
                checkUpdate = stm.executeUpdate() > 0 ? true : false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return checkUpdate;
    }
    public boolean insert(UserDTO user) throws SQLException{
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.getConnection();
            if(con != null){
                stm = con.prepareStatement(INSERT);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getFullName());
                stm.setString(3, user.getRoleID());
                stm.setString(4, user.getPassword());
                check = stm.executeUpdate() > 0 ? true : false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        return check;
    }
    public boolean checkDupe(String userID) throws SQLException{
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.getConnection();
            if(con != null){
                stm = con.prepareStatement(CHECK_DUPE);
                stm.setString(1, userID);
                rs = stm.executeQuery();
                if(rs.next()){
                    check = true;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        return check;
    }
    public boolean insertV2(UserDTO user) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try {
            conn = DBHelper.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, user.getRoleID());
                ptm.setString(4, user.getPassword());
                check = ptm.executeUpdate()>0?true:false;
            }
        }finally{
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return check;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
        UserDAO dao = new UserDAO();
//        List<UserDTO> list = dao.getListUser("a");
//        for(UserDTO user : list){
//            System.out.println(user.toString());
//        }
         boolean check = dao.insertV2(new UserDTO("admin1", "Toi la admin", "AD", "1"));
         System.out.println(check);
    }
}
