package br.com.javafacestest.view.util;

public class AppException extends Exception {

    private static final long serialVersionUID = 8095399321989525818L;

    private TipoException tipoException;

    public AppException(String txtException, TipoException tipoException) {
        super(txtException);
        this.tipoException = tipoException;
    }
    
    @SuppressWarnings("rawtypes")
    public AppException(String txtException, TipoException tipoException, Class clazz) {
     
    	super(txtException);
    	
        this.tipoException = tipoException;

        /**
    	 * LOGANDO EM TXT CONFORME O TIPO E EXCESSAO
    	 **/
        if(tipoException.getValue().equalsIgnoreCase("Warn")){
        	
        	System.out.println(txtException);
        	
        }else if(tipoException.getValue().equalsIgnoreCase("Error")){

        	System.out.println(txtException);
        	
        }
        
    }

    public TipoException getTipoException() {
        return tipoException;
    }

    public void setTipoException(TipoException tipoException) {
        this.tipoException = tipoException;
    }

}
