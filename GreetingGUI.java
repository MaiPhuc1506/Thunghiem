import javax.swing.*;

public class GreetingGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Greeting GUI");
        JLabel label = new JLabel("Xin chào bạn!", SwingConstants.CENTER);

        frame.add(label);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}