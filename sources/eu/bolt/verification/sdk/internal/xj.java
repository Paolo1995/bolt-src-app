package eu.bolt.verification.sdk.internal;

import android.os.CountDownTimer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class xj {

    /* renamed from: g  reason: collision with root package name */
    public static final a f45658g = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final long f45659a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Float, Unit> f45660b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<Unit> f45661c;

    /* renamed from: d  reason: collision with root package name */
    private CountDownTimer f45662d;

    /* renamed from: e  reason: collision with root package name */
    private long f45663e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f45664f;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ xj f45665a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j8, xj xjVar) {
            super(j8, 32L);
            this.f45665a = xjVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f45665a.f45664f = false;
            this.f45665a.f45661c.invoke();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j8) {
            this.f45665a.f45663e = j8;
            this.f45665a.f45660b.invoke(Float.valueOf(this.f45665a.h()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public xj(long j8, Function1<? super Float, Unit> onTick, Function0<Unit> onFinish) {
        Intrinsics.f(onTick, "onTick");
        Intrinsics.f(onFinish, "onFinish");
        this.f45659a = j8;
        this.f45660b = onTick;
        this.f45661c = onFinish;
    }

    private final b a(long j8) {
        return new b(j8, this);
    }

    private final boolean e() {
        return !this.f45664f && this.f45663e > 0;
    }

    public final void g() {
        CountDownTimer countDownTimer = this.f45662d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f45663e = 0L;
        this.f45664f = false;
    }

    public final float h() {
        return 1.0f - (((float) this.f45663e) / ((float) this.f45659a));
    }

    public final boolean i() {
        return this.f45664f;
    }

    public final void j() {
        CountDownTimer countDownTimer = this.f45662d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f45664f = false;
    }

    public final void k() {
        if (e()) {
            this.f45662d = a(this.f45663e).start();
            this.f45664f = true;
        }
    }

    public final void l() {
        long j8 = this.f45659a;
        this.f45663e = j8;
        this.f45662d = a(j8).start();
        this.f45664f = true;
    }
}
