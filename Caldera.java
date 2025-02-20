/**
 * Clase que gestiona los gastos de campanya de
 * una caldera de comunitaria sin contadores.
 * Permite analizar gastos y hacer una regularizacion
 * informando cuanto se tiene que devolver o
 * cuanto mas tiene que pagar cada vecino.
 * 
 * @author Artius Devora
 * @version 1.0
 */
public class Caldera {
    
    // TODO: CONSTANTES

    /** El IVA se aplica a todos los gasto. */
    
    /** El impuesto de hidrocarburos solo se aplica al gas, ademas del iva. */
    
    private final double IMP_IVA = 0.22;
    private final double IMP_HIDROCARBUROS = 0.20;
    
     

    // Conceptos gastos
    private final char AGUA = 'A';
    private final char LUZ = 'L';
    private final char NADA = 'N';
    

    // Ningun mes
    private final int NINGUNO = 0;


    // Periodos
    private final int PERIODO_OCTUBRE_DICIEMBRE = 1;
    private final int PERIODO_ENERO_MARZO = 2;
    private final int PERIODO_ABRIL_JUNIO = 3;
    private final int PERIODO_JULIO_SEPTIEMBRE = 4;
    
    
    
    // TODO: VARIABLES DE CLASE (PROPIEDADES/ATRIBUTOS)

    // vecinos y presupuesto
    private int vecinos;
    private double presupuesto;

    // acumulados
    
    private double acomuladoConsumo;
    private double acomuladoMantenimiento;
    private double gastoAgua;
    private double gastoLuz;
    
    // estadisticas
    private int mesMasConsumo;
    private double maxConsumo;
    
    private int mesMasCaro;
    private double maxPrecio;
    
    private int mesMasBarato;
    private double minPrecio;
    
    private int periodoMasMantenimiento;
    private double maxMantenimiento;
    
    private int mesMasGasto;
    private double maxGasto;
    private char conceptoMasGasto;
    
   
    
    
    
    // TODO: constructores
    
    /**
     * Constructor de la clase Caldera. Inicializa los atributos.
     */
    
    public Caldera()
    {
        acomuladoConsumo = 0;
        acomuladoMantenimiento = 0;
        gastoAgua = 0;
        gastoLuz = 0;
        mesMasConsumo = NINGUNO;
        maxConsumo = 0;
        mesMasCaro = NINGUNO;
        maxPrecio = 0;
        mesMasBarato = NINGUNO;
        minPrecio = 0;
        periodoMasMantenimiento = NINGUNO;
        maxMantenimiento = 0;
        mesMasGasto = NINGUNO;
        maxGasto = 0;
        conceptoMasGasto = 'N';   
    }
    

    
        public Caldera(int vecinos, double presupuesto)
    {
        this.vecinos = vecinos;
        this.presupuesto = presupuesto;
        acomuladoConsumo = 0;
        acomuladoMantenimiento = 0;
        gastoAgua = 0;
        gastoLuz = 0;
        mesMasConsumo = NINGUNO;
        maxConsumo = 0;
        mesMasCaro = NINGUNO;
        maxPrecio = 0;
        mesMasBarato = NINGUNO;
        minPrecio = 0;
        periodoMasMantenimiento = NINGUNO;
        maxMantenimiento = 0;
        mesMasGasto = NINGUNO;
        maxGasto = 0;
        conceptoMasGasto = 'N';   
    }
    
    // TODO: getters y setters
    
    /**
     * Fija el valor del presupuesto
     * 
     * @param quePresupuesto Valor del presupuesto, ej. 38638
     */
    public void setPresupuesto(double quePresupuesto){
        presupuesto = quePresupuesto;
    }

    /**
     * Obtiene el valor del presupuesto
     * 
     * @return valor del presupuesto, ej. 38638
     */
    public double getPresupuesto(){
        return presupuesto;
    }

    /**
     * Fija el numero de vecinos de la comunidad
     * 
     * @param queVecinos numero de vecinos, ej. 48
     */
    public void setVecinos(int queVecinos){
        vecinos = queVecinos;
    }

    /**
     * Obtiene el numero de vecinos
     * 
     * @return numero de vecinos, ej. 48
     */
    public int getVecinos(){
        return vecinos;
    }

