package uz.jasurbekruzimov.smartchild.Interface;

import java.util.ArrayList;

import edmt.dev.videoplayer.model.MediaObject;

public interface IVideoLoadListener {

    void onVideoLoadSuccess(ArrayList<MediaObject> videoList);
    void onVideoLoadFailed(String message);

}
