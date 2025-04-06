package Dominios;

public class AçogueiroCity extends PessoaCity implements SaldoBancarioCity {


    public AçogueiroCity(String nameOfPerson, String bankOfPerson) {
        super(nameOfPerson, bankOfPerson);


    }



    public void SaldoBancario(){
        SaldoBancarioCity = 0;
    }


    @Override
    public String getIdOfUser() {
        return super.getIdOfUser();
    }


    public void MostrarId(){
        System.out.println("ID DO AÇOGUEIRO É : " + getIdOfUser());
    }

}


//s
