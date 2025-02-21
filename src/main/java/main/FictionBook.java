package main;

public class FictionBook extends Book implements Borrowable {

    public FictionBook(String title, String author, int pages, int copies) {
        super(title, author, pages, copies);
    }

    public String categorize() {
        return "Fiktiokirja";
    }
    
    public void borrow() {
        if (copies > 0) {
            copies --;
            System.out.println("Kirja " + title + " on nyt lainattu.");
        } else {
            System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
        }
    }

    public void returnBook() {
        copies ++;
        System.out.println("Kirja " + title + " on nyt palautettu.");
    }
}
