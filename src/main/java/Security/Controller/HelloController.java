package Security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @RequestMapping("/rest/hello")
    public String helloGreeting(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        System.out.println("Http Session from rest/hello : " + httpSession.getAttribute("Authorization"));
//        String key = httpSession.getAttribute("Authorization").toString();
//        System.out.println("KEY :" + key);
        return "Hello Greeting";
    }
}
