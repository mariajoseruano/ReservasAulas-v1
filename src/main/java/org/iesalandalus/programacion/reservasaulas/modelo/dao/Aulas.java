/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;

/**
 *
 * @author usuario
 * 
 */
public class Aulas {
    
    //Declaración de varibales.
    
    
         private List<Aula> coleccionAulas;
	
        
       
        // Se crea Constructor.
        
        public Aulas (){
            
            coleccionAulas= new ArrayList<>();
            
            
        }
        
        //Se crea el constructor copia
        
        public Aulas (Aulas aulas) {
		setAulas(aulas);
	}
	
	private void setAulas(Aulas aulas) {
            
		if (aulas == null) {
			throw new IllegalArgumentException("No se pueden copiar aulas nulas.");
		}
		coleccionAulas = copiaProfundaAulas(aulas.coleccionAulas);
		
	}
	
        // Se crea copiaprofunda
        
	private List<Aula> copiaProfundaAulas(List<Aula>aulas) {
		List<Aula> otrasAulas = new ArrayList<>();
		for (Aula aula:aulas) {
			otrasAulas.add(new Aula(aula));
		}
		return otrasAulas;
	}
	
	
        	
	//GETTER
	
        public List<Aula>getAulas() {
		return copiaProfundaAulas(coleccionAulas);
	}
        
	public int getNumAulas() {
		return coleccionAulas.size();
	}
	
        // Método Insertar
        
	public void insertar(Aula aula) throws OperationNotSupportedException {
           
		if (aula == null) {
                    
                    throw new IllegalArgumentException("No se puede insertar un aula nula.");
		}
		if (coleccionAulas.contains(aula)) {
                    throw new OperationNotSupportedException("El aula ya existe.");
                }else{
			coleccionAulas.add(new Aula(aula));
                
                }
        }
            
        
        public Aula buscar(Aula aula) {
		int indice = coleccionAulas.indexOf(aula);
		if (indice != -1) {
			return new Aula(coleccionAulas.get(indice));
		} else {
			return null;
		}
	}
	
	public void borrar(Aula aula) throws OperationNotSupportedException {
		if (aula == null) {
			throw new IllegalArgumentException("No se puede borrar un aula nula.");
		}
		if (!coleccionAulas.remove(aula)) {
		}
		else {
			throw new OperationNotSupportedException("El aula a borrar no existe.");
		}
	}

	
	
	public List <String> representar() {
            
		List<String> representacion = new ArrayList<>();
		for (Aula aula : coleccionAulas) {
			representacion.add(aula.toString());
		}
		return representacion;
	}
}

        
        




    

