/*package com.example.demo.InMemoryStorage;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Country;
import com.example.demo.model.enumeration.Category;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authors = new ArrayList<>();
    public static List<Country> countries = new ArrayList<>();

    public static List<Book> books = new ArrayList<>();
    @PostConstruct
    public void init(){
        Country country1=new Country("Macedonia","Europe");
        countries.add(country1);
        Country country2=new Country("Greece","Europe");
        countries.add(country2);
        Country country3=new Country("Germany","Europe");
        countries.add(country3);

        Author author1=new Author("Petre","Petrevski",country1);
        authors.add(author1);
        Author author2=new Author("Zoki","Stojanovski",country2);
        authors.add(author2);
        Author author3=new Author("Marija","Markovska",country3);
        authors.add(author3);

        books.add(new Book("Romeo and Juliet", Category.NOVEL,10,author1));
        books.add(new Book("The Devil in the White City", Category.HISTORY,15,author2));
        books.add(new Book("Game of Thrones", Category.FANTASY,25,author3));


    }
}
*/