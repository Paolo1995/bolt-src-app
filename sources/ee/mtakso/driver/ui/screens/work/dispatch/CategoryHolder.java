package ee.mtakso.driver.ui.screens.work.dispatch;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.widgets.CustomCheckBox;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CategoryHolder.kt */
/* loaded from: classes5.dex */
public final class CategoryHolder extends RecyclerView.ViewHolder {

    /* renamed from: u  reason: collision with root package name */
    private final View f33956u;

    /* renamed from: v  reason: collision with root package name */
    private final CustomCheckBox f33957v;

    /* renamed from: w  reason: collision with root package name */
    private final TextView f33958w;

    /* renamed from: x  reason: collision with root package name */
    private final ImageButton f33959x;

    /* renamed from: y  reason: collision with root package name */
    private final Chip f33960y;

    /* renamed from: z  reason: collision with root package name */
    public Map<Integer, View> f33961z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryHolder(View containerView, final Function2<? super Integer, ? super Boolean, Unit> checkedCallback, final Function1<? super Integer, Unit> surgeButtonCallback) {
        super(containerView);
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(checkedCallback, "checkedCallback");
        Intrinsics.f(surgeButtonCallback, "surgeButtonCallback");
        this.f33961z = new LinkedHashMap();
        this.f33956u = containerView;
        CustomCheckBox customCheckBox = (CustomCheckBox) U().findViewById(R.id.checkBox);
        Intrinsics.e(customCheckBox, "containerView.checkBox");
        this.f33957v = customCheckBox;
        TextView textView = (TextView) U().findViewById(R.id.cc);
        Intrinsics.e(textView, "containerView.title");
        this.f33958w = textView;
        ImageButton imageButton = (ImageButton) U().findViewById(R.id.surgeButton);
        Intrinsics.e(imageButton, "containerView.surgeButton");
        this.f33959x = imageButton;
        Chip chip = (Chip) U().findViewById(R.id.chip);
        Intrinsics.e(chip, "containerView.chip");
        this.f33960y = chip;
        Color.Attr attr = new Color.Attr(R.attr.backPrimary);
        Context context = U().getContext();
        Intrinsics.e(context, "containerView.context");
        RippleProvider.b(RippleProvider.f35730a, U(), ColorKt.a(attr, context), 0, 2, null);
        Color.Attr attr2 = new Color.Attr(R.attr.dynamicPurple02);
        Context context2 = U().getContext();
        Intrinsics.e(context2, "containerView.context");
        customCheckBox.setCheckedColor(ColorKt.a(attr2, context2));
        U().setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryHolder.Q(CategoryHolder.this, view);
            }
        });
        customCheckBox.setListener(new CustomCheckBox.OnCheckedChangeListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.CategoryHolder.2
            @Override // ee.mtakso.driver.uikit.widgets.CustomCheckBox.OnCheckedChangeListener
            public void a(CustomCheckBox checkBox, boolean z7) {
                Intrinsics.f(checkBox, "checkBox");
                checkedCallback.s(Integer.valueOf(this.k()), Boolean.valueOf(z7));
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryHolder.R(Function1.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(CategoryHolder this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f33957v.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 surgeButtonCallback, CategoryHolder this$0, View view) {
        Intrinsics.f(surgeButtonCallback, "$surgeButtonCallback");
        Intrinsics.f(this$0, "this$0");
        surgeButtonCallback.invoke(Integer.valueOf(this$0.k()));
    }

    public final CustomCheckBox S() {
        return this.f33957v;
    }

    public final Chip T() {
        return this.f33960y;
    }

    public View U() {
        return this.f33956u;
    }

    public final ImageButton V() {
        return this.f33959x;
    }

    public final TextView W() {
        return this.f33958w;
    }
}
