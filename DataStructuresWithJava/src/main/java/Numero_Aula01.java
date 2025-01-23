public class Numero_Aula01 {
    public Numero_Aula01(){
        this.value = 0;
    }
//    atributo / campo
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        if (value<0){
            value=0;
            msg("value less than zero -> correct to zero.");
        } else if (value>40 && value <60) {
            if (value<50){
                value=40;
                msg("value in unsupported range -> fix to 40.");
            }else {
                value=60;
                msg("value in unsupported range -> fix to 60.");
            }
        }
        this.value=value;
        System.out.println("Novo valor atribuido");
    }

    private void msg(String texto){
        System.out.println("!!! Atenção: " + texto +"!!!");
    }

}
