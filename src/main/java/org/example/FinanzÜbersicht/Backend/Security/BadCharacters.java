package org.example.FinanzÜbersicht.Backend.Security;

public class BadCharacters {
    public String[] getBadChars() {
        return new String[]{"'", "\"", "<", ">", "&", "*"};
    }
}
