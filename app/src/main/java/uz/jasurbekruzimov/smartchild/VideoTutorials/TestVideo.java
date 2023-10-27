package uz.jasurbekruzimov.smartchild.VideoTutorials;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edmt.dev.videoplayer.VideoPlayerRecyclerView;
import edmt.dev.videoplayer.adapter.VideoPlayerRecyclerAdapter;
import edmt.dev.videoplayer.model.MediaObject;
import edmt.dev.videoplayer.utils.VerticalSpacingItemDecorator;
import uz.jasurbekruzimov.smartchild.DataBase.VideoData;
import uz.jasurbekruzimov.smartchild.Interface.IVideoLoadListener;
import uz.jasurbekruzimov.smartchild.R;

public class TestVideo extends AppCompatActivity implements IVideoLoadListener {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.shimmerVideoLayout)
    ShimmerFrameLayout shimmerFrameLayout;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.videoPlayer)
    VideoPlayerRecyclerView videoPlayerRecyclerView;

    IVideoLoadListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_video);

        init();

    }

    public void init() {
        ButterKnife.bind(this);

        listener = this;

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        videoPlayerRecyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator decorator = new VerticalSpacingItemDecorator(10);
        videoPlayerRecyclerView.addItemDecoration(decorator);

        loadVideoFromFirebase();
    }

    private void loadVideoFromFirebase() {
        shimmerFrameLayout.startShimmer();
        ArrayList<MediaObject> videoList = new ArrayList<>();

        FirebaseDatabase.getInstance()
                .getReference("Video")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                VideoData videoData = dataSnapshot.getValue(VideoData.class);
                                if (videoData != null) {
                                    MediaObject mediaObject = new MediaObject(
                                            videoData.getName(),
                                            videoData.getMediaurl(),
                                            videoData.getThumbnail(),
                                            "");
                                    videoList.add(mediaObject);
                                }
                            }
                            listener.onVideoLoadSuccess(videoList);
                        } else {
                            listener.onVideoLoadFailed("Video topilmadi");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        listener.onVideoLoadFailed(error.getMessage());
                    }
                });
    }

    @Override
    public void onVideoLoadSuccess(ArrayList<MediaObject> videoList) {
        videoPlayerRecyclerView.setMediaObjects(videoList);
        VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(videoList, initGlide());
        videoPlayerRecyclerView.setAdapter(adapter);

        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
    }

    private RequestManager initGlide() {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.user_data_background)
                .error(R.drawable.user_data_background);
        return Glide.with(this).setDefaultRequestOptions(options);
    }

    @SuppressLint("ShowToast")
    @Override
    public void onVideoLoadFailed(String message) {
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
