package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() { // from class: com.google.android.material.datepicker.Month.1
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.c(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public Month[] newArray(int i8) {
            return new Month[i8];
        }
    };
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Calendar f13352f;

    /* renamed from: g  reason: collision with root package name */
    final int f13353g;

    /* renamed from: h  reason: collision with root package name */
    final int f13354h;

    /* renamed from: i  reason: collision with root package name */
    final int f13355i;

    /* renamed from: j  reason: collision with root package name */
    final int f13356j;

    /* renamed from: k  reason: collision with root package name */
    final long f13357k;

    /* renamed from: l  reason: collision with root package name */
    private String f13358l;

    private Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar d8 = UtcDates.d(calendar);
        this.f13352f = d8;
        this.f13353g = d8.get(2);
        this.f13354h = d8.get(1);
        this.f13355i = d8.getMaximum(7);
        this.f13356j = d8.getActualMaximum(5);
        this.f13357k = d8.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month c(int i8, int i9) {
        Calendar k8 = UtcDates.k();
        k8.set(1, i8);
        k8.set(2, i9);
        return new Month(k8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month e(long j8) {
        Calendar k8 = UtcDates.k();
        k8.setTimeInMillis(j8);
        return new Month(k8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month f() {
        return new Month(UtcDates.i());
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull Month month) {
        return this.f13352f.compareTo(month.f13352f);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.f13353g == month.f13353g && this.f13354h == month.f13354h) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i8) {
        int i9 = this.f13352f.get(7);
        if (i8 <= 0) {
            i8 = this.f13352f.getFirstDayOfWeek();
        }
        int i10 = i9 - i8;
        if (i10 < 0) {
            return i10 + this.f13355i;
        }
        return i10;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f13353g), Integer.valueOf(this.f13354h)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long j(int i8) {
        Calendar d8 = UtcDates.d(this.f13352f);
        d8.set(5, i8);
        return d8.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l(long j8) {
        Calendar d8 = UtcDates.d(this.f13352f);
        d8.setTimeInMillis(j8);
        return d8.get(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String p() {
        if (this.f13358l == null) {
            this.f13358l = DateStrings.f(this.f13352f.getTimeInMillis());
        }
        return this.f13358l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long q() {
        return this.f13352f.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month r(int i8) {
        Calendar d8 = UtcDates.d(this.f13352f);
        d8.add(2, i8);
        return new Month(d8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s(@NonNull Month month) {
        if (this.f13352f instanceof GregorianCalendar) {
            return ((month.f13354h - this.f13354h) * 12) + (month.f13353g - this.f13353g);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        parcel.writeInt(this.f13354h);
        parcel.writeInt(this.f13353g);
    }
}
