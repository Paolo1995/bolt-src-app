package eu.bolt.android.rib.multistack;

import eu.bolt.android.rib.multistack.StackUpdateEvent;
import eu.bolt.logger.StaticLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: MultiStackRouterEventsRepository.kt */
/* loaded from: classes5.dex */
public final class MultiStackRouterEventsRepository {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<StackUpdateEvent> f37213a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f37214b;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(StackUpdateEvent stackUpdateEvent, String str, String str2) {
        boolean L;
        if (!(stackUpdateEvent instanceof StackUpdateEvent.NestedChildAdded) || !Intrinsics.a(((StackUpdateEvent.NestedChildAdded) stackUpdateEvent).d(), str)) {
            return false;
        }
        L = StringsKt__StringsJVMKt.L(stackUpdateEvent.c(), str2, false, 2, null);
        if (!L) {
            return false;
        }
        return true;
    }

    private final <E> boolean p(List<E> list, Function1<? super E, Boolean> function1) {
        ListIterator<E> listIterator = list.listIterator(list.size());
        boolean z7 = false;
        boolean z8 = false;
        while (listIterator.hasPrevious()) {
            if (function1.invoke(listIterator.previous()).booleanValue()) {
                if (z8) {
                    listIterator.remove();
                    z7 = true;
                } else {
                    z8 = true;
                }
            }
        }
        return z7;
    }

