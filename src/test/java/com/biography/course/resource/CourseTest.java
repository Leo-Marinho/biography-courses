package com.biography.course.resource;

import com.biography.course.BiographyCourseApplicationTests;
import com.biography.course.dto.CourseDTO;
import com.biography.course.factory.CourseFactory;
import com.biography.course.factory.CourseRequestFactory;
import com.biography.course.model.course.CourseEntity;
import com.biography.course.repository.CourseRepository;
import com.biography.course.resource.request.CourseRequest;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes de cursos")
public class CourseTest extends BiographyCourseApplicationTests {

    @Autowired
    private CourseFactory courseFactory;

    @Autowired
    private CourseRequestFactory courseRequestFactory;

    @Autowired
    private CourseRepository courseRepository;

    private ResponseEntity<List<CourseDTO>> listCourseDTOResponse;
    private ResponseEntity<CourseDTO> courseDTOResponse;

    private CourseEntity course;
    private CourseRequest request;

    private String URI_LIST_COURSE_BY_NAME = "/course/Rest Assured";
    private String URI_COURSE = "/course";
    private String URI_FOR_UPDATE = "/course/1";
    private String URI_FOR_DELETE = "/course/2";
    private String URI_GET_BY_ID = "/course/id/1";


    @Dado("^que exista um curso$")
    public void que_exista_um_curso() throws Throwable {
        this.course = courseFactory.createDefault();
        courseRepository.save(course);
    }
    @Quando("^realizar a busca pelo curso$")
    public void realizar_a_busca_pelo_curso() throws Throwable {
        this.listCourseDTOResponse = restTemplate.exchange(URI_LIST_COURSE_BY_NAME, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CourseDTO>>(){
        });
    }

    @Então("^deve retornar o curso cadastrado$")
    public void deve_retornar_o_curso_cadastrado() throws Throwable {
        final var body = this.listCourseDTOResponse.getBody();
        final var statusCode = this.listCourseDTOResponse.getStatusCode();

        assertAll("Assert em curso response", () -> assertNotNull(body));
        assertAll("Assert e, status code do GET curso ", () -> assertEquals(HttpStatus.OK, statusCode));
    }

    @Dado("^que tenha um novo curso$")
    public void queEuTenhaUmNovoCurso() throws Throwable {
        this.request = courseRequestFactory.createDefault();
        }

    @Quando("^cadastrar um novo curso$")
    public void cadastrarUmNovoCurso() throws Throwable {
        this.courseDTOResponse = restTemplate.postForEntity(URI_COURSE, this.request, CourseDTO.class);
    }

    @Então("^deve retornar o curso criado$")
    public void deveRetornarOCursoCriado() throws Throwable {
        final var body = this.courseDTOResponse.getBody();
        final var statusCode = this.courseDTOResponse.getStatusCode();

        assertAll("Assert em curso response", () -> assertNotNull(body));
        assertAll("Assert em status code do POST curso", () -> assertEquals(HttpStatus.CREATED, statusCode));
    }

    @Dado("^que remova um curso existente$")
    public void queEuRemovaUmCursoExistente() throws Throwable {
        this.restTemplate.delete(URI_FOR_DELETE);
    }

    @Quando("^listar todos os cursos$")
    public void listarTodosOsCursos() throws Throwable {
        this.listCourseDTOResponse = restTemplate.exchange(URI_COURSE, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<CourseDTO>>() {});
        }

    @Entao("^o tamanho da lista de cursos deve estar correto$")
    public void oTamanhoDaListaDeCursosDeveEstarCorreto() throws Throwable {
        final var size = this.listCourseDTOResponse.getBody().size();
        final var statusCode = this.listCourseDTOResponse.getStatusCode();

        assertAll("Assert o tamanho da lista de cursos ", ()-> assertEquals(1, size));
        assertAll("Assert em status code do POST curso", () -> assertEquals(HttpStatus.OK, statusCode));
    }

    @Dado("^que atualize um curso existente$")
    public void queEuAtualizeUmCursoExistente() throws Throwable {
        this.request = courseRequestFactory.createDefault();
        this.restTemplate.put(URI_FOR_UPDATE, this.request);
    }

    @Quando("^listar o curso atualizado$")
    public void listarOCursoAtualizado() throws Throwable {
        this.courseDTOResponse = this.restTemplate.getForEntity(URI_GET_BY_ID, CourseDTO.class);
    }
    @Entao("^o curso deve conter novos valores$")
    public void oCursoDeveConterNovosValores() throws Throwable {
        final var name = this.courseDTOResponse.getBody().getName();
        final var statusCode = this.courseDTOResponse.getStatusCode();

        assertAll("Assert o nome do curso atualizado", () -> assertEquals(name, this.request.getName()));
        assertAll("Assert em status code do GET por Id do  curso", () -> assertEquals(HttpStatus.OK, statusCode));


    }
}
