package atm.simulator.machine;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
            
    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700,700);        
        add(image);
        
        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,30));
        text.setBounds(140, 200, 400, 70);
        image.add(text);
        
        JLabel pintext = new JLabel("New Pin");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD,20));
        pintext.setBounds(130, 320, 400, 20);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,20));
        pin.setBounds(260, 320, 100,20);
        pin.addActionListener(this);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter Pin");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD,20));
        repintext.setBounds(130, 350, 400, 20);
        image.add(repintext);
                
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,20));
        repin.setBounds(260, 350, 100,20);
        repin.addActionListener(this);
        image.add(repin);
       
        change = new JButton("CHANGE");
        change.setBounds(260, 375, 100,20);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(260, 400, 100,20);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700, 700);
        setLocation(300, 0);
        setVisible(true);
                
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();
            
                 if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Enter PIN Does Not Match!");
                    return;
                }
            
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter New PIN");
                    return;
                }
            
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query3 = "update singupthree set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                                               
            }catch (Exception e){
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }        
        public static void main(String args[]) {
            new PinChange("").setVisible(true);
        }
    }
