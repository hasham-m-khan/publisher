package com.springframework.webapp.bootstrap;

import com.springframework.webapp.domain.Author;
import com.springframework.webapp.domain.Book;
import com.springframework.webapp.domain.Publisher;
import com.springframework.webapp.repositories.AuthorRepository;
import com.springframework.webapp.repositories.BookRepository;
import com.springframework.webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;
    private final PublisherRepository publisherRepo;

    public BootStrapData(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123456123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepo.save(eric);
        bookRepo.save(ddd);

        Author john = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "158643521");
        john.getBooks().add(noEJB);
        noEJB.getAuthors().add(john);

        authorRepo.save(john);
        bookRepo.save(noEJB);

        Publisher cr = new Publisher("Canadian Publishers", "123rd ST", "Toronto",
                "British Columbia", "12345");
        Publisher bg = new Publisher("The Botanical Gazette", "1st ST", "New York", "NY",
                "11421");

        publisherRepo.save(cr);
        publisherRepo.save(bg);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books in DB: " + bookRepo.count());
        System.out.println("Number of publishers in DB: " + publisherRepo.count());
    }
}
