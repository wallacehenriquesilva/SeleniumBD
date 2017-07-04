package controller;

import java.util.ArrayList;

/**
 * Created by FINCH-WALLACE on 03/07/2017.
 */
public interface GenericController<T> {
    public void incluir(T obj);
    public abstract void alterar(T obj);
    public ArrayList<T> consultar(String filtro);
    public void excluir(T obj);
}
