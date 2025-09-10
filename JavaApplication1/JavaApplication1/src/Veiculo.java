// ABSTRAÇÃO
// A classe Veiculo é abstrata porque representa o conceito de um veículo,
// mas não um veículo específico. Ninguém compra "um veículo", compra um carro, uma moto, etc.
// Ela define os atributos e métodos comuns a todos os veículos.
public abstract class Veiculo {

    // ENCAPSULAMENTO
    // Os atributos são "private" para proteger os dados.
    // O acesso a eles só pode ser feito através dos métodos públicos (getters e setters).
    private String marca;
    private String modelo;
    private int velocidade;

    // Construtor da classe mãe
    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = 0; // Todo veículo começa parado.
    }

    // Métodos concretos, comuns a todos os veículos
    public void acelerar(int incremento) {
        this.velocidade += incremento;
        System.out.println(modelo + " acelerou para " + velocidade + " km/h.");
    }

    public void frear(int decremento) {
        this.velocidade -= decremento;
        System.out.println(modelo + " freou para " + velocidade + " km/h.");
    }

    // ABSTRAÇÃO (Método Abstrato)
    // Todo veículo emite um som, mas cada um emite de forma diferente.
    // Forçamos as classes filhas a implementarem este método.
    public abstract void emitirSom();

    // --- MÉTODOS DE ACESSO (GETTERS E SETTERS) ---
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVelocidade() {
        return velocidade;
    }
    
    public void setModelo(String pModelo) {
        this.modelo=pModelo;
    }
    
//    public void setVelocidade(int incremento) {;
//        if (incremento < 0 &&
//                (this.velocidade + incremento) < 0{
//            return;
//        }
//        this.velocidade += incremento;
//    }
}