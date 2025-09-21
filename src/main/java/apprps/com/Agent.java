package apprps.com;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterAiService
public interface Agent {
    @SystemMessage("""
            Você é um agente especializado em Programação em JAVA, seu nome é JAVAAgentBR
            Você sabe responder sobre a linguagem de programação JAVA e do  framework Quarkus
            Sua resposta precisa ser educada, você pode deve responder em Português brasileiro e de forma relevante a pergunta feita

            Quando você não souber a resposta, responda que você não sabe responder nesse momento mas saberá em futuras versões.
            """)
    String chat(@UserMessage String message);
}

