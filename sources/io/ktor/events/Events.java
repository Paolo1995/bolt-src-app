package io.ktor.events;

import io.ktor.util.collections.CopyOnWriteHashMap;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: Events.kt */
/* loaded from: classes5.dex */
public final class Events {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteHashMap<EventDefinition<?>, LockFreeLinkedListHead> f46712a = new CopyOnWriteHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Events.kt */
    /* loaded from: classes5.dex */
    public static final class HandlerRegistration extends LockFreeLinkedListNode implements DisposableHandle {

        /* renamed from: i  reason: collision with root package name */
        private final Function1<?, Unit> f46713i;

        public final Function1<?, Unit> V() {
            return this.f46713i;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            Q();
        }
    }

    public final <T> void a(EventDefinition<T> definition, T t7) {
        Unit unit;
        Intrinsics.f(definition, "definition");
        LockFreeLinkedListHead a8 = this.f46712a.a(definition);
        Throwable th = null;
        if (a8 != null) {
            Throwable th2 = null;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) a8.K(); !Intrinsics.a(lockFreeLinkedListNode, a8); lockFreeLinkedListNode = lockFreeLinkedListNode.L()) {
                if (lockFreeLinkedListNode instanceof HandlerRegistration) {
                    try {
                        ((Function1) TypeIntrinsics.e(((HandlerRegistration) lockFreeLinkedListNode).V(), 1)).invoke(t7);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            ExceptionsKt__ExceptionsKt.a(th2, th3);
                            unit = Unit.f50853a;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            th2 = th3;
                        }
                    }
                }
            }
            th = th2;
        }
        if (th == null) {
            return;
        }
        throw th;
    }
}
