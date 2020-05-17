package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;


@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO{
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Importancia>findAll() throws DataAccessException{
		//TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.importancia");
		Query query = entityManager.createNativeQuery(sb.toString(),Importancia.class);
		List<Importancia> resulset = query.getResultList();
		return resulset;
		
	}
	
	public Importancia findOne(Integer codigo) throws DataAccessException {
		/*
		 * Para obtener un cliente en base a su llave primaria nos auxiliaremos
		 * del metodo find del objeto EntityManager, el cual recibe de parametro la
		 * referencia de la clase sobre la cual queremos buscar la entidad, y como 
		 * segundo parametros el valor de la llave primaria, el cual es enviado como
		 * parametro en el metodo. Dicho metodo devolvera el objeto Cliente encontrado
		 * para esa llave primaria, sino lo encuentra devolverá NULL
		 */
		Importancia c = entityManager.find(Importancia.class, codigo);
		return c;
	}

}
