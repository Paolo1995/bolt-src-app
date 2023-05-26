package ee.mtakso.driver.ui.screens.home.v3;

import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeViewModel.kt */
/* loaded from: classes3.dex */
public /* synthetic */ class HomeViewModel$showOnlineSettings$3 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeViewModel$showOnlineSettings$3(Object obj) {
        super(1, obj, LiveEvent.class, "setValue", "setValue(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        j(str);
        return Unit.f50853a;
    }

    public final void j(String str) {
        ((LiveEvent) this.f50989g).o(str);
    }
}
