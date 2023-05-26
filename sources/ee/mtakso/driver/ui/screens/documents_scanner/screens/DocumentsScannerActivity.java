package ee.mtakso.driver.ui.screens.documents_scanner.screens;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.yalantis.ucrop.UCrop;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.ui.base.mvvm.BaseDynamicTranslatedMvvmActivity;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingActivity;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingType;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.processing.DocumentsProcessingFragment;
import ee.mtakso.driver.ui.screens.documents_scanner.source.SourceType;
import ee.mtakso.driver.utils.AssertUtils;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentsScannerActivity.kt */
/* loaded from: classes3.dex */
public final class DocumentsScannerActivity extends BaseDynamicTranslatedMvvmActivity<DocumentsScannerViewModel> implements DocumentsRouterDelegate {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f28410q = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f28411o;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, View> f28412p = new LinkedHashMap();

    /* compiled from: DocumentsScannerActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DocumentsScannerActivity() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DocumentsScannerViewModel>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DocumentsScannerViewModel invoke() {
                DocumentsScannerActivity documentsScannerActivity = DocumentsScannerActivity.this;
                return (DocumentsScannerViewModel) new ViewModelProvider(documentsScannerActivity, documentsScannerActivity.R()).a(DocumentsScannerViewModel.class);
            }
        });
        this.f28411o = b8;
    }

    private final DocumentsOnBoardingType a0() {
        Serializable serializableExtra = getIntent().getSerializableExtra("args.docs_flow_type");
        if (serializableExtra instanceof DocumentsOnBoardingType) {
            return (DocumentsOnBoardingType) serializableExtra;
        }
        return null;
    }

    private final boolean b0() {
        return getIntent().getBooleanExtra("args.should_launch_onboarding_on_start", false);
    }

    private final SourceType c0() {
        Serializable serializableExtra = getIntent().getSerializableExtra("args.source_type");
        Intrinsics.d(serializableExtra, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.documents_scanner.source.SourceType");
        return (SourceType) serializableExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(DocumentsScannerActivity this$0, DocumentsScannerViewModel.InputOutputUri inputOutputUri) {
        Intrinsics.f(this$0, "this$0");
        UCrop of = UCrop.of(inputOutputUri.a(), inputOutputUri.b());
        UCrop.Options options = new UCrop.Options();
        options.setFreeStyleCropEnabled(true);
        of.withOptions(options).start(this$0);
    }

    @Override // ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsRouterDelegate
    public void D() {
        DocumentsOnBoardingType a02 = a0();
        if (a02 == null) {
            AssertUtils.a("Cannot find type for onboarding");
        } else {
            DocumentsOnBoardingActivity.f28440r.a(this, a02);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void T() {
        Injector.f20166d.b().X1().f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    /* renamed from: d0 */
    public DocumentsScannerViewModel Q() {
        return (DocumentsScannerViewModel) this.f28411o.getValue();
    }

    public void f0() {
        if (getSupportFragmentManager().findFragmentByTag("DocumentsProcessingFragment") != null) {
            return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.f277fragmentContainer, (DocumentsProcessingFragment) FragmentFactoryUtils.b(N(), this, DocumentsProcessingFragment.class, DocumentsProcessingFragment.f28464p.a(c0()))).addToBackStack("DocumentsProcessingFragment").commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i8, int i9, Intent intent) {
        Uri output;
        super.onActivityResult(i8, i9, intent);
        if (intent == null || i9 != -1 || i8 != 69 || (output = UCrop.getOutput(intent)) == null) {
            return;
        }
        Q().Z(output);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_documents_scanner);
        Q().Q(c0());
        Q().M().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DocumentsScannerActivity.e0(DocumentsScannerActivity.this, (DocumentsScannerViewModel.InputOutputUri) obj);
            }
        });
        if (b0()) {
            D();
        } else {
            f0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        f0();
    }

    @Override // ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsRouterDelegate
    public void s() {
        Q().T();
    }
}
