import CalcInterpreter.Interpreter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.text.DecimalFormat;

public class Controller {
    public Controller() {
    }

    Interpreter interpreter = new Interpreter();

    public void init() {
//        Initialize labels
        inputLabel.setText("");
        outputLabel.setText("0");
//        Initialize mouse click/text change listener
        numButton0.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "0"));
        numButton1.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "1"));
        numButton2.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "2"));
        numButton3.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "3"));
        numButton4.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "4"));
        numButton5.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "5"));
        numButton6.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "6"));
        numButton7.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "7"));
        numButton8.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "8"));
        numButton9.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "9"));
        numButton00.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "00"));
        dotButton.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "."));
        clearButton.setOnMouseClicked(e -> inputLabel.setText(""));
        backspaceButton.setOnMouseClicked(e -> {
                    if (inputLabel.getText().length() > 0)
                        inputLabel.setText(inputLabel.getText().substring(0, inputLabel.getText().length() - 1));
                }
        );
        plusButton.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "+"));
        minusButton.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "-"));
        multiplyButton.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "*"));
        divideButton.setOnMouseClicked(e -> inputLabel.setText(inputLabel.getText() + "/"));
        inputLabel.textProperty().addListener((observable, oldValue, newValue) -> processInput());

//        Initialize color changes, Dirty code but cant find another method to achieve this now without css
        setUpColors();        
    }
    

    void processInput() {
        if (inputLabel.getText().length() > 0) {
            try {
                if (!Character.isDigit(inputLabel.getText().charAt(inputLabel.getText().length() - 1))) {
                    interpreter.interpret(inputLabel.getText().substring(0, inputLabel.getText().length() - 1));
                } else {
                    interpreter.interpret(inputLabel.getText());
                }
            } catch (RuntimeException re) {
                outputLabel.setText("Error");
            }
            DecimalFormat df = new DecimalFormat("#.############");
            outputLabel.setText(df.format(interpreter.getLastResult()));
        } else {
            outputLabel.setText("0");
        }
    }
    
    void setUpColors(){
        numButton0.setOnMouseEntered(e -> numButton0.setStyle("-fx-background-color : #757575"));
        numButton0.setOnMousePressed(e -> numButton0.setStyle("-fx-background-color : #424242"));
        numButton0.setOnMouseReleased(e -> numButton0.setStyle("-fx-background-color : #757575"));
        numButton0.setOnMouseExited(e -> numButton0.setStyle("-fx-background-color : #616161"));

        numButton1.setOnMouseEntered(e -> numButton1.setStyle("-fx-background-color : #757575"));
        numButton1.setOnMousePressed(e -> numButton1.setStyle("-fx-background-color : #424242"));
        numButton1.setOnMouseReleased(e -> numButton1.setStyle("-fx-background-color : #757575"));
        numButton1.setOnMouseExited(e -> numButton1.setStyle("-fx-background-color : #616161"));

        numButton2.setOnMouseEntered(e -> numButton2.setStyle("-fx-background-color : #757575"));
        numButton2.setOnMousePressed(e -> numButton2.setStyle("-fx-background-color : #424242"));
        numButton2.setOnMouseReleased(e -> numButton2.setStyle("-fx-background-color : #757575"));
        numButton2.setOnMouseExited(e -> numButton2.setStyle("-fx-background-color : #616161"));

        numButton3.setOnMouseEntered(e -> numButton3.setStyle("-fx-background-color : #757575"));
        numButton3.setOnMousePressed(e -> numButton3.setStyle("-fx-background-color : #424242"));
        numButton3.setOnMouseReleased(e -> numButton3.setStyle("-fx-background-color : #757575"));
        numButton3.setOnMouseExited(e -> numButton3.setStyle("-fx-background-color : #616161"));

        numButton4.setOnMouseEntered(e -> numButton4.setStyle("-fx-background-color : #757575"));
        numButton4.setOnMousePressed(e -> numButton4.setStyle("-fx-background-color : #424242"));
        numButton4.setOnMouseReleased(e -> numButton4.setStyle("-fx-background-color : #757575"));
        numButton4.setOnMouseExited(e -> numButton4.setStyle("-fx-background-color : #616161"));

        numButton5.setOnMouseEntered(e -> numButton5.setStyle("-fx-background-color : #757575"));
        numButton5.setOnMousePressed(e -> numButton5.setStyle("-fx-background-color : #424242"));
        numButton5.setOnMouseReleased(e -> numButton5.setStyle("-fx-background-color : #757575"));
        numButton5.setOnMouseExited(e -> numButton5.setStyle("-fx-background-color : #616161"));

        numButton6.setOnMouseEntered(e -> numButton6.setStyle("-fx-background-color : #757575"));
        numButton6.setOnMousePressed(e -> numButton6.setStyle("-fx-background-color : #424242"));
        numButton6.setOnMouseReleased(e -> numButton6.setStyle("-fx-background-color : #757575"));
        numButton6.setOnMouseExited(e -> numButton6.setStyle("-fx-background-color : #616161"));

        numButton7.setOnMouseEntered(e -> numButton7.setStyle("-fx-background-color : #757575"));
        numButton7.setOnMousePressed(e -> numButton7.setStyle("-fx-background-color : #424242"));
        numButton7.setOnMouseReleased(e -> numButton7.setStyle("-fx-background-color : #757575"));
        numButton7.setOnMouseExited(e -> numButton7.setStyle("-fx-background-color : #616161"));

        numButton8.setOnMouseEntered(e -> numButton8.setStyle("-fx-background-color : #757575"));
        numButton8.setOnMousePressed(e -> numButton8.setStyle("-fx-background-color : #424242"));
        numButton8.setOnMouseReleased(e -> numButton8.setStyle("-fx-background-color : #757575"));
        numButton8.setOnMouseExited(e -> numButton8.setStyle("-fx-background-color : #616161"));

        numButton9.setOnMouseEntered(e -> numButton9.setStyle("-fx-background-color : #757575"));
        numButton9.setOnMousePressed(e -> numButton9.setStyle("-fx-background-color : #424242"));
        numButton9.setOnMouseReleased(e -> numButton9.setStyle("-fx-background-color : #757575"));
        numButton9.setOnMouseExited(e -> numButton9.setStyle("-fx-background-color : #616161"));

        dotButton.setOnMouseEntered(e -> dotButton.setStyle("-fx-background-color : #757575"));
        dotButton.setOnMousePressed(e -> dotButton.setStyle("-fx-background-color : #424242"));
        dotButton.setOnMouseReleased(e -> dotButton.setStyle("-fx-background-color : #757575"));
        dotButton.setOnMouseExited(e -> dotButton.setStyle("-fx-background-color : #616161"));

        plusButton.setOnMouseEntered(e -> plusButton.setStyle("-fx-background-color : #ff9100"));
        plusButton.setOnMousePressed(e -> plusButton.setStyle("-fx-background-color : #e65100"));
        plusButton.setOnMouseReleased(e -> plusButton.setStyle("-fx-background-color : #ff9100"));
        plusButton.setOnMouseExited(e -> plusButton.setStyle("-fx-background-color : #ff6d00"));

        minusButton.setOnMouseEntered(e -> minusButton.setStyle("-fx-background-color : #ff9100"));
        minusButton.setOnMousePressed(e -> minusButton.setStyle("-fx-background-color : #e65100"));
        minusButton.setOnMouseReleased(e -> minusButton.setStyle("-fx-background-color : #ff9100"));
        minusButton.setOnMouseExited(e -> minusButton.setStyle("-fx-background-color : #ff6d00"));

        multiplyButton.setOnMouseEntered(e -> multiplyButton.setStyle("-fx-background-color : #ff9100"));
        multiplyButton.setOnMousePressed(e -> multiplyButton.setStyle("-fx-background-color : #e65100"));
        multiplyButton.setOnMouseReleased(e -> multiplyButton.setStyle("-fx-background-color : #ff9100"));
        multiplyButton.setOnMouseExited(e -> multiplyButton.setStyle("-fx-background-color : #ff6d00"));

        divideButton.setOnMouseEntered(e -> divideButton.setStyle("-fx-background-color : #ff9100"));
        divideButton.setOnMousePressed(e -> divideButton.setStyle("-fx-background-color : #e65100"));
        divideButton.setOnMouseReleased(e -> divideButton.setStyle("-fx-background-color : #ff9100"));
        divideButton.setOnMouseExited(e -> divideButton.setStyle("-fx-background-color : #ff6d00"));

        clearButton.setOnMouseEntered(e -> clearButton.setStyle("-fx-background-color : #9ccc65"));
        clearButton.setOnMousePressed(e -> clearButton.setStyle("-fx-background-color : #33691e"));
        clearButton.setOnMouseReleased(e -> clearButton.setStyle("-fx-background-color : #9ccc65"));
        clearButton.setOnMouseExited(e -> clearButton.setStyle("-fx-background-color : #689f38"));

        backspaceButton.setOnMouseEntered(e -> backspaceButton.setStyle("-fx-background-color : #9ccc65"));
        backspaceButton.setOnMousePressed(e -> backspaceButton.setStyle("-fx-background-color : #33691e"));
        backspaceButton.setOnMouseReleased(e -> backspaceButton.setStyle("-fx-background-color : #9ccc65"));
        backspaceButton.setOnMouseExited(e -> backspaceButton.setStyle("-fx-background-color : #689f38"));

        numButton00.setOnMouseEntered(e -> numButton00.setStyle("-fx-background-color : #ef5350"));
        numButton00.setOnMousePressed(e -> numButton00.setStyle("-fx-background-color : #b71c1c"));
        numButton00.setOnMouseReleased(e -> numButton00.setStyle("-fx-background-color : #ef5350"));
        numButton00.setOnMouseExited(e -> numButton00.setStyle("-fx-background-color : #b71c1c"));
    }


    @FXML
    private GridPane mainGridPane;

    @FXML
    private Label inputLabel;

    @FXML
    private Button clearButton;

    @FXML
    private Label outputLabel;

    @FXML
    private Button divideButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button numButton7;

    @FXML
    private Button numButton4;

    @FXML
    private Button numButton1;

    @FXML
    private Button numButton0;

    @FXML
    private Button numButton8;

    @FXML
    private Button numButton5;

    @FXML
    private Button numButton2;

    @FXML
    private Button numButton9;

    @FXML
    private Button numButton6;

    @FXML
    private Button numButton3;

    @FXML
    private Button dotButton;

    @FXML
    private Button backspaceButton;

    @FXML
    private Button minusButton;

    @FXML
    private Button plusButton;

    @FXML
    private Button numButton00;

}
