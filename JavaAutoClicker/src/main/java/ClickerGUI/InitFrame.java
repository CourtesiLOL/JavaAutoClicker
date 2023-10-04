package ClickerGUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class InitFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;


	public InitFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton hotkeyButton = new JButton("Hotkey");
		hotkeyButton.setBounds(50, 183, 130, 40);
		contentPane.add(hotkeyButton);
		
		JButton recordingButton = new JButton("New button");
		recordingButton.setBounds(245, 183, 130, 40);
		contentPane.add(recordingButton);
		
		JButton startButton = new JButton("Start");
		startButton.setBounds(50, 132, 130, 40);
		contentPane.add(startButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.setBounds(245, 132, 130, 40);
		contentPane.add(stopButton);
		
		JLabel lblNewLabel = new JLabel("Click Interval:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(50, 50, 100, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("100");
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setBounds(130, 61, 50, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("milliseconds");
		lblNewLabel_1.setBounds(190, 64, 80, 14);
		contentPane.add(lblNewLabel_1);
	}
}
