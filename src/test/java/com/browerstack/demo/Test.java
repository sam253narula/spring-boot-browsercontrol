package com.browerstack.demo;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Test {
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		Test test = new Test();
		test.testing();
	}
	// ...
	public void testing() throws IOException, URISyntaxException {
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			Desktop.getDesktop().browse(new URI("http://www.google.com"));
		}
	}
}
