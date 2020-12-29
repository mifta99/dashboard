package mifta.code.dispendukproject1.api;

import java.util.ArrayList;
import java.util.List;

public class respon {
    String value;
    String message;
    String jwt;

    ArrayList<tampil> result;

    public ArrayList<tampil> getResult() {
        return result;
    }

    public void setResult(ArrayList<tampil> result) {
        this.result = result;
    }

    public String getJwt() {
        return jwt;
    }


    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
