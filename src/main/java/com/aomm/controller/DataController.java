package com.aomm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aomm.entity.StockEntity;
import com.aomm.service.DataRetrieveService;

@Controller
public class DataController {
	
	@Autowired
	DataRetrieveService dataRetrieveService;
	
	@RequestMapping( value = { "/","","/home" }, method = RequestMethod.GET )
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        model.setViewName( "/Default.vm" );
        return model;
    }
	
	
	@RequestMapping( value = {"/stock" }, method = RequestMethod.GET )
    public ModelAndView stock() {
        ModelAndView model = new ModelAndView();
        model.setViewName( "/stock.vm" );
        return model;
    }
	
	@RequestMapping( value = {"/sale" }, method = RequestMethod.GET )
    public ModelAndView sale() {
        ModelAndView model = new ModelAndView();
        model.setViewName( "/sale.vm" );
        return model;
    }
	
	@ResponseBody
	@RequestMapping( value = "/getStocks", method = RequestMethod.GET )
	public DataTablesOutput< StockEntity > getStocks( @Valid DataTablesInput input ){
		return dataRetrieveService.getStocks( input );
	}

}
