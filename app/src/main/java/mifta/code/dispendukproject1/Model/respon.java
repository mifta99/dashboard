package mifta.code.dispendukproject1.Model;

import java.util.List;

import mifta.code.dispendukproject1.Model.tampil;

public class respon {
    String value;
    String message;
    String jwt;

    List<tampil> result;

    public List<tampil> getResult() {
        return result;
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
