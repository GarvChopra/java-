public class Chef {
    private String name;
    private int experienceYears;

    public Chef(String name, int experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void prepareDish(String dishName) {
        System.out.println(name + " is preparing " + dishName + ".");
    }
}

class Main {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 20);
        chef.prepareDish("Beef Wellington");
    }
}