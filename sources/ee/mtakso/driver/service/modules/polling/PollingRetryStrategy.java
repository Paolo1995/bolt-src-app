package ee.mtakso.driver.service.modules.polling;

import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import ee.mtakso.driver.utils.polling.RetryStrategy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollingRetryStrategy.kt */
/* loaded from: classes3.dex */
public final class PollingRetryStrategy implements RetryStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f25136a = new Companion(null);

    /* compiled from: PollingRetryStrategy.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // ee.mtakso.driver.utils.polling.RetryStrategy
    public long a(Throwable throwable) {
        Intrinsics.f(throwable, "throwable");
        if (ApiExceptionUtils.m(throwable, 23, 22)) {
            return -1L;
        }
        return 2L;
    }
}
