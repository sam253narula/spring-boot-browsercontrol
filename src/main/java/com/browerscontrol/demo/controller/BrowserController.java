package com.browerscontrol.demo.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.browerscontrol.demo.enums.Browsers;

@RestController
public class BrowserController {

	private static final String WIN_ID = "Windows";
	// The default system browser under windows.
	private static final String WIN_PATH = "rundll32";
	// The flag to display a url.
	private static final String WIN_FLAG = "url.dll,FileProtocolHandler";

	// This Will start specified browser with passed URL
	@GetMapping("/start")
	public String start(Browsers browser, String url) throws IOException {
		String cmd = null;
		if (browser == Browsers.CHROME) {
			//below cmd command starts the default browser in your Windows OS
			cmd = WIN_PATH + " " + WIN_FLAG + " " + url;
			Process p = Runtime.getRuntime().exec(cmd);
		} else if (browser == Browsers.FIREFOX) {
			// Below cmd command is used to start specific browser in your Windows OS
			cmd = "cmd /c start firefox " + url;
			Process p = Runtime.getRuntime().exec(cmd);
		}
		return "Brower started";
	}

	// terminates the open specified browser
	@GetMapping("/stop")
	public String stop(Browsers browser) throws IOException {
		// taskkill /F /IM chrome.exe /T
		/*
		 * taskkill /F /IM chrome* /T
		 * 
		 * {Explanation:
		 * 
		 * taskkill (to kill the processes),
		 * 
		 * /F (forcefully terminate the process),
		 * 
		 * /IM (Image Name of the process to be terminated. '*' wildcard can be sure to
		 * specify all the tasks or image names)
		 * 
		 * /T (Terminate all child of the image or process) )
		 */
		String cmd = null;
		if (browser == Browsers.CHROME) {
			cmd = "taskkill /F /IM chrome.exe /T";
			Process p = Runtime.getRuntime().exec(cmd);
		} else if (browser == Browsers.FIREFOX) {
			cmd = "taskkill /F /IM firefox.exe /T";
			Process p = Runtime.getRuntime().exec(cmd);
		}

		return "Brower stopped";
	}

	// TODO : Below 2 API are pending implementation
//	@GetMapping("/cleanup")
//	public void cleanup(String browser) {
//		if(browser.equalsIgnoreCase("firefox")) {
//			
//		}
//	}
//	
//	
//	@GetMapping("/geturl")
//	public void geturl(String browser) {
//			
//	}

}
