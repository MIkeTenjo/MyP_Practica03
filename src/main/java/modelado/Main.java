package modelado;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import modelado.ninja.Fabrica.FabricaNinjaAspirante;
import modelado.ninja.Fabrica.FabricaNinjaVoluntario;
import modelado.ninja.colecciones.ColeccionNinjasAspirantes;
import modelado.ninja.colecciones.ColeccionNinjasVoluntarios;
import modelado.ninja.enumeraciones.Clan;
import modelado.ninja.enumeraciones.RangoNinja;
import modelado.ninja.gruponinja.Grupo;
import modelado.ninja.producto.Ninja;
import modelado.ninja.producto.NinjaVoluntario;
import modelado.paquete.EncargadoPaquetes;
import modelado.paquete.PaqueteConstructor;
import modelado.paquete.PaqueteConstructorConcreto;
import modelado.paquete.PaqueteHerramientas;

/**
 * Clase que representa el flujo principal del programa.
 * Main Es la clase con el flujo de la creación de grupos dado una colección de Ninjas aspirantes, Ninjas Voluntarios, paquetes
 * de herramientas Ninja que se van creando en el flujo del programa.
 */
public class Main {

    /*Nombres concretos para los Ninjas Asistentes. */
    private static final List<String> nombresNinjasAsp = List.of("Amadeo", "Eudora", "Cassian", "Melisandra",
                                                                 "Silvano", "Isolda", "Orestes", "Aurelia");

    /*Nombres concretos para los Ninjas Voluntarios. */                                                             
    private static final List<String> nombresNinjasVol = List.of("Leocadia", "Beltrán", "Calista",
                                                                 "Tiziano", "Cyrene", "Valeriano",
                                                                 "Ondina", "Zephyr");

    /*Apellidos concretos para los Ninjas Asistentes. */
    private static final List<String> apellidosNinjaAsp = List.of("Valldeperas", "Mandujano", "Rocafort",
                                                                   "Samaniego", "Zaldívar", "Escarrá",
                                                                   "Benavente", "Mendieta");

    /*Apellidos concretos para los Ninjas Voluntarios. */
    private static final List<String> apellidosNinjaVol = List.of("Corcuera", "Gaztañaga", "Santisteban",
                                                                  "Balaguer", "Montemayor", "Irarrázaval",
                                                                  "Galarza", "Arizmendi");
    /*Atributo Random para cualquier caso aleatorio. */
    private static final Random random = new Random();

    /*Atributo para las entradas del Usuario. */
    private static final Scanner scan = new Scanner(System.in);
    
    /**
     * Método que generá nombres de la forma: Nombre + APellido.
     * El método no debe recibir un argumento @param cantidad negativo ya que se considerará como 0. Tampoco
     * un valor mayor al máximo valor de combinaciones entre la lista de nombres y la lista de apellidos sin 
     * repetir.
     * 
     * Retorna un conjunto de Nombres dado la lista de nombres y la lista de apellidos con un tamaño iguál a la
     * cantidad requerida como argumento.
     * @param nombres La lista de nombres a utilizar para la generación de Nombres.
     * @param apellidos La lista de apellidos a utilizar para la generación de apellidos. 
     * @param cantidad La cantidad de Nombres con apellidos requerida.
     * @return Un conjunto de Nombres con apellidos de la longitud de la cantidad requerida.
     */
    private static Set<String> generarNombres(List<String> nombres, List<String> apellidos, int cantidad) {

        int maxCombinaciones = nombres.size() * apellidos.size();

        if (cantidad < 0) {
            cantidad = 0;
        }

        if (cantidad > maxCombinaciones) {
            cantidad = maxCombinaciones;
        }

        Set<String> nombresGenerados = new HashSet<>();

        while (nombresGenerados.size() < cantidad) {

            String nombre = nombres.get(random.nextInt(nombres.size()));

            String apellido = apellidos.get(random.nextInt(apellidos.size()));

            String nombreCompleto = nombre + " " + apellido;

            nombresGenerados.add(nombreCompleto);
        }

        return nombresGenerados;
    }

