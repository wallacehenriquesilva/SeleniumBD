package controller;

import dao.ProdutoDao;
import model.ProdutoModel;

import java.util.ArrayList;

/**
 * Created by FINCH-WALLACE on 04/07/2017.
 */
public class ProdutoController implements GenericController<ProdutoModel> {
    ProdutoDao produtoDao = new ProdutoDao();

    @Override
    public void incluir(ProdutoModel obj) {
        produtoDao.incluir(obj);
    }

    @Override
    public void alterar(ProdutoModel obj) {
        produtoDao.alterar(obj);
    }

    @Override
    public ArrayList<ProdutoModel> consultar(String condicao) {
        return produtoDao.consultar(condicao);
    }

    @Override
    public void excluir(int id) {
        produtoDao.excluir(id);
    }

    @Override
    public ArrayList<ProdutoModel> get() {
        return produtoDao.get();
    }

}
