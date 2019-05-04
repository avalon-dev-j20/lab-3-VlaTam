package calculator.builders;

import calculator.listeners.DigitListener;

import javax.swing.*;

public class DigitButtonBuilder extends ButtonBuilder {

    private final String symbols = "0123456789";

    @Override
    public void setMnemonic(JButton button) {
        if (defineSymbol(button))
            button.setMnemonic(0x30 + Integer.parseInt(button.getText()));
    }

    private boolean defineSymbol(JButton button){
        String symbolOfButton = button.getText();
        return symbols.contains(symbolOfButton);
    }

    @Override
    public void addListener(JButton button) {
        if (defineSymbol(button))
            button.addActionListener(new DigitListener());
    }

}
