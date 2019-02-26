package otro;

/**
 *
 * @author xavier
 */
public class Gato extends Mascota {
    //ATRIBUTOS

    private float gradosalvaje;

    //CONSTRUCTOR
    /**
     * Constructor de la clase Gato que hereda de Mascota
     *
     * @param nombre
     * @param edad
     * @param raza
     * @param duenyo
     * @param gradosalvaje
     */
    public Gato(String nombre, int edad, String raza, Persona duenyo, float gradosalvaje) {
        super(nombre, edad, raza, duenyo);
        this.gradosalvaje = gradosalvaje;
    }

    //MÉTODOS SETTER & GETTER

    /**
     * @return the gradosalvaje
     */
    public float getGradosalvaje() {
        return gradosalvaje;
    }

    /**
     * @param gradosalvaje the gradosalvaje to set
     */
    public void setGradosalvaje(float gradosalvaje) {
        this.gradosalvaje = gradosalvaje;
    }

}
