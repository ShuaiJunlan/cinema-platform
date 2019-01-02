package cn.shuaijunlan.platform.user.manager.modular.auth.validator.impl;

import cn.shuaijunlan.platform.user.manager.modular.auth.validator.IReqValidator;
import cn.shuaijunlan.platform.user.manager.modular.auth.validator.dto.Credence;
import cn.shuaijunlan.platform.user.manager.persistence.dao.repository.UserRepository;
import com.stylefeng.guns.api.user.vo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号密码验证
 *
 * @author fengshuonan
 * @date 2017-08-23 12:34
 */
@Service
public class DbValidator implements IReqValidator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean validate(Credence credence) {
        List<UserModel> users = userRepository.findAllByUserName(credence.getCredenceName());
        // List<User> users = userMapper.selectList(new EntityWrapper<User>().eq("userName", credence.getCredenceName()));
        if (users != null && users.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
