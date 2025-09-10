import java.util.ArrayList;
import java.util.List;

public class Garagem {

    public static void main(String[] args) {
        // Criando instâncias (objetos) das classes concretas
        Carro meuFusca = new Carro("Volkswagen", "Fusca");
        Motocicleta minhaHarley = new Motocicleta("Harley-Davidson", "Fat Boy");

        // --- Demonstração do Polimorfismo ---
        System.out.println("--- DEMONSTRAÇÃO DO POLIMORFISMO ---");

        //  POLIMORFISMO
        // Podemos tratar objetos de diferentes classes (Carro, Motocicleta)
        // de forma uniforme, como se fossem todos do tipo "Veiculo".
        List<Veiculo> veiculosNaGaragem = new ArrayList<>();
        veiculosNaGaragem.add(meuFusca);
        veiculosNaGaragem.add(minhaHarley);

        // O mesmo método 'emitirSom()' é chamado em objetos diferentes,
        // mas cada um executa a sua própria implementação.
        for (Veiculo v : veiculosNaGaragem) {
            System.out.print("O veículo " + v.getModelo() + " está na garagem. O som dele é: ");
            v.emitirSom(); // A "mágica" do polimorfismo acontece aqui!
        }
        
        System.out.println("\n--- DEMONSTRAÇÃO DE MÉTODOS HERDADOS ---");
        
        // Usando métodos que foram definidos em Veiculo e herdados
        meuFusca.acelerar(50);
        minhaHarley.acelerar(80);
        meuFusca.frear(20);
    }
}