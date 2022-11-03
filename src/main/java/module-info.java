module ca.bcit.comp2522.termproject.vnj {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.bcit.comp2522.termproject.vnj to javafx.fxml;
    exports ca.bcit.comp2522.termproject.vnj;
}