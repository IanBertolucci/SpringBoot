package br.com.treinaweb.springboot.repositorios;

import br.com.treinaweb.springboot.entidades.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAluno extends JpaRepository<Aluno, Long> {
}
