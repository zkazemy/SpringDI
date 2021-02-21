package guru.springframeword.sfgdi.controllers;

import guru.springframeword.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
//   @Autowired// this it optional and can be absent or present.
//    @Qualifier("helloServiceImpl")
    private final GreetingService greetingService;

    public ConstructorInjectedController( @Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting()
    {
        return greetingService.sayGreeting();
    }
}
