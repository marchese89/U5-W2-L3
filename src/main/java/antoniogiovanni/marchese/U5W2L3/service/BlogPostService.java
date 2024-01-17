package antoniogiovanni.marchese.U5W2L3.service;

import antoniogiovanni.marchese.U5W2L3.exceptions.NotFoundException;
import antoniogiovanni.marchese.U5W2L3.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
@Service
public class BlogPostService {
    private List<BlogPost> blogbostList = new ArrayList<>();

    public List<BlogPost> getBlogbostList() {
        return this.blogbostList;
    }

    public BlogPost save(BlogPost body) {
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 2000));
        this.blogbostList.add(body);
        return body;
    }

    public BlogPost findById(int id) {
        BlogPost found = null;
        for (BlogPost user : this.blogbostList) {
            if (user.getId() == id) {
                found = user;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Iterator<BlogPost> iterator = this.blogbostList.iterator();
        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost blogpost) {
        BlogPost found = null;
        for (BlogPost user : this.blogbostList) {
            if (user.getId() == id) {
                found = user;
                found.setCategoria(blogpost.getCategoria());
                found.setTitolo(blogpost.getTitolo());
                found.setCover(blogpost.getCover());
                found.setContenuto(blogpost.getContenuto());
                found.setTempoDiLettura(blogpost.getTempoDiLettura());
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
}
