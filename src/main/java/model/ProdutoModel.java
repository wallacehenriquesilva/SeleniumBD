package model;

import java.io.Serializable;

/**
 * Created by FINCH-WALLACE on 27/06/2017.
 */
public class ProdutoModel implements Serializable{
    private String proDesc;
    private int proPreco;

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public int getProPreco() {
        return proPreco;
    }

    public void setProPreco(int proPreco) {
        this.proPreco = proPreco;
    }


}
