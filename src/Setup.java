public class Setup {
    public static void main(String[] args) {
        Population pop = new Population(0.01,100,200);

        while(!pop.found()){
            pop.selection();
            pop.reproduce();
        }

        pop.display();
    }
}
