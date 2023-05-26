package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new Parcelable.Creator<TimeModel>() { // from class: com.google.android.material.timepicker.TimeModel.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TimeModel[] newArray(int i8) {
            return new TimeModel[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final MaxInputValidator f14513f;

    /* renamed from: g  reason: collision with root package name */
    private final MaxInputValidator f14514g;

    /* renamed from: h  reason: collision with root package name */
    final int f14515h;

    /* renamed from: i  reason: collision with root package name */
    int f14516i;

    /* renamed from: j  reason: collision with root package name */
    int f14517j;

    /* renamed from: k  reason: collision with root package name */
    int f14518k;

    /* renamed from: l  reason: collision with root package name */
    int f14519l;

    public TimeModel() {
        this(0);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, "%02d");
    }

    public static String b(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int c(int i8) {
        return i8 >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        if (this.f14516i == timeModel.f14516i && this.f14517j == timeModel.f14517j && this.f14515h == timeModel.f14515h && this.f14518k == timeModel.f14518k) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f14515h), Integer.valueOf(this.f14516i), Integer.valueOf(this.f14517j), Integer.valueOf(this.f14518k)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f14516i);
        parcel.writeInt(this.f14517j);
        parcel.writeInt(this.f14518k);
        parcel.writeInt(this.f14515h);
    }

    public TimeModel(int i8) {
        this(0, 0, 10, i8);
    }

    public TimeModel(int i8, int i9, int i10, int i11) {
        this.f14516i = i8;
        this.f14517j = i9;
        this.f14518k = i10;
        this.f14515h = i11;
        this.f14519l = c(i8);
        this.f14513f = new MaxInputValidator(59);
        this.f14514g = new MaxInputValidator(i11 == 1 ? 24 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
