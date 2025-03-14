package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.model.entity.Aluno;
import br.edu.fatecgru.service.AlunoService;

@RestController
public class AlunoController {

	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/api/alunos")
	public List<Aluno> listarTodos(){
		return alunoService.listAll();
	}
	
	@GetMapping("/api/alunos/{id}")
	public Aluno getByRaAluno(@PathVariable("id") int id){
		return alunoService.getByRa(id);
	}
	
	@GetMapping("/api/alunos/nome/{nome}")
	public Aluno getByNomeAluno(@PathVariable("nome") String nome){
		return alunoService.getByNome(nome);
	}
	
	@GetMapping("/api/alunos/primeironome/{nome}")
	public List<Aluno> getByFirstName(@PathVariable("nome") String nome){
		return alunoService.getByPrimeiroNome(nome);
	}
	
	@DeleteMapping("/api/alunos/{id}")
	public String deleteByRaAluno(@PathVariable("id") int id){
		alunoService.deleteAluno(id);
		return "Aluno deletado com sucesso";
	}
	
	@PostMapping("/api/alunos")	
	public Aluno insert(@RequestBody Aluno aluno) {
		return alunoService.saveAluno(aluno);
	}
	
	@PutMapping("/api/alunos/{id}")
	public Aluno update(@RequestBody Aluno aluno, @PathVariable Integer id) {
		Aluno alunoUpdate = alunoService.getByRa(id);
		alunoUpdate.setNome(aluno.getNome());
		alunoUpdate.setEmail(aluno.getEmail());
		alunoUpdate.setEndereco(aluno.getEndereco());
		alunoUpdate.setPeriodo(aluno.getPeriodo());
		alunoUpdate.setDatanascimento(aluno.getDatanascimento());
		return alunoService.saveAluno(alunoUpdate);
	}
}
