package com.gwtjs.icustom.common.excel.demo;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.gwtjs.icustom.common.excel.FlagInfoExcelUtils;
import com.gwtjs.icustom.common.excel.UploadDataResultDto;

/**
 * 导入测试
 * @author aGuang
 *
 */
public class ImportTest {

	@Test
	public void importDataByFile() {
		try {
			UploadDataResultDto<UserDemo> importDataByFile = FlagInfoExcelUtils
					.getInstance().importDataByFile(
							new File("D:/Workspaces/test-project/excel/src/test/java/com/gwtjs/common/excel/demo/user.xlsx"), UserDemo.class, 0,
							1, 0);
			List<UserDemo> datas = importDataByFile.getDatas();
			for (UserDemo u : datas) {
				System.out.println(JSON.toJSONString(u));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
