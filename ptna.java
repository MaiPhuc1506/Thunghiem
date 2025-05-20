package GG;

import javax.swing.*;
import java.awt.event.*;

public class ptna {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tính tổng 2 số");
        JTextField aField = new JTextField(5);
        JTextField bField = new JTextField(5);
        JButton sumButton = new JButton("Tính tổng");
        JLabel resultLabel = new JLabel("Kết quả: ");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Số a:"));
        panel.add(aField);
        panel.add(new JLabel("Số b:"));
        panel.add(bField);
        panel.add(sumButton);
        panel.add(resultLabel);

        sumButton.addActionListener(e -> {
            try {
                int a = Integer.parseInt(aField.getText());
                int b = Integer.parseInt(bField.getText());
                resultLabel.setText("Kết quả: " + (a + b));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Vui lòng nhập số hợp lệ.");
            }
        });

        frame.add(panel);
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
