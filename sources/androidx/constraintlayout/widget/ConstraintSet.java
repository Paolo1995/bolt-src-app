package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Name;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ConstraintSet {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f5069f = {0, 4, 8};

    /* renamed from: g  reason: collision with root package name */
    private static SparseIntArray f5070g = new SparseIntArray();

    /* renamed from: h  reason: collision with root package name */
    private static SparseIntArray f5071h = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    public String f5072a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f5073b = 0;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, ConstraintAttribute> f5074c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f5075d = true;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<Integer, Constraint> f5076e = new HashMap<>();

    /* loaded from: classes.dex */
    public static class Constraint {

        /* renamed from: a  reason: collision with root package name */
        int f5077a;

        /* renamed from: b  reason: collision with root package name */
        String f5078b;

        /* renamed from: c  reason: collision with root package name */
        public final PropertySet f5079c = new PropertySet();

        /* renamed from: d  reason: collision with root package name */
        public final Motion f5080d = new Motion();

        /* renamed from: e  reason: collision with root package name */
        public final Layout f5081e = new Layout();

        /* renamed from: f  reason: collision with root package name */
        public final Transform f5082f = new Transform();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f5083g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        Delta f5084h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class Delta {

            /* renamed from: a  reason: collision with root package name */
            int[] f5085a = new int[10];

            /* renamed from: b  reason: collision with root package name */
            int[] f5086b = new int[10];

            /* renamed from: c  reason: collision with root package name */
            int f5087c = 0;

            /* renamed from: d  reason: collision with root package name */
            int[] f5088d = new int[10];

            /* renamed from: e  reason: collision with root package name */
            float[] f5089e = new float[10];

            /* renamed from: f  reason: collision with root package name */
            int f5090f = 0;

            /* renamed from: g  reason: collision with root package name */
            int[] f5091g = new int[5];

            /* renamed from: h  reason: collision with root package name */
            String[] f5092h = new String[5];

            /* renamed from: i  reason: collision with root package name */
            int f5093i = 0;

            /* renamed from: j  reason: collision with root package name */
            int[] f5094j = new int[4];

            /* renamed from: k  reason: collision with root package name */
            boolean[] f5095k = new boolean[4];

            /* renamed from: l  reason: collision with root package name */
            int f5096l = 0;

            Delta() {
            }

            void a(int i8, float f8) {
                int i9 = this.f5090f;
                int[] iArr = this.f5088d;
                if (i9 >= iArr.length) {
                    this.f5088d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f5089e;
                    this.f5089e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f5088d;
                int i10 = this.f5090f;
                iArr2[i10] = i8;
                float[] fArr2 = this.f5089e;
                this.f5090f = i10 + 1;
                fArr2[i10] = f8;
            }

            void b(int i8, int i9) {
                int i10 = this.f5087c;
                int[] iArr = this.f5085a;
                if (i10 >= iArr.length) {
                    this.f5085a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f5086b;
                    this.f5086b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f5085a;
                int i11 = this.f5087c;
                iArr3[i11] = i8;
                int[] iArr4 = this.f5086b;
                this.f5087c = i11 + 1;
                iArr4[i11] = i9;
            }

            void c(int i8, String str) {
                int i9 = this.f5093i;
                int[] iArr = this.f5091g;
                if (i9 >= iArr.length) {
                    this.f5091g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f5092h;
                    this.f5092h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f5091g;
                int i10 = this.f5093i;
                iArr2[i10] = i8;
                String[] strArr2 = this.f5092h;
                this.f5093i = i10 + 1;
                strArr2[i10] = str;
            }

            void d(int i8, boolean z7) {
                int i9 = this.f5096l;
                int[] iArr = this.f5094j;
                if (i9 >= iArr.length) {
                    this.f5094j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f5095k;
                    this.f5095k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f5094j;
                int i10 = this.f5096l;
                iArr2[i10] = i8;
                boolean[] zArr2 = this.f5095k;
                this.f5096l = i10 + 1;
                zArr2[i10] = z7;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i8, ConstraintLayout.LayoutParams layoutParams) {
            this.f5077a = i8;
            Layout layout = this.f5081e;
            layout.f5116j = layoutParams.f5002e;
            layout.f5118k = layoutParams.f5004f;
            layout.f5120l = layoutParams.f5006g;
            layout.f5122m = layoutParams.f5008h;
            layout.f5124n = layoutParams.f5010i;
            layout.f5126o = layoutParams.f5012j;
            layout.f5128p = layoutParams.f5014k;
            layout.f5130q = layoutParams.f5016l;
            layout.f5132r = layoutParams.f5018m;
            layout.f5133s = layoutParams.f5020n;
            layout.f5134t = layoutParams.f5022o;
            layout.f5135u = layoutParams.f5030s;
            layout.f5136v = layoutParams.f5032t;
            layout.f5137w = layoutParams.f5034u;
            layout.f5138x = layoutParams.f5036v;
            layout.f5139y = layoutParams.G;
            layout.f5140z = layoutParams.H;
            layout.A = layoutParams.I;
            layout.B = layoutParams.f5024p;
            layout.C = layoutParams.f5026q;
            layout.D = layoutParams.f5028r;
            layout.E = layoutParams.X;
            layout.F = layoutParams.Y;
            layout.G = layoutParams.Z;
            layout.f5112h = layoutParams.f4998c;
            layout.f5108f = layoutParams.f4994a;
            layout.f5110g = layoutParams.f4996b;
            layout.f5104d = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            layout.f5106e = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            layout.H = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layout.I = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            layout.J = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            layout.K = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            layout.N = layoutParams.D;
            layout.V = layoutParams.M;
            layout.W = layoutParams.L;
            layout.Y = layoutParams.O;
            layout.X = layoutParams.N;
            layout.f5125n0 = layoutParams.f4995a0;
            layout.f5127o0 = layoutParams.f4997b0;
            layout.Z = layoutParams.P;
            layout.f5099a0 = layoutParams.Q;
            layout.f5101b0 = layoutParams.T;
            layout.f5103c0 = layoutParams.U;
            layout.f5105d0 = layoutParams.R;
            layout.f5107e0 = layoutParams.S;
            layout.f5109f0 = layoutParams.V;
            layout.f5111g0 = layoutParams.W;
            layout.f5123m0 = layoutParams.f4999c0;
            layout.P = layoutParams.f5040x;
            layout.R = layoutParams.f5042z;
            layout.O = layoutParams.f5038w;
            layout.Q = layoutParams.f5041y;
            layout.T = layoutParams.A;
            layout.S = layoutParams.B;
            layout.U = layoutParams.C;
            layout.f5131q0 = layoutParams.f5001d0;
            layout.L = layoutParams.getMarginEnd();
            this.f5081e.M = layoutParams.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i8, Constraints.LayoutParams layoutParams) {
            f(i8, layoutParams);
            this.f5079c.f5159d = layoutParams.f5177x0;
            Transform transform = this.f5082f;
            transform.f5163b = layoutParams.A0;
            transform.f5164c = layoutParams.B0;
            transform.f5165d = layoutParams.C0;
            transform.f5166e = layoutParams.D0;
            transform.f5167f = layoutParams.E0;
            transform.f5168g = layoutParams.F0;
            transform.f5169h = layoutParams.G0;
            transform.f5171j = layoutParams.H0;
            transform.f5172k = layoutParams.I0;
            transform.f5173l = layoutParams.J0;
            transform.f5175n = layoutParams.f5179z0;
            transform.f5174m = layoutParams.f5178y0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(ConstraintHelper constraintHelper, int i8, Constraints.LayoutParams layoutParams) {
            g(i8, layoutParams);
            if (constraintHelper instanceof Barrier) {
                Layout layout = this.f5081e;
                layout.f5117j0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                layout.f5113h0 = barrier.getType();
                this.f5081e.f5119k0 = barrier.getReferencedIds();
                this.f5081e.f5115i0 = barrier.getMargin();
            }
        }

        public void d(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.f5081e;
            layoutParams.f5002e = layout.f5116j;
            layoutParams.f5004f = layout.f5118k;
            layoutParams.f5006g = layout.f5120l;
            layoutParams.f5008h = layout.f5122m;
            layoutParams.f5010i = layout.f5124n;
            layoutParams.f5012j = layout.f5126o;
            layoutParams.f5014k = layout.f5128p;
            layoutParams.f5016l = layout.f5130q;
            layoutParams.f5018m = layout.f5132r;
            layoutParams.f5020n = layout.f5133s;
            layoutParams.f5022o = layout.f5134t;
            layoutParams.f5030s = layout.f5135u;
            layoutParams.f5032t = layout.f5136v;
            layoutParams.f5034u = layout.f5137w;
            layoutParams.f5036v = layout.f5138x;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.H;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.I;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.J;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.K;
            layoutParams.A = layout.T;
            layoutParams.B = layout.S;
            layoutParams.f5040x = layout.P;
            layoutParams.f5042z = layout.R;
            layoutParams.G = layout.f5139y;
            layoutParams.H = layout.f5140z;
            layoutParams.f5024p = layout.B;
            layoutParams.f5026q = layout.C;
            layoutParams.f5028r = layout.D;
            layoutParams.I = layout.A;
            layoutParams.X = layout.E;
            layoutParams.Y = layout.F;
            layoutParams.M = layout.V;
            layoutParams.L = layout.W;
            layoutParams.O = layout.Y;
            layoutParams.N = layout.X;
            layoutParams.f4995a0 = layout.f5125n0;
            layoutParams.f4997b0 = layout.f5127o0;
            layoutParams.P = layout.Z;
            layoutParams.Q = layout.f5099a0;
            layoutParams.T = layout.f5101b0;
            layoutParams.U = layout.f5103c0;
            layoutParams.R = layout.f5105d0;
            layoutParams.S = layout.f5107e0;
            layoutParams.V = layout.f5109f0;
            layoutParams.W = layout.f5111g0;
            layoutParams.Z = layout.G;
            layoutParams.f4998c = layout.f5112h;
            layoutParams.f4994a = layout.f5108f;
            layoutParams.f4996b = layout.f5110g;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = layout.f5104d;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = layout.f5106e;
            String str = layout.f5123m0;
            if (str != null) {
                layoutParams.f4999c0 = str;
            }
            layoutParams.f5001d0 = layout.f5131q0;
            layoutParams.setMarginStart(layout.M);
            layoutParams.setMarginEnd(this.f5081e.L);
            layoutParams.a();
        }

        /* renamed from: e */
        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.f5081e.a(this.f5081e);
            constraint.f5080d.a(this.f5080d);
            constraint.f5079c.a(this.f5079c);
            constraint.f5082f.a(this.f5082f);
            constraint.f5077a = this.f5077a;
            constraint.f5084h = this.f5084h;
            return constraint;
        }
    }

    /* loaded from: classes.dex */
    public static class Layout {

        /* renamed from: r0  reason: collision with root package name */
        private static SparseIntArray f5097r0;

        /* renamed from: d  reason: collision with root package name */
        public int f5104d;

        /* renamed from: e  reason: collision with root package name */
        public int f5106e;

        /* renamed from: k0  reason: collision with root package name */
        public int[] f5119k0;

        /* renamed from: l0  reason: collision with root package name */
        public String f5121l0;

        /* renamed from: m0  reason: collision with root package name */
        public String f5123m0;

        /* renamed from: a  reason: collision with root package name */
        public boolean f5098a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5100b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5102c = false;

        /* renamed from: f  reason: collision with root package name */
        public int f5108f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f5110g = -1;

        /* renamed from: h  reason: collision with root package name */
        public float f5112h = -1.0f;

        /* renamed from: i  reason: collision with root package name */
        public boolean f5114i = true;

        /* renamed from: j  reason: collision with root package name */
        public int f5116j = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f5118k = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f5120l = -1;

        /* renamed from: m  reason: collision with root package name */
        public int f5122m = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f5124n = -1;

        /* renamed from: o  reason: collision with root package name */
        public int f5126o = -1;

        /* renamed from: p  reason: collision with root package name */
        public int f5128p = -1;

        /* renamed from: q  reason: collision with root package name */
        public int f5130q = -1;

        /* renamed from: r  reason: collision with root package name */
        public int f5132r = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f5133s = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f5134t = -1;

        /* renamed from: u  reason: collision with root package name */
        public int f5135u = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f5136v = -1;

        /* renamed from: w  reason: collision with root package name */
        public int f5137w = -1;

        /* renamed from: x  reason: collision with root package name */
        public int f5138x = -1;

        /* renamed from: y  reason: collision with root package name */
        public float f5139y = 0.5f;

        /* renamed from: z  reason: collision with root package name */
        public float f5140z = 0.5f;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a0  reason: collision with root package name */
        public int f5099a0 = 0;

        /* renamed from: b0  reason: collision with root package name */
        public int f5101b0 = 0;

        /* renamed from: c0  reason: collision with root package name */
        public int f5103c0 = 0;

        /* renamed from: d0  reason: collision with root package name */
        public int f5105d0 = 0;

        /* renamed from: e0  reason: collision with root package name */
        public int f5107e0 = 0;

        /* renamed from: f0  reason: collision with root package name */
        public float f5109f0 = 1.0f;

        /* renamed from: g0  reason: collision with root package name */
        public float f5111g0 = 1.0f;

        /* renamed from: h0  reason: collision with root package name */
        public int f5113h0 = -1;

        /* renamed from: i0  reason: collision with root package name */
        public int f5115i0 = 0;

        /* renamed from: j0  reason: collision with root package name */
        public int f5117j0 = -1;

        /* renamed from: n0  reason: collision with root package name */
        public boolean f5125n0 = false;

        /* renamed from: o0  reason: collision with root package name */
        public boolean f5127o0 = false;

        /* renamed from: p0  reason: collision with root package name */
        public boolean f5129p0 = true;

        /* renamed from: q0  reason: collision with root package name */
        public int f5131q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f5097r0 = sparseIntArray;
            sparseIntArray.append(R$styleable.f5384w6, 24);
            f5097r0.append(R$styleable.f5392x6, 25);
            f5097r0.append(R$styleable.f5408z6, 28);
            f5097r0.append(R$styleable.A6, 29);
            f5097r0.append(R$styleable.F6, 35);
            f5097r0.append(R$styleable.E6, 34);
            f5097r0.append(R$styleable.f5245g6, 4);
            f5097r0.append(R$styleable.f5236f6, 3);
            f5097r0.append(R$styleable.f5218d6, 1);
            f5097r0.append(R$styleable.L6, 6);
            f5097r0.append(R$styleable.M6, 7);
            f5097r0.append(R$styleable.f5308n6, 17);
            f5097r0.append(R$styleable.f5317o6, 18);
            f5097r0.append(R$styleable.f5326p6, 19);
            f5097r0.append(R$styleable.Z5, 90);
            f5097r0.append(R$styleable.L5, 26);
            f5097r0.append(R$styleable.B6, 31);
            f5097r0.append(R$styleable.C6, 32);
            f5097r0.append(R$styleable.f5299m6, 10);
            f5097r0.append(R$styleable.f5290l6, 9);
            f5097r0.append(R$styleable.P6, 13);
            f5097r0.append(R$styleable.S6, 16);
            f5097r0.append(R$styleable.Q6, 14);
            f5097r0.append(R$styleable.N6, 11);
            f5097r0.append(R$styleable.R6, 15);
            f5097r0.append(R$styleable.O6, 12);
            f5097r0.append(R$styleable.I6, 38);
            f5097r0.append(R$styleable.f5368u6, 37);
            f5097r0.append(R$styleable.f5360t6, 39);
            f5097r0.append(R$styleable.H6, 40);
            f5097r0.append(R$styleable.f5352s6, 20);
            f5097r0.append(R$styleable.G6, 36);
            f5097r0.append(R$styleable.f5281k6, 5);
            f5097r0.append(R$styleable.f5376v6, 91);
            f5097r0.append(R$styleable.D6, 91);
            f5097r0.append(R$styleable.f5400y6, 91);
            f5097r0.append(R$styleable.f5227e6, 91);
            f5097r0.append(R$styleable.f5209c6, 91);
            f5097r0.append(R$styleable.O5, 23);
            f5097r0.append(R$styleable.Q5, 27);
            f5097r0.append(R$styleable.S5, 30);
            f5097r0.append(R$styleable.T5, 8);
            f5097r0.append(R$styleable.P5, 33);
            f5097r0.append(R$styleable.R5, 2);
            f5097r0.append(R$styleable.M5, 22);
            f5097r0.append(R$styleable.N5, 21);
            f5097r0.append(R$styleable.J6, 41);
            f5097r0.append(R$styleable.f5335q6, 42);
            f5097r0.append(R$styleable.f5200b6, 41);
            f5097r0.append(R$styleable.f5191a6, 42);
            f5097r0.append(R$styleable.T6, 76);
            f5097r0.append(R$styleable.f5254h6, 61);
            f5097r0.append(R$styleable.f5272j6, 62);
            f5097r0.append(R$styleable.f5263i6, 63);
            f5097r0.append(R$styleable.K6, 69);
            f5097r0.append(R$styleable.f5344r6, 70);
            f5097r0.append(R$styleable.X5, 71);
            f5097r0.append(R$styleable.V5, 72);
            f5097r0.append(R$styleable.W5, 73);
            f5097r0.append(R$styleable.Y5, 74);
            f5097r0.append(R$styleable.U5, 75);
        }

        public void a(Layout layout) {
            this.f5098a = layout.f5098a;
            this.f5104d = layout.f5104d;
            this.f5100b = layout.f5100b;
            this.f5106e = layout.f5106e;
            this.f5108f = layout.f5108f;
            this.f5110g = layout.f5110g;
            this.f5112h = layout.f5112h;
            this.f5114i = layout.f5114i;
            this.f5116j = layout.f5116j;
            this.f5118k = layout.f5118k;
            this.f5120l = layout.f5120l;
            this.f5122m = layout.f5122m;
            this.f5124n = layout.f5124n;
            this.f5126o = layout.f5126o;
            this.f5128p = layout.f5128p;
            this.f5130q = layout.f5130q;
            this.f5132r = layout.f5132r;
            this.f5133s = layout.f5133s;
            this.f5134t = layout.f5134t;
            this.f5135u = layout.f5135u;
            this.f5136v = layout.f5136v;
            this.f5137w = layout.f5137w;
            this.f5138x = layout.f5138x;
            this.f5139y = layout.f5139y;
            this.f5140z = layout.f5140z;
            this.A = layout.A;
            this.B = layout.B;
            this.C = layout.C;
            this.D = layout.D;
            this.E = layout.E;
            this.F = layout.F;
            this.G = layout.G;
            this.H = layout.H;
            this.I = layout.I;
            this.J = layout.J;
            this.K = layout.K;
            this.L = layout.L;
            this.M = layout.M;
            this.N = layout.N;
            this.O = layout.O;
            this.P = layout.P;
            this.Q = layout.Q;
            this.R = layout.R;
            this.S = layout.S;
            this.T = layout.T;
            this.U = layout.U;
            this.V = layout.V;
            this.W = layout.W;
            this.X = layout.X;
            this.Y = layout.Y;
            this.Z = layout.Z;
            this.f5099a0 = layout.f5099a0;
            this.f5101b0 = layout.f5101b0;
            this.f5103c0 = layout.f5103c0;
            this.f5105d0 = layout.f5105d0;
            this.f5107e0 = layout.f5107e0;
            this.f5109f0 = layout.f5109f0;
            this.f5111g0 = layout.f5111g0;
            this.f5113h0 = layout.f5113h0;
            this.f5115i0 = layout.f5115i0;
            this.f5117j0 = layout.f5117j0;
            this.f5123m0 = layout.f5123m0;
            int[] iArr = layout.f5119k0;
            if (iArr != null && layout.f5121l0 == null) {
                this.f5119k0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f5119k0 = null;
            }
            this.f5121l0 = layout.f5121l0;
            this.f5125n0 = layout.f5125n0;
            this.f5127o0 = layout.f5127o0;
            this.f5129p0 = layout.f5129p0;
            this.f5131q0 = layout.f5131q0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.K5);
            this.f5100b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                int i9 = f5097r0.get(index);
                switch (i9) {
                    case 1:
                        this.f5132r = ConstraintSet.t(obtainStyledAttributes, index, this.f5132r);
                        break;
                    case 2:
                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.f5130q = ConstraintSet.t(obtainStyledAttributes, index, this.f5130q);
                        break;
                    case 4:
                        this.f5128p = ConstraintSet.t(obtainStyledAttributes, index, this.f5128p);
                        break;
                    case 5:
                        this.A = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = obtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = obtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.f5138x = ConstraintSet.t(obtainStyledAttributes, index, this.f5138x);
                        break;
                    case 10:
                        this.f5137w = ConstraintSet.t(obtainStyledAttributes, index, this.f5137w);
                        break;
                    case 11:
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 17:
                        this.f5108f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f5108f);
                        break;
                    case 18:
                        this.f5110g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f5110g);
                        break;
                    case 19:
                        this.f5112h = obtainStyledAttributes.getFloat(index, this.f5112h);
                        break;
                    case 20:
                        this.f5139y = obtainStyledAttributes.getFloat(index, this.f5139y);
                        break;
                    case 21:
                        this.f5106e = obtainStyledAttributes.getLayoutDimension(index, this.f5106e);
                        break;
                    case 22:
                        this.f5104d = obtainStyledAttributes.getLayoutDimension(index, this.f5104d);
                        break;
                    case 23:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.f5116j = ConstraintSet.t(obtainStyledAttributes, index, this.f5116j);
                        break;
                    case 25:
                        this.f5118k = ConstraintSet.t(obtainStyledAttributes, index, this.f5118k);
                        break;
                    case 26:
                        this.G = obtainStyledAttributes.getInt(index, this.G);
                        break;
                    case 27:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 28:
                        this.f5120l = ConstraintSet.t(obtainStyledAttributes, index, this.f5120l);
                        break;
                    case 29:
                        this.f5122m = ConstraintSet.t(obtainStyledAttributes, index, this.f5122m);
                        break;
                    case 30:
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 31:
                        this.f5135u = ConstraintSet.t(obtainStyledAttributes, index, this.f5135u);
                        break;
                    case 32:
                        this.f5136v = ConstraintSet.t(obtainStyledAttributes, index, this.f5136v);
                        break;
                    case 33:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 34:
                        this.f5126o = ConstraintSet.t(obtainStyledAttributes, index, this.f5126o);
                        break;
                    case 35:
                        this.f5124n = ConstraintSet.t(obtainStyledAttributes, index, this.f5124n);
                        break;
                    case 36:
                        this.f5140z = obtainStyledAttributes.getFloat(index, this.f5140z);
                        break;
                    case 37:
                        this.W = obtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = obtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = obtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        ConstraintSet.u(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.u(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i9) {
                            case 61:
                                this.B = ConstraintSet.t(obtainStyledAttributes, index, this.B);
                                continue;
                            case 62:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                continue;
                            case 63:
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                continue;
                            default:
                                switch (i9) {
                                    case 69:
                                        this.f5109f0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 70:
                                        this.f5111g0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        continue;
                                    case 72:
                                        this.f5113h0 = obtainStyledAttributes.getInt(index, this.f5113h0);
                                        continue;
                                    case 73:
                                        this.f5115i0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f5115i0);
                                        continue;
                                    case 74:
                                        this.f5121l0 = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 75:
                                        this.f5129p0 = obtainStyledAttributes.getBoolean(index, this.f5129p0);
                                        continue;
                                    case 76:
                                        this.f5131q0 = obtainStyledAttributes.getInt(index, this.f5131q0);
                                        continue;
                                    case 77:
                                        this.f5133s = ConstraintSet.t(obtainStyledAttributes, index, this.f5133s);
                                        continue;
                                    case 78:
                                        this.f5134t = ConstraintSet.t(obtainStyledAttributes, index, this.f5134t);
                                        continue;
                                    case 79:
                                        this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        continue;
                                    case 80:
                                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        continue;
                                    case 81:
                                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                        continue;
                                    case 82:
                                        this.f5099a0 = obtainStyledAttributes.getInt(index, this.f5099a0);
                                        continue;
                                    case 83:
                                        this.f5103c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f5103c0);
                                        continue;
                                    case 84:
                                        this.f5101b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f5101b0);
                                        continue;
                                    case 85:
                                        this.f5107e0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f5107e0);
                                        continue;
                                    case 86:
                                        this.f5105d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f5105d0);
                                        continue;
                                    case 87:
                                        this.f5125n0 = obtainStyledAttributes.getBoolean(index, this.f5125n0);
                                        continue;
                                    case 88:
                                        this.f5127o0 = obtainStyledAttributes.getBoolean(index, this.f5127o0);
                                        continue;
                                    case 89:
                                        this.f5123m0 = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 90:
                                        this.f5114i = obtainStyledAttributes.getBoolean(index, this.f5114i);
                                        continue;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f5097r0.get(index));
                                        continue;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f5097r0.get(index));
                                        continue;
                                        continue;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class Motion {

        /* renamed from: o  reason: collision with root package name */
        private static SparseIntArray f5141o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f5142a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f5143b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f5144c = 0;

        /* renamed from: d  reason: collision with root package name */
        public String f5145d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f5146e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f5147f = 0;

        /* renamed from: g  reason: collision with root package name */
        public float f5148g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public int f5149h = -1;

        /* renamed from: i  reason: collision with root package name */
        public float f5150i = Float.NaN;

        /* renamed from: j  reason: collision with root package name */
        public float f5151j = Float.NaN;

        /* renamed from: k  reason: collision with root package name */
        public int f5152k = -1;

        /* renamed from: l  reason: collision with root package name */
        public String f5153l = null;

        /* renamed from: m  reason: collision with root package name */
        public int f5154m = -3;

        /* renamed from: n  reason: collision with root package name */
        public int f5155n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f5141o = sparseIntArray;
            sparseIntArray.append(R$styleable.f5237f7, 1);
            f5141o.append(R$styleable.f5255h7, 2);
            f5141o.append(R$styleable.f5291l7, 3);
            f5141o.append(R$styleable.f5228e7, 4);
            f5141o.append(R$styleable.f5219d7, 5);
            f5141o.append(R$styleable.f5210c7, 6);
            f5141o.append(R$styleable.f5246g7, 7);
            f5141o.append(R$styleable.f5282k7, 8);
            f5141o.append(R$styleable.f5273j7, 9);
            f5141o.append(R$styleable.f5264i7, 10);
        }

        public void a(Motion motion) {
            this.f5142a = motion.f5142a;
            this.f5143b = motion.f5143b;
            this.f5145d = motion.f5145d;
            this.f5146e = motion.f5146e;
            this.f5147f = motion.f5147f;
            this.f5150i = motion.f5150i;
            this.f5148g = motion.f5148g;
            this.f5149h = motion.f5149h;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5201b7);
            this.f5142a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                switch (f5141o.get(index)) {
                    case 1:
                        this.f5150i = obtainStyledAttributes.getFloat(index, this.f5150i);
                        break;
                    case 2:
                        this.f5146e = obtainStyledAttributes.getInt(index, this.f5146e);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.f5145d = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f5145d = Easing.f4446c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f5147f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f5143b = ConstraintSet.t(obtainStyledAttributes, index, this.f5143b);
                        break;
                    case 6:
                        this.f5144c = obtainStyledAttributes.getInteger(index, this.f5144c);
                        break;
                    case 7:
                        this.f5148g = obtainStyledAttributes.getFloat(index, this.f5148g);
                        break;
                    case 8:
                        this.f5152k = obtainStyledAttributes.getInteger(index, this.f5152k);
                        break;
                    case 9:
                        this.f5151j = obtainStyledAttributes.getFloat(index, this.f5151j);
                        break;
                    case 10:
                        int i9 = obtainStyledAttributes.peekValue(index).type;
                        if (i9 == 1) {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.f5155n = resourceId;
                            if (resourceId != -1) {
                                this.f5154m = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i9 == 3) {
                            String string = obtainStyledAttributes.getString(index);
                            this.f5153l = string;
                            if (string.indexOf("/") > 0) {
                                this.f5155n = obtainStyledAttributes.getResourceId(index, -1);
                                this.f5154m = -2;
                                break;
                            } else {
                                this.f5154m = -1;
                                break;
                            }
                        } else {
                            this.f5154m = obtainStyledAttributes.getInteger(index, this.f5155n);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class PropertySet {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5156a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f5157b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f5158c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f5159d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f5160e = Float.NaN;

        public void a(PropertySet propertySet) {
            this.f5156a = propertySet.f5156a;
            this.f5157b = propertySet.f5157b;
            this.f5159d = propertySet.f5159d;
            this.f5160e = propertySet.f5160e;
            this.f5158c = propertySet.f5158c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.y7);
            this.f5156a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.A7) {
                    this.f5159d = obtainStyledAttributes.getFloat(index, this.f5159d);
                } else if (index == R$styleable.z7) {
                    this.f5157b = obtainStyledAttributes.getInt(index, this.f5157b);
                    this.f5157b = ConstraintSet.f5069f[this.f5157b];
                } else if (index == R$styleable.C7) {
                    this.f5158c = obtainStyledAttributes.getInt(index, this.f5158c);
                } else if (index == R$styleable.B7) {
                    this.f5160e = obtainStyledAttributes.getFloat(index, this.f5160e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class Transform {

        /* renamed from: o  reason: collision with root package name */
        private static SparseIntArray f5161o;

        /* renamed from: a  reason: collision with root package name */
        public boolean f5162a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f5163b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f5164c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f5165d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f5166e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f5167f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f5168g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f5169h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public int f5170i = -1;

        /* renamed from: j  reason: collision with root package name */
        public float f5171j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f5172k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f5173l = 0.0f;

        /* renamed from: m  reason: collision with root package name */
        public boolean f5174m = false;

        /* renamed from: n  reason: collision with root package name */
        public float f5175n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f5161o = sparseIntArray;
            sparseIntArray.append(R$styleable.X7, 1);
            f5161o.append(R$styleable.Y7, 2);
            f5161o.append(R$styleable.Z7, 3);
            f5161o.append(R$styleable.V7, 4);
            f5161o.append(R$styleable.W7, 5);
            f5161o.append(R$styleable.R7, 6);
            f5161o.append(R$styleable.S7, 7);
            f5161o.append(R$styleable.T7, 8);
            f5161o.append(R$styleable.U7, 9);
            f5161o.append(R$styleable.a8, 10);
            f5161o.append(R$styleable.b8, 11);
            f5161o.append(R$styleable.c8, 12);
        }

        public void a(Transform transform) {
            this.f5162a = transform.f5162a;
            this.f5163b = transform.f5163b;
            this.f5164c = transform.f5164c;
            this.f5165d = transform.f5165d;
            this.f5166e = transform.f5166e;
            this.f5167f = transform.f5167f;
            this.f5168g = transform.f5168g;
            this.f5169h = transform.f5169h;
            this.f5170i = transform.f5170i;
            this.f5171j = transform.f5171j;
            this.f5172k = transform.f5172k;
            this.f5173l = transform.f5173l;
            this.f5174m = transform.f5174m;
            this.f5175n = transform.f5175n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Q7);
            this.f5162a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                switch (f5161o.get(index)) {
                    case 1:
                        this.f5163b = obtainStyledAttributes.getFloat(index, this.f5163b);
                        break;
                    case 2:
                        this.f5164c = obtainStyledAttributes.getFloat(index, this.f5164c);
                        break;
                    case 3:
                        this.f5165d = obtainStyledAttributes.getFloat(index, this.f5165d);
                        break;
                    case 4:
                        this.f5166e = obtainStyledAttributes.getFloat(index, this.f5166e);
                        break;
                    case 5:
                        this.f5167f = obtainStyledAttributes.getFloat(index, this.f5167f);
                        break;
                    case 6:
                        this.f5168g = obtainStyledAttributes.getDimension(index, this.f5168g);
                        break;
                    case 7:
                        this.f5169h = obtainStyledAttributes.getDimension(index, this.f5169h);
                        break;
                    case 8:
                        this.f5171j = obtainStyledAttributes.getDimension(index, this.f5171j);
                        break;
                    case 9:
                        this.f5172k = obtainStyledAttributes.getDimension(index, this.f5172k);
                        break;
                    case 10:
                        this.f5173l = obtainStyledAttributes.getDimension(index, this.f5173l);
                        break;
                    case 11:
                        this.f5174m = true;
                        this.f5175n = obtainStyledAttributes.getDimension(index, this.f5175n);
                        break;
                    case 12:
                        this.f5170i = ConstraintSet.t(obtainStyledAttributes, index, this.f5170i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        f5070g.append(R$styleable.A0, 25);
        f5070g.append(R$styleable.B0, 26);
        f5070g.append(R$styleable.D0, 29);
        f5070g.append(R$styleable.E0, 30);
        f5070g.append(R$styleable.K0, 36);
        f5070g.append(R$styleable.J0, 35);
        f5070g.append(R$styleable.f5248h0, 4);
        f5070g.append(R$styleable.f5239g0, 3);
        f5070g.append(R$styleable.f5203c0, 1);
        f5070g.append(R$styleable.f5221e0, 91);
        f5070g.append(R$styleable.f5212d0, 92);
        f5070g.append(R$styleable.T0, 6);
        f5070g.append(R$styleable.U0, 7);
        f5070g.append(R$styleable.f5311o0, 17);
        f5070g.append(R$styleable.f5320p0, 18);
        f5070g.append(R$styleable.f5329q0, 19);
        f5070g.append(R$styleable.Y, 99);
        f5070g.append(R$styleable.f5361u, 27);
        f5070g.append(R$styleable.F0, 32);
        f5070g.append(R$styleable.G0, 33);
        f5070g.append(R$styleable.f5302n0, 10);
        f5070g.append(R$styleable.f5293m0, 9);
        f5070g.append(R$styleable.X0, 13);
        f5070g.append(R$styleable.f5186a1, 16);
        f5070g.append(R$styleable.Y0, 14);
        f5070g.append(R$styleable.V0, 11);
        f5070g.append(R$styleable.Z0, 15);
        f5070g.append(R$styleable.W0, 12);
        f5070g.append(R$styleable.N0, 40);
        f5070g.append(R$styleable.f5394y0, 39);
        f5070g.append(R$styleable.f5386x0, 41);
        f5070g.append(R$styleable.M0, 42);
        f5070g.append(R$styleable.f5378w0, 20);
        f5070g.append(R$styleable.L0, 37);
        f5070g.append(R$styleable.f5284l0, 5);
        f5070g.append(R$styleable.f5402z0, 87);
        f5070g.append(R$styleable.I0, 87);
        f5070g.append(R$styleable.C0, 87);
        f5070g.append(R$styleable.f5230f0, 87);
        f5070g.append(R$styleable.f5194b0, 87);
        f5070g.append(R$styleable.f5401z, 24);
        f5070g.append(R$styleable.B, 28);
        f5070g.append(R$styleable.N, 31);
        f5070g.append(R$styleable.O, 8);
        f5070g.append(R$styleable.A, 34);
        f5070g.append(R$styleable.C, 2);
        f5070g.append(R$styleable.f5385x, 23);
        f5070g.append(R$styleable.f5393y, 21);
        f5070g.append(R$styleable.O0, 95);
        f5070g.append(R$styleable.f5338r0, 96);
        f5070g.append(R$styleable.f5377w, 22);
        f5070g.append(R$styleable.D, 43);
        f5070g.append(R$styleable.Q, 44);
        f5070g.append(R$styleable.L, 45);
        f5070g.append(R$styleable.M, 46);
        f5070g.append(R$styleable.K, 60);
        f5070g.append(R$styleable.I, 47);
        f5070g.append(R$styleable.J, 48);
        f5070g.append(R$styleable.E, 49);
        f5070g.append(R$styleable.F, 50);
        f5070g.append(R$styleable.G, 51);
        f5070g.append(R$styleable.H, 52);
        f5070g.append(R$styleable.P, 53);
        f5070g.append(R$styleable.P0, 54);
        f5070g.append(R$styleable.f5346s0, 55);
        f5070g.append(R$styleable.Q0, 56);
        f5070g.append(R$styleable.f5354t0, 57);
        f5070g.append(R$styleable.R0, 58);
        f5070g.append(R$styleable.f5362u0, 59);
        f5070g.append(R$styleable.f5257i0, 61);
        f5070g.append(R$styleable.f5275k0, 62);
        f5070g.append(R$styleable.f5266j0, 63);
        f5070g.append(R$styleable.R, 64);
        f5070g.append(R$styleable.f5276k1, 65);
        f5070g.append(R$styleable.X, 66);
        f5070g.append(R$styleable.f5285l1, 67);
        f5070g.append(R$styleable.f5213d1, 79);
        f5070g.append(R$styleable.f5369v, 38);
        f5070g.append(R$styleable.f5204c1, 68);
        f5070g.append(R$styleable.S0, 69);
        f5070g.append(R$styleable.f5370v0, 70);
        f5070g.append(R$styleable.f5195b1, 97);
        f5070g.append(R$styleable.V, 71);
        f5070g.append(R$styleable.T, 72);
        f5070g.append(R$styleable.U, 73);
        f5070g.append(R$styleable.W, 74);
        f5070g.append(R$styleable.S, 75);
        f5070g.append(R$styleable.f5222e1, 76);
        f5070g.append(R$styleable.H0, 77);
        f5070g.append(R$styleable.f5294m1, 78);
        f5070g.append(R$styleable.f5185a0, 80);
        f5070g.append(R$styleable.Z, 81);
        f5070g.append(R$styleable.f5231f1, 82);
        f5070g.append(R$styleable.f5267j1, 83);
        f5070g.append(R$styleable.f5258i1, 84);
        f5070g.append(R$styleable.f5249h1, 85);
        f5070g.append(R$styleable.f5240g1, 86);
        SparseIntArray sparseIntArray = f5071h;
        int i8 = R$styleable.f5333q4;
        sparseIntArray.append(i8, 6);
        f5071h.append(i8, 7);
        f5071h.append(R$styleable.f5287l3, 27);
        f5071h.append(R$styleable.f5358t4, 13);
        f5071h.append(R$styleable.f5382w4, 16);
        f5071h.append(R$styleable.f5366u4, 14);
        f5071h.append(R$styleable.f5342r4, 11);
        f5071h.append(R$styleable.f5374v4, 15);
        f5071h.append(R$styleable.f5350s4, 12);
        f5071h.append(R$styleable.f5279k4, 40);
        f5071h.append(R$styleable.f5216d4, 39);
        f5071h.append(R$styleable.f5207c4, 41);
        f5071h.append(R$styleable.f5270j4, 42);
        f5071h.append(R$styleable.f5198b4, 20);
        f5071h.append(R$styleable.f5261i4, 37);
        f5071h.append(R$styleable.V3, 5);
        f5071h.append(R$styleable.f5225e4, 87);
        f5071h.append(R$styleable.f5252h4, 87);
        f5071h.append(R$styleable.f5234f4, 87);
        f5071h.append(R$styleable.S3, 87);
        f5071h.append(R$styleable.R3, 87);
        f5071h.append(R$styleable.f5332q3, 24);
        f5071h.append(R$styleable.f5349s3, 28);
        f5071h.append(R$styleable.E3, 31);
        f5071h.append(R$styleable.F3, 8);
        f5071h.append(R$styleable.f5341r3, 34);
        f5071h.append(R$styleable.f5357t3, 2);
        f5071h.append(R$styleable.f5314o3, 23);
        f5071h.append(R$styleable.f5323p3, 21);
        f5071h.append(R$styleable.f5288l4, 95);
        f5071h.append(R$styleable.W3, 96);
        f5071h.append(R$styleable.f5305n3, 22);
        f5071h.append(R$styleable.f5365u3, 43);
        f5071h.append(R$styleable.H3, 44);
        f5071h.append(R$styleable.C3, 45);
        f5071h.append(R$styleable.D3, 46);
        f5071h.append(R$styleable.B3, 60);
        f5071h.append(R$styleable.f5405z3, 47);
        f5071h.append(R$styleable.A3, 48);
        f5071h.append(R$styleable.f5373v3, 49);
        f5071h.append(R$styleable.f5381w3, 50);
        f5071h.append(R$styleable.f5389x3, 51);
        f5071h.append(R$styleable.f5397y3, 52);
        f5071h.append(R$styleable.G3, 53);
        f5071h.append(R$styleable.f5297m4, 54);
        f5071h.append(R$styleable.X3, 55);
        f5071h.append(R$styleable.f5306n4, 56);
        f5071h.append(R$styleable.Y3, 57);
        f5071h.append(R$styleable.f5315o4, 58);
        f5071h.append(R$styleable.Z3, 59);
        f5071h.append(R$styleable.U3, 62);
        f5071h.append(R$styleable.T3, 63);
        f5071h.append(R$styleable.I3, 64);
        f5071h.append(R$styleable.H4, 65);
        f5071h.append(R$styleable.O3, 66);
        f5071h.append(R$styleable.I4, 67);
        f5071h.append(R$styleable.f5406z4, 79);
        f5071h.append(R$styleable.f5296m3, 38);
        f5071h.append(R$styleable.A4, 98);
        f5071h.append(R$styleable.f5398y4, 68);
        f5071h.append(R$styleable.f5324p4, 69);
        f5071h.append(R$styleable.f5189a4, 70);
        f5071h.append(R$styleable.M3, 71);
        f5071h.append(R$styleable.K3, 72);
        f5071h.append(R$styleable.L3, 73);
        f5071h.append(R$styleable.N3, 74);
        f5071h.append(R$styleable.J3, 75);
        f5071h.append(R$styleable.B4, 76);
        f5071h.append(R$styleable.f5243g4, 77);
        f5071h.append(R$styleable.J4, 78);
        f5071h.append(R$styleable.Q3, 80);
        f5071h.append(R$styleable.P3, 81);
        f5071h.append(R$styleable.C4, 82);
        f5071h.append(R$styleable.G4, 83);
        f5071h.append(R$styleable.F4, 84);
        f5071h.append(R$styleable.E4, 85);
        f5071h.append(R$styleable.D4, 86);
        f5071h.append(R$styleable.f5390x4, 97);
    }

    private String B(int i8) {
        switch (i8) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    private int[] m(View view, String str) {
        int i8;
        Object g8;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i9 = 0;
        int i10 = 0;
        while (i9 < split.length) {
            String trim = split[i9].trim();
            try {
                i8 = R$id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i8 = 0;
            }
            if (i8 == 0) {
                i8 = context.getResources().getIdentifier(trim, Name.MARK, context.getPackageName());
            }
            if (i8 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (g8 = ((ConstraintLayout) view.getParent()).g(0, trim)) != null && (g8 instanceof Integer)) {
                i8 = ((Integer) g8).intValue();
            }
            iArr[i10] = i8;
            i9++;
            i10++;
        }
        if (i10 != split.length) {
            return Arrays.copyOf(iArr, i10);
        }
        return iArr;
    }

    private void o(int i8, int i9, int i10, int i11, int[] iArr, float[] fArr, int i12, int i13, int i14) {
        if (iArr.length >= 2) {
            if (fArr != null && fArr.length != iArr.length) {
                throw new IllegalArgumentException("must have 2 or more widgets in a chain");
            }
            if (fArr != null) {
                q(iArr[0]).f5081e.W = fArr[0];
            }
            q(iArr[0]).f5081e.X = i12;
            j(iArr[0], i13, i8, i9, -1);
            for (int i15 = 1; i15 < iArr.length; i15++) {
                int i16 = i15 - 1;
                j(iArr[i15], i13, iArr[i16], i14, -1);
                j(iArr[i16], i14, iArr[i15], i13, -1);
                if (fArr != null) {
                    q(iArr[i15]).f5081e.W = fArr[i15];
                }
            }
            j(iArr[iArr.length - 1], i14, i10, i11, -1);
            return;
        }
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    private Constraint p(Context context, AttributeSet attributeSet, boolean z7) {
        int[] iArr;
        Constraint constraint = new Constraint();
        if (z7) {
            iArr = R$styleable.f5278k3;
        } else {
            iArr = R$styleable.f5353t;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        x(context, constraint, obtainStyledAttributes, z7);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private Constraint q(int i8) {
        if (!this.f5076e.containsKey(Integer.valueOf(i8))) {
            this.f5076e.put(Integer.valueOf(i8), new Constraint());
        }
        return this.f5076e.get(Integer.valueOf(i8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int t(TypedArray typedArray, int i8, int i9) {
        int resourceId = typedArray.getResourceId(i8, i9);
        if (resourceId == -1) {
            return typedArray.getInt(i8, -1);
        }
        return resourceId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void u(Object obj, TypedArray typedArray, int i8, int i9) {
        if (obj == null) {
            return;
        }
        int i10 = typedArray.peekValue(i8).type;
        if (i10 != 3) {
            int i11 = -2;
            boolean z7 = false;
            if (i10 != 5) {
                int i12 = typedArray.getInt(i8, 0);
                if (i12 != -4) {
                    if (i12 == -3 || (i12 != -2 && i12 != -1)) {
                        i11 = 0;
                    } else {
                        i11 = i12;
                    }
                } else {
                    z7 = true;
                }
            } else {
                i11 = typedArray.getDimensionPixelSize(i8, 0);
            }
            if (obj instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                if (i9 == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = i11;
                    layoutParams.f4995a0 = z7;
                    return;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).height = i11;
                layoutParams.f4997b0 = z7;
                return;
            } else if (obj instanceof Layout) {
                Layout layout = (Layout) obj;
                if (i9 == 0) {
                    layout.f5104d = i11;
                    layout.f5125n0 = z7;
                    return;
                }
                layout.f5106e = i11;
                layout.f5127o0 = z7;
                return;
            } else if (obj instanceof Constraint.Delta) {
                Constraint.Delta delta = (Constraint.Delta) obj;
                if (i9 == 0) {
                    delta.b(23, i11);
                    delta.d(80, z7);
                    return;
                }
                delta.b(21, i11);
                delta.d(81, z7);
                return;
            } else {
                return;
            }
        }
        v(obj, typedArray.getString(i8), i9);
    }

    static void v(Object obj, String str, int i8) {
        if (str == null) {
            return;
        }
        int indexOf = str.indexOf(61);
        int length = str.length();
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            if (substring2.length() > 0) {
                String trim = substring.trim();
                String trim2 = substring2.trim();
                if ("ratio".equalsIgnoreCase(trim)) {
                    if (obj instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                        if (i8 == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
                        }
                        w(layoutParams, trim2);
                        return;
                    } else if (obj instanceof Layout) {
                        ((Layout) obj).A = trim2;
                        return;
                    } else if (obj instanceof Constraint.Delta) {
                        ((Constraint.Delta) obj).c(5, trim2);
                        return;
                    } else {
                        return;
                    }
                }
                try {
                    if ("weight".equalsIgnoreCase(trim)) {
                        float parseFloat = Float.parseFloat(trim2);
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                            if (i8 == 0) {
                                ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                                layoutParams2.L = parseFloat;
                            } else {
                                ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
                                layoutParams2.M = parseFloat;
                            }
                        } else if (obj instanceof Layout) {
                            Layout layout = (Layout) obj;
                            if (i8 == 0) {
                                layout.f5104d = 0;
                                layout.W = parseFloat;
                            } else {
                                layout.f5106e = 0;
                                layout.V = parseFloat;
                            }
                        } else if (obj instanceof Constraint.Delta) {
                            Constraint.Delta delta = (Constraint.Delta) obj;
                            if (i8 == 0) {
                                delta.b(23, 0);
                                delta.a(39, parseFloat);
                            } else {
                                delta.b(21, 0);
                                delta.a(40, parseFloat);
                            }
                        }
                    } else if ("parent".equalsIgnoreCase(trim)) {
                        float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                            if (i8 == 0) {
                                ((ViewGroup.MarginLayoutParams) layoutParams3).width = 0;
                                layoutParams3.V = max;
                                layoutParams3.P = 2;
                            } else {
                                ((ViewGroup.MarginLayoutParams) layoutParams3).height = 0;
                                layoutParams3.W = max;
                                layoutParams3.Q = 2;
                            }
                        } else if (obj instanceof Layout) {
                            Layout layout2 = (Layout) obj;
                            if (i8 == 0) {
                                layout2.f5104d = 0;
                                layout2.f5109f0 = max;
                                layout2.Z = 2;
                            } else {
                                layout2.f5106e = 0;
                                layout2.f5111g0 = max;
                                layout2.f5099a0 = 2;
                            }
                        } else if (obj instanceof Constraint.Delta) {
                            Constraint.Delta delta2 = (Constraint.Delta) obj;
                            if (i8 == 0) {
                                delta2.b(23, 0);
                                delta2.b(54, 2);
                            } else {
                                delta2.b(21, 0);
                                delta2.b(55, 2);
                            }
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(ConstraintLayout.LayoutParams layoutParams, String str) {
        float f8 = Float.NaN;
        int i8 = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i9 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i8 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i8 = 1;
                }
                i9 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 >= 0 && indexOf2 < length - 1) {
                    String substring2 = str.substring(i9, indexOf2);
                    String substring3 = str.substring(indexOf2 + 1);
                    if (substring2.length() > 0 && substring3.length() > 0) {
                        float parseFloat = Float.parseFloat(substring2);
                        float parseFloat2 = Float.parseFloat(substring3);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            f8 = i8 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        }
                    }
                } else {
                    String substring4 = str.substring(i9);
                    if (substring4.length() > 0) {
                        f8 = Float.parseFloat(substring4);
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        layoutParams.I = str;
        layoutParams.J = f8;
        layoutParams.K = i8;
    }

    private void x(Context context, Constraint constraint, TypedArray typedArray, boolean z7) {
        if (z7) {
            y(context, constraint, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArray.getIndex(i8);
            if (index != R$styleable.f5369v && R$styleable.N != index && R$styleable.O != index) {
                constraint.f5080d.f5142a = true;
                constraint.f5081e.f5100b = true;
                constraint.f5079c.f5156a = true;
                constraint.f5082f.f5162a = true;
            }
            switch (f5070g.get(index)) {
                case 1:
                    Layout layout = constraint.f5081e;
                    layout.f5132r = t(typedArray, index, layout.f5132r);
                    break;
                case 2:
                    Layout layout2 = constraint.f5081e;
                    layout2.K = typedArray.getDimensionPixelSize(index, layout2.K);
                    break;
                case 3:
                    Layout layout3 = constraint.f5081e;
                    layout3.f5130q = t(typedArray, index, layout3.f5130q);
                    break;
                case 4:
                    Layout layout4 = constraint.f5081e;
                    layout4.f5128p = t(typedArray, index, layout4.f5128p);
                    break;
                case 5:
                    constraint.f5081e.A = typedArray.getString(index);
                    break;
                case 6:
                    Layout layout5 = constraint.f5081e;
                    layout5.E = typedArray.getDimensionPixelOffset(index, layout5.E);
                    break;
                case 7:
                    Layout layout6 = constraint.f5081e;
                    layout6.F = typedArray.getDimensionPixelOffset(index, layout6.F);
                    break;
                case 8:
                    Layout layout7 = constraint.f5081e;
                    layout7.L = typedArray.getDimensionPixelSize(index, layout7.L);
                    break;
                case 9:
                    Layout layout8 = constraint.f5081e;
                    layout8.f5138x = t(typedArray, index, layout8.f5138x);
                    break;
                case 10:
                    Layout layout9 = constraint.f5081e;
                    layout9.f5137w = t(typedArray, index, layout9.f5137w);
                    break;
                case 11:
                    Layout layout10 = constraint.f5081e;
                    layout10.R = typedArray.getDimensionPixelSize(index, layout10.R);
                    break;
                case 12:
                    Layout layout11 = constraint.f5081e;
                    layout11.S = typedArray.getDimensionPixelSize(index, layout11.S);
                    break;
                case 13:
                    Layout layout12 = constraint.f5081e;
                    layout12.O = typedArray.getDimensionPixelSize(index, layout12.O);
                    break;
                case 14:
                    Layout layout13 = constraint.f5081e;
                    layout13.Q = typedArray.getDimensionPixelSize(index, layout13.Q);
                    break;
                case 15:
                    Layout layout14 = constraint.f5081e;
                    layout14.T = typedArray.getDimensionPixelSize(index, layout14.T);
                    break;
                case 16:
                    Layout layout15 = constraint.f5081e;
                    layout15.P = typedArray.getDimensionPixelSize(index, layout15.P);
                    break;
                case 17:
                    Layout layout16 = constraint.f5081e;
                    layout16.f5108f = typedArray.getDimensionPixelOffset(index, layout16.f5108f);
                    break;
                case 18:
                    Layout layout17 = constraint.f5081e;
                    layout17.f5110g = typedArray.getDimensionPixelOffset(index, layout17.f5110g);
                    break;
                case 19:
                    Layout layout18 = constraint.f5081e;
                    layout18.f5112h = typedArray.getFloat(index, layout18.f5112h);
                    break;
                case 20:
                    Layout layout19 = constraint.f5081e;
                    layout19.f5139y = typedArray.getFloat(index, layout19.f5139y);
                    break;
                case 21:
                    Layout layout20 = constraint.f5081e;
                    layout20.f5106e = typedArray.getLayoutDimension(index, layout20.f5106e);
                    break;
                case 22:
                    PropertySet propertySet = constraint.f5079c;
                    propertySet.f5157b = typedArray.getInt(index, propertySet.f5157b);
                    PropertySet propertySet2 = constraint.f5079c;
                    propertySet2.f5157b = f5069f[propertySet2.f5157b];
                    break;
                case 23:
                    Layout layout21 = constraint.f5081e;
                    layout21.f5104d = typedArray.getLayoutDimension(index, layout21.f5104d);
                    break;
                case 24:
                    Layout layout22 = constraint.f5081e;
                    layout22.H = typedArray.getDimensionPixelSize(index, layout22.H);
                    break;
                case 25:
                    Layout layout23 = constraint.f5081e;
                    layout23.f5116j = t(typedArray, index, layout23.f5116j);
                    break;
                case 26:
                    Layout layout24 = constraint.f5081e;
                    layout24.f5118k = t(typedArray, index, layout24.f5118k);
                    break;
                case 27:
                    Layout layout25 = constraint.f5081e;
                    layout25.G = typedArray.getInt(index, layout25.G);
                    break;
                case 28:
                    Layout layout26 = constraint.f5081e;
                    layout26.I = typedArray.getDimensionPixelSize(index, layout26.I);
                    break;
                case 29:
                    Layout layout27 = constraint.f5081e;
                    layout27.f5120l = t(typedArray, index, layout27.f5120l);
                    break;
                case 30:
                    Layout layout28 = constraint.f5081e;
                    layout28.f5122m = t(typedArray, index, layout28.f5122m);
                    break;
                case 31:
                    Layout layout29 = constraint.f5081e;
                    layout29.M = typedArray.getDimensionPixelSize(index, layout29.M);
                    break;
                case 32:
                    Layout layout30 = constraint.f5081e;
                    layout30.f5135u = t(typedArray, index, layout30.f5135u);
                    break;
                case 33:
                    Layout layout31 = constraint.f5081e;
                    layout31.f5136v = t(typedArray, index, layout31.f5136v);
                    break;
                case 34:
                    Layout layout32 = constraint.f5081e;
                    layout32.J = typedArray.getDimensionPixelSize(index, layout32.J);
                    break;
                case 35:
                    Layout layout33 = constraint.f5081e;
                    layout33.f5126o = t(typedArray, index, layout33.f5126o);
                    break;
                case 36:
                    Layout layout34 = constraint.f5081e;
                    layout34.f5124n = t(typedArray, index, layout34.f5124n);
                    break;
                case 37:
                    Layout layout35 = constraint.f5081e;
                    layout35.f5140z = typedArray.getFloat(index, layout35.f5140z);
                    break;
                case 38:
                    constraint.f5077a = typedArray.getResourceId(index, constraint.f5077a);
                    break;
                case 39:
                    Layout layout36 = constraint.f5081e;
                    layout36.W = typedArray.getFloat(index, layout36.W);
                    break;
                case 40:
                    Layout layout37 = constraint.f5081e;
                    layout37.V = typedArray.getFloat(index, layout37.V);
                    break;
                case 41:
                    Layout layout38 = constraint.f5081e;
                    layout38.X = typedArray.getInt(index, layout38.X);
                    break;
                case 42:
                    Layout layout39 = constraint.f5081e;
                    layout39.Y = typedArray.getInt(index, layout39.Y);
                    break;
                case 43:
                    PropertySet propertySet3 = constraint.f5079c;
                    propertySet3.f5159d = typedArray.getFloat(index, propertySet3.f5159d);
                    break;
                case 44:
                    Transform transform = constraint.f5082f;
                    transform.f5174m = true;
                    transform.f5175n = typedArray.getDimension(index, transform.f5175n);
                    break;
                case 45:
                    Transform transform2 = constraint.f5082f;
                    transform2.f5164c = typedArray.getFloat(index, transform2.f5164c);
                    break;
                case 46:
                    Transform transform3 = constraint.f5082f;
                    transform3.f5165d = typedArray.getFloat(index, transform3.f5165d);
                    break;
                case 47:
                    Transform transform4 = constraint.f5082f;
                    transform4.f5166e = typedArray.getFloat(index, transform4.f5166e);
                    break;
                case 48:
                    Transform transform5 = constraint.f5082f;
                    transform5.f5167f = typedArray.getFloat(index, transform5.f5167f);
                    break;
                case 49:
                    Transform transform6 = constraint.f5082f;
                    transform6.f5168g = typedArray.getDimension(index, transform6.f5168g);
                    break;
                case 50:
                    Transform transform7 = constraint.f5082f;
                    transform7.f5169h = typedArray.getDimension(index, transform7.f5169h);
                    break;
                case 51:
                    Transform transform8 = constraint.f5082f;
                    transform8.f5171j = typedArray.getDimension(index, transform8.f5171j);
                    break;
                case 52:
                    Transform transform9 = constraint.f5082f;
                    transform9.f5172k = typedArray.getDimension(index, transform9.f5172k);
                    break;
                case 53:
                    Transform transform10 = constraint.f5082f;
                    transform10.f5173l = typedArray.getDimension(index, transform10.f5173l);
                    break;
                case 54:
                    Layout layout40 = constraint.f5081e;
                    layout40.Z = typedArray.getInt(index, layout40.Z);
                    break;
                case 55:
                    Layout layout41 = constraint.f5081e;
                    layout41.f5099a0 = typedArray.getInt(index, layout41.f5099a0);
                    break;
                case 56:
                    Layout layout42 = constraint.f5081e;
                    layout42.f5101b0 = typedArray.getDimensionPixelSize(index, layout42.f5101b0);
                    break;
                case 57:
                    Layout layout43 = constraint.f5081e;
                    layout43.f5103c0 = typedArray.getDimensionPixelSize(index, layout43.f5103c0);
                    break;
                case 58:
                    Layout layout44 = constraint.f5081e;
                    layout44.f5105d0 = typedArray.getDimensionPixelSize(index, layout44.f5105d0);
                    break;
                case 59:
                    Layout layout45 = constraint.f5081e;
                    layout45.f5107e0 = typedArray.getDimensionPixelSize(index, layout45.f5107e0);
                    break;
                case 60:
                    Transform transform11 = constraint.f5082f;
                    transform11.f5163b = typedArray.getFloat(index, transform11.f5163b);
                    break;
                case 61:
                    Layout layout46 = constraint.f5081e;
                    layout46.B = t(typedArray, index, layout46.B);
                    break;
                case 62:
                    Layout layout47 = constraint.f5081e;
                    layout47.C = typedArray.getDimensionPixelSize(index, layout47.C);
                    break;
                case 63:
                    Layout layout48 = constraint.f5081e;
                    layout48.D = typedArray.getFloat(index, layout48.D);
                    break;
                case 64:
                    Motion motion = constraint.f5080d;
                    motion.f5143b = t(typedArray, index, motion.f5143b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        constraint.f5080d.f5145d = typedArray.getString(index);
                        break;
                    } else {
                        constraint.f5080d.f5145d = Easing.f4446c[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    constraint.f5080d.f5147f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = constraint.f5080d;
                    motion2.f5150i = typedArray.getFloat(index, motion2.f5150i);
                    break;
                case 68:
                    PropertySet propertySet4 = constraint.f5079c;
                    propertySet4.f5160e = typedArray.getFloat(index, propertySet4.f5160e);
                    break;
                case 69:
                    constraint.f5081e.f5109f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.f5081e.f5111g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    Layout layout49 = constraint.f5081e;
                    layout49.f5113h0 = typedArray.getInt(index, layout49.f5113h0);
                    break;
                case 73:
                    Layout layout50 = constraint.f5081e;
                    layout50.f5115i0 = typedArray.getDimensionPixelSize(index, layout50.f5115i0);
                    break;
                case 74:
                    constraint.f5081e.f5121l0 = typedArray.getString(index);
                    break;
                case 75:
                    Layout layout51 = constraint.f5081e;
                    layout51.f5129p0 = typedArray.getBoolean(index, layout51.f5129p0);
                    break;
                case 76:
                    Motion motion3 = constraint.f5080d;
                    motion3.f5146e = typedArray.getInt(index, motion3.f5146e);
                    break;
                case 77:
                    constraint.f5081e.f5123m0 = typedArray.getString(index);
                    break;
                case 78:
                    PropertySet propertySet5 = constraint.f5079c;
                    propertySet5.f5158c = typedArray.getInt(index, propertySet5.f5158c);
                    break;
                case 79:
                    Motion motion4 = constraint.f5080d;
                    motion4.f5148g = typedArray.getFloat(index, motion4.f5148g);
                    break;
                case 80:
                    Layout layout52 = constraint.f5081e;
                    layout52.f5125n0 = typedArray.getBoolean(index, layout52.f5125n0);
                    break;
                case 81:
                    Layout layout53 = constraint.f5081e;
                    layout53.f5127o0 = typedArray.getBoolean(index, layout53.f5127o0);
                    break;
                case 82:
                    Motion motion5 = constraint.f5080d;
                    motion5.f5144c = typedArray.getInteger(index, motion5.f5144c);
                    break;
                case 83:
                    Transform transform12 = constraint.f5082f;
                    transform12.f5170i = t(typedArray, index, transform12.f5170i);
                    break;
                case 84:
                    Motion motion6 = constraint.f5080d;
                    motion6.f5152k = typedArray.getInteger(index, motion6.f5152k);
                    break;
                case 85:
                    Motion motion7 = constraint.f5080d;
                    motion7.f5151j = typedArray.getFloat(index, motion7.f5151j);
                    break;
                case 86:
                    int i9 = typedArray.peekValue(index).type;
                    if (i9 == 1) {
                        constraint.f5080d.f5155n = typedArray.getResourceId(index, -1);
                        Motion motion8 = constraint.f5080d;
                        if (motion8.f5155n != -1) {
                            motion8.f5154m = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i9 == 3) {
                        constraint.f5080d.f5153l = typedArray.getString(index);
                        if (constraint.f5080d.f5153l.indexOf("/") > 0) {
                            constraint.f5080d.f5155n = typedArray.getResourceId(index, -1);
                            constraint.f5080d.f5154m = -2;
                            break;
                        } else {
                            constraint.f5080d.f5154m = -1;
                            break;
                        }
                    } else {
                        Motion motion9 = constraint.f5080d;
                        motion9.f5154m = typedArray.getInteger(index, motion9.f5155n);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f5070g.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f5070g.get(index));
                    break;
                case 91:
                    Layout layout54 = constraint.f5081e;
                    layout54.f5133s = t(typedArray, index, layout54.f5133s);
                    break;
                case 92:
                    Layout layout55 = constraint.f5081e;
                    layout55.f5134t = t(typedArray, index, layout55.f5134t);
                    break;
                case 93:
                    Layout layout56 = constraint.f5081e;
                    layout56.N = typedArray.getDimensionPixelSize(index, layout56.N);
                    break;
                case 94:
                    Layout layout57 = constraint.f5081e;
                    layout57.U = typedArray.getDimensionPixelSize(index, layout57.U);
                    break;
                case 95:
                    u(constraint.f5081e, typedArray, index, 0);
                    break;
                case 96:
                    u(constraint.f5081e, typedArray, index, 1);
                    break;
                case 97:
                    Layout layout58 = constraint.f5081e;
                    layout58.f5131q0 = typedArray.getInt(index, layout58.f5131q0);
                    break;
            }
        }
        Layout layout59 = constraint.f5081e;
        if (layout59.f5121l0 != null) {
            layout59.f5119k0 = null;
        }
    }

    private static void y(Context context, Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        constraint.f5084h = delta;
        constraint.f5080d.f5142a = false;
        constraint.f5081e.f5100b = false;
        constraint.f5079c.f5156a = false;
        constraint.f5082f.f5162a = false;
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArray.getIndex(i8);
            switch (f5071h.get(index)) {
                case 2:
                    delta.b(2, typedArray.getDimensionPixelSize(index, constraint.f5081e.K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f5070g.get(index));
                    break;
                case 5:
                    delta.c(5, typedArray.getString(index));
                    break;
                case 6:
                    delta.b(6, typedArray.getDimensionPixelOffset(index, constraint.f5081e.E));
                    break;
                case 7:
                    delta.b(7, typedArray.getDimensionPixelOffset(index, constraint.f5081e.F));
                    break;
                case 8:
                    delta.b(8, typedArray.getDimensionPixelSize(index, constraint.f5081e.L));
                    break;
                case 11:
                    delta.b(11, typedArray.getDimensionPixelSize(index, constraint.f5081e.R));
                    break;
                case 12:
                    delta.b(12, typedArray.getDimensionPixelSize(index, constraint.f5081e.S));
                    break;
                case 13:
                    delta.b(13, typedArray.getDimensionPixelSize(index, constraint.f5081e.O));
                    break;
                case 14:
                    delta.b(14, typedArray.getDimensionPixelSize(index, constraint.f5081e.Q));
                    break;
                case 15:
                    delta.b(15, typedArray.getDimensionPixelSize(index, constraint.f5081e.T));
                    break;
                case 16:
                    delta.b(16, typedArray.getDimensionPixelSize(index, constraint.f5081e.P));
                    break;
                case 17:
                    delta.b(17, typedArray.getDimensionPixelOffset(index, constraint.f5081e.f5108f));
                    break;
                case 18:
                    delta.b(18, typedArray.getDimensionPixelOffset(index, constraint.f5081e.f5110g));
                    break;
                case 19:
                    delta.a(19, typedArray.getFloat(index, constraint.f5081e.f5112h));
                    break;
                case 20:
                    delta.a(20, typedArray.getFloat(index, constraint.f5081e.f5139y));
                    break;
                case 21:
                    delta.b(21, typedArray.getLayoutDimension(index, constraint.f5081e.f5106e));
                    break;
                case 22:
                    delta.b(22, f5069f[typedArray.getInt(index, constraint.f5079c.f5157b)]);
                    break;
                case 23:
                    delta.b(23, typedArray.getLayoutDimension(index, constraint.f5081e.f5104d));
                    break;
                case 24:
                    delta.b(24, typedArray.getDimensionPixelSize(index, constraint.f5081e.H));
                    break;
                case 27:
                    delta.b(27, typedArray.getInt(index, constraint.f5081e.G));
                    break;
                case 28:
                    delta.b(28, typedArray.getDimensionPixelSize(index, constraint.f5081e.I));
                    break;
                case 31:
                    delta.b(31, typedArray.getDimensionPixelSize(index, constraint.f5081e.M));
                    break;
                case 34:
                    delta.b(34, typedArray.getDimensionPixelSize(index, constraint.f5081e.J));
                    break;
                case 37:
                    delta.a(37, typedArray.getFloat(index, constraint.f5081e.f5140z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, constraint.f5077a);
                    constraint.f5077a = resourceId;
                    delta.b(38, resourceId);
                    break;
                case 39:
                    delta.a(39, typedArray.getFloat(index, constraint.f5081e.W));
                    break;
                case 40:
                    delta.a(40, typedArray.getFloat(index, constraint.f5081e.V));
                    break;
                case 41:
                    delta.b(41, typedArray.getInt(index, constraint.f5081e.X));
                    break;
                case 42:
                    delta.b(42, typedArray.getInt(index, constraint.f5081e.Y));
                    break;
                case 43:
                    delta.a(43, typedArray.getFloat(index, constraint.f5079c.f5159d));
                    break;
                case 44:
                    delta.d(44, true);
                    delta.a(44, typedArray.getDimension(index, constraint.f5082f.f5175n));
                    break;
                case 45:
                    delta.a(45, typedArray.getFloat(index, constraint.f5082f.f5164c));
                    break;
                case 46:
                    delta.a(46, typedArray.getFloat(index, constraint.f5082f.f5165d));
                    break;
                case 47:
                    delta.a(47, typedArray.getFloat(index, constraint.f5082f.f5166e));
                    break;
                case 48:
                    delta.a(48, typedArray.getFloat(index, constraint.f5082f.f5167f));
                    break;
                case 49:
                    delta.a(49, typedArray.getDimension(index, constraint.f5082f.f5168g));
                    break;
                case 50:
                    delta.a(50, typedArray.getDimension(index, constraint.f5082f.f5169h));
                    break;
                case 51:
                    delta.a(51, typedArray.getDimension(index, constraint.f5082f.f5171j));
                    break;
                case 52:
                    delta.a(52, typedArray.getDimension(index, constraint.f5082f.f5172k));
                    break;
                case 53:
                    delta.a(53, typedArray.getDimension(index, constraint.f5082f.f5173l));
                    break;
                case 54:
                    delta.b(54, typedArray.getInt(index, constraint.f5081e.Z));
                    break;
                case 55:
                    delta.b(55, typedArray.getInt(index, constraint.f5081e.f5099a0));
                    break;
                case 56:
                    delta.b(56, typedArray.getDimensionPixelSize(index, constraint.f5081e.f5101b0));
                    break;
                case 57:
                    delta.b(57, typedArray.getDimensionPixelSize(index, constraint.f5081e.f5103c0));
                    break;
                case 58:
                    delta.b(58, typedArray.getDimensionPixelSize(index, constraint.f5081e.f5105d0));
                    break;
                case 59:
                    delta.b(59, typedArray.getDimensionPixelSize(index, constraint.f5081e.f5107e0));
                    break;
                case 60:
                    delta.a(60, typedArray.getFloat(index, constraint.f5082f.f5163b));
                    break;
                case 62:
                    delta.b(62, typedArray.getDimensionPixelSize(index, constraint.f5081e.C));
                    break;
                case 63:
                    delta.a(63, typedArray.getFloat(index, constraint.f5081e.D));
                    break;
                case 64:
                    delta.b(64, t(typedArray, index, constraint.f5080d.f5143b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        delta.c(65, typedArray.getString(index));
                        break;
                    } else {
                        delta.c(65, Easing.f4446c[typedArray.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    delta.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    delta.a(67, typedArray.getFloat(index, constraint.f5080d.f5150i));
                    break;
                case 68:
                    delta.a(68, typedArray.getFloat(index, constraint.f5079c.f5160e));
                    break;
                case 69:
                    delta.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    delta.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.b(72, typedArray.getInt(index, constraint.f5081e.f5113h0));
                    break;
                case 73:
                    delta.b(73, typedArray.getDimensionPixelSize(index, constraint.f5081e.f5115i0));
                    break;
                case 74:
                    delta.c(74, typedArray.getString(index));
                    break;
                case 75:
                    delta.d(75, typedArray.getBoolean(index, constraint.f5081e.f5129p0));
                    break;
                case 76:
                    delta.b(76, typedArray.getInt(index, constraint.f5080d.f5146e));
                    break;
                case 77:
                    delta.c(77, typedArray.getString(index));
                    break;
                case 78:
                    delta.b(78, typedArray.getInt(index, constraint.f5079c.f5158c));
                    break;
                case 79:
                    delta.a(79, typedArray.getFloat(index, constraint.f5080d.f5148g));
                    break;
                case 80:
                    delta.d(80, typedArray.getBoolean(index, constraint.f5081e.f5125n0));
                    break;
                case 81:
                    delta.d(81, typedArray.getBoolean(index, constraint.f5081e.f5127o0));
                    break;
                case 82:
                    delta.b(82, typedArray.getInteger(index, constraint.f5080d.f5144c));
                    break;
                case 83:
                    delta.b(83, t(typedArray, index, constraint.f5082f.f5170i));
                    break;
                case 84:
                    delta.b(84, typedArray.getInteger(index, constraint.f5080d.f5152k));
                    break;
                case 85:
                    delta.a(85, typedArray.getFloat(index, constraint.f5080d.f5151j));
                    break;
                case 86:
                    int i9 = typedArray.peekValue(index).type;
                    if (i9 == 1) {
                        constraint.f5080d.f5155n = typedArray.getResourceId(index, -1);
                        delta.b(89, constraint.f5080d.f5155n);
                        Motion motion = constraint.f5080d;
                        if (motion.f5155n != -1) {
                            motion.f5154m = -2;
                            delta.b(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i9 == 3) {
                        constraint.f5080d.f5153l = typedArray.getString(index);
                        delta.c(90, constraint.f5080d.f5153l);
                        if (constraint.f5080d.f5153l.indexOf("/") > 0) {
                            constraint.f5080d.f5155n = typedArray.getResourceId(index, -1);
                            delta.b(89, constraint.f5080d.f5155n);
                            constraint.f5080d.f5154m = -2;
                            delta.b(88, -2);
                            break;
                        } else {
                            constraint.f5080d.f5154m = -1;
                            delta.b(88, -1);
                            break;
                        }
                    } else {
                        Motion motion2 = constraint.f5080d;
                        motion2.f5154m = typedArray.getInteger(index, motion2.f5155n);
                        delta.b(88, constraint.f5080d.f5154m);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f5070g.get(index));
                    break;
                case 93:
                    delta.b(93, typedArray.getDimensionPixelSize(index, constraint.f5081e.N));
                    break;
                case 94:
                    delta.b(94, typedArray.getDimensionPixelSize(index, constraint.f5081e.U));
                    break;
                case 95:
                    u(delta, typedArray, index, 0);
                    break;
                case 96:
                    u(delta, typedArray, index, 1);
                    break;
                case 97:
                    delta.b(97, typedArray.getInt(index, constraint.f5081e.f5131q0));
                    break;
                case 98:
                    if (MotionLayout.C0) {
                        int resourceId2 = typedArray.getResourceId(index, constraint.f5077a);
                        constraint.f5077a = resourceId2;
                        if (resourceId2 == -1) {
                            constraint.f5078b = typedArray.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        constraint.f5078b = typedArray.getString(index);
                        break;
                    } else {
                        constraint.f5077a = typedArray.getResourceId(index, constraint.f5077a);
                        break;
                    }
                case 99:
                    delta.d(99, typedArray.getBoolean(index, constraint.f5081e.f5114i));
                    break;
            }
        }
    }

    public void A(int i8, int i9) {
        q(i8).f5079c.f5157b = i9;
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ConstraintLayout constraintLayout, boolean z7) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f5076e.keySet());
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
            int id = childAt.getId();
            if (!this.f5076e.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + Debug.b(childAt));
            } else if (this.f5075d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1) {
                    if (this.f5076e.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        Constraint constraint = this.f5076e.get(Integer.valueOf(id));
                        if (constraint != null) {
                            if (childAt instanceof Barrier) {
                                constraint.f5081e.f5117j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(constraint.f5081e.f5113h0);
                                barrier.setMargin(constraint.f5081e.f5115i0);
                                barrier.setAllowsGoneWidget(constraint.f5081e.f5129p0);
                                Layout layout = constraint.f5081e;
                                int[] iArr = layout.f5119k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = layout.f5121l0;
                                    if (str != null) {
                                        layout.f5119k0 = m(barrier, str);
                                        barrier.setReferencedIds(constraint.f5081e.f5119k0);
                                    }
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.a();
                            constraint.d(layoutParams);
                            if (z7) {
                                ConstraintAttribute.f(childAt, constraint.f5083g);
                            }
                            childAt.setLayoutParams(layoutParams);
                            PropertySet propertySet = constraint.f5079c;
                            if (propertySet.f5158c == 0) {
                                childAt.setVisibility(propertySet.f5157b);
                            }
                            childAt.setAlpha(constraint.f5079c.f5159d);
                            childAt.setRotation(constraint.f5082f.f5163b);
                            childAt.setRotationX(constraint.f5082f.f5164c);
                            childAt.setRotationY(constraint.f5082f.f5165d);
                            childAt.setScaleX(constraint.f5082f.f5166e);
                            childAt.setScaleY(constraint.f5082f.f5167f);
                            Transform transform = constraint.f5082f;
                            if (transform.f5170i != -1) {
                                View findViewById = ((View) childAt.getParent()).findViewById(constraint.f5082f.f5170i);
                                if (findViewById != null) {
                                    float top = (findViewById.getTop() + findViewById.getBottom()) / 2.0f;
                                    float left = (findViewById.getLeft() + findViewById.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(transform.f5168g)) {
                                    childAt.setPivotX(constraint.f5082f.f5168g);
                                }
                                if (!Float.isNaN(constraint.f5082f.f5169h)) {
                                    childAt.setPivotY(constraint.f5082f.f5169h);
                                }
                            }
                            childAt.setTranslationX(constraint.f5082f.f5171j);
                            childAt.setTranslationY(constraint.f5082f.f5172k);
                            childAt.setTranslationZ(constraint.f5082f.f5173l);
                            Transform transform2 = constraint.f5082f;
                            if (transform2.f5174m) {
                                childAt.setElevation(transform2.f5175n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.f5076e.get(num);
            if (constraint2 != null) {
                if (constraint2.f5081e.f5117j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.f5081e;
                    int[] iArr2 = layout2.f5119k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.f5121l0;
                        if (str2 != null) {
                            layout2.f5119k0 = m(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.f5081e.f5119k0);
                        }
                    }
                    barrier2.setType(constraint2.f5081e.f5113h0);
                    barrier2.setMargin(constraint2.f5081e.f5115i0);
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.t();
                    constraint2.d(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.f5081e.f5098a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.d(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = constraintLayout.getChildAt(i9);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).j(constraintLayout);
            }
        }
    }

    public void e(int i8, int i9) {
        Constraint constraint;
        if (!this.f5076e.containsKey(Integer.valueOf(i8)) || (constraint = this.f5076e.get(Integer.valueOf(i8))) == null) {
            return;
        }
        switch (i9) {
            case 1:
                Layout layout = constraint.f5081e;
                layout.f5118k = -1;
                layout.f5116j = -1;
                layout.H = -1;
                layout.O = Integer.MIN_VALUE;
                return;
            case 2:
                Layout layout2 = constraint.f5081e;
                layout2.f5122m = -1;
                layout2.f5120l = -1;
                layout2.I = -1;
                layout2.Q = Integer.MIN_VALUE;
                return;
            case 3:
                Layout layout3 = constraint.f5081e;
                layout3.f5126o = -1;
                layout3.f5124n = -1;
                layout3.J = 0;
                layout3.P = Integer.MIN_VALUE;
                return;
            case 4:
                Layout layout4 = constraint.f5081e;
                layout4.f5128p = -1;
                layout4.f5130q = -1;
                layout4.K = 0;
                layout4.R = Integer.MIN_VALUE;
                return;
            case 5:
                Layout layout5 = constraint.f5081e;
                layout5.f5132r = -1;
                layout5.f5133s = -1;
                layout5.f5134t = -1;
                layout5.N = 0;
                layout5.U = Integer.MIN_VALUE;
                return;
            case 6:
                Layout layout6 = constraint.f5081e;
                layout6.f5135u = -1;
                layout6.f5136v = -1;
                layout6.M = 0;
                layout6.T = Integer.MIN_VALUE;
                return;
            case 7:
                Layout layout7 = constraint.f5081e;
                layout7.f5137w = -1;
                layout7.f5138x = -1;
                layout7.L = 0;
                layout7.S = Integer.MIN_VALUE;
                return;
            case 8:
                Layout layout8 = constraint.f5081e;
                layout8.D = -1.0f;
                layout8.C = -1;
                layout8.B = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void f(Context context, int i8) {
        g((ConstraintLayout) LayoutInflater.from(context).inflate(i8, (ViewGroup) null));
    }

    public void g(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f5076e.clear();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f5075d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f5076e.containsKey(Integer.valueOf(id))) {
                this.f5076e.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.f5076e.get(Integer.valueOf(id));
            if (constraint != null) {
                constraint.f5083g = ConstraintAttribute.b(this.f5074c, childAt);
                constraint.f(id, layoutParams);
                constraint.f5079c.f5157b = childAt.getVisibility();
                constraint.f5079c.f5159d = childAt.getAlpha();
                constraint.f5082f.f5163b = childAt.getRotation();
                constraint.f5082f.f5164c = childAt.getRotationX();
                constraint.f5082f.f5165d = childAt.getRotationY();
                constraint.f5082f.f5166e = childAt.getScaleX();
                constraint.f5082f.f5167f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    Transform transform = constraint.f5082f;
                    transform.f5168g = pivotX;
                    transform.f5169h = pivotY;
                }
                constraint.f5082f.f5171j = childAt.getTranslationX();
                constraint.f5082f.f5172k = childAt.getTranslationY();
                constraint.f5082f.f5173l = childAt.getTranslationZ();
                Transform transform2 = constraint.f5082f;
                if (transform2.f5174m) {
                    transform2.f5175n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    constraint.f5081e.f5129p0 = barrier.getAllowsGoneWidget();
                    constraint.f5081e.f5119k0 = barrier.getReferencedIds();
                    constraint.f5081e.f5113h0 = barrier.getType();
                    constraint.f5081e.f5115i0 = barrier.getMargin();
                }
            }
        }
    }

    public void h(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f5076e.clear();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraints.getChildAt(i8);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f5075d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f5076e.containsKey(Integer.valueOf(id))) {
                this.f5076e.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.f5076e.get(Integer.valueOf(id));
            if (constraint != null) {
                if (childAt instanceof ConstraintHelper) {
                    constraint.h((ConstraintHelper) childAt, id, layoutParams);
                }
                constraint.g(id, layoutParams);
            }
        }
    }

    public void i(int i8, int i9, int i10, int i11) {
        if (!this.f5076e.containsKey(Integer.valueOf(i8))) {
            this.f5076e.put(Integer.valueOf(i8), new Constraint());
        }
        Constraint constraint = this.f5076e.get(Integer.valueOf(i8));
        if (constraint == null) {
            return;
        }
        switch (i9) {
            case 1:
                if (i11 == 1) {
                    Layout layout = constraint.f5081e;
                    layout.f5116j = i10;
                    layout.f5118k = -1;
                    return;
                } else if (i11 == 2) {
                    Layout layout2 = constraint.f5081e;
                    layout2.f5118k = i10;
                    layout2.f5116j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + B(i11) + " undefined");
                }
            case 2:
                if (i11 == 1) {
                    Layout layout3 = constraint.f5081e;
                    layout3.f5120l = i10;
                    layout3.f5122m = -1;
                    return;
                } else if (i11 == 2) {
                    Layout layout4 = constraint.f5081e;
                    layout4.f5122m = i10;
                    layout4.f5120l = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
            case 3:
                if (i11 == 3) {
                    Layout layout5 = constraint.f5081e;
                    layout5.f5124n = i10;
                    layout5.f5126o = -1;
                    layout5.f5132r = -1;
                    layout5.f5133s = -1;
                    layout5.f5134t = -1;
                    return;
                } else if (i11 == 4) {
                    Layout layout6 = constraint.f5081e;
                    layout6.f5126o = i10;
                    layout6.f5124n = -1;
                    layout6.f5132r = -1;
                    layout6.f5133s = -1;
                    layout6.f5134t = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
            case 4:
                if (i11 == 4) {
                    Layout layout7 = constraint.f5081e;
                    layout7.f5130q = i10;
                    layout7.f5128p = -1;
                    layout7.f5132r = -1;
                    layout7.f5133s = -1;
                    layout7.f5134t = -1;
                    return;
                } else if (i11 == 3) {
                    Layout layout8 = constraint.f5081e;
                    layout8.f5128p = i10;
                    layout8.f5130q = -1;
                    layout8.f5132r = -1;
                    layout8.f5133s = -1;
                    layout8.f5134t = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
            case 5:
                if (i11 == 5) {
                    Layout layout9 = constraint.f5081e;
                    layout9.f5132r = i10;
                    layout9.f5130q = -1;
                    layout9.f5128p = -1;
                    layout9.f5124n = -1;
                    layout9.f5126o = -1;
                    return;
                } else if (i11 == 3) {
                    Layout layout10 = constraint.f5081e;
                    layout10.f5133s = i10;
                    layout10.f5130q = -1;
                    layout10.f5128p = -1;
                    layout10.f5124n = -1;
                    layout10.f5126o = -1;
                    return;
                } else if (i11 == 4) {
                    Layout layout11 = constraint.f5081e;
                    layout11.f5134t = i10;
                    layout11.f5130q = -1;
                    layout11.f5128p = -1;
                    layout11.f5124n = -1;
                    layout11.f5126o = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
            case 6:
                if (i11 == 6) {
                    Layout layout12 = constraint.f5081e;
                    layout12.f5136v = i10;
                    layout12.f5135u = -1;
                    return;
                } else if (i11 == 7) {
                    Layout layout13 = constraint.f5081e;
                    layout13.f5135u = i10;
                    layout13.f5136v = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
            case 7:
                if (i11 == 7) {
                    Layout layout14 = constraint.f5081e;
                    layout14.f5138x = i10;
                    layout14.f5137w = -1;
                    return;
                } else if (i11 == 6) {
                    Layout layout15 = constraint.f5081e;
                    layout15.f5137w = i10;
                    layout15.f5138x = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
            default:
                throw new IllegalArgumentException(B(i9) + " to " + B(i11) + " unknown");
        }
    }

    public void j(int i8, int i9, int i10, int i11, int i12) {
        if (!this.f5076e.containsKey(Integer.valueOf(i8))) {
            this.f5076e.put(Integer.valueOf(i8), new Constraint());
        }
        Constraint constraint = this.f5076e.get(Integer.valueOf(i8));
        if (constraint == null) {
            return;
        }
        switch (i9) {
            case 1:
                if (i11 == 1) {
                    Layout layout = constraint.f5081e;
                    layout.f5116j = i10;
                    layout.f5118k = -1;
                } else if (i11 == 2) {
                    Layout layout2 = constraint.f5081e;
                    layout2.f5118k = i10;
                    layout2.f5116j = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + B(i11) + " undefined");
                }
                constraint.f5081e.H = i12;
                return;
            case 2:
                if (i11 == 1) {
                    Layout layout3 = constraint.f5081e;
                    layout3.f5120l = i10;
                    layout3.f5122m = -1;
                } else if (i11 == 2) {
                    Layout layout4 = constraint.f5081e;
                    layout4.f5122m = i10;
                    layout4.f5120l = -1;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
                constraint.f5081e.I = i12;
                return;
            case 3:
                if (i11 == 3) {
                    Layout layout5 = constraint.f5081e;
                    layout5.f5124n = i10;
                    layout5.f5126o = -1;
                    layout5.f5132r = -1;
                    layout5.f5133s = -1;
                    layout5.f5134t = -1;
                } else if (i11 == 4) {
                    Layout layout6 = constraint.f5081e;
                    layout6.f5126o = i10;
                    layout6.f5124n = -1;
                    layout6.f5132r = -1;
                    layout6.f5133s = -1;
                    layout6.f5134t = -1;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
                constraint.f5081e.J = i12;
                return;
            case 4:
                if (i11 == 4) {
                    Layout layout7 = constraint.f5081e;
                    layout7.f5130q = i10;
                    layout7.f5128p = -1;
                    layout7.f5132r = -1;
                    layout7.f5133s = -1;
                    layout7.f5134t = -1;
                } else if (i11 == 3) {
                    Layout layout8 = constraint.f5081e;
                    layout8.f5128p = i10;
                    layout8.f5130q = -1;
                    layout8.f5132r = -1;
                    layout8.f5133s = -1;
                    layout8.f5134t = -1;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
                constraint.f5081e.K = i12;
                return;
            case 5:
                if (i11 == 5) {
                    Layout layout9 = constraint.f5081e;
                    layout9.f5132r = i10;
                    layout9.f5130q = -1;
                    layout9.f5128p = -1;
                    layout9.f5124n = -1;
                    layout9.f5126o = -1;
                    return;
                } else if (i11 == 3) {
                    Layout layout10 = constraint.f5081e;
                    layout10.f5133s = i10;
                    layout10.f5130q = -1;
                    layout10.f5128p = -1;
                    layout10.f5124n = -1;
                    layout10.f5126o = -1;
                    return;
                } else if (i11 == 4) {
                    Layout layout11 = constraint.f5081e;
                    layout11.f5134t = i10;
                    layout11.f5130q = -1;
                    layout11.f5128p = -1;
                    layout11.f5124n = -1;
                    layout11.f5126o = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
            case 6:
                if (i11 == 6) {
                    Layout layout12 = constraint.f5081e;
                    layout12.f5136v = i10;
                    layout12.f5135u = -1;
                } else if (i11 == 7) {
                    Layout layout13 = constraint.f5081e;
                    layout13.f5135u = i10;
                    layout13.f5136v = -1;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
                constraint.f5081e.M = i12;
                return;
            case 7:
                if (i11 == 7) {
                    Layout layout14 = constraint.f5081e;
                    layout14.f5138x = i10;
                    layout14.f5137w = -1;
                } else if (i11 == 6) {
                    Layout layout15 = constraint.f5081e;
                    layout15.f5137w = i10;
                    layout15.f5138x = -1;
                } else {
                    throw new IllegalArgumentException("right to " + B(i11) + " undefined");
                }
                constraint.f5081e.L = i12;
                return;
            default:
                throw new IllegalArgumentException(B(i9) + " to " + B(i11) + " unknown");
        }
    }

    public void k(int i8, int i9, int i10, float f8) {
        Layout layout = q(i8).f5081e;
        layout.B = i9;
        layout.C = i10;
        layout.D = f8;
    }

    public void l(int i8, int i9) {
        q(i8).f5081e.f5107e0 = i9;
    }

    public void n(int i8, int i9, int i10, int i11, int[] iArr, float[] fArr, int i12) {
        o(i8, i9, i10, i11, iArr, fArr, i12, 1, 2);
    }

    public void r(Context context, int i8) {
        XmlResourceParser xml = context.getResources().getXml(i8);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    if (eventType != 2) {
                        continue;
                    } else {
                        String name = xml.getName();
                        Constraint p8 = p(context, Xml.asAttributeSet(xml), false);
                        if (name.equalsIgnoreCase("Guideline")) {
                            p8.f5081e.f5098a = true;
                        }
                        this.f5076e.put(Integer.valueOf(p8.f5077a), p8);
                        continue;
                    }
                } else {
                    xml.getName();
                    continue;
                }
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        } catch (XmlPullParserException e9) {
            e9.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x01cb, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void s(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.s(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void z(int i8, float f8) {
        q(i8).f5081e.f5140z = f8;
    }
}
