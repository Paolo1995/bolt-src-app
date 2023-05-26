package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.client.design.button.DesignButton;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.sdk.internal.ha;
import eu.bolt.verification.sdk.internal.q0;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class r0 implements q0, c4 {

    /* renamed from: a  reason: collision with root package name */
    private final x0 f44700a;

    /* renamed from: b  reason: collision with root package name */
    private final jc f44701b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ d4 f44702c;

    /* renamed from: d  reason: collision with root package name */
    private final PublishRelay<q0.a> f44703d;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44704a;

        static {
            int[] iArr = new int[ha.a.b.values().length];
            try {
                iArr[ha.a.b.PRIMARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ha.a.b.SECONDARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ha.a.b.DANGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ha.a.b.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ha.a.b.AUTO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f44704a = iArr;
        }
    }

    @Inject
    public r0(x0 view, jc navigationBarController) {
        Intrinsics.f(view, "view");
        Intrinsics.f(navigationBarController, "navigationBarController");
        this.f44700a = view;
        this.f44701b = navigationBarController;
        this.f44702c = new d4(view, navigationBarController, n9.HIDEABLE_ONLY_VIA_API, null, null, null, false, 120, null);
        PublishRelay<q0.a> e8 = PublishRelay.e();
        Intrinsics.e(e8, "create<UiEvent>()");
        this.f44703d = e8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r3 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final eu.bolt.client.design.button.DesignButton.b i(eu.bolt.verification.sdk.internal.ha.a.b r2, boolean r3) {
        /*
            r1 = this;
            int[] r0 = eu.bolt.verification.sdk.internal.r0.a.f44704a
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            if (r2 == r0) goto L29
            r0 = 2
            if (r2 == r0) goto L26
            r0 = 3
            if (r2 == r0) goto L23
            r0 = 4
            if (r2 == r0) goto L20
            r0 = 5
            if (r2 != r0) goto L1a
            if (r3 == 0) goto L26
            goto L29
        L1a:
            kotlin.NoWhenBranchMatchedException r2 = new kotlin.NoWhenBranchMatchedException
            r2.<init>()
            throw r2
        L20:
            eu.bolt.client.design.button.DesignButton$b r2 = eu.bolt.client.design.button.DesignButton.b.Text
            goto L2b
        L23:
            eu.bolt.client.design.button.DesignButton$b r2 = eu.bolt.client.design.button.DesignButton.b.Danger
            goto L2b
        L26:
            eu.bolt.client.design.button.DesignButton$b r2 = eu.bolt.client.design.button.DesignButton.b.Secondary
            goto L2b
        L29:
            eu.bolt.client.design.button.DesignButton$b r2 = eu.bolt.client.design.button.DesignButton.b.Primary
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.r0.i(eu.bolt.verification.sdk.internal.ha$a$b, boolean):eu.bolt.client.design.button.DesignButton$b");
    }

    private final void j(final ha.a aVar, boolean z7) {
        Context context = this.f44700a.getContext();
        Intrinsics.e(context, "view.context");
        DesignButton designButton = new DesignButton(context, null, 0, 6, null);
        designButton.setStyle(i(aVar.c(), z7));
        il.d(designButton, aVar.b());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        Context context2 = this.f44700a.getContext();
        Intrinsics.e(context2, "view.context");
        int i8 = R$dimen.f41699b;
        int n8 = f2.n(context2, i8);
        Context context3 = this.f44700a.getContext();
        Intrinsics.e(context3, "view.context");
        int n9 = f2.n(context3, R$dimen.f41700i);
        Context context4 = this.f44700a.getContext();
        Intrinsics.e(context4, "view.context");
        layoutParams.setMargins(n8, n9, f2.n(context4, i8), 0);
        designButton.setLayoutParams(layoutParams);
        designButton.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.verification.sdk.internal.pv
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.k(r0.this, aVar, view);
            }
        });
        this.f44700a.getBinding().f42643b.addView(designButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(r0 this$0, ha.a model, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(model, "$model");
        this$0.f44703d.accept(new q0.a.C0083a(model.a()));
    }

    @Override // eu.bolt.verification.sdk.internal.q0
    public void a(ha uiModel) {
        Intrinsics.f(uiModel, "uiModel");
        DesignTextView setUiModel$lambda$0 = this.f44700a.getBinding().f42645d;
        Intrinsics.e(setUiModel$lambda$0, "setUiModel$lambda$0");
        il.f(setUiModel$lambda$0, uiModel.e());
        setUiModel$lambda$0.setTextAlignment(uiModel.f().c());
        DesignTextView setUiModel$lambda$1 = this.f44700a.getBinding().f42644c;
        Intrinsics.e(setUiModel$lambda$1, "setUiModel$lambda$1");
        il.d(setUiModel$lambda$1, uiModel.b());
        setUiModel$lambda$1.setTextAlignment(uiModel.c().c());
        l(uiModel.d());
        int i8 = 0;
        for (Object obj : uiModel.a()) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            ha.a aVar = (ha.a) obj;
            boolean z7 = true;
            if (uiModel.a().size() <= 1 || i8 != 0) {
                z7 = false;
            }
            j(aVar, z7);
            i8 = i9;
        }
    }

    @Override // eu.bolt.verification.sdk.internal.j0
    public Object b(Continuation<? super Unit> continuation) {
        return this.f44702c.b(continuation);
    }

    @Override // eu.bolt.verification.sdk.internal.c4
    public void c(boolean z7) {
        this.f44702c.c(z7);
    }

    @Override // eu.bolt.verification.sdk.internal.c4
    public void d(f7 state) {
        Intrinsics.f(state, "state");
        this.f44702c.d(state);
    }

    @Override // eu.bolt.verification.sdk.internal.c4
    public void e(wd action) {
        Intrinsics.f(action, "action");
        this.f44702c.e(action);
    }

    @Override // eu.bolt.verification.sdk.internal.c4
    public void f(boolean z7) {
        this.f44702c.f(z7);
    }

    @Override // eu.bolt.verification.sdk.internal.q0
    public Observable<q0.a> h() {
        return this.f44703d;
    }

    public void l(boolean z7) {
        this.f44702c.s(z7);
    }
}
