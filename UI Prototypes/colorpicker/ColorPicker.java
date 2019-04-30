package colorpicker;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Dictionary;
import java.util.Hashtable;

public class ColorPicker extends JWindow {

    private final JPanel canvas = new JPanel();
    private final JSlider redColorSlider, greenColorSlider, blueColorSlider;
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    private String hexNumberOfColor;

    public ColorPicker(){
        super();
        JPanel controlColorsPanel = createControlColorsPanel();

        redColorSlider = createSlider();
        greenColorSlider = createSlider();
        blueColorSlider = createSlider();

        JPanel panelForRedColor = createColorControlPanel("Red", redColorSlider);
        JPanel panelForGreenColor = createColorControlPanel("Green", greenColorSlider);
        JPanel panelForBlueColor = createColorControlPanel("Blue", blueColorSlider);

        controlColorsPanel.add(panelForRedColor);
        controlColorsPanel.add(panelForGreenColor);
        controlColorsPanel.add(panelForBlueColor);

        add(createPanelForCanvas());

        pack();
    }

    private JPanel createPanelForCanvas(){
        JPanel panelForCanvas = new JPanel(new BorderLayout());
        //panelForCanvas.setBackground(Color.RED);

        Border canvasBorder = BorderFactory.createEmptyBorder(10, 10, 10,0);
        panelForCanvas.setBorder(canvasBorder);

        //canvas.setBackground(Color.BLUE);
        hexNumberOfColor = getHexOfDefaultColor();
        canvas.setToolTipText("#" + hexNumberOfColor);
        canvas.setBackground(getDefaultColor());
        panelForCanvas.add(canvas);

        return panelForCanvas;
    }

    private String getHexOfDefaultColor(){
        Color color = getDefaultColor();
        return Integer.toHexString(color.getRGB());
    }

    private Color getDefaultColor(){
        return new Color(redColorSlider.getValue(), greenColorSlider.getValue(), blueColorSlider.getValue());
    }

    private JPanel createControlColorsPanel(){
        JPanel controlColorsPanel = new JPanel();
        LayoutManager boxLayout = new BoxLayout(controlColorsPanel, BoxLayout.Y_AXIS);
        controlColorsPanel.setLayout(boxLayout);

        Border controlBorder = BorderFactory.createEmptyBorder(20, 10, 10,10);
        controlColorsPanel.setBorder(controlBorder);

        //controlColorsPanel.setBackground(Color.GREEN);
        controlColorsPanel.setPreferredSize(new Dimension(300, 300));
        add(controlColorsPanel, BorderLayout.LINE_END);

        return controlColorsPanel;
    }

    private JPanel createColorControlPanel(String color, JSlider slider){
        JPanel colorControlPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        colorControlPanel.add(new JLabel(color + ":"));
        colorControlPanel.add(slider);

        return colorControlPanel;
    }

    private JSlider createSlider(){
        JSlider slider = new JSlider(0, 255, 125);
        slider.setMinorTickSpacing(17);
        slider.setPaintTicks(true);

        Dictionary<Integer, JLabel> limits = new Hashtable<>();
        limits.put(0, new JLabel("0"));
        limits.put(255, new JLabel("255"));

        slider.setLabelTable(limits);
        slider.setPaintLabels(true);

        slider.addChangeListener(this::stateChangedColor);
        return slider;
    }

    public void stateChangedColor(ChangeEvent e){
        Color color = new Color(redColorSlider.getValue(), greenColorSlider.getValue(), blueColorSlider.getValue());
        canvas.setBackground(color);

        hexNumberOfColor = Integer.toHexString(color.getRGB());
        copyToClipboard(hexNumberOfColor);
        canvas.setToolTipText("#" + hexNumberOfColor);
    }

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
    }

    public static void main(String[] args) {
        new ColorPicker();
    }

}
