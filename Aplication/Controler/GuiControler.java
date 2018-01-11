package Aplication.Controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GuiControler
{
    private WorkerPresenter workerPresenter;

    public GuiControler() { }

    public void setWorkerPresenter(WorkerPresenter workerPresenter){
        this.workerPresenter = workerPresenter;
    }

    @FXML
    public void handlePracownikAction(){
        workerPresenter.show();
    }
}

