package sample;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button help;

    @FXML
    private TextArea code;

    @FXML
    private Button to_asm;

    @FXML
    void initialize() {
        to_asm.setOnAction(event->{
            Main.asmCode = "";
            String[] clientCode = code.getText().split("\n");
            for(String el: clientCode){
                chekParam(el);
                creatAsmProg(el);
            }
        });
    }
//param: a=10,b,c
    void chekParam(String str){
        if(str.split(":")[0].equals("param")){
            String[] params = str.split(": ")[1].split(",");
            Main.asmCode = "    ORG 0x12\n";
            for(String el: params) {
               if(el.split("=").length == 2){
                   Main.asmCode += el.split("=")[0].toUpperCase() + ":  " + "WORD   "
                           + el.split("=")[1] + "\n";
               }else{
                   Main.asmCode += el.split("=")[0].toUpperCase() + ":  " + "WORD   " +
                           "?" + "\n";
               }
            }
        }
    }

    void creatAsmProg(String str){
        if(!str.split(":")[0].equals("param")){

        }
    }
}
