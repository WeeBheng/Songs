

public class Task {
    private int id;
    private String description;
    private String date;
    private String year;
    private String rating;

    public Task(int id, String title, String name, String year, String rating) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return id + "\n" + title + "\n" + name + "\n" + year + "\n" + rating;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }
    public String getRating() {
        return rating;
    }

}