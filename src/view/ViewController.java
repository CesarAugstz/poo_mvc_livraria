package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.util.Alerts;

public class ViewController {

	@FXML
	private Button btNewUser;

	@FXML
	public void onBtNewUserAction() {
		System.out.println("click");
	}

	@FXML
	private Button btRegisterRent;

	@FXML
	public void onBtRegisterRent() {
		System.out.println("click1");
	}

	@FXML
	private Button btNewRegisterRead;

	@FXML
	public void onBtRegisterRead() {
		System.out.println("click2");
	}

	@FXML
	private Button btNewBook;

	@FXML
	public void onBtNewBook() {
		System.out.println("click3");
	}

	@FXML
	private Button btNewPromotion;

	@FXML
	public void onBtNewPromotion() {
		System.out.println("click4");
	}

	@FXML
	private Button btRegisterSell;

	@FXML
	public void onBtRegisterSell() {
		System.out.println("click5");
	}
}