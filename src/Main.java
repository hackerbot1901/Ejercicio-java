import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Simulacion de clientes*/
        Cliente giancarlo = new Cliente("Giancarlo");
        giancarlo.adoptar(new Perro("Firulais", 10, 2.10, new Raza("Pequines")));
        Cliente carlos = new Cliente("Carlos");
        ArrayList<Cliente> registroClientes = new ArrayList<>();
        registroClientes.add(giancarlo);
        registroClientes.add(carlos);
        /*Muestra el menu de ingreso*/
        mostrarMenuPrincipal();
        ArrayList<Animal> registroAnimales = new ArrayList<>();
        registroAnimales.add(new Perro("Firulais", 10, 2.10, new Raza("Pequines")));
        registroAnimales.add(new Gato("Gato", 10, 2.10, new Raza("Zeus")));
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa la acción a realizar: ");
        try {
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    Animal animalARegistrar = crearAnimal(sc);
                    registroAnimales.add(animalARegistrar);
                }
                case 2 -> buscarAnimalPorRaza(sc, registroAnimales);
                case 3 -> buscarAnimalPorTipo(sc, registroAnimales);
                case 4 -> buscarAnimalPorEdad(sc, registroAnimales);
                case 5 -> buscarClientes(sc, registroClientes);
                default -> System.out.println("Opción no válida");
            }


        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor numérico válido.");
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("********        REGISTRO REFUGIO ANIMALES       ********");
        String[] opciones = {
                ". Registrar la adopción de los animales",
                ". Buscar animales por raza e imprimir los datos",
                ". Buscar animales por tipo de animal (perro, gato, hámster) e imprimir los datos",
                ". Buscar los animales de una edad específica e imprimir los datos",
                ". Buscar los clientes que han adoptado un animal e imprimir los datos\n"
        };
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + opciones[i]);
        }
    }

    private static void buscarClientes(Scanner sc, ArrayList<Cliente> registroClientes) {
        try {
            System.out.println("¿Qué criterio de búsqueda desea utilizar?");
            System.out.println("1. Por nombre de cliente");
            System.out.println("2. Por estado de adopción (adoptado/no adoptado)");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> buscarClientesPorNombre(sc, registroClientes);
                case 2 -> buscarClientesPorEstadoAdopcion(sc, registroClientes);
                default -> System.out.println("Opción no válida");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor numérico válido.");
        }
    }

    private static void buscarClientesPorNombre(Scanner sc, ArrayList<Cliente> registroClientes) {
        try {
            System.out.println("Introduce el nombre del cliente a buscar: ");
            String nombreBuscado = sc.next();

            for (Cliente cliente : registroClientes) {
                if (cliente.getNombreCliente().equalsIgnoreCase(nombreBuscado)) {
                    System.out.println("Cliente encontrado: " + cliente);
                    return;
                }
            }

            System.out.println("No se encontró ningún cliente con el nombre proporcionado.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor válido.");
        }
    }

    private static void buscarClientesPorEstadoAdopcion(Scanner sc, ArrayList<Cliente> registroClientes) {
        try {
            System.out.println("¿Desea buscar clientes adoptados o no adoptados? (1. Adoptados / 2. No adoptados)");
            int opcionEstado = sc.nextInt();

            boolean adoptado = (opcionEstado == 1);

            ArrayList<Cliente> clientesPorEstado = new ArrayList<>();

            for (Cliente cliente : registroClientes) {
                if (cliente.isAdoptado() == adoptado) {
                    clientesPorEstado.add(cliente);
                }
            }

            if (!clientesPorEstado.isEmpty()) {
                System.out.println("Clientes encontrados:");
                for (Cliente cliente : clientesPorEstado) {
                    System.out.println(cliente);
                }
            } else {
                System.out.println("No se encontró ningún cliente con el estado de adopción proporcionado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor numérico válido.");
        }
    }


    private static void buscarAnimalPorEdad(Scanner sc, ArrayList<Animal> registroAnimales) {
        try {
            System.out.println("Introduce la edad deseada: ");
            int edadDeseada = sc.nextInt();
            ArrayList<Animal> animalesPorEdad = new ArrayList<>();
            for (Animal animal : registroAnimales) {
                if (animal.getEdad() == edadDeseada) {
                    animalesPorEdad.add(animal);
                }
            }
            if (!animalesPorEdad.isEmpty()) {
                System.out.println("Animales con la edad deseada:");
                for (Animal animal : animalesPorEdad) {
                    System.out.println(animal);
                }
            } else {
                System.out.println("No hay animales con la edad deseada.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor numérico válido.");
        }
    }

    private static void buscarAnimalPorTipo(Scanner sc, ArrayList<Animal> registroAnimales) {
        try {
            mostrarOpcionesDeAnimales();
            int tipoAnimalEscogido = sc.nextInt();
            ArrayList<Animal> animalesDelTipo = new ArrayList<>();
            for (Animal animal : registroAnimales) {
                if (tipoAnimalEscogido == 1 && animal instanceof Perro) {
                    animalesDelTipo.add(animal);
                } else if (tipoAnimalEscogido == 2 && animal instanceof Gato) {
                    animalesDelTipo.add(animal);
                } else if (tipoAnimalEscogido == 3 && animal instanceof Hamster) {
                    animalesDelTipo.add(animal);
                }
            }
            if (!animalesDelTipo.isEmpty()) {
                System.out.println("Animales del tipo seleccionado:");
                for (Animal animal : animalesDelTipo) {
                    System.out.println(animal);
                }
            } else {
                System.out.println("No hay animales del tipo seleccionado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor numérico válido.");
        }
    }


    private static void buscarAnimalPorRaza(Scanner sc, ArrayList<Animal> animalesRegistrados) {
        try {
            System.out.print("Ingrese la raza a buscar: ");
            String raza = sc.next();
            for (Animal animal : animalesRegistrados) {
                if (animal.getRaza().getNombreRaza().equalsIgnoreCase(raza)) {
                    System.out.println(animal);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor válido.");
        }
    }

    private static Animal crearAnimal(Scanner sc) {
        try {
            mostrarOpcionesDeAnimales();
            int tipoAnimalEscogido = sc.nextInt();
            System.out.print("Nombre: ");
            String nombre = sc.next();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            System.out.print("Peso: ");
            double peso = sc.nextDouble();
            System.out.print("Raza: ");
            String raza = sc.next();
            Animal animal = null;
            switch (tipoAnimalEscogido) {
                case 1 -> animal = new Perro(nombre, edad, peso, new Raza(raza));
                case 2 -> animal = new Gato(nombre, edad, peso, new Raza(raza));
                case 3 -> animal = new Hamster(nombre, edad, peso, new Raza(raza));
                default -> System.out.println("Opción no válida");
            }
            return animal;
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor válido.");
            return null;
        }
    }

    private static void mostrarOpcionesDeAnimales() {
        try {
            String[] tipoAnimal = {"PERRO", "GATO", "HAMSTER"};
            System.out.println("¿QUÉ TIPO DE ANIMAL ES?: ");
            for (int i = 0; i < tipoAnimal.length; i++) {
                System.out.println((i + 1) + tipoAnimal[i]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor válido.");
        }
    }

}