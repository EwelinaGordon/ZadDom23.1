import java.sql.*;

public class BooksDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/library?characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    public BooksDAO(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }


public void save (Books books){
        final String query = "insert into books(title, author, year, isbn) values (?, ?, ?, ?)";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, books.getTitle());
        preparedStatement.setString(2, books.getAuthor());
        preparedStatement.setInt(3, books.getYear());
        preparedStatement.setString(4, books.getIsbn());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Could not save record");
    }
}

public Books read (long id){
        final String query = "select id, title, author, year, isbn from books where id = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            Books books = new Books();
            books.setId(result.getLong("id"));
            books.setTitle(result.getString("title"));
            books.setAuthor(result.getString("author"));
            books.setYear(result.getInt("year"));
            books.setIsbn(result.getString("isbn"));
            return books;
        }
    } catch (SQLException e) {
        System.out.println("Could not find book");
    } return null;
}

public void update(Books books){
        final String query = "update books set isbn = ? where id = ?";

    try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, books.getIsbn());
        preparedStatement.setLong(2, books.getId());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Could not update item");
    }
}

public void delete(long id){
        final String query = "delete from books where id = ?";

    try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Could not delete item");
    }

}

}
