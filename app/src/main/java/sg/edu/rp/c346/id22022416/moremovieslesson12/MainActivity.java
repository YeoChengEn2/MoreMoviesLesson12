package sg.edu.rp.c346.id22022416.moremovieslesson12;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMovies;
    ArrayList<Movie> alMoviesList;
    CustomAdapter caMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovies = findViewById(R.id.lvMovies);
        alMoviesList = new ArrayList<>();
        Movie item1 = new Movie("Orphan", "Horror", 2009, 2);
        Movie item2 = new Movie("Saving Private Ryan", "Drama", 1998, 3);
        Movie item3 = new Movie("True Lies", "Action/Comedy", 1994, 5);
        alMoviesList.add(item1);
        alMoviesList.add(item2);
        alMoviesList.add(item3);

        caMovies = new CustomAdapter(this, R.layout.row, alMoviesList);
        lvMovies.setAdapter(caMovies);
    }
}