    /**
     * Método que crea la colección de ninjas aspirantes a partir de un conjunto de nombres.
     * Asigna de forma aleatoria un clan ninja y atributos como la edad y el nivel de habilidad dentro
     * de los rangos válidos para un aspirante, estableciendo su rango como SIN_RANGO.
     * 
     * Retorna la colección con los objetos Ninja aspirantes creados.
     * @param nombresAspirantes El conjunto de nombres completos a asignar a cada aspirante.
     * @return Una colección de ninjas aspirantes.
     */
    private static ColeccionNinjasAspirantes crearNinjasAspirantes(Set<String> nombresAspirantes) {
        FabricaNinjaAspirante fna = new FabricaNinjaAspirante();
        ColeccionNinjasAspirantes cna = new ColeccionNinjasAspirantes();

        for (String nombre : nombresAspirantes) {
            Clan clan;
            int clanEscogido = random.nextInt(1, 6);

            switch (clanEscogido) {
                case 1:
                    clan = Clan.FUCHIHA;
                    break;
                case 2:
                    clan = Clan.OSOMAKI;
                    break;
                case 3:
                    clan = Clan.NACA;
                    break;
                case 4:
                    clan = Clan.MORTALIKA;
                    break;
                case 5:
                    clan = Clan.AKIPICHI;
                    break;
                default:
                    clan = Clan.OSOMAKI;
                    break;
            }

            Ninja ninjaAspirante = fna.crearNinja(nombre, random.nextInt(17, 91), clan, random.nextInt(1, 4), RangoNinja.SIN_RANGO);
            cna.agregar(ninjaAspirante);
        }

        return cna;
    }

    /**
     * Método que crea la colección de ninjas voluntarios a partir de un conjunto de nombres.
     * Asigna aleatoriamente un clan, una edad, un nivel de habilidad avanzado y un rango ninja
     * a cada uno de los líderes voluntarios.
     * 
     * Retorna la colección de ninjas voluntarios configurados con sus respectivos atributos.
     * @param nombresVoluntarios El conjunto de nombres completos a asignar a cada voluntario.
     * @return Una colección de ninjas voluntarios.
     */
    private static ColeccionNinjasVoluntarios crearNinjasVoluntarios(Set<String> nombresVoluntarios) {
        FabricaNinjaVoluntario fnv = new FabricaNinjaVoluntario();
        ColeccionNinjasVoluntarios cnv = new ColeccionNinjasVoluntarios(nombresVoluntarios.size());

        for (String nombre : nombresVoluntarios) {
            Clan clan;
            int clanEscogido = random.nextInt(1, 6);

            switch (clanEscogido) {
                case 1:
                    clan = Clan.FUCHIHA;
                    break;
                case 2:
                    clan = Clan.OSOMAKI;
                    break;
                case 3:
                    clan = Clan.NACA;
                    break;
                case 4:
                    clan = Clan.MORTALIKA;
                    break;
                case 5:
                    clan = Clan.AKIPICHI;
                    break;
                default:
                    clan = Clan.OSOMAKI;
                    break;
            }

            RangoNinja rango;
            int rangoEscogido = random.nextInt(1, 4);

            switch (rangoEscogido) {
                case 1:
                    rango = RangoNinja.GENIN;
                    break;
                case 2:
                    rango = RangoNinja.CHUNIN;
                    break;
                case 3:
                    rango = RangoNinja.JONIN;
                    break;
                default:
                    rango = RangoNinja.CHUNIN;
                    break;
            }

            Ninja ninjaVoluntario = fnv.crearNinja(nombre, random.nextInt(17, 91), clan, random.nextInt(4, 7), rango);
            cnv.agregar(ninjaVoluntario);
        }

        return cnv;
    }

