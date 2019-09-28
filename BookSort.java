package TestCompare;

import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName BookSort
 * @Description TODO
 * @Auther danni
 * @Date 2019/9/28 16:32]
 * @Version 1.0
 **/

public class BookSort {
    public static void bookSort(Book[] books){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入按何种方式（书名，作者，价格，销量，评论数）排序：");
        String str=scanner.next();
        switch (str){
            case "书名":
                Comparator comparator=new BookNameSortComparator();
                sort(books,comparator);
                break;
            case "作者":
                Comparator comparator1=new AuthorSortComparator();
                sort(books,comparator1);
                break;
            case "价格":
                System.out.println("请选择升序或降序：");
                String s=scanner.next();
                switch (s){
                    case"升序":
                        Comparator comparator2=new BookPriceSortComparator();
                        sort(books,comparator2);
                        break;
                    case"降序":
                        Comparator comparator0=new BookPriceSortComparator();
                        sort1(books,comparator0);
                        break;
                }
                break;
            case"销量":
                Comparator comparator3=new NumSalesSortComparator();
                sort(books,comparator3);
                break;
            case "评论数":
                Comparator comparator4=new NumCommetsSortComparator();
                sort(books,comparator4);
                break;

                default:
                    break;
        }

    }

    private static void sort(Book[] books, Comparator comparator) {
        for (int i = 1; i <books.length ; i++) {
            Book s=books[i];
            int j=i-1;
            for (j = i-1; j>=0&&(comparator.compare(books[j],s))>0 ; j--) {
                books[j + 1] = books[j];
            }
            books[j+1]=s;
        }
    }
    private static void sort1(Book[] books, Comparator comparator) {
        for (int i = 1; i <books.length ; i++) {
            Book s=books[i];
            int j=i-1;
            for (j = i-1; j>=0&&(((BookPriceSortComparator) comparator).compare1(books[j],s))>0 ; j--) {
                books[j + 1] = books[j];
            }
            books[j+1]=s;
        }
    }

    public static void main(String[] args) {
      Book[] books={new Book("001","aaa","高数",32,1200,500),
              new Book("002","bbb","大英",82,1500,5800),
              new Book("003","ccc","高物",72,1400,700),};
      bookSort(books);
        for(Book book:books){
            System.out.println(book);
        }
    }
}
//按书名排序
class BookNameSortComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.bookname.compareTo(o2.bookname);
    }
}
//按作者排序
class AuthorSortComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.author.compareTo(o2.author);
    }
}
//按价格排序
class BookPriceSortComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return (int)(o1.bookprice-o2.bookprice)*100;
    }
    public int compare1(Book o1, Book o2) {
        return  (int)(o2.bookprice-o1.bookprice)*100;
    }

}
//按销量排序
class NumSalesSortComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.numsales-o2.numsales;
    }
}
//按评论数排序
class NumCommetsSortComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.numcommets-o2.numcommets;
    }
}

