package server;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password);

    boolean newNick(String nickname , String newnick);
    boolean registration(String login, String password, String nickname);
}
