package guru.springframeword.sfgdi.controllers;

import guru.springframeword.sfgdi.services.PetService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by jt on 12/28/19.
 */
@Controller
public class PetController implements InitializingBean, DisposableBean {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest(){
        return petService.getPetType();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("******PetController ---afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("******PetController ---destroy");
    }

//    @PostConstruct
//    public void customInit()
//    {
//        System.out.println("******PetController PostConstruct");
//    }
//
//    @PreDestroy
//    public void customDestroy()
//    {
//        System.out.println("******PetController PreDestroy");
//    }
}