    private final <E> boolean s(List<E> list, E e8) {
        ListIterator<E> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.a(listIterator.previous(), e8)) {
                listIterator.remove();
                return true;
            }
        }
        return false;
    }

    public final void b() {
        this.f37213a.clear();
    }

    public final List<StackUpdateEvent> c() {
        return this.f37213a;
    }

    public final StackUpdateEvent d() {
        Object h02;
        h02 = CollectionsKt___CollectionsKt.h0(this.f37213a);
        return (StackUpdateEvent) h02;
    }

    public final boolean f() {
        return !this.f37213a.isEmpty();
    }

    public final void g(String stackKey, String routerTag) {
        Intrinsics.f(stackKey, "stackKey");
        Intrinsics.f(routerTag, "routerTag");
        Iterator<StackUpdateEvent> it = this.f37213a.iterator();
        int i8 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.a(it.next().b(), routerTag)) {
                    break;
                }
                i8++;
            } else {
                i8 = -1;
                break;
            }
        }
        if (i8 >= 0) {
            StackUpdateEvent remove = this.f37213a.remove(i8);
            Intrinsics.e(remove, "stackEvents.removeAt(eventIndex)");
            this.f37213a.add(remove);
            return;
        }
        StaticLogger staticLogger = StaticLogger.f41686a;
        ArrayList<StackUpdateEvent> arrayList = this.f37213a;
        staticLogger.i(routerTag + " not found in " + arrayList);
        this.f37213a.add(new StackUpdateEvent.PushedToStack(stackKey, routerTag));
    }

    public final List<String> h(String stackKey) {
        Intrinsics.f(stackKey, "stackKey");
        ArrayList arrayList = new ArrayList();
        int size = this.f37213a.size();
        while (true) {
            size--;
            if (-1 < size) {
                StackUpdateEvent stackUpdateEvent = this.f37213a.get(size);
                Intrinsics.e(stackUpdateEvent, "stackEvents[i]");
                StackUpdateEvent stackUpdateEvent2 = stackUpdateEvent;
                if (Intrinsics.a(stackUpdateEvent2.a(), stackKey)) {
                    if (stackUpdateEvent2 instanceof StackUpdateEvent.PushedToStack) {
                        arrayList.add(stackUpdateEvent2.b());
                    }
                    this.f37213a.remove(size);
                }
            } else {
                return arrayList;
            }
        }
    }

    public final void i(final String stackKey, final String tagPath) {
        Intrinsics.f(stackKey, "stackKey");
        Intrinsics.f(tagPath, "tagPath");
        p(this.f37213a, new Function1<StackUpdateEvent, Boolean>() { // from class: eu.bolt.android.rib.multistack.MultiStackRouterEventsRepository$onChildBackStackCleared$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(StackUpdateEvent it) {
                boolean e8;
                Intrinsics.f(it, "it");
                e8 = MultiStackRouterEventsRepository.this.e(it, stackKey, tagPath);
                return Boolean.valueOf(e8);
            }
        });
    }

    public final void j(final String stackKey, final String tagPath) {
        Intrinsics.f(stackKey, "stackKey");
        Intrinsics.f(tagPath, "tagPath");
        if (this.f37214b) {
            this.f37213a.add(new StackUpdateEvent.CancelStateRestoration(stackKey, tagPath));
        } else {
            CollectionsKt__MutableCollectionsKt.I(this.f37213a, new Function1<StackUpdateEvent, Boolean>() { // from class: eu.bolt.android.rib.multistack.MultiStackRouterEventsRepository$onChildRestoreStateCancelled$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Boolean invoke(StackUpdateEvent it) {
                    boolean e8;
                    Intrinsics.f(it, "it");
                    e8 = MultiStackRouterEventsRepository.this.e(it, stackKey, tagPath);
                    return Boolean.valueOf(e8);
                }
            });
        }
    }

    public final void k(String stateName, String stackKey, String tagPath) {
        Intrinsics.f(stateName, "stateName");
        Intrinsics.f(stackKey, "stackKey");
        Intrinsics.f(tagPath, "tagPath");
        this.f37213a.add(new StackUpdateEvent.NestedChildAdded(stateName, stackKey, tagPath));
    }

    public final void l(String stateName, String stackKey, String tagPath) {
        Intrinsics.f(stateName, "stateName");
        Intrinsics.f(stackKey, "stackKey");
        Intrinsics.f(tagPath, "tagPath");
        s(this.f37213a, new StackUpdateEvent.NestedChildAdded(stateName, stackKey, tagPath));
    }

    public final void m(final String stackKey, final String routerTag) {
        Intrinsics.f(stackKey, "stackKey");
        Intrinsics.f(routerTag, "routerTag");
        CollectionsKt__MutableCollectionsKt.I(this.f37213a, new Function1<StackUpdateEvent, Boolean>() { // from class: eu.bolt.android.rib.multistack.MultiStackRouterEventsRepository$onPoppedFromStack$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(StackUpdateEvent it) {
                boolean e8;
                Intrinsics.f(it, "it");
                e8 = MultiStackRouterEventsRepository.this.e(it, stackKey, routerTag);
                return Boolean.valueOf(e8);
            }
        });
        s(this.f37213a, new StackUpdateEvent.PushedToStack(stackKey, routerTag));
    }

    public final void n(String stackKey, String routerTag) {
        Intrinsics.f(stackKey, "stackKey");
        Intrinsics.f(routerTag, "routerTag");
        this.f37213a.add(new StackUpdateEvent.PushedToStack(stackKey, routerTag));
    }

    public final void o(final Set<String> tags) {
        Intrinsics.f(tags, "tags");
        CollectionsKt__MutableCollectionsKt.I(this.f37213a, new Function1<StackUpdateEvent, Boolean>() { // from class: eu.bolt.android.rib.multistack.MultiStackRouterEventsRepository$onRoutersRemoved$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(StackUpdateEvent it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(tags.contains(it.b()));
            }
        });
    }

    public final void q(StackUpdateEvent event) {
        Object h02;
        Intrinsics.f(event, "event");
        if (!this.f37213a.isEmpty()) {
            h02 = CollectionsKt___CollectionsKt.h0(this.f37213a);
            if (h02 == event) {
                CollectionsKt__MutableCollectionsKt.J(this.f37213a);
            }
        }
    }

    public final void r() {
        CollectionsKt__MutableCollectionsKt.J(this.f37213a);
    }

    public final void t(List<? extends StackUpdateEvent> events) {
        List J0;
        Intrinsics.f(events, "events");
        J0 = CollectionsKt___CollectionsKt.J0(events);
        for (final StackUpdateEvent stackUpdateEvent : this.f37213a) {
            if (stackUpdateEvent instanceof StackUpdateEvent.CancelStateRestoration) {
                CollectionsKt__MutableCollectionsKt.I(J0, new Function1<StackUpdateEvent, Boolean>() { // from class: eu.bolt.android.rib.multistack.MultiStackRouterEventsRepository$restoreEvents$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: b */
                    public final Boolean invoke(StackUpdateEvent it) {
                        boolean e8;
                        Intrinsics.f(it, "it");
                        e8 = MultiStackRouterEventsRepository.this.e(it, ((StackUpdateEvent.CancelStateRestoration) stackUpdateEvent).d(), stackUpdateEvent.c());
                        return Boolean.valueOf(e8);
                    }
                });
            }
        }
        this.f37213a.clear();
        this.f37213a.addAll(J0);
    }

    public String toString() {
        String obj = this.f37213a.toString();
        Intrinsics.e(obj, "stackEvents.toString()");
        return obj;
    }

    public final void u(boolean z7) {
        this.f37214b = z7;
    }
}
