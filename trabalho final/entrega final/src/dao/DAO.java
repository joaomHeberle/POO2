package dao;

import java.util.List;

public interface DAO<T> {

	public boolean insert(T obj);

	public boolean delete(int id);

	public boolean update(T obj);

	public List<T> list(int limit, int offset);

	public T get(int id);

}
