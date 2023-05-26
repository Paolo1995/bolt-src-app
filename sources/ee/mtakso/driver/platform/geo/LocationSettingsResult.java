package ee.mtakso.driver.platform.geo;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationSettingsResult.kt */
/* loaded from: classes3.dex */
public abstract class LocationSettingsResult {

    /* compiled from: LocationSettingsResult.kt */
    /* loaded from: classes3.dex */
    public static final class Error extends LocationSettingsResult {

        /* renamed from: a  reason: collision with root package name */
        private final Exception f23282a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Exception platformException) {
            super(null);
            Intrinsics.f(platformException, "platformException");
            this.f23282a = platformException;
        }

        public final Exception a() {
            return this.f23282a;
        }
    }

    /* compiled from: LocationSettingsResult.kt */
    /* loaded from: classes3.dex */
    public static final class Ok extends LocationSettingsResult {

        /* renamed from: a  reason: collision with root package name */
        public static final Ok f23283a = new Ok();

        private Ok() {
            super(null);
        }
    }

    /* compiled from: LocationSettingsResult.kt */
    /* loaded from: classes3.dex */
    public static final class ResolvableError extends LocationSettingsResult {

        /* renamed from: a  reason: collision with root package name */
        private final Exception f23284a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResolvableError(Exception platformException) {
            super(null);
            Intrinsics.f(platformException, "platformException");
            this.f23284a = platformException;
        }

        public final Exception a() {
            return this.f23284a;
        }
    }

    /* compiled from: LocationSettingsResult.kt */
    /* loaded from: classes3.dex */
    public static final class SettingsChangeUnavailable extends LocationSettingsResult {

        /* renamed from: a  reason: collision with root package name */
        public static final SettingsChangeUnavailable f23285a = new SettingsChangeUnavailable();

        private SettingsChangeUnavailable() {
            super(null);
        }
    }

    private LocationSettingsResult() {
    }

    public /* synthetic */ LocationSettingsResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
