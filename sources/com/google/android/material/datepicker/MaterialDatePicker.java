package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    static final Object F = "CONFIRM_BUTTON_TAG";
    static final Object G = "CANCEL_BUTTON_TAG";
    static final Object H = "TOGGLE_BUTTON_TAG";
    private MaterialShapeDrawable A;
    private Button B;
    private boolean C;
    private CharSequence D;
    private CharSequence E;

    /* renamed from: f  reason: collision with root package name */
    private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> f13318f = new LinkedHashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final LinkedHashSet<View.OnClickListener> f13319g = new LinkedHashSet<>();

    /* renamed from: h  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f13320h = new LinkedHashSet<>();

    /* renamed from: i  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f13321i = new LinkedHashSet<>();

    /* renamed from: j  reason: collision with root package name */
    private int f13322j;

    /* renamed from: k  reason: collision with root package name */
    private DateSelector<S> f13323k;

    /* renamed from: l  reason: collision with root package name */
    private PickerFragment<S> f13324l;

    /* renamed from: m  reason: collision with root package name */
    private CalendarConstraints f13325m;

    /* renamed from: n  reason: collision with root package name */
    private DayViewDecorator f13326n;

    /* renamed from: o  reason: collision with root package name */
    private MaterialCalendar<S> f13327o;

    /* renamed from: p  reason: collision with root package name */
    private int f13328p;

    /* renamed from: q  reason: collision with root package name */
    private CharSequence f13329q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f13330r;

    /* renamed from: s  reason: collision with root package name */
    private int f13331s;

    /* renamed from: t  reason: collision with root package name */
    private int f13332t;

    /* renamed from: u  reason: collision with root package name */
    private CharSequence f13333u;

    /* renamed from: v  reason: collision with root package name */
    private int f13334v;

    /* renamed from: w  reason: collision with root package name */
    private CharSequence f13335w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f13336x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f13337y;

    /* renamed from: z  reason: collision with root package name */
    private CheckableImageButton f13338z;

    @NonNull
    private static Drawable K(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, AppCompatResources.b(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.b(context, R$drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private void L(Window window) {
        if (this.C) {
            return;
        }
        final View findViewById = requireView().findViewById(R$id.fullscreen_header);
        EdgeToEdgeUtils.a(window, true, ViewUtils.d(findViewById), null);
        final int paddingTop = findViewById.getPaddingTop();
        final int i8 = findViewById.getLayoutParams().height;
        ViewCompat.G0(findViewById, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.4
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                int i9 = windowInsetsCompat.f(WindowInsetsCompat.Type.c()).f5738b;
                if (i8 >= 0) {
                    findViewById.getLayoutParams().height = i8 + i9;
                    View view2 = findViewById;
                    view2.setLayoutParams(view2.getLayoutParams());
                }
                View view3 = findViewById;
                view3.setPadding(view3.getPaddingLeft(), paddingTop + i9, findViewById.getPaddingRight(), findViewById.getPaddingBottom());
                return windowInsetsCompat;
            }
        });
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector<S> M() {
        if (this.f13323k == null) {
            this.f13323k = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f13323k;
    }

    private static CharSequence N(CharSequence charSequence) {
        if (charSequence != null) {
            String[] split = TextUtils.split(String.valueOf(charSequence), "\n");
            if (split.length > 1) {
                return split[0];
            }
            return charSequence;
        }
        return null;
    }

    private String O() {
        return M().I(requireContext());
    }

    private static int Q(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i8 = Month.f().f13355i;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i8) + ((i8 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int S(Context context) {
        int i8 = this.f13322j;
        if (i8 != 0) {
            return i8;
        }
        return M().O(context);
    }

    private void T(Context context) {
        boolean z7;
        this.f13338z.setTag(H);
        this.f13338z.setImageDrawable(K(context));
        CheckableImageButton checkableImageButton = this.f13338z;
        if (this.f13331s != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        checkableImageButton.setChecked(z7);
        ViewCompat.s0(this.f13338z, null);
        b0(this.f13338z);
        this.f13338z.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MaterialDatePicker.this.B.setEnabled(MaterialDatePicker.this.M().R0());
                MaterialDatePicker.this.f13338z.toggle();
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.b0(materialDatePicker.f13338z);
                MaterialDatePicker.this.Y();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean U(@NonNull Context context) {
        return X(context, 16843277);
    }

    private boolean V() {
        if (getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean W(@NonNull Context context) {
        return X(context, R$attr.nestedScrollable);
    }

    static boolean X(@NonNull Context context, int i8) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.d(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i8});
        boolean z7 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        PickerFragment<S> pickerFragment;
        int S = S(requireContext());
        this.f13327o = MaterialCalendar.V(M(), S, this.f13325m, this.f13326n);
        boolean isChecked = this.f13338z.isChecked();
        if (isChecked) {
            pickerFragment = MaterialTextInputPicker.F(M(), S, this.f13325m);
        } else {
            pickerFragment = this.f13327o;
        }
        this.f13324l = pickerFragment;
        a0(isChecked);
        Z(P());
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.mtrl_calendar_frame, this.f13324l);
        beginTransaction.commitNow();
        this.f13324l.D(new OnSelectionChangedListener<S>() { // from class: com.google.android.material.datepicker.MaterialDatePicker.5
            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void a(S s7) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.Z(materialDatePicker.P());
                MaterialDatePicker.this.B.setEnabled(MaterialDatePicker.this.M().R0());
            }
        });
    }

    private void a0(boolean z7) {
        CharSequence charSequence;
        TextView textView = this.f13336x;
        if (z7 && V()) {
            charSequence = this.E;
        } else {
            charSequence = this.D;
        }
        textView.setText(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(@NonNull CheckableImageButton checkableImageButton) {
        String string;
        if (this.f13338z.isChecked()) {
            string = checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            string = checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.f13338z.setContentDescription(string);
    }

    public String P() {
        return M().f0(getContext());
    }

    public final S R() {
        return M().b1();
    }

    void Z(String str) {
        this.f13337y.setContentDescription(O());
        this.f13337y.setText(str);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f13320h.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f13322j = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f13323k = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f13325m = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f13326n = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f13328p = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f13329q = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f13331s = bundle.getInt("INPUT_MODE_KEY");
        this.f13332t = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f13333u = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f13334v = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f13335w = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        CharSequence charSequence = this.f13329q;
        if (charSequence == null) {
            charSequence = requireContext().getResources().getText(this.f13328p);
        }
        this.D = charSequence;
        this.E = N(charSequence);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), S(requireContext()));
        Context context = dialog.getContext();
        this.f13330r = U(context);
        int d8 = MaterialAttributes.d(context, R$attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R$attr.materialCalendarStyle, R$style.Widget_MaterialComponents_MaterialCalendar);
        this.A = materialShapeDrawable;
        materialShapeDrawable.R(context);
        this.A.c0(ColorStateList.valueOf(d8));
        this.A.b0(ViewCompat.y(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i8;
        if (this.f13330r) {
            i8 = R$layout.mtrl_picker_fullscreen;
        } else {
            i8 = R$layout.mtrl_picker_dialog;
        }
        View inflate = layoutInflater.inflate(i8, viewGroup);
        Context context = inflate.getContext();
        DayViewDecorator dayViewDecorator = this.f13326n;
        if (dayViewDecorator != null) {
            dayViewDecorator.g(context);
        }
        if (this.f13330r) {
            inflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(Q(context), -2));
        } else {
            inflate.findViewById(R$id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(Q(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.f13337y = textView;
        ViewCompat.u0(textView, 1);
        this.f13338z = (CheckableImageButton) inflate.findViewById(R$id.mtrl_picker_header_toggle);
        this.f13336x = (TextView) inflate.findViewById(R$id.mtrl_picker_title_text);
        T(context);
        this.B = (Button) inflate.findViewById(R$id.confirm_button);
        if (M().R0()) {
            this.B.setEnabled(true);
        } else {
            this.B.setEnabled(false);
        }
        this.B.setTag(F);
        CharSequence charSequence = this.f13333u;
        if (charSequence != null) {
            this.B.setText(charSequence);
        } else {
            int i9 = this.f13332t;
            if (i9 != 0) {
                this.B.setText(i9);
            }
        }
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it = MaterialDatePicker.this.f13318f.iterator();
                while (it.hasNext()) {
                    ((MaterialPickerOnPositiveButtonClickListener) it.next()).a(MaterialDatePicker.this.R());
                }
                MaterialDatePicker.this.dismiss();
            }
        });
        ViewCompat.s0(this.B, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialDatePicker.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.c0(MaterialDatePicker.this.M().getError() + ", " + ((Object) accessibilityNodeInfoCompat.v()));
            }
        });
        Button button = (Button) inflate.findViewById(R$id.cancel_button);
        button.setTag(G);
        CharSequence charSequence2 = this.f13335w;
        if (charSequence2 != null) {
            button.setText(charSequence2);
        } else {
            int i10 = this.f13334v;
            if (i10 != 0) {
                button.setText(i10);
            }
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it = MaterialDatePicker.this.f13319g.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                MaterialDatePicker.this.dismiss();
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f13321i.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f13322j);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f13323k);
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.f13325m);
        if (this.f13327o.Q() != null) {
            builder.b(this.f13327o.Q().f13357k);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", builder.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f13326n);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f13328p);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f13329q);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f13332t);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f13333u);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f13334v);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f13335w);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f13330r) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.A);
            L(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.A, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        Y();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f13324l.E();
        super.onStop();
    }
}
