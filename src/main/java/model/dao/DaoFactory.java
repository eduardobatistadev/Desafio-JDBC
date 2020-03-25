package model.dao;

import db.DB;
import model.dao.impl.ItensDaVendaDaoJDBC;

public class DaoFactory {
	
	public static ItensDaVendaDao createItensDaVenda() {
		return new ItensDaVendaDaoJDBC(DB.getConnection());
	}
	
}
