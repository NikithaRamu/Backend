package com.nikitha.fsd.gipher.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nikitha.fsd.gipher.exception.BookmarkAlreadyExistsException;
import com.nikitha.fsd.gipher.exception.NoSuchBookmarkExists;
import com.nikitha.fsd.gipher.model.Gif;
import com.nikitha.fsd.gipher.model.User;
import com.nikitha.fsd.gipher.repository.BookmarkRepository;

@Service
public class BookmarkServiceImpl implements BookmarkService {

	@Autowired
	BookmarkRepository bookmarkRepository;
	
	@Override
	public Boolean addGif(String userId,Gif gif) throws BookmarkAlreadyExistsException  {
		
		List<Gif>gifToAdd = new ArrayList<Gif>();
		gif.setBookmarkCreatedAt();
		Boolean isGifSaved=false;
		Optional<User> userProfile = bookmarkRepository.findById(userId);
		if(!userProfile.isPresent())
		{
		List<Gif>gifList = new ArrayList();	
		User user= new User();
		user.setUserId(userId);
		user.setGif(gifList);
		bookmarkRepository.insert(user);
		}
		List<Gif> listOfGifs = getAllGifs(userId);
		Gif isGifPresent=null;
		isGifPresent = listOfGifs.stream().filter(x->x.getGifId().equals(gif.getGifId()))
				.findAny().orElse(null);
		
		
		if(isGifPresent==null)
		{
			gifToAdd.add(gif);
			listOfGifs.addAll(gifToAdd);
			Optional<User> user = bookmarkRepository.findById(userId);
			user.get().setGif(listOfGifs);
			bookmarkRepository.save(user.get());
			isGifSaved=true;
		}
		
		
		return isGifSaved;
	}

	@Override
	public List<Gif> getAllGifs(String userId) {

		Optional<List<Gif>> gifListForUser= Optional.empty();
		List<Gif> gifList  = new ArrayList();
		Optional<User> userData = Optional.empty();
		try
		{
			userData= bookmarkRepository.findById(userId);
			gifList=userData.get().getGif();
//			if(userData.get().getGif().size()>0)
//			{
//				gifList = userData.get().getGif();
//			}
		}
		catch (Exception e) {
			
		}
		return gifList;
	}

	@Override
	public Boolean deleteBookmark(String userId, String gifId) {
		Boolean isBookmarkDeleted = false;
		Optional<User> user = Optional.empty(); 
		Optional<List<Gif>> gifListForUser= Optional.empty();
		Gif gif = new Gif();
		user = bookmarkRepository.findById(userId);
		try
		{
			List<Gif> listOfGifs = getAllGifs(userId);
			Gif isGifPresent = listOfGifs.stream().filter(x->x.getGifId().equals(gifId))
					.findAny().orElse(null);;
					
			if(isGifPresent!=null)
			{
				isBookmarkDeleted=true;
				listOfGifs.remove(isGifPresent);
				user.get().setGif(listOfGifs);
				bookmarkRepository.save(user.get());
			}
			
			else
			{
				throw new NoSuchBookmarkExists("No Such Bookmark exists");
			}
					
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return isBookmarkDeleted;
		
	}




}
