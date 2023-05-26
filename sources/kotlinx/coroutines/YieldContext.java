package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Unconfined.kt */
/* loaded from: classes5.dex */
public final class YieldContext extends AbstractCoroutineContextElement {

    /* renamed from: h  reason: collision with root package name */
    public static final Key f51348h = new Key(null);

    /* renamed from: g  reason: collision with root package name */
    public boolean f51349g;

    /* compiled from: Unconfined.kt */
    /* loaded from: classes5.dex */
    public static final class Key implements CoroutineContext.Key<YieldContext> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public YieldContext() {
        super(f51348h);
    }
}
