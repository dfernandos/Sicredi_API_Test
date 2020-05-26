package br.com.sicredi.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Cenario2 {

    private static final String ENDPOINT = "https://viacep.com.br/ws/{cep}/json/";

    private static final String INVALID_CEP = "61612-345";
    private Response response;
    private RequestSpecification aJsonRequest;

    @Given("^usuário insere um CEP que não exista na base dos Correios$")
    public void usuárioInsereUmCEPQueNãoExistaNaBaseDosCorreios() {
        aJsonRequest = given().contentType(ContentType.JSON);
    }

    @When("^serviço é consultado cenario dois$")
    public void serviçoÉConsultadoCenarioDois() {
        response = aJsonRequest.when().get(ENDPOINT, INVALID_CEP);
    }

    @Then("^é retornada um atributo erro\\.$")
    public void éRetornadaUmAtributoErro() {
        response.
                then().body("erro", is(true)).statusCode(200);
    }

}
