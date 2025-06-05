module com.metro_12a_group2_project {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.metro_12a_group2_project.controller to javafx.fxml;
    exports com.metro_12a_group2_project;
}
