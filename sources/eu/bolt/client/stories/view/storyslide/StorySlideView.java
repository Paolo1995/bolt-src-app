package eu.bolt.client.stories.view.storyslide;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import eu.bolt.verification.sdk.internal.hk;
import eu.bolt.verification.sdk.internal.ik;
import eu.bolt.verification.sdk.internal.rl;
import eu.bolt.verification.sdk.internal.sj;
import eu.bolt.verification.sdk.internal.sl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
public final class StorySlideView extends ConstraintLayout {
    private sj E;
    private ik F;
    private hk<? extends sj> G;
    private final Map<KClass<? extends sj>, hk<? extends sj>> H;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Unit> {
        a(Object obj) {
            super(0, obj, StorySlideView.class, "onSlideDownFling", "onSlideDownFling()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            j();
            return Unit.f50853a;
        }

        public final void j() {
            ((StorySlideView) this.f50989g).L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<PointF, Unit> {
        b(Object obj) {
            super(1, obj, StorySlideView.class, "onSlideTap", "onSlideTap(Landroid/graphics/PointF;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PointF pointF) {
            j(pointF);
            return Unit.f50853a;
        }

        public final void j(PointF p02) {
            Intrinsics.f(p02, "p0");
            ((StorySlideView) this.f50989g).D(p02);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public /* synthetic */ class c extends FunctionReferenceImpl implements Function0<Unit> {
        c(Object obj) {
            super(0, obj, StorySlideView.class, "onSlideDownFling", "onSlideDownFling()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            j();
            return Unit.f50853a;
        }

        public final void j() {
            ((StorySlideView) this.f50989g).L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<PointF, Unit> {
        d(Object obj) {
            super(1, obj, StorySlideView.class, "onSlideTap", "onSlideTap(Landroid/graphics/PointF;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PointF pointF) {
            j(pointF);
            return Unit.f50853a;
        }

        public final void j(PointF p02) {
            Intrinsics.f(p02, "p0");
            ((StorySlideView) this.f50989g).D(p02);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StorySlideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorySlideView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.H = new LinkedHashMap();
    }

    public /* synthetic */ StorySlideView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final hk<? extends sj> B(sj sjVar) {
        hk<? extends sj> rlVar;
        Function0<Unit> cVar;
        Function1<? super PointF, Unit> dVar;
        ik ikVar = null;
        if (sjVar instanceof sj.c) {
            Context context = getContext();
            Intrinsics.e(context, "context");
            ik ikVar2 = this.F;
            if (ikVar2 == null) {
                Intrinsics.w(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            } else {
                ikVar = ikVar2;
            }
            rlVar = new sl(context, ikVar);
            cVar = new a(this);
            dVar = new b(this);
        } else if (!(sjVar instanceof sj.a)) {
            throw new NoWhenBranchMatchedException();
        } else {
            Context context2 = getContext();
            Intrinsics.e(context2, "context");
            ik ikVar3 = this.F;
            if (ikVar3 == null) {
                Intrinsics.w(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            } else {
                ikVar = ikVar3;
            }
            rlVar = new rl(context2, ikVar);
            cVar = new c(this);
            dVar = new d(this);
        }
        rlVar.f(sjVar, this, cVar, dVar);
        return rlVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(PointF pointF) {
        ik ikVar = this.F;
        if (ikVar == null) {
            Intrinsics.w(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            ikVar = null;
        }
        ikVar.f(pointF);
    }

    private final hk<? extends sj> G(sj sjVar) {
        Map<KClass<? extends sj>, hk<? extends sj>> map = this.H;
        KClass<? extends sj> b8 = Reflection.b(sjVar.getClass());
        hk<? extends sj> hkVar = map.get(b8);
        if (hkVar == null) {
            hkVar = B(sjVar);
            map.put(b8, hkVar);
        }
        return hkVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        ik ikVar = this.F;
        if (ikVar == null) {
            Intrinsics.w(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            ikVar = null;
        }
        ikVar.a();
    }

    public final void C() {
        hk<? extends sj> hkVar = this.G;
        if (hkVar != null) {
            hkVar.l();
        }
    }

    public final void H() {
        hk<? extends sj> hkVar = this.G;
        if (hkVar != null) {
            hkVar.r();
        }
    }

    public final void I() {
        hk<? extends sj> hkVar = this.G;
        if (hkVar != null) {
            hkVar.t();
        }
    }

    public final void J(sj slide) {
        Intrinsics.f(slide, "slide");
        if (slide instanceof sj.c) {
            hk<? extends sj> G = G(slide);
            Intrinsics.d(G, "null cannot be cast to non-null type eu.bolt.client.stories.view.storyslide.decorator.TopLeftContentSlideDecorator");
            ((sl) G).A((sj.c) slide);
        } else if (!(slide instanceof sj.a)) {
            throw new NoWhenBranchMatchedException();
        } else {
            hk<? extends sj> G2 = G(slide);
            Intrinsics.d(G2, "null cannot be cast to non-null type eu.bolt.client.stories.view.storyslide.decorator.TopArrayContentWithFooterSlideDecorator");
            ((rl) G2).F((sj.a) slide);
        }
    }

    public final void K() {
        hk<? extends sj> hkVar = this.G;
        if (hkVar != null) {
            hkVar.v();
        }
    }

    public final void setListener(ik listener) {
        Intrinsics.f(listener, "listener");
        this.F = listener;
    }

    public final void setSlide(sj slide) {
        ConstraintLayout n8;
        Intrinsics.f(slide, "slide");
        this.E = slide;
        hk<? extends sj> G = G(slide);
        G.i(slide);
        if (!Intrinsics.a(G, this.G)) {
            hk<? extends sj> hkVar = this.G;
            if (hkVar != null && (n8 = hkVar.n()) != null) {
                removeView(n8);
            }
            addView(G.n());
        }
        this.G = G;
    }
}
