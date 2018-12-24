package com.uthai.service.impl;

import com.uthai.po.Token;
import com.uthai.service.GetTokenFromServer;
import com.uthai.util.AccessToken;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class TokenImpl implements GetTokenFromServer {
    @Resource
    TokenServiceImpl tokenService;
    @Resource
    WXServiceImpl wxService;
    @Override
    public String getTokenString() {
            Token token = tokenService.selectToken();
            String result = token.getAccessToken();
            String mytoken = null;
            long timestamp = System.currentTimeMillis();
            if (result == null) {
                AccessToken atoken = wxService.getToken();
                tokenService.insertToken(atoken.getAccess_token(),timestamp, atoken.getExpires_in());
                mytoken = atoken.getAccess_token();
            } else if (result != null) {
                long time = token.getCreateTime();
                /**
                 * 超时的，重新申请Token并更新数据库
                 */
                if ((timestamp - time) / 1000L / 60L >= 120L) {
                    AccessToken atoken = wxService.getToken();
                    tokenService.updateToken(atoken.getAccess_token(),timestamp, atoken.getExpires_in());
                    mytoken = atoken.getAccess_token();
                    /**
                     * 未超时，无需重新申请
                     */
                } else if ((timestamp - time) / 1000L / 60L < 120L) {
                    mytoken =token.getAccessToken();
                }
            }

            return mytoken;
        }

}
