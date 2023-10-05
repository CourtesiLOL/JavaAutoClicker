package ClickerGuiMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.SwingWorker;

public class MouseOptions {
	private Robot mouse;
	private boolean mode = false;
	private boolean firtsExecution = false;
	private SwingWorker<Void, Void> clickerWorker;

    public MouseOptions(int delay) throws AWTException {
        try {
            // Crear y asignar la variable
            this.mouse = new Robot();
            // Configurar parámetros del ratón
            mouse.setAutoDelay(delay);

            // Crear el SwingWorker personalizado
            clickerWorker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    while (mode) {
                    	System.out.println("funciona");
                        mouse.mousePress(java.awt.event.InputEvent.BUTTON1_MASK);
                        mouse.mouseRelease(java.awt.event.InputEvent.BUTTON1_MASK);
                        Thread.sleep(delay); // Espera el tiempo configurado
                    }
                    return null;
                }
            };
        } catch (AWTException ex) {
            throw new AWTException(null);
        }
    }

    public void mouseClickOn() {
    	if(clickerWorker.isDone() || !firtsExecution) {
    		mode = true;
            System.out.println("On");
            clickerWorker.execute(); // Iniciar el SwingWorker
            
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
        mouse.setAutoDelay(Miliseconds);
    }
    public boolean InUse() {
    	return mode;
    }

}