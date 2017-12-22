//package com.td3.sar;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class ServeurImpl extends UnicastRemoteObject implements Informations {

	public ServeurImpl() throws RemoteException {
		super();
	}

	
	public int somme(int a,int b) throws RemoteException {
		
		return a+b;
	}

	
	public int nbOccurence(String c,String mot) throws RemoteException {
		
		int l=mot.length();
		int nb=0;
		for (int i=0; i<l; i++){
			if ((mot.substring(i,i+1)).equals(c)) nb++;
		}
		return nb;
	}

}
