package workflow.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import workflow.service.ExcelService;

@Controller
public class WebController {
	
	@Autowired
	ExcelService excelserv;
	
	@RequestMapping("/")
	public String main(Model model) {
		
		return "site.wfe.main";
	}
	
	@RequestMapping("/import")
	public String importExcel(Model model) {
		
		System.out.println("import excel file");
		
		try {
			excelserv.importXLSX("test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("io exception");
		}
		
		return "site.wfe.import";
	}
	
	@RequestMapping("/export")
	public String exportExcel(Model model) {
		return "site.wfe.export";
	}
}

