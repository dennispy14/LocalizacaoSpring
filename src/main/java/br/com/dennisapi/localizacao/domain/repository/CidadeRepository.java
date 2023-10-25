package br.com.dennisapi.localizacao.domain.repository;

import br.com.dennisapi.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

//    @Query(value = " select * from cidade c where c.nome like '%:nome%' ", nativeQuery = true)
//    List<Cidade> encontrarPorNome(@Param("nome") String nome );
//
//    @Query(" delete from cidade c where c.nome =:nome ")
//    @Modifying
//    void deleteByNome(String nome);
//
//    boolean existsByNome(String nome);
}
