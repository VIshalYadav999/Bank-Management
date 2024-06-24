package atm.simulator.machine;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JButton withdraw,cancel;
    JTextField amount;
    String pinnumber;
    
    Withdrawl(String pinnumber) {
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750,750);        
        add(image);
        
        JLabel text = new JLabel("Enter The Amount You Want To Withdraw");
        text.setBounds(130, 230, 350, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD, 22));
        amount.setBounds(130,270,300,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(320, 380,100,25);
        withdraw.addActionListener(this);
        image.add(withdraw);        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(320, 407,100,25);
        cancel.addActionListener(this);
        image.add(cancel);        
        
        setSize(750,750);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw ){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter The Amount You Want To withdraw");
            }else {
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs: " +number+ " Withdraw Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                } 
            }
                
        }else if (ae.getSource() == cancel ){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdrawl("");
    }
}
