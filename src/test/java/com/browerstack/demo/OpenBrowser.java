package com.browerstack.demo;

import java.awt.Desktop;
import java.net.URI;

public class OpenBrowser {
	public static void main(String[] args) throws Exception {
		Desktop desk = Desktop.getDesktop();

		// now we enter our URL that we want to open in our
		// default browser
		desk.browse(new URI("http://xyz.com"));
		//desk.
	}
}
