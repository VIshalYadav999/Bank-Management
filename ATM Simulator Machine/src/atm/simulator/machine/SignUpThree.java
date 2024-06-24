package atm.simulator.machine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    SignUpThree(String formno){
        this.formno = formno;
        setLayout(null);
        
        JLabel P3Details = new JLabel("Page 3: Account Details");
        P3Details.setFont(new Font("Raleway", Font.BOLD, 20));
        P3Details.setBounds(320, 0, 600, 40);
        add(P3Details);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(100, 50, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 90, 200, 20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 90, 240, 20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 140, 200, 20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 140, 240, 20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100, 180, 200, 30);
        add(card);
        
        JLabel no = new JLabel("XXXX-XXXX-XXXX-2609");
        no.setFont(new Font("Raleway", Font.BOLD, 20));
        no.setBounds(330, 180, 300, 30);
        add(no);
        
        JLabel cardno = new JLabel("Your Card Number");
        cardno.setFont(new Font("Raleway", Font.BOLD, 12));
        cardno.setBounds(100, 210, 300, 20);
        add(cardno);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 250, 200, 30);
        add(pin);
        
        JLabel pno = new JLabel("XXXX");
        pno.setFont(new Font("Raleway", Font.BOLD, 20));
        pno.setBounds(330, 250, 300, 30);
        add(pno);
        
        JLabel Ypass = new JLabel("Your Password");
        Ypass.setFont(new Font("Raleway", Font.BOLD, 12));
        Ypass.setBounds(100, 280, 300, 20);
        add(Ypass);
        
        JLabel Sr = new JLabel("Services Required");
        Sr.setFont(new Font("Raleway", Font.BOLD, 22));
        Sr.setBounds(100, 310, 400, 30);
        add(Sr);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,350,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,350,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,390,200,30);
        add(c3);
        
        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,390,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,430,200,30);
        add(c5);
        
        c6 = new JCheckBox("E Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,430,200,30);
        add(c6);
        
        c7 = new JCheckBox("I Hereby Declares That The Above Entered Details Are Correct To The Best Of My Knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(100,490,800,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD,14));
        submit.setBounds(250, 540, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD,14));
        cancel.setBounds(420, 540, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected ()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Reccuring Deposit Account";
            } 
            
            Random random = new Random();
            String cardnumber = ""  + Math.abs(random.nextLong() % 90000000L + 5040936000000000L);
            
            String pin = "" + Math.abs(random.nextLong() % 9000L + 1000L);
            
            String facility = "";
            if (c1.isSelected()){
                facility = facility + " ATM Card";
            }else if (c2.isSelected()){
                facility = facility + " Internet Banking";
            }else if (c3.isSelected()){
                facility = facility + " Mobile Banking";
            }else if (c4.isSelected()){
                facility = facility + " Email Alerts";
            }else if (c5.isSelected()){
                facility = facility + " Cheque Book";
            }else if (c6.isSelected()){
                facility = facility + " Mobile Banking";
            }else if (c7.isSelected()){
                facility = facility + "E-Statement";
            }
            
            try {
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type Is Required");
                } else {
                    Conn conn = new Conn ();
                    String query1 = "insert into singupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pin+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pin+"')";    
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pin);
                }
                
            } catch (Exception e) {
               System.out.println(e);
            }
        }else if (ae.getSource() == cancel){
            
        }
    }
    public static void main(String args[]){
        new SignUpThree("");
    }
}
