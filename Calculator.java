import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfeild;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Ink Free",Font.BOLD,30);
    Font myFont2 = new Font("Ink Free",Font.BOLD,25);
    
double num1=0, num2=0,result=0;
char operator;

Calculator(){

    frame = new JFrame("My Calcualtor");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 550);
    frame.setLayout(null);

    textfeild = new JTextField();
    textfeild.setBounds(50, 25, 300, 50);
    textfeild.setFont(myFont);
    textfeild.setBackground(Color.ORANGE);
    textfeild.setEditable(false);

    addButton = new JButton("+");
    subButton = new JButton("-");
    mulButton = new JButton("x");
divButton = new JButton("/");
decButton = new JButton(".");
eqButton = new JButton("=");
delButton = new JButton("Delete");
clrButton = new JButton("Clear");
negButton = new JButton("-");

    functionButtons[0] = addButton;
    functionButtons[1] =subButton;
    functionButtons[2] =mulButton;
    functionButtons[3] =divButton;
    functionButtons[4] =decButton;
    functionButtons[5] =eqButton;
    functionButtons[6] =delButton;
    functionButtons[7] =clrButton;
    functionButtons[8] =negButton;

    for(int i=0;i<9;i++){
        functionButtons[i].addActionListener(this);
        functionButtons[i].setFont(myFont2);
        functionButtons[i].setBackground(Color.ORANGE);
        functionButtons[i].setBorderPainted(false);
        functionButtons[i].setFocusable(false);
    }

    for(int i=0;i<10;i++){
        numberButtons[i] = new JButton(String.valueOf(i));
        numberButtons[i].addActionListener(this);
        numberButtons[i].setFont(myFont);
        numberButtons[i].setBackground(Color.ORANGE);
        numberButtons[i].setFocusable(false);
    }

    negButton.setBounds(50,430,80,50);
    delButton.setBounds(130,430,110,50);
    clrButton.setBounds(240,430,110,50);

    panel = new JPanel();
    panel.setBounds(50,100,300,300);
    panel.setLayout(new GridLayout(4,4,10,10));
    panel.setBackground(Color.LIGHT_GRAY);
    

    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(addButton);
    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(subButton);
    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(mulButton);
    panel.add(decButton);
    panel.add(numberButtons[0]);
    panel.add(eqButton);
    panel.add(divButton);

    frame.add(panel);
    //frame.add(negButton);
    frame.add(delButton);
    frame.add(clrButton);
    frame.add(textfeild);
    frame.setVisible(true);

}
    public static void main(String[] args){

        Calculator calc = new Calculator();
    }

    public void actionPerformed(ActionEvent e){

        for(int i=0;i<10;i++){
            if(e.getSource()== numberButtons[i]){
                textfeild.setText(textfeild.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textfeild.setText(textfeild.getText().concat("."));
            }

        
        if(e.getSource()== addButton){
            num1= Double.parseDouble(textfeild.getText());
            operator='+';
            textfeild.setText("");    
        }
        if(e.getSource()== subButton){
            num1= Double.parseDouble(textfeild.getText());
            operator='-';
            textfeild.setText("");    
        }
        if(e.getSource()== mulButton){
            num1= Double.parseDouble(textfeild.getText());
            operator='x';
            textfeild.setText("");    
        }
        if(e.getSource()== divButton){
            num1= Double.parseDouble(textfeild.getText());
            operator='/';
            textfeild.setText("");    
        }

        if(e.getSource()== eqButton){
            num2=Double.parseDouble(textfeild.getText());

            switch (operator) {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'x':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;    
                    
          }
            textfeild.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton){
            textfeild.setText("");
        }
        if(e.getSource()==delButton){
            String string= textfeild.getText();
            textfeild.setText("");

            for(int i=0; i<string.length()-1; i++){
                textfeild.setText(textfeild.getText()+string.charAt(i));
            }
    }
// if(e.getSource()==negButton){
        //double temp= Double.parseDouble(textfeild.getText());
        //temp= temp*(-1);
        //textfeild.setText(String.valueOf(temp));
    //}
   
}

}