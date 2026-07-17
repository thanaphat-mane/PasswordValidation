public class PasswordValidator {

    static final int MIN_LEN = 8;
    static final int MAX_LEN = 20;

    static boolean validate(String pw) {
        if (pw == null)
            throw new IllegalArgumentException();
        if (pw.length() < MIN_LEN)
            return false;
        if (pw.length() > MAX_LEN)
            return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        for (int i = 0; i < pw.length(); i++) {
            Character c = pw.charAt(i);
            if (c == ' ')
                return false;
            if (Character.isUpperCase(c))
                hasUpper = true;
            if (Character.isLowerCase(c))
                hasLower = true;
            if (Character.isDigit(c))
                hasDigit = true;

        }

        return hasUpper && hasLower && hasDigit;
    }
}
