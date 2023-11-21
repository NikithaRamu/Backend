package com.nikitha.fsd.recommend.service;
import java.util.List;
import com.nikitha.fsd.recommend.model.GifModelToSave;



public interface GifRecommendService  {

	List<GifModelToSave> getAllGifs(); 
	GifModelToSave findGifById(String gifId);
	Boolean saveGif(GifModelToSave gif);
	

}
