package br.com.dennisapi.localizacao.service;

import br.com.dennisapi.localizacao.domain.entity.Cidade;
import br.com.dennisapi.localizacao.domain.repository.CidadeRepository;

import static br.com.dennisapi.localizacao.domain.repository.specs.CidadeSpecs.*;

import br.com.dennisapi.localizacao.domain.repository.projection.CidadeProjection;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository repository;
    private CidadeProjection cidadeProjection;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void salrvarCidade() {
        var cidade = new Cidade(1L, "São Paulo", 12312332L);
        repository.save(cidade);
    }

    public void listarCidadePorQuantidadeHabitantes() {
        repository
                .findByHabitantesLessThanAndNomeLike(10000001L, "Br%")
                .forEach(System.out::println);
    }

    public void listarCidadesPorNome() {
        repository
                .findByNomeLike("Porto%", Sort.by("habitantes"))
                .forEach(System.out::println);
    }

    public void listarCidadesPorNomeSQL() {
        repository
                .findByNomeSqlNativo("Porto Alegre")
                .stream().map(cidadeProjection -> new Cidade(cidadeProjection.getId(), cidadeProjection.getNome(), null))
                .forEach(System.out::println);
    }

    public void listarCidadesPorPaginacao() {
        Pageable pageable = PageRequest.of(1, 2);
        repository
                .findByNomeSqlNativo("Porto Alegre")
                .forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes() {
        repository
                .findByHabitantes(78787900L)
                .forEach(System.out::println);
    }

    public void listarCidade() {
        repository.findAll().forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase("nome")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return repository
                .findAll(example);
    }

    public void listarCidadesByNomeSpec() {
        repository
                .findAll(nomeEqual("Porto Alegre").and(habitantesGreaterThan(1000L)))
                .forEach(System.out::println);

    }

    public void listarCidadesSpecsFiltroDinamico(Cidade filtro) {
        Specification<Cidade> specs = Specification.where((root, query, cb) -> cb.conjunction());

        if (filtro.getId() != null) {
            specs = specs.and(nomeLike(filtro.getNome()));
        }
        if (StringUtils.hasText(filtro.getNome())) {
            specs = specs.and(nomeLike((filtro.getNome())));
        }
        if (filtro.getHabitantes() != null) {
            specs = specs.and(habitantesGreaterThan(filtro.getHabitantes()));

        }
        repository.findAll(specs).forEach(System.out::println);
    }

}
