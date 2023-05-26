package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class NotificationCompatJellybean {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f5639a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f5640b = new Object();

    private NotificationCompatJellybean() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(NotificationCompat.Action action) {
        int i8;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat d8 = action.d();
        if (d8 != null) {
            i8 = d8.j();
        } else {
            i8 = 0;
        }
        bundle2.putInt("icon", i8);
        bundle2.putCharSequence("title", action.h());
        bundle2.putParcelable("actionIntent", action.a());
        if (action.c() != null) {
            bundle = new Bundle(action.c());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", c(action.e()));
        bundle2.putBoolean("showsUserInterface", action.g());
        bundle2.putInt("semanticAction", action.f());
        return bundle2;
    }

    private static Bundle b(RemoteInput remoteInput) {
        new Bundle();
        throw null;
    }

    private static Bundle[] c(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i8 = 0; i8 < remoteInputArr.length; i8++) {
            RemoteInput remoteInput = remoteInputArr[i8];
            bundleArr[i8] = b(null);
        }
        return bundleArr;
    }
}
