package calculator;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ResizedListener implements ComponentListener {

    final int maxWidth = 600;
    final int maxHeight = 900;

    private JWindowForCalculator window;

    public ResizedListener(JWindowForCalculator window){
        this.window = window;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        /*int width = e.getComponent().getWidth();
        int height = e.getComponent().getHeight();
        int newWidth = width;
        int newHeight = height;
        if (width > maxWidth) {
            newWidth = maxWidth;
        }

        if (height > maxHeight) {
            newHeight = maxHeight;
        }

        if (newHeight != height || newWidth != width) {
            window.setSize(newWidth, newHeight);
            //window.pack();
        }*/
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}
