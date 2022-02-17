package com.android.dependencyinjection_android.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.dependencyinjection_android.R;
import com.android.dependencyinjection_android.data.Hero;
import com.android.dependencyinjection_android.helpers.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private String[] heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.myRecyclerView);

        getHeroes();
    }

    private void getHeroes() {
        Call<List<Hero>> call = RetrofitHelper.getInstance().getApi().getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(@NonNull Call<List<Hero>> call, @NonNull Response<List<Hero>> response) {
                List<Hero> list = response.body();
                assert list != null;
                heroes = new String[list.size()];

                for (int i = 0; i < heroes.length; i++) {
                    heroes[i] = list.get(i).getName();
                }
                setupRecyclerView(heroes);
            }

            @Override
            public void onFailure(@NonNull Call<List<Hero>> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupRecyclerView(String[] list) {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private final String[] list;

        RecyclerViewAdapter(String[] list) {
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String currItem = list[position];
            holder.textView.setText(currItem);
        }

        @Override
        public int getItemCount() {
            if (list != null)
                return list.length;
            else return 0;
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            ViewHolder(View view) {
                super(view);
                textView = itemView.findViewById(R.id.textView);
            }
        }
    }
}