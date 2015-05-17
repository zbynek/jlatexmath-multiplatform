package org.scilab.forge.jlatexmath.editor;

import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;


public class EditorController implements KeyDownHandler, KeyPressHandler{
	private myModel model;
	private EditorView view;
	
	public EditorController(EditorView view){
		this.view = view;
		model = new myModel();
		model.addObserver(view);
		model.init();
		view.addKeyListener(this);
	}

	@Override
	public void onKeyDown(KeyDownEvent event) {
		log(event.getNativeKeyCode()+" DOWN");
		if(event.getNativeKeyCode() == 8){
			event.preventDefault();
		}
		model.keyPressed(event.getNativeKeyCode(), event.isAltKeyDown(), event.isControlKeyDown());
		
		
	}

	public static native void log(String string) /*-{
		$wnd.console.log(string);		
	}-*/;

	@Override
	public void onKeyPress(KeyPressEvent event) {
		log(event.getCharCode()+" PRESS");
		event.preventDefault();
		model.keyTyped(event.getCharCode());
		
	}
}