    /**
     * Método que conforma los grupos ninjas vinculando a cada ninja voluntario con su cupo requerido de aspirantes.
     * El número de aspirantes solicitados depende del rango del voluntario. En caso de que queden aspirantes o
     * voluntarios sin asignar por falta de integrantes, emite un aviso oficial con una disculpa mostrando los detalles
     * de los ninjas sobrantes.
     * 
     * Retorna la lista de grupos conformados exitosamente con sus integrantes y su paquete de herramientas.
     * @param aspirantes La colección de ninjas aspirantes disponibles para conformar los equipos.
     * @param voluntarios La colección de ninjas voluntarios que actuarán como líderes de grupo.
     * @return Una lista de objetos Grupo.
     */
    private static ArrayList<Grupo> crearGrupos(ColeccionNinjasAspirantes aspirantes, ColeccionNinjasVoluntarios voluntarios) {
        ArrayList<Grupo> gruposNinja = new ArrayList<>();
        Iterator<Ninja> iteradorAspirantes = aspirantes.iterator();
        Iterator<Ninja> iteradorVoluntarios = voluntarios.iterator();

        while (iteradorAspirantes.hasNext() && iteradorVoluntarios.hasNext()) {
            NinjaVoluntario voluntario = (NinjaVoluntario) iteradorVoluntarios.next();
            
            ColeccionNinjasAspirantes aspirantesGrupo = new ColeccionNinjasAspirantes();

            int cupoRequerido;

            switch (voluntario.getRangoNinja()) {
                case GENIN:
                    cupoRequerido = 1;
                    break;
                case CHUNIN:
                    cupoRequerido = 2;
                    break;
                case JONIN:
                    cupoRequerido = 3;
                    break;
                default:
                    throw new IllegalArgumentException("Rango ninja no válido: " + voluntario.getRangoNinja());
            }

            boolean cupoCompleto = true;

            for (int i = 0; i < cupoRequerido; i++) {
                if (iteradorAspirantes.hasNext()) {
                    aspirantesGrupo.agregar(iteradorAspirantes.next());
                } else {
                    cupoCompleto = false;
                    break; // No hay suficientes aspirantes para llenar el escuadrón
                }
            }

            // Si se llenó el cupo del voluntario, se solicita el paquete especificando el grupo y líder
            if (cupoCompleto) {
                int numeroGrupo = gruposNinja.size() + 1;
                PaqueteHerramientas paquete = elegirPaquete(scan, numeroGrupo, voluntario.getNombre());
                Grupo grupo = new Grupo(voluntario, aspirantesGrupo, paquete);
                gruposNinja.add(grupo);
            } else {
                // Si el voluntario no pudo completar su cupo por falta de aspirantes, interrumpe la asignación
                break;
            }
        }

        // 1. Avisos a los Aspirantes que se quedaron sin grupo
        if (iteradorAspirantes.hasNext()) {
            int sobrantesAsp = 0;
            System.out.println("\n════════════════════════════════════════════════════════════");
            System.out.println("       AVISO OFICIAL Y DISCULPA A LOS NINJAS ASPIRANTES     ");
            System.out.println("════════════════════════════════════════════════════════════");
            System.out.println("Estimados Aspirantes a Ninja:");
            System.out.println("Les extendemos una sincera disculpa de parte del Consejo de la Academia.");
            System.out.println("Debido a la alta demanda y al número limitado de Jefes de Grupo Voluntarios");
            System.out.println("disponibles hoy, los siguientes aspirantes no pudieron ser asignados a un equipo:\n");

            while (iteradorAspirantes.hasNext()) {
                Ninja asp = iteradorAspirantes.next();
                sobrantesAsp++;
                System.out.print(asp.getDetalles());
            }

            System.out.println("\nTotal de aspirantes en lista de espera: " + sobrantesAsp);
            System.out.println("Les instamos a continuar con su entrenamiento. Sus nombres tendrán la más alta");
            System.out.println("prioridad para la conformación de escuadrones en la próxima convocatoria.");
            System.out.println("════════════════════════════════════════════════════════════\n");
        }else if (iteradorVoluntarios.hasNext()) {
            int sobrantesVol = 0;
            System.out.println("\n════════════════════════════════════════════════════════════");
            System.out.println("       AVISO OFICIAL Y DISCULPA A LOS JEFES VOLUNTARIOS     ");
            System.out.println("════════════════════════════════════════════════════════════");
            System.out.println("Estimados Jefes de Grupo Voluntarios:");
            System.out.println("Agradecemos profundamente su disposición y vocación de servicio.");
            System.out.println("Lamentamos informarles que, debido a una insuficiencia de aspirantes");
            System.out.println("disponibles en la academia, los siguientes líderes no recibieron un escuadrón:\n");

            while (iteradorVoluntarios.hasNext()) {
                NinjaVoluntario vol = (NinjaVoluntario) iteradorVoluntarios.next();
                sobrantesVol++;
                System.out.print(vol.getDetalles());
            }

            System.out.println("\nTotal de voluntarios sin escuadrón: " + sobrantesVol);
            System.out.println("Agradecemos su tiempo. Serán reasignados a misiones individuales de rango superior.");
            System.out.println("════════════════════════════════════════════════════════════\n");
        }

        return gruposNinja;
    }

