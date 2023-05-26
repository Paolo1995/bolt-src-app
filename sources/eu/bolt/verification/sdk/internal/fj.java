package eu.bolt.verification.sdk.internal;

import io.reactivex.Observable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public interface fj {

    /* loaded from: classes5.dex */
    public static abstract class a {

        /* renamed from: eu.bolt.verification.sdk.internal.fj$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0054a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f42999a;

            /* renamed from: b  reason: collision with root package name */
            private final Throwable f43000b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0054a(String storyId, Throwable th) {
                super(null);
                Intrinsics.f(storyId, "storyId");
                this.f42999a = storyId;
                this.f43000b = th;
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f43001a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String slideId) {
                super(null);
                Intrinsics.f(slideId, "slideId");
                this.f43001a = slideId;
            }

            public final String a() {
                return this.f43001a;
            }
        }

        /* loaded from: classes5.dex */
        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f43002a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String storyId) {
                super(null);
                Intrinsics.f(storyId, "storyId");
                this.f43002a = storyId;
            }
        }

        /* loaded from: classes5.dex */
        public static final class d extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f43003a;

            /* renamed from: b  reason: collision with root package name */
            private final Throwable f43004b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(String storyId, Throwable th) {
                super(null);
                Intrinsics.f(storyId, "storyId");
                this.f43003a = storyId;
                this.f43004b = th;
            }

            public final Throwable a() {
                return this.f43004b;
            }
        }

        /* loaded from: classes5.dex */
        public static final class e extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f43005a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(String storyId) {
                super(null);
                Intrinsics.f(storyId, "storyId");
                this.f43005a = storyId;
            }
        }

        /* loaded from: classes5.dex */
        public static final class f extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f43006a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(String storyId) {
                super(null);
                Intrinsics.f(storyId, "storyId");
                this.f43006a = storyId;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    void a();

    void b();

    void close();

    void d(int i8);

    void e(String str);

    Observable<a> h();
}
