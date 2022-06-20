package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewSpline extends SplineSet {
    private static final String TAG = "ViewSpline";

    public abstract void setProperty(View view, float f);

    public static ViewSpline makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.constraintlayout.motion.utils.ViewSpline makeSpline(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1249320806: goto L_0x00ae;
                case -1249320805: goto L_0x00a4;
                case -1225497657: goto L_0x0099;
                case -1225497656: goto L_0x008e;
                case -1225497655: goto L_0x0083;
                case -1001078227: goto L_0x0078;
                case -908189618: goto L_0x006d;
                case -908189617: goto L_0x0062;
                case -797520672: goto L_0x0057;
                case -760884510: goto L_0x004c;
                case -760884509: goto L_0x0041;
                case -40300674: goto L_0x0036;
                case -4379043: goto L_0x002b;
                case 37232917: goto L_0x0020;
                case 92909918: goto L_0x0015;
                case 156108012: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x00b8
        L_0x0009:
            java.lang.String r0 = "waveOffset"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 10
            goto L_0x00b9
        L_0x0015:
            java.lang.String r0 = "alpha"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 0
            goto L_0x00b9
        L_0x0020:
            java.lang.String r0 = "transitionPathRotate"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 7
            goto L_0x00b9
        L_0x002b:
            java.lang.String r0 = "elevation"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 1
            goto L_0x00b9
        L_0x0036:
            java.lang.String r0 = "rotation"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 2
            goto L_0x00b9
        L_0x0041:
            java.lang.String r0 = "transformPivotY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 6
            goto L_0x00b9
        L_0x004c:
            java.lang.String r0 = "transformPivotX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 5
            goto L_0x00b9
        L_0x0057:
            java.lang.String r0 = "waveVariesBy"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 11
            goto L_0x00b9
        L_0x0062:
            java.lang.String r0 = "scaleY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 9
            goto L_0x00b9
        L_0x006d:
            java.lang.String r0 = "scaleX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 8
            goto L_0x00b9
        L_0x0078:
            java.lang.String r0 = "progress"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 15
            goto L_0x00b9
        L_0x0083:
            java.lang.String r0 = "translationZ"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 14
            goto L_0x00b9
        L_0x008e:
            java.lang.String r0 = "translationY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 13
            goto L_0x00b9
        L_0x0099:
            java.lang.String r0 = "translationX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 12
            goto L_0x00b9
        L_0x00a4:
            java.lang.String r0 = "rotationY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 4
            goto L_0x00b9
        L_0x00ae:
            java.lang.String r0 = "rotationX"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 3
            goto L_0x00b9
        L_0x00b8:
            r1 = -1
        L_0x00b9:
            switch(r1) {
                case 0: goto L_0x0118;
                case 1: goto L_0x0112;
                case 2: goto L_0x010c;
                case 3: goto L_0x0106;
                case 4: goto L_0x0100;
                case 5: goto L_0x00fa;
                case 6: goto L_0x00f4;
                case 7: goto L_0x00ee;
                case 8: goto L_0x00e8;
                case 9: goto L_0x00e2;
                case 10: goto L_0x00dc;
                case 11: goto L_0x00d6;
                case 12: goto L_0x00d0;
                case 13: goto L_0x00ca;
                case 14: goto L_0x00c4;
                case 15: goto L_0x00be;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            r1 = 0
            return r1
        L_0x00be:
            androidx.constraintlayout.motion.utils.ViewSpline$ProgressSet r1 = new androidx.constraintlayout.motion.utils.ViewSpline$ProgressSet
            r1.<init>()
            return r1
        L_0x00c4:
            androidx.constraintlayout.motion.utils.ViewSpline$TranslationZset r1 = new androidx.constraintlayout.motion.utils.ViewSpline$TranslationZset
            r1.<init>()
            return r1
        L_0x00ca:
            androidx.constraintlayout.motion.utils.ViewSpline$TranslationYset r1 = new androidx.constraintlayout.motion.utils.ViewSpline$TranslationYset
            r1.<init>()
            return r1
        L_0x00d0:
            androidx.constraintlayout.motion.utils.ViewSpline$TranslationXset r1 = new androidx.constraintlayout.motion.utils.ViewSpline$TranslationXset
            r1.<init>()
            return r1
        L_0x00d6:
            androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet r1 = new androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet
            r1.<init>()
            return r1
        L_0x00dc:
            androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet r1 = new androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet
            r1.<init>()
            return r1
        L_0x00e2:
            androidx.constraintlayout.motion.utils.ViewSpline$ScaleYset r1 = new androidx.constraintlayout.motion.utils.ViewSpline$ScaleYset
            r1.<init>()
            return r1
        L_0x00e8:
            androidx.constraintlayout.motion.utils.ViewSpline$ScaleXset r1 = new androidx.constraintlayout.motion.utils.ViewSpline$ScaleXset
            r1.<init>()
            return r1
        L_0x00ee:
            androidx.constraintlayout.motion.utils.ViewSpline$PathRotate r1 = new androidx.constraintlayout.motion.utils.ViewSpline$PathRotate
            r1.<init>()
            return r1
        L_0x00f4:
            androidx.constraintlayout.motion.utils.ViewSpline$PivotYset r1 = new androidx.constraintlayout.motion.utils.ViewSpline$PivotYset
            r1.<init>()
            return r1
        L_0x00fa:
            androidx.constraintlayout.motion.utils.ViewSpline$PivotXset r1 = new androidx.constraintlayout.motion.utils.ViewSpline$PivotXset
            r1.<init>()
            return r1
        L_0x0100:
            androidx.constraintlayout.motion.utils.ViewSpline$RotationYset r1 = new androidx.constraintlayout.motion.utils.ViewSpline$RotationYset
            r1.<init>()
            return r1
        L_0x0106:
            androidx.constraintlayout.motion.utils.ViewSpline$RotationXset r1 = new androidx.constraintlayout.motion.utils.ViewSpline$RotationXset
            r1.<init>()
            return r1
        L_0x010c:
            androidx.constraintlayout.motion.utils.ViewSpline$RotationSet r1 = new androidx.constraintlayout.motion.utils.ViewSpline$RotationSet
            r1.<init>()
            return r1
        L_0x0112:
            androidx.constraintlayout.motion.utils.ViewSpline$ElevationSet r1 = new androidx.constraintlayout.motion.utils.ViewSpline$ElevationSet
            r1.<init>()
            return r1
        L_0x0118:
            androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet r1 = new androidx.constraintlayout.motion.utils.ViewSpline$AlphaSet
            r1.<init>()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.utils.ViewSpline.makeSpline(java.lang.String):androidx.constraintlayout.motion.utils.ViewSpline");
    }

    static class ElevationSet extends ViewSpline {
        ElevationSet() {
        }

        public void setProperty(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f));
            }
        }
    }

    static class AlphaSet extends ViewSpline {
        AlphaSet() {
        }

        public void setProperty(View view, float f) {
            view.setAlpha(get(f));
        }
    }

    static class RotationSet extends ViewSpline {
        RotationSet() {
        }

        public void setProperty(View view, float f) {
            view.setRotation(get(f));
        }
    }

    static class RotationXset extends ViewSpline {
        RotationXset() {
        }

        public void setProperty(View view, float f) {
            view.setRotationX(get(f));
        }
    }

    static class RotationYset extends ViewSpline {
        RotationYset() {
        }

        public void setProperty(View view, float f) {
            view.setRotationY(get(f));
        }
    }

    static class PivotXset extends ViewSpline {
        PivotXset() {
        }

        public void setProperty(View view, float f) {
            view.setPivotX(get(f));
        }
    }

    static class PivotYset extends ViewSpline {
        PivotYset() {
        }

        public void setProperty(View view, float f) {
            view.setPivotY(get(f));
        }
    }

    public static class PathRotate extends ViewSpline {
        public void setProperty(View view, float f) {
        }

        public void setPathRotate(View view, float f, double d, double d2) {
            view.setRotation(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }
    }

    static class ScaleXset extends ViewSpline {
        ScaleXset() {
        }

        public void setProperty(View view, float f) {
            view.setScaleX(get(f));
        }
    }

    static class ScaleYset extends ViewSpline {
        ScaleYset() {
        }

        public void setProperty(View view, float f) {
            view.setScaleY(get(f));
        }
    }

    static class TranslationXset extends ViewSpline {
        TranslationXset() {
        }

        public void setProperty(View view, float f) {
            view.setTranslationX(get(f));
        }
    }

    static class TranslationYset extends ViewSpline {
        TranslationYset() {
        }

        public void setProperty(View view, float f) {
            view.setTranslationY(get(f));
        }
    }

    static class TranslationZset extends ViewSpline {
        TranslationZset() {
        }

        public void setProperty(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f));
            }
        }
    }

    public static class CustomSet extends ViewSpline {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = numberOfInterpolatedValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            for (int i2 = 0; i2 < size; i2++) {
                dArr[i2] = ((double) this.mConstraintAttributeList.keyAt(i2)) * 0.01d;
                this.mConstraintAttributeList.valueAt(i2).getValuesToInterpolate(this.mTempValues);
                int i3 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i3 >= fArr.length) {
                        break;
                    }
                    dArr2[i2][i3] = (double) fArr[i3];
                    i3++;
                }
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int i, ConstraintAttribute constraintAttribute) {
            this.mConstraintAttributeList.append(i, constraintAttribute);
        }

        public void setProperty(View view, float f) {
            this.mCurveFit.getPos((double) f, this.mTempValues);
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view, this.mTempValues);
        }
    }

    static class ProgressSet extends ViewSpline {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        public void setProperty(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f));
            } else if (!this.mNoMethod) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(get(f))});
                    } catch (IllegalAccessException e) {
                        Log.e(ViewSpline.TAG, "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e(ViewSpline.TAG, "unable to setProgress", e2);
                    }
                }
            }
        }
    }
}
