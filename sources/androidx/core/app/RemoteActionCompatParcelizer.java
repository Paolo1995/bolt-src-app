package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f5660a = (IconCompat) versionedParcel.v(remoteActionCompat.f5660a, 1);
        remoteActionCompat.f5661b = versionedParcel.l(remoteActionCompat.f5661b, 2);
        remoteActionCompat.f5662c = versionedParcel.l(remoteActionCompat.f5662c, 3);
        remoteActionCompat.f5663d = (PendingIntent) versionedParcel.r(remoteActionCompat.f5663d, 4);
        remoteActionCompat.f5664e = versionedParcel.h(remoteActionCompat.f5664e, 5);
        remoteActionCompat.f5665f = versionedParcel.h(remoteActionCompat.f5665f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.f5660a, 1);
        versionedParcel.D(remoteActionCompat.f5661b, 2);
        versionedParcel.D(remoteActionCompat.f5662c, 3);
        versionedParcel.H(remoteActionCompat.f5663d, 4);
        versionedParcel.z(remoteActionCompat.f5664e, 5);
        versionedParcel.z(remoteActionCompat.f5665f, 6);
    }
}
