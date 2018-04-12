package com.example.cucumber.steps;

import com.example.SpringIntegrationTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.example.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserResourceSteps extends SpringIntegrationTest {

    private final String baseUrl = "http://localhost";
    private final ParameterizedTypeReference<Set<User>> setTypeReference = new ParameterizedTypeReference<Set<User>>() {
    };
    private final List<User> createdUsers = new ArrayList<>();
    private final Set<User> fetchedUsers = new HashSet<>();

    @Given("^No resources have been created$")
    public void no_resources_have_been_created() {
        assertThat(createdUsers.size(), is(equalTo(0)));
    }

    @When("^I list resources on the server$")
    public void i_list_resources_on_the_server() {
        String url = baseUrl + ":" + port + "/user/enabled";
        ResponseEntity<Set<User>> response = restTemplate.exchange(url, HttpMethod.GET, null, setTypeReference);
        Set<User> body = response.getBody();
        assertThat(body, is(notNullValue()));
        fetchedUsers.addAll(body);
    }

    @Then("^I get (\\d+) names$")
    public void i_get_names(int listSize) {
        assertThat(fetchedUsers.size(), is(equalTo(listSize)));
    }
}
