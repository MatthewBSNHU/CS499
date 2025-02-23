public class BookDAO {
    private final MongoDatabase database;

    public BookDAO() {
        this.database = MongoDBConnection.connect();
    }

    public void addBook(String title, String author, String isbn) {
        MongoCollection<Document> booksCollection = database.getCollection("books");

        Document newBook = new Document("title", title)
                .append("author", author)
                .append("isbn", isbn)
                .append("available", true);

        booksCollection.insertOne(newBook);
        System.out.println("Book added successfully.");
    }
}
