package org.scilab.forge.jlatexmath.graphics;

import org.scilab.forge.jlatexmath.platform.graphics.Color;

import com.google.gwt.canvas.dom.client.CssColor;

public class ColorW implements Color {

	private CssColor cssColor;

	public ColorW(int r, int g, int b) {
		cssColor = CssColor.make(r, g, b);
	}

	public ColorW(String cssColorString) {
		cssColor = CssColor.make(cssColorString);
	}

	public ColorW(CssColor cssColor) {
		this.cssColor = cssColor;
	}

	public CssColor getCssColor() {
		return cssColor;
	}

	@Override
	@Deprecated
	public int getColor() {
		return 0; // unused
	}

}
