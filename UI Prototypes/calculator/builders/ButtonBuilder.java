package calculator.builders;

import calculator.listeners.*;
import javax.swing.*;
import java.awt.*;

public class ButtonBuilder {

    private final String digitSymbols = "0123456789";
    private final String operationSymbols = "+-*/";
    private final Character equalSymbol = '=';
    private final Character pointSymbol = '.';

    private Character symbol;
    private JButton button;

    public JButton createNewButton(Character symbol){
        initialize(symbol);
        customize();
        return button;
    }

    private void initialize(Character symbol){
        this.symbol = symbol;
        if (symbol == null || (!isDigit() & !isOperation() & !isPoint() & !isEqual())) {
            button = new JButton("CE");
            this.symbol = 'c';
        }
        else {
            button = new JButton(symbol.toString());
        }
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

    private void setFont(){
        Font font = new Font("Arial", Font.BOLD, 25);
        button.setFont(font);
    }

    private void setMnemonic(){
        if (isDigit()) {
            button.setMnemonic(0x30 + Integer.parseInt(symbol.toString()));
            return;
        }

        switch (symbol){
            case '+':{
                button.setMnemonic(0x050);  //назначена клавиша p (plus)
                break;
            }
            case '-':{
                button.setMnemonic(0x2D);
                break;
            }
            case '*':{
                button.setMnemonic(0x4D);   //назначена клавиша m (multiplication)
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
                button.setMnemonic(0x43);   //назначена клавиша c (clean)
        }
    }

    private void addListener(){
        if (isDigit()){
            button.addActionListener(new DigitListener(Integer.parseInt(symbol.toString())));
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

        if (isEqual()){
            button.addActionListener(new EqualOperationListener());
            return;
        }

        button.addActionListener(new CleanEntryListener());
    }

    private boolean isEqual(){
        return equalSymbol.equals(symbol);
    }

}
