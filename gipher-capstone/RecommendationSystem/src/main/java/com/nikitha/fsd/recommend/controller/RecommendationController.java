package com.nikitha.fsd.recommend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nikitha.fsd.recommend.model.GifModelToSave;
import com.nikitha.fsd.recommend.service.GifRecommendService;


@RestController
@CrossOrigin(origins="*")
public class RecommendationController {
	
	@Autowired
	GifRecommendService gifRecommendService;

	@RequestMapping(value="/api/v1/recommend/allgifs",method = RequestMethod.GET)	
	public ResponseEntity<List<GifModelToSave> >findAllGifs() 
	{	
		ResponseEntity<List<GifModelToSave>>responseEntity =null;	
		List<GifModelToSave> allRecommendGifs = new ArrayList();
		allRecommendGifs = gifRecommendService.getAllGifs();
    	if(allRecommendGifs!=null && !allRecommendGifs.isEmpty())
    	{
    
    		responseEntity = new ResponseEntity<List<GifModelToSave>>(allRecommendGifs,HttpStatus.FOUND);
    	}
    	else
    	{
    		responseEntity = new ResponseEntity<List<GifModelToSave>>(allRecommendGifs,HttpStatus.NOT_FOUND);
    	}

		return responseEntity;
	}
	

	@GetMapping("/api/v1/recommend/hello")
	public String testContoller() 
	{	
		return "hello recommendation service";
	}

}
