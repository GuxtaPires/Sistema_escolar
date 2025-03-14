package br.edu.fatecgru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.model.entity.Aluno;
import br.edu.fatecgru.model.entity.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> listAll(){
		return alunoRepository.findAll();
	}
	
	public Aluno getByRa(int ra) {
		return alunoRepository.findById(ra).get();
	}
	
	public Aluno getByNome(String nome) {
		return alunoRepository.findByNome(nome);
	}
	
	public List<Aluno> getByPrimeiroNome(String nome) {
		return alunoRepository.findByNomeStartsWith(nome);
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public void deleteAluno(int id) {
		alunoRepository.deleteById(id);
	}
}
