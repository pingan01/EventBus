package com.pingan.eventbus;

/**
 * Created time : 2019/6/3 11:05.
 *
 * @author LKKJ
 */
public class EventMessage {

    public final String message;


    private EventMessage(String message) {
        this.message = message;
    }

    public static EventMessage getInstance(String message) {
        return new EventMessage(message);

    }
}
