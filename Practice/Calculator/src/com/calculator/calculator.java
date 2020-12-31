package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator implements ActionListener {

    private static JLabel outputLabel;

    private static String s0;
    private static String s1;
    private static String s2;

    private static boolean wasOperand;
    private static boolean wasEquals;
    private static boolean canBackspace;

    calculator() {
        s0 = s1 = s2 = "";
        wasOperand = false;
        wasEquals = false;
        canBackspace = false;
    }

    private static JButton createButton(String character, calculator c) {
        JButton button = new JButton(character);
        button.addActionListener(c);
        return button;
    }

    private static void setGui(JFrame gui) {

        JPanel outputPanel = new JPanel();
        outputPanel.setPreferredSize(new Dimension(300, 40));

        outputLabel = new JLabel();
        outputPanel.add(outputLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 4));

        calculator c = new calculator();

        buttonPanel.add(createButton("%", c));
        buttonPanel.add(createButton("CE", c));
        buttonPanel.add(createButton("C", c));
        buttonPanel.add(createButton("BACK", c));

        buttonPanel.add(createButton("1/x", c));
        buttonPanel.add(createButton("x^2", c));
        buttonPanel.add(createButton("sqrt(x)", c));
        buttonPanel.add(createButton("/", c));

        buttonPanel.add(createButton("7", c));
        buttonPanel.add(createButton("8", c));
        buttonPanel.add(createButton("9", c));
        buttonPanel.add(createButton("*", c));

        buttonPanel.add(createButton("4", c));
        buttonPanel.add(createButton("5", c));
        buttonPanel.add(createButton("6", c));
        buttonPanel.add(createButton("-", c));

        buttonPanel.add(createButton("1", c));
        buttonPanel.add(createButton("2", c));
        buttonPanel.add(createButton("3", c));
        buttonPanel.add(createButton("+", c));

        buttonPanel.add(createButton("+/-", c));
        buttonPanel.add(createButton("0", c));
        buttonPanel.add(createButton(".", c));
        buttonPanel.add(createButton("=", c));

        gui.setLayout(new BorderLayout());
        gui.add(outputPanel, BorderLayout.NORTH);
        gui.add(buttonPanel, BorderLayout.SOUTH);

        gui.pack();
        gui.setLocationRelativeTo(null);
    }

    private static JFrame createGUI() {
        JFrame gui = new JFrame("George's Calculator");
        setGui(gui);
        return gui;
    }

    private static String cleanUpTrailingZero(String output) {

        String lastTwoCharacters = s2.length() > 2 ? output.substring(output.length() - 2) : output;
        if(lastTwoCharacters.equals(".0")) {
            output = output.substring(0, output.length() - 2);
        }

        return output;
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        System.out.println("Input: " + s);

        switch (s) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".":

                if (wasEquals) {
                    s0 = s;
                    s1 = "";
                    s2 = "";
                }
                else if (wasOperand) {
                    s2 = "";
                }

                if (s2.equals("") || s2.equals("0")) {
                    s2 = s;
                }
                else {
                    s2 = s2 + s;
                }

                outputLabel.setText(s2);

                wasOperand = false;
                wasEquals = false;
                canBackspace = true;

                break;
            case "+/-":
                if (wasOperand) {
                    s2 = s0;
                }

                if (s2.equals("") || s2.equals("0")) {
                    s2 = s2;
                }
                else {
                    if (s2.charAt(0) == '-') {
                        s2 = s2.substring(1);
                    }
                    else {
                        s2 = "-" + s2;
                    }
                }

                outputLabel.setText(s2);

                wasOperand = false;
                wasEquals = false;
                canBackspace = true;

                break;
            case "1/x":
                if (wasOperand) {
                    s2 = s0;
                }

                if (s2.equals("") || s2.equals("0")) {
                    s2 = "Cannot divide by zero.";
                }
                else {
                    s2 = String.valueOf(1/Double.parseDouble(s2));
                }

                // Clean-up trailing ".0" if present
                s2 = cleanUpTrailingZero(s2);
                outputLabel.setText(s2);

                wasOperand = false;
                wasEquals = false;
                canBackspace = false;

                break;
            case "x^2":
                if (wasOperand) {
                    s2 = s0;
                }

                if (s2.equals("") || s2.equals("0")) {
                    s2 = s2;
                }
                else {
                    s2 = String.valueOf(Math.pow(Double.parseDouble(s2), 2));
                }

                // Clean-up trailing ".0" if present
                s2 = cleanUpTrailingZero(s2);
                outputLabel.setText(s2);

                wasOperand = false;
                wasEquals = false;
                canBackspace = false;

                break;
            case "sqrt(x)":
                if (wasOperand) {
                    s2 = s0;
                }

                if (s2.equals("") || s2.equals("0")) {
                    s2 = s2;
                }
                else {
                    s2 = String.valueOf(Math.sqrt(Double.parseDouble(s2)));
                }

                // Clean-up trailing ".0" if present
                s2 = cleanUpTrailingZero(s2);
                outputLabel.setText(s2);

                wasOperand = false;
                wasEquals = false;
                canBackspace = false;

                break;
            case "%":
                if (wasOperand) {
                    s2 = s0;
                }

                if (s2.equals("") || s2.equals("0")) {
                    s2 = s2;
                }
                else {
                    s2 = String.valueOf((Double.parseDouble(s2)/100) * Double.parseDouble(s0));
                }

                // Clean-up trailing ".0" if present
                s2 = cleanUpTrailingZero(s2);
                outputLabel.setText(s2);

                wasOperand = false;
                wasEquals = false;
                canBackspace = false;

                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (wasEquals) {
                    s0 = s0;
                }
                else if ((s1.equals("") || s2.equals("")) && !wasOperand) {
                    s0 = s2;
                }
                else if (s1.equals("+") && !s2.equals("")) {
                    s0 = String.valueOf(Double.parseDouble(s0) + Double.parseDouble(s2));
                }
                else if (s1.equals("-") && !s2.equals("")) {
                    s0 = String.valueOf(Double.parseDouble(s0) - Double.parseDouble(s2));
                }
                else if (s1.equals("*") && !s2.equals("")) {
                    s0 = String.valueOf(Double.parseDouble(s0) * Double.parseDouble(s2));
                }
                else if (s1.equals("/") && !s2.equals("")) {
                    s0 = String.valueOf(Double.parseDouble(s0) / Double.parseDouble(s2));
                }
                s1 = s;
                s2 = "";

                // Clean-up trailing ".0" if present
                s0 = cleanUpTrailingZero(s0);
                outputLabel.setText(s0);

                wasOperand = true;
                wasEquals = false;
                canBackspace = false;

                break;
            case "=":
                if (s2.equals("")) {
                    s2 = s0;
                }
                if (s1.equals("+")) {
                    s0 = String.valueOf(Double.parseDouble(s0) + Double.parseDouble(s2));
                }
                else if (s1.equals("-")) {
                    s0 = String.valueOf(Double.parseDouble(s0) - Double.parseDouble(s2));
                }
                else if (s1.equals("*")) {
                    s0 = String.valueOf(Double.parseDouble(s0) * Double.parseDouble(s2));
                }
                else if (s1.equals("/")) {
                    s0 = String.valueOf(Double.parseDouble(s0) / Double.parseDouble(s2));
                }
                else {
                    s0 = s2;
                }

                // Clean-up trailing ".0" if present
                s0 = cleanUpTrailingZero(s0);
                outputLabel.setText(s0);

                wasOperand = true;
                wasEquals = true;
                canBackspace = false;

                break;
            case "C":
                s0 = s1 = "";

            case "CE":
                s2 = "";
                outputLabel.setText(s2);

                wasOperand = false;
                wasEquals = false;
                canBackspace = false;

                break;
            case "BACK":
                if (!canBackspace) {
                    break;
                }

                if (s2.length() >= 1) {
                    s2 = s2.substring(0, s2.length() - 1);
                }
                outputLabel.setText(s2);
                break;
        }

        System.out.println("s0: " + s0);
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("wasOperand: " + wasOperand);
        System.out.println("wasEquals: " + wasEquals);
    }

    public static void main(String... args) {
        JFrame application = createGUI();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setVisible(true);
    }
}
