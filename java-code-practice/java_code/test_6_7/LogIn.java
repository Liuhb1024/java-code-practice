package test_6_7;

/**
 * @author 刘浩彬
 * @date 2023/6/7
 */

public class LogIn {
    private String userName = "admin";
    private String password = "123456";

    public void loginInfo(String userName, String password) throws UserNameException,PasswordExcpetion{
        if(!this.userName.equals(userName)){
            //System.out.println("用户名有误！");
            throw new UserNameException("用户名错误!");
        }
        if (!this.password.equals(password)){
            //System.out.println("密码有误！");
            throw new UserNameException("密码错误！");
        }
        System.out.println("登陆成功！");
    }

    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        try{
            logIn.loginInfo("admin1","123456");
        }catch (UserNameException e){
            e.printStackTrace();
            System.out.println("UserNameException");
        }catch (PasswordExcpetion e){
            e.printStackTrace();
            System.out.println("PasswordExcpetion");
        }
    }
}
