package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class JWindowListener implements WindowListener {
private JWindowForCalculator window;

    public JWindowListener(JWindowForCalculator window){
        this.window = window;
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {
        window.setExtendedState(JFrame.NORMAL);
        //window.setPreferredSize(new Dimension(300, 500));
        //window.setLocationRelativeTo(null);
    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
    }

}
