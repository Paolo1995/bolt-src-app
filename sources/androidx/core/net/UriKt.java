package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Uri.kt */
/* loaded from: classes.dex */
public final class UriKt {
    public static final File a(Uri uri) {
        Intrinsics.f(uri, "<this>");
        if (Intrinsics.a(uri.getScheme(), "file")) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
    }
}
