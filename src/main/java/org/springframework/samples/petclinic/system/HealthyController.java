package org.springframework.samples.petclinic.system;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthyController {
	
	@GetMapping("/healthy")
	public String healthy(ModelMap model) throws UnknownHostException{
		
		String ip = InetAddress.getLocalHost().getHostAddress();
		model.put("ststus", "OK (" + ip + ")" );
		
		return "healthy";
	}
	
}
