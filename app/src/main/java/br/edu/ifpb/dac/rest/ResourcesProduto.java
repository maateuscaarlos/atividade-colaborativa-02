package br.edu.ifpb.dac.rest;


import br.edu.ifpb.dac.domain.Produto;
import br.edu.ifpb.dac.service.ProdutoService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("produtos")
@Stateless
public class ResourcesProduto {

    @EJB
    private ProdutoService produtoService;


    @GET
    @Produces("application/json")
    public List<Produto> listarProdutos() {

        return produtoService.listarTodos();
    }

    @GET
    @Path("{descricao}")
    @Produces("application/json")
    public List<Produto> todos(@PathParam("descricao") String descricao) {
        return produtoService.listarTodosPorDescricao(descricao);
    }
}
