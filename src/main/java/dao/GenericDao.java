package dao;

import java.util.ArrayList;

public interface GenericDao<T> {
    public void incluir(T obj);
    public void alterar(T obj);
    public ArrayList<T> consultar(String condicao);
    public void excluir(int id);
    public ArrayList<T> get();
}
