package main;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        boolean exit = false;
        while(!exit) {

            System.out.println("1) Lisää kirja");
            System.out.println("2) Listaa kirjat");
            System.out.println("3) Lainaa fiktiokirja");
            System.out.println("4) Palauta fiktiokirja");
            System.out.println("0) Lopeta ohjelma");

            if (sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Minkä kirjan haluat lisätä kirjastoon? 1) Fiktiokirja, 2) Tietokirja");
                        int bookType = Integer.parseInt(sc.nextLine());
                        System.out.println("Anna kirjan nimi:");
                        String bookTitle = sc.nextLine();
                        System.out.println("Anna kirjailijan nimi:");
                        String bookAuthor = sc.nextLine();
                        System.out.println("Anna sivumäärä:");
                        int bookPages = Integer.parseInt(sc.nextLine());
                        System.out.println("Anna kirjojen määrä:");
                        int bookCopies = Integer.parseInt(sc.nextLine());

                        if (bookType == 1) {
                            library.addBook(new FictionBook(bookTitle, bookAuthor, bookPages, bookCopies));
                        } else if (bookType == 2) {
                            library.addBook(new NonFictionBook(bookTitle, bookAuthor, bookPages, bookCopies));
                        } else {
                            System.out.println("Virheellinen kirjatyyppi.");
                            break;
                        }

                        System.out.println("Kirja lisätty kirjastoon!");
                        break;
                    case 2:
                        library.listBooks();
                        break;
                    case 3:
                        System.out.println("Anna lainattavan kirjan nimi:");
                        String titleToBorrow = sc.nextLine();
                        for (Book book : library.books) {
                            if (book.title.equals(titleToBorrow)) {
                                if (book instanceof FictionBook) {
                                    ((FictionBook) book).borrow();
                                }
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Anna palautettavan kirjan nimi:");
                        String titleToReturn = sc.nextLine();
                        for (Book book : library.books) {
                            if (book.title.equals(titleToReturn)) {
                                if (book instanceof FictionBook) {
                                    ((FictionBook) book).returnBook();
                                }
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä.");
                }
            }
        }
        sc.close();
    }
}
