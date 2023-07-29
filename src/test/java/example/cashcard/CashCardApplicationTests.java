package example.cashcard;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

//@JsonTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashCardApplicationTests {
//	@Autowired
//	private JacksonTester<CashCard> json;

	@Autowired
	TestRestTemplate restTemplate;


	@Test
	void contextLoads() {
	}

//	@Test
//	public void cashCardSerializationTest() throws IOException {
//		CashCard cashCard = new CashCard(99L, 123.45);
//		assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
//		assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
//		assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
//		assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
//		assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
//	}

/*	@Test
	void shouldCreateNewCahCard() {
		CashCard newCashCard = new CashCard(null, 250.00);
		ResponseEntity<Void> createResponse = restTemplate.postForEntity("/cashcards", newCashCard, Void.class);

		assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

		URI locationNewCashCard = createResponse.getHeaders().getLocation();
		ResponseEntity<String> getResponse = restTemplate.getForEntity(locationNewCashCard, String.class);

		assertThat(getResponse.getStatusCode()).isEqualTo((HttpStatus.OK));

	}*/

//	@Test
//	void shouldReturnCashCardWhenDataIsSaved() {
//		ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/99", String.class);
//
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//		DocumentContext documentContext = JsonPath.parse(response.getBody());
//		Number id = documentContext.read("$.id");
//		assertThat(id).isEqualTo(99);
//		Double amount = documentContext.read("S.amount");
//		assertThat(amount).isEqualTo(123.45);
//	}

	@Test
	void shouldNotReturnACashCardWithAnUnknownId() {
		ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/1000", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody()).isBlank();

	}

}
