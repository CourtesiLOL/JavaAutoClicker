package ClickerGUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClickerGuiMethods.MouseControler;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InitFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField delayInput;
	
	private MouseControler mouseEventClicker;
	private int delaySeted;


	public InitFrame() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
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
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(mouseEventClicker.InUse() == false) {
					mouseEventClicker.mouseClickOn();
				}
				
			}
		});
		startButton.setBounds(50, 132, 130, 40);
		contentPane.add(startButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseEventClicker.mouseClickOff();
				CreateMouseEvent(delaySeted);
				
			}
		});
		stopButton.setBounds(245, 132, 130, 40);
		contentPane.add(stopButton);
		
		JLabel lblNewLabel = new JLabel("Click Interval:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(50, 50, 100, 40);
		contentPane.add(lblNewLabel);
		
		delayInput = new JTextField();
		delayInput.setHorizontalAlignment(SwingConstants.RIGHT);
		delayInput.setText("1000");
		delayInput.setBackground(UIManager.getColor("Button.background"));
		delayInput.setBounds(130, 61, 50, 20);
		contentPane.add(delayInput);
		delayInput.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("milliseconds");
		lblNewLabel_1.setBounds(190, 64, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSetDelay = new JButton("Set");
		btnSetDelay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseEventClicker.SetDelay(Integer.parseInt(delayInput.getText()));
				delaySeted = Integer.parseInt(delayInput.getText());
				
			}
		});
		btnSetDelay.setBounds(299, 58, 58, 25);
		contentPane.add(btnSetDelay);
		
		
		delaySeted = Integer.parseInt(delayInput.getText());
		CreateMouseEvent(delaySeted);
		
	}
	
	private void CreateMouseEvent(int Midelay) {
		try {
			this.mouseEventClicker = new MouseControler(Midelay);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
