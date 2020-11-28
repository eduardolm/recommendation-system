package one.digitalinnovation;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

import java.io.IOException;

public class Evaluator {

    public static void main(String[] args) throws IOException, TasteException {

        RandomUtils.useTestSeed();
        DataModel model = new Recommend().getModelMovies();
        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
        RecommendBuilder builder = new RecommendBuilder();
        double error = evaluator.evaluate(builder, null, model, 0.9, 0.1);
        System.out.println("Recommendation error percentage: " + error);
    }
}
