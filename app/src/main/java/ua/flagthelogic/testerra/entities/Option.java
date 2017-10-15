package ua.flagthelogic.testerra.entities;

public class Option {
    int id = 0;
    String title = "default_option_title";
    int value = 0;
    public Option() {
    }

    public Option(int id, String title, int value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value=" + value +
                '}';
    }
}
