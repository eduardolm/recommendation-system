package one.digitalinnovation;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.IOException;
import java.util.List;

public class RecommendBooks {

    public static void main(String[] args) throws IOException, TasteException {
        DataModel books = new Recommend().getModelBooks();
        Recommender recommender = new RecommendBuilder().buildRecommender(books);
        List<RecommendedItem> recommendations = recommender.recommend(5, 4); // UserId 4, 3 recommendations

        for (RecommendedItem recommendation : recommendations) {
            System.out.println("You may like this book: " + recommendation);
        }
    }
}
