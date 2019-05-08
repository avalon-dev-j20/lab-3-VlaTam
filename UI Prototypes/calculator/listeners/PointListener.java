package calculator.listeners;

import calculator.Calculator;
import static calculator.Calculator.resultLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String expression = resultLabel.getText();
        if (expression.charAt(expression.length() - 1) == '.')
            return;
        if (expression.matches("[\\d\\-]+[\\+\\-\\*/]"))
            return;

        if (expression.charAt(0) == '-')
            expression = expression.substring(1, expression.length());

        String[] values = expression.split("[\\+\\-\\*/]");
        String checkingValue;
        if (values.length < 2)
            checkingValue = values[0];
        else
            checkingValue = values[1];

        if (!checkingValue.contains(".") && checkingValue.length() > 0)
            resultLabel.setText(resultLabel.getText() + ".");

        Calculator.operationIsComplete = false;
    }
}
