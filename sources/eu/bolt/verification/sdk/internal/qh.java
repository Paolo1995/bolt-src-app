package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import eu.bolt.verification.sdk.internal.cj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class qh extends RecyclerView.Adapter<c> implements cj {

    /* renamed from: l  reason: collision with root package name */
    public static final a f44656l = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private final b f44657d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f44658e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f44659f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f44660g;

    /* renamed from: h  reason: collision with root package name */
    private final Set<c> f44661h;

    /* renamed from: i  reason: collision with root package name */
    private int f44662i;

    /* renamed from: j  reason: collision with root package name */
    private int f44663j;

    /* renamed from: k  reason: collision with root package name */
    private final d f44664k;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();

        void c();

        void c(String str);

        void h(int i8, boolean z7);
    }

    /* loaded from: classes5.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final eu.bolt.client.stories.view.singlestory.a f44665u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(eu.bolt.client.stories.view.singlestory.a storyView) {
            super(storyView);
            Intrinsics.f(storyView, "storyView");
            this.f44665u = storyView;
        }

        public final eu.bolt.client.stories.view.singlestory.a O() {
            return this.f44665u;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends ViewPager2.OnPageChangeCallback {
        d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void a(int i8) {
            boolean z7 = qh.this.f44660g;
            qh.this.f44660g = i8 == 0;
            if (z7 != qh.this.f44660g) {
                if (qh.this.f44660g) {
                    eu.bolt.client.stories.view.singlestory.a P = qh.this.P();
                    if (P != null) {
                        qh.this.T(P);
                        return;
                    }
                    return;
                }
                eu.bolt.client.stories.view.singlestory.a P2 = qh.this.P();
                if (P2 != null) {
                    P2.Z();
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void c(int i8) {
            if (qh.this.f44662i != i8) {
                qh qhVar = qh.this;
                eu.bolt.client.stories.view.singlestory.a Q = qhVar.Q(qhVar.f44662i);
                if (Q != null) {
                    Q.b0();
                }
                qh.this.f44662i = i8;
                eu.bolt.client.stories.view.singlestory.a Q2 = qh.this.Q(i8);
                if (Q2 != null) {
                    qh.this.T(Q2);
                }
            }
        }
    }

    public qh(b listener) {
        Intrinsics.f(listener, "listener");
        this.f44657d = listener;
        this.f44658e = new ArrayList();
        this.f44660g = true;
        this.f44661h = new LinkedHashSet();
        this.f44662i = -10;
        this.f44664k = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final eu.bolt.client.stories.view.singlestory.a P() {
        return Q(this.f44662i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final eu.bolt.client.stories.view.singlestory.a Q(int i8) {
        Object obj;
        boolean z7;
        Iterator<T> it = this.f44661h.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((c) obj).k() == i8) {
                z7 = true;
                continue;
            } else {
                z7 = false;
                continue;
            }
            if (z7) {
                break;
            }
        }
        c cVar = (c) obj;
        if (cVar != null) {
            return cVar.O();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(eu.bolt.client.stories.view.singlestory.a aVar) {
        if (!aVar.W() && this.f44660g && this.f44659f) {
            aVar.a0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: S */
    public c G(ViewGroup parent, int i8) {
        Intrinsics.f(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.e(context, "parent.context");
        eu.bolt.client.stories.view.singlestory.a aVar = new eu.bolt.client.stories.view.singlestory.a(context, null, 0, 6, null);
        aVar.setListener(this);
        return new c(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: U */
    public void J(c holder) {
        Intrinsics.f(holder, "holder");
        super.J(holder);
        this.f44661h.add(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: V */
    public void E(c holder, int i8) {
        Intrinsics.f(holder, "holder");
        eu.bolt.client.stories.view.singlestory.a O = holder.O();
        eu.bolt.client.stories.view.singlestory.a.w(O, this.f44658e.get(i8), false, 2, null);
        O.setNavBarPaddings(this.f44663j);
    }

    public final void Y(List<String> storyIds) {
        Intrinsics.f(storyIds, "storyIds");
        this.f44658e.clear();
        this.f44658e.addAll(storyIds);
        w();
    }

    public final ViewPager2.OnPageChangeCallback b0() {
        return this.f44664k;
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void c(String storyId) {
        Intrinsics.f(storyId, "storyId");
        this.f44657d.c(storyId);
    }

    public final void c0(int i8) {
        this.f44663j = i8;
        w();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d0 */
    public void K(c holder) {
        Intrinsics.f(holder, "holder");
        super.K(holder);
        this.f44661h.remove(holder);
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void f(String str) {
        cj.a.a(this, str);
    }

    public final void g0() {
        h0();
        eu.bolt.client.stories.view.singlestory.a P = P();
        if (P != null) {
            P.Y();
        }
    }

    public final void h0() {
        this.f44659f = false;
        eu.bolt.client.stories.view.singlestory.a P = P();
        if (P != null) {
            P.Z();
        }
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void i(String storyId) {
        Intrinsics.f(storyId, "storyId");
        int indexOf = this.f44658e.indexOf(storyId) + 1;
        if (indexOf == 0) {
            t3.c("storyIds list in adapter doesn't contain storyId " + storyId, null, 2, null);
        } else if (indexOf < this.f44658e.size()) {
            this.f44657d.h(indexOf, true);
        } else {
            this.f44657d.a();
        }
    }

    public final void i0() {
        this.f44659f = true;
        eu.bolt.client.stories.view.singlestory.a P = P();
        if (P != null) {
            T(P);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void j(String storyId) {
        Intrinsics.f(storyId, "storyId");
        int indexOf = this.f44658e.indexOf(storyId) - 1;
        if (indexOf >= 0) {
            this.f44657d.h(indexOf, true);
        } else {
            this.f44657d.c();
        }
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void k(String storyId, Throwable th) {
        Intrinsics.f(storyId, "storyId");
        this.f44657d.c();
        g0();
    }

    @Override // eu.bolt.verification.sdk.internal.cj
    public void l(String storyId, Throwable th) {
        Intrinsics.f(storyId, "storyId");
        if (th instanceof xl) {
            int indexOf = this.f44658e.indexOf(storyId);
            this.f44658e.remove(indexOf);
            C(indexOf);
            if (this.f44658e.isEmpty()) {
                this.f44657d.b();
            } else if (indexOf == this.f44658e.size()) {
                this.f44657d.a();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int r() {
        return this.f44658e.size();
    }
}
