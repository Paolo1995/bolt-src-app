package eu.bolt.android.stories.widget.story;

import android.os.CountDownTimer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySlideAutoSwitchTimer.kt */
/* loaded from: classes5.dex */
public final class StorySlideAutoSwitchTimer {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f37790g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final long f37791a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Float, Unit> f37792b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<Unit> f37793c;

    /* renamed from: d  reason: collision with root package name */
    private CountDownTimer f37794d;

    /* renamed from: e  reason: collision with root package name */
    private long f37795e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f37796f;

    /* compiled from: StorySlideAutoSwitchTimer.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StorySlideAutoSwitchTimer(long j8, Function1<? super Float, Unit> onTick, Function0<Unit> onFinish) {
        Intrinsics.f(onTick, "onTick");
        Intrinsics.f(onFinish, "onFinish");
        this.f37791a = j8;
        this.f37792b = onTick;
        this.f37793c = onFinish;
    }

    private final boolean e() {
        if (!this.f37796f && this.f37795e > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [eu.bolt.android.stories.widget.story.StorySlideAutoSwitchTimer$createCountDownTimer$1] */
    private final StorySlideAutoSwitchTimer$createCountDownTimer$1 g(final long j8) {
        return new CountDownTimer(j8) { // from class: eu.bolt.android.stories.widget.story.StorySlideAutoSwitchTimer$createCountDownTimer$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                Function0 function0;
                this.f37796f = false;
                function0 = this.f37793c;
                function0.invoke();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j9) {
                Function1 function1;
                this.f37795e = j9;
                function1 = this.f37792b;
                function1.invoke(Float.valueOf(this.h()));
            }
        };
    }

    public final void f() {
        CountDownTimer countDownTimer = this.f37794d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f37795e = 0L;
        this.f37796f = false;
    }

    public final float h() {
        return 1.0f - (((float) this.f37795e) / ((float) this.f37791a));
    }

    public final boolean i() {
        return this.f37796f;
    }

    public final void j() {
        CountDownTimer countDownTimer = this.f37794d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f37796f = false;
    }

    public final void k() {
        if (e()) {
            this.f37794d = g(this.f37795e).start();
            this.f37796f = true;
        }
    }

    public final void l() {
        if (!this.f37796f) {
            long j8 = this.f37791a;
            this.f37795e = j8;
            this.f37794d = g(j8).start();
            this.f37796f = true;
            return;
        }
        throw new IllegalStateException("Timer already running");
    }
}
