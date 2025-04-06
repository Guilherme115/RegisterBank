package Dominios;

public class BombeiroCity extends PessoaCity {
    public BombeiroCity(String nameOfPerson, String bankOfPerson) {
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


