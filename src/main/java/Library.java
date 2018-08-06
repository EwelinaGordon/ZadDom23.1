public class Library {
    public static void main(String[] args) {
        //DAO: CREATE
//        Books books1 = new Books("Lalka", "Prus", 1890, "1980-BP-L");
//        Books books2 = new Books("Krzyzacy", "Sienkiewicz", 1900, "1980-HS-K");
//        Books books3 = new Books("Potop", "Sienkiewicz", 1886, "1980-HS-P");
//        Books books4 = new Books("Pan Tadeusz", "Mickiewicz", 1834, "1980-AM-P");
//        Books books5 = new Books("Siłaczka", "Żeromski", 1895, "1980-SZ-S");
        BooksDAO booksDAO = new BooksDAO();
//        booksDAO.save(books1);
//        booksDAO.save(books2);
//        booksDAO.save(books3);
//        booksDAO.save(books4);
//        booksDAO.save(books5);
        //DAO: READ
//        Books book = booksDAO.read(7);
//        System.out.println(book.toString());
        //DAO: UPDATE
//        Books bookToUpdate = booksDAO.read(7);
//        bookToUpdate.setIsbn("1834-AM-P");
//        booksDAO.update(bookToUpdate);
        //DAO: DELETE
       booksDAO.delete(8);





    }
}
