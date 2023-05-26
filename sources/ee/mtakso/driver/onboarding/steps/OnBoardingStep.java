package ee.mtakso.driver.onboarding.steps;

import androidx.fragment.app.Fragment;
import ee.mtakso.driver.routing.command.NavigationCommand;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBoardingStep.kt */
/* loaded from: classes3.dex */
public abstract class OnBoardingStep {

    /* renamed from: a  reason: collision with root package name */
    private final Type f23041a;

    /* renamed from: b  reason: collision with root package name */
    private final Severity f23042b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23043c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23044d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f23045e;

    /* renamed from: f  reason: collision with root package name */
    private final Integer f23046f;

    /* compiled from: OnBoardingStep.kt */
    /* loaded from: classes3.dex */
    public enum Severity {
        MANDATORY,
        OPTIONAL
    }

    /* compiled from: OnBoardingStep.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        PERMISSION_OVERLAY(0),
        PERMISSION_BATTERY_EXCLUSION(1),
        PERMISSION_AUTO_START(2),
        PERMISSION_OTHER(3),
        PERMISSION_NOTIFICATION(4),
        PERMISSION_NOTIFICATION_SOUND(5),
        PERMISSION_RECORD_AUDIO(6);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f23058f;

        Type(int i8) {
            this.f23058f = i8;
        }

        public final int c() {
            return this.f23058f;
        }
    }

    public OnBoardingStep(Type type, Severity severity, int i8, int i9, Integer num, Integer num2) {
        Intrinsics.f(type, "type");
        Intrinsics.f(severity, "severity");
        this.f23041a = type;
        this.f23042b = severity;
        this.f23043c = i8;
        this.f23044d = i9;
        this.f23045e = num;
        this.f23046f = num2;
    }

    public final int a() {
        return this.f23044d;
    }

    public final Integer b() {
        return this.f23046f;
    }

    public final Severity c() {
        return this.f23042b;
    }

    public final Integer d() {
        return this.f23045e;
    }

    public final int e() {
        return this.f23043c;
    }

    public final Type f() {
        return this.f23041a;
    }

    public abstract NavigationCommand<Fragment> g(int i8);

    public abstract boolean h();

    public /* synthetic */ OnBoardingStep(Type type, Severity severity, int i8, int i9, Integer num, Integer num2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, (i10 & 2) != 0 ? Severity.OPTIONAL : severity, i8, i9, (i10 & 16) != 0 ? null : num, (i10 & 32) != 0 ? null : num2);
    }
}
