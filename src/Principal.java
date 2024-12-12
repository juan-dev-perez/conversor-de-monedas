import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaApi conversor = new ConsultaApi();
        int opcionElegida = 0;
        String codigoMonedaOrigen = "";
        String codigoMonedaFinal = "";
        String monto;
        boolean EstadoDeError = false;


        System.out.println("\nBienvenido al conversor de moneda :D \n");

        while (opcionElegida != 7){
            EstadoDeError = false;

            System.out.println("***************************************************");
            System.out.println("Ingrese el número de la opción de cambio que desea");

            System.out.println("""
                    
                    1) Dólar -> Peso Argentino.
                    2) Peso Argentino -> Dólar.
                    3) Dólar -> Peso Colombiano.
                    4) Peso Colombiano -> Dolar.
                    5) Dólar -> Real Brasileño.
                    6) Real Brasileño -> Dólar.
                    7) Salir.
                    """);

            System.out.println("***************************************************");

            try{
                opcionElegida =Integer.valueOf(lectura.nextLine());

                switch (opcionElegida){
                    case 1:
                        codigoMonedaOrigen = "USD";
                        codigoMonedaFinal = "ARS";
                        break;
                    case 2:
                        codigoMonedaOrigen = "ARS";
                        codigoMonedaFinal = "USD";
                        break;
                    case 3:
                        codigoMonedaOrigen = "USD";
                        codigoMonedaFinal = "COP";
                        break;
                    case 4:
                        codigoMonedaOrigen = "COP";
                        codigoMonedaFinal = "USD";
                        break;
                    case 5:
                        codigoMonedaOrigen = "USD";
                        codigoMonedaFinal = "BRL";
                        break;
                    case 6:
                        codigoMonedaOrigen = "BRL";
                        codigoMonedaFinal = "USD";
                        break;
                    case 7:
                        System.out.println("Gracias por usar el conversor de moneda. Vuelva pronto.");
                        EstadoDeError = true;
                        break;
                    default:
                        System.out.println("Opción no valida, por favor elija nuevamente.");
                        EstadoDeError = true;
                }
            }catch(NumberFormatException e){
                System.out.println("Opción no valida, por favor elija nuevamente.");
                EstadoDeError = true;
            }

            if(!EstadoDeError){

                System.out.println("Ingrese el valor que desea convertir");
                monto = lectura.nextLine();

                try{
                    Conversion conversion = conversor.buscarCambioDeMoneda(codigoMonedaOrigen,codigoMonedaFinal, monto);
                    System.out.println("El valor " + Double.valueOf(monto) + " [" + conversion.base_code() + "] corresponde al valor final de -> " + conversion.conversion_result() + " [" + conversion.target_code() + "]");
                }catch (RuntimeException e){
                    System.out.println("Debe ingresar un monto valido");
                }
            }


        }
    }
}
