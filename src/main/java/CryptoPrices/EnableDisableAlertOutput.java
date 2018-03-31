package CryptoPrices;

import java.util.Date;

public class EnableDisableAlertOutput {

    private boolean status;
    private Date date;

    public EnableDisableAlertOutput() {}

    public EnableDisableAlertOutput(boolean status, Date date) {
        this.status = status;
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EnableDisableAlertOutput{" +
                "status=" + status +
                ", date=" + date +
                '}';
    }
}
