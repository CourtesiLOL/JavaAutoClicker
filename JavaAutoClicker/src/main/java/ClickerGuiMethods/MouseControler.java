package ClickerGuiMethods;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.SwingWorker;

public class MouseControler extends SwingWorker<Object, Object>{
	private int delayClick;
	private Robot mouse;
	private boolean mode = false;
	private boolean firtsExecution = false;
	
	public MouseControler(int delay) {
		
		try {
			this.delayClick = delay;
			this.mouse = new Robot();
			mouse.setAutoDelay(1);
		} catch (AWTException e) {
			System.out.println("Error: El mouse no se a podido crear");
		}
		
		
	}

	@Override
	protected Object doInBackground() throws Exception {
		while (mode) {
        	System.out.println("funciona");
            mouse.mousePress(java.awt.event.InputEvent.BUTTON1_MASK);
            mouse.mouseRelease(java.awt.event.InputEvent.BUTTON1_MASK);
            Thread.sleep(delayClick); // Espera el tiempo configurado
        }
		return null;
	}
	
	public void mouseClickOn() {
    	if(this.isDone() || !firtsExecution) {
    		mode = true;
            this.execute(); // Iniciar el SwingWorker
            
            if(!firtsExecution) {
            	firtsExecution = true;
            }
    	}else {
    		System.out.println("No a finalizado");
    	}
        
    }

    public void mouseClickOff() {
    	System.out.println("Off");
        mode = false;
    }

    public void SetDelay(int Miliseconds) {
        delayClick = Miliseconds;
    }
    public boolean InUse() {
    	return mode;
    }

}
