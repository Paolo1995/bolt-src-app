package eu.bolt.android.audio_recording_engine.engine;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl;
import eu.bolt.android.audio_recording_engine.db.DatabaseHolder;
import eu.bolt.android.audio_recording_engine.db.DatabaseUtils;
import eu.bolt.android.audio_recording_engine.engine.RecorderState;
import eu.bolt.android.audio_recording_engine.exception.AudioRecorderSetUpException;
import eu.bolt.android.audio_recording_engine.exception.NotEnoughStorageException;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AudioRecorderImpl.kt */
/* loaded from: classes5.dex */
public final class AudioRecorderImpl implements AudioRecorderApi {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36632a;

    /* renamed from: b  reason: collision with root package name */
    private int f36633b;

    /* renamed from: c  reason: collision with root package name */
    private String f36634c;

    /* renamed from: d  reason: collision with root package name */
    private final MutableStateFlow<RecorderState> f36635d;

    /* renamed from: e  reason: collision with root package name */
    private MediaRecorder f36636e;

    /* renamed from: f  reason: collision with root package name */
    private OrderData f36637f;

    /* renamed from: g  reason: collision with root package name */
    private String f36638g;

    /* renamed from: h  reason: collision with root package name */
    private long f36639h;

    /* renamed from: i  reason: collision with root package name */
    private long f36640i;

    /* renamed from: j  reason: collision with root package name */
    private long f36641j;

    /* renamed from: k  reason: collision with root package name */
    private final Lazy f36642k;

