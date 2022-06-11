package com.example.a11stapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    ArrayList<Movie> items = new ArrayList<Movie>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.movie_item, viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Movie item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void addItem(Movie item){
        items.add(item);
    }
    public void setItems(ArrayList<Movie> items){
        this.items = items;
    }
    public Movie getItem(int position){
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView movieName;
        TextView peopleCount;
        TextView movieRank;
        TextView movieAccrue;
        TextView releaseDate;

          public ViewHolder(View itemView){
              super(itemView);
              movieName = itemView.findViewById(R.id.MovieName);
              peopleCount = itemView.findViewById(R.id.peopleCount);
              movieRank = itemView.findViewById(R.id.movieRank);
              movieAccrue = itemView.findViewById(R.id.movieAccrue);
              releaseDate = itemView.findViewById(R.id.releaseDate);
          }
          public void setItem(Movie item)
          {
              movieName.setText(item.movieNm);
              peopleCount.setText(item.audiCnt + "명");
              movieRank.setText(item.rank + "위");
              movieAccrue.setText("누적관객수: " + item.audiAcc + "명");
              releaseDate.setText("개봉일: " + item.openDt );

          }
    }
}
