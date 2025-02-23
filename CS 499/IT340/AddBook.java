public class BookDAO {
    public void addBook(String title, String author, String isbn) {
        String sql = "INSERT INTO books (title, author, isbn, available) VALUES (?, ?, ?, TRUE)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, isbn);
            pstmt.executeUpdate();
            System.out.println("Book added successfully.");
            
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }
}
