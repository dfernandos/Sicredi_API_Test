package br.com.sicredi.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class Cenario1 {

    private static final String ENDPOINT = "https://viacep.com.br/ws/91060900/json/";
    private Response response;

    @Given("^usuário insere um CEP válido$")
    public void usuárioInsereUmCEPVálido() {
        given().contentType(ContentType.JSON);
    }

    @When("^serviço é consultado$")
    public void serviçoÉConsultado() {
        response = when().get(ENDPOINT);

    }

    @Then("^é retornado o CEP, logradouro, complemento, bairro, localidade, uf e ibge\\.$")
    public void éRetornadoOCEPLogradouroComplementoBairroLocalidadeUfEIbge() {
        String validCep ="91060-900";

        response
                .then().body("cep", is(validCep)).statusCode(200);
        Response response = get(ENDPOINT);
        response.body().prettyPrint();
    }
}
