package pojo;

/**
 * @version 1.0
 * @ClassName Article
 * @Description TODO
 * @Author 89255
 */
public class Article {
    private Integer id;
    private String title;
    private String context;
    private String author;
    private String label;
    private int collectId;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", author='" + author + '\'' +
                ", label='" + label + '\'' +
                ", collectId=" + collectId +
                '}';
    }

    public Article(Integer id, String title, String context, String author, String label, int collectId) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.author = author;
        this.label = label;
        this.collectId = collectId;
    }

    public int getCollectId() {
        return collectId;
    }

    public void setCollectId(int collectId) {
        this.collectId = collectId;
    }

    public Article(Integer id, String title, String context, String author, String label) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.author = author;
        this.label = label;
    }

    public Article() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
