package br.com.boasaude.cadastro.prestador.core.domain.vo;

public enum TipoPrestador {

	FISICA("F"),
    JURIDICA("J"),
    NAO_INFORMADO("X");

    private String value;

     TipoPrestador(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static TipoPrestador fromValue(String text){
         for(TipoPrestador tipo: values()){
             if(String.valueOf(tipo.value).equalsIgnoreCase(text)){
                 return tipo;
             }
         }
         return NAO_INFORMADO;
    }
}

