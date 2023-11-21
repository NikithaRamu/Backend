package com.nikitha.fsd.recommend.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GifModelToSave {

	@Id
	private String gifId;
	private String gifURL;
	private int numberOfTimeBookmarked;
	
	
	
	public GifModelToSave(String gifId, String gifURL, int numberOfTimeBookmarked) {

		this.gifId = gifId;
		this.gifURL = gifURL;
		this.numberOfTimeBookmarked = numberOfTimeBookmarked;
		
	}


	public GifModelToSave() {
		
	}


	public String getGifId() {
		return gifId;
	}


	public void setGifId(String gifId) {
		this.gifId = gifId;
	}


	public String getGifURL() {
		return gifURL;
	}


	public void setGifURL(String gifURL) {
		this.gifURL = gifURL;
	}


	public int getNumberOfTimeBookmarked() {
		return numberOfTimeBookmarked;
	}


	public void setNumberOfTimeBookmarked(int numberOfTimeBookmarked) {
		this.numberOfTimeBookmarked = numberOfTimeBookmarked;
	}


	@Override
	public String toString() {
		return "GifModelToSave [gifId=" + gifId + ", gifURL=" + gifURL + ", numberOfTimeBookmarked="
				+ numberOfTimeBookmarked + "]";
	}

}
