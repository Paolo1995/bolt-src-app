package ee.mtakso.driver.ui.views.quickaccess;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.GestureDetectorCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.param.field.IntSettingsField;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.ui.views.quickaccess.QuickAccessDetailsViewDelegate;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.gesture_detector.IntermediateSimpleOnGestureListener;
import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.driver.chat.service.ConversationPreviewData;
import eu.bolt.driver.core.ui.translation.TranslatedLayoutInflater;
import eu.bolt.driver.core.ui.translation.TranslatedResources;
import eu.bolt.driver.core.util.PendingIntentFactory;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: QuickAccessController.kt */
/* loaded from: classes5.dex */
public final class QuickAccessController extends IntermediateSimpleOnGestureListener implements View.OnAttachStateChangeListener {
    public static final Companion A = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final Context f34400f;

    /* renamed from: g  reason: collision with root package name */
    private final WindowManager f34401g;

    /* renamed from: h  reason: collision with root package name */
    private final Features f34402h;

    /* renamed from: i  reason: collision with root package name */
    private final QuickAccessOrderMapper f34403i;

    /* renamed from: j  reason: collision with root package name */
    private final QuickAccessPrefsManager f34404j;

    /* renamed from: k  reason: collision with root package name */
    private OnChangeStateButtonClickListener f34405k;

    /* renamed from: l  reason: collision with root package name */
    private OnChatButtonClickListener f34406l;

    /* renamed from: m  reason: collision with root package name */
    private QuickAccessMode f34407m;

    /* renamed from: n  reason: collision with root package name */
    private final GestureDetectorCompat f34408n;

    /* renamed from: o  reason: collision with root package name */
    private final TranslatedResources f34409o;

    /* renamed from: p  reason: collision with root package name */
    private final TranslatedLayoutInflater f34410p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f34411q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f34412r;

    /* renamed from: s  reason: collision with root package name */
    private QuickAccessChatViewDelegate f34413s;

    /* renamed from: t  reason: collision with root package name */
    private QuickAccessDetailsViewDelegate f34414t;

    /* renamed from: u  reason: collision with root package name */
    private QuickAccessMainViewDelegate f34415u;

    /* renamed from: v  reason: collision with root package name */
    private Disposable f34416v;

    /* renamed from: w  reason: collision with root package name */
    private int f34417w;

    /* renamed from: x  reason: collision with root package name */
    private int f34418x;

    /* renamed from: y  reason: collision with root package name */
    private OrderHandle f34419y;

    /* renamed from: z  reason: collision with root package name */
    private ChatEntity f34420z;

