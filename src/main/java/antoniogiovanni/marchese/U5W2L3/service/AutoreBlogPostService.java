package antoniogiovanni.marchese.U5W2L3.service;

import antoniogiovanni.marchese.U5W2L3.exceptions.NotFoundException;
import antoniogiovanni.marchese.U5W2L3.model.AutoreBlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
@Service
public class AutoreBlogPostService {
    private List<AutoreBlogPost> autoriBlogPostList = new ArrayList<>();
    public List<AutoreBlogPost> getAutoriBlogPostList() {
        return this.autoriBlogPostList;
    }

    public AutoreBlogPost save(AutoreBlogPost autoreBlogPost) {
        Random rndm = new Random();
        autoreBlogPost.setId(rndm.nextInt(1, 2000));
        this.autoriBlogPostList.add(autoreBlogPost);
        return autoreBlogPost;
    }

    public AutoreBlogPost findById(int id) {
        AutoreBlogPost found = null;
        for (AutoreBlogPost user : this.autoriBlogPostList) {
            if (user.getId() == id) {
                found = user;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Iterator<AutoreBlogPost> iterator = this.autoriBlogPostList.iterator();
        while (iterator.hasNext()) {
            AutoreBlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public AutoreBlogPost findByIdAndUpdate(int id, AutoreBlogPost autoreBlogPost) {
        AutoreBlogPost found = null;
        for (AutoreBlogPost autoreBlogPost1 : this.autoriBlogPostList) {
            if (autoreBlogPost1.getId() == id) {
                found = autoreBlogPost1;
                found.setNome(autoreBlogPost.getNome());
                found.setCognome(autoreBlogPost.getCognome());
                found.setEmail(autoreBlogPost.getEmail());
                found.setDataDiNascita(autoreBlogPost.getDataDiNascita());
                found.setAvatar(autoreBlogPost.getAvatar());
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
}