    /**
     * Cantidad de gas consumido cada mes al precio de mercado
     * 
     * @param mes    Numero de mes, 1 es enero, 2 febrero, ..., 12 diciembre, ej. 9
     * @param gas    Cantidad de gas consumido en KWh, ej. 15496
     * @param precio Precio en Euros al que se ha conseguido el gas, ej. 0.067668
     */
    public void consumo(int mes, int gas, double precio) {
        int cantidadMeses = 0;
        cantidadMeses ++;
        // TODO: consumo
        acomuladoConsumo += (gas * precio);
        if (cantidadMeses == 1){ 
            mesMasConsumo = mes;
            maxConsumo = (gas * precio);
            mesMasCaro = mes;
            maxPrecio = precio;
            mesMasBarato = mes;
            minPrecio = precio;
        }
        else {
            if ((gas * precio) > maxConsumo)
            {
                maxConsumo = (gas * precio);
                mesMasConsumo = mes;
            }
            else if (precio > maxPrecio)
            {
                maxPrecio = precio;
                mesMasCaro = mes;
            }
            else if (precio < minPrecio)
            {
                minPrecio = precio;
                mesMasBarato = mes;
            }
        }
    }

    /**
     * Gasto de mantenimiento en cada periodo
     * 
     * @param periodo Numero que representa el periodo, ej. OCTUBRE-DICIEMBRE es 1
     * @param importe Valor del gasto de mantenimiento
     */
    public void mantenimiento(int periodo, double importe) {
        int cantidadPeriodos = 0;
        cantidadPeriodos ++;
        // TODO: mantenimiento
        acomuladoMantenimiento += importe;
        if (cantidadPeriodos == 1){
            periodoMasMantenimiento = periodo;
            maxMantenimiento = (periodo * importe);
        }
        else {
            if (periodo * importe > maxMantenimiento)
            {
                maxMantenimiento = (periodo * importe);
                periodoMasMantenimiento = periodo;
            }
        }
    }

    /**
     * Gasto mensual en concepto de agua o luz.
     * 
     * @param mes      Numero del mes, ej. ENERO es 1
     * @param concepto Agua 'A' o luz 'L'
     * @param importe  Valor del gasto, ej. 189.03
     */
    public void gasto(int mes, char concepto, double importe) {
        int cantidadMeses = 0;
        cantidadMeses ++;
        // TODO: gasto
        if (concepto == 'A'){
            gastoAgua += importe;
        }
        if (concepto == 'L'){
            gastoLuz += importe;
        }
        
        if ((cantidadMeses == 1) || (concepto != 'N')){
            mesMasGasto = mes;
            maxGasto = importe;
            conceptoMasGasto = concepto;
        }
        else{
            if((importe > maxGasto) || (concepto != 'N')){
                maxGasto = importe;
                mesMasGasto = mes;
                conceptoMasGasto = concepto;
            }
        }
    }

    /**
     * Imprime el resultado del periodo, ej.
     * 
     * ==================
     * RESULTADO GLOBAL
     * ==================
     * Presupuesto: 38638.0
     * Consumo gas: 61688.26
     * Impuestos g.: 25909.07
     * Mantenimiento: 4157.58
     * Iva manto.: 914.67
     * Gasto agua: 2647.83
     * Iva agua: 582.52
     * Gasto luz: 4663.01
     * Iva luz: 1025.86
     * ------------------
     * TOTAL : -62950.8 Euros.
     * ------------------
     * ==================
     * RESULTADO X VECINO
     * ==================
     * Vecinos: 48
     * Aporte v.: 804.96
     * Gasto v.: 2116.43
     * Resultado: -1311.47
     * ------------------
     * El resultado ha sido NEGATIVO,
     * se tiene que pagar 1311.47 Euros.
     * El pago se pasara en
     * 5 cuotas de 262.29 Euros.
     * ------------------
     */
    public void printResultados() {
        double total = (presupuesto - acomuladoConsumo - ((IMP_IVA + IMP_HIDROCARBUROS) * acomuladoConsumo) - acomuladoMantenimiento - (IMP_IVA * acomuladoMantenimiento) - gastoAgua - (IMP_IVA * gastoAgua) - gastoLuz - (IMP_IVA * gastoLuz));
        double totalVecino = (total / vecinos);
        // TODO: printResultados
        System.out.println("==================");
        System.out.println("RESULTADO GLOBAL");
        System.out.println("==================");
        System.out.println("Presupuesto: " + presupuesto );
        System.out.println("Consumo gas: " + redondeo2decimales(acomuladoConsumo) );
        System.out.println("Impuestos g.: " + redondeo2decimales((IMP_IVA + IMP_HIDROCARBUROS) * acomuladoConsumo ));
        System.out.println("Mantenimiento " + acomuladoMantenimiento );
        System.out.println("Iva manto.: " + redondeo2decimales((IMP_IVA * acomuladoMantenimiento)));
        System.out.println("Gasto agua: " + gastoAgua );
        System.out.println("Iva agua: " + redondeo2decimales((IMP_IVA * gastoAgua)));
        System.out.println("Gasto luz: " + gastoLuz );
        System.out.println("Iva luz: " + redondeo2decimales((IMP_IVA * gastoLuz)));
        System.out.println("------------------");
        System.out.println("TOTAL : " + redondeo2decimales(total) );
        System.out.println("------------------");
        System.out.println("==================");
        System.out.println("RESULTADO X VECINO");
        System.out.println("==================");
        System.out.println("Vecinos: " + vecinos );
        System.out.println("Aporte v.: " + redondeo2decimales((presupuesto / vecinos)));
        System.out.println("Gasto v.: " + redondeo2decimales(((total - presupuesto)) / vecinos)*(-1));
        System.out.println("Resultado: " + redondeo2decimales((total / vecinos)));
        System.out.println("------------------");
        System.out.println(analisisResultado(redondeo2decimales(totalVecino)));
        System.out.println("------------------");
    }

