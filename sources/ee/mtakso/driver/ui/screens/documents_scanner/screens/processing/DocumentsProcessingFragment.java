package ee.mtakso.driver.ui.screens.documents_scanner.screens.processing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.routing.command.NavigationCommand;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsRouterDelegate;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.DocumentsScannerViewModel;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.processing.DocumentsProcessingFragment;
import ee.mtakso.driver.ui.screens.documents_scanner.source.SourceType;
import ee.mtakso.driver.uikit.utils.image.ImageManager;
import ee.mtakso.driver.uikit.utils.image.ImageRequest;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentsProcessingFragment.kt */
/* loaded from: classes3.dex */
public final class DocumentsProcessingFragment extends BazeMvvmFragment<DocumentsScannerViewModel> {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f28464p = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    public Map<Integer, View> f28465o;

    /* compiled from: DocumentsProcessingFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(SourceType sourceType) {
            Intrinsics.f(sourceType, "sourceType");
            Bundle bundle = new Bundle();
            bundle.putSerializable("args.source_type", sourceType);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public DocumentsProcessingFragment(BaseUiDependencies deps) {
        super(deps, R.layout.fragment_documents_processing, null, 4, null);
        Intrinsics.f(deps, "deps");
        this.f28465o = new LinkedHashMap();
    }

    private final SourceType Y() {
        Serializable serializable;
        Bundle arguments = getArguments();
        if (arguments != null) {
            serializable = arguments.getSerializable("args.source_type");
        } else {
            serializable = null;
        }
        Intrinsics.d(serializable, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.documents_scanner.source.SourceType");
        return (SourceType) serializable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(DocumentsProcessingFragment this$0, NavigationCommand navigationCommand) {
        Intrinsics.f(this$0, "this$0");
        navigationCommand.a(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(DocumentsProcessingFragment this$0, Uri uri) {
        Intrinsics.f(this$0, "this$0");
        ImageManager b8 = ImageManager.Companion.b(ImageManager.f36075b, null, 1, null);
        String uri2 = uri.toString();
        Intrinsics.e(uri2, "uri.toString()");
        ImageRequest imageRequest = new ImageRequest(uri2, null, null, null, 14, null);
        AppCompatImageView photoImageView = (AppCompatImageView) this$0.X(R.id.photoImageView);
        Intrinsics.e(photoImageView, "photoImageView");
        b8.c(imageRequest, photoImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(DocumentsProcessingFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(DocumentsProcessingFragment this$0, View view) {
        DocumentsRouterDelegate documentsRouterDelegate;
        Intrinsics.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity instanceof DocumentsRouterDelegate) {
            documentsRouterDelegate = (DocumentsRouterDelegate) activity;
        } else {
            documentsRouterDelegate = null;
        }
        if (documentsRouterDelegate != null) {
            documentsRouterDelegate.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(DocumentsProcessingFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(DocumentsProcessingFragment this$0, View view) {
        DocumentsRouterDelegate documentsRouterDelegate;
        Intrinsics.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity instanceof DocumentsRouterDelegate) {
            documentsRouterDelegate = (DocumentsRouterDelegate) activity;
        } else {
            documentsRouterDelegate = null;
        }
        if (documentsRouterDelegate != null) {
            documentsRouterDelegate.D();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.f28465o.clear();
    }

    public View X(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f28465o;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: f0 */
    public DocumentsScannerViewModel Q() {
        BaseUiDependencies E;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        E = E();
        return (DocumentsScannerViewModel) new ViewModelProvider(requireActivity, E.d()).a(DocumentsScannerViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i8, int i9, Intent intent) {
        super.onActivityResult(i8, i9, intent);
        M().P(i8, i9, intent);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        M().Q(Y());
        M().N().i(getViewLifecycleOwner(), new Observer() { // from class: k3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DocumentsProcessingFragment.Z(DocumentsProcessingFragment.this, (NavigationCommand) obj);
            }
        });
        M().O().i(getViewLifecycleOwner(), new Observer() { // from class: k3.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DocumentsProcessingFragment.a0(DocumentsProcessingFragment.this, (Uri) obj);
            }
        });
        ((AppCompatImageView) X(R.id.backButton)).setOnClickListener(new View.OnClickListener() { // from class: k3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DocumentsProcessingFragment.b0(DocumentsProcessingFragment.this, view2);
            }
        });
        ((AppCompatImageView) X(R.id.postProcessingButton)).setOnClickListener(new View.OnClickListener() { // from class: k3.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DocumentsProcessingFragment.c0(DocumentsProcessingFragment.this, view2);
            }
        });
        M().W();
        ((RoundButton) X(R.id.retakePhotoButton)).setOnClickListener(new View.OnClickListener() { // from class: k3.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DocumentsProcessingFragment.d0(DocumentsProcessingFragment.this, view2);
            }
        });
        ((AppCompatImageView) X(R.id.infoButton)).setOnClickListener(new View.OnClickListener() { // from class: k3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DocumentsProcessingFragment.e0(DocumentsProcessingFragment.this, view2);
            }
        });
    }
}
