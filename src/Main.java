public class Main {

    //static Pattern pattern = Pattern.compile("[a-zA-Z]");

    public static void main(String[] args) {

        String login = "Alex_Nikki_Tasya";
        String password = "asdfskdjfJHV3245";
        String confirmPass = "asdfskdjfJHV3245";

        checkLoginAndPass(login, password, confirmPass);
    }

    static void checkLoginAndPass(String login, String password, String confirmPass) {
        if (login.length() > 20 || checkSymbol(login) != login.length()) {
            throw new RuntimeException("WrongLoginException.");
        } //else { System.out.println("login " + login + " - OK"); }
        if (password.length() > 20 ||
                ((checkSymbol(password) + checkNumber(password)) < password.length()) ||
                (!(password.equals(confirmPass)))) {
            throw new RuntimeException("WrongPasswordException.");
        } //else { System.out.println("Password " + password + " - OK"); }
    }

    public static int checkSymbol(String word) {
        int count = 0;
        char[] symbols = word.toCharArray();
        for (char temp : symbols) {
            if ((int) temp > 64 && (int) temp < 91) { count++; }
            if ((int) temp > 96 && (int) temp < 123) { count++; }
            if ((int) temp == 95) { count++; }
        }
        return count;
    }
    public static int checkNumber(String word) {
        int count = 0;
        char[] symbols = word.toCharArray();
        for (char temp : symbols) {
            if ((int) temp > 47 && (int) temp < 58) { count++; }
        }
        return count;
    }

        // 48 - 57 = 0-9, 65 - 90 = A-Z, 95 = _, 97 - 122 = a-z
}