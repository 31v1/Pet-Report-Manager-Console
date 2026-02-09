/**
Elvia Sanchez Leiva
28 de setiembre 2025
* Clase: Reporte
* 
* Qué hace: Representa un reporte completo de mascota perdida o encontrada.
*           Combina información del reporte, del dueño y de la mascota.
* 
* Características importantes:
* - Fecha automática: Si no se especifica, usa la fecha actual
* - Campos no cambiables: ID, cédula reportante y fecha original.
* - Validaciones: Formato específico para cada campo
* - Estado: Activo/Resuelto para seguir el progreso del caso
* 
* Nota: Clase final para evitar herencia y mantener integridad
* 
 */

package gestorreportesmascotasant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public final class Reporte { //se usa final, porque no se espera que la clase se herede, y para no tener problemas en los constructor con paramentros, mejor hacerla final.
    //atributos
    private String idReporte;
    private String tipoReporte;
    private LocalDate fechaReporte;
    private boolean resuelto; //false = activo, true = resuelto
    private String zonaReporte;
    private Cliente cliente;
    private Mascota mascota;
    
    //Metodos set y validaciones
    public void setIdReporte (String idReporte){
        if(idReporte!= null){
           idReporte = idReporte.trim();
           if (idReporte.matches("^REP-\\d{4}$")){ // Valida que el ID comience con "REP-" seguido de 4 dígitos
                this.idReporte = idReporte;
                return;
            }        
        }
        throw new IllegalArgumentException("ID inválido. Ejemplo válido: REP-1234");     
    }
    
    public void setTipoReporte (String tipoReporte){
        if (tipoReporte != null){
            tipoReporte = tipoReporte.trim().toUpperCase();
            if (tipoReporte.isEmpty()){
                this.tipoReporte = "PDR";
                return;
            }
            if (tipoReporte.equals("PDR") || tipoReporte.equals ("ENC")){
                this.tipoReporte = tipoReporte;
                return;
            }
        } else {
            this.tipoReporte = "PDR";
            return;
        }
        
        throw new IllegalArgumentException ("Tipo de reporte inválido. Debe ser PDR o ENC.");
               
    }
    
    
    /*** Convierte String a LocalDate usando DateTimeFormatter (Java Time API) usando el formato dd/MM/yyyy.
 * Referencia: Java Documentation - DateTimeFormatter y LocalDate.parse()*/
    /**
  * Si el texto es nulo o vacío, se asigna la fecha actual.
 * @param fechaTexto la fecha en formato dd/MM/yyyy
 */
    public void setFechaReporte (String fechaTexto){
        if (fechaTexto == null || fechaTexto.trim ().isEmpty()) {
            this.fechaReporte = LocalDate.now();
        } else {
            try { //Aqui se convierte el string a fecha sistema
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                this.fechaReporte = LocalDate.parse(fechaTexto.trim(), formatter);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException ("Fecha inválida. Formato: dd/mm/aaaa");
            }
        }
    }    
        
    public void setResuelto (boolean resuelto) {
        this.resuelto = resuelto;   
    }
    
    public void setEstadoDesdeString (String estado){
        if (estado != null) {
            estado = estado.trim().toUpperCase();
            if (estado.equals("RESUELTO")) {
                this.resuelto = true;
            } else 
                if (estado.equals("ACTIVO")){
                this.resuelto = false;
            } else {
                throw new IllegalArgumentException ("Estado inválido. Debe ser 'ACTIVO' o 'RESUELTO'.");
            }
        } else {
            this.resuelto = false;
        }
    }
    
    public void setZonaReporte (String zonaReporte){
        if (zonaReporte != null) {
            zonaReporte = zonaReporte.trim().toUpperCase();
            if (zonaReporte.length() <= 30 && zonaReporte.matches("[\\p{L}0-9 .,;:()-]+")){
                this.zonaReporte = zonaReporte;
                return;
            }
            
        }
        throw new IllegalArgumentException ("Zona inválida. Debe tener entre 1 y 30 caracteres.");
    }
    
    public void setCliente (Cliente cliente){
        if (cliente != null){
            this.cliente = cliente;
            return;
        }
        throw new IllegalArgumentException ("Cliente no puede ser vacio");
    }
    
    public void setMascota (Mascota mascota){
        if (mascota != null){
            this.mascota = mascota;
            return;
        }
        throw new IllegalArgumentException ("Mascota no pueder ser vacio");
    }
    
    //Metodos get
    public String getIdReporte () {return idReporte;}
    public String getTipoReporte () {return tipoReporte;}
    public LocalDate getFechaReporte () {return fechaReporte;}
    public boolean isResuelto () {return resuelto;}
    public String getZonaReporte () {return zonaReporte;}
    public Cliente getCliente () {return cliente;}
    public Mascota getMascota () {return mascota;}
    
    
    //Constructor con parametro
    public Reporte (String idReporte, String tipoReporte, String fechaTexto, boolean resuelto, String zonaReporte, Cliente cliente, Mascota mascota){
        setIdReporte(idReporte);
        setTipoReporte(tipoReporte);
        setFechaReporte(fechaTexto);
        setResuelto(resuelto);
        setZonaReporte(zonaReporte);
        setCliente(cliente);
        setMascota(mascota);
    }
    
    //Constructor por defecto
    public Reporte (){}
    
    //Metodos personalizados
    
    // metodo para mostrar fechas formateadas
    public String getFechaFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaReporte.format(formatter);
    }
    
    // Devuelve un resumen textual del reporte
    public String getFichaReporte(){
        return "Tipo de Reporte: " + tipoReporte + "\n" +
               "Fecha del reporte: " + getFechaFormateada() + "\n" +
               "Estado del Reporte: " + resuelto + "\n" +
               "Zona del Reporte: " + zonaReporte + "\n" +
               "Nombre del Cliente: " + cliente.getNombreCompleto() + "\n" +
               "Mascota: " + mascota;
    }
    
    @Override
    public String toString(){
        return getFichaReporte();
    }
    
      
    
}//LLAVE clase Reporte
