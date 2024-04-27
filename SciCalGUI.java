// GUI Scientific Calculator
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import java.text.DecimalFormat;
import java.math.*;

public class SciCalGUI {

    private JFrame frame;
    private JTextField display;
    private String currentInput = "";
    private boolean expectingOperation = true;
    private Stack<String> operations = new Stack<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SciCalGUI calculator = new SciCalGUI();
            calculator.createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        frame = new JFrame("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField(25);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);

        JPanel buttonPanel = createButtonPanel();

        frame.add(display, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 6, 5, 5));

        // Row 1: Scientific functions
        panel.add(createButton("sin"));
        panel.add(createButton("cos"));
        panel.add(createButton("tan"));
        panel.add(createButton("log"));
        panel.add(createButton("exp"));
        panel.add(createButton("sqrt"));

        // Row 2: Numbers and basic operations
        panel.add(createButton("7"));
        panel.add(createButton("8"));
        panel.add(createButton("9"));
        panel.add(createButton("/"));
        panel.add(createButton("("));
        panel.add(createButton(")"));

        // Row 3: Numbers and basic operations
        panel.add(createButton("4"));
        panel.add(createButton("5"));
        panel.add(createButton("6"));
        panel.add(createButton("*"));
        panel.add(createButton("C"));
        panel.add(createButton("CE"));

        // Row 4: Numbers and basic operations
        panel.add(createButton("1"));
        panel.add(createButton("2"));
        panel.add(createButton("3"));
        panel.add(createButton("-"));
        panel.add(createButton("="));
        panel.add(createButton("^"));

        // Row 5: Numbers and basic operations
        panel.add(createButton("0"));
        panel.add(createButton("."));
        panel.add(createButton("pi"));
        panel.add(createButton("+"));
        panel.add(createButton("e"));

        return panel;
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 18));

        // Event handler for button clicks
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonPress(label);
            }
        });

        return button;
    }

    private void handleButtonPress(String label) {
        switch (label) {
            case "C": // Clear display and stack
                currentInput = "";
                operations.clear();
                updateDisplay();
                break;
            case "CE": // Clear entry (last input)
                if (!currentInput.isEmpty()) {
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                }
                updateDisplay();
                break;
            case "=": // Calculate result
                try {
                    String result = evaluateExpression(currentInput);
                    currentInput = result;
                } catch (Exception ex) {
                    currentInput = "Error";
                }
                updateDisplay();
                break;
            case "pi":
                currentInput += String.valueOf(Math.PI);
                break;
            case "e":
                currentInput += String.valueOf(Math.E);
                break;
            default:
                currentInput += label; // Append the label to the current input
        }
        updateDisplay();
    }

    private void updateDisplay() {
        display.setText(currentInput);
    }

    private String evaluateExpression(String expression) {
        // Convert the infix expression to postfix and evaluate it
        String postfix = infixToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    private String infixToPostfix(String infix) {
        Stack<String> operators = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        String[] tokens = infix.split("((?<=\\D)|(?=\\D))");

        for (String token : tokens) {
            if (isOperator(token)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    postfix.append(operators.pop()).append(" ");
                }
                operators.push(token);
            } else {
                postfix.append(token).append(" ");
            }
        }

        while (!operators.isEmpty()) {
            postfix.append(operators.pop()).append(" ");
        }

        return postfix.toString();
    }

    private boolean isOperator(String token) {
        return "+-*/^".contains(token);
    }

    private int precedence(String operator) {
        switch (operator) {
            case "^":
                return 3;
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }

    private String evaluatePostfix(String postfix) {
        Stack<Double> values = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                double b = values.pop();
                double a = values.pop();
                values.push(applyOperator(a, b, token));
            } else {
                values.push(Double.parseDouble(token));
            }
        }

        return new DecimalFormat("#.####").format(values.pop());
    }

    private double applyOperator(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "^":
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}