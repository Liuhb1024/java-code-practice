package DataStructure.StackandQueue;

/**
 * @author 刘浩彬
 * @date 2023/10/9
 */
public class EmptyException extends RuntimeException{
    public EmptyException() {
    }

    public EmptyException(String message) {
        super(message);
    }
}
