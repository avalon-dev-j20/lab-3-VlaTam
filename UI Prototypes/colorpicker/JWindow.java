package colorpicker;

import javax.swing.*;
import java.awt.*;

public class JWindow extends JFrame {

    public JWindow(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 300));
        setTitle("Color Picker");
        setLayout(new GridLayout(1,2));
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}
