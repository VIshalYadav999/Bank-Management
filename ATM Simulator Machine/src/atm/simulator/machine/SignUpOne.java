package atm.simulator.machine;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JRadioButton male,female,Divorce,married,unmarried;
    JDateChooser dateChooser;
    JButton next;
    
    SignUpOne(){
        
        setLayout(null);        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 900L) + 100L);
        
        JLabel formno = new JLabel("Application Form No: " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 39));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 21));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
                
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 21));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 21));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400,30);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 21));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290,60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290,80, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 21));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 21));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390,80, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390,100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        Divorce = new JRadioButton("Divorce");
        Divorce.setBounds(630, 390,80, 30);
        Divorce.setBackground(Color.WHITE);
        add(Divorce);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(Divorce);
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 21));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 21));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 21));
        state.setBounds(100, 540, 200, 30);
        add(state);
       
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 21));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.ORANGE);
        next.setFont(new Font("Raleway", Font.BOLD,15));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);        
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";            
        }else if(female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "married";
        }else if(unmarried.isSelected()){
            marital = "unmarried";
        }else if(Divorce.isSelected()){
            marital = "Divorce";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        
        
        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name Is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"F Name Is Required");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"DOB Is Required");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email Address Is Required");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address Is Required");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City Is Required");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State Is Required");
            }else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null,"Pincode Is Required");
            }else {
                Conn c = new Conn();
                String query = "insert into singup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new SignUpOne();
    }
}
