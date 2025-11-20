
package tropas;

//Se usa herencia, pero se define desde ya los atributos, porque el usuario si quiere un arquero
//Entonces ese arquero pues necesita estar definido
public class Mago extends Tropa {

    public Mago() {
        super("Mago", "Arquero", "Caballero", 1.5);
    }
    
    public static void Atacar(){
    //Cambiar sout, por algun gui, label , etc.
        System.out.println("Lanzando hechizo!");
 
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
