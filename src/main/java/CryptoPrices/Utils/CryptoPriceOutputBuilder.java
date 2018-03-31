package CryptoPrices.Utils;

import CryptoPrices.CryptoPriceOutput;

public class CryptoPriceOutputBuilder {

    public String id;
    public String name;
    public String symbol;
    public String rank;
    public String price_usd;
    public String price_btc;
    public String twentyFourHour_volume_usd;
    public String market_cap_usd;
    public String available_supply;
    public String total_supply;
    public String max_supply;
    public String percent_change_1h;
    public String percent_change_24h;
    public String percent_change_7d;
    public String last_updated;

    public CryptoPriceOutputBuilder id(String id) {
        this.id = id;
        return this;
    }

    public CryptoPriceOutputBuilder name(String name) {
        this.name = name;
        return this;
    }


    public CryptoPriceOutputBuilder symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public CryptoPriceOutputBuilder rank(String rank) {
        this.rank = rank;
        return this;
    }

    public CryptoPriceOutputBuilder price_usd(String price_usd) {
        this.price_usd = price_usd;
        return this;
    }

    public CryptoPriceOutputBuilder price_btc(String price_btc) {
        this.price_btc = price_btc;
        return this;
    }

    public CryptoPriceOutputBuilder twentyFourHour_volume_usd(String twentyFourHour_volume_usd) {
        this.twentyFourHour_volume_usd = twentyFourHour_volume_usd;
        return this;
    }

    public CryptoPriceOutputBuilder market_cap_usd(String market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
        return this;
    }

    public CryptoPriceOutputBuilder available_supply(String available_supply) {
        this.available_supply = available_supply;
        return this;
    }

    public CryptoPriceOutputBuilder total_supply(String total_supply) {
        this.total_supply = total_supply;
        return this;
    }

    public CryptoPriceOutputBuilder max_supply(String max_supply) {
        this.max_supply = max_supply;
        return this;
    }

    public CryptoPriceOutputBuilder percent_change_1h(String percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
        return this;
    }

    public CryptoPriceOutputBuilder percent_change_24h(String percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
        return this;
    }

    public CryptoPriceOutputBuilder percent_change_7d(String percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
        return this;
    }

    public CryptoPriceOutputBuilder last_updated(String last_updated) {
        this.last_updated = last_updated;
        return this;
    }

    public CryptoPriceOutput build() {
        return new CryptoPriceOutput(this);
    }
}