//  HERANÇA
// A classe Carro "herda" todos os atributos e métodos da classe Veiculo.
// Um Carro É um Veiculo.
public class Carro extends Veiculo {
    private int tamanho_porta_malas;
    // Construtor que chama o construtor da classe mãe (super)
    public Carro(String marca, String modelo) {
        super(marca, modelo);
    }
    
    // Implementação obrigatória do método abstrato da classe mãe
    @Override
    public void emitirSom() {
        System.out.println(getModelo() + " faz: Bibi!");
    }
    
    public void setPortaMalas(int PortaMalas){
        this.tamanho_porta_malas = PortaMalas;
    }
    
    public int getPortaMalas() {
        return tamanho_porta_malas;
    }
}