import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GuiControler {

    private WorkerPresenter workerPresenter;

    public GuiControler() {
       // this.workerPresenter=workerPresenter;
    }

    public void setWorkerPresenter(WorkerPresenter workerPresenter){
        this.workerPresenter = workerPresenter;
    }
    @FXML
    private Button pracownikId;
    @FXML
    public void handlePracownikAction(){
        workerPresenter.show();
    }
}

