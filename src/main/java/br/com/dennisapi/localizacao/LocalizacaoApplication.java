package br.com.dennisapi.localizacao;

import br.com.dennisapi.localizacao.domain.entity.Cidade;
import br.com.dennisapi.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public void run(String... args) throws Exception {
        salvarCidade();
        listarCidade();
    }

    @Transactional
    void salvarCidade() {
        var cidade = new Cidade(1, "Porto Alegre", 200000);
        cidadeRepository.save(cidade);
    }

    void listarCidade() {
        cidadeRepository.findAll().forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }
}
