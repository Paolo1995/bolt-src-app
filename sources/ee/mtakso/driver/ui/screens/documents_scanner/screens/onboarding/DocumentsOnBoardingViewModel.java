package ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentsOnBoardingViewModel.kt */
/* loaded from: classes3.dex */
public final class DocumentsOnBoardingViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DocumentsOnBoardingStepsResolver f28461f;

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<List<DocumentsOnBoardingStep>> f28462g;

    @Inject
    public DocumentsOnBoardingViewModel(DocumentsOnBoardingStepsResolver documentsOnBoardingStepsResolver) {
        Intrinsics.f(documentsOnBoardingStepsResolver, "documentsOnBoardingStepsResolver");
        this.f28461f = documentsOnBoardingStepsResolver;
        this.f28462g = new MutableLiveData<>();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final LiveData<List<DocumentsOnBoardingStep>> D() {
        return this.f28462g;
    }

    public final void E(DocumentsOnBoardingType type) {
        Intrinsics.f(type, "type");
        this.f28462g.o(this.f28461f.a(type));
    }
}
