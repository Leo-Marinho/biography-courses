package com.biography.course.resource;

import com.biography.course.BiographyCourseApplicationTests;
import com.biography.course.factory.CourseFactory;
import com.biography.course.resource.request.CourseRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@DisplayName("Testes de cursos")
public class CourseTest extends BiographyCourseApplicationTests {

    @Autowired
    private CourseFactory courseFactory;

    @Test
    @DisplayName("Deve retonar lista de cursos")
    public void makeSureToReturnTheList(){

        given()
            .port(port)
            .contentType(JSON)
        .when()
            .get("/course")
        .then()
            .body("size", is(2))
            .statusCode(200);
    }

    @Test
    @DisplayName("Deve retonar curso por id")
    public void makeSureToReturnTheCourseById(){

        given()
            .port(port)
            .contentType(JSON)
        .when()
            .get("/course/Java Script")
        .then()
            .body(containsString("Java Script"))
            .statusCode(200);
    }

    @Test
    @DisplayName("Deve criar um curso")
    public void makeSureToCreateCourse(){

        final CourseRequest request = courseFactory.createDefault();

        given()
            .port(port)
            .contentType(JSON)
            .body(request)
        .when()
            .post("/course/")
        .then()
            .statusCode(201);
    }

    @Test
    @DisplayName("Deve deletar um curso")
    public void makeSureDeleteCourse(){

        given()
            .port(port)
            .contentType(JSON)
        .when()
            .delete("course/2")
        .then()
            .statusCode(200);
    }

}
