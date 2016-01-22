package at.app.sila.dbo;

import java.io.Serializable;

/**
 * Created by AAbdalla on 04.01.2016.
 */
public abstract class DBO implements Serializable{

    private String key;

    protected DBO(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
