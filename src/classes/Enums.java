package classes;

public class Enums {
    public enum CodigoCarta{
        AZ(1), 
        DOIS(2), 
        TRES(3), 
        QUATRO(4), 
        CINCO(5), 
        SEIS(6), 
        SETE(7), 
        OITO(8), 
        NOVE(9), 
        DEZ(10), 
        DAMA(11), 
        VALETE(12), 
        REI(13);

        private int code;

        private CodigoCarta(int code){
            this.code = code;
        }

        public int getCode(){
            return code;
        }

        public static CodigoCarta valueOf(int code){
            for (CodigoCarta value : CodigoCarta.values()) {
               if(value.getCode() == code) {
                   return value;
               }
            }
            throw new IllegalArgumentException("Número da carta inválido");
        }
    }

    public enum NaipeCarta{
        COPAS(1), 
        OURO(2),
        ESPADA(3), 
        PAUS(4);

        private int code;
        private NaipeCarta(int code){
            this.code = code;
        }
        public int getCode(){
            return code;
        }

        public static NaipeCarta valueOf(int code){
            for (NaipeCarta value : NaipeCarta.values()) {
               if(value.getCode() == code) {
                   return value;
               }
            }
            throw new IllegalArgumentException("Naipe inválido");
        }
    }

}
