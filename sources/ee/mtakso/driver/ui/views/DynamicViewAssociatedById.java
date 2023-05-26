package ee.mtakso.driver.ui.views;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.VirtualLayout;
import ee.mtakso.driver.ui.views.DynamicViewAssociatedById;
import ee.mtakso.driver.ui.views.DynamicViewAssociatedById.ViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: DynamicViewAssociatedById.kt */
/* loaded from: classes5.dex */
public final class DynamicViewAssociatedById<VH extends ViewHolder> {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f34307g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Function1<VH, Unit> f34308a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<VH, Unit> f34309b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<VH, Unit> f34310c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<VH> f34311d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Object, VH> f34312e;

    /* renamed from: f  reason: collision with root package name */
    private final List<VH> f34313f;

    /* compiled from: DynamicViewAssociatedById.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <VH extends ViewHolder> DynamicViewAssociatedById<VH> a(final ViewGroup viewGroup, List<? extends VH> buffer, Function0<? extends VH> inflater) {
            Intrinsics.f(viewGroup, "viewGroup");
            Intrinsics.f(buffer, "buffer");
            Intrinsics.f(inflater, "inflater");
            return new DynamicViewAssociatedById<>(buffer, new Function1<VH, Unit>() { // from class: ee.mtakso.driver.ui.views.DynamicViewAssociatedById$Companion$createFromViewGroup$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TVH;)V */
                public final void b(DynamicViewAssociatedById.ViewHolder vh) {
                    Intrinsics.f(vh, "vh");
                    viewGroup.addView(vh.getView());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    b((DynamicViewAssociatedById.ViewHolder) obj);
                    return Unit.f50853a;
                }
            }, new Function1<VH, Unit>() { // from class: ee.mtakso.driver.ui.views.DynamicViewAssociatedById$Companion$createFromViewGroup$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TVH;)V */
                public final void b(DynamicViewAssociatedById.ViewHolder vh) {
                    Intrinsics.f(vh, "vh");
                    viewGroup.removeView(vh.getView());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    b((DynamicViewAssociatedById.ViewHolder) obj);
                    return Unit.f50853a;
                }
            }, new Function1<VH, Unit>() { // from class: ee.mtakso.driver.ui.views.DynamicViewAssociatedById$Companion$createFromViewGroup$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TVH;)V */
                public final void b(DynamicViewAssociatedById.ViewHolder vh) {
                    Intrinsics.f(vh, "vh");
                    viewGroup.bringChildToFront(vh.getView());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    b((DynamicViewAssociatedById.ViewHolder) obj);
                    return Unit.f50853a;
                }
            }, inflater, null);
        }

        public final <VH extends ViewHolder> DynamicViewAssociatedById<VH> b(final ConstraintLayout constraintLayout, final VirtualLayout virtualLayout, List<? extends VH> buffer, Function0<? extends VH> inflater) {
            Intrinsics.f(constraintLayout, "constraintLayout");
            Intrinsics.f(virtualLayout, "virtualLayout");
            Intrinsics.f(buffer, "buffer");
            Intrinsics.f(inflater, "inflater");
            return new DynamicViewAssociatedById<>(buffer, new Function1<VH, Unit>() { // from class: ee.mtakso.driver.ui.views.DynamicViewAssociatedById$Companion$createFromVirtualLayout$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TVH;)V */
                public final void b(DynamicViewAssociatedById.ViewHolder vh) {
                    int[] q8;
                    Intrinsics.f(vh, "vh");
                    ConstraintLayout.this.addView(vh.getView());
                    VirtualLayout virtualLayout2 = virtualLayout;
                    int[] referencedIds = virtualLayout2.getReferencedIds();
                    Intrinsics.e(referencedIds, "virtualLayout.referencedIds");
                    q8 = ArraysKt___ArraysJvmKt.q(referencedIds, vh.getView().getId());
                    virtualLayout2.setReferencedIds(q8);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    b((DynamicViewAssociatedById.ViewHolder) obj);
                    return Unit.f50853a;
                }
            }, new Function1<VH, Unit>() { // from class: ee.mtakso.driver.ui.views.DynamicViewAssociatedById$Companion$createFromVirtualLayout$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TVH;)V */
                public final void b(DynamicViewAssociatedById.ViewHolder vh) {
                    int[] G0;
                    boolean z7;
                    Intrinsics.f(vh, "vh");
                    VirtualLayout virtualLayout2 = VirtualLayout.this;
                    int[] referencedIds = virtualLayout2.getReferencedIds();
                    Intrinsics.e(referencedIds, "virtualLayout.referencedIds");
                    ArrayList arrayList = new ArrayList();
                    for (int i8 : referencedIds) {
                        if (i8 != vh.getView().getId()) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z7) {
                            arrayList.add(Integer.valueOf(i8));
                        }
                    }
                    G0 = CollectionsKt___CollectionsKt.G0(arrayList);
                    virtualLayout2.setReferencedIds(G0);
                    constraintLayout.removeView(vh.getView());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    b((DynamicViewAssociatedById.ViewHolder) obj);
                    return Unit.f50853a;
                }
            }, new Function1<VH, Unit>() { // from class: ee.mtakso.driver.ui.views.DynamicViewAssociatedById$Companion$createFromVirtualLayout$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TVH;)V */
                public final void b(DynamicViewAssociatedById.ViewHolder vh) {
                    Intrinsics.f(vh, "vh");
                    ConstraintLayout.this.bringChildToFront(vh.getView());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    b((DynamicViewAssociatedById.ViewHolder) obj);
                    return Unit.f50853a;
                }
            }, inflater, null);
        }
    }

    /* compiled from: DynamicViewAssociatedById.kt */
    /* loaded from: classes5.dex */
    public interface ViewHolder {
        View getView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DynamicViewAssociatedById(List<? extends VH> list, Function1<? super VH, Unit> function1, Function1<? super VH, Unit> function12, Function1<? super VH, Unit> function13, Function0<? extends VH> function0) {
        this.f34308a = function1;
        this.f34309b = function12;
        this.f34310c = function13;
        this.f34311d = function0;
        this.f34312e = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        this.f34313f = arrayList;
    }

    public /* synthetic */ DynamicViewAssociatedById(List list, Function1 function1, Function1 function12, Function1 function13, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, function1, function12, function13, function0);
    }

    private final void a(VH vh) {
        if (vh.getView().getParent() == null) {
            this.f34308a.invoke(vh);
        } else {
            this.f34310c.invoke(vh);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(int i8, Function1<? super Integer, ? extends Object> idSelector, Function2<? super VH, ? super Integer, Unit> binder) {
        Set<Object> K0;
        IntRange o8;
        Object K;
        Intrinsics.f(idSelector, "idSelector");
        Intrinsics.f(binder, "binder");
        K0 = CollectionsKt___CollectionsKt.K0(this.f34312e.keySet());
        o8 = RangesKt___RangesKt.o(0, i8);
        Iterator<Integer> it = o8.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            Object invoke = idSelector.invoke(Integer.valueOf(nextInt));
            K0.remove(invoke);
            VH vh = this.f34312e.get(invoke);
            if (vh == null) {
                K = CollectionsKt__MutableCollectionsKt.K(this.f34313f);
                vh = (ViewHolder) K;
                if (vh != null) {
                    this.f34312e.put(invoke, vh);
                } else {
                    vh = null;
                }
                if (vh == null) {
                    vh = this.f34311d.invoke();
                    vh.getView().setId(View.generateViewId());
                    this.f34312e.put(invoke, vh);
                }
            }
            a(vh);
            binder.s(vh, Integer.valueOf(nextInt));
        }
        for (Object obj : K0) {
            VH remove = this.f34312e.remove(obj);
            if (remove != null) {
                this.f34313f.add(remove);
            }
        }
        for (VH vh2 : this.f34313f) {
            if (vh2.getView().getParent() != null) {
                this.f34309b.invoke(vh2);
            }
        }
    }
}
