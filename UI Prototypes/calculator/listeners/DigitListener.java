package calculator.listeners;

import calculator.Calculator;
import static calculator.Calculator.resultLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitListener implements ActionListener {

    private int digit;

    public DigitListener(int digit){
        this.digit = digit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isMaxLengthOfValue())
            return;

        if (digit == 0 && resultLabel.getText().equals("0"))
            return;

        if (resultLabel.getText().equals("0") || Calculator.operationIsComplete) {
            resultLabel.setText("");
            Calculator.operationIsComplete = false;
        }

        resultLabel.setText(resultLabel.getText() + digit);
    }

    // Метод для контроля длины каждого числа, не более 9-ти символов, включая точку
    private boolean isMaxLengthOfValue(){
        String expression = resultLabel.getText();

        if (expression.matches("[\\d\\.]+"))
            return expression.length() > 8;
        else
            return expression.replaceFirst("[\\d\\.]+[\\+\\-\\*/]", "").length() > 8;
    }
}
