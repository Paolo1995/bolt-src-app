package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.core.R$id;
import androidx.core.os.BuildCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.fragment.app.FragmentTransaction;
import j$.util.Spliterator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {

    /* renamed from: d  reason: collision with root package name */
    private static int f6037d;

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f6038a;

    /* renamed from: b  reason: collision with root package name */
    public int f6039b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f6040c = -1;

    /* loaded from: classes.dex */
    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat A;
        public static final AccessibilityActionCompat B;
        public static final AccessibilityActionCompat C;
        public static final AccessibilityActionCompat D;
        public static final AccessibilityActionCompat E;
        public static final AccessibilityActionCompat F;
        @NonNull
        public static final AccessibilityActionCompat G;
        @NonNull
        public static final AccessibilityActionCompat H;
        @NonNull
        public static final AccessibilityActionCompat I;
        @NonNull
        public static final AccessibilityActionCompat J;
        public static final AccessibilityActionCompat K;
        public static final AccessibilityActionCompat L;
        public static final AccessibilityActionCompat M;
        public static final AccessibilityActionCompat N;
        public static final AccessibilityActionCompat O;
        @NonNull
        public static final AccessibilityActionCompat P;
        @NonNull
        public static final AccessibilityActionCompat Q;
        @NonNull
        public static final AccessibilityActionCompat R;
        @NonNull
        public static final AccessibilityActionCompat S;
        @NonNull
        public static final AccessibilityActionCompat T;
        @NonNull
        public static final AccessibilityActionCompat U;

        /* renamed from: e  reason: collision with root package name */
        public static final AccessibilityActionCompat f6041e = new AccessibilityActionCompat(1, null);

        /* renamed from: f  reason: collision with root package name */
        public static final AccessibilityActionCompat f6042f = new AccessibilityActionCompat(2, null);

        /* renamed from: g  reason: collision with root package name */
        public static final AccessibilityActionCompat f6043g = new AccessibilityActionCompat(4, null);

        /* renamed from: h  reason: collision with root package name */
        public static final AccessibilityActionCompat f6044h = new AccessibilityActionCompat(8, null);

        /* renamed from: i  reason: collision with root package name */
        public static final AccessibilityActionCompat f6045i = new AccessibilityActionCompat(16, null);

        /* renamed from: j  reason: collision with root package name */
        public static final AccessibilityActionCompat f6046j = new AccessibilityActionCompat(32, null);

        /* renamed from: k  reason: collision with root package name */
        public static final AccessibilityActionCompat f6047k = new AccessibilityActionCompat(64, null);

        /* renamed from: l  reason: collision with root package name */
        public static final AccessibilityActionCompat f6048l = new AccessibilityActionCompat(128, null);

        /* renamed from: m  reason: collision with root package name */
        public static final AccessibilityActionCompat f6049m = new AccessibilityActionCompat((int) Spliterator.NONNULL, (CharSequence) null, AccessibilityViewCommand.MoveAtGranularityArguments.class);

        /* renamed from: n  reason: collision with root package name */
        public static final AccessibilityActionCompat f6050n = new AccessibilityActionCompat(512, (CharSequence) null, AccessibilityViewCommand.MoveAtGranularityArguments.class);

        /* renamed from: o  reason: collision with root package name */
        public static final AccessibilityActionCompat f6051o = new AccessibilityActionCompat((int) Spliterator.IMMUTABLE, (CharSequence) null, AccessibilityViewCommand.MoveHtmlArguments.class);

        /* renamed from: p  reason: collision with root package name */
        public static final AccessibilityActionCompat f6052p = new AccessibilityActionCompat(2048, (CharSequence) null, AccessibilityViewCommand.MoveHtmlArguments.class);

        /* renamed from: q  reason: collision with root package name */
        public static final AccessibilityActionCompat f6053q = new AccessibilityActionCompat(4096, null);

        /* renamed from: r  reason: collision with root package name */
        public static final AccessibilityActionCompat f6054r = new AccessibilityActionCompat(FragmentTransaction.TRANSIT_EXIT_MASK, null);

        /* renamed from: s  reason: collision with root package name */
        public static final AccessibilityActionCompat f6055s = new AccessibilityActionCompat(16384, null);

        /* renamed from: t  reason: collision with root package name */
        public static final AccessibilityActionCompat f6056t = new AccessibilityActionCompat(32768, null);

        /* renamed from: u  reason: collision with root package name */
        public static final AccessibilityActionCompat f6057u = new AccessibilityActionCompat(65536, null);

        /* renamed from: v  reason: collision with root package name */
        public static final AccessibilityActionCompat f6058v = new AccessibilityActionCompat(131072, (CharSequence) null, AccessibilityViewCommand.SetSelectionArguments.class);

        /* renamed from: w  reason: collision with root package name */
        public static final AccessibilityActionCompat f6059w = new AccessibilityActionCompat(262144, null);

        /* renamed from: x  reason: collision with root package name */
        public static final AccessibilityActionCompat f6060x = new AccessibilityActionCompat(524288, null);

        /* renamed from: y  reason: collision with root package name */
        public static final AccessibilityActionCompat f6061y = new AccessibilityActionCompat(1048576, null);

        /* renamed from: z  reason: collision with root package name */
        public static final AccessibilityActionCompat f6062z = new AccessibilityActionCompat(2097152, (CharSequence) null, AccessibilityViewCommand.SetTextArguments.class);

        /* renamed from: a  reason: collision with root package name */
        final Object f6063a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6064b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<? extends AccessibilityViewCommand.CommandArguments> f6065c;

        /* renamed from: d  reason: collision with root package name */
        protected final AccessibilityViewCommand f6066d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction21 = null;
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 23) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
            } else {
                accessibilityAction = null;
            }
            A = new AccessibilityActionCompat(accessibilityAction, 16908342, null, null, null);
            if (i8 >= 23) {
                accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
            } else {
                accessibilityAction2 = null;
            }
            B = new AccessibilityActionCompat(accessibilityAction2, 16908343, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            if (i8 >= 23) {
                accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
            } else {
                accessibilityAction3 = null;
            }
            C = new AccessibilityActionCompat(accessibilityAction3, 16908344, null, null, null);
            if (i8 >= 23) {
                accessibilityAction4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
            } else {
                accessibilityAction4 = null;
            }
            D = new AccessibilityActionCompat(accessibilityAction4, 16908345, null, null, null);
            if (i8 >= 23) {
                accessibilityAction5 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
            } else {
                accessibilityAction5 = null;
            }
            E = new AccessibilityActionCompat(accessibilityAction5, 16908346, null, null, null);
            if (i8 >= 23) {
                accessibilityAction6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
            } else {
                accessibilityAction6 = null;
            }
            F = new AccessibilityActionCompat(accessibilityAction6, 16908347, null, null, null);
            if (i8 >= 29) {
                accessibilityAction7 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            } else {
                accessibilityAction7 = null;
            }
            G = new AccessibilityActionCompat(accessibilityAction7, 16908358, null, null, null);
            if (i8 >= 29) {
                accessibilityAction8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            } else {
                accessibilityAction8 = null;
            }
            H = new AccessibilityActionCompat(accessibilityAction8, 16908359, null, null, null);
            if (i8 >= 29) {
                accessibilityAction9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
            } else {
                accessibilityAction9 = null;
            }
            I = new AccessibilityActionCompat(accessibilityAction9, 16908360, null, null, null);
            if (i8 >= 29) {
                accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            } else {
                accessibilityAction10 = null;
            }
            J = new AccessibilityActionCompat(accessibilityAction10, 16908361, null, null, null);
            if (i8 >= 23) {
                accessibilityAction11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
            } else {
                accessibilityAction11 = null;
            }
            K = new AccessibilityActionCompat(accessibilityAction11, 16908348, null, null, null);
            if (i8 >= 24) {
                accessibilityAction12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            } else {
                accessibilityAction12 = null;
            }
            L = new AccessibilityActionCompat(accessibilityAction12, 16908349, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            if (i8 >= 26) {
                accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
            } else {
                accessibilityAction13 = null;
            }
            M = new AccessibilityActionCompat(accessibilityAction13, 16908354, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            if (i8 >= 28) {
                accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            } else {
                accessibilityAction14 = null;
            }
            N = new AccessibilityActionCompat(accessibilityAction14, 16908356, null, null, null);
            if (i8 >= 28) {
                accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            } else {
                accessibilityAction15 = null;
            }
            O = new AccessibilityActionCompat(accessibilityAction15, 16908357, null, null, null);
            if (i8 >= 30) {
                accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
            } else {
                accessibilityAction16 = null;
            }
            P = new AccessibilityActionCompat(accessibilityAction16, 16908362, null, null, null);
            if (i8 >= 30) {
                accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            } else {
                accessibilityAction17 = null;
            }
            Q = new AccessibilityActionCompat(accessibilityAction17, 16908372, null, null, null);
            if (i8 >= 32) {
                accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
            } else {
                accessibilityAction18 = null;
            }
            R = new AccessibilityActionCompat(accessibilityAction18, 16908373, null, null, null);
            if (i8 >= 32) {
                accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            } else {
                accessibilityAction19 = null;
            }
            S = new AccessibilityActionCompat(accessibilityAction19, 16908374, null, null, null);
            if (i8 >= 32) {
                accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            } else {
                accessibilityAction20 = null;
            }
            T = new AccessibilityActionCompat(accessibilityAction20, 16908375, null, null, null);
            if (i8 >= 33) {
                accessibilityAction21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            }
            U = new AccessibilityActionCompat(accessibilityAction21, 16908376, null, null, null);
        }

        public AccessibilityActionCompat(int i8, CharSequence charSequence) {
            this(null, i8, charSequence, null, null);
        }

        public AccessibilityActionCompat a(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat(null, this.f6064b, charSequence, accessibilityViewCommand, this.f6065c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f6063a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f6063a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            String name;
            if (this.f6066d == null) {
                return false;
            }
            AccessibilityViewCommand.CommandArguments commandArguments = null;
            Class<? extends AccessibilityViewCommand.CommandArguments> cls = this.f6065c;
            if (cls != null) {
                try {
                    AccessibilityViewCommand.CommandArguments newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        newInstance.a(bundle);
                        commandArguments = newInstance;
                    } catch (Exception e8) {
                        e = e8;
                        commandArguments = newInstance;
                        Class<? extends AccessibilityViewCommand.CommandArguments> cls2 = this.f6065c;
                        if (cls2 == null) {
                            name = "null";
                        } else {
                            name = cls2.getName();
                        }
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + name, e);
                        return this.f6066d.a(view, commandArguments);
                    }
                } catch (Exception e9) {
                    e = e9;
                }
            }
            return this.f6066d.a(view, commandArguments);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) obj;
            Object obj2 = this.f6063a;
            if (obj2 == null) {
                if (accessibilityActionCompat.f6063a != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(accessibilityActionCompat.f6063a)) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            Object obj = this.f6063a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public AccessibilityActionCompat(int i8, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this(null, i8, charSequence, accessibilityViewCommand, null);
        }

        AccessibilityActionCompat(Object obj) {
            this(obj, 0, null, null, null);
        }

        private AccessibilityActionCompat(int i8, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this(null, i8, charSequence, null, cls);
        }

        AccessibilityActionCompat(Object obj, int i8, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this.f6064b = i8;
            this.f6066d = accessibilityViewCommand;
            if (obj == null) {
                this.f6063a = new AccessibilityNodeInfo.AccessibilityAction(i8, charSequence);
            } else {
                this.f6063a = obj;
            }
            this.f6065c = cls;
        }
    }

    /* loaded from: classes.dex */
    public static class CollectionInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        final Object f6067a;

        CollectionInfoCompat(Object obj) {
            this.f6067a = obj;
        }

        public static CollectionInfoCompat a(int i8, int i9, boolean z7, int i10) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i8, i9, z7, i10));
        }
    }

    /* loaded from: classes.dex */
    public static class CollectionItemInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        final Object f6068a;

        CollectionItemInfoCompat(Object obj) {
            this.f6068a = obj;
        }

        public static CollectionItemInfoCompat a(int i8, int i9, int i10, int i11, boolean z7, boolean z8) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i8, i9, i10, i11, z7, z8));
        }
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f6038a = accessibilityNodeInfo;
    }

    public static AccessibilityNodeInfoCompat A0(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    public static AccessibilityNodeInfoCompat L() {
        return A0(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat M(View view) {
        return A0(AccessibilityNodeInfo.obtain(view));
    }

    public static AccessibilityNodeInfoCompat N(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return A0(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f6038a));
    }

    private void R(View view) {
        SparseArray<WeakReference<ClickableSpan>> u7 = u(view);
        if (u7 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i8 = 0; i8 < u7.size(); i8++) {
                if (u7.valueAt(i8).get() == null) {
                    arrayList.add(Integer.valueOf(i8));
                }
            }
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                u7.remove(((Integer) arrayList.get(i9)).intValue());
            }
        }
    }

    private void T(int i8, boolean z7) {
        Bundle r7 = r();
        if (r7 != null) {
            int i9 = r7.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i8);
            if (!z7) {
                i8 = 0;
            }
            r7.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i8 | i9);
        }
    }

    private void d(ClickableSpan clickableSpan, Spanned spanned, int i8) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i8));
    }

    private void f() {
        this.f6038a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f6038a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f6038a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f6038a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List<Integer> g(String str) {
        ArrayList<Integer> integerArrayList = this.f6038a.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.f6038a.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    private static String i(int i8) {
        if (i8 != 1) {
            if (i8 != 2) {
                switch (i8) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case Spliterator.NONNULL /* 256 */:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case Spliterator.IMMUTABLE /* 1024 */:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case FragmentTransaction.TRANSIT_EXIT_MASK /* 8192 */:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case 16908354:
                        return "ACTION_MOVE_WINDOW";
                    default:
                        switch (i8) {
                            case 16908342:
                                return "ACTION_SHOW_ON_SCREEN";
                            case 16908343:
                                return "ACTION_SCROLL_TO_POSITION";
                            case 16908344:
                                return "ACTION_SCROLL_UP";
                            case 16908345:
                                return "ACTION_SCROLL_LEFT";
                            case 16908346:
                                return "ACTION_SCROLL_DOWN";
                            case 16908347:
                                return "ACTION_SCROLL_RIGHT";
                            case 16908348:
                                return "ACTION_CONTEXT_CLICK";
                            case 16908349:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i8) {
                                    case 16908356:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case 16908357:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case 16908358:
                                        return "ACTION_PAGE_UP";
                                    case 16908359:
                                        return "ACTION_PAGE_DOWN";
                                    case 16908360:
                                        return "ACTION_PAGE_LEFT";
                                    case 16908361:
                                        return "ACTION_PAGE_RIGHT";
                                    case 16908362:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        switch (i8) {
                                            case 16908372:
                                                return "ACTION_IME_ENTER";
                                            case 16908373:
                                                return "ACTION_DRAG_START";
                                            case 16908374:
                                                return "ACTION_DRAG_DROP";
                                            case 16908375:
                                                return "ACTION_DRAG_CANCEL";
                                            default:
                                                return "ACTION_UNKNOWN";
                                        }
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    private boolean k(int i8) {
        Bundle r7 = r();
        if (r7 == null || (r7.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i8) != i8) {
            return false;
        }
        return true;
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> s(View view) {
        SparseArray<WeakReference<ClickableSpan>> u7 = u(view);
        if (u7 == null) {
            SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
            view.setTag(R$id.I, sparseArray);
            return sparseArray;
        }
        return u7;
    }

    private SparseArray<WeakReference<ClickableSpan>> u(View view) {
        return (SparseArray) view.getTag(R$id.I);
    }

    private boolean y() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int z(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i8 = 0; i8 < sparseArray.size(); i8++) {
                if (clickableSpan.equals(sparseArray.valueAt(i8).get())) {
                    return sparseArray.keyAt(i8);
                }
            }
        }
        int i9 = f6037d;
        f6037d = i9 + 1;
        return i9;
    }

    public boolean A() {
        return this.f6038a.isCheckable();
    }

    public boolean B() {
        return this.f6038a.isChecked();
    }

    public boolean C() {
        return this.f6038a.isClickable();
    }

    public boolean D() {
        return this.f6038a.isEnabled();
    }

    public boolean E() {
        return this.f6038a.isFocusable();
    }

    public boolean F() {
        return this.f6038a.isFocused();
    }

    public boolean G() {
        return this.f6038a.isLongClickable();
    }

    public boolean H() {
        return this.f6038a.isPassword();
    }

    public boolean I() {
        return this.f6038a.isScrollable();
    }

    public boolean J() {
        return this.f6038a.isSelected();
    }

    public boolean K() {
        boolean isShowingHintText;
        if (Build.VERSION.SDK_INT >= 26) {
            isShowingHintText = this.f6038a.isShowingHintText();
            return isShowingHintText;
        }
        return k(4);
    }

    public boolean O(int i8, Bundle bundle) {
        return this.f6038a.performAction(i8, bundle);
    }

    public void P() {
        this.f6038a.recycle();
    }

    public boolean Q(AccessibilityActionCompat accessibilityActionCompat) {
        return this.f6038a.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f6063a);
    }

    public void S(boolean z7) {
        this.f6038a.setAccessibilityFocused(z7);
    }

    @Deprecated
    public void U(Rect rect) {
        this.f6038a.setBoundsInParent(rect);
    }

    public void V(Rect rect) {
        this.f6038a.setBoundsInScreen(rect);
    }

    public void W(boolean z7) {
        this.f6038a.setCheckable(z7);
    }

    public void X(boolean z7) {
        this.f6038a.setChecked(z7);
    }

    public void Y(CharSequence charSequence) {
        this.f6038a.setClassName(charSequence);
    }

    public void Z(boolean z7) {
        this.f6038a.setClickable(z7);
    }

    public void a(int i8) {
        this.f6038a.addAction(i8);
    }

    public void a0(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f6038a;
        if (obj == null) {
            collectionInfo = null;
        } else {
            collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).f6067a;
        }
        accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    }

    public void b(AccessibilityActionCompat accessibilityActionCompat) {
        this.f6038a.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f6063a);
    }

    public void b0(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f6038a;
        if (obj == null) {
            collectionItemInfo = null;
        } else {
            collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).f6068a;
        }
        accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
    }

    public void c(View view, int i8) {
        this.f6038a.addChild(view, i8);
    }

    public void c0(CharSequence charSequence) {
        this.f6038a.setContentDescription(charSequence);
    }

    public void d0(boolean z7) {
        this.f6038a.setDismissable(z7);
    }

    public void e(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            f();
            R(view);
            ClickableSpan[] p8 = p(charSequence);
            if (p8 != null && p8.length > 0) {
                r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.f5485a);
                SparseArray<WeakReference<ClickableSpan>> s7 = s(view);
                for (int i8 = 0; i8 < p8.length; i8++) {
                    int z7 = z(p8[i8], s7);
                    s7.put(z7, new WeakReference<>(p8[i8]));
                    d(p8[i8], (Spanned) charSequence, z7);
                }
            }
        }
    }

    public void e0(boolean z7) {
        this.f6038a.setEnabled(z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f6038a;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.f6038a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.f6038a)) {
            return false;
        }
        if (this.f6040c == accessibilityNodeInfoCompat.f6040c && this.f6039b == accessibilityNodeInfoCompat.f6039b) {
            return true;
        }
        return false;
    }

    public void f0(CharSequence charSequence) {
        this.f6038a.setError(charSequence);
    }

    public void g0(boolean z7) {
        this.f6038a.setFocusable(z7);
    }

    public List<AccessibilityActionCompat> h() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f6038a.getActionList();
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i8 = 0; i8 < size; i8++) {
                arrayList.add(new AccessibilityActionCompat(actionList.get(i8)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void h0(boolean z7) {
        this.f6038a.setFocused(z7);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f6038a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(boolean z7) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6038a.setHeading(z7);
        } else {
            T(2, z7);
        }
    }

    @Deprecated
    public int j() {
        return this.f6038a.getActions();
    }

    public void j0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6038a.setHintText(charSequence);
        } else {
            this.f6038a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void k0(View view) {
        this.f6038a.setLabelFor(view);
    }

    @Deprecated
    public void l(Rect rect) {
        this.f6038a.getBoundsInParent(rect);
    }

    public void l0(int i8) {
        this.f6038a.setMaxTextLength(i8);
    }

    public void m(Rect rect) {
        this.f6038a.getBoundsInScreen(rect);
    }

    public void m0(CharSequence charSequence) {
        this.f6038a.setPackageName(charSequence);
    }

    public int n() {
        return this.f6038a.getChildCount();
    }

    public void n0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6038a.setPaneTitle(charSequence);
        } else {
            this.f6038a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public CharSequence o() {
        return this.f6038a.getClassName();
    }

    public void o0(View view) {
        this.f6039b = -1;
        this.f6038a.setParent(view);
    }

    public void p0(View view, int i8) {
        this.f6039b = i8;
        this.f6038a.setParent(view, i8);
    }

    public CharSequence q() {
        return this.f6038a.getContentDescription();
    }

    public void q0(CharSequence charSequence) {
        this.f6038a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public Bundle r() {
        return this.f6038a.getExtras();
    }

    public void r0(boolean z7) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6038a.setScreenReaderFocusable(z7);
        } else {
            T(1, z7);
        }
    }

    public void s0(boolean z7) {
        this.f6038a.setScrollable(z7);
    }

    public CharSequence t() {
        return this.f6038a.getPackageName();
    }

    public void t0(boolean z7) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6038a.setShowingHintText(z7);
        } else {
            T(4, z7);
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb.append("; boundsInParent: " + rect);
        m(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(t());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(v());
        sb.append("; contentDescription: ");
        sb.append(q());
        sb.append("; viewId: ");
        sb.append(x());
        sb.append("; uniqueId: ");
        sb.append(w());
        sb.append("; checkable: ");
        sb.append(A());
        sb.append("; checked: ");
        sb.append(B());
        sb.append("; focusable: ");
        sb.append(E());
        sb.append("; focused: ");
        sb.append(F());
        sb.append("; selected: ");
        sb.append(J());
        sb.append("; clickable: ");
        sb.append(C());
        sb.append("; longClickable: ");
        sb.append(G());
        sb.append("; enabled: ");
        sb.append(D());
        sb.append("; password: ");
        sb.append(H());
        sb.append("; scrollable: " + I());
        sb.append("; [");
        List<AccessibilityActionCompat> h8 = h();
        for (int i8 = 0; i8 < h8.size(); i8++) {
            AccessibilityActionCompat accessibilityActionCompat = h8.get(i8);
            String i9 = i(accessibilityActionCompat.b());
            if (i9.equals("ACTION_UNKNOWN") && accessibilityActionCompat.c() != null) {
                i9 = accessibilityActionCompat.c().toString();
            }
            sb.append(i9);
            if (i8 != h8.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void u0(View view, int i8) {
        this.f6040c = i8;
        this.f6038a.setSource(view, i8);
    }

    public CharSequence v() {
        if (y()) {
            List<Integer> g8 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> g9 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> g10 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> g11 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.f6038a.getText(), 0, this.f6038a.getText().length()));
            for (int i8 = 0; i8 < g8.size(); i8++) {
                spannableString.setSpan(new AccessibilityClickableSpanCompat(g11.get(i8).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), g8.get(i8).intValue(), g9.get(i8).intValue(), g10.get(i8).intValue());
            }
            return spannableString;
        }
        return this.f6038a.getText();
    }

    public void v0(CharSequence charSequence) {
        if (BuildCompat.b()) {
            this.f6038a.setStateDescription(charSequence);
        } else {
            this.f6038a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public String w() {
        if (BuildCompat.d()) {
            return this.f6038a.getUniqueId();
        }
        return this.f6038a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void w0(CharSequence charSequence) {
        this.f6038a.setText(charSequence);
    }

    public String x() {
        return this.f6038a.getViewIdResourceName();
    }

    public void x0(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f6038a.setTraversalAfter(view);
        }
    }

    public void y0(boolean z7) {
        this.f6038a.setVisibleToUser(z7);
    }

    public AccessibilityNodeInfo z0() {
        return this.f6038a;
    }
}
