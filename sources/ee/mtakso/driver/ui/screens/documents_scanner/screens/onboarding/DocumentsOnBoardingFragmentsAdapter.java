package ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentsOnBoardingFragmentsAdapter.kt */
/* loaded from: classes3.dex */
public final class DocumentsOnBoardingFragmentsAdapter extends FragmentStateAdapter {

    /* renamed from: l  reason: collision with root package name */
    private final FragmentActivity f28446l;

    /* renamed from: m  reason: collision with root package name */
    private final FragmentFactory f28447m;

    /* renamed from: n  reason: collision with root package name */
    private final List<DocumentsOnBoardingStep> f28448n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentsOnBoardingFragmentsAdapter(FragmentActivity fragmentActivity, FragmentFactory fragmentFactory, List<DocumentsOnBoardingStep> documentsFlowSteps) {
        super(fragmentActivity);
        Intrinsics.f(fragmentActivity, "fragmentActivity");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(documentsFlowSteps, "documentsFlowSteps");
        this.f28446l = fragmentActivity;
        this.f28447m = fragmentFactory;
        this.f28448n = documentsFlowSteps;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment R(int i8) {
        return FragmentFactoryUtils.b(this.f28447m, this.f28446l, DocumentsOnBoardingStepFragment.class, DocumentsOnBoardingStepFragment.f28453p.a(this.f28448n.get(i8)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int r() {
        return this.f28448n.size();
    }
}
