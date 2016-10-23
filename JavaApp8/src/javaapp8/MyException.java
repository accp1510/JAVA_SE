package javaapp8;

import java.util.Date;

//создание собственного исключения
public class MyException extends Exception {
    private Object o;
    private Date date;

    public MyException(String message, Object o, Date date) {
        super(message);
        this.o=o;
        this.date= date;
    }

    public String getMessage() {
        return super.getMessage() + "Это произошло "+date.toString()+ " в " + o.getClass();
    }
}
