/**
Elvia Sanchez Leiva
28 de setiembre 2025
* 
*  Clase: Mascota
 * 
 * Qué hace: Almacena toda la información de una mascota con validaciones
 *           para garantizar que los datos sean correctos.
 * 
 * Características:
 * - Campos obligatorios: especie, color, señas particulares
 * - Campos opcionales: raza, microchip, nombre  
 * - Validaciones estrictas en cada campo
 * - Formato específico para microchip (6 caracteres)
 */

package gestorreportesmascotasant;


public final class Mascota {
    //Atributos
    private String especie;
    private String raza;
    private String colorPrincipal;
    private String seniasParticulares;
    private String microchip;
    private String nombre;
    
    
    //Metodos set y validaciones
    public void setEspecie(String especie){
        if (especie != null){ //se revisa que el valor NO este vacio, si esta vacio directo a throw.
            especie = especie.toUpperCase(); //convertir a mayusculas, el toupper de C++
            if((especie.length() == 3) && (especie.equals("DOG")||especie.equals("CAT"))){ // revisa que sean 3 letras y que sean las correctas.
               this.especie = especie;
               return;
            } 
        } //llave IF 1
        throw new IllegalArgumentException("Especie inválida.Debe ser DOG O CAT.");
    } 
    
    public void setRaza(String raza){
        if (raza == null || raza.isEmpty()){
           this.raza = "";
           return;
        }
        
        raza = raza.trim();
            if (raza.matches("[\\p{L} ]+")){ //clase de caracteres que representa cualquier letra de cualquier idioma
                this.raza = raza;
                return;        
            } 
              
        throw new IllegalArgumentException("Raza inválida. Debe contener sólo letras, sin números ni símbolos.");   
    }
    
    public void setColorPrincipal(String colorPrincipal){
        if (colorPrincipal != null){
            colorPrincipal = colorPrincipal.trim();
            if (colorPrincipal.matches("[\\p{L} ]+")){ //Consultado de Regular-Expressions.info, Regex Java Pattern class (Oracle) pagina oficial y Regex101
                this.colorPrincipal = colorPrincipal;
                return;
            }
        }
        throw new IllegalArgumentException ("Color inválido. Debe contener sólo letras, sin números ni símbolos.");
    }    
    
    public void setSeniasParticulares (String seniasParticulares){
        if (seniasParticulares != null){
            seniasParticulares = seniasParticulares.trim();
            if (seniasParticulares.length() >=10 && seniasParticulares.matches ("[\\p{L}0-9 .,;:()-]+")){
                this.seniasParticulares = seniasParticulares;
                return;
            }
        }
        throw new IllegalArgumentException ("Texto inválido. Debe contener sólo letras, sin números ni símbolos.");
    }    
    
    public void setMicrochip (String microchip){
       if (microchip == null ||microchip.trim ().isEmpty()) {
           this.microchip = "";
           return;
       }
       microchip = microchip.trim();
       if (microchip.length() == 6  && microchip.matches("[a-zA-Z0-9]+")) {
                this.microchip = microchip;
                return;
        }
        throw new IllegalArgumentException("Microchip inválido. Debe contener exactamente 6 caracteres alfanuméricos, sin espacios ni símbolos.");
    }
       
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {//garantiza que no haya espacios adelante y atras
            this.nombre = "";
            return;
        }
        
        nombre = nombre.trim();    
        if (nombre.length() >= 2 && nombre.matches("[\\p{L} ]+")) {
            this.nombre = nombre;
            return;
        }
    
    throw new IllegalArgumentException("Nombre inválido. Debe tener al menos 2 letras, sin números ni símbolos.");
}
    
    
    //Metodos get
    public String getEspecie(){return especie; }
    public String getRaza(){return raza; }
    public String getColorPrincipal (){return colorPrincipal; }
    public String getSeniasParticulares (){return seniasParticulares; }
    public String getMicrochip (){return microchip; }
    public String getNombre (){return nombre; }
    
    //Constructor con parametros
    public Mascota (String especie, String raza, String colorPrincipal, String seniasParticulares, String microchip, String nombre){
        setEspecie(especie);
        setRaza(raza);
        setColorPrincipal(colorPrincipal);
        setSeniasParticulares (seniasParticulares);
        setMicrochip(microchip);
        setNombre(nombre);
        
    } //llave constructor...
    
    //Constructor por defecto
    public Mascota (){
        //vacio luego para usarlo mas adelante se llamaria Mascota m = new Mascota();
    }
    
    //Metodos personalizados
       
    public boolean tieneChip(){
        return microchip != null && !microchip.isEmpty();
    }
    
    public String getFichaResumen(){ //// Devuelve un resumen textual de la mascota
        return "Nombre: " + nombre + "\n" +
               "Especie: " + especie + "\n" +
               "Raza: " + raza + "\n" +
               "Color: " + colorPrincipal + "\n" +
               "Señas: " + seniasParticulares + "\n" +
               "Microchip: " + microchip;
    }
        
    @Override // esto es para que cuando se imprima una mascota (System.out.println(mascota)), se muestre su ficha resumen. se usa automáticamente en lugares donde getFichaResumen() no se llama -tal vez se ocupe..-.”
    public String toString(){
        return getFichaResumen();
    }
    
}