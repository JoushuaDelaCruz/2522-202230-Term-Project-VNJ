module ca.bcit.comp.termproject.vnj {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.desktop;
    requires TiledReader;

    opens ca.bcit.comp2522.termproject.vnj to javafx.fxml;
    exports ca.bcit.comp2522.termproject.vnj.BackToNature;
    opens ca.bcit.comp2522.termproject.vnj.BackToNature to javafx.fxml;
    exports ca.bcit.comp2522.termproject.vnj.BackToNature.Character;
    opens ca.bcit.comp2522.termproject.vnj.BackToNature.Character to javafx.fxml;
    exports ca.bcit.comp2522.termproject.vnj.BackToNature.Plants;
    opens ca.bcit.comp2522.termproject.vnj.BackToNature.Plants to javafx.fxml;
}