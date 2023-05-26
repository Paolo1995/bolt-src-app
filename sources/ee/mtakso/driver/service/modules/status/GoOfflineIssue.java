package ee.mtakso.driver.service.modules.status;

import ee.mtakso.driver.network.response.ErrorData;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoOfflineIssue.kt */
/* loaded from: classes3.dex */
public abstract class GoOfflineIssue {

    /* compiled from: GoOfflineIssue.kt */
    /* loaded from: classes3.dex */
    public static final class Blocked extends GoOfflineIssue {

        /* renamed from: a  reason: collision with root package name */
        private final ErrorData f25251a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Blocked(ErrorData errorData) {
            super(null);
            Intrinsics.f(errorData, "errorData");
            this.f25251a = errorData;
        }

        public final ErrorData a() {
            return this.f25251a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Blocked) && Intrinsics.a(this.f25251a, ((Blocked) obj).f25251a);
        }

        public int hashCode() {
            return this.f25251a.hashCode();
        }

        public String toString() {
            ErrorData errorData = this.f25251a;
            return "Blocked(errorData=" + errorData + ")";
        }
    }

    /* compiled from: GoOfflineIssue.kt */
    /* loaded from: classes3.dex */
    public static final class Failed extends GoOfflineIssue {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f25252a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(Throwable throwable) {
            super(null);
            Intrinsics.f(throwable, "throwable");
            this.f25252a = throwable;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && Intrinsics.a(this.f25252a, ((Failed) obj).f25252a);
        }

        public int hashCode() {
            return this.f25252a.hashCode();
        }

        public String toString() {
            Throwable th = this.f25252a;
            return "Failed(throwable=" + th + ")";
        }
    }

    private GoOfflineIssue() {
    }

    public /* synthetic */ GoOfflineIssue(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
