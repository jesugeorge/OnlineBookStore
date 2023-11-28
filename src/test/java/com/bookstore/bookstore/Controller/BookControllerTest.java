package com.bookstore.bookstore.Controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@SpringJUnitWebConfig
class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;

    @Test
    void testAddBook() throws Exception {
        Book bookToAdd = new Book(0L, "NewBook", "NewAuthor", null, null, null);

        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .content(asJsonString(bookToAdd))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("NewBook"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("NewAuthor"));

        verify(bookService, times(1)).save(any(Book.class));
    }

    @Test
    void testUpdateBook() throws Exception {
        Book bookToUpdate = new Book(1L, "UpdatedBook", "UpdatedAuthor", null, null, null);

        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(MockMvcRequestBuilders.put("/books")
                .content(asJsonString(bookToUpdate))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("UpdatedBook"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("UpdatedAuthor"));

        verify(bookService, times(1)).save(any(Book.class));
    }

    @Test
    void testDeleteBook() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/books/{bookId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Deleted employee id - 1"));

        verify(bookService, times(1)).deleteById(1);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}