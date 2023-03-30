package org.peaksoft;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
//       createTable();
//        addCountry("Bishkek","Kyrgyzstan","Sadyr Zhaparov");
//        addCountry("Washington","USA","Joe Baiden");
//        addCountry("Moscow","Russia","Vladimir Putin");
//        addCountry("Astana","Kazakhstan","Zhomart Tokaev");
//        addCountry("Ankara","Turkey","Recep Erdogan");
//        addCountry("Beijing","China","Xi Jinping");
//        System.out.println(getCount());
        selectCountry(5);
        for (baseCountry baseCountry : getList()) {
            System.out.println(baseCountry);
        }
    }
    public static void createTable(){
        String SQL = "CREATE TABLE basecountry("+
                "id SERIAL PRIMARY KEY," +
                "city VARCHAR(50) NOT NULL," +
                "country VARCHAR(50) NOT NULL," +
                "president VARCHAR(50) NOT NULL);";
        try (Connection connection = Db.connection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void addCountry(String city,String country,String president){
        String SQL = "INSERT INTO basecountry(city,country,president)"+
                "VALUES(?,?,?)";
        try (Connection connection = Db.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setString(1,city);
            preparedStatement.setString(2,country);
            preparedStatement.setString(3,president);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static List<baseCountry> getList() {
        String SQL = "SELECT * FROM basecountry";
        List<baseCountry> baseCountries = new ArrayList<>();
        try (Connection connection = Db.connection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                baseCountry baseCountry = new baseCountry();
                baseCountry.setId(resultSet.getInt("id"));
                baseCountry.setCity(resultSet.getString("city"));
                baseCountry.setCountry(resultSet.getString("country"));
                baseCountry.setPresident(resultSet.getString("president"));
                baseCountries.add(baseCountry);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }return baseCountries;
    }
    public static void selectCountry(int id){
        String SQL = "SELECT * FROM basecountry WHERE id = ?";
        try (Connection connection = Db.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Выведен "+id);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
