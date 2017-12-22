//package com.td3.sar;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Informations extends Remote {
	
	public int nbOccurence(String c,String mot) throws RemoteException;
	public int somme(int a,int b) throws RemoteException;;


}
