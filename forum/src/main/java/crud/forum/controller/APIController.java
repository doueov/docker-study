package crud.forum.controller;

import crud.forum.dto.NewPostDTO;
import crud.forum.dto.PostDTO;
import crud.forum.entity.Post;

import crud.forum.forum.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public String makeNewPost(@RequestBody NewPostDTO dto) {
        // System.out.println(dto);
        Post p = new Post(dto.getTitle(), dto.getAuthor(), dto.getContent(), dto.getPassword());
        postRepository.save(p);
        return "{ \"result\": \"success\" }";
    }

    @GetMapping("/posts")
    public List<PostDTO> getAllPost() {
        List<PostDTO> dtos = new ArrayList<>();
        for(Post item : postRepository.findAll()) dtos.add(PostDTO.toDTO(item));
        return dtos;
    }

    @GetMapping(value = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostDTO> getPost(@PathVariable("id") Integer id) {
        Optional<Post> optional = postRepository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(PostDTO.toDTO(optional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletePost(@PathVariable("id") Integer id, @RequestBody HashMap<String, String> payload) {
        String password = payload.get("password");
        Optional<Post> optional = postRepository.findById(id);
        if(optional.isPresent()) {
            Post post = optional.get();
            if(password.equals(post.getPassword())) {
                postRepository.delete(post);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(value = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object updatePost(@PathVariable("id") Integer id, @RequestBody HashMap<String, String> payload) {
        Optional<Post> optional = postRepository.findById(id);
        if(optional.isPresent()) {
            Post post = optional.get();
            if(payload.get("password") != null && payload.get("password").equals(post.getPassword())) {
                if(payload.get("title") != null) post.setTitle(payload.get("title"));
                if(payload.get("author") != null) post.setAuthor(payload.get("author"));
                if(payload.get("content") != null) post.setContent(payload.get("content"));
                if(payload.get("password") != null) post.setPassword(payload.get("password"));
                postRepository.save(post);
                return "{ \"result\": \"success\" }";
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
