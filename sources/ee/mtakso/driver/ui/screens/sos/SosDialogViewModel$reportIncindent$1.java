package ee.mtakso.driver.ui.screens.sos;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SosDialogViewModel.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class SosDialogViewModel$reportIncindent$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SosDialogViewModel$reportIncindent$1(Object obj) {
        super(1, obj, SosDialogViewModel.class, "handleIncidentReportingResult", "handleIncidentReportingResult(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        j(bool.booleanValue());
        return Unit.f50853a;
    }

    public final void j(boolean z7) {
        ((SosDialogViewModel) this.f50989g).P(z7);
    }
}
