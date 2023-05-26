package ee.mtakso.driver.ui.interactor.driver;

import ee.mtakso.driver.service.modules.status.GoOfflineIssue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MakeDriverInactiveInteractor.kt */
/* loaded from: classes3.dex */
public abstract class MakeDriverInactiveStatus {

    /* compiled from: MakeDriverInactiveInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Failed extends MakeDriverInactiveStatus {

        /* renamed from: a  reason: collision with root package name */
        private final GoOfflineIssue f26501a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(GoOfflineIssue issue) {
            super(null);
            Intrinsics.f(issue, "issue");
            this.f26501a = issue;
        }

        public final GoOfflineIssue a() {
            return this.f26501a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && Intrinsics.a(this.f26501a, ((Failed) obj).f26501a);
        }

        public int hashCode() {
            return this.f26501a.hashCode();
        }

        public String toString() {
            GoOfflineIssue goOfflineIssue = this.f26501a;
            return "Failed(issue=" + goOfflineIssue + ")";
        }
    }

    /* compiled from: MakeDriverInactiveInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Inactive extends MakeDriverInactiveStatus {

        /* renamed from: a  reason: collision with root package name */
        private final SetInactiveConfirmationSignal f26502a;

        public Inactive(SetInactiveConfirmationSignal setInactiveConfirmationSignal) {
            super(null);
            this.f26502a = setInactiveConfirmationSignal;
        }

        public final SetInactiveConfirmationSignal a() {
            return this.f26502a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Inactive) && this.f26502a == ((Inactive) obj).f26502a;
        }

        public int hashCode() {
            SetInactiveConfirmationSignal setInactiveConfirmationSignal = this.f26502a;
            if (setInactiveConfirmationSignal == null) {
                return 0;
            }
            return setInactiveConfirmationSignal.hashCode();
        }

        public String toString() {
            SetInactiveConfirmationSignal setInactiveConfirmationSignal = this.f26502a;
            return "Inactive(signal=" + setInactiveConfirmationSignal + ")";
        }
    }

    private MakeDriverInactiveStatus() {
    }

    public /* synthetic */ MakeDriverInactiveStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
