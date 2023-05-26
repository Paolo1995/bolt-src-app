package eu.bolt.chat.chatcore.foreground;

import eu.bolt.chat.extensions.ChatRxExtensionsKt;
import eu.bolt.chat.tools.deps.RxSchedulers;
import eu.bolt.chat.util.AppStateDispatcher;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForegroundStateDispatcher.kt */
/* loaded from: classes5.dex */
public final class ForegroundStateDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final RxSchedulers f38199a;

    /* renamed from: b  reason: collision with root package name */
    private final ForegroundStateProvider f38200b;

    /* renamed from: c  reason: collision with root package name */
    private final AppStateDispatcher f38201c;

    /* renamed from: d  reason: collision with root package name */
    private Disposable f38202d;

    public ForegroundStateDispatcher(RxSchedulers rxSchedulers, ForegroundStateProvider foregroundStateProvider, AppStateDispatcher appStateDispatcher) {
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(foregroundStateProvider, "foregroundStateProvider");
        Intrinsics.f(appStateDispatcher, "appStateDispatcher");
        this.f38199a = rxSchedulers;
        this.f38200b = foregroundStateProvider;
        this.f38201c = appStateDispatcher;
    }

    private final Disposable b(Scheduler scheduler, Scheduler scheduler2) {
        Observable<Boolean> observeOn = this.f38200b.a().subscribeOn(scheduler).distinctUntilChanged().observeOn(scheduler2);
        Intrinsics.e(observeOn, "foregroundStateProvider.…erveOn(observerScheduler)");
        return ChatRxExtensionsKt.A(observeOn, new Function1<Boolean, Unit>() { // from class: eu.bolt.chat.chatcore.foreground.ForegroundStateDispatcher$observeForegroundState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean it) {
                AppStateDispatcher appStateDispatcher;
                appStateDispatcher = ForegroundStateDispatcher.this.f38201c;
                Intrinsics.e(it, "it");
                appStateDispatcher.b(it.booleanValue());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        }, null, null, null, null, 30, null);
    }

    public final void c() {
        this.f38202d = b(this.f38199a.d(), this.f38199a.c());
    }
}
