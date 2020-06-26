package es.deusto.spq.server;

import java.io.IOException;
import java.net.URI;
import java.rmi.Naming;
import java.rmi.Remote;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import es.deusto.spq.resources.GetPropertyValues;


public class Server {

	// Base URI the Grizzly HTTP server will listen on
	

		/**
		 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
		 * application.
		 *
		 * @return Grizzly HTTP server.
		 */
		public static HttpServer startServer() {
			// create a resource config that scans for JAX-RS resources and providers
			// in com.example package
			final ResourceConfig rc = new ResourceConfig().packages("es.deusto.spq");
			// create and start a new instance of grizzly http server
			// exposing the Jersey application at BASE_URI

			
			return GrizzlyHttpServerFactory.createHttpServer(URI.create(cogerUrl()), rc);
		}
		/**
		 * Coge la URL de el archivo .properties
		 *@author isanr
		 * @return URL del server
		 */
		public static String cogerUrl(){
			GetPropertyValues properties = new GetPropertyValues();
			String url = "";
			
			try {
				url = properties.getURL();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			return url;
			
		}
		
		@SuppressWarnings("deprecation")
		public static void main(String[] args) throws IOException {
			//DBManager.getInstance();

				final HttpServer server = startServer();
				System.out.println(String.format(
						"Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
						cogerUrl()));
				System.in.read();
				server.stop();

			}
			
		
		
		
		
		
}
