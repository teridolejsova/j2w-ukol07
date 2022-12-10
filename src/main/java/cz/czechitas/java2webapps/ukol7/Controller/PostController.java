package cz.czechitas.java2webapps.ukol7.Controller;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import cz.czechitas.java2webapps.ukol7.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public ModelAndView seznamPostu() {
        PageRequest pageRequest = PageRequest.of(0,20);
       ModelAndView modelAndView=new ModelAndView("index")
               .addObject("seznamPostu",postService.seznampostu(pageRequest));

        return modelAndView;
    }
    @GetMapping("/detail/{slug}")
    public ModelAndView detailpostu (@PathVariable String slug){
        ModelAndView modelAndView = new ModelAndView("detail")
                .addObject("jedenPost",postService.singePost(slug));
        return modelAndView;

    }
}