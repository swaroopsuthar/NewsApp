package swaroop.android.newsapp.room.entity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "news")
public class News {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String author;
    private String title;
    private String desc;
    private String longDesc;
    private String url;
    private String imageUrl;

    public News(String author, String title, String desc, String longDesc, String url, String imageUrl) {
        this.author = author;
        this.title = title;
        this.desc = desc;
        this.longDesc = longDesc;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
