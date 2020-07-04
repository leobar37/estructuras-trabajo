/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import capaDatos.listaAlumno;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Alumno implements Serializable{
 //   private Pago pagoAlumno;//ATRIBUTO MATRICULA
    private String dni;
    private String nombres;
    private String apellidos;
    private int edad;
    private Date fechaNacimiento;
    private String direccion;
    private String celular;
    private String correo;
    private boolean estado;
    private String lugar;
    private String imagen;
    private Date fechaRegistro;
    private String sexo;
    
  //  private int codGrupo;//ATRIBUTO MATRICULA
    
    public Alumno() {
     //   codGrupo =-1;
    }   

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public Alumno(String dni, String nombres) {
        this.dni = dni;
        this.nombres = nombres;
    }
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

   
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public static ListasAux.ListaEnlazada consultar(){
        return listaAlumno.consultar();
    }     
    
    
    //modificar un alumno 
    public static void modificarAlumno(String dni ,Alumno objAlumno){
     int pos = listaAlumno.buscaxDniPos(dni);
        System.out.println("posicion"+pos);
      listaAlumno.consultar().Modificar(objAlumno, pos);
    }
   //eliminar alumno
    public static void elminarAlumno(String dni){
       int pos = listaAlumno.buscaxDniPos(dni);
        System.out.println(""+pos);
        listaAlumno.consultar().Eliminar(pos);   
    }
   //retornar un alumno
    public static Alumno ObtnerAlumno(String dni){
      int pos = listaAlumno.buscaxDniPos(dni);
      if(pos==-1){
         return null;
      }else{
       return (Alumno) listaAlumno.consultar().Buscar(pos);   
      }
       
    }

        public static String BuscarDni(String dni) throws IOException{
        URL url = new URL("http://luisrojas.hol.es/2ren/tutorialesexcel.php");
        String paquete = "dni="+dni+"&token=tutorialesexcel.com";
        byte[] postDataBytes = paquete.toString().getBytes("UTF-8");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length",
                String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        Reader in = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), "UTF-8"));
        String resultado = "";
           char ca;
        for (int c = in.read(); c != -1; c = in.read()) {
            ca =  (char)c;
            resultado= resultado +ca;
           // System.out.print((char) c);
        }
     
        return resultado;
    }
        public static void guardarImagen(String dniAlumno,String path) {
        try {
            //------proceso de guardado de imagen desde un lugar cualquiera hacia la raiz del proyecto----//
            Image img = new ImageIcon(path).getImage();
            BufferedImage imagen = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D pintor = imagen.createGraphics();
            pintor.drawImage(img, 0, 0, null);
            pintor.dispose();
            //directorio
            // File directorio = new File("fotos");
            //directorio.mkdir();
            //
            File fichero = new File("fotos/"+dniAlumno+".jpg");
            //fichero.createNewFile();
     //       if(fichero.delete())JOptionPane.showMessageDialog(null,"se borro");
            
            //if(fichero.createNewFile())return;
            ImageIO.write(imagen, "jpg", fichero);
            //----------------------fin proceso--------------------------//
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "error en el guardado de la imagen");
       }
    }
    public static boolean BorrarImagen(String dniAlumno){
         File fichero = new File("fotos/"+dniAlumno+".jpg");
        return fichero.delete();
        
    }

    
         
  
}

