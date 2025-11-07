
package tropas;

//Se usa herencia, pero se define desde ya los atributos, porque el usuario si quiere un arquero
//Entonces ese arquero pues necesita estar definido
public class Caballero extends Tropa {

    public Caballero() {
    }

    public Caballero(String tipo, String debilidad, String fortaleza, double danio) {
        super("Caballero", "Mago", "Arquero", 2);
    }
    
     
    public static void Atacar(){
    //Cambiar sout, por algun gui, label , etc.
        System.out.println("Agh, usando mi espada!");
 
    }
    
    
}
