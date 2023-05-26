package kotlinx.coroutines.slf4j;

import java.util.Map;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ThreadContextElement;
import org.slf4j.MDC;

/* compiled from: MDCContext.kt */
/* loaded from: classes5.dex */
public final class MDCContext extends AbstractCoroutineContextElement implements ThreadContextElement<Map<String, ? extends String>> {

    /* renamed from: h  reason: collision with root package name */
    public static final Key f51993h = new Key(null);

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f51994g;

    /* compiled from: MDCContext.kt */
    /* loaded from: classes5.dex */
    public static final class Key implements CoroutineContext.Key<MDCContext> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MDCContext() {
        this(null, 1, null);
    }

    public /* synthetic */ MDCContext(Map map, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? MDC.c() : map);
    }

    private final void I0(Map<String, String> map) {
        if (map == null) {
            MDC.b();
        } else {
            MDC.d(map);
        }
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    /* renamed from: G0 */
    public void c0(CoroutineContext coroutineContext, Map<String, String> map) {
        I0(map);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    /* renamed from: K0 */
    public Map<String, String> C0(CoroutineContext coroutineContext) {
        Map<String, String> c8 = MDC.c();
        I0(this.f51994g);
        return c8;
    }

    public MDCContext(Map<String, String> map) {
        super(f51993h);
        this.f51994g = map;
    }
}
