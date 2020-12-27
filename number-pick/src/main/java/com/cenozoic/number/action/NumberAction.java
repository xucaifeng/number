package com.cenozoic.number.action;

import com.cenozoic.number.annotation.PassToken;
import com.cenozoic.number.dto.Resp;
import com.cenozoic.number.entity.Number;
import com.cenozoic.number.entity.User;
import com.cenozoic.number.service.INumberService;
import com.cenozoic.number.util.ExcelUtils;
import com.cenozoic.number.util.IDCardUtil;
import com.cenozoic.number.util.ParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-21
 **/
@Slf4j
@RestController
@RequestMapping("number")
public class NumberAction {

    @Autowired
    private INumberService numberService;

    /**
     * 选号分组信息
     * @param request
     * @return
     */
    @RequestMapping("numberInfo")
    public Resp numberInfo(HttpServletRequest request) {
        log.info("numberInfo_reqParam={}", ParamUtil.getInputParam(request));
        User user = (User) request.getSession().getAttribute("user");

        Resp resp = numberService.getRemainNumByCenterId(user.getCenterId());
        log.info("numberInfo_response={}", resp);
        return resp;
    }


    /**
     * 选号
     * @param request
     * @return
     */
    @RequestMapping("pickNumber")
    public Resp pickNumber(HttpServletRequest request) {
        log.info("pickNumber_reqParam={}", ParamUtil.getInputParam(request));
        String centerId = request.getParameter("centerId");
        String caseName = request.getParameter("caseName");
        String caseIdCard = request.getParameter("caseIdCard");
        String brinellId = request.getParameter("brinellId");

        if (ParamUtil.isEmpty(centerId) || ParamUtil.isEmpty(caseName) || ParamUtil.isEmpty(caseIdCard) || ParamUtil.isEmpty(brinellId)) {
           return Resp.paramError();
        }

        if (!IDCardUtil.isIDCard(caseIdCard)) {
            return Resp.fail("身份证号错误");
        }

        Resp resp = numberService.pickNumber(centerId, brinellId, caseName, caseIdCard);
        log.info("pickNumber_response={}", resp);
        return resp;
    }


    /**
     * 导出excel
     * @param request
     * @param response
     */
    @PassToken
    @RequestMapping("exportToExcel")
    public void exportToExcel(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Number> numberList = numberService.selectAll();
            ExcelUtils.writeExcel(response, "取号分组结果.xlsx", numberList, Number.class);

        } catch (Exception e) {
            log.info("导出查询结果出错：" + e.getMessage());
        }

    }


}
