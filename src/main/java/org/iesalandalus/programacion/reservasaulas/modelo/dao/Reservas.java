
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

/**
 *
 * @author usuario
 */
public class Reservas {
    
    //Declaración de varibales.
    
    
         private List<Reserva> coleccionReservas;
	
        
       
        // Se crea Constructor.
        
        public Reservas (){
            
            coleccionReservas= new ArrayList<>();
            
            
        }
        
        //Se crea el constructor copia
        
        public Reservas (Reservas reservas) {
		setReservas(reservas);
	}
	
	private void setReservas(Reservas reservas) {
            
		if (reservas == null) {
			throw new IllegalArgumentException("No se pueden copiar reservas nulas.");
		}
		coleccionReservas = copiaProfundaReservas(reservas.coleccionReservas);
		
	}
	
        // Se crea copiaprofunda
        
	private List<Reserva> copiaProfundaReservas(List<Reserva>reservas) {
		List<Reserva> otrasReservas = new ArrayList<>();
		for (Reserva reserva:reservas) {
			otrasReservas.add(new Reserva(reserva));
		}
		return otrasReservas;
	}
	
	
        	
	//GETTER
	
        public List<Reserva>getReservas() {
		return copiaProfundaReservas(coleccionReservas);
	}
        
	public int getNumReservas() {
		return coleccionReservas.size();
	}
	
        // Método Insertar
        
	public void insertar(Reserva reserva) throws OperationNotSupportedException {
           
		if (reserva == null) {
                    
                    throw new IllegalArgumentException("No se puede insertar una reserva nula.");
		}
		if (coleccionReservas.contains(reserva)) {
                    throw new OperationNotSupportedException("La reserva ya existe.");
                }else{
			coleccionReservas.add(new Reserva(reserva));
                
                }
        }
            
        
        public Reserva buscar(Reservas reserva) {
		int indice = coleccionReservas.indexOf(reserva);
		if (indice != -1) {
			return new Reserva(coleccionReservas.get(indice));
		} else {
			return null;
		}
	}
	
	public void borrar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new IllegalArgumentException("No se puede borrar una reserva nula.");
		}
		if (!coleccionReservas.remove(reserva)) {
		}
		else {
			throw new OperationNotSupportedException("La reserva a borrar no existe.");
		}
	}

	
	
	public List <String> representar() {
            
		List<String> representacion = new ArrayList<>();
		for (Reserva reserva : coleccionReservas) {
			representacion.add(reserva.toString());
		}
		return representacion;
	}
        
        /*Pendiente adaptar
          /* getReservasProfesor: Tiene que devolver de todas las reservas realizadas, 
        aquellas que pertenecen al profesor pasado como parámetro.
        
        
        public Reserva[] getReservasProfesor(Profesor profesor) {
		if(profesor==null)
			throw new IllegalArgumentException("No se pueden comprobar las reservas de un profesor nulo.");
		Reserva[] ArrayReservasProfesor = new Reserva[MAX_RESERVAS];
		int indice = 0;
		for(int i = 0; i<numReservas; i++) {
			if(coleccionReservas[i]!=null && coleccionReservas[i].getProfesor().equals(profesor)) {
				ArrayReservasProfesor[indice] = new Reserva(coleccionReservas[i]);
				indice++;
                       }
		}
		return ArrayReservasProfesor;
	}

                       
        /* getReservasAula(Aula aula)Tiene que devolver de todas las reservas realizadas,
        aquellas que pertenecen al aula pasada como parámetro.
        
        public Reserva[] getReservasAula( Aula aula){
            
            if(aula==null)
			throw new IllegalArgumentException("No se pueden comprobar las reservas de una aula nula.");
		Reserva[] arrayReservasAula= new Reserva[MAX_RESERVAS];
		int indice = 0;
		for(int i = 0; i<numReservas; i++) {
			if(coleccionReservas[i]!=null && coleccionReservas[i].getAula().equals(aula)) {
				arrayReservasAula[indice] = new Reserva(coleccionReservas[i]);
				indice++;
                       }
		}
		return arrayReservasAula;
            
            }
        
        /*getReservasPermanencia(Permanencia permanencia)Tiene que devolver de todas las reservas realizadas, 
        aquellas cuya permanencia sea igual a la pasada como parámetros.
        
        public Reserva[] getReservasPermanencia ( Permanencia permanencia){
                
                if(permanencia==null)
			throw new IllegalArgumentException("No se pueden comprobar las reservas de una permanencia nula.");
		Reserva[] ArrayReservasPermanencia = new Reserva[MAX_RESERVAS];
		int indice = 0;
		for(int i = 0; i<numReservas; i++) {
			if(coleccionReservas[i]!=null && coleccionReservas[i].getPermanencia().equals(permanencia)) {
				ArrayReservasPermanencia[indice] = new Reserva(coleccionReservas[i]);
				indice++;
                       }
		}
		return ArrayReservasPermanencia;
        
        }
        
               
        public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		if(aula==null)
			throw new IllegalArgumentException("El aula no tiene disponibilidad.");
		if(permanencia==null)
			throw new IllegalArgumentException("La disponibilidad de la permanencia es nula.");
		for(int i = 0; i<coleccionReservas.length && coleccionReservas[i]!=null; i++) {
			if(coleccionReservas[i].getAula().equals(aula) && coleccionReservas[i].getPermanencia().equals(permanencia))
				return false;
		}
		return true;
	}
        */
            
          
}

        
        




    


    

    

