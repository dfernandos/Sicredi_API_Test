package br.com.sicredi.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;


public class Cenario4 {
    private static final String ENDPOINT = "https://viacep.com.br/ws/RS/{cidade}/{parteDoNome}/json/";

    private static final String CIDADE = "Gravatai";
    private static final String PARTE_DO_NOME_RUA = "Barroso";
    private Response response;
    private RequestSpecification aJsonRequest;

    @Given("usuário insere nome da cidade e parte do nome do logradouro")
    public void usuárioInsereNomeDaCidadeEParteDoNomeDoLogradouro() {
        aJsonRequest = given().contentType(ContentType.JSON);
    }

    @When("serviço é consultado quatro")
    public void serviçoÉConsultadoQuatro() {
        response = aJsonRequest.when().get(ENDPOINT, CIDADE, PARTE_DO_NOME_RUA);
    }

    @Then("retornado os CEPs com nome da logradouro")
    public void retornadoOsCEPsComNomeDaLogradouro() {
        response.
                then().body("cep", hasSize(2)).statusCode(200);
    }
}
