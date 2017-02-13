package model;

/**
 * Created by ghane on 2/13/2017.
 */

public class country {
    private String name;
    private population population;

    public country(String name, model.population population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public model.population getPopulation() {
        return population;
    }

    public void setPopulation(model.population population) {
        this.population = population;
    }
}
