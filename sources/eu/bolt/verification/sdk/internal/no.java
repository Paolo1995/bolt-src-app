package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.nh;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class no {

    /* renamed from: a  reason: collision with root package name */
    private static final a f44354a = new a(null);

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final nh.b.a a(String from) {
        Intrinsics.f(from, "from");
        int hashCode = from.hashCode();
        if (hashCode != -1383228885) {
            if (hashCode != -1364013995) {
                if (hashCode == 115029) {
                    from.equals("top");
                } else if (hashCode == 3143043 && from.equals("fill")) {
                    return nh.b.a.FILL;
                }
            } else if (from.equals("center")) {
                return nh.b.a.CENTER;
            }
        } else if (from.equals("bottom")) {
            return nh.b.a.BOTTOM;
        }
        return nh.b.a.TOP;
    }
}
