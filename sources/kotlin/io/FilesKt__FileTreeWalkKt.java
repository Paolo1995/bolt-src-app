package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileTreeWalk.kt */
/* loaded from: classes5.dex */
public class FilesKt__FileTreeWalkKt extends FilesKt__FileReadWriteKt {
    public static final FileTreeWalk g(File file, FileWalkDirection direction) {
        Intrinsics.f(file, "<this>");
        Intrinsics.f(direction, "direction");
        return new FileTreeWalk(file, direction);
    }

    public static final FileTreeWalk h(File file) {
        Intrinsics.f(file, "<this>");
        return g(file, FileWalkDirection.BOTTOM_UP);
    }

    public static FileTreeWalk i(File file) {
        Intrinsics.f(file, "<this>");
        return g(file, FileWalkDirection.TOP_DOWN);
    }
}
