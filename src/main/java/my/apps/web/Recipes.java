package my.apps.web;

/**
 * Created by camelia on 14/02/2017.
 */
public class Recipes {

    private Long id;
    private String name;
    private String ingredients;
    private String instructions;
    private String duration;
    private String type;

    public Recipes(String name, String ingredients, String instructions, String duration, String type){
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.duration = duration;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public Long getId(){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "Recipes{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                ", duration='" + duration + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
