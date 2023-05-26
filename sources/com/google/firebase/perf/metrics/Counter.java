package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class Counter implements Parcelable {
    public static final Parcelable.Creator<Counter> CREATOR = new Parcelable.Creator<Counter>() { // from class: com.google.firebase.perf.metrics.Counter.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Counter createFromParcel(Parcel parcel) {
            return new Counter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Counter[] newArray(int i8) {
            return new Counter[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final String f16773f;

    /* renamed from: g  reason: collision with root package name */
    private AtomicLong f16774g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a() {
        return this.f16774g.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String b() {
        return this.f16773f;
    }

    public void c(long j8) {
        this.f16774g.addAndGet(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(long j8) {
        this.f16774g.set(j8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f16773f);
        parcel.writeLong(this.f16774g.get());
    }

    public Counter(@NonNull String str) {
        this.f16773f = str;
        this.f16774g = new AtomicLong(0L);
    }

    private Counter(Parcel parcel) {
        this.f16773f = parcel.readString();
        this.f16774g = new AtomicLong(parcel.readLong());
    }
}
