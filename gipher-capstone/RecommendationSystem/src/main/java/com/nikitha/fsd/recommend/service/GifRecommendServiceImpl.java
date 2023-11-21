package com.nikitha.fsd.recommend.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikitha.fsd.recommend.model.GifModelToSave;
import com.nikitha.fsd.recommend.repository.RecommendRepository;

@Service
public class GifRecommendServiceImpl implements GifRecommendService

{
	@Autowired
	RecommendRepository recommendRepository;
	
	@Override
	public List<GifModelToSave> getAllGifs() {
	
		Optional<List<GifModelToSave>> listOfRecommendGifs = Optional.empty();	
		listOfRecommendGifs = Optional.ofNullable(recommendRepository.findAll());
		return listOfRecommendGifs.get();
	}

	@Override
	public GifModelToSave findGifById(String gifId) {
		
		GifModelToSave findGifById = null ;
		try
		{
		 findGifById = recommendRepository.findById(gifId).get();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        return findGifById;
	}

	@Override
	public Boolean saveGif(GifModelToSave gif) {
		
		Boolean isGifSaved = false;
		Optional<GifModelToSave> findGifById=recommendRepository.findById(gif.getGifId());
		if(findGifById.isPresent())

		{
			recommendRepository.save(gif);
			isGifSaved= true;
		}
		else
		{
			recommendRepository.insert(gif);
			isGifSaved= true;
		}
		
		return isGifSaved;
	}



}



