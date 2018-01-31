package com.github.murilompo.testejava.start;

import com.github.murilompo.testejava.pojo.Venda;
import com.github.murilompo.testejava.pojo.Vendedor;
import com.github.murilompo.testejava.repository.VendasRepostitory;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Murilo de Mello P. Oliveira<murilo_mpo@hotmail.com>
 */
public class TesteJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Venda> listaVendes = VendasRepostitory.listarTodos();

        Map<Vendedor, Double> vendedorTotalVenda
                = new HashMap<>(listaVendes.size() / 2);

        listaVendes.forEach((listaVende) -> {
            Double valor = vendedorTotalVenda.get(listaVende.getVendedor());
            valor = valor == null
                    ? listaVende.getValor()
                    : listaVende.getValor() + valor;
            vendedorTotalVenda.put(listaVende.getVendedor(), valor);
        });

        LinkedHashMap<Vendedor, Double> vendedorTotalVendaIndexavel
                = new LinkedHashMap(vendedorTotalVenda);

        System.out.printf("%-15s%-15s\n", "Vendedor", "Total");

        vendedorTotalVendaIndexavel.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    System.out.printf("%-15s%-15.2f\n", entry.getKey().getNome(), entry.getValue());
                });
    }

}
