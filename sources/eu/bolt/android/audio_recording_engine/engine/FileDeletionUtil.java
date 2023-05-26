package eu.bolt.android.audio_recording_engine.engine;

import java.io.File;
import java.util.List;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileDeletionUtil.kt */
/* loaded from: classes5.dex */
public final class FileDeletionUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final FileDeletionUtil f36668a = new FileDeletionUtil();

    private FileDeletionUtil() {
    }

    private final void b(File file, List<String> list, String str) {
        File parentFile;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory() && !Intrinsics.a(file2.getName(), DirectoryType.ENCRYPTED_DIR.c()) && !Intrinsics.a(file2.getName(), DirectoryType.DECRYPTED_DIR.c())) {
                    Intrinsics.e(file2, "file");
                    b(file2, list, str + file2.getName());
                } else if (list.contains(str) && (parentFile = file2.getParentFile()) != null) {
                    FilesKt__UtilsKt.j(parentFile);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(android.content.Context r5, eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof eu.bolt.android.audio_recording_engine.engine.FileDeletionUtil$deleteElapsedFiles$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.android.audio_recording_engine.engine.FileDeletionUtil$deleteElapsedFiles$1 r0 = (eu.bolt.android.audio_recording_engine.engine.FileDeletionUtil$deleteElapsedFiles$1) r0
            int r1 = r0.f36673j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36673j = r1
            goto L18
        L13:
            eu.bolt.android.audio_recording_engine.engine.FileDeletionUtil$deleteElapsedFiles$1 r0 = new eu.bolt.android.audio_recording_engine.engine.FileDeletionUtil$deleteElapsedFiles$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f36671h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f36673j
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f36670g
            android.content.Context r5 = (android.content.Context) r5
            java.lang.Object r6 = r0.f36669f
            eu.bolt.android.audio_recording_engine.engine.FileDeletionUtil r6 = (eu.bolt.android.audio_recording_engine.engine.FileDeletionUtil) r6
            kotlin.ResultKt.b(r7)
            goto L4a
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.b(r7)
            r0.f36669f = r4
            r0.f36670g = r5
            r0.f36673j = r3
            java.lang.Object r7 = r6.a(r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            r6 = r4
        L4a:
            java.util.List r7 = (java.util.List) r7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r5 = r5.getFilesDir()
            if (r5 == 0) goto L5c
            java.lang.String r5 = r5.getAbsolutePath()
            goto L5d
        L5c:
            r5 = 0
        L5d:
            r0.append(r5)
            java.lang.String r5 = java.io.File.separator
            r0.append(r5)
            java.lang.String r1 = "audio_recording"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            java.lang.String r5 = ""
            r6.b(r0, r7, r5)
            kotlin.Unit r5 = kotlin.Unit.f50853a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.audio_recording_engine.engine.FileDeletionUtil.a(android.content.Context, eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
