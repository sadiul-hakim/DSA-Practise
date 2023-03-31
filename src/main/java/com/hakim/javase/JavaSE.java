package com.hakim.javase;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Hakim
 */
public class JavaSE {
  public static List<Book> filter(List<Book> bookList,Predicate<Book> predicate){
      return bookList
              .stream()
              .filter(book->predicate.test(book))
              .collect(Collectors.toList());
  }
  
  
    public static void main(String[] args) {
        List<Book> bookList=List.of(
                new Book("Java Programming",1000),
                new Book("Java Advanced Programming",400),
                new Book("Java Thread Programming",350)
        );
        
      List<Book> filteredList = filter(bookList, book->book.getPrice() >= 500 && 1000 >= book.getPrice());
       
        System.out.println(filteredList);
    }
}
