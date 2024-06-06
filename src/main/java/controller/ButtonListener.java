package controller;

import model.Operation;
import model.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListener implements ActionListener {
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;

    public ButtonListener(JTextField tf1, JTextField tf2, JTextField tf3, JTextField tf4)
    {
        this.tf1 = tf1;
        this.tf2 = tf2;
        this.tf3 = tf3;
        this.tf4 = tf4;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = ((JButton) e.getSource()).getText();

        if(name.equals("Add"))
        {
            if(((Operation.Addition(Regex.getPolynomialFromInput(tf1.getText()), Regex.getPolynomialFromInput(tf2.getText())) + "").charAt(0)) == '-')
            {
                tf3.setText(Operation.Addition(Regex.getPolynomialFromInput(tf1.getText()), Regex.getPolynomialFromInput(tf2.getText())) + "");
            }
            else
            {
                tf3.setText( (Operation.Addition(Regex.getPolynomialFromInput(tf1.getText()), Regex.getPolynomialFromInput(tf2.getText()))+ "").substring(1));
            }
            tf4.setText("");
        }


       if(name.equals("Substract"))
        {
            if((Operation.Substraction(Regex.getPolynomialFromInput(tf1.getText()), Regex.getPolynomialFromInput(tf2.getText())) + "").charAt(0) == '-')
            {
                tf3.setText(Operation.Substraction(Regex.getPolynomialFromInput(tf1.getText()), Regex.getPolynomialFromInput(tf2.getText())) + "");
            }
            else
            {
                tf3.setText((Operation.Substraction(Regex.getPolynomialFromInput(tf1.getText()), Regex.getPolynomialFromInput(tf2.getText())) + "").substring(1));
            }

            tf4.setText("");
        }

       if(name.equals("Multiplicate"))
       {
           if((Operation.Multiplication(Regex.getPolynomialFromInput(tf1.getText()), Regex.getPolynomialFromInput(tf2.getText())) + "").charAt(0) == '-')
           {
               tf3.setText(Operation.Multiplication(Regex.getPolynomialFromInput(tf1.getText()), Regex.getPolynomialFromInput(tf2.getText())) + "");
           }
           else
           {
               tf3.setText((Operation.Multiplication(Regex.getPolynomialFromInput(tf1.getText()), Regex.getPolynomialFromInput(tf2.getText())) + "").substring(1));
           }

           tf4.setText("");
       }

      if(name.equals("Divide"))
      {
          ArrayList<Polynomial> result = Operation.Division(Regex.getPolynomialFromInput(tf1.getText()), Regex.getPolynomialFromInput(tf2.getText()));

          if((result.get(0)+"").charAt(0) == '-')
          {
              tf3.setText(result.get(0) + "");
          }
          else
          {
              tf3.setText((result.get(0) + "").substring(1));
          }

          if((result.get(1)+"").charAt(0) == '-')
          {
              tf4.setText(result.get(1) + "");
          }
          else
          {
              tf4.setText((result.get(1) + "").substring(1));
          }
      }

      if(name.equals("Derivate"))
      {
          if((Operation.Derivation( Regex.getPolynomialFromInput(tf1.getText())) + "").charAt(0) == '-')
          {
              tf3.setText(Operation.Derivation(Regex.getPolynomialFromInput(tf1.getText())) + "");
          }
          else
          {
              tf3.setText((Operation.Derivation(Regex.getPolynomialFromInput(tf1.getText())) + "").substring(1));
          }

          tf4.setText("");
      }

      if(name.equals("Integrate"))
      {
          if((Operation.Integration( Regex.getPolynomialFromInput(tf1.getText())) + "").charAt(0) == '-')
          {
              tf3.setText(Operation.Integration(Regex.getPolynomialFromInput(tf1.getText())) + "");
          }
          else
          {
              tf3.setText((Operation.Integration(Regex.getPolynomialFromInput(tf1.getText())) + "").substring(1));
          }
          tf4.setText("");
      }

    }
}
