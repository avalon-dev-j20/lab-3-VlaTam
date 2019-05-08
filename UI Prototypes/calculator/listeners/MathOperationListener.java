package calculator.listeners;

import calculator.Calculator;

import static calculator.Calculator.resultLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathOperationListener implements ActionListener {

    private Character mathSign;

    public MathOperationListener(Character mathSign){
        this.mathSign = mathSign;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String expression = resultLabel.getText();
        if (expression.charAt(0) == '-')
            expression = expression.substring(1, expression.length());
        expression = expression.replaceAll("[^\\+\\-\\*/]", "");
        if (expression.length() > 0)
            return;

        resultLabel.setText(resultLabel.getText() + mathSign.toString());
        Calculator.operationIsComplete = false;
    }
}
