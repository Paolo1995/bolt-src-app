package ee.mtakso.driver.ui.screens.work.map;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapExplanationState.kt */
/* loaded from: classes5.dex */
public abstract class MapExplanationState {

    /* compiled from: MapExplanationState.kt */
    /* loaded from: classes5.dex */
    public static final class Error extends MapExplanationState {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f34128a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable error) {
            super(null);
            Intrinsics.f(error, "error");
            this.f34128a = error;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.a(this.f34128a, ((Error) obj).f34128a);
        }

        public int hashCode() {
            return this.f34128a.hashCode();
        }

        public String toString() {
            Throwable th = this.f34128a;
            return "Error(error=" + th + ")";
        }
    }

    /* compiled from: MapExplanationState.kt */
    /* loaded from: classes5.dex */
    public static final class Loading extends MapExplanationState {

        /* renamed from: a  reason: collision with root package name */
        public static final Loading f34129a = new Loading();

        private Loading() {
            super(null);
        }
    }

    /* compiled from: MapExplanationState.kt */
    /* loaded from: classes5.dex */
    public static final class Ready extends MapExplanationState {

        /* renamed from: a  reason: collision with root package name */
        private final String f34130a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ready(String htmlContent) {
            super(null);
            Intrinsics.f(htmlContent, "htmlContent");
            this.f34130a = htmlContent;
        }

        public final String a() {
            return this.f34130a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ready) && Intrinsics.a(this.f34130a, ((Ready) obj).f34130a);
        }

        public int hashCode() {
            return this.f34130a.hashCode();
        }

        public String toString() {
            String str = this.f34130a;
            return "Ready(htmlContent=" + str + ")";
        }
    }

    private MapExplanationState() {
    }

    public /* synthetic */ MapExplanationState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
