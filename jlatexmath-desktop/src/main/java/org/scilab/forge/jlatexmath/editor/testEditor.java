package org.scilab.forge.jlatexmath.editor;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.scilab.forge.jlatexmath.FactoryProviderDesktop;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;

public class testEditor {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		FactoryProvider.INSTANCE = new FactoryProviderDesktop();
		JFrame frame = new JFrame();
	    frame.setTitle("");
	    frame.setSize(500, 100);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    Container contentPane = frame.getContentPane();
	    myController control = new myController();
	    contentPane.add(control.view.panel);
	 
	    frame.setVisible(true);
	}

}
