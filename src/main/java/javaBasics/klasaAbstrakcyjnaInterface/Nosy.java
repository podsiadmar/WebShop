package javaBasics.klasaAbstrakcyjnaInterface;

public class Nosy extends TV implements ChangeChannel{


    @Override
    public void onTV(boolean b) {
        if (b)
            System.out.println("TV IS ON");
        else
            System.out.println("TV IS OFF");
    }

    @Override
    public void changeChannel() {
        System.out.println("Zmiana kanału");
    }

//    @Override
//    public String toString(){
//        return "Metoda toString klasy Nosy";
//    }


}
