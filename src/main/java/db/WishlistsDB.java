package db;

import java.sql.*;

public class WishlistsDB {
    public static final WishlistsDB INSTANCE = new WishlistsDB();

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private static final String ADD_WISHLIST_QUERY = "INSERT INTO wishlists (wishlist_name, user_id) VALUES (?,?);";
    private static final String REMOVE_WISHLIST_QUERY = "DELETE FROM wishlists WHERE user_id = ? AND wishlist_name = ?;";
    private static final String SHOW_WISHLISTS_QUERY = "SELECT * FROM wishlists WHERE user_id = ?;";
    private static final String FIND_WISHLIST_QUERY = "SELECT COUNT(*) FROM wishlists WHERE user_id = ? AND wishlist_name = ?;";

    private WishlistsDB() {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Соединение с базой данных успешно установлено!");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addWishlist(String wishlistName, int userID) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_WISHLIST_QUERY)) {

            preparedStatement.setString(1, wishlistName);
            preparedStatement.setInt(2, userID);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Вишлист успешно добавлен в таблицу.");
            } else {
                System.out.println("Что-то пошло не по плану");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении вишлиста: " + e.getMessage());
        }
    }

    public void removeWishlist(String wishlistName, int userID) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_WISHLIST_QUERY)) {

            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, wishlistName);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Вишлист успешно удален из таблицы.");
            } else {
                System.out.println("Что-то пошло не по плану");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении вишлиста: " + e.getMessage());
        }
    }

    public String getWishlists(int userID) {
        String wishlists = "Ваши вишлисты: \n";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SHOW_WISHLISTS_QUERY)) {

            preparedStatement.setInt(1, userID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                wishlists += "Вишлист " + resultSet.getString("wishlist_name")
                        + " \n" + resultSet.getString("wishlist") + " \n";
            }
        } catch (SQLException e) {
            System.err.println("Ошибка вывода вишлиста: " + e.getMessage());
        }

        return wishlists;
    }

    public boolean findWishlist(String wishlistName, int userID) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_WISHLIST_QUERY)) {

            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, wishlistName);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1)>0;
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении вишлиста: " + e.getMessage());
        }

        return false;
    }
}
