module com.metro_12a_group2_project {
    requires java.sql;

    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.metro_12a_group2_project.controller to javafx.fxml;
    exports com.metro_12a_group2_project;
}
