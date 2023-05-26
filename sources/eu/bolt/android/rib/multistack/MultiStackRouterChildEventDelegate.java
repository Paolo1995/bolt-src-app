package eu.bolt.android.rib.multistack;

import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.android.rib.AbstractStackRouter;
import eu.bolt.android.rib.rx.RxExtKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiStackRouterChildEventDelegate.kt */
/* loaded from: classes5.dex */
public final class MultiStackRouterChildEventDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final String f37204a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37205b;

    /* renamed from: c  reason: collision with root package name */
    private final MultiStackRouterEventsRepository f37206c;

    /* renamed from: d  reason: collision with root package name */
    private final MultiStackRouterFocusDelegate f37207d;

    /* renamed from: e  reason: collision with root package name */
    private final PublishRelay<AbstractStackRouter.RouterEvent> f37208e;

    /* compiled from: MultiStackRouterChildEventDelegate.kt */
    /* loaded from: classes5.dex */
    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final MultiStackRouterEventsRepository f37209a;

        /* renamed from: b  reason: collision with root package name */
        private final MultiStackRouterFocusDelegate f37210b;

        /* renamed from: c  reason: collision with root package name */
        private final PublishRelay<AbstractStackRouter.RouterEvent> f37211c;

        public Factory(MultiStackRouterEventsRepository eventsRepo, MultiStackRouterFocusDelegate focusDelegate, PublishRelay<AbstractStackRouter.RouterEvent> events) {
            Intrinsics.f(eventsRepo, "eventsRepo");
            Intrinsics.f(focusDelegate, "focusDelegate");
            Intrinsics.f(events, "events");
            this.f37209a = eventsRepo;
            this.f37210b = focusDelegate;
            this.f37211c = events;
        }

        public final MultiStackRouterChildEventDelegate a(String stackKey, String routerTag) {
            Intrinsics.f(stackKey, "stackKey");
            Intrinsics.f(routerTag, "routerTag");
            return new MultiStackRouterChildEventDelegate(stackKey, routerTag, this.f37209a, this.f37210b, this.f37211c);
        }
    }

    public MultiStackRouterChildEventDelegate(String stackKey, String childRouterTag, MultiStackRouterEventsRepository eventsRepo, MultiStackRouterFocusDelegate focusDelegate, PublishRelay<AbstractStackRouter.RouterEvent> events) {
        Intrinsics.f(stackKey, "stackKey");
        Intrinsics.f(childRouterTag, "childRouterTag");
        Intrinsics.f(eventsRepo, "eventsRepo");
        Intrinsics.f(focusDelegate, "focusDelegate");
        Intrinsics.f(events, "events");
        this.f37204a = stackKey;
        this.f37205b = childRouterTag;
        this.f37206c = eventsRepo;
        this.f37207d = focusDelegate;
        this.f37208e = events;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String str) {
        String str2 = this.f37205b + "/" + str;
        this.f37206c.i(this.f37204a, str2);
        this.f37208e.accept(new AbstractStackRouter.RouterEvent.NestedBackStackCleared(str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(MultiStackRouterChildEventDelegate multiStackRouterChildEventDelegate, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = "";
        }
        multiStackRouterChildEventDelegate.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String str, String str2) {
        String str3 = this.f37205b + "/" + str2;
        String j8 = this.f37207d.j();
        this.f37206c.k(str, this.f37204a, str3);
        this.f37208e.accept(new AbstractStackRouter.RouterEvent.NestedAddChild(str, str3));
        this.f37207d.c(this.f37204a, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(MultiStackRouterChildEventDelegate multiStackRouterChildEventDelegate, String str, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = "";
        }
        multiStackRouterChildEventDelegate.g(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String str, String str2) {
        String str3 = this.f37205b + "/" + str2;
        String j8 = this.f37207d.j();
        this.f37206c.l(str, this.f37204a, str3);
        this.f37208e.accept(new AbstractStackRouter.RouterEvent.NestedCloseChild(str, str3));
        this.f37207d.b(this.f37204a, j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(MultiStackRouterChildEventDelegate multiStackRouterChildEventDelegate, String str, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = "";
        }
        multiStackRouterChildEventDelegate.i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String str) {
        String str2 = this.f37205b + "/" + str;
        this.f37206c.j(this.f37204a, str2);
        this.f37208e.accept(new AbstractStackRouter.RouterEvent.StateRestorationCancelled(str2));
    }

    public final Disposable k(Observable<AbstractStackRouter.RouterEvent> childEvents) {
        Intrinsics.f(childEvents, "childEvents");
        return RxExtKt.i(childEvents, new Function1<AbstractStackRouter.RouterEvent, Unit>() { // from class: eu.bolt.android.rib.multistack.MultiStackRouterChildEventDelegate$handleChildRouterEvents$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(AbstractStackRouter.RouterEvent it) {
                Intrinsics.f(it, "it");
                if (it instanceof AbstractStackRouter.RouterEvent.AddChild) {
                    MultiStackRouterChildEventDelegate.h(MultiStackRouterChildEventDelegate.this, ((AbstractStackRouter.RouterEvent.AddChild) it).a().name(), null, 2, null);
                } else if (it instanceof AbstractStackRouter.RouterEvent.NestedAddChild) {
                    AbstractStackRouter.RouterEvent.NestedAddChild nestedAddChild = (AbstractStackRouter.RouterEvent.NestedAddChild) it;
                    MultiStackRouterChildEventDelegate.this.g(nestedAddChild.b(), nestedAddChild.a());
                } else if (it instanceof AbstractStackRouter.RouterEvent.CloseChild) {
                    MultiStackRouterChildEventDelegate.j(MultiStackRouterChildEventDelegate.this, ((AbstractStackRouter.RouterEvent.CloseChild) it).a().name(), null, 2, null);
                } else if (it instanceof AbstractStackRouter.RouterEvent.NestedCloseChild) {
                    AbstractStackRouter.RouterEvent.NestedCloseChild nestedCloseChild = (AbstractStackRouter.RouterEvent.NestedCloseChild) it;
                    MultiStackRouterChildEventDelegate.this.i(nestedCloseChild.b(), nestedCloseChild.a());
                } else if (it instanceof AbstractStackRouter.RouterEvent.BackStackCleared) {
                    MultiStackRouterChildEventDelegate.f(MultiStackRouterChildEventDelegate.this, null, 1, null);
                } else if (it instanceof AbstractStackRouter.RouterEvent.NestedBackStackCleared) {
                    MultiStackRouterChildEventDelegate.this.e(((AbstractStackRouter.RouterEvent.NestedBackStackCleared) it).a());
                } else if (it instanceof AbstractStackRouter.RouterEvent.StateRestorationCancelled) {
                    MultiStackRouterChildEventDelegate.this.l(((AbstractStackRouter.RouterEvent.StateRestorationCancelled) it).a());
                } else if (!(it instanceof AbstractStackRouter.RouterEvent.CloseAllChildren)) {
                    boolean z7 = it instanceof AbstractStackRouter.RouterEvent.StateRestoredOnReturnFromBackStack;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AbstractStackRouter.RouterEvent routerEvent) {
                b(routerEvent);
                return Unit.f50853a;
            }
        }, null, null, null, null, 30, null);
    }
}
