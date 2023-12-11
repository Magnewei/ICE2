module com.example.ice2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.ice2 to javafx.fxml;
    exports com.example.ice2;
}