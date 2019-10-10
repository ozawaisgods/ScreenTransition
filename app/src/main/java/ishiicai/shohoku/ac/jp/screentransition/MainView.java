package ishiicai.shohoku.ac.jp.screentransition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.text.AttributedCharacterIterator;

public class MainView extends View {
    public final int FIRST = 1;     //状態を表す定数1
    public final int SECOND = 2;    //状態を表す定数2

    int state;      //状態を表す変数

    /**
     * コンストラクタ
     * @param context
     * @param attrs
     */
    public MainView(Context context, AttributeSet attrs){
        super(context, attrs);
        state = FIRST;      //始めは状態1
    }

    //画面遷移メソッド
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        if (state == FIRST) { //状態1の場合の描画
            p.setColor(Color.BLUE);
            canvas.drawARGB(255, 255, 255, 255);
            canvas.drawRect(100, 100, 300, 200, p);
        } else if (state == SECOND) {     //状態2の場合の描画
            p.setColor(Color.RED);
            canvas.drawARGB(255, 255, 255, 0);
            canvas.drawRect(100, 100, 300, 200, p);
        }else {      //それ以外の場合は、logにエラーを吐き出す
            Log.d("error", "never come here");
        }
    }

    @Override
    public  boolean onTouchEcent(MotionEvent event){
        int x = (int) event.getX();
        int y = (int) event.getY();

        //長方形の内部
        if(x>100 && x<300 && y>100 && y<200){
            if(state == FIRST){ //状態１だったら状態２へ
                state = SECOND;
            } else if (state == SECOND){ //状態 2 だったら状態 1 へ
                state = FIRST;
            } else { //それ以外だったらエラーを吐き出す
                Log.d("error", "never come here");
            }
        }

        invalidate();   //再描画
        return super.onTouchEvent(event);
    }
}
