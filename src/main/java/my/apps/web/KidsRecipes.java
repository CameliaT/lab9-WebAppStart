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
import java.util.List;

@WebServlet("/kidsRecipes")
public class KidsRecipes extends HttpServlet {

    private int counter;

    private RecipeRepository recipeRepository = new RecipeRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        counter++;

        //get input as string
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String ingredients = request.getParameter("ingredients");
        String instructions = request.getParameter("instructions");
        String duration = request.getParameter("duration");

        Recipes recipe = new Recipes(name, ingredients, instructions, duration, type);



        System.out.println(name + type);
        // write results to response
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        addStyle(out);

      try {
            out.println("<h3>CookBook</h3>");
            recipeRepository.insert(recipe);
            out.println("<b>"+ recipe.toString()+ "</b><br />");
        } catch (ClassNotFoundException e) {
            out.println("<div class='error'><b>Unable initialize database connection<b></div>");
        } catch (SQLException e){
            out.println("<div class='error'><b>Unable to write to database! " +  e.getMessage() +"<b></div>");
        }

        addGoBack(out);

        // finished writing, send to browser
        out.close();

    }

    private void addGoBack(PrintWriter out){
        out.println("<a href='/'>Go Back</a>");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<head>");
        out.println("<title> Get Recipes </title>");
        addStyle(out);
        out.println("</head>");

        try {
            out.println("<h4>Get Recipes</h4>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Type</th>");
            out.println("<th>Name</th>");
            out.println("<th>Ingredients</th>");
            out.println("<th>Instructions</th>");
            out.println("<th>Duration</th>");
            out.println("</tr>");

            List<Recipes> recipes = recipeRepository.read();
            for (Recipes recipe : recipes){
                out.println("<tr>");
                out.println("<td>"+recipe.getId()+"</td>");
                out.println("<td>"+recipe.getType()+"</td>");
                out.println("<td>"+recipe.getName()+"</td>");
                out.println("<td>"+recipe.getIngredients()+"</td>");
                out.println("<td>"+recipe.getInstructions()+"</td>");
                out.println("<td>"+recipe.getDuration()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");

        } catch (ClassNotFoundException e){
            out.println("<div class='error'><b>Unable initialize database connection<b></div>");
        } catch (SQLException e){
            out.println("<div class='error'><b>Unable to write to database! " +  e.getMessage() +"<b></div>");
        }
        addGoBack(out);
        out.close();
    }

    private void addStyle (PrintWriter out){
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
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