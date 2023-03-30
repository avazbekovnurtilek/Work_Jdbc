package org.peaksoft;

public class baseCountry {
    private int id;
    private String city;
    private String country;
    private String president;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    @Override
    public String toString() {
        return "baseCountry - "+
                " id: " + id +";"+
                " city: " + city +";"+
                " country: " + country+";"+
                " president: " + president + "!";
    }
}
