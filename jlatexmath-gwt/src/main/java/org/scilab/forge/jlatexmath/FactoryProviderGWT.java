package org.scilab.forge.jlatexmath;

import org.scilab.forge.jlatexmath.font.FontFactoryGWT;
import org.scilab.forge.jlatexmath.geom.GeomFactoryGWT;
import org.scilab.forge.jlatexmath.graphics.GraphicsFactoryGWT;
import org.scilab.forge.jlatexmath.parser.ParserFactoryGWT;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.font.FontFactory;
import org.scilab.forge.jlatexmath.platform.geom.GeomFactory;
import org.scilab.forge.jlatexmath.platform.graphics.GraphicsFactory;
import org.scilab.forge.jlatexmath.platform.parser.ParserFactory;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoaderFactory;
import org.scilab.forge.jlatexmath.resources.ResourceLoaderFactoryGWT;

public class FactoryProviderGWT extends FactoryProvider {

	@Override
	protected GeomFactory createGeomFactory() {
		return new GeomFactoryGWT();
	}

	@Override
	protected FontFactory createFontFactory() {
		return new FontFactoryGWT();
	}

	@Override
	protected GraphicsFactory createGraphicsFactory() {
		return new GraphicsFactoryGWT();
	}

	@Override
	protected ParserFactory createParserFactory() {
		return new ParserFactoryGWT();
	}

	@Override
	protected ResourceLoaderFactory createResourceLoaderFactory() {
		return new ResourceLoaderFactoryGWT();
	}

}
