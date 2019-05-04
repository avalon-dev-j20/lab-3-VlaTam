package calculator;

import javax.swing.*;
import java.awt.*;

public abstract class ButtonBuilder {

    protected JButton button;

    public JButton getButton(){
        if (button != null)
            return button;

        return new JButton();
    }

    public void createNewButton(Character symbol){
        button = new JButton(symbol.toString());
    }

    public void setFont(JButton button, Font font){
        if (font == null)
            font = new Font("Arial", Font.BOLD, 25);
        button.setFont(font);
    }

    public abstract void setMnemonic(JButton button);
    public abstract void addListener(JButton button);

}
