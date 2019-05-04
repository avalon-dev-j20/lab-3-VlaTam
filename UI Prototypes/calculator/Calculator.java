package calculator;

import calculator.listeners.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Calculator extends AbstractFrame {

    public static JLabel resultLabel = new JLabel("0");
    private final List<JButton> buttons = new ArrayList<>(17);

    public Calculator(){
        super();
        addButtons();
        createInterface();
        addListeners();
        setMnemonic();

        pack();
    }

    private void addButtons(){
        for (int i = 0; i < 10; i++)
            buttons.add(new JButton("" + i));
        buttons.add(new JButton("" + "+"));     //10
        buttons.add(new JButton("" + "-"));     //11
        buttons.add(new JButton("" + "*"));     //12
        buttons.add(new JButton("" + "/"));     //13
        buttons.add(new JButton("" + "CE"));    //14
        buttons.add(new JButton("" + "."));     //15
        buttons.add(new JButton("" + "="));     //16
    }

    private void createInterface(){
        setFont();

        JPanel panelForResult = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelForResult.add(resultLabel);

        add(panelForResult, BorderLayout.PAGE_START);
        add(createPanelForAllButtons());
    }

    private void setFont(){
        Font font = new Font("Arial", Font.BOLD, 50);
        resultLabel.setFont(font);

        font = new Font("Arial", Font.BOLD, 25);
        for (JButton button : buttons)
            button.setFont(font);
    }

    private JPanel createPanelForAllButtons(){
        JPanel panelForAllButtons = new JPanel();
        panelForAllButtons.setLayout(new BoxLayout(panelForAllButtons, BoxLayout.Y_AXIS));
        panelForAllButtons.add(createFirstPanelForButtons());
        panelForAllButtons.add(Box.createRigidArea(new Dimension(0, 15)));
        panelForAllButtons.add(createSecondPanelForButtons());
        panelForAllButtons.add(Box.createRigidArea(new Dimension(0, 15)));
        panelForAllButtons.add(createThirdPanelForButtons());
        panelForAllButtons.add(Box.createRigidArea(new Dimension(0, 15)));
        panelForAllButtons.add(createFourthPanelForButtons());
        panelForAllButtons.add(Box.createRigidArea(new Dimension(0, 15)));
        panelForAllButtons.add(createPanelForEqualSign());
        return panelForAllButtons;
    }

    private JPanel createFirstPanelForButtons(){
        JPanel firstPanelForButtons = new JPanel(new GridLayout(1, 4, 15, 0));
        firstPanelForButtons.setPreferredSize(new Dimension(360, 75));

        for (int i = 7; i < 11; i++)
            firstPanelForButtons.add(buttons.get(i));

        return firstPanelForButtons;
    }

    private JPanel createSecondPanelForButtons(){
        JPanel secondPanelForButtons = new JPanel(new GridLayout(1, 4, 15, 0));
        secondPanelForButtons.setPreferredSize(new Dimension(360, 75));

        for (int i = 4; i < 7; i++)
            secondPanelForButtons.add(buttons.get(i));
        secondPanelForButtons.add(buttons.get(11));

        return secondPanelForButtons;
    }

    private JPanel createThirdPanelForButtons(){
        JPanel thirdPanelForButtons = new JPanel(new GridLayout(1, 4, 15, 0));
        thirdPanelForButtons.setPreferredSize(new Dimension(360, 75));

        for (int i = 1; i < 4; i++)
            thirdPanelForButtons.add(buttons.get(i));
        thirdPanelForButtons.add(buttons.get(12));

        return thirdPanelForButtons;
    }

    private JPanel createFourthPanelForButtons(){
        JPanel fourthPanelForButtons = new JPanel(new GridLayout(1, 4, 15, 0));
        fourthPanelForButtons.setPreferredSize(new Dimension(360, 75));

        fourthPanelForButtons.add(buttons.get(14));
        fourthPanelForButtons.add(buttons.get(0));
        fourthPanelForButtons.add(buttons.get(15));
        fourthPanelForButtons.add(buttons.get(13));

        return fourthPanelForButtons;
    }

    private JPanel createPanelForEqualSign(){
        JPanel panelForEqualSign = new JPanel(new GridLayout(1, 1));
        panelForEqualSign.setPreferredSize(new Dimension(360, 75));
        panelForEqualSign.setBackground(Color.GREEN);
        panelForEqualSign.add(buttons.get(16));
        return panelForEqualSign;
    }

    private void addListeners(){
        for (int i = 0; i < 10; i++)
            buttons.get(i).addActionListener(new DigitListener(i));

        String[] mathSigns = {"+", "-", "*", "/"};
        for (int i = 10; i < 14; i++)
            buttons.get(i).addActionListener(new MathOperationListener(mathSigns[i - 10]));

        buttons.get(14).addActionListener(new CleanEntryListener());
        buttons.get(15).addActionListener(new PointListener());
        buttons.get(16).addActionListener(new EqualOperationListener());
    }

    private void setMnemonic(){
        for (int i = 0x0; i < 0x10; i++)
            buttons.get(i).setMnemonic(0x30 + i);
        buttons.get(10).setMnemonic(0x050);//0x0209
        buttons.get(11).setMnemonic(0x2D);
        buttons.get(12).setMnemonic(0x4D);
        buttons.get(13).setMnemonic(0x2F);
        buttons.get(14).setMnemonic(0x43);
        buttons.get(15).setMnemonic(0x2E);
        buttons.get(16).setMnemonic(0x3D);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
