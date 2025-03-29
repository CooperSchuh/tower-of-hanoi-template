
public class TowerSolver {
    private TowerModel model;
    private IntegerStack[] towers;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        int depth = model.getHeight();
        this.towers = model.getTowers();
        solve(depth, 0,2,1);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // [ solve method here]
    public void solve(int depth, int source, int destination, int other){
        if (depth == 1){
            model.move(source, destination);
        }
        else{
            solve(depth-1, source, other, destination);
            model.move(source, destination);
            solve(depth-1, other, destination, source);
        }
    }

}
