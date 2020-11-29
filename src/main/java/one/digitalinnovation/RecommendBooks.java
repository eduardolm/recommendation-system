package one.digitalinnovation;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class RecommendBooks {

    public static void main(String[] args) throws IOException, TasteException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter user id and the desired number of recommendations: ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int id = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        DataModel books = new Recommend().getModelBooks();
        Recommender recommender = new RecommendBuilder().buildRecommender(books);
        List<RecommendedItem> recommendations = recommender.recommend(id, number); // UserId 4, 3 recommendations

        for (RecommendedItem recommendation : recommendations) {
            System.out.println("You may like this book: " + recommendation);
        }
    }
}
