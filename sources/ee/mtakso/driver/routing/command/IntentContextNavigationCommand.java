package ee.mtakso.driver.routing.command;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextNavigationCommand.kt */
/* loaded from: classes3.dex */
public final class IntentContextNavigationCommand extends ContextNavigationCommand {

    /* renamed from: a  reason: collision with root package name */
    private final Intent f23362a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f23363b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntentContextNavigationCommand(Intent intent, int[] flags) {
        super(null);
        Intrinsics.f(intent, "intent");
        Intrinsics.f(flags, "flags");
        this.f23362a = intent;
        this.f23363b = flags;
    }

    @Override // ee.mtakso.driver.routing.command.NavigationCommand
    /* renamed from: b */
    public void a(Context context) {
        Intrinsics.f(context, "context");
        for (int i8 : this.f23363b) {
            this.f23362a.addFlags(i8);
        }
        context.startActivity(this.f23362a);
    }
}