    /**
     * Imprime las estadisticas del periodo, ej.
     * 
     * ==================
     * ESTADISTICAS
     * ==================
     * Max. consumo: ENERO 12527.66
     * Mes mas caro: AGOSTO 0.202504
     * Mes mas barato: SEPTIEMBRE 0.067668
     * Mayor gasto en: ABRIL 679.94 LUZ
     * P. mas manto.: OCTUBRE-DICIEMBRE 1552.1
     * ------------------
     */
    public void printEstadisticas() {
        // TODO: printEstadisticas
        System.out.println("==================");
        System.out.println("ESTADISTICAS");
        System.out.println("==================");
        System.out.println("Max. consumo:\t" + getNombreMes(mesMasConsumo) + "\t" + redondeo2decimales(maxConsumo));
        System.out.println("Mes mas caro:\t" + getNombreMes(mesMasCaro) + "\t" + maxPrecio);
        System.out.println("Mes mas barato:\t" + getNombreMes(mesMasBarato) + "\t" + minPrecio);
        System.out.println("Mayor gasto en:\t" + getNombreMes(mesMasGasto) + "\t" + redondeo2decimales(maxGasto) + "\t" + getNombreConcepto(conceptoMasGasto));
        System.out.println("P. mas manto.:\t" + getNombrePeriodo(periodoMasMantenimiento) + "\t" + redondeo2decimales(maxMantenimiento));
        System.out.println("------------------");
    }

    /**
     * Devuelve el nombre del mes asociado a su valor numerico
     * 
     * @param numMes Numero del mes del 1 al 12, ej. 1
     * @return Nombre del mes, ej. ENERO
     */
    public String getNombreMes(int numMes) {
        String str = "";
        // TODO: getNombreMes
        switch (numMes){
            case 1: str = "ENERO";
                break;
            case 2: str = "FEBRERO";
                break;
            case 3: str = "MARZO";
                break;
            case 4: str = "ABRIL";
                break;
            case 5: str = "MAYO";
                break;
            case 6: str = "JUNIO";
                break;
            case 7: str = "JULIO";
                break;
            case 8: str = "AGOSTO";
                break;
            case 9: str = "SEPTIEMBRE";
                break;
            case 10: str = "OCTUBRE";
                break;
            case 11: str = "NOVIEMBRE";
                break;
            case 12: str = "DICIEMBRE";
                break;
            default: str = "NINGUNO";
        }
        return str;        
    }

    /**
     * Devuelve el nombre del concepto asociado al caracter
     * 
     * @param concepto Valor caracter, ej. 'L'
     * @return Nombre del concepto, ej. 'LUZ'. Si no es agua o luz devuelve "NADA"
     */
    public String getNombreConcepto(char concepto) {
        String str = "";   
        
        if (concepto == 'A'){
            str = "AGUA";
        }
        else if (concepto == 'L'){
            str = "LUZ";
        }
        else str = "NADA";
        
        return str;
    }

    /**
     * Devuelve el nombre del periodo asociado a su numero
     * 
     * @param numPeriodo Numero de periodo, del 1 al 4, ej. 4
     * @return Nombre del periodo con nombres de los meses separados por guion, ej.
     *         "OCTUBRE-DICIEMBRE". Sino devuelve "NINGUN PERIODO"
     */
    public String getNombrePeriodo(int numPeriodo) {
        String str = "";
        // TODO: getNombrePeriodo
        switch (numPeriodo){
            case 1: str = "OCTUBRE-DICIEMBRE";
                break;
            case 2: str = "ENERO-MARZO";
                break;
            case 3: str = "ABRIL-JUNIO";
                break;
            case 4: str = "JULIO-SEPTIEMBRE";
                break;
            default: str = "NINGUN PERIODO";
        }
        return str;        
    }

