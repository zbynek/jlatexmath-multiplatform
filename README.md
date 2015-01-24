JLaTeXMath Multiplatform
===================

This project is a fork of the original JLaTeXMath (http://forge.scilab.org/index.php/p/jlatexmath/), refactored to be used through different platforms, such as desktop, android and web (using GWT).

Usage
-------------------

Before using the API, set the platform dependent factory instance.
** Android **
	FactoryProvider.INSTANCE = new FactoryProviderAndroid(getAssets());

** Desktop **
	FactoryProvider.INSTANCE = new FactoryProviderDesktop();

** GWT **
Coming soon...

For details of the original API please see http://forge.scilab.org/index.php/p/jlatexmath/.