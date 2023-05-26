package ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding;

import ee.mtakso.driver.R;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBoardingFlows.kt */
/* loaded from: classes3.dex */
public final class DocumentsOnBoardingStepsResolver {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f28456a = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private static final Map<DocumentsOnBoardingType, List<DocumentsOnBoardingStep>> f28457b;

    /* compiled from: OnBoardingFlows.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        List n8;
        Map<DocumentsOnBoardingType, List<DocumentsOnBoardingStep>> k8;
        DocumentsOnBoardingType documentsOnBoardingType = DocumentsOnBoardingType.TEST;
        n8 = CollectionsKt__CollectionsKt.n(new DocumentsOnBoardingStep("the_only_step", R.raw.test_docs_flow, R.string.voip_notification_title, R.string.voip_notification_channel_description), new DocumentsOnBoardingStep("the_only_step", R.raw.test_docs_flow, R.string.voip_notification_title, R.string.voip_notification_channel_description));
        k8 = MapsKt__MapsKt.k(TuplesKt.a(documentsOnBoardingType, n8));
        f28457b = k8;
    }

    public final List<DocumentsOnBoardingStep> a(DocumentsOnBoardingType onBoardingType) {
        Intrinsics.f(onBoardingType, "onBoardingType");
        List<DocumentsOnBoardingStep> list = f28457b.get(onBoardingType);
        if (list == null) {
            List<DocumentsOnBoardingStep> emptyList = Collections.emptyList();
            Intrinsics.e(emptyList, "emptyList()");
            return emptyList;
        }
        return list;
    }
}
