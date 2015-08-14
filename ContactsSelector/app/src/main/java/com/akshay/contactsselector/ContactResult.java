package com.akshay.contactsselector;

/**
 * Created by Akshay on 7/21/2015.
 */
import java.io.Serializable;
import java.util.List;

/**
 * @author Ernestas Vaiciukevicius (ernestas.vaiciukevicius@gmail.com)
 *
 */
public class ContactResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private String contactId;
    private List<ResultItem> results;

    public ContactResult(String id, List<ResultItem> results) {
        this.contactId = id;
        this.results = results;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public List<ResultItem> getResults() {
        return results;
    }

    public void setResults(List<ResultItem> results) {
        this.results = results;
    }

    public static class ResultItem implements Serializable {
        private static final long serialVersionUID = 1L;
        private String result;
        private int resultKind;

        public ResultItem(String result, int kind) {
            this.result = result;
            this.resultKind = kind;
        }

        public String getResult() {
            return result;
        }
        public void setResult(String result) {
            this.result = result;
        }
        public int getResultKind() {
            return resultKind;
        }
        public void setResultKind(int resultKind) {
            this.resultKind = resultKind;
        }
    };


}
