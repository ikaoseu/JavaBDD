/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabdd;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author xp
 */
public class JavaBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws SQLException { 
//        try{
//            Connection conexion = DriverManager.getConnection("jdbe:mysql;//localhost/tienda");
//            Statement st = conexion.createStatement();
//            //st.executeUpdate("insert into cliente values (5, 'oscar', '987123354','oscar@ufv.es')");
//            
//            ResultSet rs = st.executeQuery("SELECT * FROM CLIENTE");
//            
//            while (rs.next()){
//                System.out.println("nombre="+rs.getObject("nombre")+
//                        ",apellidos=" + rs.getObject("apellidos")+
//                        ",");
//            }
//            rs.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//    
        JavaBDD it = new JavaBDD();   
        
        Scanner sc = new Scanner(System.in);
        System.out.println("indique si quiere leer tabla(1), actualizar registro(2), dar de baja(3) o borrar entero(4): \n");
        int menu = sc.nextInt();
       
       
        if(menu == 1){
            System.out.println("usted ha seleccionado leer \n");
            System.out.println("introduzca ahora la tabla: \n");
            
            Scanner logeador = new Scanner(System.in);
            String dni = logeador.nextLine();
            
            it.leeDatos(dni);
        }else{
            if(menu == 2){
                 
                 System.out.println("usted ha seleccionado actualizar registro\n");
                 System.out.println("escriba ahora los valores en el siguiente orden, Dni, nombre, correo y telefono: \n");     
                 
                 Scanner sc_d = new Scanner(System.in);
                 Scanner sc_n = new Scanner(System.in);
                 Scanner sc_c = new Scanner(System.in);
                 Scanner sc_t = new Scanner(System.in);
                 
                                 
                 String _dni = sc_d.nextLine();
                 String _nombre = sc_n.nextLine();
                 String _correo = sc_c.nextLine();
                 String _tlf = sc_t.nextLine();
                 

                 it.grabaRegistro(_dni,_nombre,_correo,_tlf);

                 
            }else{ if(menu == 3){
                 System.out.println("usted ha seleccionado borrar registro \n");
                 System.out.println("escriba ahora su dni: \n");
                 
                 Scanner borrador = new Scanner(System.in);
                 String usuario = borrador.nextLine();
                 
                 it.borraDatos(usuario);
            }
            }
        }
}
    public void leeDatos(String tabla)throws SQLException{
        
         Connection conexion = DriverManager.getConnection("jdbe:mysql;//localhost/tienda");
          Statement st = conexion.createStatement();

            
            ResultSet rs = st.executeQuery("SELECT * FROM CLIENTE");
           
           while (rs.next()){
               System.out.println("nombre="+rs.getObject("nombre")+
                        ",apellidos=" + rs.getObject("apellidos")+
                       ",");
           }
           rs.close();
    }
    
     public void grabaRegistro(String dni, String nombre, String correo, String tlf)throws SQLException{
        
           Connection conexion = DriverManager.getConnection("jdbe:mysql;//localhost/tienda");
           Statement st = conexion.createStatement();
           st.executeUpdate("insert into cliente values ("+dni+", '"+nombre+"', '"+correo+"','"+tlf+"')");
         
    }
    public void borraDatos(String dni)throws SQLException{
        
        
    }
    }