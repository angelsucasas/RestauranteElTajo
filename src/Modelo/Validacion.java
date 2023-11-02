/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Iterator;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class Validacion {


     public boolean Validar_Numeros (String Dato) { //Valida que los datos sean numeros
		boolean isNumeric =  Dato.matches("[+-]?\\d*(\\.\\d+)?");
		
		return isNumeric;
	}
     public boolean ValidarNoVacios(String Dato){ //Valida que los campos no esten vacios
        if (Dato.isEmpty()){
            return true;
        }
        return false;
        
    }
     
     
    
}
