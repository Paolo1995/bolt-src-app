package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.k7;
import eu.bolt.verification.sdk.internal.nh;
import eu.bolt.verification.sdk.internal.x7;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c8 {

    /* renamed from: a  reason: collision with root package name */
    private final x7 f42468a;

    /* renamed from: b  reason: collision with root package name */
    private final z7 f42469b;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final nh.b f42470a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, em> f42471b;

        /* renamed from: c  reason: collision with root package name */
        private final k7.a f42472c;

        /* renamed from: d  reason: collision with root package name */
        private final String f42473d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(nh.b layout, Map<String, ? extends em> userInputs, k7.a backNavigation, String title) {
            Intrinsics.f(layout, "layout");
            Intrinsics.f(userInputs, "userInputs");
            Intrinsics.f(backNavigation, "backNavigation");
            Intrinsics.f(title, "title");
            this.f42470a = layout;
            this.f42471b = userInputs;
            this.f42472c = backNavigation;
            this.f42473d = title;
        }

        public final k7.a a() {
            return this.f42472c;
        }

        public final nh.b b() {
            return this.f42470a;
        }

        public final String c() {
            return this.f42473d;
        }

        public final Map<String, em> d() {
            return this.f42471b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f42470a, aVar.f42470a) && Intrinsics.a(this.f42471b, aVar.f42471b) && this.f42472c == aVar.f42472c && Intrinsics.a(this.f42473d, aVar.f42473d);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f42470a.hashCode() * 31) + this.f42471b.hashCode()) * 31) + this.f42472c.hashCode()) * 31) + this.f42473d.hashCode();
        }

        public String toString() {
            nh.b bVar = this.f42470a;
            Map<String, em> map = this.f42471b;
            k7.a aVar = this.f42472c;
            String str = this.f42473d;
            return "Args(layout=" + bVar + ", userInputs=" + map + ", backNavigation=" + aVar + ", title=" + str + ")";
        }
    }

    @Inject
    public c8(x7 formLayoutElementUiModelMapper, z7 formToolbarHomeModeMapper) {
        Intrinsics.f(formLayoutElementUiModelMapper, "formLayoutElementUiModelMapper");
        Intrinsics.f(formToolbarHomeModeMapper, "formToolbarHomeModeMapper");
        this.f42468a = formLayoutElementUiModelMapper;
        this.f42469b = formToolbarHomeModeMapper;
    }

    public final b8 a(a from) {
        Intrinsics.f(from, "from");
        return new b8(this.f42468a.k(new x7.a(from.b().c(), from.d())), from.b().a(), from.c(), this.f42469b.a(from.a()), this.f42468a.k(new x7.a(from.b().b(), from.d())));
    }
}
