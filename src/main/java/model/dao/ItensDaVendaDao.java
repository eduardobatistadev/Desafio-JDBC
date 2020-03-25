package model.dao;

import java.util.List;
import model.entities.ItensDaVenda;

public interface ItensDaVendaDao {
	void insert(ItensDaVenda obj);
	void update(ItensDaVenda obj);
	void deleteById(Integer id);
	ItensDaVenda findById(Integer id);
	List<ItensDaVenda> findAll();
	List<ItensDaVenda> maiorValor();
}
