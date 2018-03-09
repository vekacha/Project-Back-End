package controllers;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.BlocchiTypeCCI;
import service.BlocchiServiceImpl;
import service.interfaces.IBlocchiService;

@RestController
public class BlocchiTypeCCIController {

	@Autowired
	IBlocchiService blocchiService= new BlocchiServiceImpl();
	
	@CrossOrigin
	@RequestMapping(path = "/setblocchi",method = RequestMethod.POST)
	public void insertBlocchiCC(@RequestBody BlocchiTypeCCI blocchiTypeCCI, HttpServletResponse response) throws IOException {
		
		blocchiService.insertBlocchiCC(blocchiTypeCCI);
		
		response.sendRedirect("http://localhost:8080/projekat/getblocchi");
	
	}
}
