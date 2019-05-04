package calculator.builders;

import calculator.listeners.CleanEntryListener;
import calculator.listeners.DigitListener;
import calculator.listeners.MathOperationListener;
import calculator.listeners.PointListener;

import javax.swing.*;
import java.awt.*;

public class ButtonBuilder {

    private final String digitSymbols = "0123456789";
    private final String operationSymbols = "+-*/=";
    private final Character pointSymbol = '.';

    private Character symbol;
    private JButton button;

    public ButtonBuilder(Character symbol){
        this.symbol = symbol;
        if (symbol == null || !isDigit() || !isOperation() || !isPoint()) {
            button = new JButton("CE");
            this.symbol = 'c';
        }
        else {
            button = new JButton(symbol.toString());
        }
        customize();
    }

    private boolean isDigit(){
        return digitSymbols.contains(symbol.toString());
    }

    private boolean isOperation(){
        return operationSymbols.contains(symbol.toString());
    }

    private boolean isPoint(){
        return pointSymbol.equals(symbol);
    }

    private void customize(){
        setFont();
        setMnemonic();
        addListener();
    }

    public JButton getButton(){
        if (button != null)
            return button;

        return new JButton();
    }

    private void setFont(){
        Font font = new Font("Arial", Font.BOLD, 25);
        button.setFont(font);
    }

    private void setMnemonic(){
        if (isDigit()) {
            button.setMnemonic(0x30 + symbol);
            return;
        }

        switch (symbol){
            case '+':{
                button.setMnemonic(0x050);
                break;
            }
            case '-':{
                button.setMnemonic(0x2D);
                break;
            }
            case '*':{
                button.setMnemonic(0x4D);
                break;
            }
            case '/':{
                button.setMnemonic(0x2F);
                break;
            }
            case '.':{
                button.setMnemonic(0x2E);
                break;
            }
            case '=':{
                button.setMnemonic(0x3D);
                break;
            }
            default:
                button.setMnemonic(0x43);
        }
    }

    private void addListener(){
        if (isDigit()){
            button.addActionListener(new DigitListener(symbol));
            return;
        }

        if (isOperation()){
            button.addActionListener(new MathOperationListener(symbol));
            return;
        }

        if (isPoint()){
            button.addActionListener(new PointListener());
            return;
        }

        button.addActionListener(new CleanEntryListener());
    }

}
