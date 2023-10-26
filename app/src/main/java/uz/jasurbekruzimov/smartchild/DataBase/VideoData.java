package uz.jasurbekruzimov.smartchild.DataBase;

public class VideoData {
    String name, thumbnail, mediaurl;

    public VideoData(String name, String thumbnail, String mediaurl) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.mediaurl = mediaurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMediaurl() {
        return mediaurl;
    }

    public void setMediaurl(String mediaurl) {
        this.mediaurl = mediaurl;
    }
}