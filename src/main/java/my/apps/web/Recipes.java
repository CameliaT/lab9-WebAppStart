package my.apps.web;

/**
 * Created by camelia on 14/02/2017.
 */
public class Recipes {

    private Long id;
    private String type;
    private String name;
    private String ingredients;
    private String instructions;
    private String duration;


    public Recipes(String type, String name, String ingredients, String instructions, String duration){
        this.type = type;
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.duration = duration;

    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getDuration() {
        return duration;
    }


    public Long getId(){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "Recipe{" +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
