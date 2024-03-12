package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return result;
    }

    public static void sent(String value, String[] abuses) throws ElementAbuseException {
        for (String abus : abuses) {
            if (value.equals(abus)) {
                throw new ElementAbuseException("Illegal key");
            }
        }
    }

    public static void process(String[] value, String key, String[] abuses) {
        try {
            if (indexOf(value, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] value = {"cat", "dog", "pig"};
        String key = "cat";
        String[] abuses = {"dog", "pig"};
        process(value, key, abuses);
    }
}