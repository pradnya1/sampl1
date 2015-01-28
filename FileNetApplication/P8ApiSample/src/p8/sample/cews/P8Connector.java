package p8.sample.cews;

import java.util.Iterator;

import javax.security.auth.Subject;

import com.filenet.api.collection.ObjectStoreSet;
import com.filenet.api.collection.UserSet;
import com.filenet.api.constants.PrincipalSearchAttribute;
import com.filenet.api.constants.PrincipalSearchSortType;
import com.filenet.api.constants.PrincipalSearchType;
import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.security.Realm;
import com.filenet.api.util.UserContext;

public class P8Connector {
	
	public static void main(String[] args)
	{
	    // Set connection parameters; substitute for the placeholders.
	    String uri = "http://192.168.0.9:9080/wsi/FNCEWS40MTOM/";
	    String username = "p8admin";
	    String password = "filenet123$";
	        
	    // Make connection.
	    Connection conn = Factory.Connection.getConnection(uri);
	    Subject subject = UserContext.createSubject(conn, username, password, null);
	    UserContext.get().pushSubject(subject);

	    try
	    {
	       // Get default domain.
	       Domain domain = Factory.Domain.fetchInstance(conn, null, null);
	       System.out.println("Domain: " + domain.get_Name());

	       // Get object stores for domain.
	       ObjectStoreSet osSet = domain.get_ObjectStores();
	       ObjectStore store;
	       Iterator<?> osIter = osSet.iterator();

	       while (osIter.hasNext()) 
	       {
	          store = (ObjectStore) osIter.next();
	          System.out.println("Object store: " + store.get_Name());
	       }
	       
	       System.out.println("Connection to Content Platform Engine successful");
	       
//	       Realm realm = Factory.Realm.fetchCurrent(domain.getConnection(), null);
//		   System.out.println("Realm Name: " + realm.get_Name()); //print the name of the realm for the current user 
//		      
//		    UserSet users = ((com.filenet.api.security.Realm) realm).findUsers("Ha", PrincipalSearchType.PREFIX_MATCH,
//		    PrincipalSearchAttribute.SHORT_NAME,
//		    PrincipalSearchSortType.ASCENDING, 
//		    new Integer(5), null);

		  
	       
	       
	    }
	    finally
	    {
	       UserContext.get().popSubject();
	    }
	    
	    
	    
	    
	}
	 

}
