package Backend;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int ISBN;
    private String title;
    private String publisherName;
    private String publicationYear;
    private double price;
    private int noOfCopies;
    private int threshold;


    private List<String> authors;
    private List<String> categories;

    public Book () {
        authors = new ArrayList<>();
        categories = new ArrayList<>();
    }

    public Book (String title, int ISBN, String publisherName, double price, int quantity) {
        this.title = title;
        this.ISBN = ISBN;
        this.publisherName = publisherName;
        this.price = price;
        noOfCopies = quantity;
    }

    public void addAuthor (String author) {
        authors.add(author);
    }

    public List<String> getAuthors () {
        return authors;
    }

    public void addCategory (String category) {
        categories.add(category);
    }

    public List<String> getCategories () {
        return categories;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

}
