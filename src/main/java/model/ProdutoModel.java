package model;

import java.io.Serializable;

/**
 * Created by FINCH-WALLACE on 27/06/2017.
 */
public class ProdutoModel implements Serializable{
    private String proDesc;
    private int proPreco;
    private int proId;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

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

    @Override
    public String toString(){
        return  "--------------------- Produto ----------------------"
                + "\n ID: " + getProId()
                + "\n Valor: " + getProPreco()
                + "\n Descrição: " + getProDesc()
                + "\n ************************************************";
    }

}
