package my.apps.web;

/**
 * Created by camelia on 14/02/2017.
 */
public class Recipies {

    private String name;
    private String ingredients;
    private String instructions;
    private String duration;
    private String type;

    public Recipies (String name, String ingredients, String instructions, String duration, String type){
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

    @Override
    public String toString(){
        return "Recipies{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                ", duration='" + duration + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
