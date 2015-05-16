package org.scilab.forge.jlatexmath;

import java.util.ArrayList;

import org.scilab.forge.jlatexmath.editor.TreeEditor;

public class TrigoAtom extends Atom
{
	private Atom treeParent = null;
	ArrayList<Atom> children = new ArrayList<Atom>();
	
	private Atom parent = null;
	private Atom nextSibling = null;
	private Atom prevSibling = null;
	private Atom subExpr = null;
	
	protected TypedAtom typed= null;
	protected FencedAtom fenced = null;
	
	public TrigoAtom(TypedAtom typed, FencedAtom fenced)
	{
		this.typed = typed;
		this.fenced = fenced;
	}


	@Override
	public Box createBox(TeXEnvironment env)
	{
		TreeEditor.addAtoms(this);
		this.setTreeRelation();
		Box a = typed.createBox(env);
		Box b = fenced.createBox(env);
		HorizontalBox hBox = new HorizontalBox(env.getColor(), env.getBackground());
		hBox.add(a);
		hBox.add(b);
		
		usedBox = hBox;
		return hBox;
	}

	public void setTreeRelation()
	{
		typed.setTreeParent(this);
		fenced.setTreeParent(this);
		if(children != null)
    		children.clear();
		children.add(typed);
		children.add(fenced);
	}
	
	
	
	public Atom getNextSibling(Atom at){
		if(at == fenced){
			return getTreeParent() == null ? this : getTreeParent().getNextSibling(this);
		}
		return fenced.getNextSibling(null);
	}
	
	public Atom getPrevSibling(Atom at){
		if(at == fenced){
			return getTreeParent() == null ? this : getTreeParent().getPrevSibling(this);
		}
		return fenced.getPrevSibling(null);
	}
	
	

}
