public class GenericItem extends Item{
    protected String id;
    protected String title;
    protected String location;
    protected String year;
    protected String author;
    protected String type;

    public GenericItem(String id, String title, String location, String year, String author) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.type = "misc";
        addTag(id, this);
    }

    public GenericItem(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
        addTag(id, this);
    }

    public GenericItem(String id, String title, String location, String year, String author, String type) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.author = author;
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "MiscItem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", year='" + year + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
