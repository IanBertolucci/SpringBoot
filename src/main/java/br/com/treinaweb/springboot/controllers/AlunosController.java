package br.com.treinaweb.springboot.controllers;

import br.com.treinaweb.springboot.entidades.Aluno;
import br.com.treinaweb.springboot.entidades.Instituicao;
import br.com.treinaweb.springboot.repositorios.RepositorioAluno;
import br.com.treinaweb.springboot.repositorios.RepositorioInstituicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    private RepositorioAluno repositorioAluno;

    @Autowired
    private RepositorioInstituicao repositorioInstituicao;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView resultado = new ModelAndView("alunos/index");
        resultado.addObject("alunos", repositorioAluno.findAll());
        return resultado;
    }

    @GetMapping("/inserir")
    public ModelAndView inserir() {
        ModelAndView resultado = new ModelAndView("alunos/inserir");
        Aluno aluno = new Aluno();
        aluno.setInstituicao(new Instituicao());
        resultado.addObject("aluno", aluno);
        resultado.addObject("instituicoes", repositorioInstituicao.findAll());
        return resultado;
    }

    @PostMapping("/inserir")
    public String inserir(Aluno aluno) {
        repositorioAluno.save(aluno);
        return "redirect:/alunos/index";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        Aluno aluno = repositorioAluno.findOne(id);
        ModelAndView resultado = new ModelAndView("alunos/editar");
        resultado.addObject("aluno", aluno);
        resultado.addObject("instituicoes", repositorioInstituicao.findAll());
        return resultado;
    }

    @PostMapping("/editar")
    public String editar(Aluno aluno) {
        repositorioAluno.save(aluno);
        return "redirect:/alunos/index";
    }

    @GetMapping("excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repositorioAluno.delete(id);
        return "redirect:/alunos/index";
    }

//    @GetMapping({"/pesquisarPorNome/{nome}", "/pesquisarPorNome"})
//    public @ResponseBody
//    List<aluno> pesquisarPorNome(@PathVariable Optional<String> nome) {
//        if (nome.isPresent()) {
//            return repositorioaluno.findByNomeContaining(nome.get());
//        } else {
//            return repositorioaluno.findAll();
//        }
//    }
}
