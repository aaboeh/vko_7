package main;

public abstract class Book {
    protected String title;
    protected String author;
    protected int pages;
    protected int copies;

    public void displayInfo() {
        System.out.println("Nimi: " + title + ", Kirjailija: " + author + ", Sivut: " + pages + ", Määrä: " + copies);
        System.out.println("Kirjan kategoria: " + categorize());
    }

    public abstract String categorize();
    
}
