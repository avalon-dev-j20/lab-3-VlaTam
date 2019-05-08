package calculator.listeners;

import static calculator.Calculator.resultLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CleanEntryListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        resultLabel.setText("0");
    }
}
