package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};
    private static final String ERROR_PASSWORD_NULL = "Password can't be null";
    private static final String ERROR_LENGTH = "Password should be length [8, 32]";
    private static final String ERRORS_SUBSTRINGS = "Password shouldn't contain substrings: qwerty, 12345, password, admin, user";
    private static final String ERROR_UPPERCASE = "Password should contain at least one uppercase letter";
    private static final String ERROR_LOWERCASE = "Password should contain at least one lowercase letter";
    private static final String ERROR_DIGIT = "Password should contain at least one figure";
    private static final String ERROR_SPECIAL = "Password should contain at least one special symbol";
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 32;

    /**
     * Метод проверят пароль по правилам:
     *  1. Если password null, то выбросить исключение "Password can't be null";
     *  2. Длина пароля находится в диапазоне [8, 32],
     *     если нет то "Password should be length [8, 32]";
     *  3. Пароль содержит хотя бы один символ в верхнем регистре,
     *     если нет то "Password should contain at least one uppercase letter");
     *  4. Пароль содержит хотя бы один символ в нижнем регистре,
     *     если нет то "Password should contain at least one lowercase letter";
     *  5. Пароль содержит хотя бы одну цифру,
     *     если нет то"Password should contain at least one figure");
     *  6. Пароль содержит хотя бы один спец. символ (не цифра и не буква),
     *     если нет то "Password should contain at least one special symbol");
     *  7. Пароль не содержит подстрок без учета регистра: qwerty, 12345, password, admin, user.
     *     Без учета регистра, значит что, например, ни qwerty ни QWERTY ни qwErty и т.п.
     *     если да, то "Password shouldn't contain substrings: qwerty, 12345, password, admin, user".
     * @param password Пароль
     * @return Вернет пароль или выбросит исключение.
     */
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException(
                    ERROR_PASSWORD_NULL
            );
        }
        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            throw new IllegalArgumentException(
                    ERROR_LENGTH
            );
        }

        boolean hasUpCase = false;
        boolean hasLowCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char symbol : password.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                hasUpCase = true;
            }
            if (Character.isLowerCase(symbol)) {
                hasLowCase = true;
            }
            if (Character.isDigit(symbol)) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(symbol)) {
                hasSpecial = true;
            }
            if (hasUpCase && hasLowCase && hasDigit && hasSpecial) {
                break;
            }
        }
        String lowerPassword = password.toLowerCase();
        for (String forbidden : FORBIDDEN) {
            if (lowerPassword.contains(forbidden)) {
                throw new IllegalArgumentException(ERRORS_SUBSTRINGS);
            }
        }
        if (!hasUpCase) {
            throw new IllegalArgumentException(
                    ERROR_UPPERCASE
            );
        }
        if (!hasLowCase) {
            throw new IllegalArgumentException(
                    ERROR_LOWERCASE
            );
        }
        if (!hasDigit) {
            throw new IllegalArgumentException(
                    ERROR_DIGIT
            );
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException(
                    ERROR_SPECIAL
            );
        }
        return password;
    }
}