    /* compiled from: QuickAccessController.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: QuickAccessController.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34421a;

        static {
            int[] iArr = new int[QuickAccessMode.values().length];
            try {
                iArr[QuickAccessMode.ACTIONABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QuickAccessMode.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f34421a = iArr;
        }
    }

    public QuickAccessController(Context context, WindowManager windowManager, Features features, QuickAccessOrderMapper quickAccessOrderMapper, QuickAccessPrefsManager quickAccessPrefsManager) {
        Intrinsics.f(context, "context");
        Intrinsics.f(windowManager, "windowManager");
        Intrinsics.f(features, "features");
        Intrinsics.f(quickAccessOrderMapper, "quickAccessOrderMapper");
        Intrinsics.f(quickAccessPrefsManager, "quickAccessPrefsManager");
        this.f34400f = context;
        this.f34401g = windowManager;
        this.f34402h = features;
        this.f34403i = quickAccessOrderMapper;
        this.f34404j = quickAccessPrefsManager;
        this.f34407m = QuickAccessMode.COLLAPSED;
        this.f34408n = new GestureDetectorCompat(context, this);
        Resources resources = context.getResources();
        Intrinsics.e(resources, "context.resources");
        TranslatedResources translatedResources = new TranslatedResources(resources);
        this.f34409o = translatedResources;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.e(from, "from(context)");
        this.f34410p = new TranslatedLayoutInflater(from, context, translatedResources);
        this.f34417w = 5;
        this.f34418x = 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(int i8, int i9) {
        View view;
        QuickAccessMainViewDelegate quickAccessMainViewDelegate = this.f34415u;
        if (quickAccessMainViewDelegate != null) {
            view = quickAccessMainViewDelegate.h();
        } else {
            view = null;
        }
        if (!this.f34412r) {
            return;
        }
        if (quickAccessMainViewDelegate != null) {
            quickAccessMainViewDelegate.l(i8, i9);
        }
        if (view != null) {
            F(i8, i9, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(int i8, int i9, View view) {
        Integer num;
        Integer num2;
        double d8;
        double d9;
        boolean z7;
        View s7;
        View s8;
        if (!this.f34412r) {
            return;
        }
        QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate = this.f34414t;
        Point point = new Point();
        this.f34401g.getDefaultDisplay().getSize(point);
        Integer num3 = null;
        if (quickAccessDetailsViewDelegate != null && (s8 = quickAccessDetailsViewDelegate.s()) != null) {
            num = Integer.valueOf(s8.getMeasuredWidth());
        } else {
            num = null;
        }
        if (quickAccessDetailsViewDelegate != null && (s7 = quickAccessDetailsViewDelegate.s()) != null) {
            num2 = Integer.valueOf(s7.getMeasuredHeight());
        } else {
            num2 = null;
        }
        if (quickAccessDetailsViewDelegate != null && num != null && num2 != null) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i10 = (measuredWidth / 2) + i8;
            int i11 = (measuredHeight / 2) + i9;
            WindowManager.LayoutParams q8 = quickAccessDetailsViewDelegate.q();
            int i12 = 0;
            if (q8 != null) {
                Integer valueOf = Integer.valueOf(q8.x);
                if (valueOf.intValue() > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    num3 = valueOf;
                }
                if (num3 != null) {
                    i12 = num3.intValue();
                }
            }
            int intValue = num.intValue() + i12;
            int i13 = point.x;
            if (intValue > i13) {
                i12 = i13 - num.intValue();
            }
            if (i10 >= i12 + (num.intValue() / 2)) {
                quickAccessDetailsViewDelegate.C(QuickAccessDetailsViewDelegate.HorizontalExpansionPoint.RIGHT);
                double d10 = measuredWidth;
                d8 = i8 - (num.intValue() - (d10 - (d10 / 1.5d)));
            } else {
                quickAccessDetailsViewDelegate.C(QuickAccessDetailsViewDelegate.HorizontalExpansionPoint.LEFT);
                d8 = i8 + (measuredWidth / 1.5d);
            }
            if (i11 > point.y / 2) {
                quickAccessDetailsViewDelegate.I(QuickAccessDetailsViewDelegate.VerticalExpansionPoint.BOTTOM);
                double d11 = measuredHeight;
                d9 = i9 - (num2.intValue() - (d11 - (d11 / 1.5d)));
            } else {
                quickAccessDetailsViewDelegate.I(QuickAccessDetailsViewDelegate.VerticalExpansionPoint.TOP);
                d9 = i9 + (measuredWidth / 1.5d);
            }
            int i14 = (int) d8;
            int i15 = (int) d9;
            quickAccessDetailsViewDelegate.Q(i14, i15);
            QuickAccessChatViewDelegate quickAccessChatViewDelegate = this.f34413s;
            if (quickAccessChatViewDelegate != null) {
                quickAccessChatViewDelegate.w(i14, i15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        try {
            PendingIntentFactory.b(new PendingIntentFactory(this.f34400f), AppRoutingManager.f25869b.a(this.f34400f), 0, 0, null, 14, null).send();
        } catch (PendingIntent.CanceledException e8) {
            Kalev.e(e8, "Could not return to app from quick access");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(WindowManager.LayoutParams layoutParams) {
        this.f34417w = layoutParams.x;
        this.f34418x = layoutParams.y;
    }

    private final View.OnTouchListener p(WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            layoutParams = new WindowManager.LayoutParams();
        }
        return new QuickAccessController$createOnTouchListener$1(this, layoutParams);
    }

    private final void s() {
        QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate;
        if (!v()) {
            return;
        }
        this.f34411q = true;
        QuickAccessMainViewDelegate quickAccessMainViewDelegate = this.f34415u;
        if (quickAccessMainViewDelegate == null) {
            quickAccessMainViewDelegate = new QuickAccessMainViewDelegate(this.f34400f, this.f34401g);
        }
        QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate2 = this.f34414t;
        if (quickAccessDetailsViewDelegate2 == null) {
            quickAccessDetailsViewDelegate2 = new QuickAccessDetailsViewDelegate(this.f34400f, this.f34401g, this.f34410p);
        }
        QuickAccessChatViewDelegate quickAccessChatViewDelegate = this.f34413s;
        if (quickAccessChatViewDelegate == null) {
            quickAccessChatViewDelegate = new QuickAccessChatViewDelegate(this.f34401g, this.f34410p);
        }
        quickAccessChatViewDelegate.c(this.f34417w, this.f34418x);
        quickAccessDetailsViewDelegate2.f(this.f34417w, this.f34418x);
        final View c8 = quickAccessMainViewDelegate.c(this.f34417w, this.f34418x);
        ViewExtKt.c(c8, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessController$draw$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                int i8;
                int i9;
                QuickAccessController quickAccessController = QuickAccessController.this;
                i8 = quickAccessController.f34417w;
                i9 = QuickAccessController.this.f34418x;
                quickAccessController.F(i8, i9, c8);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        QuickAccessMode quickAccessMode = QuickAccessMode.ACTIONABLE;
        quickAccessChatViewDelegate.q(quickAccessMode);
        quickAccessDetailsViewDelegate2.D(this.f34407m);
        quickAccessMainViewDelegate.i(this.f34407m);
        if (this.f34407m != quickAccessMode && (quickAccessDetailsViewDelegate = this.f34414t) != null) {
            quickAccessDetailsViewDelegate.t();
        }
        quickAccessDetailsViewDelegate2.F(new OnOpenAppClickListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessController$draw$2
            @Override // ee.mtakso.driver.ui.views.quickaccess.OnOpenAppClickListener
            public void a() {
                QuickAccessController.this.n();
            }
        });
        quickAccessDetailsViewDelegate2.E(new OnChangeStateButtonClickListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessController$draw$3
            @Override // ee.mtakso.driver.ui.views.quickaccess.OnChangeStateButtonClickListener
            public void a() {
                OnChangeStateButtonClickListener u7 = QuickAccessController.this.u();
                if (u7 != null) {
                    u7.a();
                }
            }

            @Override // ee.mtakso.driver.ui.views.quickaccess.OnChangeStateButtonClickListener
            public void b() {
                OnChangeStateButtonClickListener u7 = QuickAccessController.this.u();
                if (u7 != null) {
                    u7.b();
                }
            }
        });
        quickAccessChatViewDelegate.r(new OnChatButtonClickListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessController$draw$4
            @Override // ee.mtakso.driver.ui.views.quickaccess.OnChatButtonClickListener
            public void a() {
                QuickAccessChatViewDelegate quickAccessChatViewDelegate2;
                quickAccessChatViewDelegate2 = QuickAccessController.this.f34413s;
                if (quickAccessChatViewDelegate2 != null) {
                    quickAccessChatViewDelegate2.l();
                }
            }
        });
        quickAccessChatViewDelegate.s(new OnOpenAppClickListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessController$draw$5
            @Override // ee.mtakso.driver.ui.views.quickaccess.OnOpenAppClickListener
            public void a() {
                ChatEntity chatEntity;
                chatEntity = QuickAccessController.this.f34420z;
                if (chatEntity != null) {
                    QuickAccessController.this.y(chatEntity);
                }
            }
        });
        quickAccessMainViewDelegate.b(p(quickAccessMainViewDelegate.g()));
        quickAccessMainViewDelegate.a(this);
        this.f34415u = quickAccessMainViewDelegate;
        this.f34414t = quickAccessDetailsViewDelegate2;
        this.f34413s = quickAccessChatViewDelegate;
    }

    private final boolean v() {
        boolean canDrawOverlays;
        if (Build.VERSION.SDK_INT >= 23) {
            canDrawOverlays = Settings.canDrawOverlays(this.f34400f);
            if (!canDrawOverlays) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(ChatEntity chatEntity) {
        try {
            PendingIntentFactory.b(new PendingIntentFactory(this.f34400f), AppRoutingManager.f25869b.b(chatEntity), 0, 0, null, 14, null).send();
        } catch (PendingIntent.CanceledException e8) {
            Kalev.e(e8, "Could not return to app from quick access");
        }
    }

    public final void A(ActiveOrderDetails details) {
        boolean z7;
        boolean z8;
        int d8;
        PaidWaitingButtonState c8;
        Intrinsics.f(details, "details");
        int a8 = this.f34404j.b().a();
        QuickAccessOrderMapper quickAccessOrderMapper = this.f34403i;
        boolean b8 = this.f34402h.b(Feature.Type.PAID_STOPS);
        if (a8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        QuickAccessDetailsState f8 = quickAccessOrderMapper.f(details, b8, z7);
        if (f8 != null && (c8 = f8.c()) != null && c8.b()) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8 && !Intrinsics.a(this.f34419y, details.a())) {
            this.f34419y = details.a();
            IntSettingsField b9 = this.f34404j.b();
            d8 = RangesKt___RangesKt.d(a8 - 1, 0);
            b9.b(d8);
        }
        QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate = this.f34414t;
        if (quickAccessDetailsViewDelegate != null) {
            quickAccessDetailsViewDelegate.l(f8);
        }
    }

    public final void B(OnChatButtonClickListener onChatButtonClickListener) {
        this.f34406l = onChatButtonClickListener;
    }

    public final void C(OnChangeStateButtonClickListener onChangeStateButtonClickListener) {
        this.f34405k = onChangeStateButtonClickListener;
    }

    public final void D(QuickAccessMode mode) {
        QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate;
        Intrinsics.f(mode, "mode");
        if (this.f34407m == mode) {
            return;
        }
        this.f34407m = mode;
        QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate2 = this.f34414t;
        if (quickAccessDetailsViewDelegate2 != null) {
            quickAccessDetailsViewDelegate2.D(mode);
        }
        QuickAccessMainViewDelegate quickAccessMainViewDelegate = this.f34415u;
        if (quickAccessMainViewDelegate != null) {
            quickAccessMainViewDelegate.i(mode);
        }
        int i8 = WhenMappings.f34421a[mode.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate3 = this.f34414t;
                if (quickAccessDetailsViewDelegate3 != null) {
                    quickAccessDetailsViewDelegate3.t();
                    return;
                }
                return;
            } else if (DisposableExtKt.b(this.f34416v) && (quickAccessDetailsViewDelegate = this.f34414t) != null) {
                quickAccessDetailsViewDelegate.t();
                return;
            } else {
                return;
            }
        }
        QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate4 = this.f34414t;
        if (quickAccessDetailsViewDelegate4 != null) {
            quickAccessDetailsViewDelegate4.J();
        }
        Disposable disposable = this.f34416v;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // ee.mtakso.driver.utils.gesture_detector.IntermediateSimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e8) {
        Intrinsics.f(e8, "e");
        if (this.f34407m == QuickAccessMode.COLLAPSED) {
            n();
            return false;
        }
        final QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate = this.f34414t;
        if (quickAccessDetailsViewDelegate != null) {
            boolean y7 = quickAccessDetailsViewDelegate.y();
            Disposable disposable = this.f34416v;
            if (disposable != null) {
                disposable.dispose();
            }
            if (y7) {
                quickAccessDetailsViewDelegate.t();
            } else {
                quickAccessDetailsViewDelegate.J();
            }
            if (!y7 && this.f34407m == QuickAccessMode.INFO) {
                Single<Long> O = Single.O(3L, TimeUnit.SECONDS);
                Intrinsics.e(O, "timer(3, TimeUnit.SECONDS)");
                Single c8 = SingleExtKt.c(O);
                final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessController$onSingleTapUp$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final void b(Long l8) {
                        QuickAccessDetailsViewDelegate.this.t();
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                        b(l8);
                        return Unit.f50853a;
                    }
                };
                Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.views.quickaccess.c
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        QuickAccessController.w(Function1.this, obj);
                    }
                };
                final QuickAccessController$onSingleTapUp$1$2 quickAccessController$onSingleTapUp$1$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessController$onSingleTapUp$1$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.f50853a;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Intrinsics.e(it, "it");
                        Kalev.e(it, "Error while hiding QuickAccessDetails by timer");
                    }
                };
                this.f34416v = c8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.views.quickaccess.d
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        QuickAccessController.x(Function1.this, obj);
                    }
                });
            }
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Intrinsics.f(view, "view");
        this.f34411q = false;
        this.f34412r = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics.f(view, "view");
        this.f34412r = false;
    }

    public final void q() {
        Kalev.b("QuickAccess destroy()");
        r();
    }

    public final void r() {
        Kalev.b("QuickAccess dismiss()");
        if (this.f34412r || this.f34411q) {
            QuickAccessMainViewDelegate quickAccessMainViewDelegate = this.f34415u;
            if (quickAccessMainViewDelegate != null) {
                quickAccessMainViewDelegate.f();
            }
            QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate = this.f34414t;
            if (quickAccessDetailsViewDelegate != null) {
                quickAccessDetailsViewDelegate.k();
            }
            QuickAccessChatViewDelegate quickAccessChatViewDelegate = this.f34413s;
            if (quickAccessChatViewDelegate != null) {
                quickAccessChatViewDelegate.h();
            }
        }
    }

    public final void t() {
        if (!this.f34411q && !this.f34412r) {
            s();
        }
    }

    public final OnChangeStateButtonClickListener u() {
        return this.f34405k;
    }

    public final void z(ConversationPreviewData chatState) {
        Intrinsics.f(chatState, "chatState");
        QuickAccessChatViewDelegate quickAccessChatViewDelegate = this.f34413s;
        if (quickAccessChatViewDelegate != null) {
            quickAccessChatViewDelegate.d();
        }
        this.f34420z = chatState.a();
        QuickAccessChatViewDelegate quickAccessChatViewDelegate2 = this.f34413s;
        if (quickAccessChatViewDelegate2 != null) {
            quickAccessChatViewDelegate2.u();
        }
        QuickAccessChatViewDelegate quickAccessChatViewDelegate3 = this.f34413s;
        if (quickAccessChatViewDelegate3 != null) {
            CharSequence text = this.f34409o.getText(R.string.new_message_quick_access);
            ChatMessageEntity d8 = chatState.d();
            quickAccessChatViewDelegate3.i(new QuickAccessDetailsState(text, (d8 == null || (r13 = d8.k()) == null) ? "" : "", null, new ActionButtonState(this.f34409o.getText(R.string.new_message_quick_access_reply), ContextCompat.getColor(this.f34400f, R.color.green700), ContextCompat.getColor(this.f34400f, R.color.green900)), null, null, null, 116, null));
        }
    }
}
