package antoniogiovanni.marchese.U5W2L3.controller;

import antoniogiovanni.marchese.U5W2L3.model.AutoreBlogPost;
import antoniogiovanni.marchese.U5W2L3.service.AutoreBlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/authors")
public class AutoreBlogPostController {
    @Autowired
    private AutoreBlogPostService autoreBlogPostService;

    // 1. GET http://localhost:3001/authors
    @GetMapping
    public List<AutoreBlogPost> getUsers() {
        return autoreBlogPostService.getAutoriBlogPostList();
    }

    // 	2. POST http://localhost:3001/authors (+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public AutoreBlogPost saveUser(@RequestBody AutoreBlogPost autoreBlogPost) {
        return autoreBlogPostService.save(autoreBlogPost);
    }

    // 	3. GET http://localhost:3001/authors/:id
    @GetMapping("/{id}")
    public AutoreBlogPost findById(@PathVariable int id) {
        return autoreBlogPostService.findById(id);
    }


    // 	4. PUT http://localhost:3001/authors/:id (+body)
    @PutMapping("/{id}")
    public AutoreBlogPost findByAndUpdate(@PathVariable int id, @RequestBody AutoreBlogPost autoreBlogPost) {
        return this.autoreBlogPostService.findByIdAndUpdate(id, autoreBlogPost);
    }

    // 	5. DELETE http://localhost:3001/authors/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable int id) {
        this.autoreBlogPostService.findByIdAndDelete(id);
    }
}
