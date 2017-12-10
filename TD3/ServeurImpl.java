import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class ServeurImpl extends UnicastRemoteObject implements Informations {

	public ServeurImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	public ServeurImpl(int arg0) throws RemoteException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ServeurImpl(int arg0, RMIClientSocketFactory arg1, RMIServerSocketFactory arg2) throws RemoteException {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int somme(int a,int b) throws RemoteException {
		
		return a+b;
	}

	@Override
	public int NbOccurence(String c,String mot) throws RemoteException {
		
		int l=mot.length();
		int nb=0;
		for (int i=0; i<l; i++){
		if ((mot.substring(i,i+1)).equals(c)) nb++;
		}
		return nb;
	}

}
