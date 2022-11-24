public class SecurePassword {
    private String password;

    public SecurePassword(String password) {
        this.password = password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public boolean isSecure() {
        return isLongEnough() && containsUppercase() && containsLowercase() && containsDigit() && containsSpecialSymbol();
    }

    public String status() {
        String requirements = "";
        if (isSecure()) {
            return "Password is secure.";
        }

        if (!isLongEnough()) {
            requirements += "\nThis password must be at least 8 characters.";
        }
        if (!containsUppercase()) {
            requirements += "\nThis password must contain at least one uppercase letter.";
        }
        if (!containsLowercase()) {
            requirements += "\nThis password must contain at least one lowercase letter";
        }
        if (!containsDigit()) {
            requirements += "\nThis password must contain at least one digit";
        }
        if (!containsSpecialSymbol()) {
            requirements += "\nThis password must contain at least one special symbol: ! @ # $ % ^ & * ?";
        }

        return requirements;
    }

    private boolean isLongEnough() {
        return password.length() >= 8;
    }

    private boolean containsUppercase() {
        /* this one is completed for you as a hint for how to do the others! */
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);  // this method implemented below
    }

    private boolean containsLowercase() {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        return checkString(lowerCaseLetters);
    }

    private boolean containsDigit() {
        String numbers = "1234567890";
        return checkString(numbers);
    }

    private boolean containsSpecialSymbol() {
        String symbols = "!@#$%^&*?";
        return checkString(symbols);
    }

    private boolean checkString(String characterString) {
        int count = 0;
        for (int j = 0; j <= characterString.length() - 1; j ++) {
            for (int i = 0; i <= password.length() - 1; i++) {
                if (password.substring(i, i + 1).equals(characterString.substring(j, j + 1))) {
                    count ++;
                }
            }
        }
        return count > 0;
    }
}
