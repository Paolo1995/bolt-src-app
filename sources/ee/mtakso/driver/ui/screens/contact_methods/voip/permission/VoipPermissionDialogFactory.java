package ee.mtakso.driver.ui.screens.contact_methods.voip.permission;

import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.VoipPrefsManager;
import ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipPermissionDialogFactory.kt */
/* loaded from: classes3.dex */
public final class VoipPermissionDialogFactory {

    /* renamed from: d  reason: collision with root package name */
    private static final Companion f28076d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final VoipPrefsManager f28077a;

    /* renamed from: b  reason: collision with root package name */
    private final PermissionManager f28078b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f28079c;

    /* compiled from: VoipPermissionDialogFactory.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public VoipPermissionDialogFactory(VoipPrefsManager voipPrefsManager, PermissionManager permissionManager, DriverProvider driverProvider) {
        Intrinsics.f(voipPrefsManager, "voipPrefsManager");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f28077a = voipPrefsManager;
        this.f28078b = permissionManager;
        this.f28079c = driverProvider;
    }

    public final BaseDialogFragment a() {
        PermissionManager.PermissionInfo o8 = this.f28078b.o("android.permission.RECORD_AUDIO");
        if (!this.f28077a.b() && !this.f28079c.t().R()) {
            PermissionManager.Companion companion = PermissionManager.f40899f;
            if (!companion.b(o8) && !companion.a(o8)) {
                VoipFirstTimePermissionDialog voipFirstTimePermissionDialog = new VoipFirstTimePermissionDialog();
                this.f28077a.a();
                return voipFirstTimePermissionDialog;
            }
        }
        return VoipSecondTimePermissionDialog.f28080n.a(PermissionManager.f40899f.a(o8));
    }
}
