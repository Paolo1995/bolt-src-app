package ee.mtakso.driver.ui.screens.settings.language;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.helper.LoadingDialogDelegate;
import ee.mtakso.driver.ui.interactor.settings.LanguageSettings;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.settings.SettingsItemFactory;
import ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsFragment;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.Divider;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDepthDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.ListItemDividerDecoration;
import ee.mtakso.driver.uicore.components.recyclerview.decorations.NoDivider;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.driver.core.language.Language;
import eu.bolt.driver.core.ui.common.activity.PopupToolbarAppearance;
import eu.bolt.driver.core.utils.AssertUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageSettingsFragment.kt */
/* loaded from: classes5.dex */
public final class LanguageSettingsFragment extends BazeMvvmFragment<LanguageSettingsViewModel> {

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f33192o;

    /* renamed from: p  reason: collision with root package name */
    private final DiffAdapter f33193p;

    /* renamed from: q  reason: collision with root package name */
    private LoadingDialogDelegate f33194q;

    /* renamed from: r  reason: collision with root package name */
    private final int f33195r;

    /* renamed from: s  reason: collision with root package name */
    public Map<Integer, View> f33196s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public LanguageSettingsFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_settings_details, null, 4, null);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        this.f33196s = new LinkedHashMap();
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = LanguageSettingsFragment.this.getActivity();
                if (activity instanceof Navigator) {
                    return (Navigator) activity;
                }
                return null;
            }
        });
        this.f33192o = b8;
        this.f33193p = new DiffAdapter().P(new TwoLinesItemDelegate(new LanguageSettingsFragment$diffAdapter$1(this), null, 0, null, 14, null));
        this.f33195r = 2132017818;
    }

    private final Navigator U() {
        return (Navigator) this.f33192o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(TwoLinesItemDelegate.Model<Language> model) {
        Language B = model.B();
        if (B != null) {
            M().G(B);
        } else {
            AssertUtils.a("Payload is mandatory, but it null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(LanguageSettingsFragment this$0, LanguageSettings state) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        this$0.Y(state);
    }

    private final void Y(LanguageSettings languageSettings) {
        int v7;
        int m8;
        DividerModel divider;
        int i8;
        Image.Res res;
        List<Language> b8 = languageSettings.b();
        v7 = CollectionsKt__IterablesKt.v(b8, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<T> it = b8.iterator();
        int i9 = 0;
        while (true) {
            Image.Res res2 = null;
            if (it.hasNext()) {
                Object next = it.next();
                int i10 = i9 + 1;
                if (i9 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                Language language = (Language) next;
                m8 = CollectionsKt__CollectionsKt.m(languageSettings.b());
                if (i9 == m8) {
                    divider = NoDivider.f34829a;
                } else {
                    divider = new Divider(false, false, false, new Color.Attr(R.attr.dynamicNeutral01), new Color.Attr(R.attr.backPrimary), null, 39, null);
                }
                DividerModel dividerModel = divider;
                Integer num = languageSettings.a().get(language);
                if (num != null) {
                    i8 = num.intValue();
                } else {
                    i8 = 0;
                }
                if (i8 != 0) {
                    res = new Image.Res(i8);
                } else {
                    res = null;
                }
                if (Intrinsics.a(language, languageSettings.c())) {
                    res2 = new Image.Res(R.drawable.ic_check_filled_24dp);
                }
                SettingsItemFactory settingsItemFactory = SettingsItemFactory.f33091a;
                arrayList.add(SettingsItemFactory.b(settingsItemFactory, language.a() + "_" + language.b(), new Text.Value(language.c()), null, null, res, new Color.Attr(R.attr.linkAlternative), res2, null, language, dividerModel, 132, null));
                i9 = i10;
            } else {
                DiffAdapter.V(this.f33193p, arrayList, null, 2, null);
                return;
            }
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f33196s.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.f33195r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        super.G();
        LoadingDialogDelegate loadingDialogDelegate = this.f33194q;
        if (loadingDialogDelegate == null) {
            Intrinsics.w("loadingDialogDelegate");
            loadingDialogDelegate = null;
        }
        loadingDialogDelegate.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        super.H(error);
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b(NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null), this, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        super.I();
        LoadingDialogDelegate loadingDialogDelegate = this.f33194q;
        if (loadingDialogDelegate == null) {
            Intrinsics.w("loadingDialogDelegate");
            loadingDialogDelegate = null;
        }
        loadingDialogDelegate.b();
    }

    public View S(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33196s;
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
    /* renamed from: X */
    public LanguageSettingsViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (LanguageSettingsViewModel) new ViewModelProvider(this, E.d()).a(LanguageSettingsViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        this.f33194q = new LoadingDialogDelegate(requireActivity);
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
        Navigator U = U();
        if (U != null) {
            U.x(new PopupToolbarAppearance(0, new Text.Resource(R.string.language, null, 2, null), false, null, null, null, null, null, null, 509, null));
        }
        int i8 = R.id.H9;
        ((RecyclerView) S(i8)).setLayoutManager(new LinearLayoutManager(requireContext()));
        ((RecyclerView) S(i8)).setAdapter(this.f33193p);
        ((RecyclerView) S(i8)).h(new ListItemDepthDecoration(Dimens.d(24)));
        ((RecyclerView) S(i8)).h(new ListItemDividerDecoration(Dimens.c(24.0f)));
        M().F().i(getViewLifecycleOwner(), new Observer() { // from class: a5.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LanguageSettingsFragment.W(LanguageSettingsFragment.this, (LanguageSettings) obj);
            }
        });
    }
}
