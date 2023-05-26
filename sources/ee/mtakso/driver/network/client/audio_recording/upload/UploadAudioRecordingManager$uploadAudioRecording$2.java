package ee.mtakso.driver.network.client.audio_recording.upload;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.audio_recording.WebAppLaunchParams;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadAudioRecordingManager.kt */
@DebugMetadata(c = "ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager$uploadAudioRecording$2", f = "UploadAudioRecordingManager.kt", l = {29, 31, 36, 42, 47, 52}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class UploadAudioRecordingManager$uploadAudioRecording$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends WebAppLaunchParams>>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f21407g;

    /* renamed from: h  reason: collision with root package name */
    Object f21408h;

    /* renamed from: i  reason: collision with root package name */
    Object f21409i;

    /* renamed from: j  reason: collision with root package name */
    Object f21410j;

    /* renamed from: k  reason: collision with root package name */
    Object f21411k;

    /* renamed from: l  reason: collision with root package name */
    Object f21412l;

    /* renamed from: m  reason: collision with root package name */
    Object f21413m;

    /* renamed from: n  reason: collision with root package name */
    int f21414n;

    /* renamed from: o  reason: collision with root package name */
    private /* synthetic */ Object f21415o;

    /* renamed from: p  reason: collision with root package name */
    final /* synthetic */ UploadAudioRecordingManager f21416p;

    /* renamed from: q  reason: collision with root package name */
    final /* synthetic */ OrderHandle f21417q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadAudioRecordingManager$uploadAudioRecording$2(UploadAudioRecordingManager uploadAudioRecordingManager, OrderHandle orderHandle, Continuation<? super UploadAudioRecordingManager$uploadAudioRecording$2> continuation) {
        super(2, continuation);
        this.f21416p = uploadAudioRecordingManager;
        this.f21417q = orderHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UploadAudioRecordingManager$uploadAudioRecording$2 uploadAudioRecordingManager$uploadAudioRecording$2 = new UploadAudioRecordingManager$uploadAudioRecording$2(this.f21416p, this.f21417q, continuation);
        uploadAudioRecordingManager$uploadAudioRecording$2.f21415o = obj;
        return uploadAudioRecordingManager$uploadAudioRecording$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Result<WebAppLaunchParams>> continuation) {
        return ((UploadAudioRecordingManager$uploadAudioRecording$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x012a A[Catch: all -> 0x0223, TryCatch #0 {all -> 0x0223, blocks: (B:7:0x0028, B:31:0x0124, B:33:0x012a, B:36:0x0152, B:40:0x0185, B:42:0x0189, B:46:0x01b9, B:50:0x01e2, B:54:0x0212, B:55:0x0219, B:56:0x021a, B:10:0x004c, B:14:0x0076, B:17:0x009f, B:20:0x00c9, B:23:0x00e2, B:29:0x0118, B:26:0x00f3), top: B:62:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x017a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0189 A[Catch: all -> 0x0223, TryCatch #0 {all -> 0x0223, blocks: (B:7:0x0028, B:31:0x0124, B:33:0x012a, B:36:0x0152, B:40:0x0185, B:42:0x0189, B:46:0x01b9, B:50:0x01e2, B:54:0x0212, B:55:0x0219, B:56:0x021a, B:10:0x004c, B:14:0x0076, B:17:0x009f, B:20:0x00c9, B:23:0x00e2, B:29:0x0118, B:26:0x00f3), top: B:62:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0209 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0212 A[Catch: all -> 0x0223, TryCatch #0 {all -> 0x0223, blocks: (B:7:0x0028, B:31:0x0124, B:33:0x012a, B:36:0x0152, B:40:0x0185, B:42:0x0189, B:46:0x01b9, B:50:0x01e2, B:54:0x0212, B:55:0x0219, B:56:0x021a, B:10:0x004c, B:14:0x0076, B:17:0x009f, B:20:0x00c9, B:23:0x00e2, B:29:0x0118, B:26:0x00f3), top: B:62:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x021a A[Catch: all -> 0x0223, TRY_LEAVE, TryCatch #0 {all -> 0x0223, blocks: (B:7:0x0028, B:31:0x0124, B:33:0x012a, B:36:0x0152, B:40:0x0185, B:42:0x0189, B:46:0x01b9, B:50:0x01e2, B:54:0x0212, B:55:0x0219, B:56:0x021a, B:10:0x004c, B:14:0x0076, B:17:0x009f, B:20:0x00c9, B:23:0x00e2, B:29:0x0118, B:26:0x00f3), top: B:62:0x0009 }] */
    /* JADX WARN: Type inference failed for: r10v7, types: [ee.mtakso.driver.network.client.audio_recording.WebAppLaunchParams, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x020a -> B:31:0x0124). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager$uploadAudioRecording$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
