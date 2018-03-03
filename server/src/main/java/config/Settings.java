package config;

public enum Settings {
    PORT("1234"),
    FORMAT_DATE("dd.MM.yyyy"),
    FORMAT_TIME("hh:mm:ss");

    private String attribute;

    Settings(String attribute) {
        this.attribute = attribute;
    }

    public String get() {
        return this.attribute;
    }
}
