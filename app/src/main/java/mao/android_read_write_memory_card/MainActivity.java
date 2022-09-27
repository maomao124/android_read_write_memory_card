package mao.android_read_write_memory_card;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.TextView_result);

        // 获取系统的公共存储路径
        String s = Environment.getExternalStorageDirectory().toString();
        textView.setText(textView.getText() + "\n\n公共存储根路径：" + s);

        s = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();

        textView.setText(textView.getText() + "\n\n公共存储下载路径：" + s);

        s = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).toString();

        textView.setText(textView.getText() + "\n\n公共存储音乐路径：" + s);

        s = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();

        textView.setText(textView.getText() + "\n\n公共存储图片路径：" + s);

        s = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString();

        textView.setText(textView.getText() + "\n\n私有存储下载路径：" + s);

        // Android10的存储空间默认采取分区方式，此处判断是传统方式还是分区方式
        boolean externalStorageLegacy = Environment.isExternalStorageLegacy();

        textView.setText(textView.getText() + "\n\n是否是分区方式：" + externalStorageLegacy);
    }
}