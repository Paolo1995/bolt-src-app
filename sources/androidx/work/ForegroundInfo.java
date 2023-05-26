package androidx.work;

import android.app.Notification;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ForegroundInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f8276a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8277b;

    /* renamed from: c  reason: collision with root package name */
    private final Notification f8278c;

    public ForegroundInfo(int i8, @NonNull Notification notification, int i9) {
        this.f8276a = i8;
        this.f8278c = notification;
        this.f8277b = i9;
    }

    public int a() {
        return this.f8277b;
    }

    @NonNull
    public Notification b() {
        return this.f8278c;
    }

    public int c() {
        return this.f8276a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ForegroundInfo.class != obj.getClass()) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
        if (this.f8276a != foregroundInfo.f8276a || this.f8277b != foregroundInfo.f8277b) {
            return false;
        }
        return this.f8278c.equals(foregroundInfo.f8278c);
    }

    public int hashCode() {
        return (((this.f8276a * 31) + this.f8277b) * 31) + this.f8278c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f8276a + ", mForegroundServiceType=" + this.f8277b + ", mNotification=" + this.f8278c + '}';
    }
}
