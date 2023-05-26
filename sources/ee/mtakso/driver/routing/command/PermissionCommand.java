package ee.mtakso.driver.routing.command;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentNavigationCommand.kt */
/* loaded from: classes3.dex */
public final class PermissionCommand extends FragmentNavigationCommand {

    /* renamed from: a  reason: collision with root package name */
    private final String f23367a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23368b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionCommand(String permission, int i8) {
        super(null);
        Intrinsics.f(permission, "permission");
        this.f23367a = permission;
        this.f23368b = i8;
    }

    @Override // ee.mtakso.driver.routing.command.NavigationCommand
    /* renamed from: b */
    public void a(Fragment context) {
        Intrinsics.f(context, "context");
        ActivityCompat.g(context.requireActivity(), new String[]{this.f23367a}, this.f23368b);
    }
}
