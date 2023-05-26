package androidx.core.app;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class RemoteInput {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api20Impl {
        private Api20Impl() {
        }

        static void a(Object obj, Intent intent, Bundle bundle) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) obj, intent, bundle);
        }

        public static android.app.RemoteInput b(RemoteInput remoteInput) {
            throw null;
        }

        static Bundle c(Intent intent) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }
    }

    static android.app.RemoteInput a(RemoteInput remoteInput) {
        return Api20Impl.b(remoteInput);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static android.app.RemoteInput[] b(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i8 = 0; i8 < remoteInputArr.length; i8++) {
            RemoteInput remoteInput = remoteInputArr[i8];
            remoteInputArr2[i8] = a(null);
        }
        return remoteInputArr2;
    }
}
