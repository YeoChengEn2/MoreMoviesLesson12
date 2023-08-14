package sg.edu.rp.c346.id22022416.moremovieslesson12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> alMoviesList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        alMoviesList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvDisplayTitle);
        TextView tvGenre = rowView.findViewById(R.id.tvDisplayGenre);
        TextView tvYear = rowView.findViewById(R.id.tvDisplayYear);
        ImageView ivRating = rowView.findViewById(R.id.ivDisplayRating);

        Movie currentItem = alMoviesList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvGenre.setText("+" + currentItem.getGenre());
        tvYear.setText(currentItem.getYear() + "");

        if (currentItem.getRating() == 1) {
            ivRating.setImageResource(R.drawable.rating_g);
        } else if (currentItem.getRating() == 2) {
            ivRating.setImageResource(R.drawable.rating_m18);
        } else if (currentItem.getRating() == 3) {
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if (currentItem.getRating() == 4) {
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if (currentItem.getRating() == 5) {
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else {
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}