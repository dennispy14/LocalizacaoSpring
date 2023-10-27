package br.com.dennisapi.localizacao;

import br.com.dennisapi.localizacao.domain.entity.Cidade;
import br.com.dennisapi.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeService service;

    @Override
    public void run(String... args) throws Exception {
        //var cidade = new Cidade(null, "Porto Alegre",null);

        service.listarCidadesPorNomeSQL();
    }

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }
}
