package ru.itis.OOP;

public class Money {
    public long rubles;
    public byte pennies;

    public Money(){
        this(0,0);
    }

    public Money(long rubles, int pennies){
        this.rubles = rubles;
        addPennies(pennies);
    }

    public void addPennies(int pennies){
        if(pennies >= 100){
            this.rubles += pennies / 100;
            pennies %= 100;
            this.pennies = (byte)(pennies);
        }else if(pennies < 0){
            this.rubles -= (pennies / 100) + 1;
            pennies += 100;
            this.pennies = (byte)(pennies);
        }
        this.pennies = (byte)pennies;
    }

    public Money sum(Money money){
        Money m = new Money();
        m.rubles = this.rubles + money.rubles;
        m.addPennies((this.pennies + money.pennies));
        return m;
    }

    public Money subtraction(Money money){
        Money m = new Money();
        m.rubles = this.rubles - money.rubles;
        m.addPennies((this.pennies - money.pennies));
        return m;
    }

    public Money multiplication(int k){
        Money m = new Money();
        m.rubles = this.rubles * k;
        m.addPennies((this.pennies*k));
        return m;
    }

    public boolean equals(Money m) {
        return (m.rubles == this.rubles && m.pennies == this.pennies);
    }

    @Override
    public String toString(){
        return rubles + "," + pennies;
    }
}
