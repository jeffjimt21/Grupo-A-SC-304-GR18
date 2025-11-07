
package tropas;

//Se usa herencia, pero se define desde ya los atributos, porque el usuario si quiere un arquero
//Entonces ese arquero pues necesita estar definido
public class Arquero extends Tropa {

    public Arquero() {
    }

    public Arquero(String tipo, String debilidad, String fortaleza, double danio) {
        super("Arquero", "Caballero", "Mago", 1);
    }
    
    //Metodos?, pues una tropa puede atacar, aunque sean mensajes, puesto que el daño se da luego
    
    public static void Atacar(){
    //Cambiar sout, por algun gui, label , etc.
        System.out.println("Disparando flecha");
    
    
    }
    
    
}
