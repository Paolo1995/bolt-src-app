package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import eu.bolt.verification.sdk.internal.lb;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Cancellable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class lb implements kb {

    /* renamed from: e  reason: collision with root package name */
    public static final a f44025e = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Activity f44026a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f44027b;

    /* renamed from: c  reason: collision with root package name */
    private final int f44028c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f44029d;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<Long, Unit> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<Boolean> f44031g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ObservableEmitter<Boolean> observableEmitter) {
            super(1);
            this.f44031g = observableEmitter;
        }

        public final void b(Long l8) {
            if (lb.this.f44026a.isFinishing()) {
                if (this.f44031g.isDisposed()) {
                    return;
                }
                this.f44031g.onComplete();
                return;
            }
            lb lbVar = lb.this;
            View c8 = lbVar.c(lbVar.f44026a);
            if (c8 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            lbVar.f(c8, this.f44031g);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
            b(l8);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function0<Observable<Boolean>> {
        c() {
            super(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(lb this$0, ObservableEmitter emitter) {
            Intrinsics.f(this$0, "this$0");
            Intrinsics.f(emitter, "emitter");
            if (!this$0.j()) {
                if (emitter.isDisposed()) {
                    return;
                }
                emitter.onError(new IllegalStateException("Activity window SoftInputMethod must be ADJUST_RESIZE"));
                return;
            }
            View c8 = this$0.c(this$0.f44026a);
            if (c8 == null) {
                this$0.i(emitter);
            } else {
                this$0.f(c8, emitter);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: c */
        public final Observable<Boolean> invoke() {
            final lb lbVar = lb.this;
            return Observable.create(new ObservableOnSubscribe() { // from class: eu.bolt.verification.sdk.internal.lu
                @Override // io.reactivex.ObservableOnSubscribe
                public final void a(ObservableEmitter observableEmitter) {
                    lb.c.d(lb.this, observableEmitter);
                }
            }).share();
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: f  reason: collision with root package name */
        private Boolean f44033f;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ View f44035h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<Boolean> f44036i;

        d(View view, ObservableEmitter<Boolean> observableEmitter) {
            this.f44035h = view;
            this.f44036i = observableEmitter;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean k8 = lb.this.k(this.f44035h);
            if (Intrinsics.a(Boolean.valueOf(k8), this.f44033f)) {
                return;
            }
            this.f44033f = Boolean.valueOf(k8);
            this.f44036i.onNext(Boolean.valueOf(k8));
        }
    }

    @Inject
    public lb(Activity activity) {
        Lazy b8;
        Intrinsics.f(activity, "activity");
        this.f44026a = activity;
        this.f44027b = new Rect();
        this.f44028c = f2.a(activity, 100.0f);
        b8 = LazyKt__LazyJVMKt.b(new c());
        this.f44029d = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View c(Activity activity) {
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View activityRoot, d keyboardLayoutListener) {
        Intrinsics.f(activityRoot, "$activityRoot");
        Intrinsics.f(keyboardLayoutListener, "$keyboardLayoutListener");
        activityRoot.getViewTreeObserver().removeOnGlobalLayoutListener(keyboardLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final View view, ObservableEmitter<Boolean> observableEmitter) {
        if (observableEmitter.isDisposed()) {
            return;
        }
        final d dVar = new d(view, observableEmitter);
        observableEmitter.b(new Cancellable() { // from class: eu.bolt.verification.sdk.internal.ku
            @Override // io.reactivex.functions.Cancellable
            public final void cancel() {
                lb.e(view, dVar);
            }
        });
        view.getViewTreeObserver().addOnGlobalLayoutListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(ObservableEmitter<Boolean> observableEmitter) {
        Observable<Long> observeOn = Observable.timer(50L, TimeUnit.MILLISECONDS, Schedulers.a()).observeOn(AndroidSchedulers.a());
        Intrinsics.e(observeOn, "timer(INIT_DELAY_MS, Tim…dSchedulers.mainThread())");
        ug.r(observeOn, new b(observableEmitter), null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        int i8 = this.f44026a.getWindow().getAttributes().softInputMode & 240;
        return i8 == 16 || i8 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(View view) {
        view.getWindowVisibleDisplayFrame(this.f44027b);
        return view.getRootView().getBottom() - this.f44027b.bottom > this.f44028c;
    }
}
