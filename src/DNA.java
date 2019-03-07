public class DNA {

    protected int nums[];
    protected double fitness = 0.0;
    protected int total;




    DNA(int total) {
        this.total = total;
        this.nums = new int[4];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random(0, total);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[ ");
        for (int x: nums  ) {
            s.append(x + " ");
        }
        s.append("]");
        return s.toString();
    }


    private double random(int num) {
        return (Math.random() * num);
    }


    private int random(int min, int max) {
        int rn = (int) ((Math.random() * ((max - min) + 1)) + min);
        return rn;
    }

    void fitness() {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; //find the sum of the random numbers
        }

        fitness = sum / (double) total;     //this is the percentage of the characters present...
    }

    // The function receives one argument (DNA) and returns DNA.
    DNA crossover(DNA partner) {
        // The child is a new instance of DNA.
        // Note that the DNA is generated randomly in the constructor,
        // but we will overwrite it below with DNA from parents.
        DNA child = new DNA(total);

        // Picking a random “midpoint” in the genes array
        int midpoint = (int) random(nums.length);

        for (int i = 0; i < nums.length; i++) {
            //[full] Before midpoint copy genes from one parent, after midpoint copy genes from the other parent
            if (i > midpoint) child.nums[i] = nums[i];
            else child.nums[i] = partner.nums[i];
            //[end]
        }
        // Return the new child DNA
        return child;
    }

    void mutate(double mutationRate) {
        for (int i = 0; i < nums.length; i++) {
            if (random(1) < mutationRate) nums[i] = random(0, total);
        }
    }
}
