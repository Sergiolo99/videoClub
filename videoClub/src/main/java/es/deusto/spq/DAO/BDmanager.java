package es.deusto.spq.DAO;



import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import es.deusto.spq.data.Usuario;

public class BDmanager {
	
	private static BDmanager instance = null;
	private PersistenceManagerFactory pmf;
	private PersistenceManager pm;
	static final Logger logger = Logger.getLogger(BDmanager.class);
	
	protected BDmanager() {
		logger.debug("Clase usuario inicializada");
		
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm = pmf.getPersistenceManager();
		
		logger.info("Conexion creada");
		
	}
	
	public static BDmanager getInstance() {

		instance = new BDmanager();

		if (instance ==null) {
			instance = new BDmanager();
			instance.borrarUsuarios();
			instance.insertarDatos();

		}
		return instance;
	}
	
	public void deleteData() {
		borrarUsuarios();
	}

	public List<Usuario> getUsuarios() {
		logger.debug("Metodo getUsuario");
		List<Usuario> lista= new ArrayList<Usuario>();
		Transaction tx = pm.currentTransaction();
		try {
			logger.info("   * Encontranso los usuarios .");
			tx.begin();
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario u : extent) {
				lista.add(u);
			}
			tx.commit();
		} catch (Exception ex) {
			logger.error("   $ Error al encontrar los usuarios: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		logger.info("Usuarios encontrados");

		return lista;
	}


	public Usuario getUsuario(int id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Usuario usu = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName()+ " WHERE id == '" + id + "'");
			query.setUnique(true);
			usu = (Usuario) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo el usuario de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usu;
	}
	
	public void borrarUsuarios() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario usuario : extent) {
				pm.deletePersistent(usuario);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}

	}
	
	public boolean guardar(Object o) {
		boolean b = true;
    	Transaction tx = pm.currentTransaction();
    	try {
			tx.begin();
			System.out.println("  * Guardando objeto: " + o);
			pm.makePersistent(o);
			tx.commit();
		} catch (Exception e) {
			System.out.println("  $ Error guardando objeto: " + e.getMessage());
			b = false;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
		}
		return b;
	}
	
	public void borrar(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println(" * Delete an object: " + object);
			
			pm.deletePersistent(object);
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error deleting an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	
	
	public static void store(Usuario usu) {
		BDmanager.getInstance().guardar(usu);	
	}
	
	public static void delete(Usuario usu) {
		BDmanager.getInstance().borrar(usu);	
	}
	
	
	public void insertarDatos() {
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Usuario sergio = new Usuario (1, "Sergio", "Lopez", "Sergio", "hola", "hola");
		listaUsuarios.add(sergio);
		try {
			
		guardar(sergio);
		}catch(Exception ex) {
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
		
	}
	
	
	
	}
	


