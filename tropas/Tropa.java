
package tropas;


public class Tropa {
    //Atributos generales
    protected String tipo;
    protected String debilidad;
    protected String fortaleza;
    protected double danio;

    //Constructores
    
    public Tropa() {
    }

    
    public Tropa(String tipo, String debilidad, String fortaleza, double danio) {
        this.tipo = tipo;
        this.debilidad = debilidad;
        this.fortaleza = fortaleza;
        this.danio = danio;
    }
    
    //Metodos
    //Para ganarle a una tropa hay que saber contra quien me enfrento
    //Si una tropa enemiga es debil contra la fortaleza de nuestra tropa entonces ganara nuestra tropa
    public boolean Ganar_a(Tropa enemiga){
        
        if (enemiga.getDebilidad().equals(this.fortaleza)) {
            return true;
        } else {
        
            return false;
        
        }
        
        
    }
    
    //Es redundante con ganar, pero es mejor para leer las batallas.
    public boolean Pierde_con(Tropa enemiga){
        
        if (this.debilidad.equals(enemiga.getFortaleza())) {
            return true;
        } else {
        
            return false;
        
        }
        
        
    }
    
    public void Mostrarestadisticas(){
    //Sout tienen que ser reemplazados por la gui, podrian ser labels, iconos o imagenes, etc.
        System.out.println("---Tropa:---");
        System.out.println("Tipo: "+ this.getTipo());
        System.out.println("Debilidad: "+ this.getDebilidad());
        System.out.println("Fortaleza: "+ this.getFortaleza());
        System.out.println("Danio: "+ this.getDanio());
    
    }
    
    
    
    //Getters & Setters

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

    public void setDaño(double danio) {
        this.danio = danio;
    }
  
    
    
    
}
