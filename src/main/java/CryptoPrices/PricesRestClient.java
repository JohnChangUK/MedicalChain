package CryptoPrices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PricesRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<CryptoPriceOutput[]> getCryptoInformation(String id) {
        System.out.println("Using CoinMarketCap API");
        return restTemplate.getForEntity("https://api.coinmarketcap.com/v1/ticker/" + id, CryptoPriceOutput[].class);
    }
}
