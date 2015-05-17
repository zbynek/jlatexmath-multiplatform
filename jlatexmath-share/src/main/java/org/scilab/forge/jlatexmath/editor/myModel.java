package org.scilab.forge.jlatexmath.editor;

import java.util.Vector;

import org.scilab.forge.jlatexmath.Atom;
import org.scilab.forge.jlatexmath.TeXEnvironment;
import org.scilab.forge.jlatexmath.TeXFormula;

public class myModel 
{
	TeXFormula formula = null;
	TreeEditor editor = null;
	String latex = null;
	private boolean changed = false;
    private Vector<ModelObserver> obs;
	
	public myModel()
	{
		latex = "x";
		formula = new TeXFormula(latex);
		editor = new TreeEditor();
		obs = new Vector<ModelObserver>();
	}
	
	public void keyTyped(char c)
	{
		editor.keyTyped(formula,formula.getRoot(),c);
		Atom root = formula.getRoot();
		Atom selAtom = editor.getSelAtm();
		this.notifyObservers(root, selAtom);
	}
	
	public void keyPressed(int keyCode, boolean altDown, boolean ctrlDown)
	{
		editor.keyPressed(formula,keyCode, altDown, ctrlDown);
		Atom root = formula.getRoot();
		Atom selAtom = editor.getSelAtm();
		this.notifyObservers(root, selAtom);
	}
	
	public void formulaClicked(double x, double y, TeXEnvironment te)
	{
		editor.formulaClicked(x, y, te);
		Atom root = formula.getRoot();
		Atom selAtom = editor.getSelAtm();
		this.notifyObservers(root, selAtom);
	}
	
	public void init()
	{
		editor.initFormula(formula);
		Atom root = formula.getRoot();
		Atom selAtom = formula.getRoot();
		this.notifyObservers(root, selAtom);
	}
	
	   /**
     * Adds an observer to the set of observers for this object, provided
     * that it is not the same as some observer already in the set.
     * The order in which notifications will be delivered to multiple
     * observers is not specified. See the class comment.
     *
     * @param   o   an observer to be added.
     * @throws NullPointerException   if the parameter o is null.
     */
    public synchronized void addObserver(ModelObserver o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    public void notifyObservers(Atom a,Atom b) {
    	changed = true;
        /*
         * a temporary array buffer, used as a snapshot of the state of
         * current Observers.
         */
        Object[] arrLocal;

        synchronized (this) {
            /* We don't want the Observer doing callbacks into
             * arbitrary code while holding its own Monitor.
             * The code where we extract each Observable from
             * the Vector and store the state of the Observer
             * needs synchronization, but notifying observers
             * does not (should not).  The worst result of any
             * potential race-condition here is that:
             * 1) a newly-added Observer will miss a
             *   notification in progress
             * 2) a recently unregistered Observer will be
             *   wrongly notified when it doesn't care
             */
            if (!changed)
                return;
            arrLocal = obs.toArray();
            changed = false;
        }

        for (int i = arrLocal.length-1; i>=0; i--)
            ((ModelObserver)arrLocal[i]).update(a,b);
    }

}
