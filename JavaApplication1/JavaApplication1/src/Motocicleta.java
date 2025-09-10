//  HERANÇA
// A classe Motocicleta também herda de Veiculo.
public class Motocicleta extends Veiculo {
    private boolean parabrisa;
    public Motocicleta(String marca, String modelo) {
        super(marca, modelo);
    }

    // Implementação obrigatória e específica para a Motocicleta
    @Override
    public void emitirSom() {
        System.out.println(getModelo() + " faz: Vrummm!");
    }
    
    public void setParabrisa(boolean parabrisa) {
        this.parabrisa = parabrisa;
    }
    
    public boolean getParabrisa(){
        return parabrisa;
    }
}