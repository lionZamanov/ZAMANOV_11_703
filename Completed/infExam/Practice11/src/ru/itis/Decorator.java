package ru.itis;

public abstract class Decorator implements InterfaceComponent{

    protected InterfaceComponent component;

    public Decorator(InterfaceComponent c){
        component = c;
    }

    @Override
    public void crawl() {
        component.crawl();
    }

    public void say(){
        System.out.println("nothing");
    }

    public void fly(){
        System.out.println("nothing");
    }
}
