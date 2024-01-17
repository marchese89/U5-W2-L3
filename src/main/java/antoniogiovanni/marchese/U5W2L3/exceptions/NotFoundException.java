package antoniogiovanni.marchese.U5W2L3.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(int id){
        super("Elemento con id "+id+ " non trovato!");
    }
}
