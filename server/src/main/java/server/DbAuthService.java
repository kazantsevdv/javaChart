package server;

import java.sql.*;

public class DbAuthService implements AuthService {
    private Connection connection;


    public DbAuthService() {

        try {
            connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        PreparedStatement psgetnnick = null;
        ResultSet rs = null;
        String res = null;

        try {
            psgetnnick = connection.prepareStatement("SELECT login, password, nickname FROM users WHERE login=? and password=? LIMIT 1;");
            psgetnnick.setString(1, login);
            psgetnnick.setString(2, password);
            rs = psgetnnick.executeQuery();
            if (rs.next()) {
                res = rs.getString("nickname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (psgetnnick != null) {
                    psgetnnick.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public boolean newNick(String nickname, String newnickname) {
        PreparedStatement psnewnick = null;
        try {
            psnewnick = connection.prepareStatement("UPDATE users SET nickname=? WHERE nickname=?;");
            psnewnick.setString(2, nickname);
            psnewnick.setString(1, newnickname);

            if (psnewnick.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psnewnick != null) {
                    psnewnick.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        PreparedStatement psadduser = null;

        try {
            //проверка на уникалбность логина и ника в базе
            psadduser = connection.prepareStatement("INSERT INTO users (login, password, nickname) VALUES (?, ?, ?);");
            psadduser.setString(1, login);
            psadduser.setString(2, password);
            psadduser.setString(3, nickname);
            if (psadduser.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (psadduser != null) {
                    psadduser.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:db.db");
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        disconnect();

    }


}
