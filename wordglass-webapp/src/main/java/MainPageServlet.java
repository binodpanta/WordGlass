import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

import com.wordglass.db.DBAccess;
import com.wordglass.dbmodels.WordsProvider;

public class MainPageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");

		resp.getWriter()
				.print("<span>Welcome to WordGlass, a cool and useful Words app!</span>");

		StringBuilder sb = new StringBuilder(
				"<p>Here are the developers...</p>");
		for (String s : new WordsProvider().getWordlist()) {
			sb.append(s + "<br/>");
		}

		sb.append("<hr/><p>Here are the Tables available...</p>");
		for (String c : DBAccess.getInstance().collections()) {
			sb.append(c + "<br/>");
		}

		resp.getWriter().print(sb.toString());

	}

	public static void main(String[] args) throws Exception {
		Server server = new Server(Integer.valueOf(System.getenv("PORT")));
		ServletContextHandler context = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		context.addServlet(new ServletHolder(new MainPageServlet()), "/*");
		server.start();
		server.join();
	}
}
