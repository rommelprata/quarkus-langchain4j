package apprps.com;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClasseChamada {

    public String metodoChamado(String recebe){
        System.out.println("estou no metodo que foi chamado recebendo o parametro -> "+ recebe);
        return "Retornando informações tratadas no metodo e o paramtro que foi recebido = "+ recebe;
    }
}
