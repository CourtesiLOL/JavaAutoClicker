package ClickerGuiMethods;

import java.awt.AWTException;
import java.awt.Robot;

public class MouseOptions {
	private Robot mouse;
	
	public MouseOptions(int delay,int positionX,int positionY) throws AWTException{
		try {
			//Create and assign  the variable
			Robot mouse = new Robot();
			this.mouse = mouse;
			//Configure mouse parameters
			mouse.setAutoDelay(delay);
			mouse.mouseMove(positionX, positionY);
			
		}catch(AWTException ex) {
			throw new AWTException(null);
		}
	}
	
	public void mouseClickOn() {
		//Nothing at the moment
	}
	public void mouseClickOff() {
		//Nothing at the moment
	}
}
