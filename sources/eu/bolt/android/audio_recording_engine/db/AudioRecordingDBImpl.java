package eu.bolt.android.audio_recording_engine.db;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AudioRecordingDBImpl.kt */
/* loaded from: classes5.dex */
public final class AudioRecordingDBImpl {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f36584b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final AudioRecordingDatabase f36585a;

    /* compiled from: AudioRecordingDBImpl.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AudioRecordingDBImpl() {
        AudioRecordingDatabase a8 = DatabaseHolder.f36598a.a();
        if (a8 != null) {
            this.f36585a = a8;
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final Object a(Continuation<? super List<String>> continuation) {
        return this.f36585a.G().b(System.currentTimeMillis(), 86400000, continuation);
    }

    public final Object b(String str, Continuation<? super List<Integer>> continuation) {
        return this.f36585a.G().d(str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(java.lang.String r13, kotlin.coroutines.Continuation<? super eu.bolt.android.audio_recording_engine.engine.RecordingProperties> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl$getRecordingProperties$1
            if (r0 == 0) goto L13
            r0 = r14
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl$getRecordingProperties$1 r0 = (eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl$getRecordingProperties$1) r0
            int r1 = r0.f36590j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36590j = r1
            goto L18
        L13:
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl$getRecordingProperties$1 r0 = new eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl$getRecordingProperties$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.f36588h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f36590j
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r13 = r0.f36586f
            eu.bolt.android.audio_recording_engine.db.OrderRecordingsData r13 = (eu.bolt.android.audio_recording_engine.db.OrderRecordingsData) r13
            kotlin.ResultKt.b(r14)
            goto L74
        L31:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L39:
            java.lang.Object r13 = r0.f36587g
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r2 = r0.f36586f
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl r2 = (eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl) r2
            kotlin.ResultKt.b(r14)
            goto L5c
        L45:
            kotlin.ResultKt.b(r14)
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDatabase r14 = r12.f36585a
            eu.bolt.android.audio_recording_engine.db.RecordingDao r14 = r14.G()
            r0.f36586f = r12
            r0.f36587g = r13
            r0.f36590j = r5
            java.lang.Object r14 = r14.f(r13, r0)
            if (r14 != r1) goto L5b
            return r1
        L5b:
            r2 = r12
        L5c:
            eu.bolt.android.audio_recording_engine.db.OrderRecordingsData r14 = (eu.bolt.android.audio_recording_engine.db.OrderRecordingsData) r14
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDatabase r2 = r2.f36585a
            eu.bolt.android.audio_recording_engine.db.RecordingDao r2 = r2.G()
            r0.f36586f = r14
            r0.f36587g = r3
            r0.f36590j = r4
            java.lang.Object r13 = r2.a(r13, r0)
            if (r13 != r1) goto L71
            return r1
        L71:
            r11 = r14
            r14 = r13
            r13 = r11
        L74:
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            long r9 = kotlin.collections.CollectionsKt.z0(r14)
            if (r13 == 0) goto L8a
            eu.bolt.android.audio_recording_engine.engine.RecordingProperties r3 = new eu.bolt.android.audio_recording_engine.engine.RecordingProperties
            long r5 = r13.a()
            long r7 = r13.b()
            r4 = r3
            r4.<init>(r5, r7, r9)
        L8a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl.c(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(eu.bolt.android.audio_recording_engine.db.OrderWithRecordings r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl$insertOrderWithRecordings$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl$insertOrderWithRecordings$1 r0 = (eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl$insertOrderWithRecordings$1) r0
            int r1 = r0.f36595j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36595j = r1
            goto L18
        L13:
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl$insertOrderWithRecordings$1 r0 = new eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl$insertOrderWithRecordings$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f36593h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f36595j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.f36592g
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.f36591f
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl r2 = (eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl) r2
            kotlin.ResultKt.b(r7)
            goto L6b
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.f36592g
            eu.bolt.android.audio_recording_engine.db.OrderWithRecordings r6 = (eu.bolt.android.audio_recording_engine.db.OrderWithRecordings) r6
            java.lang.Object r2 = r0.f36591f
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl r2 = (eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl) r2
            kotlin.ResultKt.b(r7)
            goto L63
        L48:
            kotlin.ResultKt.b(r7)
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDatabase r7 = r5.f36585a
            eu.bolt.android.audio_recording_engine.db.RecordingDao r7 = r7.G()
            eu.bolt.android.audio_recording_engine.db.OrderRecordingsData r2 = r6.a()
            r0.f36591f = r5
            r0.f36592g = r6
            r0.f36595j = r4
            java.lang.Object r7 = r7.g(r2, r0)
            if (r7 != r1) goto L62
            return r1
        L62:
            r2 = r5
        L63:
            java.util.List r6 = r6.b()
            java.util.Iterator r6 = r6.iterator()
        L6b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L8a
            java.lang.Object r7 = r6.next()
            eu.bolt.android.audio_recording_engine.db.RecordingFileInfo r7 = (eu.bolt.android.audio_recording_engine.db.RecordingFileInfo) r7
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDatabase r4 = r2.f36585a
            eu.bolt.android.audio_recording_engine.db.RecordingDao r4 = r4.G()
            r0.f36591f = r2
            r0.f36592g = r6
            r0.f36595j = r3
            java.lang.Object r7 = r4.e(r7, r0)
            if (r7 != r1) goto L6b
            return r1
        L8a:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl.d(eu.bolt.android.audio_recording_engine.db.OrderWithRecordings, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object e(String str, int i8, Continuation<? super Unit> continuation) {
        Object d8;
        Object c8 = this.f36585a.G().c(str, i8, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (c8 == d8) {
            return c8;
        }
        return Unit.f50853a;
    }
}
