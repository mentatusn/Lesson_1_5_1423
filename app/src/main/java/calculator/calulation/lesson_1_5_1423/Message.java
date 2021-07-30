package calculator.calulation.lesson_1_5_1423;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;

public class Message implements Parcelable {
    private String message;
    private String[] mesageArray;


    public Message() {
    }

    protected Message(Parcel in) {
        message = in.readString();
        mesageArray = in.createStringArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeStringArray(mesageArray);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMesageArray(String[] mesageArray) {
        this.mesageArray = mesageArray;
    }

    public String getMessage() {
        return message;
    }

    public String[] getMesageArray() {
        return mesageArray;
    }
}
