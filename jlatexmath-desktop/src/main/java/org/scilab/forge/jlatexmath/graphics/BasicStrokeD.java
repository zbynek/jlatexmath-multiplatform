package org.scilab.forge.jlatexmath.graphics;

import java.awt.BasicStroke;

public class BasicStrokeD extends BasicStroke implements
		org.scilab.forge.jlatexmath.platform.graphics.BasicStroke {

	public BasicStrokeD(BasicStroke basicStroke) {
		this(basicStroke.getLineWidth(), basicStroke.getEndCap(), basicStroke.getLineJoin(), basicStroke
				.getMiterLimit());
	}

	public BasicStrokeD(float width, int cap, int join, float miterlimit) {
		super(width, cap, join, miterlimit);
	}

}
