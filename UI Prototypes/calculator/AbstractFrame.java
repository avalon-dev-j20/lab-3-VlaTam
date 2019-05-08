package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AbstractFrame extends JFrame {

    private final int minWidth = 390;
    private final int minHeight = 540;
    private final int maxWidth = 585;
    private final int maxHeight = 810;

    AbstractFrame(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(minWidth, minHeight));
        setMaximumSize(new Dimension(maxWidth, maxHeight)); //Не работает для Windows
        getRootPane().setBorder(BorderFactory.createEmptyBorder(15, 15, 15,15));

        setTitle("Calculator");
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        addComponentListener(new EventHandler());
    }

    private class EventHandler extends ComponentAdapter{

        @Override
        public void componentResized(ComponentEvent e) {
            int width = e.getComponent().getWidth();
            int height = e.getComponent().getHeight();

            if (width > maxWidth)
                width = maxWidth;

            if (height > maxHeight)
                height = maxHeight;

            setSize(width, height);
        }
    }

}

