package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class Timer implements Parcelable {
    public static final Parcelable.Creator<Timer> CREATOR = new Parcelable.Creator<Timer>() { // from class: com.google.firebase.perf.util.Timer.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Timer createFromParcel(Parcel parcel) {
            return new Timer(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Timer[] newArray(int i8) {
            return new Timer[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private long f16898f;

    /* renamed from: g  reason: collision with root package name */
    private long f16899g;

    public long a() {
        return this.f16898f + b();
    }

    public long b() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.f16899g);
    }

    public long c(@NonNull Timer timer) {
        return TimeUnit.NANOSECONDS.toMicros(timer.f16899g - this.f16899g);
    }

    public long d() {
        return this.f16898f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e() {
        this.f16898f = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.f16899g = System.nanoTime();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeLong(this.f16898f);
        parcel.writeLong(this.f16899g);
    }

    public Timer() {
        this.f16898f = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.f16899g = System.nanoTime();
    }

    private Timer(Parcel parcel) {
        this.f16898f = parcel.readLong();
        this.f16899g = parcel.readLong();
    }
}
