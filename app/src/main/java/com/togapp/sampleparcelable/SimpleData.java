package com.togapp.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {

    int number;
    String message;

    // Parcel 객체에서 읽기
    public SimpleData(Parcel src) {
        number = src.readInt();
        message = src.readString();
    }

    // CREATOR 상수 정의
    //public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public SimpleData createFromParcel(Parcel in) {
            // SimpleData 생성자 호출 Parcel 객체에서 읽기
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    // MainActivity.java에서
    // SimpleData 객체 생성 할때
    // SimpleData data = new SimpleData(100, "Helloo Android!"); 이부분에서 필요한것
    public SimpleData(int num, String msg) {
        number = num;
        message = msg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Parcel 객체로 쓰기
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(number);
        parcel.writeString(message);
    }
}
