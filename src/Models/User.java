package Models;

import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static final AtomicInteger ID_FACTORY = new AtomicInteger();
    private final int id;
    private String name;

    public User(String name){
        this.id = ID_FACTORY.getAndIncrement();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public final int getId() {
        return id;
    }
}
