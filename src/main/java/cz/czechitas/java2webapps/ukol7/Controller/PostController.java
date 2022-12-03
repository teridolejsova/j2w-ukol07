package cz.czechitas.java2webapps.ukol7.Controller;

import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
    PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @GetMapping("/")
    public ModelAndView seznamPostu(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 20) Pageable pageable) {
       ModelAndView modelAndView=new ModelAndView("index")
               .addObject("seznamPostu",postRepository.findAll(pageable).getContent());
        return modelAndView;
    }
}