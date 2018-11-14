package com.br.neogridconference;

/**
 * Esta classe representa cada atividade "Activity" . tem dois atributos, nome e
 * tempo. Retorna um objeto do tipo Activity
 */
public class Activity {

    private String name;
    int time;

    public Activity(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
       return String.format("ActivityObject{name= %s, time= %d}", this.name, this.time);
    }
}
