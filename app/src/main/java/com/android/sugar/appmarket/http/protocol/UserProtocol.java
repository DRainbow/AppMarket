package com.android.sugar.appmarket.http.protocol;

import com.android.sugar.appmarket.bean.UserInfo;
import com.android.sugar.appmarket.utils.LogUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserProtocol
 * @Description:
 * @author: SugarT
 * @date: 16/7/25 上午10:52
 */
public class UserProtocol extends BaseProtocol<List<UserInfo>> {

    @Override
    protected String getKey() {
        return "user";
    }

    @Override
    protected List<UserInfo> parseFromJson(String json) {
        try {
            List<UserInfo> list = new ArrayList<>();
            JSONObject obj = new JSONObject(json);
            UserInfo info = new UserInfo();
            info.setName(obj.getString("name"));
            info.setEmail(obj.getString("email"));
            info.setUrl(obj.getString("url"));
            list.add(info);
            return list;
        } catch (Exception e) {
            LogUtils.e(e);
            return null;
        }
    }
}
