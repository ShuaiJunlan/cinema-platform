package cn.shuaijunlan.platformgateway.modular.auth.validator.impl;

import cn.shuaijunlan.platformgateway.modular.auth.validator.IReqValidator;
import cn.shuaijunlan.platformgateway.modular.auth.validator.dto.Credence;
import org.springframework.stereotype.Service;

/**
 * 账号密码验证
 *
 * @author fengshuonan
 * @date 2017-08-23 12:34
 */
@Service
public class DbValidator implements IReqValidator {

    // @Autowired
    // UserMapper userMapper;

    @Override
    public boolean validate(Credence credence) {
        // List<User> users = userMapper.selectList(new EntityWrapper<User>().eq("userName", credence.getCredenceName()));
        // if (users != null && users.size() > 0) {
        //     return true;
        // } else {
        //     return false;
        // }
        return true;
    }
}
