package com.GenerateMultiplesLoopJSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public static void main( String[] args ) throws IOException 
    {
    	
        // Criando dados de exemplo
        List<Map<String, Object>> produtos = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            Map<String, Object> produto = new HashMap<>();
            produto.put("id", i);
            produto.put("nome", "Produto " + i);

            List<Map<String, Object>> categorias = new ArrayList<>();
            for (int j = 1; j <= 2; j++) {
                Map<String, Object> categoria = new HashMap<>();
                categoria.put("nome", "Categoria " + j);

                List<Map<String, Object>> atributos = new ArrayList<>();
                for (int k = 1; k <= 3; k++) {
                    Map<String, Object> atributo = new HashMap<>();
                    atributo.put("nome", "Atributo " + k);
                    atributo.put("valor", "Valor " + k);
                    atributos.add(atributo);
                }
                categoria.put("atributos", atributos);
                categorias.add(categoria);
            }
            produto.put("categorias", categorias);
            produtos.add(produto);
        }

        // Convertendo para JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(produtos);

        // Gravando em um arquivo
        File file = new File("c:\\tmp\\produtos_complexos.json");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(jsonString);
        fileWriter.close();

        System.out.println("JSON complexo gerado com sucesso!");
    
    }

}
