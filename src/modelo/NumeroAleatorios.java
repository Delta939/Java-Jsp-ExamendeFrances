package modelo;
import java.util.ArrayList;

/**
 * 
 * @author Francisco Garcia Martinez
 * @author e-mail:tank1002016@yahoo.com
 * @version 3.0  1/06/2016 
 *
 *
 */

public class NumeroAleatorios {
    private int valorInicial;
    private int valorFinal;
    private ArrayList<Integer> listaNumero;

    public NumeroAleatorios(int valorInicial, int valorFinal){
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        listaNumero = new ArrayList<Integer>();
    }
    
    private int numeroAleatorio(){
        return (int)(Math.random()*(valorFinal-valorInicial+1)+valorInicial);
    }
    
    public int generar(){
        if(listaNumero.size() < (valorFinal - valorInicial) +1){//Aun no se han generado todos los numeros
            int numero = numeroAleatorio();//genero un numero
            if(listaNumero.isEmpty()){//si la lista esta vacia
                listaNumero.add(numero);
                return numero;
            }else{//si no esta vacia
                if(listaNumero.contains(numero)){//Si el numero que generé esta contenido en la lista
                    return generar();//recursivamente lo mando a generar otra vez
                }else{//Si no esta contenido en la lista
                    listaNumero.add(numero);
                    return numero;
                }
            }
        }else{// ya se generaron todos los numeros
            return -1;
        }
    }
}
