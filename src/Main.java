import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;
        Queue cola = new Queue();
        Pila pila = new Pila();
        // Menú principal del sistema operativo simulado.
        while (seguir) {
            try {
                // Menú principal.
                System.out.println("\nBienvenido a AACUDYN");
                System.out.print("\nA qué departamento ingresarás? \n1. Procesos\n2. Mantenimiento\n3. Terminar turno\n");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion < 1 || opcion > 4) {
                    throw new IllegalArgumentException("Valor fuera del rango.");
                }
                switch (opcion) {
                    // Menú interno para utilizar las funciones de la lista de cola.
                    case 1:
                        boolean submenu1 = true;
                        while (submenu1) {
                            try {
                                System.out.print("\n¿Qué quieres hacer?\n1. Agregar proceso\n2. Atender proceso \n3. Ver lista de procesos\n4. Salir de este menú\n ");
                                int datoElegido = scanner.nextInt();
                                scanner.nextLine();
                                if (datoElegido < 1 || datoElegido > 4) {
                                    throw new IllegalArgumentException("Valor fuera del rango.");
                                }
                                switch (datoElegido) {
                                    case 1:
                                        System.out.print("\nLISTA DE TAREAS:\n1. Iniciar ciclo de inyección de molde\n2. Empaque y etiquetado de lote \n3. Preparar resina seca\n4. Salir de este menú\n");
                                        int tarea = scanner.nextInt();
                                        scanner.nextLine();
                                        if (tarea < 1 || tarea > 4) {
                                            throw new IllegalArgumentException("Valor fuera del rango.");
                                        }
                                        switch (tarea) {
                                            case 1:
                                                System.out.print("Molde a inyectar: ");
                                                String molde = scanner.nextLine();
                                                if (molde.isBlank()){
                                                    throw new IllegalArgumentException("Campo en blanco, intenta de nuevo.");
                                                }
                                                cola.enqueue("Ciclo de inyección de molde " + molde);
                                                System.out.println("Tarea añadida de molde "+ molde);
                                                break;
                                            case 2:
                                                System.out.print("Número de lote: ");
                                                int lote = scanner.nextInt();
                                                scanner.nextLine();

                                                cola.enqueue("Empaque y etiquetado de lote " + lote);
                                                System.out.println("Tarea añadida de lote "+ lote);
                                                break;
                                            case 3:
                                                cola.enqueue("Preparar resina");
                                                System.out.println("Tarea añadida");
                                                break;
                                            case 4:
                                                System.out.println("Devolviéndote al menú anterior...");
                                                break;

                                        }
                                        break;
                                    case 2:
                                        System.out.println("\nAtendiendo tarea: " + cola.dequeue());
                                        System.out.println("Lista de procesos actualizada:");
                                        cola.display();
                                        break;
                                    case 3:
                                        System.out.println("Tarea próxima a realizar "+ cola.peek());
                                        cola.display();
                                        break;
                                    case 4:
                                        System.out.println("Devolviéndote al menú principal...");
                                        submenu1 = false;
                                        break;
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (InputMismatchException e) {
                                System.out.println("Ingresa un número válido.");
                                scanner.nextLine();
                            }
                        }
                        break;
                    // Menú interno para utilizar las funciones de la lista de pila.
                    case 2:
                        boolean submenu2 = true;
                        while (submenu2) {
                            try {
                                System.out.print("\n¿Qué quieres hacer?\n1. Agregar tarea de mantenimiento\n2. Atender falla \n3. Ver lista de fallas\n4. Salir de este menú\n ");
                                int datoElegido = scanner.nextInt();
                                scanner.nextLine();
                                if (datoElegido < 1 || datoElegido > 4) {
                                    throw new IllegalArgumentException("Valor fuera del rango.");
                                }
                                switch (datoElegido) {
                                    case 1:
                                        System.out.print("\nLISTA DE TAREAS DE URGENCIA:\n1. Ajustar parámetros de temperatura\n2. Desobstaculizar máquina \n3. Reparar fuga en el sistema hidráulico\n4. Otro \n5. Salir de este menú\n");
                                        int tarea = scanner.nextInt();
                                        scanner.nextLine();
                                        if (tarea < 1 || tarea > 5) {
                                            throw new IllegalArgumentException("Valor fuera del rango.");
                                        }
                                        switch (tarea) {
                                            case 1:
                                                System.out.print("Molde a revisar: ");
                                                String molde = scanner.nextLine();
                                                if (molde.isBlank()){
                                                    throw new IllegalArgumentException("Campo en blanco, intenta de nuevo.");
                                                }
                                                pila.push("Ajustar parámetros de temperatura en molde "+ molde);
                                                System.out.println("Tarea añadida para mantenimiento");
                                                break;
                                            case 2:
                                                System.out.print("Máquina obstruida: ");
                                                String maquina = scanner.nextLine();
                                                if (maquina.isBlank()){
                                                    throw new IllegalArgumentException("Campo en blanco, intenta de nuevo.");
                                                }
                                                pila.push("Desobstaculizar máquina " + maquina);
                                                System.out.println("Máquina " + maquina+" será revisada");
                                                break;
                                            case 3:
                                                System.out.print("Número de prensa en el que se encuentra la fuga: ");
                                                int prensa = scanner.nextInt();
                                                scanner.nextLine();
                                                pila.push("Reparar fuga en el sistema hidráulico de prensa "+ prensa);
                                                System.out.println("Se atenderá lo antes posible.");
                                                break;
                                            case 4:
                                                System.out.print("Reporte: ");
                                                String reporte = scanner.nextLine();
                                                if (reporte.isBlank()){
                                                    throw new IllegalArgumentException("Campo en blanco, intenta de nuevo.");
                                                }
                                                pila.push(reporte);
                                                break;
                                            case 5:
                                                System.out.println("Devolviéndote al menú anterior...");
                                                break;
                                        }
                                        break;
                                    case 2:
                                        System.out.println("\nAtendiendo falla: " + pila.peek());
                                        pila.pop();
                                        System.out.println("Lista de procesos actualizada:");
                                        pila.display();
                                        break;
                                    case 3:
                                        System.out.println("Última falla reportada: "+ pila.peek());
                                        pila.display();
                                        break;
                                    case 4:
                                        System.out.println("Devolviéndote al menú principal...");
                                        submenu2 = false;
                                        break;
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (InputMismatchException e) {
                                System.out.println("Ingresa el tipo de dato adecuado.");
                                scanner.nextLine();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("¡Hoy hiciste un buen trabajo!...");
                        seguir = false;
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ingresa un número adecuado.");
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un número.");
                scanner.nextLine();
            }
        }}}
