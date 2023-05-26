package eu.bolt.android.stories.widget.set;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import eu.bolt.android.stories.R$id;
import eu.bolt.android.stories.R$layout;
import eu.bolt.android.stories.analytics.StoryAnalyticListener;
import eu.bolt.android.stories.utils.StoriesHtmlEngine;
import eu.bolt.android.stories.widget.set.StorySetAdapter;
import eu.bolt.android.stories.widget.story.Story;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySetView.kt */
/* loaded from: classes5.dex */
public final class StorySetView extends FrameLayout implements StorySetAdapter.StoriesAdapterListener {

    /* renamed from: f  reason: collision with root package name */
    private ViewPager2 f37660f;

    /* renamed from: g  reason: collision with root package name */
    private final StorySetAdapter f37661g;

    /* renamed from: h  reason: collision with root package name */
    private StorySetHostListener f37662h;

    /* renamed from: i  reason: collision with root package name */
    public Map<Integer, View> f37663i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StorySetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorySetView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f37663i = new LinkedHashMap();
        this.f37661g = new StorySetAdapter(this);
        View.inflate(context, R$layout.view_story_set, this);
        i();
    }

    private final void i() {
        View findViewById = findViewById(R$id.f37451o);
        Intrinsics.e(findViewById, "findViewById(R.id.stories)");
        ViewPager2 viewPager2 = (ViewPager2) findViewById;
        this.f37660f = viewPager2;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.w("stories");
            viewPager2 = null;
        }
        viewPager2.setAdapter(this.f37661g);
        ViewPager2 viewPager23 = this.f37660f;
        if (viewPager23 == null) {
            Intrinsics.w("stories");
        } else {
            viewPager22 = viewPager23;
        }
        viewPager22.g(this.f37661g.b0());
    }

    @Override // eu.bolt.android.stories.widget.set.StorySetAdapter.StoriesAdapterListener
    public void a(Throwable exception) {
        Intrinsics.f(exception, "exception");
        StorySetHostListener storySetHostListener = this.f37662h;
        if (storySetHostListener != null) {
            storySetHostListener.a(exception);
        }
    }

    @Override // eu.bolt.android.stories.widget.set.StorySetAdapter.StoriesAdapterListener
    public void b() {
        StorySetHostListener storySetHostListener = this.f37662h;
        if (storySetHostListener != null) {
            storySetHostListener.b();
        }
    }

    @Override // eu.bolt.android.stories.widget.set.StorySetAdapter.StoriesAdapterListener
    public void c() {
        StorySetHostListener storySetHostListener = this.f37662h;
        if (storySetHostListener != null) {
            storySetHostListener.c();
        }
    }

    @Override // eu.bolt.android.stories.widget.set.StorySetAdapter.StoriesAdapterListener
    public void d(String storyId) {
        Intrinsics.f(storyId, "storyId");
        StorySetHostListener storySetHostListener = this.f37662h;
        if (storySetHostListener != null) {
            storySetHostListener.d(storyId);
        }
    }

    @Override // eu.bolt.android.stories.widget.set.StorySetAdapter.StoriesAdapterListener
    public void e(String storyId) {
        Intrinsics.f(storyId, "storyId");
        StorySetHostListener storySetHostListener = this.f37662h;
        if (storySetHostListener != null) {
            storySetHostListener.e(storyId);
        }
    }

    @Override // eu.bolt.android.stories.widget.set.StorySetAdapter.StoriesAdapterListener
    public void f(int i8, boolean z7) {
        ViewPager2 viewPager2 = this.f37660f;
        if (viewPager2 == null) {
            Intrinsics.w("stories");
            viewPager2 = null;
        }
        viewPager2.j(i8, z7);
    }

    public final void g(Function1<? super String, ? extends CharSequence> fromHtml) {
        Intrinsics.f(fromHtml, "fromHtml");
        StoriesHtmlEngine.f37614a.b(fromHtml);
    }

    public final void h(Story story) {
        Intrinsics.f(story, "story");
        this.f37661g.k0(story);
    }

    public final void j(Function1<? super String, Unit> tryAgain) {
        Intrinsics.f(tryAgain, "tryAgain");
        this.f37661g.j0(tryAgain);
    }

    public final void k(StorySetHostListener listener) {
        Intrinsics.f(listener, "listener");
        this.f37662h = listener;
    }

    public final void setStoryAnalyticListener(StoryAnalyticListener storyAnalyticListener) {
        Intrinsics.f(storyAnalyticListener, "storyAnalyticListener");
        this.f37661g.i0(storyAnalyticListener);
    }

    public final void setStoryIds(List<String> storyIds) {
        Intrinsics.f(storyIds, "storyIds");
        this.f37661g.l0(storyIds);
        ViewPager2 viewPager2 = this.f37660f;
        if (viewPager2 == null) {
            Intrinsics.w("stories");
            viewPager2 = null;
        }
        viewPager2.j(0, false);
    }

    public /* synthetic */ StorySetView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
