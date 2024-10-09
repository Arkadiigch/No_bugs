package org.example.HW1.Book;

public class Book implements Displayable {
     private String nameBook;
     private String nameAuthor;
     private int publishDate;

     public void setNameBook(String nameBook){
         this.nameBook = nameBook;
     }
     public String getNameBook() {
         return this.nameBook;
     }
    public void setNameAuthor(String nameAuthor){
        this.nameAuthor = nameAuthor;
    }
    public String getNameAuthor() {
        return this.nameAuthor;
    }
    public void setPublishDate(int publishDate){
         this.publishDate = publishDate;
    }
    public int getPublishDate() {
        return this.publishDate;
    }

    @Override
    public void display() {
        System.out.println("Название: " + this.nameBook);
        System.out.println("Автор: " + this.nameAuthor);
        System.out.println("Год издания: " + this.publishDate);
    }
}
