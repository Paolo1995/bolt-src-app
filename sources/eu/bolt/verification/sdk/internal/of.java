package eu.bolt.verification.sdk.internal;

import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class of {

    /* renamed from: a  reason: collision with root package name */
    private final ip f44455a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f44456a;

        public a(String sdkEvent) {
            Intrinsics.f(sdkEvent, "sdkEvent");
            this.f44456a = sdkEvent;
        }

        public final String a() {
            return this.f44456a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f44456a, ((a) obj).f44456a);
        }

        public int hashCode() {
            return this.f44456a.hashCode();
        }

        public String toString() {
            String str = this.f44456a;
            return "Args(sdkEvent=" + str + ")";
        }
    }

    @Inject
    public of(ip verificationNetworkRepository) {
        Intrinsics.f(verificationNetworkRepository, "verificationNetworkRepository");
        this.f44455a = verificationNetworkRepository;
    }

    public Completable a(a args) {
        Intrinsics.f(args, "args");
        return this.f44455a.n(args.a());
    }
}
