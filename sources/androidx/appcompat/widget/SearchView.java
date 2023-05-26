package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.actions.SearchIntents;
import j$.util.Spliterator;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {

    /* renamed from: v0  reason: collision with root package name */
    static final PreQAutoCompleteTextViewReflector f2096v0;
    final ImageView A;
    final ImageView B;
    private final View C;
    private UpdatableTouchDelegate D;
    private Rect E;
    private Rect F;
    private int[] G;
    private int[] H;
    private final ImageView I;
    private final Drawable J;
    private final int K;
    private final int L;
    private final Intent M;
    private final Intent N;
    private final CharSequence O;
    private OnQueryTextListener P;
    private OnCloseListener Q;
    View.OnFocusChangeListener R;
    private OnSuggestionListener S;
    private View.OnClickListener T;
    private boolean U;
    private boolean V;
    CursorAdapter W;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f2097a0;

    /* renamed from: b0  reason: collision with root package name */
    private CharSequence f2098b0;

    /* renamed from: c0  reason: collision with root package name */
    private boolean f2099c0;

    /* renamed from: d0  reason: collision with root package name */
    private boolean f2100d0;

    /* renamed from: e0  reason: collision with root package name */
    private int f2101e0;

    /* renamed from: f0  reason: collision with root package name */
    private boolean f2102f0;

    /* renamed from: g0  reason: collision with root package name */
    private CharSequence f2103g0;

    /* renamed from: h0  reason: collision with root package name */
    private CharSequence f2104h0;

    /* renamed from: i0  reason: collision with root package name */
    private boolean f2105i0;

    /* renamed from: j0  reason: collision with root package name */
    private int f2106j0;

    /* renamed from: k0  reason: collision with root package name */
    SearchableInfo f2107k0;

    /* renamed from: l0  reason: collision with root package name */
    private Bundle f2108l0;

    /* renamed from: m0  reason: collision with root package name */
    private final Runnable f2109m0;

    /* renamed from: n0  reason: collision with root package name */
    private Runnable f2110n0;

    /* renamed from: o0  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f2111o0;

    /* renamed from: p0  reason: collision with root package name */
    private final View.OnClickListener f2112p0;

    /* renamed from: q0  reason: collision with root package name */
    View.OnKeyListener f2113q0;

    /* renamed from: r0  reason: collision with root package name */
    private final TextView.OnEditorActionListener f2114r0;

    /* renamed from: s0  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f2115s0;

    /* renamed from: t0  reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f2116t0;

    /* renamed from: u  reason: collision with root package name */
    final SearchAutoComplete f2117u;

    /* renamed from: u0  reason: collision with root package name */
    private TextWatcher f2118u0;

    /* renamed from: v  reason: collision with root package name */
    private final View f2119v;

    /* renamed from: w  reason: collision with root package name */
    private final View f2120w;

    /* renamed from: x  reason: collision with root package name */
    private final View f2121x;

    /* renamed from: y  reason: collision with root package name */
    final ImageView f2122y;

    /* renamed from: z  reason: collision with root package name */
    final ImageView f2123z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        static void b(SearchAutoComplete searchAutoComplete, int i8) {
            searchAutoComplete.setInputMethodMode(i8);
        }
    }

    /* loaded from: classes.dex */
    public interface OnCloseListener {
        boolean a();
    }

    /* loaded from: classes.dex */
    public interface OnQueryTextListener {
        boolean a(String str);

        boolean b(String str);
    }

    /* loaded from: classes.dex */
    public interface OnSuggestionListener {
        boolean a(int i8);

        boolean b(int i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PreQAutoCompleteTextViewReflector {

        /* renamed from: a  reason: collision with root package name */
        private Method f2134a;

        /* renamed from: b  reason: collision with root package name */
        private Method f2135b;

        /* renamed from: c  reason: collision with root package name */
        private Method f2136c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        PreQAutoCompleteTextViewReflector() {
            this.f2134a = null;
            this.f2135b = null;
            this.f2136c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f2134a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f2135b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f2136c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT < 29) {
                return;
            }
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f2135b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f2134a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f2136c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.SearchView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: h  reason: collision with root package name */
        boolean f2137h;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f2137h + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeValue(Boolean.valueOf(this.f2137h));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2137h = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: j  reason: collision with root package name */
        private int f2138j;

        /* renamed from: k  reason: collision with root package name */
        private SearchView f2139k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f2140l;

        /* renamed from: m  reason: collision with root package name */
        final Runnable f2141m;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.f830p);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i8 = configuration.screenWidthDp;
            int i9 = configuration.screenHeightDp;
            if (i8 >= 960 && i9 >= 720 && configuration.orientation == 2) {
                return Spliterator.NONNULL;
            }
            if (i8 < 600) {
                if (i8 < 640 || i9 < 480) {
                    return 160;
                }
                return 192;
            }
            return 192;
        }

        void b() {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.f2096v0.c(this);
        }

        boolean c() {
            if (TextUtils.getTrimmedLength(getText()) == 0) {
                return true;
            }
            return false;
        }

        void d() {
            if (this.f2140l) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f2140l = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            if (this.f2138j > 0 && !super.enoughToFilter()) {
                return false;
            }
            return true;
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2140l) {
                removeCallbacks(this.f2141m);
                post(this.f2141m);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z7, int i8, Rect rect) {
            super.onFocusChanged(z7, i8, rect);
            this.f2139k.X();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i8, KeyEvent keyEvent) {
            if (i8 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f2139k.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i8, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z7) {
            super.onWindowFocusChanged(z7);
            if (z7 && this.f2139k.hasFocus() && getVisibility() == 0) {
                this.f2140l = true;
                if (SearchView.K(getContext())) {
                    b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z7) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z7) {
                this.f2140l = false;
                removeCallbacks(this.f2141m);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f2140l = false;
                removeCallbacks(this.f2141m);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f2140l = true;
            }
        }

        void setSearchView(SearchView searchView) {
            this.f2139k = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i8) {
            super.setThreshold(i8);
            this.f2138j = i8;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i8) {
            super(context, attributeSet, i8);
            this.f2141m = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.d();
                }
            };
            this.f2138j = getThreshold();
        }
    }

    /* loaded from: classes.dex */
    private static class UpdatableTouchDelegate extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f2143a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f2144b;

        /* renamed from: c  reason: collision with root package name */
        private final Rect f2145c;

        /* renamed from: d  reason: collision with root package name */
        private final Rect f2146d;

        /* renamed from: e  reason: collision with root package name */
        private final int f2147e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2148f;

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f2147e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f2144b = new Rect();
            this.f2146d = new Rect();
            this.f2145c = new Rect();
            a(rect, rect2);
            this.f2143a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f2144b.set(rect);
            this.f2146d.set(rect);
            Rect rect3 = this.f2146d;
            int i8 = this.f2147e;
            rect3.inset(-i8, -i8);
            this.f2145c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z7;
            boolean z8;
            int x7 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z9 = true;
            if (action != 0) {
                if (action != 1 && action != 2) {
                    if (action == 3) {
                        z8 = this.f2148f;
                        this.f2148f = false;
                    }
                    z7 = true;
                    z9 = false;
                } else {
                    z8 = this.f2148f;
                    if (z8 && !this.f2146d.contains(x7, y7)) {
                        z9 = z8;
                        z7 = false;
                    }
                }
                z9 = z8;
                z7 = true;
            } else {
                if (this.f2144b.contains(x7, y7)) {
                    this.f2148f = true;
                    z7 = true;
                }
                z7 = true;
                z9 = false;
            }
            if (!z9) {
                return false;
            }
            if (z7 && !this.f2145c.contains(x7, y7)) {
                motionEvent.setLocation(this.f2143a.getWidth() / 2, this.f2143a.getHeight() / 2);
            } else {
                Rect rect = this.f2145c;
                motionEvent.setLocation(x7 - rect.left, y7 - rect.top);
            }
            return this.f2143a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector;
        if (Build.VERSION.SDK_INT < 29) {
            preQAutoCompleteTextViewReflector = new PreQAutoCompleteTextViewReflector();
        } else {
            preQAutoCompleteTextViewReflector = null;
        }
        f2096v0 = preQAutoCompleteTextViewReflector;
    }

    public SearchView(@NonNull Context context) {
        this(context, null);
    }

    private Intent A(String str, Uri uri, String str2, String str3, int i8, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2104h0);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f2108l0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i8 != 0) {
            intent.putExtra("action_key", i8);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f2107k0.getSearchActivity());
        return intent;
    }

    private Intent B(Cursor cursor, int i8, String str) {
        int i9;
        Uri parse;
        String n8;
        try {
            String n9 = SuggestionsAdapter.n(cursor, "suggest_intent_action");
            if (n9 == null) {
                n9 = this.f2107k0.getSuggestIntentAction();
            }
            if (n9 == null) {
                n9 = "android.intent.action.SEARCH";
            }
            String str2 = n9;
            String n10 = SuggestionsAdapter.n(cursor, "suggest_intent_data");
            if (n10 == null) {
                n10 = this.f2107k0.getSuggestIntentData();
            }
            if (n10 != null && (n8 = SuggestionsAdapter.n(cursor, "suggest_intent_data_id")) != null) {
                n10 = n10 + "/" + Uri.encode(n8);
            }
            if (n10 == null) {
                parse = null;
            } else {
                parse = Uri.parse(n10);
            }
            return A(str2, parse, SuggestionsAdapter.n(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.n(cursor, "suggest_intent_query"), i8, str);
        } catch (RuntimeException e8) {
            try {
                i9 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i9 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i9 + " returned exception.", e8);
            return null;
        }
    }

    private Intent C(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2108l0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i8 = 1;
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i8 = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i8);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent D(Intent intent, SearchableInfo searchableInfo) {
        String flattenToShortString;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            flattenToShortString = null;
        } else {
            flattenToShortString = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", flattenToShortString);
        return intent2;
    }

    private void E() {
        this.f2117u.dismissDropDown();
    }

    private void G(View view, Rect rect) {
        view.getLocationInWindow(this.G);
        getLocationInWindow(this.H);
        int[] iArr = this.G;
        int i8 = iArr[1];
        int[] iArr2 = this.H;
        int i9 = i8 - iArr2[1];
        int i10 = iArr[0] - iArr2[0];
        rect.set(i10, i9, view.getWidth() + i10, view.getHeight() + i9);
    }

    private CharSequence H(CharSequence charSequence) {
        if (this.U && this.J != null) {
            int textSize = (int) (this.f2117u.getTextSize() * 1.25d);
            this.J.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.J), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    private boolean I() {
        SearchableInfo searchableInfo = this.f2107k0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f2107k0.getVoiceSearchLaunchWebSearch()) {
            intent = this.M;
        } else if (this.f2107k0.getVoiceSearchLaunchRecognizer()) {
            intent = this.N;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    static boolean K(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    private boolean L() {
        if ((this.f2097a0 || this.f2102f0) && !J()) {
            return true;
        }
        return false;
    }

    private void M(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e8) {
            Log.e("SearchView", "Failed launch activity: " + intent, e8);
        }
    }

    private boolean O(int i8, int i9, String str) {
        Cursor c8 = this.W.c();
        if (c8 != null && c8.moveToPosition(i8)) {
            M(B(c8, i9, str));
            return true;
        }
        return false;
    }

    private void Z() {
        post(this.f2109m0);
    }

    private void a0(int i8) {
        Editable text = this.f2117u.getText();
        Cursor c8 = this.W.c();
        if (c8 == null) {
            return;
        }
        if (c8.moveToPosition(i8)) {
            CharSequence convertToString = this.W.convertToString(c8);
            if (convertToString != null) {
                setQuery(convertToString);
                return;
            } else {
                setQuery(text);
                return;
            }
        }
        setQuery(text);
    }

    private void c0() {
        int[] iArr;
        boolean z7 = true;
        boolean z8 = !TextUtils.isEmpty(this.f2117u.getText());
        int i8 = 0;
        if (!z8 && (!this.U || this.f2105i0)) {
            z7 = false;
        }
        ImageView imageView = this.A;
        if (!z7) {
            i8 = 8;
        }
        imageView.setVisibility(i8);
        Drawable drawable = this.A.getDrawable();
        if (drawable != null) {
            if (z8) {
                iArr = ViewGroup.ENABLED_STATE_SET;
            } else {
                iArr = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
        }
    }

    private void e0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f2117u;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(H(queryHint));
    }

    private void f0() {
        this.f2117u.setThreshold(this.f2107k0.getSuggestThreshold());
        this.f2117u.setImeOptions(this.f2107k0.getImeOptions());
        int inputType = this.f2107k0.getInputType();
        int i8 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f2107k0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f2117u.setInputType(inputType);
        CursorAdapter cursorAdapter = this.W;
        if (cursorAdapter != null) {
            cursorAdapter.a(null);
        }
        if (this.f2107k0.getSuggestAuthority() != null) {
            SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.f2107k0, this.f2111o0);
            this.W = suggestionsAdapter;
            this.f2117u.setAdapter(suggestionsAdapter);
            SuggestionsAdapter suggestionsAdapter2 = (SuggestionsAdapter) this.W;
            if (this.f2099c0) {
                i8 = 2;
            }
            suggestionsAdapter2.w(i8);
        }
    }

    private void g0() {
        int i8;
        if (L() && (this.f2123z.getVisibility() == 0 || this.B.getVisibility() == 0)) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        this.f2121x.setVisibility(i8);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.f856g);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.f857h);
    }

    private void h0(boolean z7) {
        int i8;
        if (this.f2097a0 && L() && hasFocus() && (z7 || !this.f2102f0)) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        this.f2123z.setVisibility(i8);
    }

    private void i0(boolean z7) {
        int i8;
        int i9;
        this.V = z7;
        int i10 = 0;
        if (z7) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        boolean z8 = !TextUtils.isEmpty(this.f2117u.getText());
        this.f2122y.setVisibility(i8);
        h0(z8);
        View view = this.f2119v;
        if (z7) {
            i9 = 8;
        } else {
            i9 = 0;
        }
        view.setVisibility(i9);
        this.I.setVisibility((this.I.getDrawable() == null || this.U) ? 8 : 8);
        c0();
        j0(!z8);
        g0();
    }

    private void j0(boolean z7) {
        int i8 = 8;
        if (this.f2102f0 && !J() && z7) {
            this.f2123z.setVisibility(8);
            i8 = 0;
        }
        this.B.setVisibility(i8);
    }

    private void setQuery(CharSequence charSequence) {
        int length;
        this.f2117u.setText(charSequence);
        SearchAutoComplete searchAutoComplete = this.f2117u;
        if (TextUtils.isEmpty(charSequence)) {
            length = 0;
        } else {
            length = charSequence.length();
        }
        searchAutoComplete.setSelection(length);
    }

    void F() {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.a(this.f2117u);
            return;
        }
        PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = f2096v0;
        preQAutoCompleteTextViewReflector.b(this.f2117u);
        preQAutoCompleteTextViewReflector.a(this.f2117u);
    }

    public boolean J() {
        return this.V;
    }

    void N(int i8, String str, String str2) {
        getContext().startActivity(A("android.intent.action.SEARCH", null, null, str2, i8, str));
    }

    void P() {
        if (TextUtils.isEmpty(this.f2117u.getText())) {
            if (this.U) {
                OnCloseListener onCloseListener = this.Q;
                if (onCloseListener == null || !onCloseListener.a()) {
                    clearFocus();
                    i0(true);
                    return;
                }
                return;
            }
            return;
        }
        this.f2117u.setText("");
        this.f2117u.requestFocus();
        this.f2117u.setImeVisibility(true);
    }

    boolean Q(int i8, int i9, String str) {
        OnSuggestionListener onSuggestionListener = this.S;
        if (onSuggestionListener != null && onSuggestionListener.b(i8)) {
            return false;
        }
        O(i8, 0, null);
        this.f2117u.setImeVisibility(false);
        E();
        return true;
    }

    boolean R(int i8) {
        OnSuggestionListener onSuggestionListener = this.S;
        if (onSuggestionListener != null && onSuggestionListener.a(i8)) {
            return false;
        }
        a0(i8);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void T() {
        i0(false);
        this.f2117u.requestFocus();
        this.f2117u.setImeVisibility(true);
        View.OnClickListener onClickListener = this.T;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void U() {
        Editable text = this.f2117u.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            OnQueryTextListener onQueryTextListener = this.P;
            if (onQueryTextListener == null || !onQueryTextListener.b(text.toString())) {
                if (this.f2107k0 != null) {
                    N(0, null, text.toString());
                }
                this.f2117u.setImeVisibility(false);
                E();
            }
        }
    }

    boolean V(View view, int i8, KeyEvent keyEvent) {
        int length;
        if (this.f2107k0 != null && this.W != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i8 != 66 && i8 != 84 && i8 != 61) {
                if (i8 != 21 && i8 != 22) {
                    if (i8 == 19) {
                        this.f2117u.getListSelection();
                        return false;
                    }
                } else {
                    if (i8 == 21) {
                        length = 0;
                    } else {
                        length = this.f2117u.length();
                    }
                    this.f2117u.setSelection(length);
                    this.f2117u.setListSelection(0);
                    this.f2117u.clearListSelection();
                    this.f2117u.b();
                    return true;
                }
            } else {
                return Q(this.f2117u.getListSelection(), 0, null);
            }
        }
        return false;
    }

    void W(CharSequence charSequence) {
        Editable text = this.f2117u.getText();
        this.f2104h0 = text;
        boolean z7 = !TextUtils.isEmpty(text);
        h0(z7);
        j0(!z7);
        c0();
        g0();
        if (this.P != null && !TextUtils.equals(charSequence, this.f2103g0)) {
            this.P.a(charSequence.toString());
        }
        this.f2103g0 = charSequence.toString();
    }

    void X() {
        i0(J());
        Z();
        if (this.f2117u.hasFocus()) {
            F();
        }
    }

    void Y() {
        SearchableInfo searchableInfo = this.f2107k0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(D(this.M, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(C(this.N, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public void b0(CharSequence charSequence, boolean z7) {
        this.f2117u.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f2117u;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f2104h0 = charSequence;
        }
        if (z7 && !TextUtils.isEmpty(charSequence)) {
            U();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f2100d0 = true;
        super.clearFocus();
        this.f2117u.clearFocus();
        this.f2117u.setImeVisibility(false);
        this.f2100d0 = false;
    }

    void d0() {
        int[] iArr;
        if (this.f2117u.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.f2120w.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f2121x.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.f2117u.getImeOptions();
    }

    public int getInputType() {
        return this.f2117u.getInputType();
    }

    public int getMaxWidth() {
        return this.f2101e0;
    }

    public CharSequence getQuery() {
        return this.f2117u.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f2098b0;
        if (charSequence == null) {
            SearchableInfo searchableInfo = this.f2107k0;
            if (searchableInfo != null && searchableInfo.getHintId() != 0) {
                return getContext().getText(this.f2107k0.getHintId());
            }
            return this.O;
        }
        return charSequence;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.K;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.W;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        b0("", false);
        clearFocus();
        i0(true);
        this.f2117u.setImeOptions(this.f2106j0);
        this.f2105i0 = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (this.f2105i0) {
            return;
        }
        this.f2105i0 = true;
        int imeOptions = this.f2117u.getImeOptions();
        this.f2106j0 = imeOptions;
        this.f2117u.setImeOptions(imeOptions | 33554432);
        this.f2117u.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f2109m0);
        post(this.f2110n0);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        if (z7) {
            G(this.f2117u, this.E);
            Rect rect = this.F;
            Rect rect2 = this.E;
            rect.set(rect2.left, 0, rect2.right, i11 - i9);
            UpdatableTouchDelegate updatableTouchDelegate = this.D;
            if (updatableTouchDelegate == null) {
                UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.F, this.E, this.f2117u);
                this.D = updatableTouchDelegate2;
                setTouchDelegate(updatableTouchDelegate2);
                return;
            }
            updatableTouchDelegate.a(this.F, this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i8, int i9) {
        int i10;
        if (J()) {
            super.onMeasure(i8, i9);
            return;
        }
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824 && (i10 = this.f2101e0) > 0) {
                    size = Math.min(i10, size);
                }
            } else {
                size = this.f2101e0;
                if (size <= 0) {
                    size = getPreferredWidth();
                }
            }
        } else {
            int i11 = this.f2101e0;
            size = i11 > 0 ? Math.min(i11, size) : Math.min(getPreferredWidth(), size);
        }
        int mode2 = View.MeasureSpec.getMode(i9);
        int size2 = View.MeasureSpec.getSize(i9);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                size2 = getPreferredHeight();
            }
        } else {
            size2 = Math.min(getPreferredHeight(), size2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(size2, Pow2.MAX_POW2));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        i0(savedState.f2137h);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2137h = J();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z7) {
        super.onWindowFocusChanged(z7);
        Z();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i8, Rect rect) {
        if (this.f2100d0 || !isFocusable()) {
            return false;
        }
        if (!J()) {
            boolean requestFocus = this.f2117u.requestFocus(i8, rect);
            if (requestFocus) {
                i0(false);
            }
            return requestFocus;
        }
        return super.requestFocus(i8, rect);
    }

    public void setAppSearchData(Bundle bundle) {
        this.f2108l0 = bundle;
    }

    public void setIconified(boolean z7) {
        if (z7) {
            P();
        } else {
            T();
        }
    }

    public void setIconifiedByDefault(boolean z7) {
        if (this.U == z7) {
            return;
        }
        this.U = z7;
        i0(z7);
        e0();
    }

    public void setImeOptions(int i8) {
        this.f2117u.setImeOptions(i8);
    }

    public void setInputType(int i8) {
        this.f2117u.setInputType(i8);
    }

    public void setMaxWidth(int i8) {
        this.f2101e0 = i8;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.Q = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.R = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.P = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.T = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.S = onSuggestionListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f2098b0 = charSequence;
        e0();
    }

    public void setQueryRefinementEnabled(boolean z7) {
        int i8;
        this.f2099c0 = z7;
        CursorAdapter cursorAdapter = this.W;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) cursorAdapter;
            if (z7) {
                i8 = 2;
            } else {
                i8 = 1;
            }
            suggestionsAdapter.w(i8);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f2107k0 = searchableInfo;
        if (searchableInfo != null) {
            f0();
            e0();
        }
        boolean I = I();
        this.f2102f0 = I;
        if (I) {
            this.f2117u.setPrivateImeOptions("nm");
        }
        i0(J());
    }

    public void setSubmitButtonEnabled(boolean z7) {
        this.f2097a0 = z7;
        i0(J());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.W = cursorAdapter;
        this.f2117u.setAdapter(cursorAdapter);
    }

    void z() {
        int i8;
        int i9;
        if (this.C.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f2120w.getPaddingLeft();
            Rect rect = new Rect();
            boolean b8 = ViewUtils.b(this);
            if (this.U) {
                i8 = resources.getDimensionPixelSize(R$dimen.f854e) + resources.getDimensionPixelSize(R$dimen.f855f);
            } else {
                i8 = 0;
            }
            this.f2117u.getDropDownBackground().getPadding(rect);
            if (b8) {
                i9 = -rect.left;
            } else {
                i9 = paddingLeft - (rect.left + i8);
            }
            this.f2117u.setDropDownHorizontalOffset(i9);
            this.f2117u.setDropDownWidth((((this.C.getWidth() + rect.left) + rect.right) + i8) - paddingLeft);
        }
    }

    public SearchView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.I);
    }

    public SearchView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.E = new Rect();
        this.F = new Rect();
        this.G = new int[2];
        this.H = new int[2];
        this.f2109m0 = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.d0();
            }
        };
        this.f2110n0 = new Runnable() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // java.lang.Runnable
            public void run() {
                CursorAdapter cursorAdapter = SearchView.this.W;
                if (cursorAdapter instanceof SuggestionsAdapter) {
                    cursorAdapter.a(null);
                }
            }
        };
        this.f2111o0 = new WeakHashMap<>();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchView searchView = SearchView.this;
                if (view == searchView.f2122y) {
                    searchView.T();
                } else if (view == searchView.A) {
                    searchView.P();
                } else if (view == searchView.f2123z) {
                    searchView.U();
                } else if (view == searchView.B) {
                    searchView.Y();
                } else if (view == searchView.f2117u) {
                    searchView.F();
                }
            }
        };
        this.f2112p0 = onClickListener;
        this.f2113q0 = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.6
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i9, KeyEvent keyEvent) {
                SearchView searchView = SearchView.this;
                if (searchView.f2107k0 == null) {
                    return false;
                }
                if (searchView.f2117u.isPopupShowing() && SearchView.this.f2117u.getListSelection() != -1) {
                    return SearchView.this.V(view, i9, keyEvent);
                }
                if (SearchView.this.f2117u.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i9 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView2 = SearchView.this;
                searchView2.N(0, null, searchView2.f2117u.getText().toString());
                return true;
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i9, KeyEvent keyEvent) {
                SearchView.this.U();
                return true;
            }
        };
        this.f2114r0 = onEditorActionListener;
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i9, long j8) {
                SearchView.this.Q(i9, 0, null);
            }
        };
        this.f2115s0 = onItemClickListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i9, long j8) {
                SearchView.this.R(i9);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.f2116t0 = onItemSelectedListener;
        this.f2118u0 = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.10
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
                SearchView.this.W(charSequence);
            }
        };
        int[] iArr = R$styleable.f984f2;
        TintTypedArray v7 = TintTypedArray.v(context, attributeSet, iArr, i8, 0);
        ViewCompat.q0(this, context, iArr, attributeSet, v7.r(), i8, 0);
        LayoutInflater.from(context).inflate(v7.n(R$styleable.f1034p2, R$layout.f934r), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R$id.D);
        this.f2117u = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f2119v = findViewById(R$id.f916z);
        View findViewById = findViewById(R$id.C);
        this.f2120w = findViewById;
        View findViewById2 = findViewById(R$id.J);
        this.f2121x = findViewById2;
        ImageView imageView = (ImageView) findViewById(R$id.f914x);
        this.f2122y = imageView;
        ImageView imageView2 = (ImageView) findViewById(R$id.A);
        this.f2123z = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R$id.f915y);
        this.A = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R$id.E);
        this.B = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R$id.B);
        this.I = imageView5;
        ViewCompat.w0(findViewById, v7.g(R$styleable.f1039q2));
        ViewCompat.w0(findViewById2, v7.g(R$styleable.f1059u2));
        int i9 = R$styleable.f1054t2;
        imageView.setImageDrawable(v7.g(i9));
        imageView2.setImageDrawable(v7.g(R$styleable.f1024n2));
        imageView3.setImageDrawable(v7.g(R$styleable.f1009k2));
        imageView4.setImageDrawable(v7.g(R$styleable.f1069w2));
        imageView5.setImageDrawable(v7.g(i9));
        this.J = v7.g(R$styleable.f1049s2);
        TooltipCompat.a(imageView, getResources().getString(R$string.f950n));
        this.K = v7.n(R$styleable.f1064v2, R$layout.f933q);
        this.L = v7.n(R$styleable.f1014l2, 0);
        imageView.setOnClickListener(onClickListener);
        imageView3.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        imageView4.setOnClickListener(onClickListener);
        searchAutoComplete.setOnClickListener(onClickListener);
        searchAutoComplete.addTextChangedListener(this.f2118u0);
        searchAutoComplete.setOnEditorActionListener(onEditorActionListener);
        searchAutoComplete.setOnItemClickListener(onItemClickListener);
        searchAutoComplete.setOnItemSelectedListener(onItemSelectedListener);
        searchAutoComplete.setOnKeyListener(this.f2113q0);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.SearchView.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z7) {
                SearchView searchView = SearchView.this;
                View.OnFocusChangeListener onFocusChangeListener = searchView.R;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z7);
                }
            }
        });
        setIconifiedByDefault(v7.a(R$styleable.f1029o2, true));
        int f8 = v7.f(R$styleable.f994h2, -1);
        if (f8 != -1) {
            setMaxWidth(f8);
        }
        this.O = v7.p(R$styleable.f1019m2);
        this.f2098b0 = v7.p(R$styleable.f1044r2);
        int k8 = v7.k(R$styleable.f1004j2, -1);
        if (k8 != -1) {
            setImeOptions(k8);
        }
        int k9 = v7.k(R$styleable.f999i2, -1);
        if (k9 != -1) {
            setInputType(k9);
        }
        setFocusable(v7.a(R$styleable.f989g2, true));
        v7.w();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.M = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.N = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.C = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.4
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                    SearchView.this.z();
                }
            });
        }
        i0(this.U);
        e0();
    }
}
