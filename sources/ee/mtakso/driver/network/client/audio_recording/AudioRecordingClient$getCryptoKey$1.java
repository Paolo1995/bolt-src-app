package ee.mtakso.driver.network.client.audio_recording;

import ee.mtakso.driver.network.client.OrderHandle;
import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.ServerResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioRecordingClient.kt */
@DebugMetadata(c = "ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient$getCryptoKey$1", f = "AudioRecordingClient.kt", l = {22}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AudioRecordingClient$getCryptoKey$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GetCryptoKeyResponse>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f21370g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ AudioRecordingClient f21371h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OrderHandle f21372i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRecordingClient$getCryptoKey$1(AudioRecordingClient audioRecordingClient, OrderHandle orderHandle, Continuation<? super AudioRecordingClient$getCryptoKey$1> continuation) {
        super(2, continuation);
        this.f21371h = audioRecordingClient;
        this.f21372i = orderHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioRecordingClient$getCryptoKey$1(this.f21371h, this.f21372i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super GetCryptoKeyResponse> continuation) {
        return ((AudioRecordingClient$getCryptoKey$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        AudioRecordingNetworkAPI audioRecordingNetworkAPI;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f21370g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            audioRecordingNetworkAPI = this.f21371h.f21369b;
            GetCryptoKeyRequest getCryptoKeyRequest = new GetCryptoKeyRequest(this.f21372i);
            this.f21370g = 1;
            obj = audioRecordingNetworkAPI.c(getCryptoKeyRequest, this);
            if (obj == d8) {
                return d8;
            }
        }
        return BasicServerResponseKt.a((ServerResponse) obj);
    }
}
