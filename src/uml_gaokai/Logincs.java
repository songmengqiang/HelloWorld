package uml_gaokai;

import java.awt.*;
import javax.swing.*;


import com.borland.jbcl.layout.*;
import java.awt.event.*;

import com.borland.dx.sql.dataset.Database;
import com.borland.dx.sql.dataset.Load;
import com.borland.dx.sql.dataset.QueryDataSet;
import com.borland.dx.sql.dataset.QueryDescriptor;

import db.DBUtil;

import java.sql.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Logincs extends JDialog implements ActionListener{
  private JPanel panel1 = new JPanel();
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel jPanel1 = new JPanel();
  private XYLayout xYLayout1 = new XYLayout();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JPasswordField jPasswordField1 = new JPasswordField();
  private Database database1 = new Database();
  private QueryDataSet queryDataSet1 = new QueryDataSet();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  private TitledBorder titledBorder1;
  private TitledBorder titledBorder2;
  private JLabel jLabel6 = new JLabel();

  public Logincs(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public Logincs() {
    this(null, "", false);
  }
  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(xYLayout1);
    jLabel1.setForeground(Color.blue);//��ǩ�ؼ���������ɫ
    jLabel1.setText("�û���"); //��ǩ����
    jLabel2.setForeground(Color.blue);
    jLabel2.setText("����");
    jButton1.setForeground(UIManager.getColor("List.selectionBackground"));//��ť�ؼ�������ɫ
    jButton1.setBorder(BorderFactory.createRaisedBevelBorder());//��ť���
    jButton1.setText("��¼");//��ť����
    jButton1.addActionListener(this);//���밴ť�¼�
    jButton2.setForeground(UIManager.getColor("Menu.selectionBackground"));
    jButton2.setBorder(BorderFactory.createRaisedBevelBorder());
    jButton2.setToolTipText("");
    jButton2.setText("ȡ��");
    jButton2.addActionListener(this);
    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    jPanel1.setMinimumSize(new Dimension(600, 600));//��������С
    jPanel1.setPreferredSize(new Dimension(400, 300));
    jPasswordField1.setBorder(titledBorder1);
    jPasswordField1.setToolTipText("");
    database1.setJdbcConnection(DBUtil.getConnection());
    queryDataSet1.setQuery(new QueryDescriptor(database1, "SELECT [user].userName,[user].userPassword,[user].userAuthority \n" +
        "FROM [UML_CS].[dbo].[user]", null, true, Load.ALL));
    this.setResizable(false);
    this.setTitle("Login");
    jLabel3.setBackground(Color.white);//��ǩ������ɫ
    jLabel3.setForeground(Color.green);
    jLabel3.setBorder(BorderFactory.createEtchedBorder());
    jLabel3.setText("                                        С�ͳ��й���ϵͳ");
    jLabel4.setBorder(BorderFactory.createEtchedBorder());
    jLabel4.setText(" ���������ˣ��߿�");
    jLabel5.setBorder(BorderFactory.createEtchedBorder());
    jLabel5.setToolTipText("");
    jLabel5.setText("�����汾��: 1.1");
    jTextField1.setBorder(titledBorder2);
    jLabel6.setBorder(BorderFactory.createEtchedBorder());
    getContentPane().add(panel1);
    panel1.add(jPanel1, BorderLayout.WEST);
    jPanel1.add(jLabel3,     new XYConstraints(-1, 0, 395, 30));
    jPanel1.add(jLabel5,     new XYConstraints(274, 30, 121, 32));
    jPanel1.add(jLabel4, new XYConstraints(127, 32, 143, 30));
    jPanel1.add(jPasswordField1, new XYConstraints(143, 196, 132, 24));
    jPanel1.add(jTextField1, new XYConstraints(143, 136, 132, 24));
    jPanel1.add(jLabel2, new XYConstraints(23, 195, 60, 25));
    jPanel1.add(jLabel1, new XYConstraints(23, 134, 60, 25));
    jPanel1.add(jLabel6,    new XYConstraints(-2, 65, 396, 191));
    jPanel1.add(jButton1, new XYConstraints(90, 274, 68, 28));
    jPanel1.add(jButton2, new XYConstraints(193, 275, 69, 28));
  }
  public void actionPerformed(ActionEvent e){
    //the user login
    if(e.getSource() == jButton1) //�õ����浥���¼�
    {
      try{
        String userAuthority = null ;
        String userName = null ;
        String userPassword = null ;
        String testName = jTextField1.getText().toString() ;//��jTextField1�еõ��û���
        String testPassword = String.valueOf(jPasswordField1.getPassword()) ;//��jPassword�еõ��û�����
        Statement sql = database1.createStatement() ; //��Statement����
        ResultSet rs = sql.executeQuery("SELECT userName,userPassword , userAuthority FROM [UML_CS].[dbo].[user] WHERE userName = '"+testName+"'") ;
        //ִ��SQL��䣬�����ݿ⵱��ѡ���û��������룬��Ȩ�ޡ�
        while(rs.next()) //
        {
          userName = rs.getString("userName") ; //�����ݿ⵱�еõ��û���
          userPassword = rs.getString("userPassword") ;//�����ݿ⵱�еõ�����
          userAuthority = rs.getString("userAuthority") ;//�����ݿ⵱�еõ�Ȩ��
        }
        verifyUser(userName,userPassword,testPassword,userAuthority); //����verifyUser����
        cancel() ;//�˳�
      }
      catch(SQLException ex){ex.printStackTrace();}
    }
    //exit the System
    else if(e.getSource() == jButton2){
      cancel();
    }
  }
  void cancel()
  {
    dispose();
  }

  //��֤�û����Լ�����
  void verifyUser(String userName , String userPassword , String testPassword, String userAuthority)
  {
    if(userName == null) //�ж��û����Ƿ�Ϊ��
    {
      JOptionPane.showMessageDialog(null,"�û��������ڣ�����ע��","verify user",JOptionPane.DEFAULT_OPTION);
      //�׳��Ի���
    }
    else
    {
      if(userPassword.equals(testPassword) == false) //�ж������Ƿ����
      {
        JOptionPane.showMessageDialog(null,"����������벻��ȷ��������","verify password" , JOptionPane.DEFAULT_OPTION);
        //�׳��Ի���
      }
      else{
        JOptionPane.showMessageDialog(null,"success","",JOptionPane.DEFAULT_OPTION);
        //
        verifyUserAuthority(userAuthority) ;//����Ȩ���ж�
      }
    }
  }
  //��֤�û�Ȩ��
  void verifyUserAuthority(String userAuthority){
    if(userAuthority.equals("admin"))//����û�Ϊadmin���򵯳�����Ա����
    {
      AdminWindow adminWindow = new AdminWindow() ;
      //���öԻ���
      Dimension dlgSize = adminWindow.getPreferredSize();
      Dimension frmSize = getSize();
      Point loc = getLocation();
      adminWindow.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
      adminWindow.setModal(true);
      adminWindow.pack();
      adminWindow.show();
    }
    else if (userAuthority.equals("customer")){
      CustomerWindow customerWindow =new CustomerWindow() ;
      Dimension dlgSize = customerWindow.getPreferredSize();
      Dimension frmSize = getSize();
      Point loc = getLocation();
      customerWindow.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
      customerWindow.setModal(true);
      customerWindow.pack();
      customerWindow.show();
    }
    else if (userAuthority.equals("buyer")){
      BuyerWindow buyerWindow =new BuyerWindow() ;
      Dimension dlgSize = buyerWindow.getPreferredSize();
      Dimension frmSize = getSize();
      Point loc = getLocation();
      buyerWindow.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
      buyerWindow.setModal(true);
      buyerWindow.pack();
      buyerWindow.show();
    }
    else if (userAuthority.equals("saler")){
      SalesWindow salesWindow =new SalesWindow() ;
      Dimension dlgSize = salesWindow.getPreferredSize();
      Dimension frmSize = getSize();
      Point loc = getLocation();
      salesWindow.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
      salesWindow.setModal(true);
      salesWindow.pack();
      salesWindow.show();
    }
    else if (userAuthority.equals("manager")){
      ManagementWindow managementWindow =new ManagementWindow() ;
      Dimension dlgSize = managementWindow.getPreferredSize();
      Dimension frmSize = getSize();
      Point loc = getLocation();
      managementWindow.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
      managementWindow.setModal(true);
      managementWindow.pack();
      managementWindow.show();
    }
  }
}