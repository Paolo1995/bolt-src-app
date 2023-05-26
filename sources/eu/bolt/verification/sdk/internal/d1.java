package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.b1;
import eu.bolt.verification.sdk.internal.d2;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d1 {

    /* renamed from: a  reason: collision with root package name */
    private final d2 f42573a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final b1 f42574a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, em> f42575b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(b1 button, Map<String, ? extends em> userInputs) {
            Intrinsics.f(button, "button");
            Intrinsics.f(userInputs, "userInputs");
            this.f42574a = button;
            this.f42575b = userInputs;
        }

        public final b1 a() {
            return this.f42574a;
        }

        public final Map<String, em> b() {
            return this.f42575b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f42574a, aVar.f42574a) && Intrinsics.a(this.f42575b, aVar.f42575b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f42574a.hashCode() * 31) + this.f42575b.hashCode();
        }

        public String toString() {
            b1 b1Var = this.f42574a;
            Map<String, em> map = this.f42575b;
            return "Args(button=" + b1Var + ", userInputs=" + map + ")";
        }
    }

    @Inject
    public d1(d2 conditionIsFeasibleChecker) {
        Intrinsics.f(conditionIsFeasibleChecker, "conditionIsFeasibleChecker");
        this.f42573a = conditionIsFeasibleChecker;
    }

    public final boolean a(a args) {
        boolean z7;
        Intrinsics.f(args, "args");
        List<b1.a> b8 = args.a().b();
        if (!(b8 instanceof Collection) || !b8.isEmpty()) {
            for (b1.a aVar : b8) {
                c2 b9 = aVar.b();
                if (b9 != null) {
                    z7 = this.f42573a.b(new d2.a(b9, args.b()));
                    continue;
                } else {
                    z7 = true;
                    continue;
                }
                if (z7) {
                    return true;
                }
            }
        }
        return false;
    }
}
