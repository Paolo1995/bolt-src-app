package ee.mtakso.driver.ui.screens.settings.theme;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.settings.theme.ThemeSettingsFragment;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.ui.utils.KeyboardUtils;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.theme.AppThemeMode;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThemeSettingsFragment.kt */
/* loaded from: classes5.dex */
public final class ThemeSettingsFragment extends BazeMvvmFragment<ThemeSettingsViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f33297o;

    /* renamed from: p  reason: collision with root package name */
    private int f33298p;

    /* renamed from: q  reason: collision with root package name */
    private final DiffAdapter f33299q;

    /* renamed from: r  reason: collision with root package name */
    public Map<Integer, View> f33300r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ThemeSettingsFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_settings_details, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f33300r = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.settings.theme.ThemeSettingsFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = ThemeSettingsFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f33297o = b8;
        this.f33298p = 2132017818;
        this.f33299q = new DiffAdapter().P(new TwoLinesItemDelegate(new ThemeSettingsFragment$diffAdapter$1(this), null, 0, null, 14, null));
    }

    private final Navigator V() {
        return (Navigator) this.f33297o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(TwoLinesItemDelegate.Model<AppThemeMode> model) {
        AppThemeMode B = model.B();
        if (B != null) {
            KeyboardUtils.f34304a.a(getView());
            M().E(B);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(ThemeSettingsState themeSettingsState) {
        int v7;
        Image.Res res;
        Text.Resource resource;
        int m8;
        boolean z7;
        List<AppThemeMode> d8 = themeSettingsState.d();
        v7 = CollectionsKt__IterablesKt.v(d8, 10);
        ArrayList arrayList = new ArrayList(v7);
        int i8 = 0;
        for (Object obj : d8) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            AppThemeMode appThemeMode = (AppThemeMode) obj;
            if (appThemeMode == themeSettingsState.c()) {
                res = new Image.Res(R.drawable.ic_check_24dp);
            } else {
                res = null;
            }
            String name = appThemeMode.name();
            Integer a8 = AppThemeUtils.f34255a.a(appThemeMode);
            if (a8 != null) {
                resource = new Text.Resource(a8.intValue(), null, 2, null);
            } else {
                resource = null;
            }
            Color.Attr attr = new Color.Attr(R.attr.contentPrimary);
            Color.Attr attr2 = new Color.Attr(R.attr.linkAlternative);
            Color.Attr attr3 = new Color.Attr(R.attr.backPrimary);
            m8 = CollectionsKt__CollectionsKt.m(themeSettingsState.d());
            if (i8 < m8) {
                z7 = true;
            } else {
                z7 = false;
            }
            arrayList.add(new TwoLinesItemDelegate.Model(name, resource, null, attr, null, null, null, null, null, null, null, attr2, res, null, null, null, attr3, null, appThemeMode, false, 0, 0, z7, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, false, false, false, 507176948, null));
            i8 = i9;
        }
        DiffAdapter.V(this.f33299q, arrayList, null, 2, null);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33300r.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f33298p);
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33300r;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: Y */
    public ThemeSettingsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (ThemeSettingsViewModel) new ViewModelProvider(this, E.d()).a(ThemeSettingsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        Navigator V = V();
        if (V != null) {
            V.x(new PopupToolbarAppearance(0, new Text.Resource(R.string.settings_app_theme, null, 2, null), false, null, null, null, null, null, null, 509, null));
        }
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) S(i8)).setAdapter(this.f33299q);
        ((RecyclerView) S(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        LiveData<ThemeSettingsState> D = M().D();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ThemeSettingsState, Unit> function1 = new Function1<ThemeSettingsState, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.theme.ThemeSettingsFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ThemeSettingsState it) {
                ThemeSettingsFragment themeSettingsFragment = ThemeSettingsFragment.this;
                Intrinsics.e(it, "it");
                themeSettingsFragment.Z(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ThemeSettingsState themeSettingsState) {
                b(themeSettingsState);
                return Unit.f50853a;
            }
        };
        D.i(viewLifecycleOwner, new Observer() { // from class: e5.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThemeSettingsFragment.X(Function1.this, obj);
            }
        });
    }
}
