package pthu.metaheuristics;

import java.util.Random;

import pthu.Instance;
import pthu.Solution;

public class ConstructiveHeuristic {

    private final Instance instance;
    private final Solution solution;
    private final Random random;

    public ConstructiveHeuristic(Instance instance) {
        this.instance = instance;
        this.solution = new Solution(instance);
        this.random = new Random();
    }

   

}
