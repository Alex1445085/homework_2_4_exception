public class Main {

    //static Pattern pattern = Pattern.compile("[a-zA-Z]");

    public static void main(String[] args) {

        String login = "Alex_Nikki";
        String password = "AsdfskdjfJHV3245";
        String confirmPass = "AsdfskdjfJHV3245";
        try {
            checkLoginAndPass(login, password, confirmPass);
        } catch (RuntimeException ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Check is end.");
        }

    }

    static void checkLoginAndPass(String login, String password, String confirmPass) {
        if (login.length() > 20 || checkSymbol(login) != login.length()) {
            throw new RuntimeException("WrongLoginException.");
        } //else { System.out.println("login " + login + " - OK"); }
        if (password.length() > 20 ||
                checkPass(password) < password.length() ||
                (!(password.equals(confirmPass)))) {
            throw new RuntimeException("WrongPasswordException.");
        } //else { System.out.println("Password " + password + " - OK"); }
    }

    public static int checkSymbol(String word) {
        int count = 0;
        char[] symbols = word.toCharArray();
        for (char temp : symbols) {
            if ((int) temp >= 65 && (int) temp <= 90) {
                count++;
            }
            if ((int) temp >= 97 && (int) temp <= 122) {
                count++;
            }
            if ((int) temp == 95) {
                count++;
            }
        }
        return count;
    }

    public static int checkPass(String word) {
        int count = checkSymbol(word);
        char[] symbols = word.toCharArray();
        for (char temp : symbols) {
            if (temp >= 48 && temp <= 57) {
                count++;
            }
        }
        return count;
    }

    // 48 - 57 = 0-9, 65 - 90 = A-Z, 95 = _, 97 - 122 = a-z
}