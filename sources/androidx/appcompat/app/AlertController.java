package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* renamed from: a  reason: collision with root package name */
    private final Context f1087a;

    /* renamed from: b  reason: collision with root package name */
    final AppCompatDialog f1088b;

    /* renamed from: c  reason: collision with root package name */
    private final Window f1089c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1090d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f1091e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f1092f;

    /* renamed from: g  reason: collision with root package name */
    ListView f1093g;

    /* renamed from: h  reason: collision with root package name */
    private View f1094h;

    /* renamed from: i  reason: collision with root package name */
    private int f1095i;

    /* renamed from: j  reason: collision with root package name */
    private int f1096j;

    /* renamed from: k  reason: collision with root package name */
    private int f1097k;

    /* renamed from: l  reason: collision with root package name */
    private int f1098l;

    /* renamed from: m  reason: collision with root package name */
    private int f1099m;

    /* renamed from: o  reason: collision with root package name */
    Button f1101o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f1102p;

    /* renamed from: q  reason: collision with root package name */
    Message f1103q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f1104r;

    /* renamed from: s  reason: collision with root package name */
    Button f1105s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f1106t;

    /* renamed from: u  reason: collision with root package name */
    Message f1107u;

    /* renamed from: v  reason: collision with root package name */
    private Drawable f1108v;

    /* renamed from: w  reason: collision with root package name */
    Button f1109w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f1110x;

    /* renamed from: y  reason: collision with root package name */
    Message f1111y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f1112z;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1100n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.f1101o && (message4 = alertController.f1103q) != null) {
                message = Message.obtain(message4);
            } else if (view == alertController.f1105s && (message3 = alertController.f1107u) != null) {
                message = Message.obtain(message3);
            } else if (view == alertController.f1109w && (message2 = alertController.f1111y) != null) {
                message = Message.obtain(message2);
            } else {
                message = null;
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f1088b).sendToTarget();
        }
    };

    /* loaded from: classes.dex */
    public static class AlertParams {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public OnPrepareListViewListener O;

        /* renamed from: a  reason: collision with root package name */
        public final Context f1126a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f1127b;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f1129d;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f1131f;

        /* renamed from: g  reason: collision with root package name */
        public View f1132g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f1133h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f1134i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f1135j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f1136k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f1137l;

        /* renamed from: m  reason: collision with root package name */
        public Drawable f1138m;

        /* renamed from: n  reason: collision with root package name */
        public DialogInterface.OnClickListener f1139n;

        /* renamed from: o  reason: collision with root package name */
        public CharSequence f1140o;

        /* renamed from: p  reason: collision with root package name */
        public Drawable f1141p;

        /* renamed from: q  reason: collision with root package name */
        public DialogInterface.OnClickListener f1142q;

        /* renamed from: s  reason: collision with root package name */
        public DialogInterface.OnCancelListener f1144s;

        /* renamed from: t  reason: collision with root package name */
        public DialogInterface.OnDismissListener f1145t;

        /* renamed from: u  reason: collision with root package name */
        public DialogInterface.OnKeyListener f1146u;

        /* renamed from: v  reason: collision with root package name */
        public CharSequence[] f1147v;

        /* renamed from: w  reason: collision with root package name */
        public ListAdapter f1148w;

        /* renamed from: x  reason: collision with root package name */
        public DialogInterface.OnClickListener f1149x;

        /* renamed from: y  reason: collision with root package name */
        public int f1150y;

        /* renamed from: z  reason: collision with root package name */
        public View f1151z;

        /* renamed from: c  reason: collision with root package name */
        public int f1128c = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f1130e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;

        /* renamed from: r  reason: collision with root package name */
        public boolean f1143r = true;

        /* loaded from: classes.dex */
        public interface OnPrepareListViewListener {
            void a(ListView listView);
        }

        public AlertParams(Context context) {
            this.f1126a = context;
            this.f1127b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(final AlertController alertController) {
            int i8;
            ListAdapter listAdapter;
            final RecycleListView recycleListView = (RecycleListView) this.f1127b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                if (this.K == null) {
                    listAdapter = new ArrayAdapter<CharSequence>(this.f1126a, alertController.M, 16908308, this.f1147v) { // from class: androidx.appcompat.app.AlertController.AlertParams.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i9, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i9, view, viewGroup);
                            boolean[] zArr = AlertParams.this.F;
                            if (zArr != null && zArr[i9]) {
                                recycleListView.setItemChecked(i9, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    listAdapter = new CursorAdapter(this.f1126a, this.K, false) { // from class: androidx.appcompat.app.AlertController.AlertParams.2

                        /* renamed from: f  reason: collision with root package name */
                        private final int f1154f;

                        /* renamed from: g  reason: collision with root package name */
                        private final int f1155g;

                        {
                            Cursor cursor = getCursor();
                            this.f1154f = cursor.getColumnIndexOrThrow(AlertParams.this.L);
                            this.f1155g = cursor.getColumnIndexOrThrow(AlertParams.this.M);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor) {
                            ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f1154f));
                            RecycleListView recycleListView2 = recycleListView;
                            int position = cursor.getPosition();
                            boolean z7 = true;
                            if (cursor.getInt(this.f1155g) != 1) {
                                z7 = false;
                            }
                            recycleListView2.setItemChecked(position, z7);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                            return AlertParams.this.f1127b.inflate(alertController.M, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.H) {
                    i8 = alertController.N;
                } else {
                    i8 = alertController.O;
                }
                int i9 = i8;
                if (this.K != null) {
                    listAdapter = new SimpleCursorAdapter(this.f1126a, i9, this.K, new String[]{this.L}, new int[]{16908308});
                } else {
                    listAdapter = this.f1148w;
                    if (listAdapter == null) {
                        listAdapter = new CheckedItemAdapter(this.f1126a, i9, 16908308, this.f1147v);
                    }
                }
            }
            OnPrepareListViewListener onPrepareListViewListener = this.O;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.a(recycleListView);
            }
            alertController.H = listAdapter;
            alertController.I = this.I;
            if (this.f1149x != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j8) {
                        AlertParams.this.f1149x.onClick(alertController.f1088b, i10);
                        if (!AlertParams.this.H) {
                            alertController.f1088b.dismiss();
                        }
                    }
                });
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j8) {
                        boolean[] zArr = AlertParams.this.F;
                        if (zArr != null) {
                            zArr[i10] = recycleListView.isItemChecked(i10);
                        }
                        AlertParams.this.J.onClick(alertController.f1088b, i10, recycleListView.isItemChecked(i10));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f1093g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f1132g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f1131f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f1129d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i8 = this.f1128c;
                if (i8 != 0) {
                    alertController.m(i8);
                }
                int i9 = this.f1130e;
                if (i9 != 0) {
                    alertController.m(alertController.c(i9));
                }
            }
            CharSequence charSequence2 = this.f1133h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f1134i;
            if (charSequence3 != null || this.f1135j != null) {
                alertController.k(-1, charSequence3, this.f1136k, null, this.f1135j);
            }
            CharSequence charSequence4 = this.f1137l;
            if (charSequence4 != null || this.f1138m != null) {
                alertController.k(-2, charSequence4, this.f1139n, null, this.f1138m);
            }
            CharSequence charSequence5 = this.f1140o;
            if (charSequence5 != null || this.f1141p != null) {
                alertController.k(-3, charSequence5, this.f1142q, null, this.f1141p);
            }
            if (this.f1147v != null || this.K != null || this.f1148w != null) {
                b(alertController);
            }
            View view2 = this.f1151z;
            if (view2 != null) {
                if (this.E) {
                    alertController.t(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i10 = this.f1150y;
            if (i10 != 0) {
                alertController.r(i10);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class ButtonHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f1164a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f1164a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i8 = message.what;
            if (i8 != -3 && i8 != -2 && i8 != -1) {
                if (i8 == 1) {
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
                return;
            }
            ((DialogInterface.OnClickListener) message.obj).onClick(this.f1164a.get(), message.what);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i8, int i9, CharSequence[] charSequenceArr) {
            super(context, i8, i9, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i8) {
            return i8;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: f  reason: collision with root package name */
        private final int f1165f;

        /* renamed from: g  reason: collision with root package name */
        private final int f1166g;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f969c2);
            this.f1166g = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.f974d2, -1);
            this.f1165f = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.f979e2, -1);
        }

        public void a(boolean z7, boolean z8) {
            int i8;
            int i9;
            if (!z8 || !z7) {
                int paddingLeft = getPaddingLeft();
                if (z7) {
                    i8 = getPaddingTop();
                } else {
                    i8 = this.f1165f;
                }
                int paddingRight = getPaddingRight();
                if (z8) {
                    i9 = getPaddingBottom();
                } else {
                    i9 = this.f1166g;
                }
                setPadding(paddingLeft, i8, paddingRight, i9);
            }
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f1087a = context;
        this.f1088b = appCompatDialog;
        this.f1089c = window;
        this.R = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.F, R$attr.f828n, 0);
        this.J = obtainStyledAttributes.getResourceId(R$styleable.G, 0);
        this.K = obtainStyledAttributes.getResourceId(R$styleable.I, 0);
        this.L = obtainStyledAttributes.getResourceId(R$styleable.K, 0);
        this.M = obtainStyledAttributes.getResourceId(R$styleable.L, 0);
        this.N = obtainStyledAttributes.getResourceId(R$styleable.N, 0);
        this.O = obtainStyledAttributes.getResourceId(R$styleable.J, 0);
        this.P = obtainStyledAttributes.getBoolean(R$styleable.M, true);
        this.f1090d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.H, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.h(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        int i8;
        int i9 = 0;
        if (view2 != null) {
            if (view.canScrollVertically(-1)) {
                i8 = 0;
            } else {
                i8 = 4;
            }
            view2.setVisibility(i8);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i9 = 4;
            }
            view3.setVisibility(i9);
        }
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i8 = this.K;
        if (i8 == 0) {
            return this.J;
        }
        if (this.Q == 1) {
            return i8;
        }
        return this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i8, int i9) {
        final View findViewById = this.f1089c.findViewById(R$id.f912v);
        final View findViewById2 = this.f1089c.findViewById(R$id.f911u);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.K0(view, i8, i9);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i8 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i8 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.f1092f != null) {
                this.A.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: androidx.appcompat.app.AlertController.2
                    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                    public void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
                        AlertController.f(nestedScrollView, findViewById, findViewById2);
                    }
                });
                this.A.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertController.f(AlertController.this.A, findViewById, findViewById2);
                    }
                });
                return;
            }
            ListView listView = this.f1093g;
            if (listView != null) {
                listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: androidx.appcompat.app.AlertController.4
                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
                        AlertController.f(absListView, findViewById, findViewById2);
                    }

                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScrollStateChanged(AbsListView absListView, int i10) {
                    }
                });
                this.f1093g.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertController.f(AlertController.this.f1093g, findViewById, findViewById2);
                    }
                });
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    private void u(ViewGroup viewGroup) {
        boolean z7;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f1101o = button;
        button.setOnClickListener(this.S);
        boolean z8 = true;
        if (TextUtils.isEmpty(this.f1102p) && this.f1104r == null) {
            this.f1101o.setVisibility(8);
            z7 = false;
        } else {
            this.f1101o.setText(this.f1102p);
            Drawable drawable = this.f1104r;
            if (drawable != null) {
                int i8 = this.f1090d;
                drawable.setBounds(0, 0, i8, i8);
                this.f1101o.setCompoundDrawables(this.f1104r, null, null, null);
            }
            this.f1101o.setVisibility(0);
            z7 = true;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f1105s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f1106t) && this.f1108v == null) {
            this.f1105s.setVisibility(8);
        } else {
            this.f1105s.setText(this.f1106t);
            Drawable drawable2 = this.f1108v;
            if (drawable2 != null) {
                int i9 = this.f1090d;
                drawable2.setBounds(0, 0, i9, i9);
                this.f1105s.setCompoundDrawables(this.f1108v, null, null, null);
            }
            this.f1105s.setVisibility(0);
            z7 |= true;
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.f1109w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f1110x) && this.f1112z == null) {
            this.f1109w.setVisibility(8);
        } else {
            this.f1109w.setText(this.f1110x);
            Drawable drawable3 = this.f1112z;
            if (drawable3 != null) {
                int i10 = this.f1090d;
                drawable3.setBounds(0, 0, i10, i10);
                this.f1109w.setCompoundDrawables(this.f1112z, null, null, null);
            }
            this.f1109w.setVisibility(0);
            z7 |= true;
        }
        if (z(this.f1087a)) {
            if (z7) {
                b(this.f1101o);
            } else if (z7) {
                b(this.f1105s);
            } else if (z7) {
                b(this.f1109w);
            }
        }
        if (!z7) {
            z8 = false;
        }
        if (!z8) {
            viewGroup.setVisibility(8);
        }
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f1089c.findViewById(R$id.f913w);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f1092f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f1093g != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.A);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.f1093g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void w(ViewGroup viewGroup) {
        View view = this.f1094h;
        boolean z7 = false;
        if (view == null) {
            if (this.f1095i != 0) {
                view = LayoutInflater.from(this.f1087a).inflate(this.f1095i, viewGroup, false);
            } else {
                view = null;
            }
        }
        if (view != null) {
            z7 = true;
        }
        if (!z7 || !a(view)) {
            this.f1089c.setFlags(131072, 131072);
        }
        if (z7) {
            FrameLayout frameLayout = (FrameLayout) this.f1089c.findViewById(R$id.f904n);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f1100n) {
                frameLayout.setPadding(this.f1096j, this.f1097k, this.f1098l, this.f1099m);
            }
            if (this.f1093g != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f1089c.findViewById(R$id.O).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f1089c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f1091e)) && this.P) {
            TextView textView = (TextView) this.f1089c.findViewById(R$id.f900j);
            this.E = textView;
            textView.setText(this.f1091e);
            int i8 = this.B;
            if (i8 != 0) {
                this.D.setImageResource(i8);
                return;
            }
            Drawable drawable = this.C;
            if (drawable != null) {
                this.D.setImageDrawable(drawable);
                return;
            }
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
            return;
        }
        this.f1089c.findViewById(R$id.O).setVisibility(8);
        this.D.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y() {
        boolean z7;
        boolean z8;
        boolean z9;
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f1089c.findViewById(R$id.f910t);
        int i8 = R$id.P;
        View findViewById4 = findViewById3.findViewById(i8);
        int i9 = R$id.f903m;
        View findViewById5 = findViewById3.findViewById(i9);
        int i10 = R$id.f901k;
        View findViewById6 = findViewById3.findViewById(i10);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R$id.f905o);
        w(viewGroup);
        View findViewById7 = viewGroup.findViewById(i8);
        View findViewById8 = viewGroup.findViewById(i9);
        View findViewById9 = viewGroup.findViewById(i10);
        ViewGroup i11 = i(findViewById7, findViewById4);
        ViewGroup i12 = i(findViewById8, findViewById5);
        ViewGroup i13 = i(findViewById9, findViewById6);
        v(i12);
        u(i13);
        x(i11);
        int i14 = 0;
        if (viewGroup.getVisibility() != 8) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (i11 != null && i11.getVisibility() != 8) {
            z8 = 1;
        } else {
            z8 = 0;
        }
        if (i13 != null && i13.getVisibility() != 8) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (!z9 && i12 != null && (findViewById2 = i12.findViewById(R$id.K)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z8) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (this.f1092f != null || this.f1093g != null) {
                view = i11.findViewById(R$id.N);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (i12 != null && (findViewById = i12.findViewById(R$id.L)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f1093g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z8, z9);
        }
        if (!z7) {
            View view2 = this.f1093g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                if (z9) {
                    i14 = 2;
                }
                p(i12, view2, z8 | i14, 3);
            }
        }
        ListView listView2 = this.f1093g;
        if (listView2 != null && (listAdapter = this.H) != null) {
            listView2.setAdapter(listAdapter);
            int i15 = this.I;
            if (i15 > -1) {
                listView2.setItemChecked(i15, true);
                listView2.setSelection(i15);
            }
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.f827m, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public int c(int i8) {
        TypedValue typedValue = new TypedValue();
        this.f1087a.getTheme().resolveAttribute(i8, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f1093g;
    }

    public void e() {
        this.f1088b.setContentView(j());
        y();
    }

    public boolean g(int i8, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        if (nestedScrollView != null && nestedScrollView.s(keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean h(int i8, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        if (nestedScrollView != null && nestedScrollView.s(keyEvent)) {
            return true;
        }
        return false;
    }

    public void k(int i8, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i8, onClickListener);
        }
        if (i8 != -3) {
            if (i8 != -2) {
                if (i8 == -1) {
                    this.f1102p = charSequence;
                    this.f1103q = message;
                    this.f1104r = drawable;
                    return;
                }
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f1106t = charSequence;
            this.f1107u = message;
            this.f1108v = drawable;
            return;
        }
        this.f1110x = charSequence;
        this.f1111y = message;
        this.f1112z = drawable;
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i8) {
        this.C = null;
        this.B = i8;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i8 != 0) {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public void o(CharSequence charSequence) {
        this.f1092f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f1091e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i8) {
        this.f1094h = null;
        this.f1095i = i8;
        this.f1100n = false;
    }

    public void s(View view) {
        this.f1094h = view;
        this.f1095i = 0;
        this.f1100n = false;
    }

    public void t(View view, int i8, int i9, int i10, int i11) {
        this.f1094h = view;
        this.f1095i = 0;
        this.f1100n = true;
        this.f1096j = i8;
        this.f1097k = i9;
        this.f1098l = i10;
        this.f1099m = i11;
    }
}
