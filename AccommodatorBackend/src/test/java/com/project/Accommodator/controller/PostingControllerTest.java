package com.project.Accommodator.controller;
import com.project.Accommodator.model.Posting;
import com.project.Accommodator.service.PostingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class PostingControllerTest {
    @Autowired
    private PostingController postingControllerMock;
    PostingService postingServiceMock;

    @BeforeEach
    public void setup() {
        postingServiceMock = mock(PostingService.class);
        postingControllerMock.PostingService = postingServiceMock;
    }

    @Test
    public void objectCreated() throws Exception {
        assertNotNull(postingControllerMock);
    }
    @Test
    public void testGetPostingById() throws Exception {
        int id = 1;
        Posting expectedPosting = new Posting(1);
        when(postingServiceMock.getPostingById(id)).thenReturn(expectedPosting);
        Posting actualPosting = postingControllerMock.getPostingById(id);
        assertEquals(expectedPosting, actualPosting);
    }

    @Test
    public void testCreatePosting() throws Exception {
        Posting expectedPosting = new Posting(1);
        when(postingServiceMock.createPosting(expectedPosting)).thenReturn(expectedPosting);
        Posting actualPosting = postingControllerMock.createPosting(expectedPosting);
        assertEquals(expectedPosting, actualPosting);
    }
    @Test
    public void testGetAllPosts() throws Exception {
        List<Posting> expectedPostings = new ArrayList<>();
        expectedPostings.add(new Posting(1));
        expectedPostings.add(new Posting(2));
        when(postingServiceMock.getAllPosts()).thenReturn(expectedPostings);
        Iterable<Posting> actualPostings = postingControllerMock.getAllPosts();
        assertEquals(expectedPostings, actualPostings);
    }

}