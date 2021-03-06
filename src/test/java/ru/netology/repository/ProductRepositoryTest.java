package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository productRepository = new ProductRepository();

    Book book1 = new Book(1,"Tom",100,"Lev",20,1950);
    Book book2 = new Book(3,"Tom",100,"Sid",20,1950);

    @BeforeEach
     public void setUp() {
        productRepository.save(book1);
        productRepository.save(book2);
    }

    @Test
    public void shouldDeleteNotExistingElement() {
        assertThrows(NotFoundException.class, () -> productRepository.removeById(2));
    }

    @Test
    public void shouldDeleteExistingElement() {
        productRepository.removeById(1);
        Product[] actual = productRepository.findAll();
        Product[] expected = new Product[]{book2};
        assertArrayEquals(actual,expected);
    }
}