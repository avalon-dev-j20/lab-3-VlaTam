package calculator.listeners;

import static calculator.Calculator.resultLabel;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class EqualOperationListener implements ActionListener {

    private BigDecimal firstValue;
    private BigDecimal secondValue;
    private BigDecimal result;
    private String stringResult;
    private char mathOperation;
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (resultLabel.getText().matches("[\\d\\.\\-]+[\\+\\-\\*/][\\d\\.]+")){
            DigitListener.counterOfPressing = 0;

            defineValues();
            calculate();
            writeResult();
            copyToClipboard(stringResult);
        }
    }

    private void defineValues(){
        String expression = resultLabel.getText();
        firstValue = new BigDecimal(1.);
        if (expression.charAt(0) == '-') {
            expression = expression.substring(1, expression.length());
            firstValue = new BigDecimal(-1.);
        }

        mathOperation = expression.replaceAll("[^\\+\\-\\*/]", "").charAt(0);

        String[] values = expression.split("[\\+\\-\\*/]");
        firstValue = firstValue.multiply(new BigDecimal(values[0]));
        secondValue = new BigDecimal(values[1]);
    }

    private void calculate(){
        switch (mathOperation){
            case '+': {
                result = firstValue.add(secondValue);
                break;
            }
            case '-': {
                result = firstValue.subtract(secondValue);
                break;
            }
            case '*': {
                result = firstValue.multiply(secondValue);
                break;
            }
            default: {
                if (secondValue.equals(new BigDecimal(0.)))
                    result = new BigDecimal(0.);
                else
                    result = firstValue.divide(secondValue, 6, BigDecimal.ROUND_CEILING);
            }
        }
    }

    private void writeResult(){
        stringResult = result.toString();
        if (!stringResult.equals("0")) {
            stringResult = stringResult.replaceAll("0+$", "");
            stringResult = stringResult.replaceAll("\\.$", "");
        }

        resultLabel.setText(stringResult);
    }

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
    }
}
