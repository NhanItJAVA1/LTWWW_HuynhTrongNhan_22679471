package iuh.fit.tuan_javabeann.autowired;

public class MyNumberFormatter implements MyFormatter{
    @Override
    public String format(String message) {
        return "Number: " + message;
    }
}
