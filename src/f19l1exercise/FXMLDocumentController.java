/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f19l1exercise;

import ancient_encryption.AtbashCipher;
import ancient_encryption.CeasarCipher;
import ancient_encryption.CipherInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import opg4_polymorphism.ShapeFacade;

/**
 *
 * @author Benjamin Staugaard | Benz56
 */
public class FXMLDocumentController implements Initializable {

    // Encryption Exercise
    @FXML
    private TextField inputField;

    @FXML
    private ToggleGroup type;

    @FXML
    private Spinner<Integer> spinner;

    @FXML
    private TextField encryptField;

    @FXML
    private TextField decryptField;

    // Shape Exercise
    @FXML
    private ToggleGroup shape;

    @FXML
    private TextField shapeInput1;

    @FXML
    private TextField shapeInput2;

    @FXML
    private TextArea infoArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, CipherInterface.ALPHABETH.length - 1, CipherInterface.ALPHABETH.length / 2));
        shape.selectedToggleProperty().addListener((observable, oldValue, newValue) -> shapeInput2.setVisible(shape.getToggles().indexOf(newValue) < 2));
        shape.getToggles().get(0).setUserData(ShapeFacade.SHAPES.ELLIPSE);
        shape.getToggles().get(1).setUserData(ShapeFacade.SHAPES.RECTANGLE);
        shape.getToggles().get(2).setUserData(ShapeFacade.SHAPES.CIRCLE);
        shape.getToggles().get(3).setUserData(ShapeFacade.SHAPES.SQUERE);
    }

    @FXML
    private void onButtonClick(ActionEvent event) {
        CipherInterface cipherInterface = type.getToggles().indexOf(type.getSelectedToggle()) == 0 ? new AtbashCipher() : new CeasarCipher(spinner.getValue());

        if (((Button) event.getSource()).getText().equalsIgnoreCase("encrypt")) {
            encryptField.setText(cipherInterface.encrypt(inputField.getText()));
        } else {
            decryptField.setText(cipherInterface.decrypt(encryptField.getText()));
        }
    }

    @FXML
    private void onGetInfo(ActionEvent event) {
        ShapeFacade.SHAPES selectedShape = (ShapeFacade.SHAPES) this.shape.getSelectedToggle().getUserData();
        try {
            if (!shapeInput2.isVisible()) {
                infoArea.setText(ShapeFacade.getInstance().getShapeInfo(selectedShape, Double.parseDouble(shapeInput1.getText())));
            } else {
                infoArea.setText(ShapeFacade.getInstance().getShapeInfo(selectedShape, Double.parseDouble(shapeInput1.getText()), Double.parseDouble(shapeInput2.getText())));
            }
        } catch (NumberFormatException e) {
            infoArea.setText("Invalid input...");
        }
    }
}
