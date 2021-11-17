package javaBasics.klasaAbstrakcyjnaInterface;

public class Home {
    public static void main (String[] args)
    {
        Nosy n = new Nosy();
        n.onTV(true);
        System.out.println(n.toString());
    }
}
