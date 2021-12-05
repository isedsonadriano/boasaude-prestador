package br.com.boasaude.cadastro.prestador.core.domain.vo;

import java.util.Random;

public enum TipoPrestador {

	MEDICO("M"),
    ENFEIMEIRO("E"),
    NUTRICIONISTA("N"),
    FISIOTERAPEUTA("F"),
    DENTISTA("D"),
    NAO_INFORMADO("NI");

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
    
    public static TipoPrestador getRandomTipoPrestador() {
    	return values()[new Random().nextInt(4)];
    }
}

