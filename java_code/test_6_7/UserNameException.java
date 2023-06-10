package test_6_7;

/**
 * @author 刘浩彬
 * @date 2023/6/7
 * @Description：
 */
public class UserNameException extends RuntimeException{
    public UserNameException() {
    }

    public UserNameException(String message) {
        super(message);
    }
}
