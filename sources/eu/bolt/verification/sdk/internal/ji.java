package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$layout;
import eu.bolt.verification.sdk.internal.qh;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public class ji extends FrameLayout implements qh.b {

    /* renamed from: f  reason: collision with root package name */
    private wh f43701f;

    /* renamed from: g  reason: collision with root package name */
    private ViewPager2 f43702g;

    /* renamed from: h  reason: collision with root package name */
    private final qh f43703h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f43704i;

    /* renamed from: j  reason: collision with root package name */
    private List<String> f43705j;

    /* renamed from: k  reason: collision with root package name */
    private String f43706k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ji(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f43703h = new qh(this);
        View.inflate(context, R$layout.view_stories, this);
        g();
    }

    public static /* synthetic */ void d(ji jiVar, String str, boolean z7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchToStory");
        }
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        jiVar.e(str, z7);
    }

    private final void g() {
        View findViewById = findViewById(R$id.Y0);
        Intrinsics.e(findViewById, "findViewById(R.id.stories)");
        ViewPager2 viewPager2 = (ViewPager2) findViewById;
        this.f43702g = viewPager2;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.w("stories");
            viewPager2 = null;
        }
        viewPager2.setAdapter(this.f43703h);
        ViewPager2 viewPager23 = this.f43702g;
        if (viewPager23 == null) {
            Intrinsics.w("stories");
        } else {
            viewPager22 = viewPager23;
        }
        viewPager22.g(this.f43703h.b0());
    }

    @Override // eu.bolt.verification.sdk.internal.qh.b
    public void a() {
        wh whVar = this.f43701f;
        if (whVar != null) {
            whVar.a();
        }
    }

    @Override // eu.bolt.verification.sdk.internal.qh.b
    public void b() {
        wh whVar = this.f43701f;
        if (whVar != null) {
            whVar.b();
        }
    }

    @Override // eu.bolt.verification.sdk.internal.qh.b
    public void c() {
        wh whVar = this.f43701f;
        if (whVar != null) {
            whVar.c();
        }
    }

    @Override // eu.bolt.verification.sdk.internal.qh.b
    public void c(String storyId) {
        Intrinsics.f(storyId, "storyId");
        this.f43706k = storyId;
        wh whVar = this.f43701f;
        if (whVar != null) {
            whVar.c(storyId);
        }
    }

    public final void e(String storyId, boolean z7) {
        Intrinsics.f(storyId, "storyId");
        List<String> list = this.f43705j;
        Integer valueOf = list != null ? Integer.valueOf(list.indexOf(storyId)) : null;
        if (valueOf == null || valueOf.intValue() == -1) {
            return;
        }
        h(valueOf.intValue(), z7);
    }

    public final void f(List<String> storyIds, int i8) {
        Intrinsics.f(storyIds, "storyIds");
        this.f43705j = storyIds;
        this.f43703h.Y(storyIds);
        ViewPager2 viewPager2 = this.f43702g;
        if (viewPager2 == null) {
            Intrinsics.w("stories");
            viewPager2 = null;
        }
        viewPager2.j(i8, false);
    }

    public final String getDisplayedStoryId() {
        return this.f43706k;
    }

    @Override // eu.bolt.verification.sdk.internal.qh.b
    public void h(int i8, boolean z7) {
        ViewPager2 viewPager2 = this.f43702g;
        if (viewPager2 == null) {
            Intrinsics.w("stories");
            viewPager2 = null;
        }
        viewPager2.j(i8, z7);
    }

    public final void i() {
        this.f43704i = false;
        this.f43703h.h0();
    }

    public final void j() {
        this.f43704i = true;
        if (uq.X(this)) {
            this.f43703h.i0();
        }
    }

    public final void setBottomNavBarOffset(int i8) {
        this.f43703h.c0(i8);
    }

    public final void setHost(wh storiesHost) {
        Intrinsics.f(storiesHost, "storiesHost");
        this.f43701f = storiesHost;
    }
}
