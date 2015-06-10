package uml_gaokai;
//download by http://down.liehuo.net
import java.awt.*;
import javax.swing.*;

 
import com.borland.jbcl.layout.*;
import java.awt.event.*;

import com.borland.dx.sql.dataset.Database;

import db.DBUtil;

import java.sql.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class DeleteUser extends JDialog {
  private JPanel panel1 = new JPanel();
  private XYLayout xYLayout1 = new XYLayout();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JTextField jTextField2 = new JTextField();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private Database database1 = new Database();

  public DeleteUser(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DeleteUser() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    panel1.setLayout(xYLayout1);
    jLabel1.setText("�û���");
    jLabel2.setText("���");
    jButton1.setText("ȷ��");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    jButton2.setText("ȡ��");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    database1.setJdbcConnection(DBUtil.getConnection());
    panel1.add(jLabel1,  new XYConstraints(58, 44, 78, 25));
    panel1.add(jLabel2,  new XYConstraints(59, 92, 84, 27));
    panel1.add(jTextField1,  new XYConstraints(153, 44, 109, 27));
    panel1.add(jTextField2,  new XYConstraints(153, 93, 112, 29));
    panel1.add(jButton1,  new XYConstraints(151, 202, 82, 28));
    panel1.add(jButton2,       new XYConstraints(256, 203, 83, 27));
    this.getContentPane().add(panel1, BorderLayout.CENTER);
  }

  public void cancel(){
    dispose() ;
  }

  void jButton2_actionPerformed(ActionEvent e) {
    cancel();
  }

  void jButton1_actionPerformed(ActionEvent e) {
    String userName = String.valueOf(jTextField1.getText()) ;
    String userAuthority = String.valueOf(jTextField2.getText()) ;
    int response = JOptionPane.showConfirmDialog(null,"�����Ƿ�ɾ�����û�","",JOptionPane.YES_NO_CANCEL_OPTION) ;
    if(response == 0){
      try{
      Statement sql = database1.createStatement() ;
      sql.executeUpdate("DELETE FROM user WHERE userName = '"+userName+"' and userAuthority = '"+userAuthority+"'") ;
      dispose() ;
      }
      catch(SQLException www){www.printStackTrace();}
    }
  }
}