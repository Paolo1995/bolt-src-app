package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import ee.mtakso.driver.uicore.components.recyclerview.delegates.common.TwoLinesItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SafetyToolkitBottomSheetFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class SafetyToolkitBottomSheetFragment$diffAdapter$3 extends FunctionReferenceImpl implements Function1<TwoLinesItemDelegate.Model<SafetyFeature>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SafetyToolkitBottomSheetFragment$diffAdapter$3(Object obj) {
        super(1, obj, SafetyToolkitBottomSheetFragment.class, "handleItemClick", "handleItemClick(Lee/mtakso/driver/uicore/components/recyclerview/delegates/common/TwoLinesItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TwoLinesItemDelegate.Model<SafetyFeature> model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(TwoLinesItemDelegate.Model<SafetyFeature> p02) {
        Intrinsics.f(p02, "p0");
        ((SafetyToolkitBottomSheetFragment) this.f50989g).r0(p02);
    }
}
