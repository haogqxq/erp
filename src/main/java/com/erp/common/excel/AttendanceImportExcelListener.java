package com.erp.common.excel;

import com.alibaba.fastjson.JSON;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.erp.dao.AttendanceImportExcelDAO;
import com.erp.dto.AttendanceImportExcel;
import com.erp.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/3
 * @description：Excel模板的读取类
 */
@Slf4j
@Component
public class AttendanceImportExcelListener extends AnalysisEventListener<AttendanceImportExcel> {
    /**
     * 每隔20条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 20;
    List<AttendanceImportExcel> list = new ArrayList<AttendanceImportExcel>();
    private AttendanceService attendanceService;
    public AttendanceImportExcelListener() {
    }

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param attendanceService
     */
    public AttendanceImportExcelListener(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(AttendanceImportExcel data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", list.size());
        attendanceService.importMonthData(list);
        log.info("存储数据库成功！");
    }
}
