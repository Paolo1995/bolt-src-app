package ee.mtakso.driver.uikit.recyclerview;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Paging.kt */
/* loaded from: classes5.dex */
public final class Paging {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView f35993a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f35994b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35995c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f35996d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f35997e;

    /* renamed from: f  reason: collision with root package name */
    private final Paging$scrollListener$1 f35998f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [ee.mtakso.driver.uikit.recyclerview.Paging$scrollListener$1, androidx.recyclerview.widget.RecyclerView$OnScrollListener] */
    public Paging(RecyclerView recyclerView, Function0<Unit> onLoadNextPage) {
        Intrinsics.f(recyclerView, "recyclerView");
        Intrinsics.f(onLoadNextPage, "onLoadNextPage");
        this.f35993a = recyclerView;
        this.f35994b = onLoadNextPage;
        this.f35995c = 5;
        ?? r32 = new RecyclerView.OnScrollListener() { // from class: ee.mtakso.driver.uikit.recyclerview.Paging$scrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void a(RecyclerView recyclerView2, int i8) {
                Intrinsics.f(recyclerView2, "recyclerView");
                super.a(recyclerView2, i8);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView recyclerView2, int i8, int i9) {
                Intrinsics.f(recyclerView2, "recyclerView");
                super.b(recyclerView2, i8, i9);
                if (i9 >= 0) {
                    Paging.this.b();
                }
            }
        };
        this.f35998f = r32;
        recyclerView.l(r32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        LinearLayoutManager linearLayoutManager;
        RecyclerView.Adapter adapter;
        int n22;
        if (!this.f35996d && !this.f35997e) {
            RecyclerView.LayoutManager layoutManager = this.f35993a.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager != null && (adapter = this.f35993a.getAdapter()) != null && (n22 = linearLayoutManager.n2()) != -1 && n22 + this.f35995c + 1 >= adapter.r()) {
                this.f35996d = true;
                this.f35994b.invoke();
            }
        }
    }

    public final void c(boolean z7) {
        this.f35996d = false;
        this.f35997e = z7;
        b();
    }
}
