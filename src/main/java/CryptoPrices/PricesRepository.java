package CryptoPrices;

import org.springframework.stereotype.Repository;

@Repository
public class PricesRepository {

    public void enableDisableAlert(boolean enableDisableAlert) {
        System.out.println("Set value true/false in column enableAlert in the table of Database");
        System.out.println("Insert: " + new AlertValue(true, "Nano", 5.75).toString());
    }
    
    public AlertValue getValueAlert() {
        return new AlertValue(true, "Ethereum", 398.58);
    }
}
