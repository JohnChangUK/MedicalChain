package CryptoPrices;

import CryptoPrices.Utils.CryptoPriceOutputBuilder;

public class CryptoPriceOutput {

    private String id;
    private String name;
    private String symbol;
    private String rank;
    private String price_usd;
    private String price_btc;
    private String twentyFourHour_volume_usd;
    private String market_cap_usd;
    private String available_supply;
    private String total_supply;
    private String max_supply;
    private String percent_change_1h;
    private String percent_change_24h;
    private String percent_change_7d;
    private String last_updated;

    public CryptoPriceOutput(CryptoPriceOutputBuilder cryptoPriceOutputBuilder) {
        this.id = cryptoPriceOutputBuilder.id;
        this.name = cryptoPriceOutputBuilder.name;
        this.symbol = cryptoPriceOutputBuilder.symbol;
        this.rank = cryptoPriceOutputBuilder.rank;
        this.price_usd = cryptoPriceOutputBuilder.price_usd;
        this.price_btc = cryptoPriceOutputBuilder.price_btc;
        this.twentyFourHour_volume_usd = cryptoPriceOutputBuilder.twentyFourHour_volume_usd;
        this.market_cap_usd = cryptoPriceOutputBuilder.market_cap_usd;
        this.available_supply = cryptoPriceOutputBuilder.available_supply;
        this.total_supply = cryptoPriceOutputBuilder.total_supply;
        this.max_supply = cryptoPriceOutputBuilder.max_supply;
        this.percent_change_1h = cryptoPriceOutputBuilder.percent_change_1h;
        this.percent_change_24h = cryptoPriceOutputBuilder.percent_change_24h;
        this.percent_change_7d = cryptoPriceOutputBuilder.percent_change_7d;
        this.last_updated = cryptoPriceOutputBuilder.last_updated;
    }

    public CryptoPriceOutput() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(String price_usd) {
        this.price_usd = price_usd;
    }

    public String getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(String price_btc) {
        this.price_btc = price_btc;
    }

    public String getTwentyFourHour_volume_usd() {
        return twentyFourHour_volume_usd;
    }

    public void setTwentyFourHour_volume_usd(String twentyFourHour_volume_usd) {
        this.twentyFourHour_volume_usd = twentyFourHour_volume_usd;
    }

    public String getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(String market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public String getAvailable_supply() {
        return available_supply;
    }

    public void setAvailable_supply(String available_supply) {
        this.available_supply = available_supply;
    }

    public String getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(String total_supply) {
        this.total_supply = total_supply;
    }

    public String getMax_supply() {
        return max_supply;
    }

    public void setMax_supply(String max_supply) {
        this.max_supply = max_supply;
    }

    public String getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(String percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public String getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(String percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public String getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(String percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }
}
