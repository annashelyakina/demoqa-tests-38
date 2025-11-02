package guru.qa.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    private final Integer id;
    private final String title;
    private final String author;
    private final Integer year;
    private final String genre;

    //Конструктор
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Book(@JsonProperty("id") Integer id,
                @JsonProperty("title") String title,
                @JsonProperty("author") String author,
                @JsonProperty("year") Integer year,
                @JsonProperty("genre") String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    // Геттеры для полей
    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Integer getYear() { return year; }
    public String getGenre() { return genre; }
  }