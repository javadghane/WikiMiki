package model;

/**
 * Created by ghane on 2/13/2017.
 */

public class population {

    private int females;
    private int males;
    private int age;
    private String countryName;
    private int year;

    public population(int femails, int males, int age, String countryName, int year) {
        this.females = femails;
        this.males = males;
        this.age = age;
        this.countryName = countryName;
        this.year = year;
    }

    public int getFemales() {
        return females;
    }

    public void setFemales(int females) {
        this.females = females;
    }

    public int getMales() {
        return males;
    }

    public void setMales(int males) {
        this.males = males;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
