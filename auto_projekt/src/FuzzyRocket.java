import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class FuzzyRocket {

    FuzzyRuleSet fuzzyRuleSet;
    public double rocketX = 0;

    public FuzzyRocket() {
        try {
            String fileName = "src/rocket.fcl";
            FIS fis = FIS.load(fileName,false);
            fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Asteroid asteroid) {
        int distance = 200 - asteroid.asteroidY;
        int position = Double.valueOf(asteroid.asteroidX - rocketX).intValue();

        fuzzyRuleSet.setVariable("distance", distance);
        fuzzyRuleSet.setVariable("position", position);

        fuzzyRuleSet.evaluate();
        double changeX = fuzzyRuleSet.getVariable("change_direction").getLatestDefuzzifiedValue();
        rocketX += changeX / 20;
    }
}