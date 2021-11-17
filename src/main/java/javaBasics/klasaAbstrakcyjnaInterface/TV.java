package javaBasics.klasaAbstrakcyjnaInterface;

public abstract class TV implements ChangeChannel, Change{
    //informuje nas ze jest klasa abstrakcyjna tzn nie mozna utworzyc jej instancji, jej wystapienia

    public abstract void onTV(boolean b);

    @Override
    public String toString(){
        return "Metoda toString klasy TV";
    }

}
