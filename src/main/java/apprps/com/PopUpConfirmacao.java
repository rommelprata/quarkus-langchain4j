package apprps.com;

import javax.swing.*;
import java.util.function.Consumer;

public class PopUpConfirmacao {

    public static void exibirPopUp(Consumer<Integer> callback) {
        // Usa SwingUtilities.invokeLater para garantir que a GUI seja executada na EDT
        SwingUtilities.invokeLater(() -> {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION);
            // Chama o callback com a resposta do usuário assim que ela estiver disponível
            callback.accept(resposta);
        });
    }
}

