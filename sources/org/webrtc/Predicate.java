package org.webrtc;

/* loaded from: classes4.dex */
public interface Predicate<T> {

    /* renamed from: org.webrtc.Predicate$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC<T> {
        public static Predicate a(final Predicate predicate, final Predicate predicate2) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.2
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate3) {
                    return CC.a(this, predicate3);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.b(this);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate3) {
                    return CC.c(this, predicate3);
                }

                @Override // org.webrtc.Predicate
                public boolean test(T t7) {
                    return Predicate.this.test(t7) && predicate2.test(t7);
                }
            };
        }

        public static Predicate b(final Predicate predicate) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.3
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate2) {
                    return CC.a(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.b(this);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate2) {
                    return CC.c(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public boolean test(T t7) {
                    return !Predicate.this.test(t7);
                }
            };
        }

        public static Predicate c(final Predicate predicate, final Predicate predicate2) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.1
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate3) {
                    return CC.a(this, predicate3);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.b(this);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate3) {
                    return CC.c(this, predicate3);
                }

                @Override // org.webrtc.Predicate
                public boolean test(T t7) {
                    return Predicate.this.test(t7) || predicate2.test(t7);
                }
            };
        }
    }

    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> predicate);

    boolean test(T t7);
}
