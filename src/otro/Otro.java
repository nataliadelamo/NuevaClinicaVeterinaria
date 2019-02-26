package otro;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author xavier
 */
public class Otro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //ATRIBUTOS
        int numero = 5;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Mascota> listaMascotas = new ArrayList<>();
        ArrayList<Persona> clientes = new ArrayList<>();

        //Clientes iniciales
        Persona pepa = new Persona("Pepa", "Navarro García", "21333412P", 61);
        clientes.add(pepa);
        Persona luna = new Persona("Luna", "Guerrero Cano", "25355471X", 46);
        clientes.add(luna);
        Persona blanca = new Persona("Blanca", "Romero Cano", "04501992H", 32);
        clientes.add(blanca);

        //Mascotas iniciales
        //String nombre, int edad, String raza, Persona duenyo, float peso
        Cerdo oink1 = new Cerdo("Valiente", 2, "Vietnamita", blanca, 12.50f);
        listaMascotas.add(oink1);
        Cerdo oink2 = new Cerdo("Babe", 10, "Europeo", blanca, 100.75f);
        listaMascotas.add(oink2);

        //Tiene toda la pinta de ser un método
        do {
            mostrarMenu();
            try {
                numero = Integer.parseInt(teclado.readLine());
            } catch (IOException e) {
                System.err.println("Vaya, un error de entrada/salida... qué raro");
            } catch (NumberFormatException e) {
                System.err.println("Has causado una excepción porque no has entrado un número entero, gracias");
            }

            //Otros métodos quizás?
            switch (numero) {
                case 1:
            if (clienteNuevo(teclado, clientes)) {
                return;
            }
                    break;

                case 2:
                    //CLIENTE EXISTENTE, PRIMERO LO HABREMOS LISTADO CON LA OPCIÓN 3
                    System.out.println("PRIMERO INTRODUCIMOS EL CLIENTE");
                    System.out.println("Introduce el número de cliente");
                    int indice = 0;
                    try {
                        indice = Integer.parseInt(teclado.readLine());
                    } catch (Exception e) {
                        System.err.println("Has causado una excepción porque no has entrado un número entero, gracias");
                        return;
                    }
                    Persona p2 = null;
                    try {
                        p2 = clientes.get(indice);
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Has causado una excepción porque el cliente no existe");
                        return;
                    }

            if (nuevaMascota(teclado, p2, listaMascotas)) {
                return;
            }
                    break;

                case 3:
                    for (Persona p : clientes) {
                        System.out.println("Número Cliente: " + clientes.indexOf(p) + " --- DATOS: " + p.toString());
                    }
                    break;
                case 4:
                    for (Mascota m : listaMascotas) {
                        System.out.println("Número Mascota: " + listaMascotas.indexOf(m) + " --- DATOS: " + m.toString());
                    }
                    break;

            }

        } while (numero != 5);

    }

     /**
     * Método para crear una mascota nueva
     *
     * @param teclado
     * @param p2 objeto de persona
     *@param listaMascotas lista de macotas
     * 
     */
    public static boolean nuevaMascota(BufferedReader teclado, Persona p2, ArrayList<Mascota> listaMascotas) throws IOException {
        //MASCOTA NUEVA
        String nombre;
        int edad;
        
        System.out.println("AHORA INTRODUCIMOS LA MASCOTA");
        System.out.println("Introduce el nombre");
        nombre = teclado.readLine();
        System.out.println("Introduce la raza");
        String raza = teclado.readLine();
        System.out.println("Introduce la edad");
        edad = 0;
        try {
            edad = Integer.parseInt(teclado.readLine());
        } catch (Exception e) {
            System.err.println("Has causado una excepción porque no has entrado un número entero, gracias");
            return true;
        }
        int indiceM = 0;
        System.out.println("Introduce el tipo de mascota");
        System.out.println("1. Cerdo");
        try {
            indiceM = Integer.parseInt(teclado.readLine());
        }catch (IOException e) {
            System.err.println("Vaya, un error de entrada/salida... qué raro");
        } catch (NumberFormatException e) {
            System.err.println("Has causado una excepción porque no has entrado un número entero, gracias");
            return true;
        }
        Mascota m1;
        switch (indiceM) {
            case 1:
                float peso = 0.0f;
                System.out.println("Introduce el peso del cerdo o la cerda");
                try {
                    peso = Float.parseFloat(teclado.readLine());
                } catch (Exception e) {
                    System.err.println("Has causado una excepción porque no has entrado un número entero, gracias");
                    return true;
                }
                m1 = new Cerdo(nombre, edad, raza, p2, peso);
                break;
            default:
                m1 = new Mascota(nombre, edad, raza, p2);
                break;
        }
        listaMascotas.add(m1);
        return false;
    }

     /**
     * Método para crear una mascota nueva
     *
     * @param teclado
     *@param clientes lista de clientes
     * 
     */
    public static boolean clienteNuevo(BufferedReader teclado, ArrayList<Persona> clientes) throws IOException {
        //CLIENTE NUEVO
        System.out.println("INTRODUCIMOS EL CLIENTE");
        System.out.println("Introduce el nombre");
        String nombre = teclado.readLine();
        System.out.println("Introduce los apellidos");
        String apellidos = teclado.readLine();
        System.out.println("Introduce el DNI");
        String dni = teclado.readLine();
        System.out.println("Introduce la edad");
        int edad = 0;
        try {
            edad = Integer.parseInt(teclado.readLine());
        } catch (Exception e) {
            System.err.println("Has causado una excepción porque no has entrado un número entero, gracias");
            return true;
        }
        Persona p1 = new Persona(nombre, apellidos, dni, edad);
        clientes.add(p1);
        return false;
    }

     /**
     * Método que muestra el menú
     *
     * 
     */
    public static void mostrarMenu() {
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Añadir un nuevo cliente");
        System.out.println("2. Añadir una nueva mascota para un cliente existente");
        System.out.println("3. Mostrar todos los dueños");
        System.out.println("4. Mostrar todas las mascotas");
        System.out.println("5. Salir");
    }
}
