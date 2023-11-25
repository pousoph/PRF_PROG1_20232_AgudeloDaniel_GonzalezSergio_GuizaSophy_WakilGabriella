package co.edu.unbosque.model.persistence;

import java.time.LocalDate;

public interface CRUDOperation {

	public void create(String... strs);

	public void create(Object obj);

	public String readAll();

	public boolean updateByIndex(int index, String... newData);

	public boolean delete(int index);

	public boolean delete(Object obj);


}
