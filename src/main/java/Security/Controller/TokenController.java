package Security.Controller;

import Security.Model.JwtUser;
import Security.SpringSecurityJWT.JwtGenerator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/token")
public class TokenController {

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping()
    public String generate(@RequestBody final JwtUser jwtUser) {

        return jwtGenerator.generate(jwtUser);
    }

    @GetMapping("/jwt")
    public void makeRequest(HttpServletResponse response, HttpServletRequest request) throws IOException {

        String url = "http://localhost:8080/rest/hello";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Token eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKb2huIiwidXNlcklkIjoiMSIsInJvbGUiOiJCbG9ja2NoYWluIEVuZ2luZWVyIn0.RHF1hJ4i7FuFhNZy6qQNnksfyw4a40pbgZHyjVMTaODcU_UnYUJCHWhlqkJzQybCkMQGy6OBT9Xq22h5SaTC2Q");

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("Authorization", "Token eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKb2huIiwidXNlcklkIjoiMSIsInJvbGUiOiJCbG9ja2NoYWluIEVuZ2luZWVyIn0.RHF1hJ4i7FuFhNZy6qQNnksfyw4a40pbgZHyjVMTaODcU_UnYUJCHWhlqkJzQybCkMQGy6OBT9Xq22h5SaTC2Q");

        System.out.println("This is the Attribute: " + httpSession.getAttribute("Authorization"));
        restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        response.setHeader("Authorization", "Token eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKb2huIiwidXNlcklkIjoiMSIsInJvbGUiOiJCbG9ja2NoYWluIEVuZ2luZWVyIn0.RHF1hJ4i7FuFhNZy6qQNnksfyw4a40pbgZHyjVMTaODcU_UnYUJCHWhlqkJzQybCkMQGy6OBT9Xq22h5SaTC2Q");
        response.sendRedirect("http://localhost:8080/token/test");
    }

    @GetMapping("/test")
    public String sessionRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        System.out.println("Http Session : " + httpSession.getAttribute("Authorization"));
        return "Successful Saved Session: " + httpSession.getAttribute("Authorization");
    }
}
