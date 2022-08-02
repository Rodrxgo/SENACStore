package Utils;

import java.awt.Toolkit;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.Locale;

public class Utils {
    /**
     * 
     * @param txt - valor proveniente da view a ser validado se pode ser convertido para int
     * @param convertToDouble - false: txt é um int, true: txt é um Double
     * @return boolean - true: sucesso (pode converter), false: falha (não pode converter)
     */
    public static boolean validaNumero(String txt){
        try {
            Double.parseDouble(txt);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    
    /**
     * s
     * @param value - valor que deseja arredondar
     * @param places - numero de casas decimais desejadas
     * @return double - valor arredondado
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    /**
     * 
     * @param resultado - objeto ResultSet resultante da consulta no DB
     * @param nomeValorColuna - Nome da coluna que possui o valor à ser retorando do DB
     * @return String - retorna o valor formatado em pt-br #.###,##
     */
    public static String formatPtBr(ResultSet resultado, String nomeValorColuna){
        String valorFinal = "";
        
        try {
            Locale localBrasil = new Locale("pt", "BR");
            Double valorAtual = Double.parseDouble(resultado.getString(nomeValorColuna));
            valorFinal = NumberFormat.getCurrencyInstance(localBrasil).format(valorAtual);
            valorFinal = valorFinal.replace("R$", "").trim();
            
            return valorFinal;
        } catch (Exception e){
            return valorFinal;
        }
    }
}
