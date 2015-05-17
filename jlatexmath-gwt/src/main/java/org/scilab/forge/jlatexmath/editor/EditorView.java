package org.scilab.forge.jlatexmath.editor;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.scilab.forge.jlatexmath.Atom;
import org.scilab.forge.jlatexmath.Box;
import org.scilab.forge.jlatexmath.ColorUtil;
import org.scilab.forge.jlatexmath.DefaultTeXFont;
import org.scilab.forge.jlatexmath.SymbolAtom;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXEnvironment;
import org.scilab.forge.jlatexmath.geom.Rectangle2DW;
import org.scilab.forge.jlatexmath.graphics.ColorW;
import org.scilab.forge.jlatexmath.graphics.Graphics2DW;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.font.Font;
import org.scilab.forge.jlatexmath.platform.geom.Rectangle2D;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

public class EditorView implements ModelObserver{
	private Canvas canvas;
	
	
	Atom root = null;
	Atom selAtom  = null;
	private Box box = null;
	int size = 18;
	TeXEnvironment te = new TeXEnvironment(TeXConstants.STYLE_DISPLAY, new DefaultTeXFont(size));
	private Rectangle2D currentBox = FactoryProvider.INSTANCE.getGeomFactory().createRectangle2D(0,0,0,0);
	
	
	
	public EditorView(Element parent){
		SymbolAtom.NEEDS_CLONE = true;
		canvas = Canvas.createIfSupported();
		canvas.setCoordinateSpaceHeight(500);
		canvas.setCoordinateSpaceWidth(500);
		String latex = parent.getInnerText();
		//drawLatex(c.getContext2d(),latex, 16, Font.PLAIN, 0,0, ColorUtil.BLACK);
		parent.setInnerText("");
		canvas.setTabIndex(1);
		String tmpID = DOM.createUniqueId();
		parent.setId(tmpID);
		RootPanel.get(tmpID).add(canvas);
		canvas.setFocus(true);
		
	}
	@Override
	public void update(Atom root0, Atom sel0) {
		
		root = root0;
		selAtom = sel0;		
		box = root.createBox(te);		
		box.updateRectangle(size, (3/size), (3/size));
		currentBox = selAtom.getBox().getRectangle();
		doRepaint();
		
	}
	private void doRepaint() {
		//super.paintComponent(g);
	    Rectangle2D rect = new Rectangle2DW((int)currentBox.getX() + 178, (int)currentBox.getY() + 178, 
	    		(int)currentBox.getWidth() + 2, (int)currentBox.getHeight() + 2);
	    Graphics2DInterface g2 = new Graphics2DW(canvas.getContext2d());
	    g2.setColor(new ColorW(255,255,0));
	    g2.fillRect(0, 0, 500, 500);
	    /*if(g != saveg)
	    {
	    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	 	    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	 	    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	 	    saveg = g;
	    }*/
	    g2.setColor(new ColorW(255,0,0));
	    g2.saveTransformation();
	    g2.draw(rect);
	    g2.setColor(new ColorW(0,0,0));
		g2.scale(size, size); // the point size
		box.draw(g2, 10, 10);
		g2.restoreTransformation();
		
	}
	public void addKeyListener(EditorController editorController) {
		canvas.addKeyDownHandler(editorController);
		canvas.addKeyPressHandler(editorController);
		
	}

}
