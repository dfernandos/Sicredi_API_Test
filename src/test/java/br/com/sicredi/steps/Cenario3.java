package br.com.sicredi.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Cenario3 {

    private static final String ENDPOINT = "https://viacep.com.br/ws/{invalidCep}/json/";
    private static final String INVALID_CEP = "91060-900A";
    private RequestSpecification requestSpecification;
    private Response response;

    @Given("^usuário insere um CEP com formato inválido$")
    public void usuárioInsereUmCEPComFormatoInválido() {
        requestSpecification = given().contentType(ContentType.JSON);
    }

    @When("^serviço é consultado cenario tres$")
    public void serviçoÉConsultadoCenarioTres(){
        response = requestSpecification.when().get(ENDPOINT, INVALID_CEP);
    }

    @Then("^retornado uma mensagem de erro$")
    public void retornadoUmaMensagemDeErro() {
        response.then().statusCode(400).contentType(ContentType.HTML).body("html.body.h3", equalTo("Verifique a sua URL (Bad Request)"));
    }
}
