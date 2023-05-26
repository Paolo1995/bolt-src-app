package ee.mtakso.driver.utils.effects;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VibrateEffect.kt */
/* loaded from: classes5.dex */
public final class VibrateEffect implements Effect {

    /* renamed from: d  reason: collision with root package name */
    private static final Companion f36416d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Vibrator f36417a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioManager f36418b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f36419c;

    /* compiled from: VibrateEffect.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: VibrateEffect.kt */
    /* loaded from: classes5.dex */
    public static final class Type {

        /* renamed from: j  reason: collision with root package name */
        public static final Type f36420j;

        /* renamed from: k  reason: collision with root package name */
        public static final Type f36421k;

        /* renamed from: l  reason: collision with root package name */
        private static final /* synthetic */ Type[] f36422l;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f36423f;

        /* renamed from: g  reason: collision with root package name */
        private final long[] f36424g;

        /* renamed from: h  reason: collision with root package name */
        private final int[] f36425h;

        /* renamed from: i  reason: collision with root package name */
        private final int f36426i;

        static {
            long[] jArr = {0, 100, 1000, 300, 200, 100, 500, 200, 100};
            int[] iArr = new int[9];
            for (int i8 = 0; i8 < 9; i8++) {
                iArr[i8] = -1;
            }
            f36420j = new Type("RING", 0, false, jArr, iArr, 0);
            long[] jArr2 = {200, 500, 300, 500, 1000};
            int[] iArr2 = new int[5];
            for (int i9 = 0; i9 < 5; i9++) {
                iArr2[i9] = -1;
            }
            f36421k = new Type("NEW_ORDER", 1, false, jArr2, iArr2, 0);
            f36422l = a();
        }

        private Type(String str, int i8, boolean z7, long[] jArr, int[] iArr, int i9) {
            this.f36423f = z7;
            this.f36424g = jArr;
            this.f36425h = iArr;
            this.f36426i = i9;
        }

        private static final /* synthetic */ Type[] a() {
            return new Type[]{f36420j, f36421k};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f36422l.clone();
        }

        public final int[] c() {
            return this.f36425h;
        }

        public final int e() {
            return this.f36426i;
        }

        public final long[] f() {
            return this.f36424g;
        }

        public final boolean h() {
            return this.f36423f;
        }
    }

    public VibrateEffect(Vibrator vibrator, AudioManager audioManager, Type type) {
        Intrinsics.f(vibrator, "vibrator");
        Intrinsics.f(audioManager, "audioManager");
        Intrinsics.f(type, "type");
        this.f36417a = vibrator;
        this.f36418b = audioManager;
        this.f36419c = type;
    }

    @TargetApi(26)
    private final VibrationEffect b(Type type) {
        if (type.h()) {
            VibrationEffect createOneShot = VibrationEffect.createOneShot(type.f()[0], type.c()[0]);
            Intrinsics.e(createOneShot, "{\n            VibrationE… amplitudes[0])\n        }");
            return createOneShot;
        }
        VibrationEffect createWaveform = VibrationEffect.createWaveform(type.f(), type.c(), type.e());
        Intrinsics.e(createWaveform, "{\n            VibrationE…itudes, repeat)\n        }");
        return createWaveform;
    }

    private final boolean c() {
        int ringerMode = this.f36418b.getRingerMode();
        if (ringerMode == 0) {
            return false;
        }
        if (ringerMode != 1 && ringerMode != 2) {
            return false;
        }
        return true;
    }

    @Override // ee.mtakso.driver.utils.effects.Effect
    @SuppressLint({"MissingPermission"})
    public void a() {
        if (this.f36417a.hasVibrator() && c()) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f36417a.vibrate(b(this.f36419c));
            } else if (this.f36419c.h()) {
                this.f36417a.vibrate(this.f36419c.f()[0]);
            } else {
                this.f36417a.vibrate(this.f36419c.f(), this.f36419c.e());
            }
        }
    }

    @Override // ee.mtakso.driver.utils.effects.Effect
    @SuppressLint({"MissingPermission"})
    public void cancel() {
        if (!this.f36417a.hasVibrator()) {
            return;
        }
        this.f36417a.cancel();
    }
}
