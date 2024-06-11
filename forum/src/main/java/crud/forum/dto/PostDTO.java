package crud.forum.dto;

import crud.forum.entity.Post;

public class PostDTO {
    private Integer id;
    private String title;
    private String author;
    private String content;

    public PostDTO(Integer id, String title, String author, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    static public PostDTO toDTO(Post post) {
        return new PostDTO(post.getId(), post.getTitle(), post.getAuthor(), post.getContent());
    }

    public Integer getId() {return id;}public void setId(Integer id) {this.id = id;}public String getTitle() {return title;}public void setTitle(String title) {this.title = title;}public String getAuthor() {return author;}public void setAuthor(String author) {this.author = author;}public String getContent() {return content;}public void setContent(String content) {this.content = content;}
}
