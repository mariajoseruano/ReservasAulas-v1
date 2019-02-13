/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

/**
 *
 * @author usuario
 */
public class Profesores {
    
    //Declaración de varibales.
    
    
         private List<Profesor> coleccionProfesores;
	
        
       
        // Se crea Constructor.
        
        public Profesores (){
            
            coleccionProfesores= new ArrayList<>();
            
            
        }
        
        //Se crea el constructor copia
        
        public Profesores (Profesores profesores) {
		setProfesores(profesores);
	}
	
	private void setProfesores(Profesores profesores) {
            
		if (profesores == null) {
			throw new IllegalArgumentException("No se pueden copiar profesores nulos.");
		}
		coleccionProfesores = copiaProfundaProfesores(profesores.coleccionProfesores);
		
	}
	
        // Se crea copiaprofunda
        
	private List<Profesor> copiaProfundaProfesores(List<Profesor>profesores) {
		List<Profesor> otrosProfesores = new ArrayList<>();
		for (Profesor profesor:profesores) {
			otrosProfesores.add(new Profesor(profesor));
		}
		return otrosProfesores;
	}
	
	
        	
	//GETTER
	
        public List<Profesor>getProfesores() {
		return copiaProfundaProfesores(coleccionProfesores);
	}
        
	public int getNumProfesores() {
		return coleccionProfesores.size();
	}
	
        // Método Insertar
        
	public void insertar(Profesor profesor) throws OperationNotSupportedException {
           
		if (profesor == null) {
                    
                    throw new IllegalArgumentException("No se puede insertar un profesor nulo.");
		}
		if (coleccionProfesores.contains(profesor)) {
                    throw new OperationNotSupportedException("El profesor ya existe.");
                }else{
			coleccionProfesores.add(new Profesor(profesor));
                
                }
        }
            
        
        public Profesor buscar(Profesor profesor) {
		int indice = coleccionProfesores.indexOf(profesor);
		if (indice != -1) {
			return new Profesor(coleccionProfesores.get(indice));
		} else {
			return null;
		}
	}
	
	public void borrar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor == null) {
			throw new IllegalArgumentException("No se puede borrar un profesor nula.");
		}
		if (!coleccionProfesores.remove(profesor)) {
		}
		else {
			throw new OperationNotSupportedException("El profesor a borrar no existe.");
		}
	}

	
	
	public List <String> representar() {
            
		List<String> representacion = new ArrayList<>();
		for (Profesor profesor : coleccionProfesores) {
			representacion.add(profesor.toString());
		}
		return representacion;
	}
}

        
        




    


    
