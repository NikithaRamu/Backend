package com.nikitha.fsd.gipher.service;
import java.util.List;

import com.nikitha.fsd.gipher.exception.BookmarkAlreadyExistsException;
import com.nikitha.fsd.gipher.exception.NoSuchBookmarkExists;
import com.nikitha.fsd.gipher.model.Gif;
import com.nikitha.fsd.gipher.model.User;



public interface BookmarkService  {
	Boolean addGif(String userId,Gif gif) throws BookmarkAlreadyExistsException;
	List<Gif> getAllGifs(String userId); 
	Boolean deleteBookmark(String userId,String gifId) throws NoSuchBookmarkExists;

}
