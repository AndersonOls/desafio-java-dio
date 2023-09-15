package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Mirela", "Daniela"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }

    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso");

        }while (continuarTentando && tentativasRealizadas<3);

        if (atendeu)
            System.out.println("Conseguimos contao com " + candidato + " na " + tentativasRealizadas +" tentativa.");
        else
            System.out.println("Não conseguimos contao com " + candidato + " numero máximo de tentivas " + tentativasRealizadas +" realizada.");

    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Mirela", "Daniela"};
        System.out.println("Imprimindo a lista de candidatos indformando o indice do elemento");
        for(int i=0; i<candidatos.length; i++ ){
            System.out.println("O candidato de numero " + (i+1) + " é o " + candidatos[i]);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Mirela", "Daniela"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados <5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretrnedido();

            System.out.println("O candidato " + candidato + " solicitou o salario de: " + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }else{
                System.out.println("O candidato " + candidato + " não foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretrnedido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
        System.out.println("Ligar para o candidato");
        } else if (salarioBase==salarioPretendido) {
            System.out.println("Ligar com contra proposta");
        }else {
            System.out.println("Aguardando demais candidatos");
        }
    }
}
