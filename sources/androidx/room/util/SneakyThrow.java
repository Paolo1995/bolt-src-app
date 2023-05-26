package androidx.room.util;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class SneakyThrow {
    private SneakyThrow() {
    }

    public static void a(@NonNull Exception exc) {
        b(exc);
    }

    private static <E extends Throwable> void b(@NonNull Throwable th) throws Throwable {
        throw th;
    }
}
