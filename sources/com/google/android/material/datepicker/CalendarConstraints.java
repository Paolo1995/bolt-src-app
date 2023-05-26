package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() { // from class: com.google.android.material.datepicker.CalendarConstraints.1
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public CalendarConstraints[] newArray(int i8) {
            return new CalendarConstraints[i8];
        }
    };
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Month f13245f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final Month f13246g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final DateValidator f13247h;

    /* renamed from: i  reason: collision with root package name */
    private Month f13248i;

    /* renamed from: j  reason: collision with root package name */
    private final int f13249j;

    /* renamed from: k  reason: collision with root package name */
    private final int f13250k;

    /* renamed from: l  reason: collision with root package name */
    private final int f13251l;

    /* loaded from: classes.dex */
    public interface DateValidator extends Parcelable {
        boolean X(long j8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (this.f13245f.equals(calendarConstraints.f13245f) && this.f13246g.equals(calendarConstraints.f13246g) && ObjectsCompat.a(this.f13248i, calendarConstraints.f13248i) && this.f13249j == calendarConstraints.f13249j && this.f13247h.equals(calendarConstraints.f13247h)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month f(Month month) {
        if (month.compareTo(this.f13245f) < 0) {
            return this.f13245f;
        }
        if (month.compareTo(this.f13246g) > 0) {
            return this.f13246g;
        }
        return month;
    }

    public DateValidator g() {
        return this.f13247h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month h() {
        return this.f13246g;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f13245f, this.f13246g, this.f13248i, Integer.valueOf(this.f13249j), this.f13247h});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f13249j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f13251l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month l() {
        return this.f13248i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month n() {
        return this.f13245f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.f13250k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeParcelable(this.f13245f, 0);
        parcel.writeParcelable(this.f13246g, 0);
        parcel.writeParcelable(this.f13248i, 0);
        parcel.writeParcelable(this.f13247h, 0);
        parcel.writeInt(this.f13249j);
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, Month month3, int i8) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.f13245f = month;
        this.f13246g = month2;
        this.f13248i = month3;
        this.f13249j = i8;
        this.f13247h = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i8 >= 0 && i8 <= UtcDates.k().getMaximum(7)) {
            this.f13251l = month.s(month2) + 1;
            this.f13250k = (month2.f13354h - month.f13354h) + 1;
            return;
        }
        throw new IllegalArgumentException("firstDayOfWeek is not valid");
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: f  reason: collision with root package name */
        static final long f13252f = UtcDates.a(Month.c(1900, 0).f13357k);

        /* renamed from: g  reason: collision with root package name */
        static final long f13253g = UtcDates.a(Month.c(2100, 11).f13357k);

        /* renamed from: a  reason: collision with root package name */
        private long f13254a;

        /* renamed from: b  reason: collision with root package name */
        private long f13255b;

        /* renamed from: c  reason: collision with root package name */
        private Long f13256c;

        /* renamed from: d  reason: collision with root package name */
        private int f13257d;

        /* renamed from: e  reason: collision with root package name */
        private DateValidator f13258e;

        public Builder() {
            this.f13254a = f13252f;
            this.f13255b = f13253g;
            this.f13258e = DateValidatorPointForward.a(Long.MIN_VALUE);
        }

        @NonNull
        public CalendarConstraints a() {
            Month e8;
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f13258e);
            Month e9 = Month.e(this.f13254a);
            Month e10 = Month.e(this.f13255b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l8 = this.f13256c;
            if (l8 == null) {
                e8 = null;
            } else {
                e8 = Month.e(l8.longValue());
            }
            return new CalendarConstraints(e9, e10, dateValidator, e8, this.f13257d);
        }

        @NonNull
        public Builder b(long j8) {
            this.f13256c = Long.valueOf(j8);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(@NonNull CalendarConstraints calendarConstraints) {
            this.f13254a = f13252f;
            this.f13255b = f13253g;
            this.f13258e = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.f13254a = calendarConstraints.f13245f.f13357k;
            this.f13255b = calendarConstraints.f13246g.f13357k;
            this.f13256c = Long.valueOf(calendarConstraints.f13248i.f13357k);
            this.f13257d = calendarConstraints.f13249j;
            this.f13258e = calendarConstraints.f13247h;
        }
    }
}
