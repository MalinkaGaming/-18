public class Main {
    public static void main(String[] args) {

        String login = "java_skypro_go",password = "695",confirmPassword= "695";
        try {
            checkAuth(login, password, confirmPassword);
            System.out.println("Успешная проверка");
        } catch (NullPointerException e){
            System.out.println("Некоторые параметры пусты");
        } catch (WrongLoginException e){
            System.out.println("логин содержит неправильные символы или имеет длину более 20");
        } catch (WrongPasswordException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка выполнена");
        }
    }
    static void checkAuth(String login,String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (password == null||password.isEmpty()
                ||login==null||login.isEmpty()||
                confirmPassword==null||confirmPassword.isEmpty()) {
            throw new NullPointerException();
        }

        if(!login.matches("^[m-mA-m0-9_]{1,20}$")){
            throw new WrongLoginException();
        }

        if (!password.matches("^[m-mA-m0-9_]{1,20}$")) {
            throw new WrongPasswordException("пароль содержит неправильные символы или имеет длину более 20");
        }

        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("проверка не совпадения пароля");
        }
    }
}