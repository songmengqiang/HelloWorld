package uml_gaokai;
//download by http://down.liehuo.net
import java.awt.*;
import javax.swing.*;
 

import com.borland.dx.dataset.Column;
import com.borland.dx.sql.dataset.Database;
import com.borland.dx.sql.dataset.Load;
import com.borland.dx.sql.dataset.QueryDataSet;
import com.borland.dx.sql.dataset.QueryDescriptor;
import com.borland.dbswing.*;
import com.borland.jbcl.layout.*;

import db.DBUtil;

import java.awt.event.*;
import java.sql.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class CustomerWindow extends JDialog {
  private JPanel panel1 = new JPanel();
  private Database database1 = new Database();
  private JdbTable jdbTable1 = new JdbTable();
  private XYLayout xYLayout1 = new XYLayout();
  private TableScrollPane tableScrollPane1 = new TableScrollPane();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  private JButton jButton4 = new JButton();
  private Column column1 = new Column();
  private Column column2 = new Column();
  private Column column3 = new Column();
  private QueryDataSet queryDataSet1 = new QueryDataSet();
  private QueryDataSet queryDataSet2 = new QueryDataSet();
  private QueryDataSet queryDataSet3 = new QueryDataSet();
  private QueryDataSet queryDataSet4 = new QueryDataSet();
  private JLabel jLabel1 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField2 = new JTextField();
  private JLabel jLabel3 = new JLabel();
  private JTextField jTextField3 = new JTextField();
  private JLabel jLabel4 = new JLabel();
  private JTextField jTextField4 = new JTextField();
  private JLabel jLabel5 = new JLabel();
  private JTextField jTextField5 = new JTextField();
  private JLabel jLabel6 = new JLabel();
  private JTextField jTextField6 = new JTextField();
  private JLabel jLabel7 = new JLabel();
  private JTextField jTextField7 = new JTextField();
  private JLabel jLabel8 = new JLabel();
  private JPasswordField jPasswordField1 = new JPasswordField();

  public CustomerWindow(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public CustomerWindow() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    panel1.setLayout(xYLayout1);
    database1.setJdbcConnection(DBUtil.getConnection());
    jButton1.setText("���ȫ����Ʒ��Ϣ");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    jButton2.setText("���ĳ����Ʒ");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    jButton3.setText("������Ʒ");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton3_actionPerformed(e);
      }
    });
    jButton4.setText("�˳�");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton4_actionPerformed(e);
      }
    });
    jdbTable1.setToolTipText("");
    column1.setColumnName("GoodsPrice");
    column1.setDataType(com.borland.dx.dataset.Variant.DOUBLE);
    column1.setSchemaName("dbo");
    column1.setTableName("goodsInfo");
    column1.setVisible(com.borland.jb.util.TriStateProperty.DEFAULT);
    column1.setServerColumnName("GoodsPrice");
    column1.setSqlType(6);
    column3.setColumnName("NewColumn1");
    column3.setDataType(com.borland.dx.dataset.Variant.STRING);
    column3.setDefault("");
    column3.setPreferredOrdinal(1);
    column3.setServerColumnName("NewColumn1");
    column3.setSqlType(0);
    jLabel1.setText("��Ʒ��");
    jLabel2.setText("��ƷID");
    jLabel3.setText("��Ʒ����");
    jLabel4.setText("��Ʒ��");
    jLabel5.setText("��Ʒ����");
    jLabel6.setText("����");
    jLabel7.setText("�ͻ�����");
    jLabel8.setText("����");
    getContentPane().add(panel1);
    panel1.add(tableScrollPane1,  new XYConstraints(219, 140, -1, -1));
    panel1.add(jdbTable1,            new XYConstraints(2, 0, 542, 222));
    panel1.add(jButton2, new XYConstraints(0, 267, 131, 23));
    panel1.add(jLabel1,  new XYConstraints(136, 268, 39, 21));
    panel1.add(jTextField2, new XYConstraints(178, 268, 65, 21));
    panel1.add(jLabel2,  new XYConstraints(249, 268, 52, 21));
    panel1.add(jTextField1,  new XYConstraints(297, 268, 66, 23));
    panel1.add(jTextField3,  new XYConstraints(431, 309, 65, 21));
    panel1.add(jLabel3,  new XYConstraints(375, 309, -1, 23));
    panel1.add(jLabel4,  new XYConstraints(137, 309, 39, 21));
    panel1.add(jLabel5,      new XYConstraints(249, 309, 50, 22));
    panel1.add(jTextField5,   new XYConstraints(299, 309, 69, 20));
    panel1.add(jButton3,    new XYConstraints(-1, 307, 133, 22));
    panel1.add(jLabel6,     new XYConstraints(136, 339, 46, 21));
    panel1.add(jTextField6,        new XYConstraints(180, 339, 66, -1));
    panel1.add(jLabel7,    new XYConstraints(249, 339, 50, 21));
    panel1.add(jTextField7,     new XYConstraints(298, 339, 71, 21));
    panel1.add(jLabel8,   new XYConstraints(378, 339, 50, 20));
    panel1.add(jButton4, new XYConstraints(413, 384, 130, 22));
    panel1.add(jPasswordField1,  new XYConstraints(432, 338, 66, 19));
    panel1.add(jTextField4,   new XYConstraints(178, 310, 71, 21));
    panel1.add(jButton1,  new XYConstraints(-2, 233, 133, 22));
  }
  //���ȫ����Ʒ
  void jButton1_actionPerformed(ActionEvent e) {
    queryDataSet1.setQuery(new QueryDescriptor(database1, "SELECT goodsInfo.GoodsID,goodsInfo.GoodsName,goodsInfo.GoodsNumber,goodsInfo.GoodsProduct,go" +
        "odsInfo.GoodsPrice FROM goodsInfo", null, true, Load.ALL));
    jdbTable1.setDataSet(queryDataSet1);
    queryDataSet1.refresh();
  }
  //���ĳ����Ʒ
  void jButton2_actionPerformed(ActionEvent e) {
    String GoodsName = String.valueOf(jTextField2.getText()) ;
    int GoodsID = Integer.parseInt(jTextField1.getText()) ;
    if( GoodsName.equals("") && GoodsID == 0){
      JOptionPane.showMessageDialog(null,"��������Ʒ������ƷID�ţ���ѯ��Ʒ","",JOptionPane.DEFAULT_OPTION);
    }
    else if( GoodsName.equals("") == false  && GoodsID == 0 ){
      queryDataSet2.setQuery(new QueryDescriptor(database1, "SELECT goodsInfo.GoodsID,goodsInfo.GoodsName,goodsInfo.GoodsNumber,goodsInfo.GoodsProduct,go" +
          "odsInfo.GoodsPrice FROM goodsInfo WHERE GoodsName = '"+GoodsName+"'", null, true, Load.ALL));
      jdbTable1.setDataSet(queryDataSet2);
      queryDataSet2.refresh();
    }
    else if( GoodsName.equals("") && GoodsID != 0 ){
      queryDataSet3.setQuery(new QueryDescriptor(database1, "SELECT goodsInfo.GoodsID,goodsInfo.GoodsName,goodsInfo.GoodsNumber,goodsInfo.GoodsProduct,go" +
          "odsInfo.GoodsPrice FROM goodsInfo WHERE GoodsID = '"+GoodsID+"'", null, true, Load.ALL));
      jdbTable1.setDataSet(queryDataSet3);
      queryDataSet3.refresh();
    }
  }
  //������Ʒ
  void jButton3_actionPerformed(ActionEvent e) {
    String goodsName = jTextField4.getText() ; //get the GoodsName
    String goodsSize = jTextField5.getText() ; //get the goodsSize
    String goodsCustomNumber = jTextField3.getText() ; //get the goodsCustomNumber
    String venditionDate = jTextField6.getText() ; //get the venditionDate
    String customerName = jTextField7.getText() ; // get the userName
    String testPassword = String.valueOf(jPasswordField1.getPassword()) ; // get the passward
    String userPassword = null ;
    Statement sql = database1.createStatement() ;
    try{
      ResultSet rs = sql.executeQuery("SELECT userPassword FROM user WHERE userName = '"+customerName+"'") ;
      while(rs.next()){
        userPassword = rs.getString("userPassword") ;
      }
      //�����û���ȷ��
      if(userPassword.equals(testPassword) == false){
        JOptionPane.showMessageDialog(null,"����������벻��ȷ��������","verify password" , JOptionPane.DEFAULT_OPTION);
      }
      else{
        JOptionPane.showMessageDialog(null,"success","",JOptionPane.DEFAULT_OPTION);
        sql.executeUpdate("INSERT INTO vendition_TABLE(GoodsName,GoodsSize,GoodsCustomNumber,VenditionDate,CustomerName) VALUES('"+goodsName+"','"+goodsSize+"','"+goodsCustomNumber+"','"+venditionDate+"','"+customerName+"')") ;
        queryDataSet4.setQuery(new QueryDescriptor(database1, "SELECT * FROM vendition_TABLE WHERE CustomerName = '"+customerName+"'", null, true, Load.ALL));
        jdbTable1.setDataSet(queryDataSet4);
        queryDataSet4.refresh();
      }
    }
    catch(Exception www){
      JOptionPane.showMessageDialog(null,"�뽫���е���Ϣ��д����","",JOptionPane.DEFAULT_OPTION);
    }
  }

  void jButton4_actionPerformed(ActionEvent e) {
    dispose() ;
  }
}