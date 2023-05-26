package eu.bolt.android.stories.widget.set;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import eu.bolt.android.stories.analytics.StoryAnalyticListener;
import eu.bolt.android.stories.widget.set.StorySetAdapter;
import eu.bolt.android.stories.widget.story.Story;
import eu.bolt.android.stories.widget.story.StoryListener;
import eu.bolt.android.stories.widget.story.StoryView;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorySetAdapter.kt */
/* loaded from: classes5.dex */
public final class StorySetAdapter extends RecyclerView.Adapter<StoryHolder> implements StoryListener {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f37646m = new Companion(null);

    /* renamed from: d  reason: collision with root package name */
    private final StoriesAdapterListener f37647d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f37648e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<StoryHolder> f37649f;

    /* renamed from: g  reason: collision with root package name */
    private int f37650g;

    /* renamed from: h  reason: collision with root package name */
    private int f37651h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f37652i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f37653j;

    /* renamed from: k  reason: collision with root package name */
    private StoryAnalyticListener f37654k;

    /* renamed from: l  reason: collision with root package name */
    private final StorySetAdapter$onPageChangeCallback$1 f37655l;

    /* compiled from: StorySetAdapter.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StorySetAdapter.kt */
    /* loaded from: classes5.dex */
    public interface StoriesAdapterListener {
        void a(Throwable th);

        void b();

        void c();

        void d(String str);

        void e(String str);

        void f(int i8, boolean z7);
    }

    /* compiled from: StorySetAdapter.kt */
    /* loaded from: classes5.dex */
    public static final class StoryHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final StoryView f37656u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StoryHolder(StoryView storyView) {
            super(storyView);
            Intrinsics.f(storyView, "storyView");
            this.f37656u = storyView;
        }

