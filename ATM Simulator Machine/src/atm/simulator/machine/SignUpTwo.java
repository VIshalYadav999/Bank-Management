package atm.simulator.machine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    JTextField aadhar,pan;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    JComboBox religion,category,income,education,occupation;
    String formno;
    
    SignUpTwo(String formno){
        this.formno = formno;
        setLayout(null);        
        setTitle("New Account Application Form - Page 02");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel rel = new JLabel("Religion: ");
        rel.setFont(new Font("Raleway", Font.BOLD, 21));
        rel.setBounds(100, 140, 100, 30);
        add(rel);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Parsi","Buddist","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel fname = new JLabel("Category: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 21));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[] = {"General","OBC","ST","SC","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 21));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String valIncome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 21));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        JLabel email = new JLabel("Qualification: ");
        email.setFont(new Font("Raleway", Font.BOLD, 21));
        email.setBounds(100, 315, 200, 30);
        add(email);
        
        String valEducation[] = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Other"};
        education = new JComboBox(valEducation);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
                
        JLabel marital = new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 21));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        String valOccupation[] = {"Self-Employed","Bussiness","Retired","Student","Other"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);        
        
        JLabel address = new JLabel("PAN Number: ");
        address.setFont(new Font("Raleway", Font.BOLD, 21));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 15));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city = new JLabel("Aadhar Number: ");
        city.setFont(new Font("Raleway", Font.BOLD, 21));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 15));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel state = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD, 21));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        syes = new JRadioButton ("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
       
        ButtonGroup SeniorGroup = new ButtonGroup();
        SeniorGroup.add(syes);
        SeniorGroup.add(sno);
        
        JLabel pincode = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 21));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton ("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup ExistingGroup = new ButtonGroup();
        ExistingGroup.add(eyes);
        ExistingGroup.add(eno);
        
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
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem() ;
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String sseniorcitizen = null;
        if (syes.isSelected()) {
            sseniorcitizen = "Yes";            
        }else if(sno.isSelected()) {
            sseniorcitizen = "No";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();
        String sexistingaccount = null;
        if(eyes.isSelected()){
            sexistingaccount = "Yes";
        }else if(eno.isSelected()){
            sexistingaccount = "No";
        }
        
        try{
            
            Conn c = new Conn();
            String query = "insert into singuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+sseniorcitizen+"','"+sexistingaccount+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignUpThree(formno).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new SignUpTwo("");
    }
}
