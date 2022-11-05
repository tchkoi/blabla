package ge.ufc.webservices.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;


@XmlRootElement(name = "transactions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transactions {
    @XmlElement(name = "transaction")
    @JsonProperty("transactions")
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return transactions.toString();
    }
}
