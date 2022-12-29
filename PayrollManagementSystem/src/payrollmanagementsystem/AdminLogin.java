package payrollmanagementsystem;

import com.toedter.calendar.JCalendar;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import javax.swing.text.Document;
import net.proteanit.sql.DbUtils;

import com.itextpdf.text.BaseColor;
import java.security.*;
import java.util.*; 

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.net.MalformedURLException;

public class AdminLogin extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    
    public AdminLogin() {
        super("Admin");
        initComponents();
        conn=ConnectMSSQL.connectDB();
        Department();
        EmployeeID();
        ProjectNo();
        OvertimeEmployee();
        TotalEmployee();
        Calander();
        month();
        EmployeeCITY();
        
    }
    
    //CALANDER
    public void Calander()
    {
        Calendar call=new GregorianCalendar();
        int month=call.get(Calendar.MONTH);
        int year=call.get(Calendar.YEAR);
        int day=call.get(Calendar.DAY_OF_MONTH);
        jTextField1.setText(+day+" - "+(month+1)+" - "+year);
        
        
        int second=call.get(Calendar.SECOND);
        int min=call.get(Calendar.MINUTE);
        int hour=call.get(Calendar.HOUR);
        
        jTextField24.setText(+hour+" : "+min+" : "+second);
        
        if (month == Calendar.JANUARY)
        {
            jTextField90.setText("JANUARY");
            jTextField98.setText("JANUARY");
            jTextField73.setText("JANUARY");
            jTextField101.setText("31");
            jTextField108.setText("31");
        }
        if (month == Calendar.FEBRUARY)
        {
            jTextField90.setText("FEBRUARY");
            jTextField98.setText("FEBRUARY");
            jTextField73.setText("FEBRUARY");
            jTextField101.setText("28");
            jTextField108.setText("28");
        }
        if (month == Calendar.MARCH)
        {
            jTextField90.setText("MARCH");
            jTextField98.setText("MARCH");
            jTextField73.setText("MARCH");
            jTextField101.setText("31");
            jTextField108.setText("31");
        }
        if (month == Calendar.APRIL)
        {
            jTextField90.setText("APRIL");
            jTextField98.setText("APRIL");
            jTextField73.setText("APRIL");
            jTextField101.setText("30");
            jTextField108.setText("30");
        }
        if (month == Calendar.MAY)
        {
            jTextField90.setText("MAY");
            jTextField98.setText("MAY");
            jTextField73.setText("MAY");
            jTextField101.setText("31");
            jTextField108.setText("31");
        }
        if (month == Calendar.JUNE)
        {
            jTextField90.setText("JUNE");
            jTextField98.setText("JUNE");
            jTextField73.setText("JUNE");
            jTextField101.setText("30");
            jTextField108.setText("30");
        }
        if (month == Calendar.JULY)
        {
            jTextField90.setText("JULY");
            jTextField98.setText("JULY");
            jTextField73.setText("JULY");
            jTextField101.setText("31");
            jTextField108.setText("31");
        }
        if (month == Calendar.AUGUST)
        {
            jTextField90.setText("AUGUST");
            jTextField98.setText("AUGUST");
            jTextField73.setText("AUGUST");
            jTextField101.setText("31");
            jTextField108.setText("31");
        }
        if (month == Calendar.SEPTEMBER)
        {
            jTextField90.setText("SEPTEMBER");
            jTextField98.setText("SEPTEMBER");
            jTextField73.setText("SEPTEMBER");
            jTextField101.setText("30");
            jTextField108.setText("30");
        }
        if (month == Calendar.OCTOBER)
        {
            jTextField90.setText("OCTOBER");
            jTextField98.setText("OCTOBER");
            jTextField73.setText("OCTOBER");
            jTextField101.setText("31");
            jTextField108.setText("31");
        }
        if (month == Calendar.NOVEMBER)
        {
            jTextField90.setText("NOVEMBER");
            jTextField98.setText("NOVEMBER");
            jTextField73.setText("NOVEMBER");
            jTextField101.setText("30");
            jTextField108.setText("30");
        }
        if (month == Calendar.DECEMBER)
        {
            jTextField90.setText("DECEMBER");
            jTextField98.setText("DECEMBER");
            jTextField73.setText("DECEMBER");
            jTextField101.setText("31");
            jTextField108.setText("31");
        }
    }
    
    public void TotalEmployee()
    {
        
        try{
            String sql="SELECT COUNT(Emp_ID) as 'Total Employee' FROM EMPLOYEE";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
                {
                        String totalEmployee=rs.getString("Total Employee");
                        jTextField97.setText(totalEmployee);
                        
                }
            
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Total Employee Error: "+ex);
        }
        
    }
    
    
    //grt month
    public void month()
    {
        jComboBox5.addItem("JANUARY");
        jComboBox5.addItem("FEBRUARY");
        jComboBox5.addItem("MARCH");
        jComboBox5.addItem("APRIL");
        jComboBox5.addItem("MAY");
        jComboBox5.addItem("JUNE");
        jComboBox5.addItem("JULY");
        jComboBox5.addItem("AUGUST");
        jComboBox5.addItem("SEPTEMBER");
        jComboBox5.addItem("OCTOBER");
        jComboBox5.addItem("NOVEMBER");
        jComboBox5.addItem("DECEMBER");
        
        jComboBox6.addItem("JANUARY");
        jComboBox6.addItem("FEBRUARY");
        jComboBox6.addItem("MARCH");
        jComboBox6.addItem("APRIL");
        jComboBox6.addItem("MAY");
        jComboBox6.addItem("JUNE");
        jComboBox6.addItem("JULY");
        jComboBox6.addItem("AUGUST");
        jComboBox6.addItem("SEPTEMBER");
        jComboBox6.addItem("OCTOBER");
        jComboBox6.addItem("NOVEMBER");
        jComboBox6.addItem("DECEMBER");
        
        jComboBox7.addItem("JANUARY");
        jComboBox7.addItem("FEBRUARY");
        jComboBox7.addItem("MARCH");
        jComboBox7.addItem("APRIL");
        jComboBox7.addItem("MAY");
        jComboBox7.addItem("JUNE");
        jComboBox7.addItem("JULY");
        jComboBox7.addItem("AUGUST");
        jComboBox7.addItem("SEPTEMBER");
        jComboBox7.addItem("OCTOBER");
        jComboBox7.addItem("NOVEMBER");
        jComboBox7.addItem("DECEMBER");
        
        
        
    }
    
    public void Department()
    {
        try{
            String sql="select * from DEPARTMENT";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                String departmentID=rs.getString("Dept_ID");
                jComboBox1.addItem(departmentID);
                
                String departmentName=rs.getString("Dept_Name");
                jComboBox8.addItem(departmentName);
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("DepartmentName ComboBox Error: "+ex);
        }
    }
    
    public void EmployeeID()
    {
        try{
            String sql="select * from EMPLOYEE";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                String empID=rs.getString("Emp_ID");
                jComboBox2.addItem(empID);
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("EmployeeID ComboBox Error I: "+ex);
        }
    }
    
    public void EmployeeCITY()
    {
        try{
            String sql="SELECT DISTINCT(Emp_City) as CITY FROM EMPLOYEE";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                String empCity=rs.getString("City");
                jComboBox9.addItem(empCity);
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Employee City ComboBox Error I: "+ex);
        }
    }
    
    public void ProjectNo()
    {
        try{
            String sql="select DISTINCT Project_NO from CORPORATE_TRAVEL";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                String department=rs.getString("Project_NO");
                jComboBox3.addItem(department);
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Project ComboBox Error: "+ex);
        }
    }
    
    public void OvertimeEmployee()
    {
        try{
            String sql="select DISTINCT Emp_ID from EMPLOYEE_OVERTIME";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next())
            {
                String empID=rs.getString("Emp_ID");
                jComboBox4.addItem(empID);
            }
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Overtime ComboBox Error: "+ex);
        }
    }
    
    
    public void Deposite()
    {
        String sql="INSERT INTO DEPOSITE(Emp_ID,Account_No,Deposite_Date,Deposite_Time,Deposite_Amount,After_Deposite_Balance)  values(?,?,?,?,?,?)";
        try{

            pst=conn.prepareStatement(sql);

            pst.setString(1,jTextField19.getText());//Employee ID
            pst.setString(2,jTextField21.getText());//Account No
            pst.setString(3,((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText());//Deposite Date
            pst.setString(4,jTextField24.getText());//Deposite Time
            pst.setString(5,jTextField22.getText());//Deposite Amount
            pst.setString(6,jTextField20.getText());//After Deposite Employee Account Balance

            pst.execute();

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Employee Paygrade Error: "+ex);
        }
        
    }
    
    
    public void Withdraw()
    {
        String sql="INSERT INTO WITHDRAW(Emp_ID,Account_No,Withdraw_Date,Withdraw_Time,Withdraw_Amount,After_Withdraw_Balance)  values(?,?,?,?,?,?)";
        try{

            pst=conn.prepareStatement(sql);

            pst.setString(1,jTextField19.getText());//Employee ID
            pst.setString(2,jTextField21.getText());//Account No
            pst.setString(3,((JTextField)jDateChooser3.getDateEditor().getUiComponent()).getText());//Deposite Date
            pst.setString(4,jTextField24.getText());//Deposite Time
            pst.setString(5,jTextField23.getText());//Deposite Amount
            pst.setString(6,jTextField20.getText());//After Deposite Employee Account Balance

            pst.execute();

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Employee Paygrade Error: "+ex);
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        imageSet = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jTextField82 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jTextField76 = new javax.swing.JTextField();
        jTextField85 = new javax.swing.JTextField();
        jTextField74 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jTextField81 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jTextField75 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jTextField83 = new javax.swing.JTextField();
        jTextField84 = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jTextField31 = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jTextField19 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jTextField22 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel25 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel28 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jTextField45 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextField47 = new javax.swing.JTextField();
        jButton32 = new javax.swing.JButton();
        jTextField53 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jPanel15 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField55 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTextField54 = new javax.swing.JTextField();
        jButton34 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton33 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jTextField29 = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jTextField30 = new javax.swing.JTextField();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jTextField32 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jTextField37 = new javax.swing.JTextField();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jButton48 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jButton49 = new javax.swing.JButton();
        jTextField42 = new javax.swing.JTextField();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jTextField43 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jButton53 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jTextField67 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jTextField64 = new javax.swing.JTextField();
        jTextField68 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jTextField65 = new javax.swing.JTextField();
        jTextField66 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jTextField69 = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jTextField63 = new javax.swing.JTextField();
        jButton59 = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jTextField70 = new javax.swing.JTextField();
        jButton60 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jTextField72 = new javax.swing.JTextField();
        amount = new javax.swing.JRadioButton();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jButton61 = new javax.swing.JButton();
        percentage = new javax.swing.JRadioButton();
        jButton62 = new javax.swing.JButton();
        jTextField71 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jTextField79 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jTextField86 = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton64 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jButton69 = new javax.swing.JButton();
        jTextField87 = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        jTextField89 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jTextField80 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jButton66 = new javax.swing.JButton();
        jTextField90 = new javax.swing.JTextField();
        jPanel42 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel43 = new javax.swing.JPanel();
        jButton65 = new javax.swing.JButton();
        jTextField78 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jTextField88 = new javax.swing.JTextField();
        jPanel45 = new javax.swing.JPanel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton67 = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jButton70 = new javax.swing.JButton();
        jTextField92 = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jTextField91 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel48 = new javax.swing.JPanel();
        jTextField94 = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jTextField95 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jTextField96 = new javax.swing.JTextField();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel47 = new javax.swing.JPanel();
        jTextField99 = new javax.swing.JTextField();
        jTextField100 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jTextField97 = new javax.swing.JTextField();
        jTextField98 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox<>();
        jButton73 = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jTextField101 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jButton38 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jTextField35 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jTextField73 = new javax.swing.JTextField();
        jTextField108 = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jTextField116 = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jTextField56 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        jTextField58 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jTextField114 = new javax.swing.JTextField();
        jPanel50 = new javax.swing.JPanel();
        jTextField77 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jTextField93 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jTextField102 = new javax.swing.JTextField();
        jButton63 = new javax.swing.JButton();
        jPanel51 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jTextField103 = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jTextField104 = new javax.swing.JTextField();
        jTextField105 = new javax.swing.JTextField();
        jTextField106 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jButton71 = new javax.swing.JButton();
        jTextField107 = new javax.swing.JTextField();
        jPanel52 = new javax.swing.JPanel();
        jTextField109 = new javax.swing.JTextField();
        jTextField110 = new javax.swing.JTextField();
        jTextField111 = new javax.swing.JTextField();
        jTextField112 = new javax.swing.JTextField();
        jTextField113 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jDateChooser9 = new com.toedter.calendar.JDateChooser();
        jButton74 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel40 = new javax.swing.JPanel();
        jTextField62 = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel56 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jPanel58 = new javax.swing.JPanel();
        jButton88 = new javax.swing.JButton();
        jDateChooser10 = new com.toedter.calendar.JDateChooser();
        jTextField118 = new javax.swing.JTextField();
        jButton87 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jTextField117 = new javax.swing.JTextField();
        jButton83 = new javax.swing.JButton();
        jButton82 = new javax.swing.JButton();
        jButton90 = new javax.swing.JButton();
        jButton85 = new javax.swing.JButton();
        jButton80 = new javax.swing.JButton();
        jButton86 = new javax.swing.JButton();
        jButton81 = new javax.swing.JButton();
        jButton84 = new javax.swing.JButton();
        jComboBox9 = new javax.swing.JComboBox<>();
        jTextField115 = new javax.swing.JTextField();
        jDateChooser11 = new com.toedter.calendar.JDateChooser();
        jComboBox8 = new javax.swing.JComboBox<>();
        jTextField119 = new javax.swing.JTextField();
        jButton77 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jButton79 = new javax.swing.JButton();
        jButton89 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jPanel54 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel55 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField24 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 0));
        jLabel6.setText("Department ID");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(990, 540));

        jTabbedPane1.setBackground(new java.awt.Color(51, 0, 0));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 4));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(990, 421));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 0), 4));

        jPanel16.setBackground(new java.awt.Color(0, 51, 51));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jComboBox1.setBackground(new java.awt.Color(0, 153, 153));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(51, 0, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Department ID" }));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(53, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\show.png")); // NOI18N
        jButton2.setText("Show Departments");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(53, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\adddepartment.png")); // NOI18N
        jButton3.setText("Add Department");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, 0, 367, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(51, 153, 0));
        jTable1.setRowHeight(28);
        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Department", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 0), 4));

        jPanel18.setBackground(new java.awt.Color(0, 51, 51));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jComboBox2.setBackground(new java.awt.Color(0, 153, 153));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee ID" }));
        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(53, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\employee.png")); // NOI18N
        jButton4.setText("Employee");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(53, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\createaccount.png")); // NOI18N
        jButton5.setText("Join Employee");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 153, 153));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(53, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\business.png")); // NOI18N
        jButton6.setText("Admin");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 153, 153));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(53, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\createaccount.png")); // NOI18N
        jButton7.setText("Join Admin");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 2, true));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel27.setBackground(new java.awt.Color(0, 51, 51));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Photo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jDesktopPane1.setLayer(imageSet, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageSet, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageSet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        jPanel19.setBackground(new java.awt.Color(0, 51, 51));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Personal Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 204, 0));
        jLabel89.setText("Religion");

        jTextField82.setEditable(false);
        jTextField82.setBackground(new java.awt.Color(0, 102, 102));
        jTextField82.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField82.setName(""); // NOI18N

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 204, 0));
        jLabel80.setText("Employee ID");

        jTextField76.setEditable(false);
        jTextField76.setBackground(new java.awt.Color(0, 102, 102));
        jTextField76.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField76.setName(""); // NOI18N

        jTextField85.setEditable(false);
        jTextField85.setBackground(new java.awt.Color(0, 102, 102));
        jTextField85.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField85.setName(""); // NOI18N

        jTextField74.setEditable(false);
        jTextField74.setBackground(new java.awt.Color(0, 102, 102));
        jTextField74.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField74.setName(""); // NOI18N

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 204, 0));
        jLabel83.setText("Department ID");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 204, 0));
        jLabel86.setText("Age");

        jTextField81.setEditable(false);
        jTextField81.setBackground(new java.awt.Color(0, 102, 102));
        jTextField81.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField81.setName(""); // NOI18N

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 204, 0));
        jLabel85.setText("Date Of Join");

        jTextField75.setEditable(false);
        jTextField75.setBackground(new java.awt.Color(0, 102, 102));
        jTextField75.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField75.setName(""); // NOI18N

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 204, 0));
        jLabel88.setText("Gender");

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 204, 0));
        jLabel82.setText("Name");

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 204, 0));
        jLabel84.setText("Date Of Birth");

        jTextField83.setEditable(false);
        jTextField83.setBackground(new java.awt.Color(0, 102, 102));
        jTextField83.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField83.setName(""); // NOI18N

        jTextField84.setEditable(false);
        jTextField84.setBackground(new java.awt.Color(0, 102, 102));
        jTextField84.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField84.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel80)
                        .addComponent(jLabel82)
                        .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel89, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField75)
                        .addComponent(jTextField74)
                        .addComponent(jTextField81)
                        .addComponent(jTextField76, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField82)
                    .addComponent(jTextField85)
                    .addComponent(jTextField83, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField84))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField81, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField74, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField76, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField75, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField82, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jTextField83, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(jTextField84, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField85, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85))
                .addContainerGap())
        );

        jPanel21.setBackground(new java.awt.Color(0, 51, 51));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Address", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 204, 0));
        jLabel14.setText("City");

        jTextField11.setEditable(false);
        jTextField11.setBackground(new java.awt.Color(0, 102, 102));
        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField11.setName(""); // NOI18N

        jTextField12.setEditable(false);
        jTextField12.setBackground(new java.awt.Color(0, 102, 102));
        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField12.setName(""); // NOI18N

        jTextField15.setEditable(false);
        jTextField15.setBackground(new java.awt.Color(0, 102, 102));
        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField15.setName(""); // NOI18N

        jTextField13.setEditable(false);
        jTextField13.setBackground(new java.awt.Color(0, 102, 102));
        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField13.setName(""); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 204, 0));
        jLabel16.setText("Address");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 204, 0));
        jLabel34.setText("Nationality");

        jTextField14.setEditable(false);
        jTextField14.setBackground(new java.awt.Color(0, 102, 102));
        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField14.setName(""); // NOI18N

        jTextField16.setEditable(false);
        jTextField16.setBackground(new java.awt.Color(0, 102, 102));
        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField16.setName(""); // NOI18N

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 204, 0));
        jLabel76.setText("N ID");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 204, 0));
        jLabel77.setText("Email");

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 204, 0));
        jLabel79.setText("Phone");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel14)
                            .addComponent(jLabel76)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(jTextField13)
                                .addComponent(jTextField11))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(0, 51, 51));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Basic Salary", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jTextField31.setEditable(false);
        jTextField31.setBackground(new java.awt.Color(0, 102, 102));
        jTextField31.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField31.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField31, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel29.setBackground(new java.awt.Color(0, 51, 51));
        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jButton11.setBackground(new java.awt.Color(0, 153, 153));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\clear.png")); // NOI18N
        jButton11.setText("Clear");
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 153, 153));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\update.png")); // NOI18N
        jButton10.setText("Update");
        jButton10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 153, 153));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\delete.png")); // NOI18N
        jButton12.setText("Delete");
        jButton12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 153, 153));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\edit.png")); // NOI18N
        jButton9.setText("Edit");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(216, 216, 216))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("Employee", jPanel4);

        jPanel20.setBackground(new java.awt.Color(0, 51, 51));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 4));

        jPanel23.setBackground(new java.awt.Color(0, 51, 51));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Account Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 204, 0))); // NOI18N

        jTextField19.setBackground(new java.awt.Color(0, 102, 102));
        jTextField19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField19.setName(""); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 204, 0));
        jLabel21.setText("Employee Name");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 204, 0));
        jLabel22.setText("Balance");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 204, 0));
        jLabel24.setText("Total Balance");

        jTextField18.setBackground(new java.awt.Color(0, 102, 102));
        jTextField18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField18.setName(""); // NOI18N

        jTextField17.setBackground(new java.awt.Color(0, 102, 102));
        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField17.setName(""); // NOI18N

        jTextField20.setBackground(new java.awt.Color(0, 102, 102));
        jTextField20.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jTextField20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField20.setName(""); // NOI18N

        jTextField21.setBackground(new java.awt.Color(0, 102, 102));
        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField21.setName(""); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 204, 0));
        jLabel25.setText("Account No");

        jButton19.setBackground(new java.awt.Color(0, 153, 153));
        jButton19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\clear.png")); // NOI18N
        jButton19.setText("Clear");
        jButton19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 204, 0));
        jLabel23.setText("Employee ID");

        jButton37.setBackground(new java.awt.Color(0, 153, 153));
        jButton37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton37.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\delete.png")); // NOI18N
        jButton37.setText("Delete");
        jButton37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                            .addComponent(jTextField21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField20, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel24.setBackground(new java.awt.Color(0, 51, 51));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Deposite", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 204, 0))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 204, 0));
        jLabel26.setText("Amount");

        jButton13.setBackground(new java.awt.Color(0, 153, 153));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\deposit.png")); // NOI18N
        jButton13.setText("Deposite");
        jButton13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jTextField22.setBackground(new java.awt.Color(0, 102, 102));
        jTextField22.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jTextField22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField22.setName(""); // NOI18N

        jButton15.setBackground(new java.awt.Color(0, 153, 153));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\total.png")); // NOI18N
        jButton15.setText("Total Amount");
        jButton15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 153, 153));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\clear.png")); // NOI18N
        jButton16.setText("Clear");
        jButton16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jDateChooser2.setBackground(new java.awt.Color(51, 0, 51));
        jDateChooser2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 2));
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField22))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBackground(new java.awt.Color(0, 51, 51));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Withdraw", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 204, 0))); // NOI18N

        jButton18.setBackground(new java.awt.Color(0, 153, 153));
        jButton18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\clear.png")); // NOI18N
        jButton18.setText("Clear");
        jButton18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 204, 0));
        jLabel27.setText("Amount");

        jTextField23.setBackground(new java.awt.Color(0, 102, 102));
        jTextField23.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jTextField23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField23.setName(""); // NOI18N

        jButton17.setBackground(new java.awt.Color(0, 153, 153));
        jButton17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\total.png")); // NOI18N
        jButton17.setText("Total Amount");
        jButton17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(0, 153, 153));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\withdraw.png")); // NOI18N
        jButton14.setText("Withdraw");
        jButton14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jDateChooser3.setBackground(new java.awt.Color(51, 0, 51));
        jDateChooser3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 2));
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField23))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(0, 51, 51));
        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jButton21.setBackground(new java.awt.Color(0, 153, 153));
        jButton21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\show.png")); // NOI18N
        jButton21.setText("Show Accounts");
        jButton21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(0, 153, 153));
        jButton20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\createaccount.png")); // NOI18N
        jButton20.setText("Add Employee Saving Account");
        jButton20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setText("Employee ID");

        jTextField3.setBackground(new java.awt.Color(0, 102, 102));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 2));

        jButton8.setBackground(new java.awt.Color(0, 153, 153));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\find.png")); // NOI18N
        jButton8.setText("Find");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Employee Account", jPanel20);

        jPanel13.setBackground(new java.awt.Color(0, 51, 51));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jPanel26.setBackground(new java.awt.Color(0, 51, 51));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Project Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 204, 0));
        jLabel51.setText("Foreign Corporation");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 204, 0));
        jLabel45.setText("Project Name");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 204, 0));
        jLabel44.setText("Employee ID");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 204, 0));
        jLabel49.setText("Cost Amount");

        jTextField45.setBackground(new java.awt.Color(0, 102, 102));
        jTextField45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField45.setName(""); // NOI18N

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 204, 0));
        jLabel50.setText("Project Leader ID");

        jTextField47.setBackground(new java.awt.Color(0, 102, 102));
        jTextField47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField47.setName(""); // NOI18N

        jButton32.setBackground(new java.awt.Color(0, 153, 153));
        jButton32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton32.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\confirm.png")); // NOI18N
        jButton32.setText("Confirm");
        jButton32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jTextField53.setBackground(new java.awt.Color(0, 102, 102));
        jTextField53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField53.setName(""); // NOI18N
        jTextField53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField53ActionPerformed(evt);
            }
        });

        jTextField44.setBackground(new java.awt.Color(0, 102, 102));
        jTextField44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField44.setName(""); // NOI18N
        jTextField44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField44ActionPerformed(evt);
            }
        });

        jTextField50.setBackground(new java.awt.Color(0, 102, 102));
        jTextField50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField50.setName(""); // NOI18N

        jTextField51.setBackground(new java.awt.Color(0, 102, 102));
        jTextField51.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField51.setName(""); // NOI18N

        jTextField48.setBackground(new java.awt.Color(0, 102, 102));
        jTextField48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField48.setName(""); // NOI18N

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 204, 0));
        jLabel47.setText("From Date");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 204, 0));
        jLabel48.setText("To date");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 204, 0));
        jLabel46.setText("Destination");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 204, 0));
        jLabel54.setText("Project NO");

        jDateChooser7.setBackground(new java.awt.Color(51, 0, 51));
        jDateChooser7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 2));
        jDateChooser7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jDateChooser8.setBackground(new java.awt.Color(51, 0, 51));
        jDateChooser8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 2));
        jDateChooser8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47)
                    .addComponent(jLabel45)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel48)
                        .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel50)
                    .addComponent(jLabel44)
                    .addComponent(jLabel54)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField48, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jDateChooser8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField44)
                    .addComponent(jTextField51)
                    .addComponent(jTextField47)
                    .addComponent(jTextField45)
                    .addComponent(jTextField50)
                    .addComponent(jTextField53, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jDateChooser7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jDateChooser7, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser8, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel48)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(0, 51, 51));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 204, 0));
        jLabel52.setText("Foreign Corporation");

        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTable2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.setRowHeight(28);
        jTable2.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jScrollPane2.setViewportView(jTable2);

        jTextField55.setBackground(new java.awt.Color(0, 102, 102));
        jTextField55.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField55.setName(""); // NOI18N
        jTextField55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField55ActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 204, 0));
        jLabel53.setText("Project Name");

        jTextField54.setBackground(new java.awt.Color(0, 102, 102));
        jTextField54.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField54.setName(""); // NOI18N
        jTextField54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField54ActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(0, 153, 153));
        jButton34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton34.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\complete.png")); // NOI18N
        jButton34.setText("Complete");
        jButton34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField54, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(jTextField55))))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton34))
        );

        jPanel30.setBackground(new java.awt.Color(0, 51, 51));
        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jComboBox3.setBackground(new java.awt.Color(0, 153, 153));
        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(51, 0, 51));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Project No" }));
        jComboBox3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(0, 153, 153));
        jButton33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton33.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\show.png")); // NOI18N
        jButton33.setText("Show");
        jButton33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton33)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Corporate Travel", jPanel13);

        jPanel7.setBackground(new java.awt.Color(0, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jPanel12.setBackground(new java.awt.Color(0, 51, 51));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Apply for Allowance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 204, 0))); // NOI18N

        jTextField29.setBackground(new java.awt.Color(0, 102, 102));
        jTextField29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField29.setName(""); // NOI18N

        jButton29.setBackground(new java.awt.Color(0, 153, 153));
        jButton29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton29.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\yes.png")); // NOI18N
        jButton29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(0, 153, 153));
        jButton23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton23.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\no.png")); // NOI18N
        jButton23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(0, 153, 153));
        jButton26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton26.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\no.png")); // NOI18N
        jButton26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(0, 153, 153));
        jButton28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton28.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\no.png")); // NOI18N
        jButton28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(0, 153, 153));
        jButton27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton27.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\yes.png")); // NOI18N
        jButton27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 204, 0));
        jLabel31.setText("Meals allowance");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 204, 0));
        jLabel28.setText("Fixed medical allowance");

        jTextField27.setBackground(new java.awt.Color(0, 102, 102));
        jTextField27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField27.setName(""); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 204, 0));
        jLabel29.setText("Employee ID");

        jTextField26.setBackground(new java.awt.Color(0, 102, 102));
        jTextField26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField26.setName(""); // NOI18N
        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });

        jTextField25.setBackground(new java.awt.Color(0, 102, 102));
        jTextField25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField25.setName(""); // NOI18N
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 204, 0));
        jLabel32.setText("Travel Allowance");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 204, 0));
        jLabel30.setText("House Rent Allowance");

        jTextField28.setBackground(new java.awt.Color(0, 102, 102));
        jTextField28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField28.setName(""); // NOI18N

        jButton22.setBackground(new java.awt.Color(0, 153, 153));
        jButton22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton22.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\yes.png")); // NOI18N
        jButton22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jTextField30.setBackground(new java.awt.Color(0, 102, 102));
        jTextField30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField30.setName(""); // NOI18N

        jButton30.setBackground(new java.awt.Color(0, 153, 153));
        jButton30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton30.setForeground(new java.awt.Color(51, 0, 51));
        jButton30.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\total.png")); // NOI18N
        jButton30.setText("Total Amount");
        jButton30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(0, 153, 153));
        jButton31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton31.setForeground(new java.awt.Color(51, 0, 51));
        jButton31.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\apply.png")); // NOI18N
        jButton31.setText("Apply");
        jButton31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton56.setBackground(new java.awt.Color(0, 153, 153));
        jButton56.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton56.setForeground(new java.awt.Color(51, 0, 51));
        jButton56.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\clear.png")); // NOI18N
        jButton56.setText("Clear");
        jButton56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(0, 153, 153));
        jButton24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton24.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\yes.png")); // NOI18N
        jButton24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(0, 153, 153));
        jButton25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton25.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\no.png")); // NOI18N
        jButton25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jTextField32.setBackground(new java.awt.Color(0, 102, 102));
        jTextField32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField32.setName(""); // NOI18N
        jTextField32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField32ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 204, 0));
        jLabel36.setText("Name");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel29)
                            .addComponent(jLabel32)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField26, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(jTextField27)
                                    .addComponent(jTextField28)
                                    .addComponent(jTextField29)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jTextField25))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(jButton56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField30)
                            .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(153, 153, 153)
                        .addComponent(jTextField32)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(0, 51, 51));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Find Employee Allowance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 204, 0))); // NOI18N

        jTextField37.setEditable(false);
        jTextField37.setBackground(new java.awt.Color(0, 102, 102));
        jTextField37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField37.setName(""); // NOI18N

        jButton42.setBackground(new java.awt.Color(0, 153, 153));
        jButton42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton42.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\yes.png")); // NOI18N
        jButton42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setBackground(new java.awt.Color(0, 153, 153));
        jButton43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton43.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\no.png")); // NOI18N
        jButton43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.setBackground(new java.awt.Color(0, 153, 153));
        jButton44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton44.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\no.png")); // NOI18N
        jButton44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setBackground(new java.awt.Color(0, 153, 153));
        jButton45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton45.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\no.png")); // NOI18N
        jButton45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton46.setBackground(new java.awt.Color(0, 153, 153));
        jButton46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton46.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\no.png")); // NOI18N
        jButton46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton47.setBackground(new java.awt.Color(0, 153, 153));
        jButton47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton47.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\yes.png")); // NOI18N
        jButton47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 204, 0));
        jLabel38.setText("Meals allowance");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 204, 0));
        jLabel39.setText("Fixed medical allowance");

        jTextField38.setEditable(false);
        jTextField38.setBackground(new java.awt.Color(0, 102, 102));
        jTextField38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField38.setName(""); // NOI18N

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 204, 0));
        jLabel40.setText("Paygrade ID");

        jTextField39.setEditable(false);
        jTextField39.setBackground(new java.awt.Color(0, 102, 102));
        jTextField39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField39.setName(""); // NOI18N

        jTextField40.setBackground(new java.awt.Color(0, 102, 102));
        jTextField40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField40.setName(""); // NOI18N

        jButton48.setBackground(new java.awt.Color(0, 153, 153));
        jButton48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton48.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\yes.png")); // NOI18N
        jButton48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 204, 0));
        jLabel41.setText("Travel Allowence");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 204, 0));
        jLabel42.setText("House Rent Allowance");

        jTextField41.setEditable(false);
        jTextField41.setBackground(new java.awt.Color(0, 102, 102));
        jTextField41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField41.setName(""); // NOI18N

        jButton49.setBackground(new java.awt.Color(0, 153, 153));
        jButton49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton49.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\yes.png")); // NOI18N
        jButton49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jTextField42.setBackground(new java.awt.Color(0, 102, 102));
        jTextField42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField42.setName(""); // NOI18N

        jButton50.setBackground(new java.awt.Color(0, 153, 153));
        jButton50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton50.setForeground(new java.awt.Color(51, 0, 51));
        jButton50.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\total.png")); // NOI18N
        jButton50.setText("Total Amount");
        jButton50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jButton51.setBackground(new java.awt.Color(0, 153, 153));
        jButton51.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton51.setForeground(new java.awt.Color(51, 0, 51));
        jButton51.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\delete.png")); // NOI18N
        jButton51.setText("Delete");
        jButton51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        jButton52.setBackground(new java.awt.Color(0, 153, 153));
        jButton52.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton52.setForeground(new java.awt.Color(51, 0, 51));
        jButton52.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\edit.png")); // NOI18N
        jButton52.setText("Edit");
        jButton52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jButton54.setBackground(new java.awt.Color(0, 153, 153));
        jButton54.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton54.setForeground(new java.awt.Color(51, 0, 51));
        jButton54.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\find.png")); // NOI18N
        jButton54.setText("Find");
        jButton54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jButton55.setBackground(new java.awt.Color(0, 153, 153));
        jButton55.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton55.setForeground(new java.awt.Color(51, 0, 51));
        jButton55.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\update.png")); // NOI18N
        jButton55.setText("Update");
        jButton55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jTextField43.setBackground(new java.awt.Color(0, 102, 102));
        jTextField43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField43.setName(""); // NOI18N

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 204, 0));
        jLabel43.setText("Employee ID");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton51, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel38)
                                .addComponent(jLabel42)
                                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel40))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton48, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(jButton49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField41, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField38, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField37)
                                    .addComponent(jTextField39, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jTextField42, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField40))))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton53.setBackground(new java.awt.Color(0, 153, 153));
        jButton53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton53.setForeground(new java.awt.Color(51, 0, 51));
        jButton53.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\show.png")); // NOI18N
        jButton53.setText("Show Employee");
        jButton53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pay Grade", jPanel7);

        jPanel9.setBackground(new java.awt.Color(0, 51, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 51), 4));

        jPanel17.setBackground(new java.awt.Color(0, 51, 51));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Employee", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jTextField67.setBackground(new java.awt.Color(0, 102, 102));
        jTextField67.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField67.setName(""); // NOI18N

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 204, 0));
        jLabel65.setText("Department");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 204, 0));
        jLabel66.setText("Address");

        jTextField64.setBackground(new java.awt.Color(0, 102, 102));
        jTextField64.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField64.setName(""); // NOI18N

        jTextField68.setBackground(new java.awt.Color(0, 102, 102));
        jTextField68.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField68.setName(""); // NOI18N

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 204, 0));
        jLabel58.setText("Name");

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 204, 0));
        jLabel67.setText("Email");

        jTextField65.setBackground(new java.awt.Color(0, 102, 102));
        jTextField65.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField65.setName(""); // NOI18N

        jTextField66.setBackground(new java.awt.Color(0, 102, 102));
        jTextField66.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField66.setName(""); // NOI18N

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 204, 0));
        jLabel69.setText("Basic Salary");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 204, 0));
        jLabel68.setText("Phone");

        jTextField69.setBackground(new java.awt.Color(0, 102, 102));
        jTextField69.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField69.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addComponent(jLabel58)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67)
                    .addComponent(jLabel68)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField66, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(jTextField64)
                    .addComponent(jTextField65)
                    .addComponent(jTextField67)
                    .addComponent(jTextField68)
                    .addComponent(jTextField69))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel35.setBackground(new java.awt.Color(0, 51, 51));
        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 204, 0));
        jLabel33.setText("Employee ID");

        jTextField63.setBackground(new java.awt.Color(0, 102, 102));
        jTextField63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField63.setName(""); // NOI18N

        jButton59.setBackground(new java.awt.Color(0, 153, 153));
        jButton59.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton59.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\find.png")); // NOI18N
        jButton59.setText("Find");
        jButton59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addGap(23, 23, 23)
                .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton59, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel36.setBackground(new java.awt.Color(0, 51, 51));
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Increase Salary", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jTextField70.setEditable(false);
        jTextField70.setBackground(new java.awt.Color(0, 102, 102));
        jTextField70.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField70.setName(""); // NOI18N

        jButton60.setBackground(new java.awt.Color(0, 153, 153));
        jButton60.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton60.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\yes.png")); // NOI18N
        jButton60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 204, 0));
        jLabel70.setText("Update Salary By:");

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 204, 0));
        jLabel73.setText("Total");

        jTextField72.setBackground(new java.awt.Color(0, 102, 102));
        jTextField72.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField72.setName(""); // NOI18N

        amount.setBackground(new java.awt.Color(0, 153, 102));
        amount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        amount.setForeground(new java.awt.Color(0, 255, 204));
        amount.setText("Amount");
        amount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 204, 0));
        jLabel71.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\percentage.png")); // NOI18N

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 204, 0));
        jLabel72.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\dollar.png")); // NOI18N

        jButton61.setBackground(new java.awt.Color(0, 153, 153));
        jButton61.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton61.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\yes.png")); // NOI18N
        jButton61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        percentage.setBackground(new java.awt.Color(0, 153, 102));
        percentage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        percentage.setForeground(new java.awt.Color(0, 255, 204));
        percentage.setText("Percentage(%)");
        percentage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        percentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentageActionPerformed(evt);
            }
        });

        jButton62.setBackground(new java.awt.Color(0, 153, 153));
        jButton62.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton62.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\increase.png")); // NOI18N
        jButton62.setText("Incerase Salary");
        jButton62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        jTextField71.setEditable(false);
        jTextField71.setBackground(new java.awt.Color(0, 102, 102));
        jTextField71.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField71.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel70)
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel72)
                        .addComponent(jLabel71))
                    .addComponent(jLabel73))
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField72)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(percentage)
                            .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amount, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jButton60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentage)
                    .addComponent(amount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField72, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Salary Increase", jPanel9);

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 51), 4));

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 204, 0));
        jLabel78.setText("Holidays are left");

        jTextField79.setBackground(new java.awt.Color(0, 102, 102));
        jTextField79.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jTextField79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField79.setName(""); // NOI18N

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 204, 0));
        jLabel87.setText("Personal Holidays");

        jTextField86.setEditable(false);
        jTextField86.setBackground(new java.awt.Color(0, 102, 102));
        jTextField86.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jTextField86.setText("25");
        jTextField86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField86.setName(""); // NOI18N

        jPanel37.setBackground(new java.awt.Color(0, 51, 51));
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Reason", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(0, 153, 102));
        jTextArea2.setColumns(40);
        jTextArea2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane5.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );

        jButton64.setBackground(new java.awt.Color(0, 153, 153));
        jButton64.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton64.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\notapprove.png")); // NOI18N
        jButton64.setText("Not Approve");
        jButton64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        jButton68.setBackground(new java.awt.Color(0, 153, 153));
        jButton68.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton68.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\approval.png")); // NOI18N
        jButton68.setText("Approve");
        jButton68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton68ActionPerformed(evt);
            }
        });

        jDateChooser5.setBackground(new java.awt.Color(51, 0, 51));
        jDateChooser5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 2));
        jDateChooser5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton69.setBackground(new java.awt.Color(0, 153, 153));
        jButton69.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton69.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\checked.png")); // NOI18N
        jButton69.setText("Check");
        jButton69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });

        jTextField87.setBackground(new java.awt.Color(0, 102, 102));
        jTextField87.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jTextField87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField87.setName(""); // NOI18N

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 204, 0));
        jLabel96.setText("Total Days");

        jTextField89.setBackground(new java.awt.Color(0, 102, 102));
        jTextField89.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jTextField89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField89.setName(""); // NOI18N

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 204, 0));
        jLabel97.setText("Leave ID");

        jPanel39.setBackground(new java.awt.Color(0, 51, 51));
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Employee", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jTable3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jTable3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable3.setRowHeight(28);
        jTable3.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel87)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField86))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel78)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField79)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel96)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField87, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel97)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField89, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField86, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton69, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField89, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField79, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField87, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("LeaveMS", jPanel5);

        jPanel34.setBackground(new java.awt.Color(0, 51, 51));
        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 4));

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 204, 0));

        jPanel41.setBackground(new java.awt.Color(0, 51, 51));
        jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 204, 0));
        jLabel95.setText("Running Month");

        jTextField80.setBackground(new java.awt.Color(0, 102, 102));
        jTextField80.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField80.setName(""); // NOI18N
        jTextField80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField80ActionPerformed(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 204, 0));
        jLabel94.setText("Name");

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 204, 0));
        jLabel93.setText("Current date");

        jDateChooser4.setBackground(new java.awt.Color(51, 0, 51));
        jDateChooser4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 2));
        jDateChooser4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton66.setBackground(new java.awt.Color(0, 153, 153));
        jButton66.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton66.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\assign.png")); // NOI18N
        jButton66.setText("Assign");
        jButton66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });

        jTextField90.setBackground(new java.awt.Color(0, 102, 102));
        jTextField90.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField90.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField90.setName(""); // NOI18N
        jTextField90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField90ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel94)
                    .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField80)
                    .addComponent(jButton66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField90))
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField80, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField90, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.setBackground(new java.awt.Color(0, 51, 51));
        jPanel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jTable4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable4.setRowHeight(28);
        jScrollPane6.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        jPanel43.setBackground(new java.awt.Color(0, 51, 51));
        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Find Employee", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 255, 0))); // NOI18N

        jButton65.setBackground(new java.awt.Color(0, 153, 153));
        jButton65.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton65.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\find.png")); // NOI18N
        jButton65.setText("Find");
        jButton65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });

        jTextField78.setBackground(new java.awt.Color(0, 102, 102));
        jTextField78.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField78.setName(""); // NOI18N
        jTextField78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField78ActionPerformed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(0, 204, 0));
        jLabel91.setText("Employee ID");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel91)
                .addGap(18, 18, 18)
                .addComponent(jTextField78, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField78, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel44.setBackground(new java.awt.Color(0, 51, 51));
        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "No of Working Days", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 255, 0))); // NOI18N

        jComboBox6.setBackground(new java.awt.Color(0, 153, 102));
        jComboBox6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox6.setForeground(new java.awt.Color(51, 0, 51));
        jComboBox6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jComboBox6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jTextField88.setBackground(new java.awt.Color(0, 102, 102));
        jTextField88.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField88.setName(""); // NOI18N
        jTextField88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField88ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jComboBox6, 0, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField88, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField88, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel45.setBackground(new java.awt.Color(0, 51, 51));
        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Employee ID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 255, 0))); // NOI18N

        jComboBox4.setBackground(new java.awt.Color(0, 153, 102));
        jComboBox4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee ID" }));
        jComboBox4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox4, 0, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButton67.setBackground(new java.awt.Color(0, 153, 153));
        jButton67.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton67.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\overtimex.png")); // NOI18N
        jButton67.setText("Show Employee");
        jButton67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(356, 356, 356)
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(383, 383, 383))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(418, 418, 418))
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Overtime Tracking", jPanel34);

        jPanel38.setBackground(new java.awt.Color(0, 51, 51));
        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 4));

        jPanel46.setBackground(new java.awt.Color(0, 51, 51));
        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Find Employee", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jButton70.setBackground(new java.awt.Color(0, 153, 153));
        jButton70.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton70.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\find.png")); // NOI18N
        jButton70.setText("Find");
        jButton70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70ActionPerformed(evt);
            }
        });

        jTextField92.setBackground(new java.awt.Color(0, 102, 102));
        jTextField92.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField92.setName(""); // NOI18N
        jTextField92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField92ActionPerformed(evt);
            }
        });

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 204, 0));
        jLabel99.setText("Employee ID");

        jTextField91.setBackground(new java.awt.Color(0, 102, 102));
        jTextField91.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField91.setName(""); // NOI18N
        jTextField91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField91ActionPerformed(evt);
            }
        });

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 204, 0));
        jLabel98.setText("Name");

        jComboBox5.setBackground(new java.awt.Color(0, 153, 102));
        jComboBox5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Month" }));
        jComboBox5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jComboBox5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99)
                    .addComponent(jLabel98))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField91, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jTextField92, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField92, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField91, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel48.setBackground(new java.awt.Color(0, 51, 51));
        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Activity", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jTextField94.setEditable(false);
        jTextField94.setBackground(new java.awt.Color(0, 102, 102));
        jTextField94.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(0, 204, 0));
        jLabel101.setText("Present");

        jTextField95.setEditable(false);
        jTextField95.setBackground(new java.awt.Color(0, 102, 102));
        jTextField95.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(0, 204, 0));
        jLabel102.setText("Absent");

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(0, 204, 0));
        jLabel103.setText("Late");

        jTextField96.setEditable(false);
        jTextField96.setBackground(new java.awt.Color(0, 102, 102));
        jTextField96.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField96, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jTextField95, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jTextField94))
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField94, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField95, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField96, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel49.setBackground(new java.awt.Color(0, 51, 51));
        jPanel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jTable5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable5.setRowHeight(28);
        jTable5.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jScrollPane7.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel47.setBackground(new java.awt.Color(0, 51, 51));
        jPanel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jTextField99.setBackground(new java.awt.Color(0, 102, 102));
        jTextField99.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField99.setName(""); // NOI18N
        jTextField99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField99ActionPerformed(evt);
            }
        });

        jTextField100.setBackground(new java.awt.Color(0, 102, 102));
        jTextField100.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField100.setName(""); // NOI18N
        jTextField100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField100ActionPerformed(evt);
            }
        });

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(0, 204, 0));
        jLabel104.setText("Employee");

        jTextField97.setBackground(new java.awt.Color(0, 102, 102));
        jTextField97.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField97.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField97.setName(""); // NOI18N
        jTextField97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField97ActionPerformed(evt);
            }
        });

        jTextField98.setBackground(new java.awt.Color(0, 102, 102));
        jTextField98.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField98.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField98.setName(""); // NOI18N
        jTextField98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField98ActionPerformed(evt);
            }
        });

        jComboBox7.setBackground(new java.awt.Color(0, 153, 102));
        jComboBox7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Month" }));
        jComboBox7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jButton73.setBackground(new java.awt.Color(0, 153, 153));
        jButton73.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton73.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\checked.png")); // NOI18N
        jButton73.setText("Check");
        jButton73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton73ActionPerformed(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(0, 204, 0));
        jLabel105.setText("Present");

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 204, 0));
        jLabel106.setText("Absent");

        jDateChooser6.setBackground(new java.awt.Color(51, 0, 51));
        jDateChooser6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 2));
        jDateChooser6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jTextField101.setBackground(new java.awt.Color(0, 102, 102));
        jTextField101.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField101.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField101.setName(""); // NOI18N
        jTextField101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField101ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel104)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField97, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel105)
                            .addComponent(jLabel106))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField100)
                            .addComponent(jTextField99)))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField98)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField101, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox7, 0, 210, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField97, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField98, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField101, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField99, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton73, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField100, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 101, Short.MAX_VALUE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Attendance", jPanel38);

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jPanel31.setBackground(new java.awt.Color(0, 51, 51));
        jPanel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jTextField4.setBackground(new java.awt.Color(0, 102, 102));
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 2));

        jButton38.setBackground(new java.awt.Color(0, 153, 153));
        jButton38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton38.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\find.png")); // NOI18N
        jButton38.setText("Find");
        jButton38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 0));
        jLabel7.setText("Employee ID");

        jButton39.setBackground(new java.awt.Color(0, 153, 153));
        jButton39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton39.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\paygrade.png")); // NOI18N
        jButton39.setText("Paygrade");
        jButton39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton40.setBackground(new java.awt.Color(0, 153, 153));
        jButton40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton40.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\leave.png")); // NOI18N
        jButton40.setText("Attendance");
        jButton40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton41.setBackground(new java.awt.Color(0, 153, 153));
        jButton41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton41.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\overtime.png")); // NOI18N
        jButton41.setText("Overtime");
        jButton41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton72.setBackground(new java.awt.Color(0, 153, 153));
        jButton72.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton72.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\leave.png")); // NOI18N
        jButton72.setText("Payroll");
        jButton72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton72ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel32.setBackground(new java.awt.Color(0, 51, 51));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "PayGrade", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jTextField35.setEditable(false);
        jTextField35.setBackground(new java.awt.Color(0, 102, 102));
        jTextField35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField35.setName(""); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 204, 0));
        jLabel35.setText("Dept Name");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 204, 0));
        jLabel56.setText("Phone");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 204, 0));
        jLabel55.setText("Email");

        jTextField34.setEditable(false);
        jTextField34.setBackground(new java.awt.Color(0, 102, 102));
        jTextField34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField34.setName(""); // NOI18N

        jTextField52.setEditable(false);
        jTextField52.setBackground(new java.awt.Color(0, 102, 102));
        jTextField52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField52.setName(""); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 204, 0));
        jLabel37.setText("Name");

        jTextField36.setEditable(false);
        jTextField36.setBackground(new java.awt.Color(0, 102, 102));
        jTextField36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField36.setName(""); // NOI18N

        jTextField33.setEditable(false);
        jTextField33.setBackground(new java.awt.Color(0, 102, 102));
        jTextField33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField33.setName(""); // NOI18N

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 204, 0));
        jLabel57.setText("Salary");

        jTextField73.setEditable(false);
        jTextField73.setBackground(new java.awt.Color(0, 102, 102));
        jTextField73.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField73.setName(""); // NOI18N

        jTextField108.setEditable(false);
        jTextField108.setBackground(new java.awt.Color(0, 102, 102));
        jTextField108.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField108.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField108.setName(""); // NOI18N

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 204, 0));
        jLabel100.setText("Bonus");

        jTextField116.setBackground(new java.awt.Color(0, 102, 102));
        jTextField116.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField116.setText("0000");
        jTextField116.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField116.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(8, 8, 8)))
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField108, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel100)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField116, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField108, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField116, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(0, 51, 51));
        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "PayGrade", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 204, 0));
        jLabel63.setText("Meals");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 204, 0));
        jLabel59.setText("Paygrade ID");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 204, 0));
        jLabel61.setText("Travel");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 204, 0));
        jLabel60.setText("Medical");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 204, 0));
        jLabel62.setText("House Rent");

        jTextField56.setEditable(false);
        jTextField56.setBackground(new java.awt.Color(0, 102, 102));
        jTextField56.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField56.setName(""); // NOI18N

        jTextField57.setEditable(false);
        jTextField57.setBackground(new java.awt.Color(0, 102, 102));
        jTextField57.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField57.setName(""); // NOI18N

        jTextField58.setEditable(false);
        jTextField58.setBackground(new java.awt.Color(0, 102, 102));
        jTextField58.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField58.setName(""); // NOI18N

        jTextField59.setEditable(false);
        jTextField59.setBackground(new java.awt.Color(0, 102, 102));
        jTextField59.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField59.setName(""); // NOI18N

        jTextField60.setEditable(false);
        jTextField60.setBackground(new java.awt.Color(0, 102, 102));
        jTextField60.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField60.setName(""); // NOI18N

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(0, 204, 0));
        jLabel109.setText("Total");

        jTextField114.setEditable(false);
        jTextField114.setBackground(new java.awt.Color(0, 102, 102));
        jTextField114.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField114.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField114.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63)
                    .addComponent(jLabel109)
                    .addComponent(jLabel60)
                    .addComponent(jLabel59)
                    .addComponent(jLabel61))
                .addGap(3, 3, 3)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField58, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField114)
                    .addComponent(jTextField60)
                    .addComponent(jTextField59)
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField56)
                        .addComponent(jTextField57, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField56, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField57, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField58, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField114, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel50.setBackground(new java.awt.Color(0, 51, 51));
        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Overtime", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 255, 51))); // NOI18N

        jTextField77.setEditable(false);
        jTextField77.setBackground(new java.awt.Color(0, 102, 102));
        jTextField77.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField77.setName(""); // NOI18N

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 204, 0));
        jLabel74.setText("Working Days");

        jTable6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable6.setRowHeight(28);
        jTable6.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jScrollPane8.setViewportView(jTable6);

        jTextField93.setEditable(false);
        jTextField93.setBackground(new java.awt.Color(0, 102, 102));
        jTextField93.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField93.setText("250");
        jTextField93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField93.setName(""); // NOI18N

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 204, 0));
        jLabel75.setText("D per Amount");

        jTextField102.setEditable(false);
        jTextField102.setBackground(new java.awt.Color(0, 102, 102));
        jTextField102.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField102.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField102.setName(""); // NOI18N

        jButton63.setBackground(new java.awt.Color(0, 153, 153));
        jButton63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton63.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\total.png")); // NOI18N
        jButton63.setText("Total");
        jButton63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel50Layout.createSequentialGroup()
                                .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField102))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel50Layout.createSequentialGroup()
                                .addComponent(jLabel74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField77)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField93, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField77, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField93, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField102, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel51.setBackground(new java.awt.Color(0, 51, 51));
        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Attendance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 255, 0))); // NOI18N

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 204, 0));
        jLabel107.setText("Present");

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(0, 204, 0));
        jLabel108.setText("Absent");

        jTextField103.setEditable(false);
        jTextField103.setBackground(new java.awt.Color(0, 102, 102));
        jTextField103.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField103.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField103.setName(""); // NOI18N

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 204, 0));
        jLabel110.setText("Late");

        jTextField104.setEditable(false);
        jTextField104.setBackground(new java.awt.Color(0, 102, 102));
        jTextField104.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField104.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField104.setName(""); // NOI18N

        jTextField105.setEditable(false);
        jTextField105.setBackground(new java.awt.Color(0, 102, 102));
        jTextField105.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField105.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField105.setName(""); // NOI18N

        jTextField106.setEditable(false);
        jTextField106.setBackground(new java.awt.Color(0, 102, 102));
        jTextField106.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField106.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField106.setName(""); // NOI18N

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 204, 0));
        jLabel114.setText("Extra L");

        jButton71.setBackground(new java.awt.Color(0, 153, 153));
        jButton71.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton71.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\total.png")); // NOI18N
        jButton71.setText("Total");
        jButton71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton71ActionPerformed(evt);
            }
        });

        jTextField107.setEditable(false);
        jTextField107.setBackground(new java.awt.Color(0, 102, 102));
        jTextField107.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField107.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField107.setName(""); // NOI18N
        jTextField107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField107ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField107, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField106))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel108)
                            .addComponent(jLabel107)
                            .addComponent(jLabel110))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField105)
                            .addComponent(jTextField103)
                            .addComponent(jTextField104))))
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField103, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField104, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField105, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField106, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton71, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jTextField107, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel52.setBackground(new java.awt.Color(0, 51, 51));
        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 4), "Payroll", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 102, 102))); // NOI18N

        jTextField109.setEditable(false);
        jTextField109.setBackground(new java.awt.Color(0, 102, 102));
        jTextField109.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField109.setName(""); // NOI18N

        jTextField110.setEditable(false);
        jTextField110.setBackground(new java.awt.Color(0, 102, 102));
        jTextField110.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField110.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField110.setName(""); // NOI18N

        jTextField111.setEditable(false);
        jTextField111.setBackground(new java.awt.Color(0, 102, 102));
        jTextField111.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField111.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField111.setName(""); // NOI18N

        jTextField112.setEditable(false);
        jTextField112.setBackground(new java.awt.Color(0, 102, 102));
        jTextField112.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField112.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField112.setName(""); // NOI18N

        jTextField113.setEditable(false);
        jTextField113.setBackground(new java.awt.Color(0, 102, 102));
        jTextField113.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField113.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField113.setName(""); // NOI18N

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 204, 0));
        jLabel64.setText("Salary");

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(0, 204, 0));
        jLabel115.setText("Pay Grade");

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(0, 204, 0));
        jLabel116.setText("Overtime");

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 204, 0));
        jLabel117.setText("Attendance");

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 204, 0));
        jLabel118.setText("Net Salary");

        jDateChooser9.setBackground(new java.awt.Color(51, 0, 51));
        jDateChooser9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 2));
        jDateChooser9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton74.setBackground(new java.awt.Color(0, 153, 153));
        jButton74.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton74.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\checked.png")); // NOI18N
        jButton74.setText("Done");
        jButton74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jButton74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton74ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel117)
                            .addComponent(jLabel116)
                            .addComponent(jLabel115)
                            .addComponent(jLabel64)
                            .addComponent(jLabel118))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField112, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField113)
                            .addComponent(jTextField109, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField110)
                            .addComponent(jTextField111)))
                    .addComponent(jButton74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField109, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField110, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField111, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField113, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField112, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton74, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Payroll", jPanel6);

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0), 4));

        jButton57.setBackground(new java.awt.Color(0, 153, 153));
        jButton57.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton57.setForeground(new java.awt.Color(51, 0, 51));
        jButton57.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\clear.png")); // NOI18N
        jButton57.setText("Clear");
        jButton57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jButton58.setBackground(new java.awt.Color(0, 153, 153));
        jButton58.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton58.setForeground(new java.awt.Color(51, 0, 51));
        jButton58.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\yes.png")); // NOI18N
        jButton58.setText("Submit");
        jButton58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(0, 153, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));
        jScrollPane4.setViewportView(jTextArea1);

        jPanel40.setBackground(new java.awt.Color(0, 51, 51));
        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4));

        jTextField62.setBackground(new java.awt.Color(0, 102, 102));
        jTextField62.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField62.setName(""); // NOI18N

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 204, 0));
        jLabel90.setText("Title");

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 204, 0));
        jLabel81.setText("Date");

        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Notice", jPanel8);

        jPanel56.setBackground(new java.awt.Color(0, 51, 51));
        jPanel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 4));

        jPanel57.setBackground(new java.awt.Color(0, 51, 51));
        jPanel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 4));

        jTable7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable7.setRowHeight(24);
        jTable7.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jScrollPane9.setViewportView(jTable7);

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        jScrollPane10.setBackground(new java.awt.Color(0, 51, 51));
        jScrollPane10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));

        jPanel58.setBackground(new java.awt.Color(0, 51, 51));

        jButton88.setBackground(new java.awt.Color(0, 153, 153));
        jButton88.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton88.setText("List the DEPARTMENT where there are no EMPLOYEE");
        jButton88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton88ActionPerformed(evt);
            }
        });

        jDateChooser10.setBackground(new java.awt.Color(51, 0, 51));
        jDateChooser10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 2));
        jDateChooser10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jTextField118.setBackground(new java.awt.Color(0, 102, 102));
        jTextField118.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField118.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField118.setName(""); // NOI18N
        jTextField118.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField118ActionPerformed(evt);
            }
        });

        jButton87.setBackground(new java.awt.Color(0, 153, 153));
        jButton87.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton87.setText("List the EMPLOYEE in each of the CITY");
        jButton87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton87ActionPerformed(evt);
            }
        });

        jButton76.setBackground(new java.awt.Color(0, 153, 153));
        jButton76.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton76.setText("Daily,Weekly,Monthly and Anual salary of all employee by ASC");
        jButton76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton76ActionPerformed(evt);
            }
        });

        jTextField117.setBackground(new java.awt.Color(0, 102, 102));
        jTextField117.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField117.setName(""); // NOI18N
        jTextField117.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField117ActionPerformed(evt);
            }
        });

        jButton83.setBackground(new java.awt.Color(0, 153, 153));
        jButton83.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton83.setText("Highest paid EMPLOYEE in the ? DEPARTMENT");
        jButton83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton83ActionPerformed(evt);
            }
        });

        jButton82.setBackground(new java.awt.Color(0, 153, 153));
        jButton82.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton82.setText("All Departments Max Salary,Avg Salary and number of employee");
        jButton82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton82ActionPerformed(evt);
            }
        });

        jButton90.setBackground(new java.awt.Color(0, 153, 153));
        jButton90.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton90.setText("List the EMPLOYEE who joined after");
        jButton90.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton90ActionPerformed(evt);
            }
        });

        jButton85.setBackground(new java.awt.Color(0, 153, 153));
        jButton85.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton85.setText("Name of DEPARTMENT where highest number of EMPLOYEE are working");
        jButton85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton85ActionPerformed(evt);
            }
        });

        jButton80.setBackground(new java.awt.Color(0, 153, 153));
        jButton80.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton80.setText("Find EMPLOYEE whose salary between");
        jButton80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton80ActionPerformed(evt);
            }
        });

        jButton86.setBackground(new java.awt.Color(0, 153, 153));
        jButton86.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton86.setText("List the EMPLOYEE who join in the same Date");
        jButton86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton86ActionPerformed(evt);
            }
        });

        jButton81.setBackground(new java.awt.Color(0, 153, 153));
        jButton81.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton81.setText("Find DEPARTMENT where more than ? Emp are working");
        jButton81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton81ActionPerformed(evt);
            }
        });

        jButton84.setBackground(new java.awt.Color(0, 153, 153));
        jButton84.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton84.setText("Highest paid EMPLOYEE for all DEPARTMENT");
        jButton84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton84ActionPerformed(evt);
            }
        });

        jComboBox9.setBackground(new java.awt.Color(0, 153, 153));
        jComboBox9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jComboBox9.setForeground(new java.awt.Color(51, 0, 51));
        jComboBox9.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox9PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jTextField115.setBackground(new java.awt.Color(0, 102, 102));
        jTextField115.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField115.setName(""); // NOI18N
        jTextField115.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField115ActionPerformed(evt);
            }
        });

        jDateChooser11.setBackground(new java.awt.Color(51, 0, 51));
        jDateChooser11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102), 2));
        jDateChooser11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jComboBox8.setBackground(new java.awt.Color(0, 153, 153));
        jComboBox8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jComboBox8.setForeground(new java.awt.Color(51, 0, 51));
        jComboBox8.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox8PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jTextField119.setBackground(new java.awt.Color(0, 102, 102));
        jTextField119.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField119.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jTextField119.setName(""); // NOI18N
        jTextField119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField119ActionPerformed(evt);
            }
        });

        jButton77.setBackground(new java.awt.Color(0, 153, 153));
        jButton77.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton77.setText("The number of EMPLOYEE for each DEPARTMENT");
        jButton77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton77ActionPerformed(evt);
            }
        });

        jButton78.setBackground(new java.awt.Color(0, 153, 153));
        jButton78.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton78.setText("The name of those EMPLOYEE starting with");
        jButton78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton78ActionPerformed(evt);
            }
        });

        jButton79.setBackground(new java.awt.Color(0, 153, 153));
        jButton79.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton79.setText("Employee Name by ASC");
        jButton79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton79ActionPerformed(evt);
            }
        });

        jButton89.setBackground(new java.awt.Color(0, 153, 153));
        jButton89.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton89.setText("List the EMPLOYEE who joined before");
        jButton89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton89ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jDateChooser10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(jButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createSequentialGroup()
                        .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel58Layout.createSequentialGroup()
                                .addComponent(jButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField117))
                            .addComponent(jButton81, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField119, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jTextField118)))
                    .addComponent(jButton82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(jButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton85, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(jButton86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(jButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField118, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField117, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField119, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane10.setViewportView(jPanel58);

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Search", jPanel56);

        jPanel11.setBackground(new java.awt.Color(0, 51, 51));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255), 4));

        jPanel53.setBackground(new java.awt.Color(0, 51, 51));
        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Farhan Fuad", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 255, 0))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\profilepic\\farhan.jpg")); // NOI18N

        jTextArea5.setEditable(false);
        jTextArea5.setBackground(new java.awt.Color(0, 153, 102));
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jTextArea5.setRows(5);
        jTextArea5.setText("ID:18.01.04.082\nGroup: 08\nSection: B2\nDepartment: CSE\nCourse NO: CSE3104\nCourse Name: Database\nSemister: Spring 20");
        jScrollPane13.setViewportView(jTextArea5);

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(51, 51, 51))
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13))
        );

        jPanel54.setBackground(new java.awt.Color(0, 51, 51));
        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Abdullah Al Mohaimen", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 255, 0))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\profilepic\\mohaimen.jpg")); // NOI18N

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(0, 153, 102));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("ID:18.01.04.098\nGroup: 08\nSection: B2\nDepartment: CSE\nCourse NO: CSE3104\nCourse Name: Database\nSemister: Spring 20");
        jScrollPane11.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
        );

        jPanel55.setBackground(new java.awt.Color(0, 51, 51));
        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 4), "Mashfiq rahman", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 255, 0))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\profilepic\\mashfiq.jpg")); // NOI18N

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(0, 153, 102));
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jTextArea4.setRows(5);
        jTextArea4.setText("ID:18.01.04.087\nGroup: 08\nSection: B2\nDepartment: CSE\nCourse NO: CSE3104\nCourse Name: Database\nSemister: Spring 20");
        jScrollPane12.setViewportView(jTextArea4);

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("About Us", jPanel10);

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 4, true));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("Payroll Management System");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(260, 20, 441, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\salary.png")); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(700, 10, 64, 64);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 153, 153));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 51), 2));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(900, 15, 120, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\salary.png")); // NOI18N
        jPanel2.add(jLabel4);
        jLabel4.setBounds(190, 10, 64, 64);

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\Icon\\logout.png")); // NOI18N
        jButton1.setText("Logout");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(1030, 51, 120, 28);

        jTextField24.setEditable(false);
        jTextField24.setBackground(new java.awt.Color(0, 153, 153));
        jTextField24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 51), 2));
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField24);
        jTextField24.setBounds(1030, 15, 120, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon("G:\\Database Lab(3104)\\Project\\background\\k.jpg")); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 0, 1260, 90);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1169, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1185, 657));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        First f=new First();
        f.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    
    //FIND EMPLOYEE............WHO WORKS EXTRA TIME
    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
        
            try{
                    String sql="select Overtime_Date From EMPLOYEE_OVERTIME where Emp_ID=? and Working_Month=?";
                    pst=conn.prepareStatement(sql);
                    pst.setString(1,jTextField4.getText());
                    pst.setString(2,jTextField73.getText());
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                
                        jTable6.setModel(DbUtils.resultSetToTableModel(rs));
                
                        try
                        {
                            String eSql="SELECT COUNT(Emp_ID) as 'Total Working Days' FROM EMPLOYEE_OVERTIME WHERE Emp_ID=? and Working_Month=?";
                            pst=conn.prepareStatement(eSql);
                            pst.setString(1,jTextField4.getText());
                    pst.setString(2,jTextField73.getText());
                            rs=pst.executeQuery();
                            if(rs.next())
                            {
                                String workingDays=rs.getString("Total Working Days");
                                jTextField77.setText(workingDays);
                        
                            }

                        }catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(null, ex);
                            System.out.println("(PAYROLL) EMPLOYEE OVERTIME A: "+ex);
                        }
                    }
                    else
                    {
                        jTextField77.setText("0");
                        jTextField102.setText("0");
                    }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("(PAYROLL) EMPLOYEE OVERTIME B: "+ex);
        }
    }//GEN-LAST:event_jButton41ActionPerformed

    
    //FIND EMPLOYEE ATTENDANCE
    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
        try{
            String id=jTextField4.getText();
            String month=jTextField73.getText();
            String sql="select * from ATTENDANCE where Emp_ID=? and C_Month=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,id);
            pst.setString(2,month);
            rs=pst.executeQuery();
            if(rs.next())
            {
                try
                {
                    String aSql="SELECT COUNT(Result) as 'Attendance' FROM ATTENDANCE WHERE Emp_ID=? and C_Month=?";
                    pst=conn.prepareStatement(aSql);
                    pst.setString(1,id);
                    pst.setString(2,month);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        String workingDays=rs.getString("Attendance");
                        jTextField103.setText(workingDays);
                        
                        int monthPerDay=Integer.parseInt(jTextField108.getText());
                        int presentDay=Integer.parseInt(jTextField103.getText());
                        int absent=monthPerDay-presentDay;
                        
                        String totalabsent=String.valueOf(absent);
                        jTextField104.setText(totalabsent);
                        
                    }

                }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                    System.out.println("Payroll Employee Present Error: "+ex);
                }
                
                try
                        {
                            String bSql="SELECT COUNT(Result) as 'LateDay' FROM ATTENDANCE WHERE Result='Late' and Emp_ID=? and C_Month=?";
                            pst=conn.prepareStatement(bSql);
                            pst.setString(1,id);
                            pst.setString(2,month);
                            rs=pst.executeQuery();
                            if(rs.next())
                            {
                                String totalLate=rs.getString("LateDay");
                                jTextField105.setText(totalLate);
                                
                            }
                            
                        }catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(null, ex);
                            System.out.println("Payroll Employee Late Error: "+ex);
                        }
                
            }
            
            else
            {
                jTextField107.setText("0000");
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Employee Project Combobox Error: "+ex);
        }
        
        
        try
        {
            String id=jTextField4.getText();
            String month=jTextField73.getText();
            String cSql="SELECT Total_Days FROM LEAVEMS WHERE Emp_ID=? and C_Month=? and Approval='Approve'";
            pst=conn.prepareStatement(cSql);
            pst.setString(1,id);
            pst.setString(2,month);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String leaveDays=rs.getString("Total_Days");
                jTextField106.setText(leaveDays);
            }
            
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Employee Extra Leave Error: "+ex);
        }
    }//GEN-LAST:event_jButton40ActionPerformed

    
    //FIND EMPLOYEE.........WHO GETTING ALLOWANCE
    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:

        String sql="Select PayGrade_ID,Trvel_Al_Amount,Medical_Al_Amount,House_Rnt_Amount,Meal_Al_Amount,Total_Al_Amount from EMPLOYEE JOIN EMPLOYEE_PAY_GRADE ON EMPLOYEE.Emp_ID=EMPLOYEE_PAY_GRADE.Emp_ID AND EMPLOYEE_PAY_GRADE.Emp_ID=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,jTextField4.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String paygrade=rs.getString("PayGrade_ID");
                jTextField56.setText(paygrade);

                String travel=rs.getString("Trvel_Al_Amount");
                jTextField57.setText(travel);

                String medical=rs.getString("Medical_Al_Amount");
                jTextField58.setText(medical);

                String house=rs.getString("House_Rnt_Amount");
                jTextField59.setText(house);

                String meals=rs.getString("Meal_Al_Amount");
                jTextField60.setText(meals);

                String total=rs.getString("Total_Al_Amount");
                jTextField114.setText(total);

                rs.close();
                pst.close();
            }
            else{
                jTextField56.setText("0");
                jTextField57.setText("0");
                jTextField58.setText("0");
                jTextField59.setText("0");
                jTextField60.setText("0");
                jTextField114.setText("0");
                
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Find Payroll Error A: "+ex);
        }finally{
            try{
                rs.close();
                pst.close();

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Find Payroll Error B: "+ex);
            }
        }
    }//GEN-LAST:event_jButton39ActionPerformed

    
    //FIND EMPLOYEE...........PAYROLL
    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:

        String sql="Select Dept_Name,Emp_ID,Emp_Name,Emp_Email,Emp_PhoneNo,Emp_netSalary from DEPARTMENT JOIN EMPLOYEE ON DEPARTMENT.Dept_ID=EMPLOYEE.Emp_Dept AND EMPLOYEE.Emp_ID=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,jTextField4.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {

                String deptName=rs.getString("Dept_Name");
                jTextField33.setText(deptName);

                String EmpName=rs.getString("Emp_Name");
                jTextField34.setText(EmpName);

                String EmpEmail=rs.getString("Emp_Email");
                jTextField35.setText(EmpEmail);

                String EmpPhone=rs.getString("Emp_PhoneNo");
                jTextField36.setText(EmpPhone);

                String EmpSalary=rs.getString("Emp_netSalary");
                jTextField52.setText(EmpSalary);

                rs.close();
                pst.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Please!\nFill up all the field");
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Find EMPLOYEE Payroll Error A: "+ex);
        }finally{
            try{
                rs.close();
                pst.close();

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Find EMPLOYEE Payroll Error B: "+ex);
            }
        }

    }//GEN-LAST:event_jButton38ActionPerformed

    
    //SHOW EMPLOYEE WHO ARE GETTING ALLOWANCE
    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Employee_PaygradeList list=new Employee_PaygradeList();
        list.setVisible(true);
    }//GEN-LAST:event_jButton53ActionPerformed

    
    //AFTRE EDIT EMPLOYEE ALLOWANCE UPDATE
    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here:
        try{
            String paygradeID=jTextField40.getText();
            String travel=jTextField39.getText();
            String medical=jTextField38.getText();
            String home=jTextField41.getText();
            String meals=jTextField37.getText();
            String total=jTextField42.getText();

            String sql="UPDATE EMPLOYEE_PAY_GRADE set Trvel_Al_Amount='"+travel+"',Medical_Al_Amount='"+medical+"',House_Rnt_Amount='"+home+"',Meal_Al_Amount='"+meals+"',Total_Al_Amount='"+total+"' where PayGrade_ID='"+paygradeID+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Congratulation!\nPaygrade details has been updated");

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Paygrade Update Error: "+ex);
        }
    }//GEN-LAST:event_jButton55ActionPerformed

    
    //FIND EMPLOYEE WHO APPLY FOR ALLOWANCE
    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        // TODO add your handling code here:

        String sql="Select PayGrade_ID,Trvel_Al_Amount,Medical_Al_Amount,House_Rnt_Amount,Meal_Al_Amount,Total_Al_Amount from EMPLOYEE JOIN EMPLOYEE_PAY_GRADE ON EMPLOYEE.Emp_ID=EMPLOYEE_PAY_GRADE.Emp_ID AND EMPLOYEE_PAY_GRADE.Emp_ID=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,jTextField43.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {

                String paygrade=rs.getString("PayGrade_ID");
                jTextField40.setText(paygrade);

                String travel=rs.getString("Trvel_Al_Amount");
                jTextField39.setText(travel);

                String medical=rs.getString("Medical_Al_Amount");
                jTextField38.setText(medical);

                String house=rs.getString("House_Rnt_Amount");
                jTextField41.setText(house);

                String meals=rs.getString("Meal_Al_Amount");
                jTextField37.setText(meals);

                String total=rs.getString("Total_Al_Amount");
                jTextField42.setText(total);

                jButton48.setEnabled(false);
                jButton43.setEnabled(false);
                jButton44.setEnabled(false);
                jButton49.setEnabled(false);
                jButton42.setEnabled(false);
                jButton45.setEnabled(false);
                jButton46.setEnabled(false);
                jButton47.setEnabled(false);

                rs.close();
                pst.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Employee ID\nPlease! Enter Correct Employee ID");
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Finde Pay grade Error A: "+ex);
        }finally{
            try{
                rs.close();
                pst.close();

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Find pay grade Error B: "+ex);
            }
        }

    }//GEN-LAST:event_jButton54ActionPerformed

    
    //EMPLOYEE ALLOWANCE EDIT
    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // TODO add your handling code here:
        jButton48.setEnabled(true);
        jButton43.setEnabled(true);
        jButton44.setEnabled(true);
        jButton49.setEnabled(true);
        jButton42.setEnabled(true);
        jButton45.setEnabled(true);
        jButton46.setEnabled(true);
        jButton47.setEnabled(true);
    }//GEN-LAST:event_jButton52ActionPerformed

    
    //DELETE EMPLOYEE ALLOWANCE
    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        // TODO add your handling code here:

        int delete=JOptionPane.showConfirmDialog(null, "Are you sure?","You want to delete",JOptionPane.YES_NO_OPTION);
        if(delete==0)
        {
            String id=jTextField40.getText();
            String sql="DELETE from EMPLOYEE_PAY_GRADE where PayGrade_ID=?";

            try{
                pst=conn.prepareStatement(sql);
                pst.setString(1,id);
                pst.execute();

                jTextField43.setText("");
                jTextField40.setText("");
                jTextField39.setText("");
                jTextField38.setText("");
                jTextField41.setText("");
                jTextField37.setText("");
                jTextField42.setText("");
                JOptionPane.showMessageDialog(null,"Paygrade ID has been Deleted");

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("DELETE PAYGRADE ERROR: "+ex);
            }
        }

    }//GEN-LAST:event_jButton51ActionPerformed

    //AFTER EDIT.......TOTAL ALLOWANCE
    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        // TODO add your handling code here:
        try{
            String travelAl=jTextField39.getText();
            String medicalAl=jTextField38.getText();
            String houseAl=jTextField41.getText();
            String mealsAl=jTextField37.getText();

            int total=Integer.parseInt(travelAl)+Integer.parseInt(medicalAl)+Integer.parseInt(houseAl)+Integer.parseInt(mealsAl);
            String totalAmount=String.valueOf(total);
            jTextField42.setText(totalAmount);

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Total Allowance Aount Error: "+ex);
        }
    }//GEN-LAST:event_jButton50ActionPerformed

    
    //AFTER EDIT FIXED MEDICAL ALLOWANCE OK
    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        // TODO add your handling code here:
        jTextField38.setText("500");
    }//GEN-LAST:event_jButton49ActionPerformed

    
    //AFTER EDIT TRAVEL ALLOWANCE OK
    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
        jTextField39.setText("1000");
    }//GEN-LAST:event_jButton48ActionPerformed

    
    //AFTER EDIT HOUSE RENT ALLWANCE OK
    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
        jTextField41.setText("3000");
    }//GEN-LAST:event_jButton47ActionPerformed

    
    //AFTER EDIT MELAS ALLOWANCE NOT OK
    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        // TODO add your handling code here:
        jTextField37.setText("0000");
    }//GEN-LAST:event_jButton46ActionPerformed

    
    //AFTER EDIT HOUSE RENT ALLOWANCE NOT OK
    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
        jTextField41.setText("0000");
    }//GEN-LAST:event_jButton45ActionPerformed

    
    //AFTER EDIT FIXED MEDICAL ALLOWANCE NOT OK
    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
        jTextField38.setText("0000");

    }//GEN-LAST:event_jButton44ActionPerformed

    //AFTER EDIT TRAVEL ALLOWANCE NOT OK
    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
        jTextField39.setText("0000");
    }//GEN-LAST:event_jButton43ActionPerformed

    
    //AFTER EDIT MELAS ALLOWANCE OK
    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        jTextField37.setText("2500");
    }//GEN-LAST:event_jButton42ActionPerformed

    
    //APPLY ALLOWANCE INFORMATION CLEAR
    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        // TODO add your handling code here:
        jTextField25.setText("");
        jTextField26.setText("");
        jTextField27.setText("");
        jTextField28.setText("");
        jTextField29.setText("");
        jTextField30.setText("");

    }//GEN-LAST:event_jButton56ActionPerformed

    
    //APPLY FOR EMPLOYEE ALLOWANCE
    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:

        String sql="INSERT INTO EMPLOYEE_PAY_GRADE(Emp_ID,Trvel_Al_Amount,Medical_Al_Amount,House_Rnt_Amount,Meal_Al_Amount,Total_Al_Amount)  values(?,?,?,?,?,?)";
        try{

            pst=conn.prepareStatement(sql);

            pst.setString(1,jTextField25.getText());//Employee ID
            pst.setString(2,jTextField26.getText());//Travel Allowance
            pst.setString(3,jTextField27.getText());//Medical Allowance
            pst.setString(4,jTextField28.getText());//House Rent Allowance
            pst.setString(5,jTextField29.getText());//Meals Allowence
            pst.setString(6,jTextField30.getText());//Total Amount

            pst.execute();
            JOptionPane.showMessageDialog(null, "Congratulation!\nCompleted");

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "This Employee already gets allowance");
            System.out.println("Employee Paygrade Error: "+ex);
        }

    }//GEN-LAST:event_jButton31ActionPerformed
    
    
    //APPLY FOR ALLOWANCE TOTAL AMOUNT
    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        try{
            String travelAl=jTextField26.getText();
            String medicalAl=jTextField27.getText();
            String houseAl=jTextField28.getText();
            String mealsAl=jTextField29.getText();

            int total=Integer.parseInt(travelAl)+Integer.parseInt(medicalAl)+Integer.parseInt(houseAl)+Integer.parseInt(mealsAl);
            String totalAmount=String.valueOf(total);
            jTextField30.setText(totalAmount);

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Total Allowance Aount Error: "+ex);
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    //FIXED MEDICAL ALLOWANCE OK
    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        jTextField27.setText("500");
    }//GEN-LAST:event_jButton22ActionPerformed

    
    //TRAVEL ALLOWANCE OK
    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        jTextField26.setText("1000");
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    //HOUSE RENT ALLOWANCE OK
    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        jTextField28.setText("3000");
    }//GEN-LAST:event_jButton27ActionPerformed

    //MEALS ALLOWANCE NOT OK
    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        jTextField29.setText("0000");
    }//GEN-LAST:event_jButton28ActionPerformed

    
    //HOUSE RENT ALLOWANCE NOT OK
    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        jTextField28.setText("0000");
    }//GEN-LAST:event_jButton26ActionPerformed
    
    
    //FIXEDD MEDICAL ALLOWANCE NOT OK
    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        jTextField27.setText("0000");
    }//GEN-LAST:event_jButton23ActionPerformed
    
    
    //TRAVEL ALLOWANCE NOT OK
    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        jTextField26.setText("0000");
    }//GEN-LAST:event_jButton25ActionPerformed

    
    //MEALS ALLOWANCE OK
    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        jTextField29.setText("2500");
    }//GEN-LAST:event_jButton29ActionPerformed

    
    //TRAVEL INFO SHOW
    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        ProjectList pr=new ProjectList();
        pr.setVisible(true);
    }//GEN-LAST:event_jButton33ActionPerformed

    //TRAVEL ID NO.
    private void jComboBox3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox3PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        try{
            String a1=(String)jComboBox3.getSelectedItem();
            String sql="select Project_Name,Foreign_Company,Emp_ID from CORPORATE_TRAVEL where Project_NO=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,a1);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String empId=rs.getString("Foreign_Company");
                jTextField55.setText(empId);

                String deptId=rs.getString("Project_Name");
                jTextField54.setText(deptId);

                jTable2.setModel(DbUtils.resultSetToTableModel(rs));
                jButton48.setEnabled(true);

            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Employee Project Combobox Error: "+ex);
        }

    }//GEN-LAST:event_jComboBox3PopupMenuWillBecomeInvisible

    
    //AFTER TOUR COMPLETED DELETE TOUR INFO
    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:

        int delete=JOptionPane.showConfirmDialog(null, "Are you sure?","Complete",JOptionPane.YES_NO_OPTION);
        if(delete==0)
        {
            String projectNo=(String)jComboBox3.getSelectedItem();
            String projectName=jTextField54.getText();
            String sql="DELETE from CORPORATE_TRAVEL where Project_NO=? and Project_Name=?";

            try{
                pst=conn.prepareStatement(sql);
                pst.setString(1,projectNo);
                pst.setString(2,projectName);
                pst.execute();

                jTextField55.setText("");
                jTextField54.setText("");
                JOptionPane.showMessageDialog(null,"Assignment Completed");

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("CORPORATE TRAVEL COMPLETE ERROR: "+ex);
            }
        }

    }//GEN-LAST:event_jButton34ActionPerformed

    private void jTextField54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField54ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField54ActionPerformed

    private void jTextField55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField55ActionPerformed

    private void jTextField44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField44ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField44ActionPerformed

    private void jTextField53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField53ActionPerformed
    
    
    //CORPORATE TRAVEL COMFIRMATION
    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        String sql="INSERT INTO CORPORATE_TRAVEL(Project_NO,Emp_ID,Project_Leader_ID,Foreign_Company,Project_Name,Destination,From_Date,To_Date,Cost_Amount)  values(?,?,?,?,?,?,?,?,?)";
        try{

            pst=conn.prepareStatement(sql);

            pst.setString(1,jTextField53.getText());//Project No
            pst.setString(2,jTextField44.getText());//Employee ID
            pst.setString(3,jTextField51.getText());//Project Leader ID
            pst.setString(4,jTextField50.getText());//Foreign Company Name
            pst.setString(5,jTextField45.getText());//Project Name
            pst.setString(6,jTextField47.getText());//Destination
            pst.setString(7,((JTextField)jDateChooser7.getDateEditor().getUiComponent()).getText());//From Date
            pst.setString(8,((JTextField)jDateChooser8.getDateEditor().getUiComponent()).getText());//To Date
            pst.setString(9,jTextField48.getText());//Cost AMount

            pst.execute();
            JOptionPane.showMessageDialog(null, "Congratulation!\nProject Details has been Added");

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("INSERT CORPORATE TRAVEL INFORMATION Error: "+ex);
        }
    }//GEN-LAST:event_jButton32ActionPerformed

    
    //FIND EMPLOYEE FOR SAVING ACCOUNT INFORMATION
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String sql="Select Emp_ID,Emp_Account,Emp_Name,Emp_Balance from EMPLOYEE JOIN EMPLOYEE_ACCOUNT ON EMPLOYEE.Emp_ID=EMPLOYEE_ACCOUNT.Emp_AccID AND EMPLOYEE_ACCOUNT.Emp_AccID=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,jTextField3.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String empID=rs.getString("Emp_ID");
                jTextField19.setText(empID);

                String accNO=rs.getString("Emp_Account");
                jTextField21.setText(accNO);

                String EmpName=rs.getString("Emp_Name");
                jTextField17.setText(EmpName);

                String EmpBalance=rs.getString("Emp_Balance");
                jTextField18.setText(EmpBalance);

                rs.close();
                pst.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Employee ID\nPlease! Enter Correct Employee ID");
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Something wents wrong");
            System.out.println("FIND EMPLOYEE SAVING Error A: "+ex);
        }finally{
            try{
                rs.close();
                pst.close();

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Find Error B: "+ex);
            }
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    
    //CREATE EMPLOYEE SAVING ACCOUNT
    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        AddAccount ad=new AddAccount();
        ad.setVisible(true);
    }//GEN-LAST:event_jButton20ActionPerformed

    
    //SHOW EMPLOYEE SAVING ACCOUNT
    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        AccountList ac=new AccountList();
        ac.setVisible(true);
    }//GEN-LAST:event_jButton21ActionPerformed

    
    //AFTER WITHDRAW UPDATE EMPLOYEE ACCOUNT............BALANCE
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:

        try{
            String accountNo=jTextField21.getText();
            String totalAmount=jTextField20.getText();
            String sql="UPDATE EMPLOYEE_ACCOUNT set Emp_Balance='"+totalAmount+"' where Emp_Account='"+accountNo+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            Withdraw();
            JOptionPane.showMessageDialog(null, "Successfully Withdraw\n      Thank you!");
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Withdraw Error: "+ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    
    //WITHDRAW TOTAL AMOUNT
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        try{
            String mainBalance=jTextField18.getText();
            String withdrawAmount=jTextField23.getText();

            int newBalance=Integer.parseInt(mainBalance)-Integer.parseInt(withdrawAmount);
            String totalAmount=String.valueOf(newBalance);
            jTextField20.setText(totalAmount);

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please find employee account please!!");
            System.out.println("Withdraw Total Amount Error: "+ex);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        jTextField22.setText("");
    }//GEN-LAST:event_jButton16ActionPerformed

    
    //DEPOSITE TOTAL AMOUNT
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        try{
            String mainBalance=jTextField18.getText();
            String depositeAmount=jTextField22.getText();

            int newBalance=Integer.parseInt(mainBalance)+Integer.parseInt(depositeAmount);
            String totalAmount=String.valueOf(newBalance);
            jTextField20.setText(totalAmount);

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please find employee account..Please!!");
            System.out.println("Deposite Total AMount Error: "+ex);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    
    //AFTER DEPOSITE UPDATE ACCOUNT BALANCE
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        try{
            String accountNo=jTextField21.getText();
            String totalAmount=jTextField20.getText();
            String sql="UPDATE EMPLOYEE_ACCOUNT set Emp_Balance='"+totalAmount+"' where Emp_Account='"+accountNo+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            Deposite();
            JOptionPane.showMessageDialog(null, "Successfully Deposited\n      Thank you!");
            jTextField18.setText("");
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Deposite error: "+ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    
    //DELETE EMPLOYEE SAVING ACCOUNT
    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
        int delete=JOptionPane.showConfirmDialog(null, "Are you sure?","You want to delete",JOptionPane.YES_NO_OPTION);

        if(delete==0)
        {
            String id=jTextField3.getText();
            String sql="DELETE from EMPLOYEE_ACCOUNT where Emp_AccID=?";
            try{
                pst=conn.prepareStatement(sql);
                pst.setString(1,id);
                pst.execute();

                jTextField3.setText("");
                jTextField17.setText("");
                jTextField21.setText("");
                jTextField18.setText("");
                jTextField19.setText("");
                jTextField20.setText("");

                JOptionPane.showMessageDialog(null,"Employee Account has been Deleted");

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Employee Account Delete Error: "+ex);
            }

        }

    }//GEN-LAST:event_jButton37ActionPerformed

    
    //CLEAR FOR EMPLOYEE SAVING ACCOUNT INFORMATION
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        jTextField19.setText("");
        jTextField21.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jTextField20.setText("");
    }//GEN-LAST:event_jButton19ActionPerformed

    
    //EMPLOYEE INFORMATION EDIT
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        jTextField82.setEditable(true);
        jTextField11.setEditable(true);
        jTextField12.setEditable(true);
        jTextField13.setEditable(true);
        jTextField15.setEditable(true);
        jTextField16.setEditable(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    
    //DELETE ANY EMPLOYEE INFORMATION
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:

        int delete=JOptionPane.showConfirmDialog(null, "Are you sure?","You want to delete",JOptionPane.YES_NO_OPTION);

        if(delete==0)
        {
            String id=jTextField81.getText();
            String sql="DELETE from EMPLOYEE where Emp_id=?";
            try{
                pst=conn.prepareStatement(sql);
                pst.setString(1,id);
                pst.execute();

                jTextField81.setText("");
                jTextField74.setText("");
                jTextField76.setText("");
                jTextField75.setText("");
                jTextField82.setText("");
                jTextField83.setText("");
                jTextField84.setText("");
                jTextField85.setText("");
                jTextField11.setText("");
                jTextField12.setText("");
                jTextField13.setText("");
                jTextField31.setText("");
                jTextField15.setText("");
                jTextField16.setText("");
                JOptionPane.showMessageDialog(null,"Employee has been Deleted");

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Employee Delete Error: "+ex);
            }

        }
    }//GEN-LAST:event_jButton12ActionPerformed

    
    //AFTER EDIT EMPLOYEE INFORMATION UPDATE
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        try{
            String id=jTextField81.getText();
            String age=jTextField82.getText();
            String address=jTextField11.getText();
            String city=jTextField12.getText();
            String nationality=jTextField13.getText();
            String email=jTextField15.getText();
            String phone=jTextField16.getText();

            String sql="UPDATE EMPLOYEE set Emp_Age='"+age+"',Emp_Address='"+address+"',Emp_City='"+city+"',Emp_Nationality='"+nationality+"',Emp_Email='"+email+"',Emp_PhoneNo='"+phone+"' where Emp_ID='"+id+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Congratulation!\nEmployee details has been updated");

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Employee Update Error: "+ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    
    //CLEAR FOR EMPLOYEE INFORMATION TEXTFIELD
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        jTextField81.setText("");
        jTextField74.setText("");
        jTextField76.setText("");
        jTextField75.setText("");
        jTextField82.setText("");
        jTextField83.setText("");
        jTextField84.setText("");
        jTextField85.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField31.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField14.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed

    
    //JOIN ADMIN
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        AddAdmin ad=new AddAdmin();
        ad.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    
    //FIND ADMIN ALL INFORMATION
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        AdminList admin=new AdminList();
        admin.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    
    //JOIN ANY EMPLOYEE
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        AddEmployee emp=new AddEmployee();
        emp.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    
    //FIND ALL EMPLOYEE INFORMATION
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        EmployeeList employee=new EmployeeList();
        employee.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    
    //EMPLOYEE INFORMATION
    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
        // TODO add your handling code here:

        String a1=(String)jComboBox2.getSelectedItem();
        
        try{
            String sql="select * from EMPLOYEE where Emp_ID=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,a1);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String empId=rs.getString("Emp_ID");
                jTextField81.setText(empId);

                String deptId=rs.getString("Emp_Dept");
                jTextField74.setText(deptId);

                String name=rs.getString("Emp_Name");
                jTextField76.setText(name);

                String dob=rs.getString("Emp_DOB");
                jTextField75.setText(dob);

                String age=rs.getString("Emp_Age");
                jTextField82.setText(age);

                String gender=rs.getString("Emp_Gender");
                jTextField83.setText(gender);

                String religion=rs.getString("Emp_Religion");
                jTextField84.setText(religion);

                String doj=rs.getString("Emp_Doj");
                jTextField85.setText(doj);

                String address=rs.getString("Emp_Address");
                jTextField11.setText(address);

                String city=rs.getString("Emp_City");
                jTextField12.setText(city);

                String nationality=rs.getString("Emp_Nationality");
                jTextField13.setText(nationality);

                String nId=rs.getString("Emp_Nid");
                jTextField14.setText(nId);

                String email=rs.getString("Emp_Email");
                jTextField15.setText(email);

                String phone=rs.getString("Emp_PhoneNo");
                jTextField16.setText(phone);

                String salary=rs.getString("Emp_netSalary");
                jTextField31.setText(salary);
                
                byte[] image=rs.getBytes("Emp_Image");
                imageSet.setIcon(new ImageIcon(image));
                
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("FIND Employee Combobox Error B: "+ex);
        }
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    
    //ADD DEPARTMENT
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        AddDepartment dept=new AddDepartment();
        dept.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    
    //DEPARTMENT SHOW
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        DepartmentList list=new DepartmentList();
        list.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    //DEPARTMENT WIZE EMPLOYEE
    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        try{
            String select=(String)jComboBox1.getSelectedItem();
            String sql="Select Dept_Name,Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo from DEPARTMENT JOIN EMPLOYEE ON DEPARTMENT.Dept_ID=EMPLOYEE.Emp_Dept AND DEPARTMENT.Dept_ID=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,select);
            rs=pst.executeQuery();
            if(rs.next())
            {
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Department Combobox Error: "+ex);
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton57ActionPerformed

    
    //NOTICE PUBLISH
    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        // TODO add your handling code here:
        
        String sql="INSERT INTO NOTICE(Title,Notice_Date,Notice)  values(?,?,?)";
        try{
            
            pst=conn.prepareStatement(sql);
            pst.setString(1,jTextField62.getText());//Title
            
            pst.setString(2,((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());//Current Date
            pst.setString(3,jTextArea1.getText());//Age

            pst.execute();
            JOptionPane.showMessageDialog(null, "Notice Publish");
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("AddEmployee Error: "+ex);
        }
    }//GEN-LAST:event_jButton58ActionPerformed

    
    //FIND EMPLOYEE SALARY INCREASE
    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        // TODO add your handling code here:
        
        String sql="Select Emp_Name,Dept_Name,Emp_Address,Emp_Email,Emp_PhoneNo,Emp_netSalary from DEPARTMENT JOIN EMPLOYEE ON DEPARTMENT.Dept_ID=EMPLOYEE.Emp_Dept AND EMPLOYEE.Emp_ID=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,jTextField63.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String empName=rs.getString("Emp_Name");
                jTextField64.setText(empName);

                String deptName=rs.getString("Dept_Name");
                jTextField65.setText(deptName);
                
                String EmpAddress=rs.getString("Emp_Address");
                jTextField66.setText(EmpAddress);
                
                String EmpEmail=rs.getString("Emp_Email");
                jTextField67.setText(EmpEmail);
                
                String EmpPhone=rs.getString("Emp_PhoneNo");
                jTextField68.setText(EmpPhone);

                String EmpBalance=rs.getString("Emp_netSalary");
                jTextField69.setText(EmpBalance);

                rs.close();
                pst.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Employee ID\nPlease! Enter Correct Employee ID");
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Find Error A: "+ex);
        }finally{
            try{
                rs.close();
                pst.close();

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Find Error B: "+ex);
            }
        }
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        // TODO add your handling code here:
        int salary = Integer.parseInt(jTextField69.getText());
        int percentage = Integer.parseInt(jTextField70.getText());
        
        int total=salary+((salary*percentage)/100);
        String totalAmount=String.valueOf(total);
        jTextField72.setText(totalAmount);
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
        int salary = Integer.parseInt(jTextField69.getText());
        int amount = Integer.parseInt(jTextField71.getText());
        
        int total=salary+amount;
        String totalAmount=String.valueOf(total);
        jTextField72.setText(totalAmount);
    }//GEN-LAST:event_jButton61ActionPerformed

    
    //AFTER INCREASE.........UPDATE EMPLOYEE SALARY FROM EMPLOYEE TABLE
    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        // TODO add your handling code here:
        int update=JOptionPane.showConfirmDialog(null, "Are you sure?","Salary Increase",JOptionPane.YES_NO_OPTION);
        if(update==0)
        {
            String id=jTextField63.getText();
            String netSalary=jTextField72.getText();

            try{
                String sql="UPDATE EMPLOYEE set Emp_netSalary='"+netSalary+"' where Emp_ID='"+id+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Congratulation!\nEmployee Salary has been updated");
                jTextField64.setText("");
                jTextField65.setText("");
                jTextField66.setText("");
                jTextField67.setText("");
                jTextField68.setText("");
                jTextField69.setText("");
                jTextField70.setText("");
                jTextField71.setText("");
                jTextField72.setText("");

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Salary Increase Error: "+ex);
            }
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Please find account first then fill the all field in Increase salary");
        }
    }//GEN-LAST:event_jButton62ActionPerformed

    //IF EMPLOYEE SALARY INCREASE BY PERCENTAGE
    private void percentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentageActionPerformed
        // TODO add your handling code here:
        amount.setSelected(false);
        jTextField70.setEditable(true);
        jTextField71.setEditable(false);
        jButton60.setEnabled(true);
        jButton61.setEnabled(false);
    }//GEN-LAST:event_percentageActionPerformed

    
    //IF EMPLOYEE SALARY INCREASE BY AMOUNT
    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        // TODO add your handling code here:
        percentage.setSelected(false);
        jTextField71.setEditable(true);
        jTextField70.setEditable(false);
        jButton60.setEnabled(false);
        jButton61.setEnabled(true);
    }//GEN-LAST:event_amountActionPerformed

    
    //ADMIN LEAVE APPROVAL
    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
        
        
        int update=JOptionPane.showConfirmDialog(null, "Are you sure?","Approval",JOptionPane.YES_NO_OPTION);
        if(update==0)
        {

//            int row=jTable3.getSelectedRow();
//            String rowClick=(jTable3.getModel().getValueAt(row, 0).toString());
            
            String leftHoliday=jTextField79.getText();
            String totalHoliday=jTextField87.getText();

            int updateHoliday=Integer.parseInt(leftHoliday)+Integer.parseInt(totalHoliday);
            //String days=String.valueOf(updateHoliday);
            String leaveID=jTextField89.getText();
            
            try{
                String sql="UPDATE LEAVEMS set Holidays_Left='"+updateHoliday+"',Approval='Not Approve' where Leave_ID='"+leaveID+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Not Approve");

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Not Approve Error: "+ex);
            }
        }
        
        
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        jTextField23.setText("");
    }//GEN-LAST:event_jButton18ActionPerformed

    
    //FIND EMPLOYEE...............OVERTIME
    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        // TODO add your handling code here:
        String sql="Select Emp_Name From EMPLOYEE where Emp_ID=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,jTextField78.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String EmpName=rs.getString("Emp_Name");
                jTextField80.setText(EmpName);

                rs.close();
                pst.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Employee ID\nPlease! Enter Correct Employee ID");
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Find EMPLOYEE OVERTIME Error A: "+ex);
        }finally{
            try{
                rs.close();
                pst.close();

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Find EMPLOYEE OVERTIME Error B: "+ex);
            }
        }
        
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jTextField78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField78ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField78ActionPerformed

    private void jTextField80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField80ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField80ActionPerformed

    
    //INSERT INTO OVERTIME TABLE
    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed
        // TODO add your handling code here:
        
        String sql="INSERT INTO EMPLOYEE_OVERTIME(Emp_ID,Emp_Name,Working_Month,Overtime_Date)  values(?,?,?,?)";
        try{
            
            pst=conn.prepareStatement(sql);

            pst.setString(1,jTextField78.getText());//Employee ID
            pst.setString(2,jTextField80.getText());//Emp Name
            
            pst.setString(3,jTextField90.getText());//Month Name
            pst.setString(4,((JTextField)jDateChooser4.getDateEditor().getUiComponent()).getText());//Working Day

            pst.execute();
            JOptionPane.showMessageDialog(null, "Congratulation!\nCompleted");

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Employee Paygrade Error: "+ex);
        }
    }//GEN-LAST:event_jButton66ActionPerformed

    private void jTextField88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField88ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField88ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        OvertimeEmployee ob=new OvertimeEmployee();
        ob.setVisible(true);
    }//GEN-LAST:event_jButton67ActionPerformed

    
    //SHOW EMPLOYEE OVERTIME DETAILS
    private void jComboBox4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox4PopupMenuWillBecomeInvisible
         // TODO add your handling code here:
        
        try{
            String id=(String)jComboBox4.getSelectedItem();
            String month=(String)jComboBox6.getSelectedItem();
            String sql="select Emp_Name,Overtime_Date From EMPLOYEE_OVERTIME where Emp_ID=? and Working_Month=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,id);
            pst.setString(2,month);
            rs=pst.executeQuery();
            if(rs.next())
            {
                
                jTable4.setModel(DbUtils.resultSetToTableModel(rs));
                
                try
                {
                    String eSql="SELECT COUNT(Emp_ID) as 'Total Working Days' FROM EMPLOYEE_OVERTIME WHERE Emp_ID=? and Working_Month=?";
                    pst=conn.prepareStatement(eSql);
                    pst.setString(1,id);
                    pst.setString(2,month);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        String workingDays=rs.getString("Total Working Days");
                        jTextField88.setText(workingDays);
                        
                    }

                }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                    System.out.println("Employee overtime Combobox Error A: "+ex);
                }
                        

            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Employee overtime Combobox Error B: "+ex);
        }
        
    }//GEN-LAST:event_jComboBox4PopupMenuWillBecomeInvisible

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        // TODO add your handling code here:
        
        int update=JOptionPane.showConfirmDialog(null, "Are you sure?","Approval",JOptionPane.YES_NO_OPTION);
        if(update==0)
        {
//            int row=jTable3.getSelectedRow();
//            String rowClick=(jTable3.getModel().getValueAt(row, 0).toString());
            String leaveID=jTextField89.getText();

            try{
                String sql="UPDATE LEAVEMS set Approval='Approve' where Leave_ID='"+leaveID+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Approve");

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Approve Error: "+ex);
            }
        }
    }//GEN-LAST:event_jButton68ActionPerformed

    
    //EMPLOYEE LEAVEMS CHECK
    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        // TODO add your handling code here:
        String cDate=((JTextField)jDateChooser5.getDateEditor().getUiComponent()).getText();
        try{
            String sql="select Leave_ID,Emp_ID,Holidays_Left,From_Date,To_Date,Total_Days,Reason From LEAVEMS where Apply_Date=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,cDate);
            rs=pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));   
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Chose the date..Please!!");
            System.out.println("Employee LEAVEMS Table Error: "+ex);
        }
        finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton69ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        
        int row=jTable3.getSelectedRow();
        String rowClick=(jTable3.getModel().getValueAt(row, 0).toString());
        try{
            String sql="SELECT Leave_ID,Emp_ID,Holidays_Left,From_Date,To_Date,Total_Days,Reason From LEAVEMS where Leave_ID='"+rowClick+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String reason=rs.getString("Reason");
                jTextArea2.setText(reason);
                
                String holidayLeft=rs.getString("Holidays_Left");
                jTextField79.setText(holidayLeft);
                
                String totalHoliday=rs.getString("Total_Days");
                jTextField87.setText(totalHoliday);
                
                String leaveID=rs.getString("Leave_ID");
                jTextField89.setText(leaveID);
                
                rs.close();
                pst.close();
            }
            else{
                //JOptionPane.showMessageDialog(null, "No Account");
            }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTextField90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField90ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField90ActionPerformed

    private void jTextField91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField91ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField91ActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        // TODO add your handling code here:
        String sql="Select Emp_Name From EMPLOYEE where Emp_ID=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,jTextField92.getText());
            rs=pst.executeQuery();
            if(rs.next())
            {
                String EmpName=rs.getString("Emp_Name");
                jTextField91.setText(EmpName);

                rs.close();
                pst.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Employee ID\nPlease! Enter Correct Employee ID");
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Find EMPLOYEE ATTENDANCE Error A: "+ex);
        }finally{
            try{
                rs.close();
                pst.close();

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Find EMPLOYEE ATTENDANCE Error B: "+ex);
            }
        }
    }//GEN-LAST:event_jButton70ActionPerformed

    private void jTextField92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField92ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField92ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jTextField97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField97ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField97ActionPerformed

    private void jButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton73ActionPerformed
        // TODO add your handling code here:
        
        String cMonth=(String)jComboBox7.getSelectedItem();
        String cDate=((JTextField)jDateChooser6.getDateEditor().getUiComponent()).getText();
        String sql="Select * From ATTENDANCE where C_Month=? and C_Date=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,cMonth);
            pst.setString(2,cDate);
            rs=pst.executeQuery();
            if(rs.next())
            {
                jTable5.setModel(DbUtils.resultSetToTableModel(rs)); 
                
                try
                {
                    String aSql="SELECT COUNT(Emp_ID) as 'Total' FROM ATTENDANCE WHERE C_Month=? and C_Date=?";
                    pst=conn.prepareStatement(aSql);
                    pst.setString(1,cMonth);
                    pst.setString(2,cDate);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        String workingDays=rs.getString("Total");
                        jTextField99.setText(workingDays);
                        
                        int totalEmployee=Integer.parseInt(jTextField97.getText());
                        int presentEmployee=Integer.parseInt(jTextField99.getText());
                        int absentEmployee=totalEmployee-presentEmployee;
                        
                        String totalabsent=String.valueOf(absentEmployee);
                        jTextField100.setText(totalabsent);
                        
                    }

                }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                    System.out.println("TOTAL PRESENT ERROR A: "+ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "SOMETHING WRONG\nPlease fill up the current month and date");
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Find Error A: "+ex);
        }finally{
            try{
                rs.close();
                pst.close();

            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("TOTAL PRESENT ERROR B: "+ex);
            }
        }
    }//GEN-LAST:event_jButton73ActionPerformed

    private void jTextField98ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField98ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField98ActionPerformed

    private void jTextField99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField99ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField99ActionPerformed

    private void jTextField100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField100ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField100ActionPerformed

    private void jComboBox6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox6PopupMenuWillBecomeInvisible
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox6PopupMenuWillBecomeInvisible

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jComboBox5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox5PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        
        try{
            String month=(String)jComboBox5.getSelectedItem();
            String sql="select * from ATTENDANCE where Emp_ID=? and C_Month=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,jTextField92.getText());
            pst.setString(2,month);
            rs=pst.executeQuery();
            if(rs.next())
            {
                jTable5.setModel(DbUtils.resultSetToTableModel(rs)); 
                
                try
                {
                    String aSql="SELECT COUNT(Result) as 'Attendance' FROM ATTENDANCE WHERE Emp_ID=? and C_Month=?";
                    pst=conn.prepareStatement(aSql);
                    pst.setString(1,jTextField92.getText());
                    pst.setString(2,month);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        String workingDays=rs.getString("Attendance");
                        jTextField94.setText(workingDays);
                        
                        int monthPerDay=Integer.parseInt(jTextField101.getText());
                        int presentDay=Integer.parseInt(jTextField94.getText());
                        int absent=monthPerDay-presentDay;
                        
                        String totalabsent=String.valueOf(absent);
                        jTextField95.setText(totalabsent);
                        
                    }

                }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                    System.out.println("Employee ATTENDANCE(MONTH) A: "+ex);
                }
                
                try
                        {
                            String bSql="SELECT COUNT(Result) as 'LateDay' FROM ATTENDANCE WHERE Result='Late' and Emp_ID=? and C_Month=?";
                            pst=conn.prepareStatement(bSql);
                            pst.setString(1,jTextField92.getText());
                            pst.setString(2,month);
                            rs=pst.executeQuery();
                            if(rs.next())
                            {
                                String totalLate=rs.getString("LateDay");
                                jTextField96.setText(totalLate);
                                
                            }
                            
                        }catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(null, ex);
                            System.out.println("Employee ATTENDANCE(MONTH) B: "+ex);
                        }
                
            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Employee aTTENDANCE(MONTH) Error c: "+ex);
        }
    }//GEN-LAST:event_jComboBox5PopupMenuWillBecomeInvisible

    private void jTextField101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField101ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField101ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        // TODO add your handling code here:
        
        try{
            String totalDays=jTextField77.getText();
            String daysPerAmount=jTextField93.getText();

            int amount=Integer.parseInt(totalDays)*Integer.parseInt(daysPerAmount);
            String totalAmount=String.valueOf(amount);
            jTextField102.setText(totalAmount);

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Deposite Total AMount Error: "+ex);
        }
        
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71ActionPerformed
        // TODO add your handling code here:
        
        
        try{
            
            
            String absentDays=jTextField104.getText();
            String leaveDays=jTextField106.getText();
            String lateDays=jTextField105.getText();

            int absent=Integer.parseInt(absentDays)-Integer.parseInt(leaveDays);
            int absentCost=absent*100;
            int lateCost=Integer.parseInt(lateDays)*50;
            
            int totalCost=absentCost+lateCost;
            
            String totalAmount=String.valueOf(totalCost);
            jTextField107.setText(totalAmount);

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Deposite Total AMount Error: "+ex);
        }
    }//GEN-LAST:event_jButton71ActionPerformed

    private void jButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72ActionPerformed
        // TODO add your handling code here:
        
        String paygradeAmount=jTextField114.getText();
        String overtimeAmount=jTextField102.getText();
        String attendanceAmount=jTextField107.getText();
        String salary=jTextField52.getText();
        String bonus=jTextField116.getText();
        
        try{
            
            jTextField109.setText(salary);
            jTextField110.setText(paygradeAmount);
            jTextField111.setText(overtimeAmount);
            jTextField113.setText(attendanceAmount);
            
            int p=Integer.parseInt(jTextField114.getText());
            int o=Integer.parseInt(jTextField102.getText());
            int a=Integer.parseInt(jTextField107.getText());
            int s=Integer.parseInt(jTextField52.getText());
            int n=Integer.parseInt(jTextField116.getText());
            
            int x=p+a;
            int y=s+o+n;
            
            int netS=y-x;
            
            
            String totalAmount=String.valueOf(netS);
            jTextField112.setText(totalAmount);
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton72ActionPerformed

    private void jButton74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton74ActionPerformed
        // TODO add your handling code here:
        FileOutputStream file = null;
        Document document = new Document();
        String sql="INSERT INTO PAYROLL(Emp_ID,Emp_Name,C_Month,C_Date,Salary,Paygrade,overTime,Attendance,Bonus,NetSalary)  values(?,?,?,?,?,?,?,?,?,?)";
        try{
            
            pst=conn.prepareStatement(sql);
            
            pst.setString(1,jTextField4.getText());//Employee ID
            pst.setString(2,jTextField34.getText());//Employee Name
         
            pst.setString(3,jTextField73.getText());//Current Month
            pst.setString(4,((JTextField)jDateChooser9.getDateEditor().getUiComponent()).getText());//Current Date
            
            pst.setString(5,jTextField109.getText());//Salary
            pst.setString(6,jTextField110.getText());//Paygrade
            pst.setString(7,jTextField111.getText());//0vertime
            pst.setString(8,jTextField113.getText());//Attendance
            pst.setString(9,jTextField116.getText());//Bonus
            pst.setString(10,jTextField112.getText());//Net Salary
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Congratulation!\nPayroll has been Completed");
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("PAYROLL ERROR: "+ex);
        }
        
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("../payslip/"+jTextField4.getText()+"_"+ jTextField73.getText()+"_PaySlip.pdf"));
            document.open();
            //document.add(new Paragraph("PAYROLL SLIP"))
            
            //Paragraph p = new Paragraph();
            document.add(new Paragraph("                                                                                                                                                                             Date:" + jDateChooser9.getDate(),FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLDITALIC,BaseColor.LIGHT_GRAY)));
            
            document.add(new Paragraph("\n"));
            document.add(new Paragraph(" Payment Slip\n",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.BLUE)));
            document.add(new Paragraph(" ============================================================ \n",FontFactory.getFont(FontFactory.TIMES_BOLD,12,Font.BOLD,BaseColor.DARK_GRAY)));

            document.add(new Paragraph(" Employee ID:                    " + jTextField4.getText()+"\n\n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY))); 
            document.add(new Paragraph(" Name:                           " + jTextField34.getText()+"\n\n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY)));
            document.add(new Paragraph(" Dept Name:                      " + jTextField33.getText()+"\n\n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY)));    
            document.add(new Paragraph(" Email:                          " + jTextField35.getText()+"\n\n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY)));
            document.add(new Paragraph(" Phone No:                       " + jTextField36.getText()+"\n\n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY)));
            document.add(new Paragraph(" Month:                          " + jTextField73.getText()+"\n\n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY)));
            document.add(new Paragraph(" Salary :                        " + jTextField52.getText()+"\n\n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY)));
            document.add(new Paragraph(" Pay Grade Fee:                  " + jTextField110.getText()+"\n\n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY)));
            document.add(new Paragraph(" Overtime Warking Days:          " + jTextField77.getText()+"\n\n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY)));
            document.add(new Paragraph(" Extra Payment:                  " +jTextField111.getText()+"\n\n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY)));  
            document.add(new Paragraph(" Attendance Fee :                " + jTextField113.getText()+"\n\n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY)));
            document.add(new Paragraph(" ============================================================ \n",FontFactory.getFont(FontFactory.TIMES_BOLD,11,Font.BOLD,BaseColor.DARK_GRAY)));
            document.add(new Paragraph(" Net Salary:                   " + jTextField112.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,12,Font.BOLD,BaseColor.DARK_GRAY)));
            //document.add(p);

            document.close();
            writer.close();
            JOptionPane.showMessageDialog(null, jTextField4.getText() + "Pay Slip has been Created");
        } catch (DocumentException | FileNotFoundException ex) {
            
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Error: " + ex);
        }
    }//GEN-LAST:event_jButton74ActionPerformed

    private void jTextField32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField32ActionPerformed

    private void jTextField107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField107ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField107ActionPerformed

    
    
    private void jButton76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton76ActionPerformed
        // TODO add your handling code here:
        
        try{
            String sql="SELECT Emp_ID,Emp_Name,Emp_netSalary/30 Daily,Emp_netSalary/7 Weekly,Emp_netSalary,Emp_netSalary*12 Annually FROM EMPLOYEE ORDER BY Annually";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable7.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton76ActionPerformed

    private void jButton78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton78ActionPerformed
        // TODO add your handling code here:
        String text=jTextField115.getText();
            
        try{
            String sql="SELECT Emp_ID,Emp_Name FROM EMPLOYEE where Emp_Name LIKE '"+text+"%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton78ActionPerformed

    private void jTextField115ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField115ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField115ActionPerformed

    private void jButton79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton79ActionPerformed
        // TODO add your handling code here:
        try{
            String sql="SELECT Emp_ID,Emp_Name,Emp_netSalary FROM EMPLOYEE  ORDER BY Emp_Name";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton79ActionPerformed

    private void jButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton80ActionPerformed
        // TODO add your handling code here:
        
        String s1=jTextField117.getText();
        String s2=jTextField118.getText();
            
        try{
            String sql="SELECT Emp_ID,Emp_Name,Emp_netSalary FROM EMPLOYEE WHERE Emp_netSalary BETWEEN '"+s1+"' AND '"+s2+"' ORDER BY Emp_netSalary";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton80ActionPerformed

    private void jTextField117ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField117ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField117ActionPerformed

    private void jTextField118ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField118ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField118ActionPerformed

    private void jButton81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton81ActionPerformed
        // TODO add your handling code here:
        String no=jTextField119.getText();
            
        try{
            String sql="Select DEPARTMENT.Dept_Name,DEPARTMENT.Dept_ID FROM EMPLOYEE INNER JOIN DEPARTMENT ON Emp_Dept=Dept_ID GROUP BY DEPARTMENT.Dept_Name,DEPARTMENT.Dept_ID HAVING COUNT(*)>'"+no+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton81ActionPerformed

    private void jTextField119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField119ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField119ActionPerformed

    private void jButton82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton82ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton82ActionPerformed

    private void jButton83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton83ActionPerformed
        // TODO add your handling code here:
        
        String select=(String)jComboBox8.getSelectedItem();
            
        try{
            String sql="SELECT Emp_ID,Emp_Name,Emp_netSalary FROM EMPLOYEE WHERE Emp_netSalary IN (SELECT max(Emp_netSalary) FROM EMPLOYEE WHERE Emp_Dept IN(SELECT d.Dept_ID FROM DEPARTMENT d where d.Dept_Name='"+select+"'))";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton83ActionPerformed

    private void jComboBox8PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox8PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox8PopupMenuWillBecomeInvisible

    private void jButton84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton84ActionPerformed
        // TODO add your handling code here:
        
        try{
            String sql="SELECT E.Emp_Name,E.Emp_ID,E.Emp_Dept FROM EMPLOYEE E WHERE E.Emp_netSalary IN (SELECT max(Emp_netSalary) FROM EMPLOYEE GROUP BY Emp_Dept)";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton84ActionPerformed

    private void jButton85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton85ActionPerformed
        // TODO add your handling code here:
        
        try{
            String sql="SELECT Dept_Name,Dept_ID FROM DEPARTMENT WHERE Dept_ID IN (SELECT Emp_Dept FROM EMPLOYEE GROUP BY Emp_Dept HAVING count(*) IN (SELECT MAX(mycount) FROM (SELECT COUNT(*) mycount FROM EMPLOYEE GROUP BY Emp_Dept) a))";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton85ActionPerformed

    private void jButton86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton86ActionPerformed
        // TODO add your handling code here:
        
        try{
            String sql="SELECT Emp_ID,Emp_Name,Emp_Doj FROM EMPLOYEE e WHERE Emp_Doj IN (SELECT Emp_Doj FROM EMPLOYEE WHERE e.Emp_ID <> Emp_ID)";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton86ActionPerformed

    private void jButton87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton87ActionPerformed
        // TODO add your handling code here:
        
        String select=(String)jComboBox9.getSelectedItem();
            
        try{
            String sql="SELECT Emp_Name FROM EMPLOYEE WHERE Emp_City='"+select+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
        
    }//GEN-LAST:event_jButton87ActionPerformed

    private void jComboBox9PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox9PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox9PopupMenuWillBecomeInvisible

    private void jButton88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton88ActionPerformed
        // TODO add your handling code here:
        
        try{
            String sql="SELECT d.Dept_ID,count(a.Emp_Dept) as TotalEmployee FROM DEPARTMENT d LEFT OUTER JOIN EMPLOYEE a ON a.Emp_Dept=d.Dept_ID GROUP BY d.Dept_ID HAVING count(a.Emp_Dept)=0";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton88ActionPerformed

    private void jButton89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton89ActionPerformed
        // TODO add your handling code here:
        
        String cDate=((JTextField)jDateChooser10.getDateEditor().getUiComponent()).getText();
        
        try{
            String sql="SELECT Emp_ID,Emp_Name FROM EMPLOYEE WHERE Emp_Doj<('"+cDate+"')";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
        
    }//GEN-LAST:event_jButton89ActionPerformed

    private void jButton90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton90ActionPerformed
        // TODO add your handling code here:
        
        String cDate=((JTextField)jDateChooser11.getDateEditor().getUiComponent()).getText();
        
        try{
            String sql="SELECT Emp_ID,Emp_Name FROM EMPLOYEE WHERE Emp_Doj>('"+cDate+"')";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton90ActionPerformed

    private void jButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton77ActionPerformed
        // TODO add your handling code here:

        try{
            String sql="SELECT Dept_ID,Dept_name,COUNT(*) FROM DEPARTMENT ORDER BY Dept_ID";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();

            jTable7.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Table7 Error: "+ex);
        }
    }//GEN-LAST:event_jButton77ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton amount;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel imageSet;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton79;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton82;
    private javax.swing.JButton jButton83;
    private javax.swing.JButton jButton84;
    private javax.swing.JButton jButton85;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JButton jButton88;
    private javax.swing.JButton jButton89;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton90;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser10;
    private com.toedter.calendar.JDateChooser jDateChooser11;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private com.toedter.calendar.JDateChooser jDateChooser9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField100;
    private javax.swing.JTextField jTextField101;
    private javax.swing.JTextField jTextField102;
    private javax.swing.JTextField jTextField103;
    private javax.swing.JTextField jTextField104;
    private javax.swing.JTextField jTextField105;
    private javax.swing.JTextField jTextField106;
    private javax.swing.JTextField jTextField107;
    private javax.swing.JTextField jTextField108;
    private javax.swing.JTextField jTextField109;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField110;
    private javax.swing.JTextField jTextField111;
    private javax.swing.JTextField jTextField112;
    private javax.swing.JTextField jTextField113;
    private javax.swing.JTextField jTextField114;
    private javax.swing.JTextField jTextField115;
    private javax.swing.JTextField jTextField116;
    private javax.swing.JTextField jTextField117;
    private javax.swing.JTextField jTextField118;
    private javax.swing.JTextField jTextField119;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField73;
    private javax.swing.JTextField jTextField74;
    private javax.swing.JTextField jTextField75;
    private javax.swing.JTextField jTextField76;
    private javax.swing.JTextField jTextField77;
    private javax.swing.JTextField jTextField78;
    private javax.swing.JTextField jTextField79;
    private javax.swing.JTextField jTextField80;
    private javax.swing.JTextField jTextField81;
    private javax.swing.JTextField jTextField82;
    private javax.swing.JTextField jTextField83;
    private javax.swing.JTextField jTextField84;
    private javax.swing.JTextField jTextField85;
    private javax.swing.JTextField jTextField86;
    private javax.swing.JTextField jTextField87;
    private javax.swing.JTextField jTextField88;
    private javax.swing.JTextField jTextField89;
    private javax.swing.JTextField jTextField90;
    private javax.swing.JTextField jTextField91;
    private javax.swing.JTextField jTextField92;
    private javax.swing.JTextField jTextField93;
    private javax.swing.JTextField jTextField94;
    private javax.swing.JTextField jTextField95;
    private javax.swing.JTextField jTextField96;
    private javax.swing.JTextField jTextField97;
    private javax.swing.JTextField jTextField98;
    private javax.swing.JTextField jTextField99;
    private javax.swing.JRadioButton percentage;
    // End of variables declaration//GEN-END:variables

//for adding Image
    private ImageIcon format=null;
    String filename=null;
    int x=0;
    byte[] employee_image=null;
    private String gender;
}
