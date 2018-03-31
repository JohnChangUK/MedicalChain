package CryptoPrices;

import CryptoPrices.Utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PricesRestClient pricesRestClient;

    @Autowired
    private PricesRepository pricesRepository;

    public ResponseEntity<CryptoPriceOutput[]> getInformation(String id) {
        return pricesRestClient.getCryptoInformation(id);
    }

    public String enableDisableAlert(String id, double alertPrice, boolean enableDisable) {
        pricesRepository.enableDisableAlert(enableDisable);
        if (enableDisable) {
            initialiseMonitoringPrice(alertPrice, id);
        }
        return new EnableDisableAlertOutput(enableDisable, new Date()).toString();
    }

    public String initialiseMonitoringPrice(double alertPrice, String id) {
        System.out.println("------- Monitoring Price -------");
        List<CryptoPriceOutput> cryptoInfo = Arrays.asList(pricesRestClient.getCryptoInformation(id).getBody());
        cryptoInfo.forEach(item -> {
            if (Double.parseDouble(item.getPrice_usd()) > alertPrice) {
                alertUser(Double.parseDouble(item.getPrice_usd()), id);
            }
        });
        return cryptoInfo.toString();
    }

    private void alertUser(double alertPrice, String id) {
        System.out.println("Updated Price of " + id + " is: " + alertPrice);
        SendMail.sendMail(alertPrice);
    }

}