        public final StoryView O() {
            return this.f37656u;
        }
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [eu.bolt.android.stories.widget.set.StorySetAdapter$onPageChangeCallback$1] */
    public StorySetAdapter(StoriesAdapterListener listener) {
        Intrinsics.f(listener, "listener");
        this.f37647d = listener;
        this.f37648e = new ArrayList();
        this.f37649f = new LinkedHashSet();
        this.f37650g = -1;
        this.f37651h = -1;
        this.f37652i = true;
        this.f37655l = new ViewPager2.OnPageChangeCallback() { // from class: eu.bolt.android.stories.widget.set.StorySetAdapter$onPageChangeCallback$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void a(int i8) {
                boolean z7;
                boolean z8;
                boolean z9;
                boolean z10;
                StoryView a02;
                StoryView a03;
                z7 = StorySetAdapter.this.f37652i;
                StorySetAdapter storySetAdapter = StorySetAdapter.this;
                if (i8 == 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                storySetAdapter.f37652i = z8;
                z9 = StorySetAdapter.this.f37652i;
                if (z7 != z9) {
                    z10 = StorySetAdapter.this.f37652i;
                    if (z10) {
                        a03 = StorySetAdapter.this.a0();
                        if (a03 != null) {
                            StorySetAdapter.this.h0(a03);
                            return;
                        }
                        return;
                    }
                    a02 = StorySetAdapter.this.a0();
                    if (a02 != null) {
                        a02.D();
                    }
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void c(int i8) {
                int i9;
                int i10;
                StorySetAdapter.StoriesAdapterListener storiesAdapterListener;
                List list;
                int i11;
                StoryView c02;
                StoryView c03;
                i9 = StorySetAdapter.this.f37651h;
                if (i9 != i8) {
                    StorySetAdapter storySetAdapter = StorySetAdapter.this;
                    i11 = storySetAdapter.f37651h;
                    c02 = storySetAdapter.c0(i11);
                    if (c02 != null) {
                        c02.C();
                    }
                    StorySetAdapter.this.f37651h = i8;
                    c03 = StorySetAdapter.this.c0(i8);
                    if (c03 != null) {
                        StorySetAdapter.this.h0(c03);
                    }
                }
                i10 = StorySetAdapter.this.f37650g;
                if (i8 > i10) {
                    storiesAdapterListener = StorySetAdapter.this.f37647d;
                    list = StorySetAdapter.this.f37648e;
                    storiesAdapterListener.d((String) list.get(i8));
                    StorySetAdapter.this.f37650g = i8;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoryView a0() {
        return c0(this.f37651h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StoryView c0(int i8) {
        Object obj;
        boolean z7;
        Iterator<T> it = this.f37649f.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((StoryHolder) obj).k() == i8) {
                    z7 = true;
                    continue;
                } else {
                    z7 = false;
                    continue;
                }
                if (z7) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        StoryHolder storyHolder = (StoryHolder) obj;
        if (storyHolder == null) {
            return null;
        }
        return storyHolder.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(StoryView storyView) {
        if (!storyView.A() && this.f37652i && this.f37653j) {
            storyView.E();
        }
    }

    @Override // eu.bolt.android.stories.widget.story.StoryListener
    public void a(Throwable exception) {
        Intrinsics.f(exception, "exception");
        this.f37647d.a(exception);
    }

    public final ViewPager2.OnPageChangeCallback b0() {
        return this.f37655l;
    }

    @Override // eu.bolt.android.stories.widget.story.StoryListener
    public void d(Story story) {
        Intrinsics.f(story, "story");
        int indexOf = this.f37648e.indexOf(story.a()) + 1;
        if (indexOf == 0) {
            String a8 = story.a();
            Kalev.d("storyIds list in adapter doesn't contain storyId " + a8);
        } else if (indexOf < this.f37648e.size()) {
            this.f37647d.f(indexOf, true);
        } else {
            this.f37647d.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d0 */
    public void E(StoryHolder holder, int i8) {
        Intrinsics.f(holder, "holder");
    }

    @Override // eu.bolt.android.stories.widget.story.StoryListener
    public void e() {
        this.f37647d.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e0 */
    public StoryHolder G(ViewGroup parent, int i8) {
        Intrinsics.f(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.e(context, "parent.context");
        StoryView storyView = new StoryView(context, null, 0, 6, null);
        storyView.setStoryListener(this);
        StoryAnalyticListener storyAnalyticListener = this.f37654k;
        if (storyAnalyticListener != null) {
            storyView.setStoryAnalyticListener(storyAnalyticListener);
        }
        return new StoryHolder(storyView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f0 */
    public void J(StoryHolder holder) {
        Intrinsics.f(holder, "holder");
        super.J(holder);
        this.f37649f.add(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g0 */
    public void K(StoryHolder holder) {
        Intrinsics.f(holder, "holder");
        super.K(holder);
        this.f37649f.remove(holder);
    }

    @Override // eu.bolt.android.stories.widget.story.StoryListener
    public void h(Story story) {
        Intrinsics.f(story, "story");
        int indexOf = this.f37648e.indexOf(story.a()) - 1;
        if (indexOf >= 0) {
            this.f37647d.f(indexOf, true);
        } else {
            this.f37647d.b();
        }
    }

    public final void i0(StoryAnalyticListener storyAnalyticListener) {
        Intrinsics.f(storyAnalyticListener, "storyAnalyticListener");
        this.f37654k = storyAnalyticListener;
    }

    public void j0(final Function1<? super String, Unit> tryAgain) {
        Intrinsics.f(tryAgain, "tryAgain");
        StoryView a02 = a0();
        if (a02 != null) {
            a02.I(new Function1<String, Unit>() { // from class: eu.bolt.android.stories.widget.set.StorySetAdapter$showError$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final void b(String str) {
                    List list;
                    int i8;
                    Function1<String, Unit> function1 = tryAgain;
                    list = this.f37648e;
                    i8 = this.f37651h;
                    function1.invoke(list.get(i8));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    b(str);
                    return Unit.f50853a;
                }
            });
        }
    }

    public final void k0(Story story) {
        Intrinsics.f(story, "story");
        StoryView a02 = a0();
        if (a02 != null) {
            a02.O(story);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void l0(List<String> ids) {
        Intrinsics.f(ids, "ids");
        this.f37648e.clear();
        this.f37648e.addAll(ids);
        w();
    }

    @Override // eu.bolt.android.stories.widget.story.StoryListener
    public void m(Story story) {
        Intrinsics.f(story, "story");
        this.f37647d.e(story.a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int r() {
        return this.f37648e.size();
    }
}
