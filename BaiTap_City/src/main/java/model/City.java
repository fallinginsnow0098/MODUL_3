package model;

public class City {
    private int id;
    private String name;
    private double popular;
    private double area;
    private double gdp;
    private String country;

    public City(int id, String name, double popular, double area, double gdp, String country) {
        this.id = id;
        this.name = name;
        this.popular = popular;
        this.area = area;
        this.gdp = gdp;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopular() {
        return popular;
    }

    public void setPopular(double popular) {
        this.popular = popular;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", popular=" + popular +
                ", area=" + area +
                ", gdp=" + gdp +
                ", country='" + country + '\'' +
                '}';
    }
}
