package calculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Calculator extends JWindowForCalculator {

    private JLabel resultLabel = new JLabel("0");
    private JButton zeroButton = new JButton("0");
    private JButton oneButton = new JButton("1");
    private JButton twoButton = new JButton("2");
    private JButton threeButton = new JButton("3");
    private JButton fourButton = new JButton("4");
    private JButton fiveButton = new JButton("5");
    private JButton sixButton = new JButton("6");
    private JButton sevenButton = new JButton("7");
    private JButton eightButton = new JButton("8");
    private JButton nineButton = new JButton("9");
    private JButton ceButton = new JButton("CE");
    private JButton pointButton = new JButton(".");
    private JButton plusButton = new JButton("+");
    private JButton minusButton = new JButton("-");
    private JButton multiplicationButton = new JButton("*");
    private JButton divisionButton = new JButton("/");
    private JButton equalButton = new JButton("=");


    public Calculator(){
        super();
        setFont();

        JPanel panelForResult = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelForResult.add(resultLabel);
        add(panelForResult, BorderLayout.PAGE_START);

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
        add(rootPanel);

        JPanel panelForButtons = new JPanel(new GridLayout(4, 4, 15, 15));
        panelForButtons.setPreferredSize(new Dimension(360, 360));
        panelForButtons.setBackground(Color.red);
        Border panelForButtonsBorder = BorderFactory.createEmptyBorder(0, 0, 15,0);
        panelForButtons.setBorder(panelForButtonsBorder);

        panelForButtons.add(sevenButton);
        panelForButtons.add(eightButton);
        panelForButtons.add(nineButton);
        panelForButtons.add(plusButton);
        panelForButtons.add(fourButton);
        panelForButtons.add(fiveButton);
        panelForButtons.add(sixButton);
        panelForButtons.add(minusButton);
        panelForButtons.add(oneButton);
        panelForButtons.add(twoButton);
        panelForButtons.add(threeButton);
        panelForButtons.add(multiplicationButton);
        panelForButtons.add(ceButton);
        panelForButtons.add(zeroButton);
        panelForButtons.add(pointButton);
        panelForButtons.add(divisionButton);
        rootPanel.add(panelForButtons);

        JPanel panelForEqualSign = new JPanel(new GridLayout(1, 1));
        panelForEqualSign.setPreferredSize(new Dimension(360, 75));
        panelForEqualSign.setBackground(Color.GREEN);

        panelForEqualSign.add(equalButton);
        rootPanel.add(panelForEqualSign);

        pack();
    }

    private void setFont(){
        Font font = new Font("Arial", Font.BOLD, 50);
        resultLabel.setFont(font);

        font = new Font("Arial", Font.BOLD, 25);
        sevenButton.setFont(font);
        eightButton.setFont(font);
        nineButton.setFont(font);
        plusButton.setFont(font);
        fourButton.setFont(font);
        fiveButton.setFont(font);
        sixButton.setFont(font);
        minusButton.setFont(font);
        oneButton.setFont(font);
        twoButton.setFont(font);
        threeButton.setFont(font);
        multiplicationButton.setFont(font);
        ceButton.setFont(font);
        zeroButton.setFont(font);
        pointButton.setFont(font);
        divisionButton.setFont(font);
        equalButton.setFont(font);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
