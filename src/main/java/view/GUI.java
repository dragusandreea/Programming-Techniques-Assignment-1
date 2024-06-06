package view;

import controller.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public static void startGUI() {

        JFrame frame = new JFrame("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 360);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel10 = new JPanel();

        JLabel label1 = new JLabel("Polynomial Calculator");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setVerticalAlignment(SwingConstants.CENTER);
        panel1.add(label1);

        JLabel label2 = new JLabel("  First Polynomial =   ");
        JTextField textfield2 = new JTextField(20);
        panel2.add(label2);
        panel2.add(textfield2);

        JLabel label4 = new JLabel("Second Polynomial = ");
        JTextField textfield4 = new JTextField(20);
        panel4.add(label4);
        panel4.add(textfield4);

        JLabel label10 = new JLabel("Result = ");
        JTextField textfield10 = new JTextField(35);

        JLabel label11 = new JLabel("Result2 = ");
        JTextField textfield11 = new JTextField(35);

        panel10.add(label10);
        panel10.add(textfield10);

        panel10.add(label11);
        panel10.add(textfield11);


        ButtonListener listener33 = new ButtonListener(textfield2,textfield4,textfield10,textfield11);

        JButton button31 = new JButton("Multiplicate");
        button31.addActionListener(listener33);

        JButton button32 = new JButton("Divide");
        button32.addActionListener(listener33);

        JButton button33 = new JButton("Add");
        button33.addActionListener(listener33);

        JButton button34 = new JButton("Derivate");
        button34.addActionListener(listener33);

        GridLayout layout3 = new GridLayout(0, 1);
        panel3.setLayout(layout3);

        panel3.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JButton button51 = new JButton("Substract");
        button51.addActionListener(listener33);

        JButton button54 = new JButton("Integrate");
        button54.addActionListener(listener33);

        GridLayout layout5 = new GridLayout(0, 1);
        panel5.setLayout(layout5);

        panel3.add(button33);
        panel3.add(button51);
        panel3.add(button31);

        panel5.add(button32);
        panel5.add(button34);
        panel5.add(button54);

        panel5.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        GridLayout layout6 = new GridLayout(0, 2);
        panel6.setLayout(layout6);

        panel6.add(panel3);
        panel6.add(panel5);


        JPanel finalPanel = new JPanel();
        finalPanel.add(panel1);
        finalPanel.add(panel2);
        finalPanel.add(panel4);
        finalPanel.add(panel10);
        finalPanel.add(panel6);
        finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.Y_AXIS));
        frame.setContentPane(finalPanel);
        frame.setVisible(true);

    }
}
