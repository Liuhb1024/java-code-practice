package test_6_7;

/**
 * @author 刘浩彬
 * @date 2023/6/7
 */
public class PasswordExcpetion extends RuntimeException{
    public PasswordExcpetion() {
    }

    public PasswordExcpetion(String message) {
        super(message);
    }
}
