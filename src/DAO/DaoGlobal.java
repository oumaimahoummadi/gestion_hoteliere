package DAO;

import java.util.List;

public interface DaoGlobal<T> {
	void add(T t);
	void update(T t);
	void delete(int i);
	List<T> get();
	
	//getRvCl();

}
