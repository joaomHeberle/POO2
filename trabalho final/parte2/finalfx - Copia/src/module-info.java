module finalfx {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;

	
	opens application to javafx.graphics;
	opens application.controllers to javafx.fxml;
	opens application.models to javafx.base;
	
}
