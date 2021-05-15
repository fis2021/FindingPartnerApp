package FPA.Controlers;

import FPA.Services.AnnoucementServices;
import FPA.View.LogInView;

public class AnnoucementController {
    private LogInView view;

    public AnnoucementController(LogInView view) {
        this.view = view;
    }

    public void addAnnouce(String annouce)
    {
        AnnoucementServices.addAnnouce(annouce);
    }
}
