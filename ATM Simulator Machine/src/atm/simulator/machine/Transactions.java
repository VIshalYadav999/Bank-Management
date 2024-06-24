package atm.simulator.machine;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,Withdrawl,fastcash,exit,pinchange,balanceenquiry,ministatement;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700,700);        
        add(image);
        
        
        JLabel text = new JLabel("Please Select Your Transactions");
        text.setBounds(135, 230, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(130, 320,100,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        Withdrawl = new JButton("Withdrawl");
        Withdrawl.setBounds(130, 350,100,25);
        Withdrawl.addActionListener(this);
        image.add(Withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(130, 380,100,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        exit = new JButton("Exit");
        exit.setBounds(210, 407,100,20);
        exit.addActionListener(this);
        image.add(exit);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(290, 320,100,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Balance");
        balanceenquiry.setBounds(290, 350,100,25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(290, 380,100,25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        setSize(700,700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit) {
            System.exit(0);
        } else if(ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == Withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if(ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if(ae.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Transactions("");
    }
}
