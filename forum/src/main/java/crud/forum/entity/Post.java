package crud.forum.entity;

import jakarta.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String author;

    @Column(nullable=false)
    private String content;

    @Column(nullable=false)
    private String password;

    public Post() {}

    public Post(String title, String author, String content, String password) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.password = password;
    }

    public Integer getId() {return id;}public void setId(Integer id) {this.id = id;}public String getTitle() {return title;}public void setTitle(String title) {this.title = title;}public String getAuthor() {return author;}public void setAuthor(String author) {this.author = author;}public String getContent() {return content;}public void setContent(String content) {this.content = content;}public String getPassword() {return password;}public void setPassword(String password) {this.password = password;}

    @Override public String toString() {return "Post{id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + ", content='" + content + '\'' + ", password='" + password + '\'' + '}'; }
}