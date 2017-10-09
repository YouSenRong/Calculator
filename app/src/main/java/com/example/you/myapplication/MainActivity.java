package com.example.you.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;

public class MainActivity extends AppCompatActivity {

//    //声明按钮
//    private Button myNumBtn[];
    private TextView TextExpression;
    private TextView TextResult;
    private String strExpression = "";
    private String strResult = "";
    private boolean ifClear = false;
    Calculator calculator = new Calculator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //通过findViewById（）初始化控件

//        myNumBtn[0] = (Button) findViewById(R.id.btn_zero);
//        myNumBtn[1] = (Button) findViewById(R.id.btn_one);
//        myNumBtn[2] = (Button) findViewById(R.id.btn_two);
//        myNumBtn[3] = (Button) findViewById(R.id.btn_three);
//        myNumBtn[4] = (Button) findViewById(R.id.btn_four);
//        myNumBtn[5] = (Button) findViewById(R.id.btn_five);
//        myNumBtn[6] = (Button) findViewById(R.id.btn_six);
//        myNumBtn[7] = (Button) findViewById(R.id.btn_seven);
//        myNumBtn[8] = (Button) findViewById(R.id.btn_eight);
//        myNumBtn[9] = (Button) findViewById(R.id.btn_nine);
        TextExpression = (TextView) findViewById(R.id.textView);
        //ResultEdit = (EditText) findViewById(R.id.editText);
        TextResult = (TextView) findViewById(R.id.ResultTextView);
        TextExpression.setTextIsSelectable(true);
        TextResult.setTextIsSelectable(true);
        //hideSoftInputMethod(ResultEdit);
        // ResultEdit.setInputType(InputType.TYPE_NULL);
        //InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(ResultEdit.getWindowToken(), 0);


    }
    //通过实现onClick()方法，实现数字0~9的点击
    public void ClickZero(View v)
    {
        Clear();
        strExpression = strExpression + "0";
        //ShowExpression(strExpression);
        NumClickShowExpression(strExpression);
    }
    public void ClickOne(View v)
    {
        Clear();
        strExpression = strExpression + "1";
        //ShowExpression(strExpression);
        NumClickShowExpression(strExpression);
    }
    public void ClickTwo(View v)
    {
        Clear();
        strExpression = strExpression + "2";
        //ShowExpression(strExpression);
        NumClickShowExpression(strExpression);
    }
    public void ClickThree(View v)
    {
        Clear();
        strExpression = strExpression + "3";
        //ShowExpression(strExpression);
        NumClickShowExpression(strExpression);
    }
    public void ClickFour(View v)
    {
        Clear();
        strExpression = strExpression + "4";
        //ShowExpression(strExpression);

        NumClickShowExpression(strExpression);
    }
    public void ClickFive(View v)
    {
        Clear();
        strExpression = strExpression + "5";
        //ShowExpression(strExpression);

        NumClickShowExpression(strExpression);
    }
    public void ClickSix(View v)
    {
        Clear();
        strExpression = strExpression + "6";
        //ShowExpression(strExpression);

        NumClickShowExpression(strExpression);
    }
    public void ClickSeven(View v)
    {
        Clear();
        strExpression = strExpression + "7";
        //ShowExpression(strExpression);

        NumClickShowExpression(strExpression);
    }
    public void ClickEight(View v)
    {
        Clear();
        strExpression = strExpression + "8";
        //ShowExpression(strExpression);

        NumClickShowExpression(strExpression);
    }
    public void ClickNine(View v)
    {
        Clear();
        strExpression = strExpression + "9";
        //ShowExpression(strExpression);

        NumClickShowExpression(strExpression);
    }


    //操作符响应函数
    public void ClickClear(View v)
    {
        strExpression = "";
        ShowExpression(strExpression);
    }
    public void ClickMultiply(View v)
    {
        ifClear = false;
        TextExpression.setTextSize(35);
        strExpression = strExpression + "×";
        ShowExpression(strExpression);
    }
    public void ClickDivide(View v)
    {
        ifClear = false;
        TextExpression.setTextSize(35);
        strExpression = strExpression + "÷";
        ShowExpression(strExpression);
    }
    public void ClickBack(View v)
    {
        if(strExpression.isEmpty())
        {
            return;
        }
        strExpression = strExpression.substring(0,strExpression.length()-1);
        ShowExpression(strExpression);
    }
    public void ClickPlus(View v)
    {
        ifClear = false;
        TextExpression.setTextSize(35);
        strExpression = strExpression + "+";
        ShowExpression(strExpression);
    }
    public void ClickMinus(View v)
    {
        ifClear = false;
        TextExpression.setTextSize(35);
        strExpression = strExpression + "-";
        ShowExpression(strExpression);
    }
    public void ClickEqual(View v)
    {
        ifClear = true;
        if(strExpression.isEmpty())
            return ;
        calculator.setStrExpression(strExpression);
        double Result = calculator.Operate();
        TextExpression.setTextSize(50);
        strExpression = String.valueOf(Result);
        ShowExpression(strExpression);
        strResult = "";
        ShowResult(strResult);
    }
    public void ClickPoint(View v)
    {
        ifClear = false;
        strExpression = strExpression + ".";
        ShowExpression(strExpression);
    }
    public void ClickPercent(View v)
    {
        strExpression = strExpression + "%";
        //ShowExpression(strExpression);
        NumClickShowExpression(strExpression);
    }

    public void Clear()
    {
        if(ifClear)
        {
            strExpression = "";
            ifClear = false;
        }
    }
    public void NumClickShowExpression(String strExpression)
    {
        TextExpression.setTextSize(35);
        calculator.setStrExpression(strExpression);
        double Result = calculator.Operate();
        strResult = String.valueOf(Result);
        ShowResult(strResult);
        ShowExpression(strExpression);
    }
    //显示表达式
    public void ShowExpression(String strExpression)
    {
        TextExpression.setText(strExpression);
    }
    //显示结果
    public void ShowResult(String strExpression)
    {
        //TextExpression.setText(strExpression);
        TextResult.setText(strExpression);
    }
}