    /* compiled from: AudioRecorderImpl.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36643a;

        static {
            int[] iArr = new int[DirectoryType.values().length];
            try {
                iArr[DirectoryType.ENCRYPTED_DIR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DirectoryType.DECRYPTED_DIR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f36643a = iArr;
        }
    }

    public AudioRecorderImpl(Context context) {
        Lazy b8;
        Intrinsics.f(context, "context");
        this.f36632a = context;
        this.f36633b = 1;
        this.f36635d = StateFlowKt.a(RecorderState.Initial.f36679a);
        b8 = LazyKt__LazyJVMKt.b(new Function0<AudioRecordingDBImpl>() { // from class: eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl$audioRecordingDBApi$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final AudioRecordingDBImpl invoke() {
                return new AudioRecordingDBImpl();
            }
        });
        this.f36642k = b8;
        DatabaseHolder.f36598a.b(context);
    }

    private final void i() {
        this.f36636e = null;
        this.f36633b = 1;
        this.f36634c = null;
        this.f36639h = 0L;
        this.f36640i = 0L;
        this.f36641j = 0L;
    }

    private final AudioRecordingDBImpl j() {
        return (AudioRecordingDBImpl) this.f36642k.getValue();
    }

    private final String k(OrderData orderData, DirectoryType directoryType) {
        String m8 = m(orderData);
        int i8 = WhenMappings.f36643a[directoryType.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return m8 + directoryType.c() + File.separator;
            }
            throw new NoWhenBranchMatchedException();
        }
        return m8 + directoryType.c() + File.separator;
    }

    private final Long l(File file) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Context context = this.f36632a;
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.e(fromFile, "fromFile(this)");
        mediaMetadataRetriever.setDataSource(context, fromFile);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        if (extractMetadata != null) {
            return Long.valueOf(Long.parseLong(extractMetadata));
        }
        return null;
    }

    private final String m(OrderData orderData) {
        String str;
        StringBuilder sb = new StringBuilder();
        File filesDir = this.f36632a.getFilesDir();
        if (filesDir != null) {
            str = filesDir.getAbsolutePath();
        } else {
            str = null;
        }
        sb.append(str);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("audio_recording");
        sb.append(str2);
        sb.append(orderData.c());
        sb.append(str2);
        sb.append(orderData.a());
        sb.append(str2);
        sb.append(orderData.b());
        sb.append(str2);
        return sb.toString();
    }

    private final void n() {
        MediaRecorder mediaRecorder;
        if (Build.VERSION.SDK_INT >= 31) {
            mediaRecorder = new MediaRecorder(this.f36632a);
        } else {
            mediaRecorder = new MediaRecorder();
        }
        p(mediaRecorder);
        this.f36636e = mediaRecorder;
    }

    private final void p(MediaRecorder mediaRecorder) {
        try {
            mediaRecorder.setAudioSource(1);
            mediaRecorder.setOutputFormat(2);
            mediaRecorder.setAudioEncoder(3);
            mediaRecorder.setAudioSamplingRate(44100);
            mediaRecorder.setAudioEncodingBitRate(20000);
        } catch (Exception e8) {
            Log.e("RecorderSetUpException", e8.toString());
            throw new AudioRecorderSetUpException();
        }
    }

    private final void q() {
        String str = this.f36634c + this.f36633b + ".m4a";
        try {
            MediaRecorder mediaRecorder = this.f36636e;
            if (mediaRecorder != null) {
                mediaRecorder.setOutputFile(new File(str).getAbsolutePath());
                mediaRecorder.prepare();
                mediaRecorder.start();
            }
            t();
            this.f36635d.d(new RecorderState.InProgress(this.f36639h));
        } catch (Exception e8) {
            this.f36635d.d(RecorderState.Initial.f36679a);
            Log.e("RecorderStartException", e8.toString());
        }
    }

    private final void r() {
        MediaRecorder mediaRecorder = this.f36636e;
        if (mediaRecorder != null) {
            if (mediaRecorder != null) {
                try {
                    mediaRecorder.stop();
                    mediaRecorder.reset();
                    mediaRecorder.release();
                } catch (Exception e8) {
                    Log.e("RecorderStopException", e8.toString());
                    return;
                }
            }
            this.f36636e = null;
            s();
        }
    }

    private final void s() {
        this.f36641j += TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.f36640i);
    }

    private final void t() {
        this.f36639h = System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(this.f36641j);
        this.f36640i = System.currentTimeMillis();
    }

    @Override // eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi
    public Object a(OrderData orderData, Continuation<? super RecordingProperties> continuation) {
        return j().c(DatabaseUtils.f36600a.a(orderData), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
    @Override // eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(eu.bolt.android.audio_recording_engine.engine.OrderData r6, int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl$onFileUploaded$1
            if (r0 == 0) goto L13
            r0 = r8
            eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl$onFileUploaded$1 r0 = (eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl$onFileUploaded$1) r0
            int r1 = r0.f36655k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36655k = r1
            goto L18
        L13:
            eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl$onFileUploaded$1 r0 = new eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl$onFileUploaded$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f36653i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f36655k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f36650f
            java.io.File r6 = (java.io.File) r6
            kotlin.ResultKt.b(r8)
            goto L84
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.f36652h
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.f36651g
            java.io.File r7 = (java.io.File) r7
            java.lang.Object r2 = r0.f36650f
            eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl r2 = (eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl) r2
            kotlin.ResultKt.b(r8)
            goto L6f
        L48:
            kotlin.ResultKt.b(r8)
            java.io.File r8 = new java.io.File
            java.lang.String r2 = r5.m(r6)
            r8.<init>(r2)
            eu.bolt.android.audio_recording_engine.db.DatabaseUtils r2 = eu.bolt.android.audio_recording_engine.db.DatabaseUtils.f36600a
            java.lang.String r6 = r2.a(r6)
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl r2 = r5.j()
            r0.f36650f = r5
            r0.f36651g = r8
            r0.f36652h = r6
            r0.f36655k = r4
            java.lang.Object r7 = r2.e(r6, r7, r0)
            if (r7 != r1) goto L6d
            return r1
        L6d:
            r2 = r5
            r7 = r8
        L6f:
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl r8 = r2.j()
            r0.f36650f = r7
            r2 = 0
            r0.f36651g = r2
            r0.f36652h = r2
            r0.f36655k = r3
            java.lang.Object r8 = r8.b(r6, r0)
            if (r8 != r1) goto L83
            return r1
        L83:
            r6 = r7
        L84:
            java.util.List r8 = (java.util.List) r8
            boolean r7 = r8.isEmpty()
            if (r7 == 0) goto L95
            boolean r7 = r6.exists()
            if (r7 == 0) goto L95
            kotlin.io.FilesKt.j(r6)
        L95:
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl.b(eu.bolt.android.audio_recording_engine.engine.OrderData, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi
    public Object c(Continuation<? super Unit> continuation) {
        Object d8;
        Object a8 = FileDeletionUtil.f36668a.a(this.f36632a, j(), continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (a8 == d8) {
            return a8;
        }
        return Unit.f50853a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
        if (r5 != false) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084 A[LOOP:0: B:28:0x007e->B:30:0x0084, LOOP_END] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.util.List] */
    @Override // eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(eu.bolt.android.audio_recording_engine.engine.OrderData r7, kotlin.coroutines.Continuation<? super java.util.List<eu.bolt.android.audio_recording_engine.engine.UploadParams>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl$getUploadParams$1
            if (r0 == 0) goto L13
            r0 = r8
            eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl$getUploadParams$1 r0 = (eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl$getUploadParams$1) r0
            int r1 = r0.f36649j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36649j = r1
            goto L18
        L13:
            eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl$getUploadParams$1 r0 = new eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl$getUploadParams$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f36647h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f36649j
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.f36646g
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r0 = r0.f36645f
            java.io.File[] r0 = (java.io.File[]) r0
            kotlin.ResultKt.b(r8)
            goto L78
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            kotlin.ResultKt.b(r8)
            eu.bolt.android.audio_recording_engine.engine.DirectoryType r8 = eu.bolt.android.audio_recording_engine.engine.DirectoryType.ENCRYPTED_DIR
            java.lang.String r8 = r6.k(r7, r8)
            java.io.File r2 = new java.io.File
            r2.<init>(r8)
            java.io.File[] r8 = r2.listFiles()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r4 = 0
            if (r8 == 0) goto L5b
            int r5 = r8.length
            if (r5 != 0) goto L58
            r5 = 1
            goto L59
        L58:
            r5 = 0
        L59:
            if (r5 == 0) goto L5c
        L5b:
            r4 = 1
        L5c:
            if (r4 != 0) goto L99
            eu.bolt.android.audio_recording_engine.db.AudioRecordingDBImpl r4 = r6.j()
            eu.bolt.android.audio_recording_engine.db.DatabaseUtils r5 = eu.bolt.android.audio_recording_engine.db.DatabaseUtils.f36600a
            java.lang.String r7 = r5.a(r7)
            r0.f36645f = r8
            r0.f36646g = r2
            r0.f36649j = r3
            java.lang.Object r7 = r4.b(r7, r0)
            if (r7 != r1) goto L75
            return r1
        L75:
            r0 = r8
            r8 = r7
            r7 = r2
        L78:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L7e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L98
            java.lang.Object r1 = r8.next()
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            eu.bolt.android.audio_recording_engine.engine.UploadParams r2 = new eu.bolt.android.audio_recording_engine.engine.UploadParams
            int r3 = r0.length
            r2.<init>(r1, r3)
            r7.add(r2)
            goto L7e
        L98:
            r2 = r7
        L99:
            java.util.List r7 = kotlin.collections.CollectionsKt.H0(r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl.d(eu.bolt.android.audio_recording_engine.engine.OrderData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    @Override // eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object f(kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl.f(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r2 != false) goto L18;
     */
    @Override // eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object g(eu.bolt.android.audio_recording_engine.engine.OrderData r4, java.lang.String r5, int r6, kotlin.coroutines.Continuation<? super android.net.Uri> r7) {
        /*
            r3 = this;
            eu.bolt.android.audio_recording_engine.engine.StorageUtils r7 = eu.bolt.android.audio_recording_engine.engine.StorageUtils.f36684a
            boolean r7 = r7.a()
            if (r7 == 0) goto L53
            eu.bolt.android.audio_recording_engine.engine.DirectoryType r7 = eu.bolt.android.audio_recording_engine.engine.DirectoryType.ENCRYPTED_DIR
            java.lang.String r7 = r3.k(r4, r7)
            eu.bolt.android.audio_recording_engine.engine.DirectoryType r0 = eu.bolt.android.audio_recording_engine.engine.DirectoryType.DECRYPTED_DIR
            java.lang.String r4 = r3.k(r4, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            java.io.File[] r7 = r0.listFiles()
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L2b
            r0.mkdirs()
        L2b:
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L37
            int r2 = r7.length
            if (r2 != 0) goto L34
            r2 = 1
            goto L35
        L34:
            r2 = 0
        L35:
            if (r2 == 0) goto L38
        L37:
            r0 = 1
        L38:
            if (r0 != 0) goto L51
            eu.bolt.android.audio_recording_engine.engine.EncryptionHandler r0 = eu.bolt.android.audio_recording_engine.engine.EncryptionHandler.f36667a
            r6 = r7[r6]
            java.lang.String r7 = "encryptedFiles[fileIndex]"
            kotlin.jvm.internal.Intrinsics.e(r6, r7)
            java.io.File r4 = r0.a(r5, r6, r4)
            android.net.Uri r4 = android.net.Uri.fromFile(r4)
            java.lang.String r5 = "fromFile(this)"
            kotlin.jvm.internal.Intrinsics.e(r4, r5)
            goto L52
        L51:
            r4 = 0
        L52:
            return r4
        L53:
            eu.bolt.android.audio_recording_engine.exception.NotEnoughStorageException r4 = new eu.bolt.android.audio_recording_engine.exception.NotEnoughStorageException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.audio_recording_engine.engine.AudioRecorderImpl.g(eu.bolt.android.audio_recording_engine.engine.OrderData, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi
    public void h(OrderData orderData, String cryptoKey) {
        Intrinsics.f(orderData, "orderData");
        Intrinsics.f(cryptoKey, "cryptoKey");
        if (StorageUtils.f36684a.a()) {
            if (this.f36636e == null) {
                n();
            }
            String k8 = k(orderData, DirectoryType.ENCRYPTED_DIR);
            File file = new File(k8);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f36634c = k8;
            this.f36637f = orderData;
            this.f36638g = cryptoKey;
            q();
            return;
        }
        throw new NotEnoughStorageException();
    }

    @Override // eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi
    /* renamed from: o */
    public MutableStateFlow<RecorderState> e() {
        return this.f36635d;
    }
}
