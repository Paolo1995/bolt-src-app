package ee.mtakso.voip_client;

import android.annotation.NonNull;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import ee.mtakso.voip_client.VoipAudioManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.webrtc.MediaStreamTrack;

/* compiled from: VoipAudioManager.kt */
/* loaded from: classes5.dex */
public final class VoipAudioManager implements VoipAudioDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36487a;

    /* renamed from: b  reason: collision with root package name */
    private final VoipLogger f36488b;

    /* renamed from: c  reason: collision with root package name */
    private final KFunction<Unit> f36489c;

    /* renamed from: d  reason: collision with root package name */
    private AudioFocusRequest f36490d;

    /* renamed from: e  reason: collision with root package name */
    private final VoipBluetoothManager f36491e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f36492f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f36493g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f36494h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f36495i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f36496j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f36497k;

    public VoipAudioManager(Context context, VoipLogger logger) {
        Intrinsics.f(context, "context");
        Intrinsics.f(logger, "logger");
        this.f36487a = context;
        this.f36488b = logger;
        this.f36489c = new VoipAudioManager$audioFocusChangedListener$1(this);
        this.f36491e = new VoipBluetoothManager(context, logger);
        this.f36492f = k().isMicrophoneMute();
        this.f36493g = k().isSpeakerphoneOn();
    }

    private final void h() {
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.f36490d;
            if (audioFocusRequest != null) {
                k().abandonAudioFocusRequest(audioFocusRequest);
                return;
            }
            return;
        }
        AudioManager k8 = k();
        final KFunction<Unit> kFunction = this.f36489c;
        k8.abandonAudioFocus(new AudioManager.OnAudioFocusChangeListener() { // from class: c6.e
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i8) {
                VoipAudioManager.i(KFunction.this, i8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(KFunction tmp0, int i8) {
        Intrinsics.f(tmp0, "$tmp0");
        ((Function1) tmp0).invoke(Integer.valueOf(i8));
    }

    private final AudioManager k() {
        Object systemService = this.f36487a.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(int i8) {
        if (i8 != -3) {
            if (i8 != -2) {
                if (i8 == -1) {
                    this.f36488b.d("VoipAudioManager: audio focus changed to AUDIOFOCUS_LOSS", new Object[0]);
                    return;
                }
                return;
            }
            this.f36488b.d("VoipAudioManager: audio focus changed to AUDIOFOCUS_LOSS_TRANSIENT", new Object[0]);
            return;
        }
        this.f36488b.d("VoipAudioManager: audio focus changed to AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK", new Object[0]);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.media.AudioFocusRequest$Builder] */
    private final int m() {
        int requestAudioFocus;
        if (Build.VERSION.SDK_INT >= 26) {
            AudioManager k8 = k();
            AudioFocusRequest.Builder audioAttributes = new Object(4) { // from class: android.media.AudioFocusRequest.Builder
                static {
                    throw new NoClassDefFoundError();
                }

                public native /* synthetic */ AudioFocusRequest build();

                @NonNull
                public native /* synthetic */ Builder setAudioAttributes(@NonNull AudioAttributes audioAttributes2);

                @NonNull
                public native /* synthetic */ Builder setOnAudioFocusChangeListener(@NonNull AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener);
            }.setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(0).build());
            final KFunction<Unit> kFunction = this.f36489c;
            AudioFocusRequest build = audioAttributes.setOnAudioFocusChangeListener(new AudioManager.OnAudioFocusChangeListener() { // from class: c6.c
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final void onAudioFocusChange(int i8) {
                    VoipAudioManager.n(KFunction.this, i8);
                }
            }).build();
            this.f36490d = build;
            requestAudioFocus = k8.requestAudioFocus(build);
            return requestAudioFocus;
        }
        AudioManager k9 = k();
        final KFunction<Unit> kFunction2 = this.f36489c;
        return k9.requestAudioFocus(new AudioManager.OnAudioFocusChangeListener() { // from class: c6.d
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i8) {
                VoipAudioManager.o(KFunction.this, i8);
            }
        }, 0, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(KFunction tmp0, int i8) {
        Intrinsics.f(tmp0, "$tmp0");
        ((Function1) tmp0).invoke(Integer.valueOf(i8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(KFunction tmp0, int i8) {
        Intrinsics.f(tmp0, "$tmp0");
        ((Function1) tmp0).invoke(Integer.valueOf(i8));
    }

    private final void p() {
        if (!this.f36495i) {
            return;
        }
        k().setMicrophoneMute(this.f36492f);
        k().setSpeakerphoneOn(this.f36493g);
        k().setMode(0);
        this.f36495i = false;
    }

    private final void q() {
        if (this.f36495i) {
            return;
        }
        this.f36492f = k().isMicrophoneMute();
        this.f36493g = k().isSpeakerphoneOn();
        this.f36495i = true;
    }

    private final void r(boolean z7) {
        k().setMicrophoneMute(z7);
    }

    private final void s(boolean z7) {
        k().setSpeakerphoneOn(z7);
        this.f36491e.m(!z7);
    }

    @Override // ee.mtakso.voip_client.VoipAudioDelegate
    public void a(boolean z7) {
        q();
        r(z7);
        this.f36496j = z7;
    }

    @Override // ee.mtakso.voip_client.VoipAudioDelegate
    public void b(boolean z7) {
        q();
        s(z7);
        this.f36497k = z7;
    }

    @Override // ee.mtakso.voip_client.VoipAudioDelegate
    public boolean d() {
        return this.f36496j;
    }

    @Override // ee.mtakso.voip_client.VoipAudioDelegate
    public boolean e() {
        return this.f36497k;
    }

    @Override // ee.mtakso.voip_client.VoipAudioDelegate
    public void reset() {
        p();
    }

    @Override // ee.mtakso.voip_client.VoipAudioDelegate
    public void start() {
        if (this.f36494h) {
            return;
        }
        int m8 = m();
        if (m8 != 0) {
            if (m8 == 2) {
                this.f36488b.d("VoipAudioManager: failed to obtain audio focus AUDIOFOCUS_REQUEST_DELAYED", new Object[0]);
            }
        } else {
            this.f36488b.d("VoipAudioManager: failed to obtain audio focus AUDIOFOCUS_REQUEST_FAILED", new Object[0]);
        }
        q();
        k().setMode(3);
        r(d());
        s(e());
        this.f36491e.j();
        this.f36494h = true;
    }

    @Override // ee.mtakso.voip_client.VoipAudioDelegate
    public void stop() {
        if (!this.f36494h) {
            return;
        }
        a(false);
        h();
        p();
        this.f36491e.k();
        this.f36494h = false;
    }
}
