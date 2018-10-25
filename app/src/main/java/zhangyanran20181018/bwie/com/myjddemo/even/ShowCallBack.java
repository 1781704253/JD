package zhangyanran20181018.bwie.com.myjddemo.even;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by 匹诺曹 on 2018/10/23.
 */

public interface ShowCallBack {
    void onSuccess(Call call, Response response);
    void onFailure(Call call, IOException e);
}
