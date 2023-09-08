package com.project.Accommodator.service.implementation;

import com.project.Accommodator.model.Posting;
import com.project.Accommodator.repository.PostingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PostingServiceImplementationTest {
    @Mock
    private PostingRepository postingRepositoryMock;

    @InjectMocks
    private PostingServiceImplementation postingServiceImplementationMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testCreatePosting() {
        Posting expectedPosting = new Posting(12);
        when(postingRepositoryMock.save(expectedPosting)).thenReturn(expectedPosting);
        Posting actualPosting = postingServiceImplementationMock.createPosting(expectedPosting);
        assertEquals(expectedPosting, actualPosting);
    }

    @Test
    public void testGetPostingById() {
        int id = 1;
        Posting expectedPosting = new Posting(1);
        when(postingRepositoryMock.findById(id)).thenReturn(Optional.of(expectedPosting));
        Posting actualPosting = postingServiceImplementationMock.getPostingById(id);
        assertEquals(expectedPosting, actualPosting);
    }
    @Test
    public void testGetAllPosts() {
        Iterable<Posting> expectedPostings = postingRepositoryMock.findAll();
        when(postingRepositoryMock.findAll()).thenReturn(expectedPostings);
        Iterable<Posting> actualPostings = postingServiceImplementationMock.getAllPosts();
        assertEquals(expectedPostings, actualPostings);
    }
}