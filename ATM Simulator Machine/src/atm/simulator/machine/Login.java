package atm.simulator.machine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField PinTextField;
    
    Login() {
        setTitle("Automated Teller Machine");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100,100);        
        add(label);
        
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward",Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel Cardno = new JLabel("Card No: ");
        Cardno.setFont(new Font("Raleway",Font.BOLD, 26));
        Cardno.setBounds(120, 150, 150, 30);
        add(Cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(cardTextField);
        
        JLabel Pin = new JLabel("PIN: ");
        Pin.setFont(new Font("Osward",Font.BOLD, 26));
        Pin.setBounds(120, 220, 230, 30);
        add(Pin);
        
        PinTextField = new JPasswordField();
        PinTextField.setBounds(300, 220, 230, 30);
        PinTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(PinTextField);
        
        login = new JButton ("SIGN IN");
        login.setBounds(300,300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton ("CLEAR");
        clear.setBounds(430,300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton ("SIGN UP");
        signup.setBounds(300,350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
                        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 210);        
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear){
            cardTextField.setText("");
            PinTextField.setText("");
        }else if (ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = PinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect CardNumber Or Pin");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource() == signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
        
    public static void main(String args[]) {
        new Login();
    }
}
