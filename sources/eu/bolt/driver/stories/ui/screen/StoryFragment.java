package eu.bolt.driver.stories.ui.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import eu.bolt.driver.core.ui.base.fragment.BaseFragmentParams;
import eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import eu.bolt.driver.stories.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryFragment.kt */
/* loaded from: classes5.dex */
public final class StoryFragment extends BaseMvvmFragment<StoryViewModel> {

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, View> f41554l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public StoryFragment(BaseFragmentParams params, ViewModelFactory viewModelFactory) {
        super(params, viewModelFactory);
        Intrinsics.f(params, "params");
        Intrinsics.f(viewModelFactory, "viewModelFactory");
        this.f41554l = new LinkedHashMap();
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment
    public void D() {
        this.f41554l.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment
    /* renamed from: O */
    public StoryViewModel N() {
        return (StoryViewModel) new ViewModelProvider(this, BaseMvvmFragment.I(this)).a(StoryViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_story, viewGroup, false);
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
    }
}
