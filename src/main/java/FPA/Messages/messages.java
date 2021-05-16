package FPA.Messages;

public class messages {
    private String from;
    private String to;
    private String mess;

    public messages(String from, String to, String mess) {
        this.from = from;
        this.to = to;
        this.mess = mess;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
