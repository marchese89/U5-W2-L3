package antoniogiovanni.marchese.U5W2L3.controller;

import antoniogiovanni.marchese.U5W2L3.model.BlogPost;
import antoniogiovanni.marchese.U5W2L3.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    // 1. GET http://localhost:3001/blogPosts
    @GetMapping
    public List<BlogPost> getUsers() {
        return blogPostService.getBlogbostList();
    }

    // 	2. POST http://localhost:3001/blogPosts (+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public BlogPost saveUser(@RequestBody BlogPost blogPost) {
        return blogPostService.save(blogPost);
    }

    // 	3. GET http://localhost:3001/blogPosts/:id
    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable int id) {
        return blogPostService.findById(id);
    }


    // 	4. PUT http://localhost:3001/blogPosts/:id (+body)
    @PutMapping("/{id}")
    public BlogPost findByAndUpdate(@PathVariable int id, @RequestBody BlogPost blogPost) {
        return this.blogPostService.findByIdAndUpdate(id, blogPost);
    }

    // 	5. DELETE http://localhost:3001/blogPosts/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable int id) {
        this.blogPostService.findByIdAndDelete(id);
    }
}
