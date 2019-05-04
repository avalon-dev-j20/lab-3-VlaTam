package calculator;

import calculator.builders.ButtonBuilder;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Calculator extends AbstractFrame {

    public static JLabel resultLabel = new JLabel("0");
    public static boolean operationIsComplete;  //Используется в слушателях, чтобы после получения промежуточного
                                                //результата новые вводимые цифры формировали новое число.
                                                //Промежуточный результат стирается

    private final List<JButton> buttons = new ArrayList<>(17);

    public Calculator(){
        super();
        addButtons();
        createInterface();

        pack();
    }

    private void addButtons(){
        ButtonBuilder buttonBuilder = new ButtonBuilder();

        for (int i = 0; i < 10; i++){
            JButton button = buttonBuilder.createNewButton((char)('0' + i));
            buttons.add(button);
        }
        buttons.add(buttonBuilder.createNewButton('+'));     //10
        buttons.add(buttonBuilder.createNewButton('-'));     //11
        buttons.add(buttonBuilder.createNewButton('*'));     //12
        buttons.add(buttonBuilder.createNewButton('/'));     //13
        buttons.add(buttonBuilder.createNewButton(null));    //14 button 'CE'
        buttons.add(buttonBuilder.createNewButton('.'));     //15
        buttons.add(buttonBuilder.createNewButton('='));     //16
    }

    private void createInterface(){
        resultLabel.setFont(new Font("Arial", Font.BOLD, 50));

        JPanel panelForResult = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelForResult.add(resultLabel);

        add(panelForResult, BorderLayout.PAGE_START);
        add(createPanelForAllButtons());
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

    public static void main(String[] args) {
        new Calculator();
    }
}
