package crud.forum.controller;

import crud.forum.dto.PostDTO;
import crud.forum.entity.Post;
import crud.forum.forum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ui")
public class UIController {
    private final String template = """
<!DOCTYPE html>
<html>
    <body>
        <div>%s</div>
    </body>
</html>
""";

    @Autowired
    private PostRepository postRepository;

    @GetMapping(value = "/posts", produces = MediaType.TEXT_HTML_VALUE)
    public String getPostsUI() {
        List<PostDTO> dtos = new ArrayList<>();
        for(Post item : postRepository.findAll()) dtos.add(PostDTO.toDTO(item));
        String data = "<ul>";
        for(PostDTO dto : dtos) {
            data += "<li>" + (dto.getTitle()) + "</li>";
        }
        data += "</ul>";
        return String.format(template, data);
    }

    @GetMapping(value = "/posts/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getPostUI(@PathVariable("id") Integer id) {
        Optional<Post> optional = postRepository.findById(id);
        if(optional.isPresent()) {
            Post post = optional.get();
            return ResponseEntity.ok(String.format(template, String.format("<h1>%s</h1><h2>%s</h2><p>%s</p>", post.getTitle(), post.getAuthor(), post.getContent())));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format(template, "not found"));
        }

    }
}

