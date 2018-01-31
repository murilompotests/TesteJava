package com.github.murilompo.testejava.start;

import com.github.murilompo.testejava.pojo.Venda;
import com.github.murilompo.testejava.pojo.Vendedor;
import com.github.murilompo.testejava.repository.VendasRepostitory;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Murilo de Mello P. Oliveira<murilo_mpo@hotmail.com>
 */
public class TesteJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.printf("%-15s%-15s\n", "Vendedor", "Total");
        VendasRepostitory.listarTodos()
                .stream()
                .collect(Collectors.groupingBy(Venda::getVendedor, Collectors.summingDouble(Venda::getValor)))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.printf("%-15s%-15.2f\n", entry.getKey().getNome(), entry.getValue()));

    }

}
