module com.metro_12a_group2_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;

    opens com.metro_12a_group2_project.controller to javafx.fxml;
    exports com.metro_12a_group2_project;
}
