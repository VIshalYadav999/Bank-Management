package atm.simulator.machine;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,Withdrawl,fastcash,Back,pinchange,balanceenquiry,ministatement;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700,700);        
        add(image);
        
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(170, 230, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(130, 320,100,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        Withdrawl = new JButton("Rs 500");
        Withdrawl.setBounds(130, 350,100,25);
        Withdrawl.addActionListener(this);
        image.add(Withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(130, 380,100,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        Back = new JButton("Back");
        Back.setBounds(210, 407,100,20);
        Back.addActionListener(this);
        image.add(Back);
        
        pinchange = new JButton("Rs 2000");
        pinchange.setBounds(290, 320,100,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Rs 5000");
        balanceenquiry.setBounds(290, 350,100,25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        ministatement = new JButton("Rs 10000");
        ministatement.setBounds(290, 380,100,25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        setSize(700,700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != Back && balance <Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " +amount+ "Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch (Exception e) {
                System.out.println(e);
            }
        } 
        
    }
    
    public static void main(String args[]) {
        new FastCash("");
    }
}
