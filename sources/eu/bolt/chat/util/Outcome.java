package eu.bolt.chat.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Outcome.kt */
/* loaded from: classes5.dex */
public abstract class Outcome<R, E> {

    /* compiled from: Outcome.kt */
    /* loaded from: classes5.dex */
    public static final class Failure<R, E> extends Outcome<R, E> {

        /* renamed from: a  reason: collision with root package name */
        private final E f39700a;

        public Failure(E e8) {
            super(null);
            this.f39700a = e8;
        }

        public final E a() {
            return this.f39700a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && Intrinsics.a(this.f39700a, ((Failure) obj).f39700a);
        }

        public int hashCode() {
            E e8 = this.f39700a;
            if (e8 == null) {
                return 0;
            }
            return e8.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.f39700a + ')';
        }
    }

    /* compiled from: Outcome.kt */
    /* loaded from: classes5.dex */
    public static final class Success<R, E> extends Outcome<R, E> {

        /* renamed from: a  reason: collision with root package name */
        private final R f39701a;

        public Success(R r7) {
            super(null);
            this.f39701a = r7;
        }

        public final R a() {
            return this.f39701a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.a(this.f39701a, ((Success) obj).f39701a);
        }

        public int hashCode() {
            R r7 = this.f39701a;
            if (r7 == null) {
                return 0;
            }
            return r7.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.f39701a + ')';
        }
    }

    private Outcome() {
    }

    public /* synthetic */ Outcome(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
