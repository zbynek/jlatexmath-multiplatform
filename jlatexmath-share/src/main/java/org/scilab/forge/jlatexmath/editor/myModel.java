package org.scilab.forge.jlatexmath.editor;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.scilab.forge.jlatexmath.Atom;
import org.scilab.forge.jlatexmath.TeXEnvironment;
import org.scilab.forge.jlatexmath.TeXFormula;

public class myModel extends java.util.Observable
{
	TeXFormula formula = null;
	TreeEditor editor = null;
	String latex = null;
	ArrayList<Atom> rootSel = null; 
	
	public myModel()
	{
		latex = "x";
		formula = new TeXFormula(latex);
		editor = new TreeEditor();
		rootSel = new ArrayList<Atom>();
	}
	
	public void keyTyped(char c)
	{
		editor.keyTyped(formula,formula.getRoot(),c);
		Atom root = formula.getRoot();
		Atom selAtom = editor.getSelAtm();
		if(rootSel != null)
			rootSel.clear();
		rootSel.add(root);
		rootSel.add(selAtom);
		this.setChanged();
		this.notifyObservers(rootSel);
	}
	
	public void keyPressed(KeyEvent e)
	{
		editor.keyPressed(formula,e.getKeyCode(), e.isAltDown(), e.isControlDown());
		Atom root = formula.getRoot();
		Atom selAtom = editor.getSelAtm();
		if(rootSel != null)
			rootSel.clear();
		rootSel.add(root);
		rootSel.add(selAtom);
		this.setChanged();
		this.notifyObservers(rootSel);
	}
	
	public void formulaClicked(double x, double y, TeXEnvironment te)
	{
		editor.formulaClicked(x, y, te);
		Atom root = formula.getRoot();
		Atom selAtom = editor.getSelAtm();
		if(rootSel != null)
			rootSel.clear();
		rootSel.add(root);
		rootSel.add(selAtom);
		this.setChanged();
		this.notifyObservers(rootSel);
	}
	
	public void init()
	{
		editor.initFormula(formula);
		Atom root = formula.getRoot();
		Atom selAtom = formula.getRoot();
		if(rootSel != null)
			rootSel.clear();
		rootSel.add(root);
		rootSel.add(selAtom);
		this.setChanged();
		this.notifyObservers(rootSel);
	}
}
