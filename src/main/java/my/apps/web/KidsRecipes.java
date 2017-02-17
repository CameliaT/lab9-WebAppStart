package my.apps.web;
import my.apps.db.RecipeRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/KidsRecipes")
public class KidsRecipes extends HttpServlet {

    private int counter;

    private RecipeRepository recipeRepository = new RecipeRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        counter++;

        //get input as string
        String name = request.getParameter("name");
        String ingredients = request.getParameter("ingredients");
        String instructions = request.getParameter("instructions");
        String duration = request.getParameter("duration");
        String type = request.getParameter("type");
        Recipes recipes = new Recipes(name, ingredients, instructions, duration, type);



        System.out.println(name + type);
        // write results to response
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
        // out.println("name - <b>" + name + "</b><br/>");
        // out.println("type - <b>" + type + "</b><br/>");
        out.println("<b>"+ recipes.toString()+ "</b><br />");

      try {
            out.println("<h3>CookBook</h3>");
            recipeRepository.insert(recipes);
            out.println("<b>"+ recipes.toString()+ "</b><br />");
        } catch (ClassNotFoundException e) {
            out.println("<div class='error'><b>Unable initialize database connection<b></div>");
        } catch (SQLException e){
            out.println("<div class='error'><b>Unable to write to database! " +  e.getMessage() +"<b></div>");
        }

        out.println("<a href='/'>Go Back</a>");

        // finished writing, send to browser
        out.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<head>");
        out.println("<title> Get count </title>");
        out.println("</head>");

        out.println("<h2>Get count</h2>");
        out.println(counter);
        out.close();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init() called. Counter is: " + counter);
    }

    @Override
    public void destroy() {
        System.out.println("Destroying Servlet! Counter is:" + counter);
        super.destroy();
    }
}