    /**
     * Analiza el resultado, si el valor es negativo se tendra que pagar si es
     * positivo se devolvera.
     * En el caso negativo se debera pagar de una vez si el importe en menor o igual
     * que 200,
     * en multiplos de 200 y el resto si el resultado es menor o igual que 600 o
     * en 5 partes alicuotas sino.
     * 
     * @param resultado cantidad positiva o negativa, ej. -1311.47
     * @return Mensaje con la informacion sobre el pago. Ej.
     *         </br>
     *         El resultado ha sido NEGATIVO,
     *         se tiene que pagar 114.56 Euros.
     *         El pago se pasara en un solo cobro.
     *         </br>
     *         El resultado ha sido NEGATIVO,
     *         se tiene que pagar 513.33 Euros.
     *         El pago se pasara en
     *         2 cuotas de 200 Euros y
     *         otro cobro de 113.33 Euros.
     *         </br>
     *         El resultado ha sido NEGATIVO,
     *         se tiene que pagar 1311.47 Euros.
     *         El pago se pasara en
     *         5 cuotas de 262.29 Euros.
     *         </br>
     *         El resultado ha sido POSITIVO,
     *         se devolvera 45.52 Euros.
     *         El pago se realizara en breve en
     *         una transferencia.
     */
    public String analisisResultado(double resultado) {
        String str = "";
        
        if (resultado >= 0){
           str = "El resultado ha sido POSITIVO," + "\n" + "se devolvera " + resultado + " Euros." + "\n" + "El pago se realizara en breve en" + "\n" + "una transferencia.";
           
        }
        else if ((resultado >= -200) && (resultado < 0)){
            str = "El resultado ha sido NEGATIVO," + "\n" + "se tiene que pagar " + (-1 * resultado) + " Euros." + "\n" + "El pago se pasara en un solo cobro."; 
        }
        else if ((resultado >= -600) && (resultado < 0)){
            str = "El resultado ha sido NEGATIVO," + "\n" + "se tiene que pagar " + resultado + " Euros." + "\n" + "El pago se pasara en" + "\n" + ((int)resultado / 200) + "cuotas de 200 Euros y" + "\n" + "otro cobro de " + (resultado - (((int)resultado / 200)) * 200);
        }
        else if (resultado < -600){
            str = "El resultado ha sido NEGATIVO," + "\n" + "se tiene que pagar " + resultado + " Euros." + "\n" + "El pago se pasara en" + "\n" + "5 cuotas de " + (resultado / 5) + " Euros.";
        }
        return str;
    }

    /**
     * Redondea un valor de tipo double a dos decimales.
     * Al imprimirlo se vera al menos un decimal y como mucho dos.
     *
     * @param valor Numero con decimales de tipo double
     * @return Redondeo con 1 o 2 decimales, ej.
     *         38638 -> 38638.0
     *         61688.255730000004 -> 61688.26
     *         25909.067406600003 -> 25909.07
     *         -62950.79553660001 -> -62950.8
     *         -1311.4749070125 -> -1311.47
     */
    public double redondeo2decimales(double valor) {
        double parteEntera;
        double numero;
        numero = valor;
        parteEntera = Math.floor(numero);
        numero = (numero-parteEntera)*100.0;
        numero = Math.round(numero);
        numero = (numero/100.0)+parteEntera;
        return numero;
        // TODO: redondeo2decimales
    }

    /**
     * Divide un numero decimal entre un numero entero y devuelve el resultado
     * entero.
     * 
     * @param dividendo Numero con decimales que se divide, ej. 647.55
     * @param divisor   Numero entero que divide, ej. 200
     * @return Cociente, numero entero, cuantos divisores caben en el dividendo, ej.
     *         3
     */
    public int divisionEntera(double dividendo, int divisor) {
        int cociente;
        cociente = ((int)dividendo / divisor);
        // TODO: divisionEntera
        return cociente;
    }

    /**
     * Divide un numero decimal entre un numero entero y devuelve el resto con
     * decimales.
     * 
     * @param dividendo Numero con decimales que se divide, ej. 647.55
     * @param divisor   Numero entero que divide, ej. 200
     * @return Resto con decimales, ej. 47.55
     */
    public double restoDivisionEntera(double dividendo, int divisor) {
        double resto;
        resto = (dividendo % divisor);
        // TODO: restoDivisionEntera
        return resto;
    }

}
