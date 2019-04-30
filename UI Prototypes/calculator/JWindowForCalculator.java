package calculator;

import javax.swing.*;
import java.awt.*;

public class JWindowForCalculator extends JFrame {

    public JWindowForCalculator(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(300, 500));

        setTitle("Calculator");
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        addComponentListener(new ResizedListener(this));
        addWindowListener(new JWindowListener(this));
    }

}

