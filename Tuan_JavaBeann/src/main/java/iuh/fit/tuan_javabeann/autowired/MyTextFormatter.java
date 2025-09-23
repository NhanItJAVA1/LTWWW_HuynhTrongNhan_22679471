package iuh.fit.tuan_javabeann.autowired;

public class MyTextFormatter implements MyFormatter{
    @Override
    public String format(String message) {
        return "Text:" + message;
    }
}
