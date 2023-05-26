package ee.mtakso.driver.ui.screens.history.details.file_upload;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.audio_recording.WebAppLaunchParams;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel;
import ee.mtakso.driver.ui.screens.history.details.file_upload.FileUploadConfirmationDialog;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.AudioRecordingMapper;
import ee.mtakso.driver.uicore.utils.ContextUtils;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.android.audio_recording_engine.engine.RecordingProperties;
import eu.bolt.android.audio_recording_engine.exception.NotEnoughStorageException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUploadConfirmationDialog.kt */
/* loaded from: classes3.dex */
public final class FileUploadConfirmationDialog extends BaseMvvmDialogFragment<OrderHistoryDetailsViewModel> {

    /* renamed from: o  reason: collision with root package name */
    public static final Companion f29539o = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private final AudioRecordingMapper f29540l;

    /* renamed from: m  reason: collision with root package name */
    private final Lazy f29541m;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, View> f29542n;

    /* compiled from: FileUploadConfirmationDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(OrderHandle orderHandle) {
            Intrinsics.f(orderHandle, "orderHandle");
            Bundle bundle = new Bundle();
            bundle.putParcelable("orderHandle", orderHandle);
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public FileUploadConfirmationDialog(BaseUiDependencies deps, AudioRecordingMapper audioRecordingMapper) {
        super(deps, R.layout.dialog_file_upload_confirmation);
        Lazy b8;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(audioRecordingMapper, "audioRecordingMapper");
        this.f29542n = new LinkedHashMap();
        this.f29540l = audioRecordingMapper;
        b8 = LazyKt__LazyJVMKt.b(new Function0<OrderHandle>() { // from class: ee.mtakso.driver.ui.screens.history.details.file_upload.FileUploadConfirmationDialog$orderHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final OrderHandle invoke() {
                Parcelable parcelable = FileUploadConfirmationDialog.this.requireArguments().getParcelable("orderHandle");
                if (parcelable != null) {
                    return (OrderHandle) parcelable;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
        this.f29541m = b8;
    }

    private final OrderHandle a0() {
        return (OrderHandle) this.f29541m.getValue();
    }

    private final String b0(RecordingProperties recordingProperties) {
        if (recordingProperties != null) {
            long c8 = recordingProperties.c();
            AudioRecordingMapper audioRecordingMapper = this.f29540l;
            String string = getString(R.string.size_kb);
            Intrinsics.e(string, "getString(R.string.size_kb)");
            String string2 = getString(R.string.size_mb);
            Intrinsics.e(string2, "getString(R.string.size_mb)");
            String string3 = getString(R.string.size_gb);
            Intrinsics.e(string3, "getString(R.string.size_gb)");
            String a8 = audioRecordingMapper.a(c8, string, string2, string3);
            if (a8 != null) {
                return a8;
            }
        }
        return "";
    }

    private final void c0(OrderHandle orderHandle) {
        H().X0(orderHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        dismissAllowingStateLoss();
        H().Y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(WebAppLaunchParams webAppLaunchParams) {
        dismissAllowingStateLoss();
        H().l0(webAppLaunchParams.a());
    }

    private final void f0() {
        LiveData<Boolean> A0 = H().A0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.file_upload.FileUploadConfirmationDialog$observeLoaderProgress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean isLoading) {
                Intrinsics.e(isLoading, "isLoading");
                if (isLoading.booleanValue()) {
                    ((RoundButton) FileUploadConfirmationDialog.this.V(R.id.sendButton)).k();
                } else {
                    ((RoundButton) FileUploadConfirmationDialog.this.V(R.id.sendButton)).g();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        A0.i(viewLifecycleOwner, new Observer() { // from class: u3.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FileUploadConfirmationDialog.g0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void h0() {
        LiveEvent<Result<WebAppLaunchParams>> I0 = H().I0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner, "viewLifecycleOwner");
        final Function1<Result<? extends WebAppLaunchParams>, Unit> function1 = new Function1<Result<? extends WebAppLaunchParams>, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.file_upload.FileUploadConfirmationDialog$observeWebAppParamsResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Result<? extends WebAppLaunchParams> webAppLaunchParamsResult) {
                OrderHistoryDetailsViewModel H;
                OrderHistoryDetailsViewModel H2;
                Intrinsics.e(webAppLaunchParamsResult, "webAppLaunchParamsResult");
                Object j8 = webAppLaunchParamsResult.j();
                FileUploadConfirmationDialog fileUploadConfirmationDialog = FileUploadConfirmationDialog.this;
                if (Result.h(j8)) {
                    WebAppLaunchParams webAppLaunchParams = (WebAppLaunchParams) j8;
                    Object j9 = webAppLaunchParamsResult.j();
                    if (Result.g(j9)) {
                        j9 = null;
                    }
                    WebAppLaunchParams webAppLaunchParams2 = (WebAppLaunchParams) j9;
                    if (webAppLaunchParams2 != null) {
                        fileUploadConfirmationDialog.e0(webAppLaunchParams2);
                    } else {
                        fileUploadConfirmationDialog.d0();
                    }
                }
                FileUploadConfirmationDialog fileUploadConfirmationDialog2 = FileUploadConfirmationDialog.this;
                Throwable e8 = Result.e(j8);
                if (e8 != null) {
                    if (e8 instanceof NotEnoughStorageException) {
                        fileUploadConfirmationDialog2.dismissAllowingStateLoss();
                        H2 = fileUploadConfirmationDialog2.H();
                        H2.j0();
                    } else if (e8 instanceof CancellationException) {
                        H = fileUploadConfirmationDialog2.H();
                        H.h0();
                    } else {
                        fileUploadConfirmationDialog2.d0();
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends WebAppLaunchParams> result) {
                b(result);
                return Unit.f50853a;
            }
        };
        I0.i(viewLifecycleOwner, new Observer() { // from class: u3.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FileUploadConfirmationDialog.i0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(FileUploadConfirmationDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.H().Q0();
        OrderHandle orderHandle = this$0.a0();
        Intrinsics.e(orderHandle, "orderHandle");
        this$0.c0(orderHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(FileUploadConfirmationDialog this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.H().P0();
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(RecordingProperties recordingProperties) {
        ((AppCompatTextView) V(R.id.tb)).setText(getString(R.string.send_audio_to_cs_subtitle, b0(recordingProperties)));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment
    public void F() {
        this.f29542n.clear();
    }

    public View V(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f29542n;
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
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment
    /* renamed from: m0 */
    public OrderHistoryDetailsViewModel N() {
        BaseUiDependencies baseUiDependencies;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        baseUiDependencies = ((BaseMvvmDialogFragment) this).f26249f;
        return (OrderHistoryDetailsViewModel) new ViewModelProvider(requireActivity, baseUiDependencies.d()).a(OrderHistoryDetailsViewModel.class);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        F();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        Window window2;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.85f;
            window.setAttributes(attributes);
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            int i8 = ContextUtils.a(requireContext).widthPixels;
            Dialog dialog2 = getDialog();
            if (dialog2 != null && (window2 = dialog2.getWindow()) != null) {
                window2.setLayout((int) (i8 * 0.8d), -2);
            }
            window.setBackgroundDrawableResource(R.drawable.rounded_dialog);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        LiveData<RecordingProperties> D0 = H().D0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<RecordingProperties, Unit> function1 = new Function1<RecordingProperties, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.file_upload.FileUploadConfirmationDialog$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(RecordingProperties recordingProperties) {
                FileUploadConfirmationDialog.this.n0(recordingProperties);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecordingProperties recordingProperties) {
                b(recordingProperties);
                return Unit.f50853a;
            }
        };
        D0.i(viewLifecycleOwner, new Observer() { // from class: u3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FileUploadConfirmationDialog.j0(Function1.this, obj);
            }
        });
        ((RoundButton) V(R.id.sendButton)).setOnClickListener(new View.OnClickListener() { // from class: u3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FileUploadConfirmationDialog.k0(FileUploadConfirmationDialog.this, view2);
            }
        });
        ((RoundButton) V(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: u3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FileUploadConfirmationDialog.l0(FileUploadConfirmationDialog.this, view2);
            }
        });
        f0();
        h0();
        H().R0();
    }
}
