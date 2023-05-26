package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class PerfSession implements Parcelable {
    public static final Parcelable.Creator<PerfSession> CREATOR = new Parcelable.Creator<PerfSession>() { // from class: com.google.firebase.perf.internal.PerfSession.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PerfSession createFromParcel(@NonNull Parcel parcel) {
            return new PerfSession(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PerfSession[] newArray(int i8) {
            return new PerfSession[i8];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private String f16750f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16751g;

    /* renamed from: h  reason: collision with root package name */
    private Timer f16752h;

    public static com.google.firebase.perf.v1.PerfSession[] b(@NonNull List<PerfSession> list) {
        if (list.isEmpty()) {
            return null;
        }
        com.google.firebase.perf.v1.PerfSession[] perfSessionArr = new com.google.firebase.perf.v1.PerfSession[list.size()];
        com.google.firebase.perf.v1.PerfSession a8 = list.get(0).a();
        boolean z7 = false;
        for (int i8 = 1; i8 < list.size(); i8++) {
            com.google.firebase.perf.v1.PerfSession a9 = list.get(i8).a();
            if (!z7 && list.get(i8).g()) {
                perfSessionArr[0] = a9;
                perfSessionArr[i8] = a8;
                z7 = true;
            } else {
                perfSessionArr[i8] = a9;
            }
        }
        if (!z7) {
            perfSessionArr[0] = a8;
        }
        return perfSessionArr;
    }

    public static PerfSession c() {
        String str;
        String replaceAll = UUID.randomUUID().toString().replaceAll("\\-", "");
        PerfSession perfSession = new PerfSession(replaceAll, new Clock());
        perfSession.i(j());
        AndroidLogger e8 = AndroidLogger.e();
        Object[] objArr = new Object[2];
        if (perfSession.g()) {
            str = "Verbose";
        } else {
            str = "Non Verbose";
        }
        objArr[0] = str;
        objArr[1] = replaceAll;
        e8.b("Creating a new %s Session: %s", objArr);
        return perfSession;
    }

    public static boolean j() {
        ConfigResolver f8 = ConfigResolver.f();
        if (f8.I() && Math.random() < f8.B()) {
            return true;
        }
        return false;
    }

    public com.google.firebase.perf.v1.PerfSession a() {
        PerfSession.Builder v7 = com.google.firebase.perf.v1.PerfSession.newBuilder().v(this.f16750f);
        if (this.f16751g) {
            v7.u(SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS);
        }
        return v7.build();
    }

    public Timer d() {
        return this.f16752h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        if (TimeUnit.MICROSECONDS.toMinutes(this.f16752h.b()) > ConfigResolver.f().y()) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.f16751g;
    }

    public boolean g() {
        return this.f16751g;
    }

    public String h() {
        return this.f16750f;
    }

    public void i(boolean z7) {
        this.f16751g = z7;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        parcel.writeString(this.f16750f);
        parcel.writeByte(this.f16751g ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f16752h, 0);
    }

    public PerfSession(String str, Clock clock) {
        this.f16751g = false;
        this.f16750f = str;
        this.f16752h = clock.a();
    }

    private PerfSession(@NonNull Parcel parcel) {
        this.f16751g = false;
        this.f16750f = parcel.readString();
        this.f16751g = parcel.readByte() != 0;
        this.f16752h = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
    }
}