    /**
     * Método que le permite al usuario seleccionar o personalizar un paquete de herramientas ninja.
     * Utiliza un bucle iterativo controlado por try-catch para capturar excepciones por ingreso de caracteres
     * no numéricos.
     * 
     * Retorna el paquete de herramientas construido por el encargado según la elección realizada.
     * @param scanner El objeto Scanner utilizado para leer las entradas del usuario.
     * @return El paquete de herramientas para asignarse al grupo.
     */
    private static PaqueteHerramientas elegirPaquete(Scanner scanner, int numeroGrupo, String nombreLider) {
        EncargadoPaquetes encargado = new EncargadoPaquetes();
        PaqueteConstructor paquete = new PaqueteConstructorConcreto();
        PaqueteHerramientas resultado = new PaqueteHerramientas();
        boolean opcionValida = false;

        while (!opcionValida) {
            System.out.println("\n--------------------------------------------------");
            System.out.println(" SELECCIÓN DE PAQUETE DE HERRAMIENTAS - GRUPO #" + numeroGrupo);
            System.out.println(" Líder a cargo: " + nombreLider);
            System.out.println("--------------------------------------------------");
            System.out.println("1. Paquete Básico");
            System.out.println("2. Paquete Avanzado");
            System.out.println("3. Paquete Táctico");
            System.out.println("4. Paquete Personalizado");

            try {
                System.out.print("Seleccione una opción (1-4): ");
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        encargado.construirPaqueteBasico(paquete);
                        opcionValida = true;
                        resultado = paquete.obtenerResultado();
                        resultado.setTipoPaquete("Básico");
                        break;
                    case 2:
                        encargado.construirPaqueteAvanzado(paquete);
                        opcionValida = true;
                        resultado = paquete.obtenerResultado();
                        resultado.setTipoPaquete("Avanzado");
                        break;
                    case 3:
                        encargado.construirPaqueteTactico(paquete);
                        opcionValida = true;
                        resultado = paquete.obtenerResultado();
                        resultado.setTipoPaquete("Táctico");
                        break;
                    case 4:
                        System.out.println("\n[ Configuración de Paquete Personalizado ]");
                        int kunais = leerEntero(scanner, "Ingrese cantidad de Kunais: ");
                        int shurikens = leerEntero(scanner, "Ingrese cantidad de Shurikens: ");
                        int papeles = leerEntero(scanner, "Ingrese cantidad de Papeles Bomba: ");
                        int bombas = leerEntero(scanner, "Ingrese cantidad de Bombas de Humo: ");
                        int botiquines = leerEntero(scanner, "Ingrese cantidad de Botiquines: ");

                        encargado.construirPaquetePersonalizado(paquete, kunais, shurikens, papeles, bombas, botiquines);
                        opcionValida = true;
                        resultado = paquete.obtenerResultado();
                        resultado.setTipoPaquete("Personalizado");
                        break;
                    default:
                        System.out.println(" Opción fuera de rango. Por favor ingrese un número del 1 al 4.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(" Entrada no válida. Debe ingresar un número entero, no letras ni símbolos.");
                scanner.next(); 
            }
        }

        return resultado; // Retorna el paquete de herramientas construido según la elección del usuario
    }

    /**
     * Método auxiliar que lee de forma segura un número entero ingresado por el usuario.
     * Ante un tipo de dato inválido como texto o símbolos, captura la excepción {@link InputMismatchException},
     * limpia el búfer y vuelve a solicitar el valor indefinidamente hasta obtener un entero válido.
     * 
     * Retorna el número entero leído y validado.
     * @param scanner El objeto Scanner utilizado para realizar la lectura de datos.
     * @param mensaje El mensaje impreso en pantalla solicitando la cantidad deseada.
     * @return El número entero ingresado correctamente por el usuario.
     */
    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(" Entrada no válida. Ingrese una cantidad numérica.");
                scanner.next();
            }
        }
    }

    private static String determinarCampoEntrenamiento(int totalNiveles) {

        if (totalNiveles <= 7) {
            return "Valle del Dragón (Suma de habilidad: " + totalNiveles + ")";
        } else if (totalNiveles <= 11) {
            return "Bosque Sombrío (Suma de habilidad: " + totalNiveles + ")";
        } else {
            return "Montaña Espiritual (Suma de habilidad: " + totalNiveles + ")";
        }
    }
                                                            
    public static void main(String[] args) {
        System.out.println("========================================================");
        System.out.println(" BIENVENIDO A LA ACADEMIA NINJA DE LA ALDEA DE CIENCIAS ");
        System.out.println("========================================================");
        System.out.println("1. Iniciar Aplicación");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
        
        int opcionInicio;
        try {
            opcionInicio = scan.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("El valor ingresado no es un número válido. Ingrese 1 para iniciar, 2 para salir.");
            System.out.println("Saliendo del programa.");
            opcionInicio = 2;
        }

        if (opcionInicio != 1) {
            System.out.println("\nSaliendo del sistema... ¡Hasta luego!");
            return;
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("          SELECCIONE EL MODO DE INICIO            ");
        System.out.println("--------------------------------------------------");
        System.out.println("1. Inicio Básico (Misma cantidad de Aspirantes y Voluntarios)");
        System.out.println("2. Inicio Medio  (Cantidad desbalanceada entre Aspirantes y Voluntarios)");
        System.out.println("3. Inicio Personalizado (Definir cantidades manualmente)");
        System.out.print("Seleccione una opción: ");
        
        int modoInicio = 0;
        try {
            modoInicio = scan.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("El valor ingresado no es un número válido.");
            System.out.println("Se tomará el modo básico por defecto.");
            modoInicio = 1;
        }

        int cantAspirantes = 0;
        int cantVoluntarios = 0;

        // Combinaciones máximas posibles (8 nombres * 8 apellidos = 64)
        // Puede cambiar de acuerdo a cuanto tamaño tiene las listas de nomres y apellidos.
        int maxCombinacionesAsp = nombresNinjasAsp.size() * apellidosNinjaAsp.size();
        int maxCombinacionesVol = nombresNinjasVol.size() * apellidosNinjaVol.size();

        switch (modoInicio) {
            case 1:
                // Inicio Básico: Mismo tamaño para ambos.
                cantAspirantes = 10;
                cantVoluntarios = 10;
                System.out.println("\n[Modo Básico] Generando 10 Aspirantes y 10 Voluntarios...");
                break;
                
            case 2:
                // Inicio Medio: Un tipo es mayor al otro de forma aleatoria.
                boolean masAspirantes = random.nextBoolean();
                if (masAspirantes) {
                    cantAspirantes = 18;
                    cantVoluntarios = 6;
                } else {
                    cantAspirantes = 6;
                    cantVoluntarios = 18;
                }
                System.out.printf("\n[Modo Medio] Generando %d Aspirantes y %d Voluntarios...\n",
                        cantAspirantes, cantVoluntarios);
                break;
                
            case 3:
                // Inicio Personalizado.
                System.out.println("\n[Modo Personalizado]");
                System.out.printf("Máxima creación de Ninjas: Aspirantes: %d | Voluntarios: %d\n",
                        maxCombinacionesAsp, maxCombinacionesVol);
                
                System.out.print("Ingrese la cantidad de Ninjas Aspirantes a generar: ");
                try {
                    cantAspirantes = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("El valor ingresado no es un número válido.");
                    System.out.println("Se tomarán 10 Aspirantes por defecto.");
                    cantAspirantes = 10;
                }
                if (cantAspirantes > maxCombinacionesAsp) {
                    System.out.printf("La cantidad ingresada supera el límite. Se ajustará al tope máximo de %d.\n", maxCombinacionesAsp);
                    cantAspirantes = maxCombinacionesAsp;
                }
                
                System.out.print("Ingrese la cantidad de Ninjas Voluntarios a generar: ");
                try {
                    cantVoluntarios = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("El valor ingresado no es un número válido.");
                    System.out.println("Se tomarán 10 Voluntarios por defecto.");
                    cantVoluntarios = 10;
                }
                
                if (cantVoluntarios > maxCombinacionesVol) {
                    System.out.printf("La cantidad ingresada supera el límite. Se ajustará al tope máximo de %d.\n", maxCombinacionesVol);
                    cantVoluntarios = maxCombinacionesVol;
                }
                break;
                
            default:
                System.out.println("\nOpción no válida. Se asignarán 10 Aspirantes y 10 Voluntarios por defecto...");
                cantAspirantes = 10;
                cantVoluntarios = 10;
                break;
        }

        Set<String> nombresAspirantesGenerados = generarNombres(nombresNinjasAsp, apellidosNinjaAsp, cantAspirantes);
        Set<String> nombresVoluntariosGenerados = generarNombres(nombresNinjasVol, apellidosNinjaVol, cantVoluntarios);
        ColeccionNinjasAspirantes ninjasAspirantes = crearNinjasAspirantes(nombresAspirantesGenerados);
        ColeccionNinjasVoluntarios ninjasVoluntarios = crearNinjasVoluntarios(nombresVoluntariosGenerados);

        System.out.println("\n========================================================");
        System.out.println("             INICIANDO ASIGNACIÓN DE GRUPOS             ");
        System.out.println("========================================================");

        ArrayList<Grupo> gruposFormados = crearGrupos(ninjasAspirantes, ninjasVoluntarios);

        // Mostrar presentación de los grupos constituidos
        System.out.println("\n========================================================");
        System.out.println("             GRUPOS CONFORMADOS EXITOSAMENTE            ");
        System.out.println("========================================================");

        if (gruposFormados.isEmpty()) {
            System.out.println("No se pudo formar ningún grupo debido a la falta de integrantes.");
        } else {
            int numeroGrupo = 1;
            for (Grupo grupo : gruposFormados) {
                System.out.println("\n--------------------------------------------------");
                System.out.println("                 GRUPO NINJA #" + numeroGrupo);
                System.out.println("--------------------------------------------------");
                System.out.println(grupo.presentación());
                String campoEntrenamiento = determinarCampoEntrenamiento(grupo.totalNiveles());
                System.out.println("Campo de Entrenamiento Asignado: " + campoEntrenamiento);
                
                numeroGrupo++;
            }
        }

        System.out.println("\n========================================================");
        System.out.println("       PROCESO FINALIZADO EN LA ACADEMIA NINJA          ");
        System.out.println("========================================================\n");
    }
}