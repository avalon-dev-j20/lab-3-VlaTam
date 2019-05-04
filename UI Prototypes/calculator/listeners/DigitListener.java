package calculator.listeners;

import static calculator.Calculator.resultLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitListener implements ActionListener {

    public static int counterOfPressing = 0;
    private int digit;

    public DigitListener(int digit){
        this.digit = digit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (++counterOfPressing > 10)
            return;
        if (digit == 0 && resultLabel.getText().equals("0"))
            return;

        if (resultLabel.getText().equals("0"))
            resultLabel.setText("");

        resultLabel.setText(resultLabel.getText() + digit);
    }
}
