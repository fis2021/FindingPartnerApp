package FPA.Controlers;

import FPA.Services.MessagesServices;
import FPA.View.LogInView;

public class MessagesController {
    private LogInView view;

    public MessagesController(LogInView view) {
        this.view = view;
    }

    public void sendMessage(String from, String to, String mess)
    {
        MessagesServices.addMessage(from,to,mess);
    }
}
