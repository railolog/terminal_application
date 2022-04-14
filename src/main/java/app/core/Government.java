package app.core;

public enum Government {
    KLEPTOCRACY ("Клептократия"),
    NOOCRACY ("Ноократия"),
    OLIGARCHY ("Олигархия");

    private String title;

    Government(String title){
        this.title = title;
    }


    @Override
    public String toString() {
        return title;
    }
}
