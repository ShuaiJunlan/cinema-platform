package cn.shuaijunlan.platformgateway.modular.vo;

import lombok.Data;

/**
 * @author shuaijunlan
 */
@Data
public class ResponseVO<M> {
    // 返回状态【0-成功，1-业务失败，999-表示系统异常】
    private int code;
    // 返回信息
    private String msg;
    // 返回数据实体;
    private M data;


    private ResponseVO() {
    }


    public static <M> ResponseVO success(M m) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(0);
        responseVO.setData(m);

        return responseVO;
    }

    public static <M> ResponseVO success(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(0);
        responseVO.setMsg(msg);

        return responseVO;
    }

    public static <M> ResponseVO serviceFail(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(1);
        responseVO.setMsg(msg);

        return responseVO;
    }

    public static <M> ResponseVO appFail(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(999);
        responseVO.setMsg(msg);

        return responseVO;
    }

}
