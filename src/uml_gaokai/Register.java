package uml_gaokai;
//download by http://down.liehuo.net

import com.borland.dx.sql.dataset.Database;

import db.DBUtil;

import java.sql.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Register {
  public Register( String userName , int userAge , String userGender , String userAuthority ,String userAddress ,String userPassword , String testPassword ){
    if(userPassword.equals(testPassword)){
      try{
        Database database1 = new Database();
         database1.setJdbcConnection(DBUtil.getConnection());
        Statement sql1 = database1.createStatement() ;
        JOptionPane.showMessageDialog(null,"ע��ɹ�,�����µ�½","",JOptionPane.DEFAULT_OPTION);
        sql1.executeUpdate("INSERT INTO user(userName, userAge , userGender, userAuthority , userAddress , userPassword) VALUES('"+userName+"' , '"+userAge+"' , '"+userGender+"' , '"+userAuthority+"' , '"+userAddress+"','"+userPassword+"')") ;
      }
      catch(SQLException www){www.printStackTrace();}
    }
    else{
      JOptionPane.showMessageDialog(null,"�����������ǰ�󲻷�,����������","",JOptionPane.DEFAULT_OPTION);
    }
  }
}