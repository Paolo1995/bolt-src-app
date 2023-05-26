package ee.mtakso.driver.ui.screens.infoweb;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.PopupToolbarAppearance;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebFragment;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebViewModel;
import ee.mtakso.driver.ui.views.webview.PlainWebView;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfoWebFragment.kt */
/* loaded from: classes3.dex */
public final class InfoWebFragment extends BazeMvvmFragment<InfoWebViewModel> {

    /* renamed from: s */
    public static final Companion f30370s = new Companion(null);

    /* renamed from: o */
    private MenuItem f30371o;

    /* renamed from: p */
    private final Lazy f30372p;

    /* renamed from: q */
    private final Lazy f30373q;

    /* renamed from: r */
    public Map<Integer, View> f30374r;

    /* compiled from: InfoWebFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Bundle b(Companion companion, InfoWebViewModel.Config config, Bundle bundle, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                bundle = new Bundle();
            }
            return companion.a(config, bundle);
        }

        public final Bundle a(InfoWebViewModel.Config config, Bundle bundle) {
            Intrinsics.f(config, "config");
            Intrinsics.f(bundle, "bundle");
            bundle.putParcelable("CONFIG", config);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public InfoWebFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_web_info, null, 4, null);
        Lazy b8;
        Lazy b9;
        Intrinsics.f(deps, "deps");
        this.f30374r = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.infoweb.InfoWebFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = InfoWebFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f30372p = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<InfoWebViewModel.Config>() { // from class: ee.mtakso.driver.ui.screens.infoweb.InfoWebFragment$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final InfoWebViewModel.Config invoke() {
                return (InfoWebViewModel.Config) InfoWebFragment.this.requireArguments().getParcelable("CONFIG");
            }
        });
        this.f30373q = b9;
    }

    private final void T(InfoWebViewModel.WebContent.Raw raw) {
        Color.Attr attr = new Color.Attr(R.attr.contentPrimary);
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        int a8 = ColorKt.a(attr, requireContext);
        String str = "<html><head></head><body style=\"background-color:transparent;color:rgba(" + android.graphics.Color.red(a8) + "," + android.graphics.Color.green(a8) + "," + android.graphics.Color.blue(a8) + "," + android.graphics.Color.alpha(a8) + ");\">" + raw.a() + "</body></html>";
        int i8 = R.id.S2;
        ((PlainWebView) S(i8)).i(str);
        ((PlainWebView) S(i8)).setBackgroundColor(0);
    }

    private final void U(InfoWebViewModel.WebContent.Link link) {
        int i8 = R.id.S2;
        ((PlainWebView) S(i8)).loadUrl(link.a());
        ((PlainWebView) S(i8)).setBackgroundColor(0);
    }

    private final InfoWebViewModel.Config V() {
        return (InfoWebViewModel.Config) this.f30373q.getValue();
    }

    private final Navigator W() {
        return (Navigator) this.f30372p.getValue();
    }

    public static final void X(InfoWebFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Z();
    }

    private final void Z() {
        InfoWebViewModel.FaqConfig b8;
        InfoWebViewModel.Config V = V();
        if (V != null && (b8 = V.b()) != null) {
            M().D(b8.b());
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f30374r.clear();
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30374r;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: Y */
    public InfoWebViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (InfoWebViewModel) new ViewModelProvider(this, E.d()).a(InfoWebViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.f(menu, "menu");
        Intrinsics.f(menuInflater, "menuInflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.payout_history_view_menu, menu);
        MenuItem findItem = menu.findItem(R.id.actionHelp);
        this.f30371o = findItem;
        if (findItem != null) {
            findItem.setVisible(false);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.f(item, "item");
        int itemId = item.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.actionHelp) {
                return false;
            }
            Z();
            return true;
        }
        Navigator W = W();
        if (W == null) {
            return true;
        }
        W.c();
        return true;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        boolean z7;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        InfoWebViewModel.Config V = V();
        if (V == null) {
            Navigator W = W();
            if (W != null) {
                W.c();
                return;
            }
            return;
        }
        Navigator W2 = W();
        if (W2 != null) {
            W2.n(new PopupToolbarAppearance(0, new Text.Value(V.c()), false, 5, null));
        }
        int i8 = R.id.faqButton;
        RoundButton faqButton = (RoundButton) S(i8);
        Intrinsics.e(faqButton, "faqButton");
        if (V.b() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(faqButton, z7, 0, 2, null);
        if (V.b() != null) {
            ((RoundButton) S(i8)).setText(V.b().a());
            ((RoundButton) S(i8)).setOnClickListener(new View.OnClickListener() { // from class: d4.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    InfoWebFragment.X(InfoWebFragment.this, view2);
                }
            });
        }
        G();
        InfoWebViewModel.WebContent a8 = V.a();
        if (a8 instanceof InfoWebViewModel.WebContent.Link) {
            U((InfoWebViewModel.WebContent.Link) a8);
        } else if (a8 instanceof InfoWebViewModel.WebContent.Raw) {
            T((InfoWebViewModel.WebContent.Raw) a8);
        } else {
            Navigator W3 = W();
            if (W3 != null) {
                W3.c();
            }
        }
    }
}
