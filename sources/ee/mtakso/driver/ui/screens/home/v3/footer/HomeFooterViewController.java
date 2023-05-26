package ee.mtakso.driver.ui.screens.home.v3.footer;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.ui.screens.home.v3.footer.HomeFooterViewController;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeFooterViewController.kt */
/* loaded from: classes3.dex */
public final class HomeFooterViewController {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<HomeTab, Unit> f30008a;

    /* renamed from: b  reason: collision with root package name */
    private final FooterContainer f30009b;

    /* renamed from: c  reason: collision with root package name */
    private FooterAppearance f30010c;

    /* renamed from: d  reason: collision with root package name */
    private DriverStatus f30011d;

    /* renamed from: e  reason: collision with root package name */
    private HomeTab f30012e;

    /* JADX WARN: Multi-variable type inference failed */
    public HomeFooterViewController(View root, Function1<? super HomeTab, Unit> tabChangeCallback) {
        Intrinsics.f(root, "root");
        Intrinsics.f(tabChangeCallback, "tabChangeCallback");
        this.f30008a = tabChangeCallback;
        FooterContainer footerContainer = new FooterContainer(root);
        this.f30009b = footerContainer;
        this.f30011d = DriverStatus.UNDEFINED;
        this.f30012e = HomeTab.WORK;
        ((ConstraintLayout) footerContainer.a(R.id.bottomFooterWorkButtonLayout)).setOnClickListener(new View.OnClickListener() { // from class: y3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFooterViewController.e(HomeFooterViewController.this, view);
            }
        });
        ((ConstraintLayout) footerContainer.a(R.id.bottomFooterInboxButtonLayout)).setOnClickListener(new View.OnClickListener() { // from class: y3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFooterViewController.f(HomeFooterViewController.this, view);
            }
        });
        ((ConstraintLayout) footerContainer.a(R.id.bottomFooterHistoryButtonLayout)).setOnClickListener(new View.OnClickListener() { // from class: y3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFooterViewController.g(HomeFooterViewController.this, view);
            }
        });
        ((ConstraintLayout) footerContainer.a(R.id.bottomFooterSettingsButtonLayout)).setOnClickListener(new View.OnClickListener() { // from class: y3.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFooterViewController.h(HomeFooterViewController.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(HomeFooterViewController this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.j(HomeTab.WORK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(HomeFooterViewController this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.j(HomeTab.NEWS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(HomeFooterViewController this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.j(HomeTab.HISTORY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(HomeFooterViewController this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.j(HomeTab.SETTINGS);
    }

    private final void j(HomeTab homeTab) {
        this.f30008a.invoke(homeTab);
        this.f30012e = homeTab;
    }

    public final void i(FooterAppearance appearance) {
        Intrinsics.f(appearance, "appearance");
        this.f30010c = appearance;
        appearance.a(this.f30009b, this.f30011d);
    }

    public final void k(DriverStatus state) {
        Intrinsics.f(state, "state");
        if (state == this.f30011d) {
            return;
        }
        this.f30011d = state;
        FooterAppearance footerAppearance = this.f30010c;
        if (footerAppearance != null) {
            footerAppearance.a(this.f30009b, state);
        }
    }
}
