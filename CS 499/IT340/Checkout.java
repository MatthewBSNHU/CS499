public class TransactionDAO {
    public void borrowBook(int userId, int bookId) {
        String sql = "INSERT INTO transactions (book_id, user_id, borrow_date) VALUES (?, ?, NOW())";
        String updateBookStatus = "UPDATE books SET available = FALSE WHERE book_id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             PreparedStatement updateStmt = conn.prepareStatement(updateBookStatus)) {

            pstmt.setInt(1, bookId);
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();

            updateStmt.setInt(1, bookId);
            updateStmt.executeUpdate();
            
            System.out.println("Book borrowed successfully.");

        } catch (SQLException e) {
            System.out.println("Error borrowing book: " + e.getMessage());
        }
    }
}
