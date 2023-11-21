package com.nikitha.fsd.gipher.test.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.nikitha.fsd.gipher.model.Gif;
import com.nikitha.fsd.gipher.model.User;
import com.nikitha.fsd.gipher.repository.BookmarkRepository;
import com.nikitha.fsd.gipher.service.BookmarkServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class BookmarkRepositoryTest {

    

    @Autowired
    private BookmarkRepository bookmarkRepository;

    private Gif gif;
    private User user ;

    
    private List<Gif> gifList = null;

    @BeforeEach
    public void setUp() throws Exception {

    	gif = new Gif();
    	gif.setGifId("1");
    	gif.setGifURL("wwww.gif.com");
    	gif.setBookmarkCreatedAt();

        gifList = new ArrayList<>();
        gifList.add(gif);

        user = new User();
        user.setUserId("Nikitha");
        user.setGif(gifList);

    }

    @AfterEach
    public void tearDown() throws Exception {
    	bookmarkRepository.deleteAll();
    }

    @Test
    public void AddUserGifTest() {
    	bookmarkRepository.insert(user);
    	List<Gif> allGifs = bookmarkRepository.findById("Nikitha").get().getGif();
        assertThat(gifList.get(0).getGifId(), is(allGifs.get(0).getGifId()));
    }


    @Test
    public void deleteGifTest() {
    	bookmarkRepository.insert(user);
    	List<Gif> allGifs = bookmarkRepository.findById("Nikitha").get().getGif();
    	assertThat(gifList.get(0).getGifId(), is(allGifs.get(0).getGifId()));
        Iterator<Gif> iterator = allGifs.listIterator();
        while (iterator.hasNext()) {
            gif = iterator.next();
            if (gif.getGifId().equals("1"))
                iterator.remove();
        }

        user.setGif(allGifs);
        bookmarkRepository.save(user);

        allGifs = bookmarkRepository.findById("Nikitha").get().getGif();

        assertThat(true,is(allGifs.isEmpty()));

    }

    @Test
    public void getAllGifTest() {

    	bookmarkRepository.insert(user);
        List<Gif> allGifList = bookmarkRepository.findById(user.getUserId()).get().getGif();
        assertThat(allGifList.size(),is(1));
    }
}