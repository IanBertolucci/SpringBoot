package br.com.treinaweb.springboot.repositorios;

import br.com.treinaweb.springboot.entidades.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioInstituicao extends JpaRepository<Instituicao, Long> {
    List<Instituicao> findByNomeContaining(String nome);
}
