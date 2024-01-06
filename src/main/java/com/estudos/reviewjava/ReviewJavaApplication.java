package com.estudos.reviewjava;

import com.estudos.reviewjava.model.Cidade;
import com.estudos.reviewjava.model.Pessoa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class ReviewJavaApplication {

    public static void main(String[] args) {

        //// PARTE 1

        ArrayList<String> strings = new ArrayList<>();
        strings.add("Pedro");
        strings.add("Joao");

        List<String> strings2 = strings.stream().filter(palavra -> Objects.equals(palavra, "Pedro")).toList();

        System.out.println(strings2);

        /////// PARTE 2

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa(1,"Pedro", 23, Cidade.RECIFE),
                new Pessoa(2,"Joao", 32, Cidade.SAO_PAULO),
                new Pessoa(3, "Jose", 30, Cidade.RECIFE),
                new Pessoa(4, "Ednaldo", 35, Cidade.RIO_DE_JANEIRO),
                new Pessoa(5, "Edvaldo", 25, Cidade.SAO_PAULO),
                new Pessoa(6, "Peter", 10, Cidade.RECIFE)
        );

        List<Pessoa> filtroPorIdade = pessoas.stream().filter(pessoa -> pessoa.getIdade() > 30).toList();
        List<String> mapDeNome = pessoas.stream().map(Pessoa::getNome).toList();
        LinkedList<String> mapDeCidadeEmString = pessoas.stream().map(pessoa -> pessoa.getCidade().toString()).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Cidade> mapDeCidadeEmEnum = pessoas.stream().map(Pessoa::getCidade).collect(Collectors.toCollection(LinkedList::new));

        System.out.println("Pessoas com mais de 30 anos: " + filtroPorIdade);
        System.out.println("Nome das pessoas: " + mapDeNome);
        System.out.println("Nome das cidades em String: " + mapDeCidadeEmString);
        System.out.println("Nome das cidades em String: " + mapDeCidadeEmEnum);

        SpringApplication.run(ReviewJavaApplication.class, args);
    }

}
