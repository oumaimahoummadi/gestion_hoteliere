package DAO;
import java.util.List;
import gestion_hoteliere.Clients;

public interface ClientsDao {
	public List<Clients> getClients();
	public void addClient(Clients Client);
	public void updateClient(Clients Client);
	public void deleteClient(Clients Client);

	

}



