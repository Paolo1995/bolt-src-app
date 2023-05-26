package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
/* loaded from: classes5.dex */
public class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public static boolean j(File file) {
        Intrinsics.f(file, "<this>");
        while (true) {
            boolean z7 = true;
            for (File file2 : FilesKt__FileTreeWalkKt.h(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z7) {
                        break;
                    }
                }
                z7 = false;
            }
            return z7;
        }
    }

    public static String k(File file) {
        String X0;
        Intrinsics.f(file, "<this>");
        String name = file.getName();
        Intrinsics.e(name, "name");
        X0 = StringsKt__StringsKt.X0(name, ".", null, 2, null);
        return X0;
    }
}
