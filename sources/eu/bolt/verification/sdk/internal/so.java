package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.o9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class so {

    /* renamed from: a  reason: collision with root package name */
    private static final a f45054a = new a(null);

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final o9.a a(String from) {
        Intrinsics.f(from, "from");
        int hashCode = from.hashCode();
        if (hashCode == -1364013995) {
            from.equals("center");
        } else if (hashCode != -229697526) {
            if (hashCode == 1036316515 && from.equals("fill_height")) {
                return o9.a.FILL_HEIGHT;
            }
        } else if (from.equals("fill_width")) {
            return o9.a.FILL_WIDTH;
        }
        return o9.a.CENTER;
    }
}
