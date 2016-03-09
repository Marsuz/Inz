package core.model;

/**
 * Created by Marcin on 2016-03-09.
 */
public class Response {

    private int id;
    private String message;

    public Response(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

}