class Calculator
{
    private String strExpression;
    private Hashtable<Character, Integer> ht = new Hashtable<>();
    private char Key[] = {'#', '+', '-', '×', '÷', '%'};
    private int Priority[] = {0, 1, 1, 2, 2, 3};
    //操作运算符栈
    private Stack<Character> CharStack = new Stack<>();
    //操作数栈
    private Stack<Double> NumStack = new Stack<>();
    //运算结果
    private double dResult = 0;
    private String strResult = "";
    //构造函数
    public Calculator()
    {
        for(int i =0; i<Key.length; i++)
        {
            ht.put(Key[i], Priority[i]);
        }
        this.strExpression = "";
    }
    //带参构造函数
    public Calculator(String strExpression)
    {
        for(int i =0; i<Key.length; i++)
        {
            ht.put(Key[i], Priority[i]);
        }
        strExpression = strExpression.concat("#");
        this.strExpression = strExpression;
    }
    public void setStrExpression(String strExpression)
    {
        strExpression = strExpression.concat("#");
        this.strExpression = strExpression;
    }
    public String getStrExpression()
    {
        return this.strExpression;
    }
    public double getdResult()
    {
        return this.dResult;
    }
    public String getStrResult()
    {
        return this.strResult;
    }
    public double[] getNum(String string)
    {
        String strNumArray[] = string.split("#|\\+|-|×|÷|%");
        double dNumArray[] = new double[strNumArray.length];
        for(int i = 0,j = 0; i < strNumArray.length; i++)
        {
            if(!strNumArray[i].isEmpty())
            {
                dNumArray[j++] = Double.parseDouble(strNumArray[i]);
            }
        }
        return dNumArray;
    }
    public double Operate()
    {
        //操作数数组
        int j = 0;
        double dNumArray[] = getNum(strExpression);
        CharStack.push('#');
        NumStack.push(dNumArray[j++]);
        for (int i = 0; i < strExpression.length();)
        {
            char charTemp = strExpression.charAt(i);
            if(charTemp == '+' || charTemp == '-' || charTemp == '×' || charTemp == '÷')
            {
                if(ht.get(charTemp) > ht.get(CharStack.peek()))
                {
                    CharStack.push(charTemp);
                    NumStack.push(dNumArray[j++]);
                    i++;
                }
                else
                {
                    char charOperator = CharStack.pop();
                    calculate(charOperator);
                }
            }
            else if(charTemp == '%')
            {
                NumStack.push(NumStack.pop() *0.01);
                i++;
            }
            else if(charTemp == '#')
            {
                if(CharStack.peek() == '#')
                {
                    dResult = NumStack.peek();
                    return  dResult;
                }
                else
                {
                    calculate(CharStack.pop());
                }
                /**
                 * while
                 */
            }
            else
            {
                i++;
            }
        }
        return 0;
    }
    public int calculate(char charOperator)
    {
        double dNum1 = 0;
        double dNum2 = 0;
        switch(charOperator)
        {
            case '+':
                dNum1 = NumStack.pop();
                dNum2 = NumStack.pop();
                NumStack.push(dNum1 + dNum2);
                break;
            case '-':
                dNum1 = NumStack.pop();
                dNum2 = NumStack.pop();
                NumStack.push(dNum2 - dNum1);
                break;
            case '×':
                dNum1 = NumStack.pop();
                dNum2 = NumStack.pop();
                NumStack.push(dNum1 * dNum2);
                break;
            case '÷':
                dNum1 = NumStack.pop();
                dNum2 = NumStack.pop();
                if(dNum1 != 0)
                {
                    NumStack.push(dNum2 / dNum1);
                }
                else
                {
                    return 0;
                }
                break;
//            case '%':
//                dNum1 = NumStack.pop();
//                NumStack.push(dNum1 * 0.01);
//                break;
        }
        return 1;
    }

}