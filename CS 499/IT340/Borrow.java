public class TransactionDAO {
    private final MongoDatabase database;

    public TransactionDAO() {
        this.database = MongoDBConnection.connect();
    }

    public void borrowBook(String userId, String bookId) {
        MongoCollection<Document> booksCollection = database.getCollection("books");

        Document book = booksCollection.find(new Document("_id", bookId)).first();
        if (book != null && book.getBoolean("available")) {
            booksCollection.updateOne(
                new Document("_id", bookId),
                new Document("$set", new Document("available", false))
            );
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }
}
