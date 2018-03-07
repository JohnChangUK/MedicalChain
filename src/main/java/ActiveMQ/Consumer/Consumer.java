package ActiveMQ.Consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    // Create a Consumer which is ready to listen to ActiveMQ
    @JmsListener(destination = "standalone.queue")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
