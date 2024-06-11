package crud.forum.dto;

public class NewPostDTO {
    private String title;
    private String author;
    private String content;
    private String password;

    public String getTitle() {return title;}public void setTitle(String title) {this.title = title;}public String getAuthor() {return author;}public void setAuthor(String author) {this.author = author;}public String getContent() {return content;}public void setContent(String content) {this.content = content;}public String getPassword() {return password;}public void setPassword(String password) {this.password = password;}
    @Override public String toString() {return "NewPostDTO{title='" + title + '\'' + ", author='" + author + '\'' + ", content='" + content + '\'' + ", password='" + password + '\'' + '}'; }
}
