package com.nikitha.fsd.gipher.test.service;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nikitha.fsd.gipher.exception.BookmarkAlreadyExistsException;
import com.nikitha.fsd.gipher.model.Gif;
import com.nikitha.fsd.gipher.model.User;
import com.nikitha.fsd.gipher.repository.BookmarkRepository;
import com.nikitha.fsd.gipher.service.BookmarkServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BookmarkServiceImplTest {


	private User user;
	private Gif gif;
    @Mock
    private BookmarkRepository bookmarkRepository;
    @InjectMocks
    private BookmarkServiceImpl bookmarkServiceImpl;
    private List<Gif> gifList = null;
    Optional<User> options;


    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        gif = new Gif();
       
        
        gif.setGifId("1");
        gif.setGifURL("wwww.gif.com");
        gif.setBookmarkCreatedAt();

        gifList = new ArrayList<>();
        gifList.add(gif);

        user = new User();

        user.setUserId("Nikitha");
        user.setGif(gifList);
        
        options= Optional.of(user);
        
    }


    @Test
    public void addBookmarkSuccess() throws BookmarkAlreadyExistsException {
       
    	when(bookmarkRepository.insert((User) any())).thenReturn(user);
    	when(bookmarkRepository.findById(user.getUserId())).thenReturn(options);
    	Gif gif1 = new Gif();
    	gif1.setGifId("2");
    	gif1.setGifURL("www.giffy.com");
    	gif1.setBookmarkCreatedAt();
        boolean status = bookmarkServiceImpl.addGif("Nikitha",gif1);
        assertEquals(true, status);
    }

    @Test
    public void addNewsFailure() throws BookmarkAlreadyExistsException {

        when(bookmarkRepository.insert((User) any())).thenReturn(user);
        when(bookmarkRepository.findById(user.getUserId())).thenReturn(options);
        boolean status = bookmarkServiceImpl.addGif("Nikitha", gif);
        assertEquals(false, status);
     }
    
    
    @Test
    public void getAllGifs() throws BookmarkAlreadyExistsException {

        when(bookmarkRepository.insert((User) any())).thenReturn(user);
        when(bookmarkRepository.findById(user.getUserId())).thenReturn(options);
        List<Gif> allGifs = bookmarkServiceImpl.getAllGifs(user.getUserId());
        assertEquals(gifList, allGifs);
     }
    



    @Test
    public void deleteAllGifsSucess()  {
        when(bookmarkRepository.findById(user.getUserId())).thenReturn(options);
        when(bookmarkRepository.save(user)).thenReturn(user);
        boolean flag = bookmarkServiceImpl.deleteBookmark(user.getUserId(), gif.getGifId());
        assertEquals(true, flag);
    }

    @Test
    public void deleteAllGifsSucessFailure() {
        when(bookmarkRepository.findById(user.getUserId())).thenReturn(options);
        when(bookmarkRepository.save(user)).thenReturn(user);
        boolean flag = bookmarkServiceImpl.deleteBookmark(user.getUserId(), "nonExistingGifId");
        assertEquals(false, flag);
       
    
    }

}