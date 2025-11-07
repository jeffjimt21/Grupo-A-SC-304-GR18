
package tropas;

//Se usa herencia, pero se define desde ya los atributos, porque el usuario si quiere un arquero
//Entonces ese arquero pues necesita estar definido
public class Mago extends Tropa {

    public Mago() {
    }

    public Mago(String tipo, String debilidad, String fortaleza, double danio) {
        super("Mago", "Arquero", "Caballero", 1.5);
    }
    
    public static void Atacar(){
    //Cambiar sout, por algun gui, label , etc.
        System.out.println("Lanzando hechizo!");
 
    }
    
    
}
