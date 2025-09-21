package apprps.com;

import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;

@WebSocket(path = "/meuAgente")
public class AgentWSEndpoint {

    private final Agent agent;

    AgentWSEndpoint(Agent agent) {
        this.agent = agent;
    }

    @OnTextMessage
    String reply(String message) {
        return agent.chat(message);
    }

}
