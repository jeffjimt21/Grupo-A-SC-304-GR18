
package tropas;

//Se usa herencia, pero se define desde ya los atributos, porque el usuario si quiere un arquero
//Entonces ese arquero pues necesita estar definido
public class Arquero extends Tropa {

 
    public Arquero() {
        super("Arquero", "Caballero", "Mago", 1.0);
    }
    
    //Metodos?, pues una tropa puede atacar, aunque sean mensajes, puesto que el daño se da luego
    
    public static void Atacar(){
    //Cambiar sout, por algun gui, label , etc.
        System.out.println("Disparando flecha");
    
    
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDebilidad() {
        return debilidad;
    }

    public void setDebilidad(String debilidad) {
        this.debilidad = debilidad;
    }

    public String getFortaleza() {
        return fortaleza;
    }

    public void setFortaleza(String fortaleza) {
        this.fortaleza = fortaleza;
    }

    public double getDanio() {
        return danio;
    }

    public void setDanio(double danio) {
        this.danio = danio;
    }
    
    
    
    
}
