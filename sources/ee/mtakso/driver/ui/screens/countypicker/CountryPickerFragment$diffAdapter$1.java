package ee.mtakso.driver.ui.screens.countypicker;

import ee.mtakso.driver.ui.screens.countypicker.item.CountryItemDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CountryPickerFragment.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class CountryPickerFragment$diffAdapter$1 extends FunctionReferenceImpl implements Function1<CountryItemDelegate.Model, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CountryPickerFragment$diffAdapter$1(Object obj) {
        super(1, obj, CountryPickerFragment.class, "handleClick", "handleClick(Lee/mtakso/driver/ui/screens/countypicker/item/CountryItemDelegate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CountryItemDelegate.Model model) {
        j(model);
        return Unit.f50853a;
    }

    public final void j(CountryItemDelegate.Model p02) {
        Intrinsics.f(p02, "p0");
        ((CountryPickerFragment) this.f50989g).a0(p02);
    }
}
