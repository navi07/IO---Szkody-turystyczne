package Application.Controler;

import javafx.fxml.FXML;

public class GuiControler
{
    private WorkerPresenter workerPresenter;
    private ClientPresenter clientPresenter;

    public GuiControler() { }

    public void setWorkerPresenter(WorkerPresenter workerPresenter){
        this.workerPresenter = workerPresenter;
    }
    public void setClientPresenter(ClientPresenter clientPresenter) { this.clientPresenter = clientPresenter; }

    @FXML
    public void handlePracownikAction(){
        workerPresenter.show();
    }
    public void handleKlientAction() { clientPresenter.show(); }
    public void handleWyjdzAction() { System.exit(0); }
}

