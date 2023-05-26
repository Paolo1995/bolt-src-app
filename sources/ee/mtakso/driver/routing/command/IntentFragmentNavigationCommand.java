package ee.mtakso.driver.routing.command;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentNavigationCommand.kt */
/* loaded from: classes3.dex */
public final class IntentFragmentNavigationCommand extends FragmentNavigationCommand {

    /* renamed from: a  reason: collision with root package name */
    private final Intent f23364a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f23365b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f23366c;

    public /* synthetic */ IntentFragmentNavigationCommand(Intent intent, Integer num, Integer num2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(intent, (i8 & 2) != 0 ? null : num, (i8 & 4) != 0 ? null : num2);
    }

    @Override // ee.mtakso.driver.routing.command.NavigationCommand
    /* renamed from: b */
    public void a(Fragment context) {
        Intrinsics.f(context, "context");
        Integer num = this.f23366c;
        if (num != null) {
            this.f23364a.addFlags(num.intValue());
        }
        Integer num2 = this.f23365b;
        if (num2 != null) {
            context.startActivityForResult(this.f23364a, num2.intValue());
        } else {
            context.startActivity(this.f23364a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntentFragmentNavigationCommand(Intent intent, Integer num, Integer num2) {
        super(null);
        Intrinsics.f(intent, "intent");
        this.f23364a = intent;
        this.f23365b = num;
        this.f23366c = num2;
    }
}
