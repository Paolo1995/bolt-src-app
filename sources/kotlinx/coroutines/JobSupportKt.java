package kotlinx.coroutines;

import kotlinx.coroutines.internal.Symbol;

/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public final class JobSupportKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Symbol f51315a = new Symbol("COMPLETING_ALREADY");

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f51316b = new Symbol("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c  reason: collision with root package name */
    private static final Symbol f51317c = new Symbol("COMPLETING_RETRY");

    /* renamed from: d  reason: collision with root package name */
    private static final Symbol f51318d = new Symbol("TOO_LATE_TO_CANCEL");

    /* renamed from: e  reason: collision with root package name */
    private static final Symbol f51319e = new Symbol("SEALED");

    /* renamed from: f  reason: collision with root package name */
    private static final Empty f51320f = new Empty(false);

    /* renamed from: g  reason: collision with root package name */
    private static final Empty f51321g = new Empty(true);

    public static final Object g(Object obj) {
        if (obj instanceof Incomplete) {
            return new IncompleteStateBox((Incomplete) obj);
        }
        return obj;
    }

    public static final Object h(Object obj) {
        IncompleteStateBox incompleteStateBox;
        Incomplete incomplete;
        if (obj instanceof IncompleteStateBox) {
            incompleteStateBox = (IncompleteStateBox) obj;
        } else {
            incompleteStateBox = null;
        }
        if (incompleteStateBox != null && (incomplete = incompleteStateBox.f51288a) != null) {
            return incomplete;
        }
        return obj;
    }
}
