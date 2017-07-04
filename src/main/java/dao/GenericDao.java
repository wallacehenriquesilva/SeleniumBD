package dao;

import java.util.ArrayList;

public interface GenericDao<T> {
    public void incluir(T obj);
    public void alterar(T obj);
    public ArrayList<T> consultar(String filtro);
    public void excluir(T obj);
    public T get(long id);    
}
