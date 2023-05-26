package eu.bolt.verification.sdk.internal;

import io.reactivex.Observable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public interface yh {

    /* loaded from: classes5.dex */
    public static abstract class a {

        /* renamed from: eu.bolt.verification.sdk.internal.yh$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0100a extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0100a f45755a = new C0100a();

            private C0100a() {
                super(null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final b f45756a = new b();

            private b() {
                super(null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f45757a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String storyId) {
                super(null);
                Intrinsics.f(storyId, "storyId");
                this.f45757a = storyId;
            }

            public final String a() {
                return this.f45757a;
            }
        }

        /* loaded from: classes5.dex */
        public static final class d extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final d f45758a = new d();

            private d() {
                super(null);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    void d(int i8);

    void e();

    void f(List<String> list, int i8);

    void g();

    Observable<a> h();

    void i(String str);
}
