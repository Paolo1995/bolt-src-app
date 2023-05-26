package eu.bolt.driver.stories.ui.screen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.stories.mapper.StoryMapper;
import eu.bolt.android.stories.model.Story;
import eu.bolt.android.stories.widget.set.StorySetHostListener;
import eu.bolt.android.stories.widget.set.StorySetView;
import eu.bolt.driver.core.ui.base.fragment.BaseFragmentParams;
import eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import eu.bolt.driver.stories.R$anim;
import eu.bolt.driver.stories.R$id;
import eu.bolt.driver.stories.R$layout;
import eu.bolt.driver.stories.R$style;
import eu.bolt.driver.stories.service.analytic.StoryAnalyticDelegate;
import eu.bolt.driver.stories.ui.screen.StorySetFragment;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySetFragment.kt */
/* loaded from: classes5.dex */
public final class StorySetFragment extends BaseMvvmFragment<StorySetViewModel> {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f41557p = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private final StoryMapper f41558l;

    /* renamed from: m  reason: collision with root package name */
    private final StoryAnalyticDelegate f41559m;

    /* renamed from: n  reason: collision with root package name */
    private final HtmlEngine f41560n;

    /* renamed from: o  reason: collision with root package name */
    public Map<Integer, View> f41561o;

    /* compiled from: StorySetFragment.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(List<String> ids, boolean z7) {
            Intrinsics.f(ids, "ids");
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("STORY_IDS", new ArrayList<>(ids));
            bundle.putBoolean("CLOSE_HOST_ON_DONE", z7);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public StorySetFragment(BaseFragmentParams params, ViewModelFactory viewModelFactory, StoryMapper storyMapper, StoryAnalyticDelegate storyAnalyticDelegate, HtmlEngine htmlEngine) {
        super(params, viewModelFactory);
        Intrinsics.f(params, "params");
        Intrinsics.f(viewModelFactory, "viewModelFactory");
        Intrinsics.f(storyMapper, "storyMapper");
        Intrinsics.f(storyAnalyticDelegate, "storyAnalyticDelegate");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f41561o = new LinkedHashMap();
        this.f41558l = storyMapper;
        this.f41559m = storyAnalyticDelegate;
        this.f41560n = htmlEngine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(int i8) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(i8);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            activity3.overridePendingTransition(R$anim.hold, R$anim.story_exit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment
    public void D() {
        this.f41561o.clear();
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseFragment
    protected void E() {
        CircularProgressIndicator progressView = (CircularProgressIndicator) P(R$id.f41542a);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, false, 0, 2, null);
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseFragment
    protected void F(Throwable error) {
        Intrinsics.f(error, "error");
        ((StorySetView) P(R$id.storySetView)).j(new Function1<String, Unit>() { // from class: eu.bolt.driver.stories.ui.screen.StorySetFragment$showError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String it) {
                StorySetViewModel J;
                Intrinsics.f(it, "it");
                J = StorySetFragment.this.J();
                J.t(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseFragment
    protected void G() {
        CircularProgressIndicator progressView = (CircularProgressIndicator) P(R$id.f41542a);
        Intrinsics.e(progressView, "progressView");
        ViewExtKt.e(progressView, true, 0, 2, null);
    }

    public View P(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f41561o;
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
    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment
    /* renamed from: W */
    public StorySetViewModel N() {
        return (StorySetViewModel) new ViewModelProvider(this, BaseMvvmFragment.I(this)).a(StorySetViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onAttach(Context context) {
        Intrinsics.f(context, "context");
        super.onAttach(context);
        requireActivity().setRequestedOrientation(1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.f(inflater, "inflater");
        return inflater.cloneInContext(new ContextThemeWrapper(requireContext(), R$style.f41543a)).inflate(R$layout.fragment_story_set, viewGroup, false);
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // eu.bolt.driver.core.ui.base.fragment.BaseMvvmFragment, eu.bolt.driver.core.ui.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        List<String> list;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        int i8 = R$id.storySetView;
        ((StorySetView) P(i8)).setStoryAnalyticListener(this.f41559m);
        ((StorySetView) P(i8)).g(new Function1<String, CharSequence>() { // from class: eu.bolt.driver.stories.ui.screen.StorySetFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CharSequence invoke(String source) {
                HtmlEngine htmlEngine;
                Intrinsics.f(source, "source");
                htmlEngine = StorySetFragment.this.f41560n;
                return htmlEngine.a(source);
            }
        });
        LiveData<Story> s7 = J().s();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Story, Unit> function1 = new Function1<Story, Unit>() { // from class: eu.bolt.driver.stories.ui.screen.StorySetFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Story it) {
                StoryMapper storyMapper;
                storyMapper = StorySetFragment.this.f41558l;
                Intrinsics.e(it, "it");
                ((StorySetView) StorySetFragment.this.P(R$id.storySetView)).h(storyMapper.a(it));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Story story) {
                b(story);
                return Unit.f50853a;
            }
        };
        s7.i(viewLifecycleOwner, new Observer() { // from class: i7.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StorySetFragment.V(Function1.this, obj);
            }
        });
        StorySetView storySetView = (StorySetView) P(i8);
        Bundle arguments = getArguments();
        if (arguments != null) {
            list = arguments.getStringArrayList("STORY_IDS");
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.k();
        }
        storySetView.setStoryIds(list);
        final boolean z7 = requireArguments().getBoolean("CLOSE_HOST_ON_DONE");
        ((StorySetView) P(i8)).k(new StorySetHostListener() { // from class: eu.bolt.driver.stories.ui.screen.StorySetFragment$onViewCreated$3
            @Override // eu.bolt.android.stories.widget.set.StorySetHostListener
            public void a(Throwable exception) {
                Intrinsics.f(exception, "exception");
            }

            @Override // eu.bolt.android.stories.widget.set.StorySetHostListener
            public void b() {
                if (z7) {
                    StorySetFragment.this.U(0);
                }
            }

            @Override // eu.bolt.android.stories.widget.set.StorySetHostListener
            public void c() {
                if (z7) {
                    StorySetFragment.this.U(-1);
                }
            }

            @Override // eu.bolt.android.stories.widget.set.StorySetHostListener
            public void d(String storyId) {
                StorySetViewModel J;
                Intrinsics.f(storyId, "storyId");
                Kalev.b("onStoryDownloadListener");
                J = StorySetFragment.this.J();
                J.t(storyId);
            }

            @Override // eu.bolt.android.stories.widget.set.StorySetHostListener
            public void e(String storyId) {
                Intrinsics.f(storyId, "storyId");
            }
        });
    }
}
