package ee.mtakso.driver.ui.interactor.driver;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkRadius.kt */
/* loaded from: classes3.dex */
public abstract class WorkRadius {

    /* compiled from: WorkRadius.kt */
    /* loaded from: classes3.dex */
    public static final class Disabled extends WorkRadius {

        /* renamed from: a  reason: collision with root package name */
        public static final Disabled f26519a = new Disabled();

        private Disabled() {
            super(null);
        }
    }

    /* compiled from: WorkRadius.kt */
    /* loaded from: classes3.dex */
    public static final class Enabled extends WorkRadius {

        /* renamed from: a  reason: collision with root package name */
        private final String f26520a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Enabled(String radius) {
            super(null);
            Intrinsics.f(radius, "radius");
            this.f26520a = radius;
        }

        public final String a() {
            return this.f26520a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Enabled) && Intrinsics.a(this.f26520a, ((Enabled) obj).f26520a);
        }

        public int hashCode() {
            return this.f26520a.hashCode();
        }

        public String toString() {
            String str = this.f26520a;
            return "Enabled(radius=" + str + ")";
        }
    }

    private WorkRadius() {
    }

    public /* synthetic */ WorkRadius(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
