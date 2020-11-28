package one.digitalinnovation;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.IOException;
import java.util.List;

public class RecommendMovies {

    public static void main(String[] args) throws IOException, TasteException {
        DataModel movies = new Recommend().getModelMovies();
        Recommender recommender = new RecommendBuilder().buildRecommender(movies);
        List<RecommendedItem> recommendations = recommender.recommend(4, 3); // UserId 4, 3 recommendations

        for (RecommendedItem recommendation : recommendations) {
            System.out.println("You may like this movie: " + recommendation);
        }
    }
}
