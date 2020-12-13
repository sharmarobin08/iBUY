package com.example.ibuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ibuy.api_interfaces.JsonPlaceHolderApi;
import com.example.ibuy.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitrail extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofitrail);


        textViewResult = findViewById(R.id.text_view_result);
        createPost();
    }

    void createPost(){
        Post post = new Post(89, "MockTest" , "MockBodyData");

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Post> call = jsonPlaceHolderApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code:" + response.code());
                    return;

                }

                Post postResponse = response.body();
                String content = "";
                content += "Code:" +response.code() +"\n";
                content += "Id:" + post.getId() + "\n";
                content += "userId: " + post.getUserId() + "\n";
                content += "Tittle:" + post.getTitle() + "\n";
                content += "Text:" + post.getText() + "\n\n";
                textViewResult.append(content);


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

    public void getPosts(){

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code:" + response.code());
                    return;

                }
                List<Post> posts = response.body();
                for (Post post : posts) {
                    String content = "";
                    content += "Id:" + post.getId() + "\n";
                    content += "User Id: " + post.getUserId() + "\n";
                    content += "Tittle:" + post.getTitle() + "\n";
                    content += "Text:" + post.getText() + "\n\n";
                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(retrofit2.Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }}