
public class Caminhao extends Veiculo {
    private String carreta;
    
 
    public Caminhao(String marca, String modelo){
        super(marca,modelo);
    }
    
    @Override
    public void emitirSom() {
        System.out.println(getModelo() + "Faz: foonfoon");
    }
    public String getCarreta(){
        return carreta;
    }
    public void setCarreta(String Carreta){
        this.carreta = Carreta;
    }
    
}
