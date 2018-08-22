package com.example.bear.cts;

import android.content.Context;
import android.content.Intent;
import android.os.LocaleList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextLinks;
import android.view.textclassifier.TextSelection;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        textView.setTextIsSelectable(false);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        /**
         * TextLinks
         */
        Spannable text = (Spannable) textView.getText();
        TextLinks.Request.Builder request = new TextLinks.Request.Builder(text);
        TextClassificationManager textClassificationManager = (TextClassificationManager) getSystemService(Context.TEXT_CLASSIFICATION_SERVICE);
        textClassificationManager.getTextClassifier().generateLinks(request.build()).apply(text, TextLinks.APPLY_STRATEGY_REPLACE, null);
        textView.setText(text);

//        textView.setTextClassifier(new TextClassifier(){
//            @Override
//            public TextSelection suggestSelection(CharSequence text, int selectionStartIndex, int selectionEndIndex, LocaleList defaultLocales) {
//                return new TextSelection.Builder(0, 40).build();
//            }
//
//            @Override
//            public TextClassification classifyText(CharSequence text, int startIndex, int endIndex, LocaleList defaultLocales) {
//                return new TextClassification.Builder().build();
//            }
//        });
//        textView.setText("Activity is No." + i++);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Main2Activity.class));
//            }
//        });
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {
        super.onActionModeStarted(mode);
        Log.d("cts", "onActionModeStarted: ");
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {
        super.onActionModeFinished(mode);
        Log.d("cts", "onActionModeFinished: ");
    }
}
