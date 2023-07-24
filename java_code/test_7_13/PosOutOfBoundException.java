package test_7_13;

/**
 * @author 刘浩彬
 * @date 2023/7/15
 */
public class PosOutOfBoundException extends RuntimeException{
    public PosOutOfBoundException() {
    }

    public PosOutOfBoundException(String message) {
        super(message);
    }
}
