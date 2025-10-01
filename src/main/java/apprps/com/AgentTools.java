package apprps.com;

import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class AgentTools {

    @Tool
    String projectabout() {
        System.out.println("Falando sobre o projeto");
        return "Esse é um projeto de teste para demostrar a utilizacao do Tools , onde vc pode chamar qualquer funcionalidade do seu sistema!";
    }

    @Tool("Calcula a soma de dois números")
    int add(int a, int b) {
        System.out.println("Called add with a=" + a + ", b=" + b);
        return a + b;
    }

    @Tool ("Chama meu metodo numero 1")
    String acaoNosistema2(String vem) {

        ClasseChamada metodo = new ClasseChamada();
        return metodo.metodoChamado(vem);
    }

    @Tool("Mostra um pop-up de confirmação para o usuário e retorna sua resposta.")
    public String confirmarAcao() {
        System.out.println("Agente de IA solicitando pop-up de confirmação...");

        CountDownLatch latch = new CountDownLatch(1);
        final int[] resposta = new int[1];

        // Chama o método do pop-up, passando um callback para lidar com a resposta
        PopUpConfirmacao.exibirPopUp(r -> {
            resposta[0] = r;
            latch.countDown(); // Sinaliza que a resposta foi obtida
        });

        try {
            // Espera até 1 minuto pela resposta do usuário.
            if (!latch.await(1, TimeUnit.MINUTES)) {
                System.err.println("Tempo esgotado para resposta do pop-up.");
                return "Usuário não respondeu a tempo.";
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Ferramenta interrompida.";
        }

        // Traduz a resposta do pop-up em um formato que o LLM possa entender
        if (resposta[0] == JOptionPane.YES_OPTION) {
            return "Usuário confirmou a ação.";
        } else if (resposta[0] == JOptionPane.NO_OPTION) {
            return "Usuário negou a ação.";
        } else {
            return "Ação do pop-up foi cancelada.";
        }
    }



}
