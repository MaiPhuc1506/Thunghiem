package Haha;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class OK extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OK frame = new OK();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OK() {
		setTitle("Nhập tên của bạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 150);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		// Tạo các thành phần giao diện người dùng
		JPanel panel = new JPanel();
		JTextField nameField = new JTextField(10);
		JButton submitButton = new JButton("Chào!");
		JLabel messageLabel = new JLabel(" ");

		panel.add(new JLabel("Tên bạn là:"));
		panel.add(nameField);
		panel.add(submitButton);
		panel.add(messageLabel);

		contentPane.add(panel, BorderLayout.CENTER);

		// Sự kiện nút
		submitButton.addActionListener(e -> {
			String name = nameField.getText().trim();
			if (!name.isEmpty()) {
				messageLabel.setText("Xin chào, " + name + "!");
			} else {
				messageLabel.setText("Vui lòng nhập tên.");
			}
		});
	}
}
