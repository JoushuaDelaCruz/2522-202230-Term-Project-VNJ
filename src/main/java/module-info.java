module ca.bcit.comp2522.termproject.vnj {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.bcit.comp2522.termproject.vnj to javafx.fxml;
    exports ca.bcit.comp2522.termproject.vnj;
    exports ca.bcit.comp2522.termproject.vnj.BackToNature;
    opens ca.bcit.comp2522.termproject.vnj.BackToNature to javafx.fxml;
}